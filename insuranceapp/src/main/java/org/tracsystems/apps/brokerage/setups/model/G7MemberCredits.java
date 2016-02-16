package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the g7_member_credits database table.
 * 
 */
@Entity
@Table(name="g7_member_credits")
@NamedQuery(name="G7MemberCredits.findAll", query="SELECT c FROM G7MemberCredits c")
public class G7MemberCredits implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gmc_code")
	private Long gmcCode;
	
	@Column(name="gmc_receipt_no")
	private String gmcReceiptNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gmc_receipt_date")
	private Date gmcReceiptDate;
	
	@Column(name="gmc_receipt_type")
	private String gmcReceiptType;
	
	@Column(name="gmc_receipt_narrative")
	private String gmcReceiptNarrative;
	
	@Column(name="gmc_amount")
	private BigDecimal gmcAmount;
	
	@Column(name="gmc_allocated_amt")
	private BigDecimal gmcAllocatedAmt;
	
	//bi-directional many-to-one association to G7Members Table
	@ManyToOne
	@JoinColumn(name="gmc_gmem_code")
	private G7Members g7Member;
	
	public G7MemberCredits() {
		
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

	public G7Members getG7Member() {
		return g7Member;
	}

	public void setG7Member(G7Members g7Member) {
		this.g7Member = g7Member;
	}


}
