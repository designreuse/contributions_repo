package org.tracsystems.apps.brokerage.setups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
	
	public void GenerateMemberDebits(Long memId){
		//First Get the Mandatory Debits Types
		List<G7DebitTypesVO> g7DebitTypes = g7DebitTypesRepo.findMandatoryDebitTypes();
		
		//Loop through each Debits Type Item and get the Current Amount.
		for(G7DebitTypesVO dt: g7DebitTypes){
			List<G7DebitTypesAmountsVO> g7DebitTypesAmt = g7DebitTypesAmountsRepo.findCurrentDebitTypeAmount(dt.getGdtCode(), new Date());

			//Loop through the Current Amount and create a Debit Record.
			for(G7DebitTypesAmountsVO dta: g7DebitTypesAmt){
				G7MemberDebits NewMemberDebit = new G7MemberDebits();
				//NewMemberDebit.setG7DebitType(g7DebitType);
				createG7MemberDebit(NewMemberDebit);
				
			}
		}

	}

}
