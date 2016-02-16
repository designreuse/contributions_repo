package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;


public class CountyVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long countyId;

	private String countyCode;

	private String countyName;
	
	

	public CountyVO(Long countyId, String countyCode, String countyName) {
		super();
		this.countyId = countyId;
		this.countyCode = countyCode;
		this.countyName = countyName;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	
	
	

}
