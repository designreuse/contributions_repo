package org.tracsystems.apps.brokerage.setup.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tracsystems.apps.brokerage.fileuploads.utils.FileUploadValidator;
import org.tracsystems.apps.brokerage.setups.model.OrgBranch;
import org.tracsystems.apps.brokerage.setups.model.Organization;
import org.tracsystems.apps.brokerage.setups.service.OrganizationService;
import org.tracsystems.apps.brokerage.setups.vo.CurrencyVO;
import org.tracsystems.apps.brokerage.utils.DataTableObject;
import org.tracsystems.apps.brokerage.utils.JsonResponse;



/**
 * Controller for organizing and managing organization screen
 * This depends on OrganizationService as the main dependency.
 * Product Manager to advise on validation of the screen
 * @author Peter
 *
 */

@Controller
@RequestMapping(value = "/protected/organization")
public class OrganizationController {
	
	
	 private static final String SYSTEM_IMAGES = "images";
	 private static final String TEMP_FOLDER_PATH = System.getProperty("java.io.tmpdir");
	 private static final String IMAGES_SYSTEM_PATH = TEMP_FOLDER_PATH + File.separator + SYSTEM_IMAGES; 
	 private static final File  IMAGES_SYSTEM_DIR = new File(IMAGES_SYSTEM_PATH);
	 private static final String IMAGES_SYSTEM_DIR_ABSOLUTE_PATH = IMAGES_SYSTEM_DIR.getAbsolutePath() + File.separator;
	

	@Autowired
	private OrganizationService orgService;
	
	 @Autowired
	 FileUploadValidator fileValidator;
	 
	 @InitBinder("organization")
	    protected void initBinder(WebDataBinder binder) {
	       binder.setValidator(fileValidator);
	    }
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String organizationHome(Model model){
		return "orgdefinition";
	}
	
	
	@ModelAttribute
	public Organization setOrganizationForm(){
		Organization organization = orgService.getOrganizationDetails();
		organization.setFormAction("E");
		return organization;
	}
	
	@RequestMapping(value="/editOrganization",method=RequestMethod.GET)
	public String createOrganization(Model model) throws IOException{
		Organization organization = orgService.getOrganizationDetails();
		organization.setFormAction("A");
		model.addAttribute("organization",organization);
		return  organizationHome(model);
	}
	
	@RequestMapping(value="/createOrganization",method=RequestMethod.POST)
	public String createOrganization(Organization organization,Model model) throws IOException{
		if(!organization.getFile().isEmpty())
		organization.setOrgLogo(organization.getFile().getBytes());
		orgService.createOrganization(organization);
		return  organizationHome(model);
	}
	
	
	
	/**
	 * This gets the system logo from the database and saves in the temporary folder of the system
	 * 
	 * @return
	 * @throws IOException
	 */
	 @RequestMapping(value = "/logo")
	    @ResponseBody
	    public byte[] getImage() throws IOException {
		 Organization organization = orgService.getOrganizationDetails();
		    File temporaryLogo = new File(IMAGES_SYSTEM_DIR_ABSOLUTE_PATH+ "logo.jpg");
		    if(temporaryLogo.exists()) temporaryLogo.delete();
		   FileUtils.writeByteArrayToFile(temporaryLogo, organization.getOrgLogo());
	       return Files.readAllBytes(temporaryLogo.toPath());
	    }
	
	 @RequestMapping("/deleteOrgBranch/{branchId}")
	 public @ResponseBody String deleteOrgBranch(@PathVariable Long branchId){
		 //error handling code goes here
		  orgService.deleteOrgBranch(branchId);		
		   return "success";
	 }
	 
	 @RequestMapping("/deleteOrgBank/{bankCode}")
	 public @ResponseBody String deleteOrgBank(@PathVariable Long bankCode){
		 //error handling code goes here
		  orgService.deleteOrgBanks(bankCode);
		   return "success";
	 }
	
	 @RequestMapping(value="/getBranchDetails/{branchId}")
	 public @ResponseBody OrgBranch getBranchDetails(@PathVariable Long branchId){		 
		 OrgBranch branch = orgService.getOrgBranch(branchId);
		 System.out.println(branch);
		 return branch;
		 
	 }
	
	
	
	
	

}
