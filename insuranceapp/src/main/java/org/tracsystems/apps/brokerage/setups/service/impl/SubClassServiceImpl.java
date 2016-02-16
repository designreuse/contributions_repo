package org.tracsystems.apps.brokerage.setups.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tracsystems.apps.brokerage.setups.model.Classes;
import org.tracsystems.apps.brokerage.setups.model.SubClass;
import org.tracsystems.apps.brokerage.setups.repository.ClassesRepository;
import org.tracsystems.apps.brokerage.setups.repository.SubclassRepository;
import org.tracsystems.apps.brokerage.setups.service.SubClassService;


@Service
public class SubClassServiceImpl implements SubClassService {
	
	@Autowired
	private ClassesRepository classesRepo;
	
	@Autowired
	private SubclassRepository subclassRepo;
	
	
	public List<Classes>  getAllClasses(){
		return classesRepo.findAll();
	}
	
	
	@Transactional(readOnly=false)
	public void createClass(Classes classObject){
		classesRepo.save(classObject);
	}
	
	@Transactional(readOnly=false)
	public void delete(Long classId){
		classesRepo.delete(classId);
	}
	
	
	public Classes findByClassCode(Long code){
		return  classesRepo.findOne(code);
	}
	
	public List<SubClass> findClassSubclasses(Long claCode){
		return subclassRepo.findClassSubclasses(claCode);
	}
	
	@Transactional(readOnly=false)
	public void createSubclass(SubClass subclass) throws DataAccessException {
		 subclassRepo.save(subclass);
	}
	
	@Transactional(readOnly=false)
	public void deleteSubclass(Long subclassId){
		 subclassRepo.delete(subclassId);
	}
	
	public SubClass finSubclassByCode(Long subclassCode){
		return subclassRepo.findOne(subclassCode);
	}
	

}
