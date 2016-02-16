package org.tracsystems.apps.brokerage.setups.vo;

import java.util.ArrayList;
import java.util.List;

public class ProductSubClassVO {
	
	private List<String> selectedSubclass = new ArrayList<String>();	
	private Long proCode;
	
	
	public List<String> getSelectedSubclass() {
		return selectedSubclass;
	}
	public void setSelectedSubclass(List<String> selectedSubclass) {
		this.selectedSubclass = selectedSubclass;
	}

	public Long getProCode() {
		return proCode;
	}
	public void setProCode(Long proCode) {
		this.proCode = proCode;
	}
	

}
