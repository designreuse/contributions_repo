package org.tracsystems.apps.brokerage.setups.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tracsystems.apps.brokerage.setups.model.G7DebitTypes;
import org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesVO;

public interface G7DebitTypesRepository extends JpaRepository<G7DebitTypes, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7DebitTypesVO(b.gdtCode,b.gdtShtDesc,b.gdtDesc,b.gdtMandatory) from G7DebitTypes b where b.gdtMandatory ='Y'")
	List<G7DebitTypesVO> findMandatoryDebitTypes();

	
}
