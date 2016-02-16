package org.tracsystems.apps.brokerage.setups.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tracsystems.apps.brokerage.setups.model.Product;
import org.tracsystems.apps.brokerage.setups.model.ProductGroup;
import org.tracsystems.apps.brokerage.setups.model.ProductSubClass;
import org.tracsystems.apps.brokerage.setups.model.SubClass;
import org.tracsystems.apps.brokerage.setups.repository.ProductGroupRepository;
import org.tracsystems.apps.brokerage.setups.repository.ProductSubclassRepository;
import org.tracsystems.apps.brokerage.setups.repository.ProductsRepository;
import org.tracsystems.apps.brokerage.setups.repository.SubclassRepository;
import org.tracsystems.apps.brokerage.setups.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	  private ProductGroupRepository productGroupRepo; 
	  @Autowired
	  private ProductsRepository productRepo;
	  
	  @Autowired
	  private ProductSubclassRepository subclassRepo;
	  
	  @Autowired
	  private SubclassRepository sclRepo;
	  
	  
	  public List<Product> getProducts(ProductGroup group, Integer offset, Integer maxResults){
		  Pageable pageable = new PageRequest(offset, 200);
		  return productRepo.findByProductGroup(group, pageable);
	  }
	  
	  
	  public List<Object> findProductSubclasses(Long proCode){
		  return subclassRepo.findProductSubclasses(proCode);
	  }
	  
	  public List<SubClass> findSubclassesForProduct(Long proCode){
		  return subclassRepo.findSubclassesForProduct(proCode);
	  }
	  
	  
	  public List<ProductGroup> findAllProductGroups(){
		  return productGroupRepo.findAll();
	  }
	  
	  
	  public Long getProductsCount(){
		  return  productRepo.count();
	  }
	  
	  
	  public ProductGroup findProductGroupByCode(Long code){
		  return productGroupRepo.findOne(code);
	  }
	  
	  @Transactional(readOnly= false)
	  public void createProductGroup(ProductGroup group){
		  productGroupRepo.save(group);
	  }
	  
	  
	  @Transactional(readOnly=false)
	  public void createProduct(Product product){
		  productRepo.save(product);
	  }
	  
	  public Product findProductByid(Long prodId){
		  return productRepo.findOne(prodId);
	  }
	  
	  @Transactional(readOnly=false)
	  public void createProductSubclass(List<ProductSubClass> subclasses){
		  subclassRepo.save(subclasses);
	  }
	
	  public SubClass findSubClassById(Long sclId){
		  return sclRepo.findOne(sclId);
	  }
	  
	  public ProductSubClass findProdSubclassById(Long clpCode){
		  return subclassRepo.findOne(clpCode);
	  }
	  
	  
	  @Transactional(readOnly=false)
	  public void deleteProdSubclass(Long clpCode){
		  subclassRepo.delete(clpCode);
	  }
	  
	  @Transactional(readOnly=false)
	  public void updateProdSubclass(ProductSubClass subclass){
		  subclassRepo.save(subclass);
	  }

}
