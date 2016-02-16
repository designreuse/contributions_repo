package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;

public class CountryVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long couCode;

	
	private String couName;

	private String couShtDesc;
	
	

	public CountryVO(Long couCode, String couName, String couShtDesc) {
		this.couCode = couCode;
		this.couName = couName;
		this.couShtDesc = couShtDesc;
	}

	public Long getCouCode() {
		return couCode;
	}

	public void setCouCode(Long couCode) {
		this.couCode = couCode;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouShtDesc() {
		return couShtDesc;
	}

	public void setCouShtDesc(String couShtDesc) {
		this.couShtDesc = couShtDesc;
	}
	
	

}
