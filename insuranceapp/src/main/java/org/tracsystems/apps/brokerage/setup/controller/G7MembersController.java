package org.tracsystems.apps.brokerage.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tracsystems.apps.brokerage.setups.model.G7MemberCredits;
import org.tracsystems.apps.brokerage.setups.model.G7MemberDebits;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.service.G7MemberService;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberCreditsVO;
import org.tracsystems.apps.brokerage.setups.vo.G7MemberDebitsVO;
import org.tracsystems.apps.brokerage.utils.DataTableObject;


@Controller
@RequestMapping(value = "/protected/g7Members")
public class G7MembersController {
	
	 @Autowired
	 private G7MemberService g7MemberService;
	 
	 private void initScreenModel(ModelAndView model){
    	model.addObject("g7Member", new G7Members());
    	model.addObject("g7MemberDebit", new G7MemberDebits());
		model.addObject("g7MemberCredit", new G7MemberCredits());
	 }
	
	 @RequestMapping(method = RequestMethod.GET)
     public ModelAndView welcome() {		
		 ModelAndView model = new ModelAndView();
		 model.addObject("g7Mems", g7MemberService.findAllG7Members());
		 initScreenModel(model);
		 model.setViewName("g7Members");
	     return model;
	 }
	 
	 
	 @RequestMapping(value = "/getSpecMemDebits/{memId}", produces = "application/json")
	 public @ResponseBody DataTableObject<G7MemberDebitsVO> getSpecificMemberDebits(@PathVariable Long memId,@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){	
		Integer pageNumber = 0;
        pageNumber = ((iDisplayStart)/10)+1;	
    	Page<G7MemberDebitsVO> memDebits = g7MemberService.findMemberSpecificDebits(pageNumber-1, iDisplayLength, memId);
    	Long totalRecords = memDebits.getTotalElements();
    	DataTableObject<G7MemberDebitsVO> memDebitsObject = new DataTableObject<G7MemberDebitsVO>(totalRecords,totalRecords,memDebits.getContent());
    	return memDebitsObject;
	 }
	 
	 @RequestMapping(value = "/getSpecMemCredits/{memId}", produces = "application/json")
	 public @ResponseBody DataTableObject<G7MemberCreditsVO> getSpecificMemberCredits(@PathVariable Long memId,@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho,
            @RequestParam String sSearch){	
		Integer pageNumber = 0;
        pageNumber = ((iDisplayStart)/10)+1;	
    	Page<G7MemberCreditsVO> memCredits = g7MemberService.findMemberSpecificCredits(pageNumber-1, iDisplayLength, memId);
    	Long totalRecords = memCredits.getTotalElements();
    	DataTableObject<G7MemberCreditsVO> memCreditsObject = new DataTableObject<G7MemberCreditsVO>(totalRecords,totalRecords,memCredits.getContent());
    	return memCreditsObject;
	 }

}
