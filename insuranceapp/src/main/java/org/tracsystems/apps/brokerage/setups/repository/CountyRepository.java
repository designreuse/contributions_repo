package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.County;
import org.tracsystems.apps.brokerage.setups.vo.CountyVO;

public interface CountyRepository extends JpaRepository<County, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.CountyVO(c.countyId,c.countyCode,c.countyName) from County c where c.country.couCode=:couCode and c.countyName like :countyName")
	   public Page<CountyVO> searchByCounty(@Param("countyName") String couName,@Param("couCode") Long countryCode,Pageable pageable);
		

}
