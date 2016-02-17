package org.tracsystems.apps.brokerage.setups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tracsystems.apps.brokerage.setups.model.G7DebitTypes;
import org.tracsystems.apps.brokerage.setups.model.G7MemberCredits;
import org.tracsystems.apps.brokerage.setups.model.G7MemberDebits;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.repository.G7DebitTypesAmountsRepository;
import org.tracsystems.apps.brokerage.setups.repository.G7DebitTypesRepository;
import org.tracsystems.apps.brokerage.setups.repository.G7MemberCreditsRepository;
import org.tracsystems.apps.brokerage.setups.repository.G7MemberDebitsRepository;
import org.tracsystems.apps.brokerage.setups.repository.G7MembersRepository;
import org.tracsystems.apps.brokerage.setups.service.G7MemberService;
import org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesAmountsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberCreditsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MembersVO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class G7MemberServiceImpl implements G7MemberService {
	
	@Autowired
	private G7MembersRepository g7MembersRepo; 
	@Autowired
	private G7MemberDebitsRepository g7MemberDebitsRepo;
	@Autowired
	private G7MemberCreditsRepository g7MemberCreditsRepo; 
	@Autowired
	private G7DebitTypesRepository g7DebitTypesRepo; 
	@Autowired
	private G7DebitTypesAmountsRepository g7DebitTypesAmountsRepo; 
	
	
	
	
	public List<G7Members> findAllG7Members(){
		  return g7MembersRepo.findAll();
	  }
	
	@Override
	public G7MembersVO findG7MemberDetails(Long memId) {
		return g7MembersRepo.findG7MemberDetails(memId);
	}

	@Override
	public List<G7MemberDebits> findDebitsForG7Member(G7Members g7Member) {
		return g7MemberDebitsRepo.findByG7Member(g7Member);
	}

	@Override
	public List<G7MemberCredits> findCreditsForG7Member(G7Members g7Member) {
		return g7MemberCreditsRepo.findByG7Member(g7Member);
	}
	
	@Override
	public Page<G7MemberDebitsVO> findMemberSpecificDebits(int current, int length, Long memId) {
		Pageable pageable = new PageRequest(current, length);
		return g7MemberDebitsRepo.findMemberSpecificDebits(memId, pageable);
	}
	
	@Override
	public Page<G7MemberCreditsVO> findMemberSpecificCredits(int current, int length, Long memId) {
		Pageable pageable = new PageRequest(current, length);
		return g7MemberCreditsRepo.findMemberSpecificCredits(memId, pageable);
	}

	@Override
	public void createG7MemberDebit(G7MemberDebits g7MemberDebit) {
		g7MemberDebitsRepo.save(g7MemberDebit);
		
	}

	@Override
	public void createG7MemberCredit(G7MemberCredits g7MemberCredit) {
		g7MemberCreditsRepo.save(g7MemberCredit);
		
	}


	@Override
	public void deleteG7MemberDebit(Long gmdCode) {
		g7MemberDebitsRepo.delete(gmdCode);
		
	}

	@Override
	public void deleteG7MemberCredit(Long gmcCode) {
		g7MemberCreditsRepo.delete(gmcCode);
		
	}

	@Override
	public G7MemberDebits findDebitById(Long gmdCode) {
		return g7MemberDebitsRepo.findOne(gmdCode);
	}

	@Override
	public G7MemberCredits findCreditById(Long gmcCode) {
		return g7MemberCreditsRepo.findOne(gmcCode);
	}
	
	@Override
	public void GenerateMemberDebits(Long memId){
		Integer DebitSeq = 1;
		String DebitPref = "DEBIT-";
		String FinalDebitNo;
		
	try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse("2015-01-15");
			String FormattedCurrDate = formatter.format(new Date());
			Date endDate = formatter.parse(FormattedCurrDate);
	
			
			//Create Member Object.
			G7Members CurrMember = new G7Members();
			CurrMember.setGmemCode(memId);
			
			//First Get the Mandatory Debits Types
			List<G7DebitTypesVO> g7DebitTypes = g7DebitTypesRepo.findMandatoryDebitTypes();
			
			//Loop through each Debits Type Item and get the Current Amount.
			for(G7DebitTypesVO dt: g7DebitTypes){
				
				//Delete any existing Mandatory debits for Member
				List<G7MemberDebitsVO> existingDebits = g7MemberDebitsRepo.findMemberSpecificDebitsList(memId, dt.getGdtCode());
				for(G7MemberDebitsVO ed: existingDebits){
					deleteG7MemberDebit(ed.getGmdCode());
				}
				
				Calendar start = Calendar.getInstance();
				start.setTime(startDate);
				Calendar end = Calendar.getInstance();
				end.setTime(endDate);
				
				for (Date date = start.getTime(); start.before(end); start.add(Calendar.MONTH, 1), date = start.getTime()) {
					
					List<G7DebitTypesAmountsVO> g7DebitTypesAmt = g7DebitTypesAmountsRepo.findCurrentDebitTypeAmount(dt.getGdtCode(), date);
		
					//Loop through the Current Amount and create a Debit Record.
					for(G7DebitTypesAmountsVO dta: g7DebitTypesAmt){
						
						FinalDebitNo = DebitPref.concat(String.valueOf(DebitSeq));
						
						G7MemberDebits NewMemberDebit = new G7MemberDebits();
						NewMemberDebit.setG7Member(CurrMember);
						NewMemberDebit.setGmdGdtCode(dt.getGdtCode());
						NewMemberDebit.setGmdAmount(dta.getGdtaAmount());
						NewMemberDebit.setGmdDebitNo(FinalDebitNo);
						NewMemberDebit.setGmdGeneratedDate(new Date());
						NewMemberDebit.setGmdIntAcrAmt(new BigDecimal("0"));
						NewMemberDebit.setGmdSettled("N");
						NewMemberDebit.setGmdDueDate(date);
						
						//NewMemberDebit.setG7DebitType(g7DebitType);
						createG7MemberDebit(NewMemberDebit);
						
						DebitSeq++;
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
