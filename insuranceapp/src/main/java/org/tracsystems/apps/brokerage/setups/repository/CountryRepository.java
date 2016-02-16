package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.Country;
import org.tracsystems.apps.brokerage.setups.vo.CountryVO;

public interface CountryRepository extends JpaRepository<Country, Long> {
	
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.CountryVO(c.couCode,c.couName,c.couShtDesc) from Country c where c.couName like :couName")
   public Page<CountryVO> searchByCountry(@Param("couName") String couName,Pageable pageable);
	

}
