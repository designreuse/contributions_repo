package org.tracsystems.apps.brokerage.setups.vo;

import java.math.BigDecimal;
import java.util.Date;

public class G7MemberCreditsVO {
	
	private Long gmcCode;
	private String gmcReceiptNo;
	private Date gmcReceiptDate;
	private String gmcReceiptType;
	private String gmcReceiptNarrative;
	private BigDecimal gmcAmount;
	private BigDecimal gmcAllocatedAmt;
	
	
	
	public G7MemberCreditsVO(Long gmcCode, String gmcReceiptNo, Date gmcReceiptDate, String gmcReceiptType,
			String gmcReceiptNarrative, BigDecimal gmcAmount, BigDecimal gmcAllocatedAmt) {
		super();
		this.gmcCode = gmcCode;
		this.gmcReceiptNo = gmcReceiptNo;
		this.gmcReceiptDate = gmcReceiptDate;
		this.gmcReceiptType = gmcReceiptType;
		this.gmcReceiptNarrative = gmcReceiptNarrative;
		this.gmcAmount = gmcAmount;
		this.gmcAllocatedAmt = gmcAllocatedAmt;
	}
	
	public Long getGmcCode() {
		return gmcCode;
	}
	public void setGmcCode(Long gmcCode) {
		this.gmcCode = gmcCode;
	}
	public String getGmcReceiptNo() {
		return gmcReceiptNo;
	}
	public void setGmcReceiptNo(String gmcReceiptNo) {
		this.gmcReceiptNo = gmcReceiptNo;
	}
	public Date getGmcReceiptDate() {
		return gmcReceiptDate;
	}
	public void setGmcReceiptDate(Date gmcReceiptDate) {
		this.gmcReceiptDate = gmcReceiptDate;
	}
	public String getGmcReceiptType() {
		return gmcReceiptType;
	}
	public void setGmcReceiptType(String gmcReceiptType) {
		this.gmcReceiptType = gmcReceiptType;
	}
	public String getGmcReceiptNarrative() {
		return gmcReceiptNarrative;
	}
	public void setGmcReceiptNarrative(String gmcReceiptNarrative) {
		this.gmcReceiptNarrative = gmcReceiptNarrative;
	}
	public BigDecimal getGmcAmount() {
		return gmcAmount;
	}
	public void setGmcAmount(BigDecimal gmcAmount) {
		this.gmcAmount = gmcAmount;
	}
	public BigDecimal getGmcAllocatedAmt() {
		return gmcAllocatedAmt;
	}
	public void setGmcAllocatedAmt(BigDecimal gmcAllocatedAmt) {
		this.gmcAllocatedAmt = gmcAllocatedAmt;
	}

}
