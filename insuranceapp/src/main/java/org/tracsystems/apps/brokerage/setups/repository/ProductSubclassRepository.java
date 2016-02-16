package org.tracsystems.apps.brokerage.setups.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tracsystems.apps.brokerage.setups.model.ProductSubClass;
import org.tracsystems.apps.brokerage.setups.model.SubClass;

public interface ProductSubclassRepository extends CrudRepository<ProductSubClass, Long> {

	@Query("select p.clpCode,p.clpMandatory,p.clpWef,p.clpWet,s.sclShtDesc,s.sclDesc from ProductSubClass p join p.subClass s where p.product.proCode=?")
	public List<Object> findProductSubclasses(Long proCode);
	
	@Query("select s from SubClass s where NOT EXISTS (select p from s.productSubClasses p where p.product.proCode=?)")
	public List<SubClass> findSubclassesForProduct(Long proCode);
	
}
