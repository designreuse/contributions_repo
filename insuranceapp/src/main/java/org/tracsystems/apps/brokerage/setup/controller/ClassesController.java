package org.tracsystems.apps.brokerage.setup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tracsystems.apps.brokerage.setups.model.Classes;
import org.tracsystems.apps.brokerage.setups.model.SubClass;
import org.tracsystems.apps.brokerage.setups.service.SubClassService;
import org.tracsystems.apps.brokerage.utils.JsonResponse;


	

@Controller
@RequestMapping(value = "/protected/classes")
public class ClassesController {

	@Autowired
	private SubClassService service;
	
	public void initModel(ModelAndView model){
		model.addObject("classCommand", new Classes());
		model.addObject("subclassCommand", new SubClass());
		model.addObject("classes", service.getAllClasses());
		model.setViewName("classes");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		initModel(model);
		return model;
	}

	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public ModelAndView createClass(@ModelAttribute("classCommand") @Valid Classes classCommand, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.addObject("subclassCommand", new SubClass());
			model.addObject("classes", service.getAllClasses());
			model.setViewName("classes");
			return model;
		}
		service.createClass(classCommand);
		model.addObject("message", "Class Created/Updated Successfully");
		initModel(model);
		return model;
	}

	@RequestMapping(value = "/editClass/{code}", method = RequestMethod.GET)
	public ModelAndView findClassByCode(@PathVariable Long code) {
		ModelAndView model = new ModelAndView();
		model.addObject("classCommand", service.findByClassCode(code));
		SubClass subclass = new SubClass();
		subclass.setClaCode(code);
		model.addObject("subclassCommand", subclass);
		model.setViewName("classform");
		return model;
	}

	@RequestMapping(value = "/subclasses/{code}", method = RequestMethod.GET)
	public ModelAndView findClassSubclasses(@PathVariable Long code) {
		ModelAndView model = new ModelAndView();
		model.addObject("subclasses", service.findClassSubclasses(code));
		SubClass subclass = new SubClass();
		subclass.setClaCode(code);
		model.addObject("subclassCommand", subclass);
		model.setViewName("classsubclasses");
		return model;
	}

	@RequestMapping(value = "/deleteSubclass/{subCode}", method = RequestMethod.GET)
	public ModelAndView deleteSubClass(@PathVariable Long subCode) {
		ModelAndView model = new ModelAndView();
		Long classCode = service.finSubclassByCode(subCode).getClassname().getClaCode();
		service.deleteSubclass(subCode);
		model.addObject("subclasses", service.findClassSubclasses(classCode));
		model.setViewName("classsubclasses");
		return model;

	}

	@RequestMapping(value = "/newSubclass/{claCode}", method = RequestMethod.GET)
	public ModelAndView newSubclass(@PathVariable Long claCode) {
		ModelAndView model = new ModelAndView();
		SubClass subclass = new SubClass();
		subclass.setClaCode(claCode);
		model.addObject("subclassCommand", subclass);
		model.setViewName("subclassForm");
		return model;
	}

	@RequestMapping(value = "/editSubclass/{sclCode}", method = RequestMethod.GET)
	public ModelAndView editSubclass(@PathVariable Long sclCode) {
		ModelAndView model = new ModelAndView();
		SubClass subclass = service.finSubclassByCode(sclCode);
		subclass.setClaCode(subclass.getClassname().getClaCode());
		model.addObject("subclassCommand", subclass);
		model.setViewName("subclassForm");
		return model;
	}

	@RequestMapping(value="/createSubclass",method=RequestMethod.POST)
	public @ResponseBody JsonResponse createSubclass(@ModelAttribute("subclassCommand") SubClass subclassCommand,BindingResult result){
		JsonResponse response = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "sclShtDesc", "Enter subclass Id");
		ValidationUtils.rejectIfEmpty(result, "sclDesc", "Enter Subclass Desc");
		ValidationUtils.rejectIfEmpty(result, "sclWef", "Enter Wef Date");
		if(!result.hasErrors()){
			subclassCommand.setClassname(service.findByClassCode(subclassCommand.getClaCode()));
			service.createSubclass(subclassCommand);
		  
		}
		else{
			response.setStatus("Error");
			response.setResult(result.getAllErrors());
		}
		
		return response;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


}
