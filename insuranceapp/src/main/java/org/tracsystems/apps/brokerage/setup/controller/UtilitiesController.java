package org.tracsystems.apps.brokerage.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tracsystems.apps.brokerage.setups.model.Currencies;
import org.tracsystems.apps.brokerage.setups.model.OrgBranch;
import org.tracsystems.apps.brokerage.setups.service.OrganizationService;
import org.tracsystems.apps.brokerage.setups.vo.BankVO;
import org.tracsystems.apps.brokerage.setups.vo.CountryVO;
import org.tracsystems.apps.brokerage.setups.vo.CountyVO;
import org.tracsystems.apps.brokerage.setups.vo.CurrencyVO;
import org.tracsystems.apps.brokerage.setups.vo.OrgBranchVO;
import org.tracsystems.apps.brokerage.setups.vo.TownVO;
import org.tracsystems.apps.brokerage.utils.DataTableObject;



@Controller
@RequestMapping(value = "/protected/utilities")
public class UtilitiesController {
	
	@Autowired
	private OrganizationService orgService;
	
	@RequestMapping(value = "/getCountries", produces = "application/json")
	public @ResponseBody DataTableObject<CountryVO> getCountries(@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){
		Integer pageNumber = 0;
    		pageNumber = ((iDisplayStart)/10)+1;	
    	Page<CountryVO> countries = orgService.findByCountry(pageNumber-1, iDisplayLength, sSearch);
    	Long totalRecords = countries.getTotalElements();
    	DataTableObject<CountryVO> countryObject = new DataTableObject<CountryVO>(totalRecords,totalRecords,countries.getContent());
    	return countryObject;
    	
	}
	
	@RequestMapping(value = "/getCounties/{couCode}", produces = "application/json")
	public @ResponseBody DataTableObject<CountyVO> getCountryCounties(@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch,
            @PathVariable Long couCode){
		Integer pageNumber = 0;
    		pageNumber = ((iDisplayStart)/10)+1;	
    	Page<CountyVO> countries = orgService.findCountiesByCountry(pageNumber-1, iDisplayLength, sSearch,couCode);
    	Long totalRecords = countries.getTotalElements();
    	DataTableObject<CountyVO> countryObject = new DataTableObject<CountyVO>(totalRecords,totalRecords,countries.getContent());
    	return countryObject;
    	
	}
	
	@RequestMapping(value = "/getTowns/{countyId}", produces = "application/json")
	public @ResponseBody DataTableObject<TownVO> getCountyTowns(@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch,
            @PathVariable Long countyId){
		Integer pageNumber = 0;
    		pageNumber = ((iDisplayStart)/10)+1;	
    	Page<TownVO> countries = orgService.searchTownsByCounty(pageNumber-1, iDisplayLength, sSearch,countyId);
    	Long totalRecords = countries.getTotalElements();
    	DataTableObject<TownVO> countryObject = new DataTableObject<TownVO>(totalRecords,totalRecords,countries.getContent());
    	return countryObject;
	}
	
	@RequestMapping(value = "/getCurrencies", produces = "application/json")
	public @ResponseBody DataTableObject<CurrencyVO> getCurrencies(@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){
		Integer pageNumber = 0;
    		pageNumber = ((iDisplayStart)/10)+1;	
    	Page<CurrencyVO> currencies = orgService.findSystemCurrencies(pageNumber-1, iDisplayLength, sSearch);
    	Long totalRecords = currencies.getTotalElements();
    	DataTableObject<CurrencyVO> countryObject = new DataTableObject<CurrencyVO>(totalRecords,totalRecords,currencies.getContent());
    	return countryObject;
	}
	
	
	@RequestMapping(value = "/getOrgBranches/{orgId}", produces = "application/json")
	public @ResponseBody DataTableObject<OrgBranchVO> getOrganizationBranches(@PathVariable Long orgId,@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){
		
		Integer pageNumber = 0;
    		pageNumber = ((iDisplayStart)/10)+1;	
    	Page<OrgBranchVO> currencies = orgService.getOrganizationBranches(pageNumber-1, iDisplayLength,orgId, sSearch);
    	Long totalRecords = currencies.getTotalElements();
    	DataTableObject<OrgBranchVO> countryObject = new DataTableObject<OrgBranchVO>(totalRecords,totalRecords,currencies.getContent());
    	return countryObject;
	}
	
	
	@RequestMapping(value = "/getOrgBanks/{orgId}", produces = "application/json")
	public @ResponseBody DataTableObject<BankVO> getOrganizationBanks(@PathVariable Long orgId,@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){	
		Integer pageNumber = 0;
        pageNumber = ((iDisplayStart)/10)+1;	
    	Page<BankVO> currencies = orgService.getOrganizationBanks(pageNumber-1, iDisplayLength,orgId, sSearch);
    	Long totalRecords = currencies.getTotalElements();
    	DataTableObject<BankVO> countryObject = new DataTableObject<BankVO>(totalRecords,totalRecords,currencies.getContent());
    	return countryObject;
	}
	
	

}
