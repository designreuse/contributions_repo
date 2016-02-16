package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.Town;
import org.tracsystems.apps.brokerage.setups.vo.TownVO;

public interface TownRepository extends JpaRepository<Town, Integer> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.TownVO(c.ctCode,c.ctName,c.ctPostalCode,c.ctShtDesc) from Town c where c.county.countyId=:countyId and c.ctName like :ctName")
	public Page<TownVO> searchTownsByCounty(@Param("ctName") String townName,@Param("countyId") Long countyId, Pageable pageable);

}
