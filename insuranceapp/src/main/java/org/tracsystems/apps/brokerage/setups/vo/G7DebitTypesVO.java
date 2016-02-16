package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;

public class G7DebitTypesVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long gdtCode;
	private String gdtShtDesc;
	private String gdtDesc;
	private String gdtMandatory;
	
	public G7DebitTypesVO(Long gdtCode, String gdtShtDesc, String gdtDesc, String gdtMandatory) {
		super();
		this.gdtCode = gdtCode;
		this.gdtShtDesc = gdtShtDesc;
		this.gdtDesc = gdtDesc;
		this.gdtMandatory = gdtMandatory;
	}
	
	public Long getGdtCode() {
		return gdtCode;
	}
	public void setGdtCode(Long gdtCode) {
		this.gdtCode = gdtCode;
	}
	public String getGdtShtDesc() {
		return gdtShtDesc;
	}
	public void setGdtShtDesc(String gdtShtDesc) {
		this.gdtShtDesc = gdtShtDesc;
	}
	public String getGdtDesc() {
		return gdtDesc;
	}
	public void setGdtDesc(String gdtDesc) {
		this.gdtDesc = gdtDesc;
	}
	public String getGdtMandatory() {
		return gdtMandatory;
	}
	public void setGdtMandatory(String gdtMandatory) {
		this.gdtMandatory = gdtMandatory;
	}

}
