package org.tracsystems.apps.brokerage.setups.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.tracsystems.apps.brokerage.setups.model.Classes;
import org.tracsystems.apps.brokerage.setups.model.SubClass;


public interface SubClassService {
	
	
	
	public List<Classes>  getAllClasses();
	
	public void createClass(Classes classObject);
	
	public void delete(Long classId);
	
	
	public Classes findByClassCode(Long code);
	
	public List<SubClass> findClassSubclasses(Long claCode);
	
	public void createSubclass(SubClass subclass) throws DataAccessException;
	
	public void deleteSubclass(Long subclassId);
	
	public SubClass finSubclassByCode(Long subclassCode);
	

}
