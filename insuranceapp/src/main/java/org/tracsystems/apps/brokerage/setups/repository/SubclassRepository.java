package org.tracsystems.apps.brokerage.setups.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tracsystems.apps.brokerage.setups.model.SubClass;

public interface SubclassRepository extends CrudRepository<SubClass, Long>{
	
	@Query("select s from SubClass s  where s.classname.claCode=?")
	public List<SubClass> findClassSubclasses(Long claCode);

}
