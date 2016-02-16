package org.tracsystems.apps.brokerage.setups.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tracsystems.apps.brokerage.setups.model.Currencies;
import org.tracsystems.apps.brokerage.setups.model.OrgBranch;
import org.tracsystems.apps.brokerage.setups.model.Organization;
import org.tracsystems.apps.brokerage.setups.repository.CountryRepository;
import org.tracsystems.apps.brokerage.setups.repository.CountyRepository;
import org.tracsystems.apps.brokerage.setups.repository.CurrencyRepository;
import org.tracsystems.apps.brokerage.setups.repository.OrgBankRepository;
import org.tracsystems.apps.brokerage.setups.repository.OrgBranchRepository;
import org.tracsystems.apps.brokerage.setups.repository.OrganizationRepository;
import org.tracsystems.apps.brokerage.setups.repository.TownRepository;
import org.tracsystems.apps.brokerage.setups.service.OrganizationService;
import org.tracsystems.apps.brokerage.setups.vo.BankVO;
import org.tracsystems.apps.brokerage.setups.vo.CountryVO;
import org.tracsystems.apps.brokerage.setups.vo.CountyVO;
import org.tracsystems.apps.brokerage.setups.vo.CurrencyVO;
import org.tracsystems.apps.brokerage.setups.vo.OrgBranchVO;
import org.tracsystems.apps.brokerage.setups.vo.TownVO;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	

	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private CountyRepository countyRepo;
	
	@Autowired
	private TownRepository townRepo;
	
	@Autowired
	private CurrencyRepository currencyRepo;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private OrgBranchRepository orgBranchRepo;
	
	@Autowired
	private OrgBankRepository bankRepo;
	
	
	@Cacheable(value="countryCache")
	public Page<CountryVO> findByCountry(int current,int length,String search){
		Pageable pageable = new PageRequest(current, length);
		return countryRepo.searchByCountry("%"+search+"%",pageable);
	}
	
	@Cacheable(value="countyCache")
	public Page<CountyVO> findCountiesByCountry(int current,int length,String search,Long couCode){
		Pageable pageable = new PageRequest(current, length);
		return countyRepo.searchByCounty("%"+search+"%",couCode,pageable);
	}

	@Cacheable(value="townCache")
	@Override
	public Page<TownVO> searchTownsByCounty(int current, int length, String search, Long countyId) {
		Pageable pageable = new PageRequest(current, length);
		return townRepo.searchTownsByCounty("%"+search+"%",countyId,pageable);
	}

	@Cacheable(value="currencyCache")
	@Override
	public Page<CurrencyVO> findSystemCurrencies(int current, int length, String currencyName) {
		Pageable pageable = new PageRequest(current, length);
		return currencyRepo.searchCurrencies("%"+currencyName+"%", pageable);
	}

	@Cacheable(value="organizationCache")
	@Override
	public Organization getOrganizationDetails() {
		List<Organization> orgDetails = orgRepo.findAll();
		System.out.println("getting organization details..");
		if(!orgDetails.isEmpty())
			return orgDetails.get(0);
		else
		return new Organization();
	}

	@CacheEvict(value="organizationCache")
	@Override
	public void createOrganization(Organization org) {
		 orgRepo.save(org);
		
	}

	@Override
	public Page<OrgBranchVO> getOrganizationBranches(int current, int length, Long orgId, String obName) {
		Pageable pageable = new PageRequest(current, length);
		return orgBranchRepo.findOrganizationBranches(orgId,"%"+obName+"%", pageable);
	}

	@Override
	public Page<BankVO> getOrganizationBanks(int current, int length, Long orgId, String bankName) {
		Pageable pageable = new PageRequest(current, length);
		return bankRepo.findOrganizationBanks(orgId,"%"+bankName+"%", pageable);
	}

	@Override
	public void deleteOrgBranch(Long BranchCode) {
		 orgBranchRepo.delete(BranchCode);
		
	}

	@Override
	public void deleteOrgBanks(Long bankCode) {
		bankRepo.delete(bankCode);
		
	}

	@Override
	public OrgBranch getOrgBranch(Long id) {
		return orgBranchRepo.findOne(id);
	}
	
	
	

	

	

	
}
