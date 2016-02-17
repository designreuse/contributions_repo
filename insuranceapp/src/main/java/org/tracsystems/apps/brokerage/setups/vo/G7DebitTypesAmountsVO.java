package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class G7DebitTypesAmountsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long gdtaCode;
	private BigDecimal gdtaAmount;
	private Date gdtaWef;
	private Date gdtaWet;
	
	public G7DebitTypesAmountsVO(Long gdtaCode, BigDecimal gdtaAmount, Date gdtaWef, Date gdtaWet) {
		super();
		this.gdtaCode = gdtaCode;
		this.gdtaAmount = gdtaAmount;
		this.gdtaWef = gdtaWef;
		this.gdtaWet = gdtaWet;
	}
	
	public Long getGdtaCode() {
		return gdtaCode;
	}
	public void setGdtaCode(Long gdtaCode) {
		this.gdtaCode = gdtaCode;
	}
	public BigDecimal getGdtaAmount() {
		return gdtaAmount;
	}
	public void setGdtaAmount(BigDecimal gdtaAmount) {
		this.gdtaAmount = gdtaAmount;
	}
	public Date getGdtaWef() {
		return gdtaWef;
	}
	public void setGdtaWef(Date gdtaWef) {
		this.gdtaWef = gdtaWef;
	}
	public Date getGdtaWet() {
		return gdtaWet;
	}
	public void setGdtaWet(Date gdtaWet) {
		this.gdtaWet = gdtaWet;
	}

}
