package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.G7MemberDebits;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO;

import java.util.List;

public interface G7MemberDebitsRepository extends JpaRepository<G7MemberDebits, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO(b.gmdCode,b.gmdDebitNo,b.gmdGeneratedDate,b.gmdDueDate,b.gmdAmount,b.gmdSettled,b.gmdIntAcrAmt) from G7MemberDebits b where b.g7Member.gmemCode =:memId")
	Page<G7MemberDebitsVO> findMemberSpecificDebits(@Param("memId") Long memId,Pageable pageable);
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO(b.gmdCode,b.gmdDebitNo,b.gmdGeneratedDate,b.gmdDueDate,b.gmdAmount,b.gmdSettled,b.gmdIntAcrAmt) from G7MemberDebits b where b.g7Member.gmemCode =:memId and b.gmdGdtCode =:debitCode")
	List<G7MemberDebitsVO> findMemberSpecificDebitsList(@Param("memId") Long memId, @Param("debitCode") Long debitCode);


	List<G7MemberDebits> findByG7Member(G7Members g7member);
}
