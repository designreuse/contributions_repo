package org.tracsystems.apps.brokerage.setups.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tracsystems.apps.brokerage.setups.model.Product;
import org.tracsystems.apps.brokerage.setups.model.ProductGroup;

public interface ProductsRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByProductGroup(ProductGroup group,Pageable page);

}
