package org.tracsystems.apps.brokerage.setups.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.tracsystems.apps.brokerage.setups.model.Currencies;
import org.tracsystems.apps.brokerage.setups.model.OrgBranch;
import org.tracsystems.apps.brokerage.setups.model.Organization;
import org.tracsystems.apps.brokerage.setups.vo.BankVO;
import org.tracsystems.apps.brokerage.setups.vo.CountryVO;
import org.tracsystems.apps.brokerage.setups.vo.CountyVO;
import org.tracsystems.apps.brokerage.setups.vo.CurrencyVO;
import org.tracsystems.apps.brokerage.setups.vo.OrgBranchVO;
import org.tracsystems.apps.brokerage.setups.vo.TownVO;


public interface OrganizationService {
	
	public Page<CountryVO> findByCountry(int current,int length,String search);
	
	public Page<CountyVO> findCountiesByCountry(int current,int length,String search,Long couCode);
	
	public Page<TownVO> searchTownsByCounty(int current,int length,String search,Long countyId);
	
	public Page<CurrencyVO> findSystemCurrencies(int current,int length,String currencyName);
	
	public Organization getOrganizationDetails();
	
	public void createOrganization(Organization org);
	
	public Page<OrgBranchVO> getOrganizationBranches(int current, int length,Long orgId,String obName);
	
	public Page<BankVO> getOrganizationBanks(int current, int length,Long orgId,String bankName);
	
	public void deleteOrgBranch(Long BranchCode);
	
	public void deleteOrgBanks(Long bankCode);
	
	public OrgBranch getOrgBranch(Long id);
}
