package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.tracsystems.apps.brokerage.setups.model.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

}
