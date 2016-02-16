package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;

public class BankVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bankCode;

	private String bankName;

	private String bankShtDesc;
	
	

	public BankVO(Long bankCode, String bankName, String bankShtDesc) {
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankShtDesc = bankShtDesc;
	}

	public Long getBankCode() {
		return bankCode;
	}

	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankShtDesc() {
		return bankShtDesc;
	}

	public void setBankShtDesc(String bankShtDesc) {
		this.bankShtDesc = bankShtDesc;
	}
	
	

}
