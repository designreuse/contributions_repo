package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.Currencies;
import org.tracsystems.apps.brokerage.setups.vo.CurrencyVO;

public interface CurrencyRepository extends JpaRepository<Currencies, Long>  {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.CurrencyVO(c.curCode,c.curIsoCode,c.curName) from Currencies c where  c.curName like :curName")
	public Page<CurrencyVO> searchCurrencies(@Param("curName") String curname,Pageable pageable);

}
