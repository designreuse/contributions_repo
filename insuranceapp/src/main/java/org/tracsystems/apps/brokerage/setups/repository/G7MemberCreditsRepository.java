package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.G7MemberCredits;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberCreditsVO;

import java.util.List;
public interface G7MemberCreditsRepository extends JpaRepository<G7MemberCredits, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7MemberCreditsVO(b.gmcCode,b.gmcReceiptNo,b.gmcReceiptDate,b.gmcReceiptType,b.gmcReceiptNarrative,b.gmcAmount,b.gmcAllocatedAmt) from G7MemberCredits b where b.g7Member.gmemCode =:memId")
	Page<G7MemberCreditsVO> findMemberSpecificCredits(@Param("memId") Long memId,Pageable pageable);

	
	List<G7MemberCredits> findByG7Member(G7Members g7member);
}
