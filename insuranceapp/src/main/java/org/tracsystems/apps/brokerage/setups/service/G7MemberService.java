package org.tracsystems.apps.brokerage.setups.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.tracsystems.apps.brokerage.setups.model.G7MemberCredits;
import org.tracsystems.apps.brokerage.setups.model.G7MemberDebits;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberCreditsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MembersVO;


public interface G7MemberService {
	
	public List<G7Members> findAllG7Members();
	
	public List<G7MemberDebits> findDebitsForG7Member(G7Members g7Member);
	
	public List<G7MemberCredits> findCreditsForG7Member(G7Members g7Member);
	
	public G7MemberDebits findDebitById(Long gmdCode);
	
	public G7MemberCredits findCreditById(Long gmcCode);
	
	public void createG7MemberDebit(G7MemberDebits g7MemberDebit);
	
	public void createG7MemberCredit(G7MemberCredits g7MemberCredit);
	
	public void deleteG7MemberDebit(Long gmdCode);
	
	public void deleteG7MemberCredit(Long gmcCode);

	public Page<G7MemberDebitsVO> findMemberSpecificDebits(int current, int length, Long memId);

	public Page<G7MemberCreditsVO> findMemberSpecificCredits(int current, int length, Long memId);

	public void GenerateMemberDebits(Long memId);

	public G7MembersVO findG7MemberDetails(Long memId);

}
