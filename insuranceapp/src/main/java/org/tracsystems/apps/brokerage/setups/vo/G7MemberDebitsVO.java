package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class G7MemberDebitsVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long gmdCode;
	private String gmdDebitNo;
	private Date gmdGeneratedDate;
	private Date gmdDueDate;
	private BigDecimal gmdAmount;
	private String gmdSettled;
	private BigDecimal gmdIntAcrAmt;
	
	public G7MemberDebitsVO(Long gmdCode, String gmdDebitNo, Date gmdGeneratedDate, Date gmdDueDate,
			BigDecimal gmdAmount, String gmdSettled, BigDecimal gmdIntAcrAmt) {
		super();
		this.gmdCode = gmdCode;
		this.gmdDebitNo = gmdDebitNo;
		this.gmdGeneratedDate = gmdGeneratedDate;
		this.gmdDueDate = gmdDueDate;
		this.gmdAmount = gmdAmount;
		this.gmdSettled = gmdSettled;
		this.gmdIntAcrAmt = gmdIntAcrAmt;
	}
	
	public Long getGmdCode() {
		return gmdCode;
	}
	public void setGmdCode(Long gmdCode) {
		this.gmdCode = gmdCode;
	}
	
	public String getGmdDebitNo() {
		return gmdDebitNo;
	}
	public void setGmdDebitNo(String gmdDebitNo) {
		this.gmdDebitNo = gmdDebitNo;
	}
	public Date getGmdGeneratedDate() {
		return gmdGeneratedDate;
	}
	public void setGmdGeneratedDate(Date gmdGeneratedDate) {
		this.gmdGeneratedDate = gmdGeneratedDate;
	}
	public Date getGmdDueDate() {
		return gmdDueDate;
	}
	public void setGmdDueDate(Date gmdDueDate) {
		this.gmdDueDate = gmdDueDate;
	}
	public BigDecimal getGmdAmount() {
		return gmdAmount;
	}
	public void setGmdAmount(BigDecimal gmdAmount) {
		this.gmdAmount = gmdAmount;
	}
	public String getGmdSettled() {
		return gmdSettled;
	}
	public void setGmdSettled(String gmdSettled) {
		this.gmdSettled = gmdSettled;
	}
	public BigDecimal getGmdIntAcrAmt() {
		return gmdIntAcrAmt;
	}
	public void setGmdIntAcrAmt(BigDecimal gmdIntAcrAmt) {
		this.gmdIntAcrAmt = gmdIntAcrAmt;
	}
	
}
