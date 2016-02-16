package org.tracsystems.apps.brokerage.setup.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tracsystems.apps.brokerage.setups.model.Product;
import org.tracsystems.apps.brokerage.setups.model.ProductGroup;
import org.tracsystems.apps.brokerage.setups.model.ProductSubClass;
import org.tracsystems.apps.brokerage.setups.service.ProductService;
import org.tracsystems.apps.brokerage.setups.vo.ProductSubClassVO;
import org.tracsystems.apps.brokerage.utils.JsonResponse;

@Controller
@RequestMapping(value = "/protected/products")
public class ProductsController {
	
	    @Autowired
	   private ProductService prodService;
	    
	    
	    private void initScreenModel(ModelAndView model){
	    	model.addObject("proSubclass", new ProductSubClass());
	    	model.addObject("productGroup", new ProductGroup());
			 model.addObject("product", new Product());
			 model.addObject("productSubclass",new ProductSubClassVO());
	    }
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ModelAndView welcome() {		
		 ModelAndView model = new ModelAndView();
		 model.addObject("producGroups", prodService.findAllProductGroups());
		 initScreenModel(model);
		 model.setViewName("products");
	     return model;
	   }
	 
	 
   	 @RequestMapping(value="/getProducts/{ProductGroup}",method = RequestMethod.GET)
	    public ModelAndView getProducts(@PathVariable Long ProductGroup,Integer offset, Integer maxResults) {		
		 ModelAndView model = new ModelAndView();
		 model.addObject("producGroups", prodService.findAllProductGroups());
		 if(offset==null){
			  offset=0;
		 }
		 if(maxResults==null){
			 maxResults=10;
		 }
		 ProductGroup group = prodService.findProductGroupByCode(ProductGroup);
		 if(group!=null)
	     model.addObject("products", prodService.getProducts(group, offset, maxResults));
		 initScreenModel(model);
		 model.setViewName("products");
	     return model;
	   }
	 
	 
	    @RequestMapping(value="/createProductGroup",method = RequestMethod.POST)
	    public ModelAndView  createProductGroup(@ModelAttribute("productGroup") ProductGroup group) {
	    	Long groupId = group.getPrgCode();
	    	prodService.createProductGroup(group);
		   return new ModelAndView("redirect:/protected/products/getProducts/"+groupId);
	    }
	    
	    
	    @RequestMapping(value="/createProduct",method = RequestMethod.POST)
	    public ModelAndView  createProduct(@ModelAttribute("product") Product product) {  
	    	ProductGroup group = prodService.findProductGroupByCode(product.getPrgCode());
	    	if(group!=null){
	    		product.setProductGroup(group);
	    	}
	    	prodService.createProduct(product);
	    	ModelAndView model = new ModelAndView();
	    	model.addObject("prgCode", product.getPrgCode());
	    	model.setViewName("productsList");
		   return model;
	    }
	    
	    @RequestMapping(value="/editProduct/{prodId}",method = RequestMethod.GET)
	    public ModelAndView  editProduct(@PathVariable Long prodId) {  
	    	
	    	Product product = prodService.findProductByid(prodId);
	    	product.setPrgCode(product.getProductGroup().getPrgCode());
	    	ModelAndView model = new ModelAndView();
	    	model.addObject("product", product);
			 model.setViewName("productsForm");    	
		     return model;
	    }
	    
	    
	    @RequestMapping(value="/getProductSubclasses/{proCode}",method = RequestMethod.GET)
	    public ModelAndView  getProSubclasses(@PathVariable Long proCode) { 
	        ModelAndView model = new ModelAndView();
	        model.addObject("subclasses", prodService.findProductSubclasses(proCode));
	        model.addObject("productSubclass",new ProductSubClassVO());
	    	model.setViewName("subclassList");
		   return model;
	    }
	    
	    
	    @RequestMapping(value="/getSubclassesForProduct/{proCode}",method = RequestMethod.GET)
	    public ModelAndView  findSubclassesForProduct(@PathVariable Long proCode) { 
	        ModelAndView model = new ModelAndView();
	        model.addObject("prosubclasses", prodService.findSubclassesForProduct(proCode));
	        model.addObject("productSubclass",new ProductSubClassVO());
	    	model.setViewName("prodsubclasses");
		   return model;
	    }
	    
	    
	    @RequestMapping(value="/deleteProdSubclasses/{clpCode}",method = RequestMethod.GET)
	    public ModelAndView  deleteProSubclasses(@PathVariable Long clpCode) { 
	    	
	    	ProductSubClass subclass = prodService.findProdSubclassById(clpCode);
	        Long proCode = subclass.getProduct().getProCode();
	        prodService.deleteProdSubclass(clpCode);
	        ModelAndView model = new ModelAndView();
	        model.addObject("prosubclasses", prodService.findSubclassesForProduct(proCode));
	        model.addObject("productSubclass",new ProductSubClassVO());
	    	model.setViewName("redirect:/protected/products/getProductSubclasses/"+proCode);
		   return model;
	    }
	    
	    @RequestMapping(value="/createProductSubclass",method = RequestMethod.POST)
	    public ModelAndView createProductSubclass(@ModelAttribute("productSubclass") ProductSubClassVO productSubclass){
	    	Long proCode =  productSubclass.getProCode();
	    	List<ProductSubClass> subclasses = new ArrayList<ProductSubClass>();
	    	for(String sub :productSubclass.getSelectedSubclass()){
	    		 ProductSubClass subclass = new ProductSubClass();
	    		 subclass.setSubClass(prodService.findSubClassById(Long.parseLong(sub)));
	    		 subclass.setProduct(prodService.findProductByid(proCode));
	    		 subclasses.add(subclass);
	    	 }
	    	 prodService.createProductSubclass(subclasses);
	    	 return new ModelAndView("redirect:/protected/products/getProductSubclasses/"+productSubclass.getProCode());
	    }
	    
	    @InitBinder
	    public void initBinder(WebDataBinder webDataBinder) {
	     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	     dateFormat.setLenient(false);
	     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	     }
	    
	    
	    @RequestMapping(value="/updateProductSubclass",method = RequestMethod.POST)
	    public @ResponseBody JsonResponse updateProductSubclass(@ModelAttribute("proSubclass") ProductSubClass proSubclass,BindingResult result){
	    	JsonResponse response = new JsonResponse();
	    	ValidationUtils.rejectIfEmpty(result, "clpMandatory", "Select Whether Mandatory or not");
	    	ValidationUtils.rejectIfEmpty(result, "clpWef", "Enter Wef Date");
	    	if(!result.hasErrors()){
		    	Long proCode =  proSubclass.getProCode();
		    	proSubclass.setProduct(prodService.findProductByid(proCode));
		    	proSubclass.setSubClass( prodService.findSubClassById(proSubclass.getSclCode()));
		    	prodService.updateProdSubclass(proSubclass);
	    	}
	    	else{
	    		response.setStatus("Error");
				response.setResult(result.getAllErrors());
	    	}
	    	return response;
	    }
	    
	    
	    @RequestMapping(value="/editProductSubclass/{clpCode}",method = RequestMethod.GET)
	    public ModelAndView editProductSubclass(@PathVariable Long clpCode){
	    	  ProductSubClass subclass = prodService.findProdSubclassById(clpCode);
	    	  subclass.setSubclassName(subclass.getSubClass().getSclDesc());
	    	  subclass.setProCode(subclass.getProduct().getProCode());
	    	  subclass.setSclCode(subclass.getSubClass().getSclCode());
	    	  ModelAndView model = new ModelAndView();
	    	  model.addObject("proSubclass", subclass);
	    	  model.setViewName("editProdsubclasses");
	    	 return model;
	    }
	    
	    
	 

}
