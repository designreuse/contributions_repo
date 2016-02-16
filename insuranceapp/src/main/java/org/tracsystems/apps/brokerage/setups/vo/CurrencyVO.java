package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;

public class CurrencyVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long curCode;

	private String curIsoCode;

	private String curName;
	
	
	

	public CurrencyVO(Long curCode, String curIsoCode, String curName) {
		this.curCode = curCode;
		this.curIsoCode = curIsoCode;
		this.curName = curName;
	}

	public Long getCurCode() {
		return curCode;
	}

	public void setCurCode(Long curCode) {
		this.curCode = curCode;
	}

	public String getCurIsoCode() {
		return curIsoCode;
	}

	public void setCurIsoCode(String curIsoCode) {
		this.curIsoCode = curIsoCode;
	}

	public String getCurName() {
		return curName;
	}

	public void setCurName(String curName) {
		this.curName = curName;
	}
	
	

}
