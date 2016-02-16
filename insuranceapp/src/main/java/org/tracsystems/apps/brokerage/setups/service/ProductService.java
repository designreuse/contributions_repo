package org.tracsystems.apps.brokerage.setups.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.tracsystems.apps.brokerage.setups.model.Product;
import org.tracsystems.apps.brokerage.setups.model.ProductGroup;
import org.tracsystems.apps.brokerage.setups.model.ProductSubClass;
import org.tracsystems.apps.brokerage.setups.model.SubClass;

public interface ProductService {


	  public List<Product> getProducts(ProductGroup group, Integer offset, Integer maxResults);
	  
	  
	  public List<Object> findProductSubclasses(Long proCode);
	  
	  public List<SubClass> findSubclassesForProduct(Long proCode);
	  
	  
	  public List<ProductGroup> findAllProductGroups();
	  
	  
	  public Long getProductsCount();
	  
	  
	  public ProductGroup findProductGroupByCode(Long code);
	  
	  public void createProductGroup(ProductGroup group);
	  
	  
	  public void createProduct(Product product);
	  
	  public Product findProductByid(Long prodId);
	  
	  public void createProductSubclass(List<ProductSubClass> subclasses);
	
	  public SubClass findSubClassById(Long sclId);
	  
	  public ProductSubClass findProdSubclassById(Long clpCode);
	  
	  
	  public void deleteProdSubclass(Long clpCode);
	  
	  
	  public void updateProdSubclass(ProductSubClass subclass);


}
