package org.tracsystems.apps.brokerage.setups.vo;

import javax.persistence.Column;

public class TownVO {
	
	private Long ctCode;

	private String ctName;

	private String ctPostalCode;

	private String ctShtDesc;
	
	
	

	public TownVO(Long ctCode, String ctName, String ctPostalCode, String ctShtDesc) {
		super();
		this.ctCode = ctCode;
		this.ctName = ctName;
		this.ctPostalCode = ctPostalCode;
		this.ctShtDesc = ctShtDesc;
	}

	public Long getCtCode() {
		return ctCode;
	}

	public void setCtCode(Long ctCode) {
		this.ctCode = ctCode;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getCtPostalCode() {
		return ctPostalCode;
	}

	public void setCtPostalCode(String ctPostalCode) {
		this.ctPostalCode = ctPostalCode;
	}

	public String getCtShtDesc() {
		return ctShtDesc;
	}

	public void setCtShtDesc(String ctShtDesc) {
		this.ctShtDesc = ctShtDesc;
	}
	
	

}
