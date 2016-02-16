package org.tracsystems.apps.brokerage.setups.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.G7DebitTypesAmounts;
import org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesAmountsVO;

public interface G7DebitTypesAmountsRepository extends JpaRepository<G7DebitTypesAmounts, Long> {
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesAmountsVO(b.gdtaCode,b.gdtaAmount,b.gdtaWef,b.gdtaWet) from G7DebitTypesAmounts b where b.g7DebitType.gdtCode =:dbtypeId and :currDate between b.gdtaWef and b.gdtaWet")
	List<G7DebitTypesAmountsVO> findCurrentDebitTypeAmount(@Param("dbtypeId") Long dbtypeId, @Param("currDate") Date currDate);

}
