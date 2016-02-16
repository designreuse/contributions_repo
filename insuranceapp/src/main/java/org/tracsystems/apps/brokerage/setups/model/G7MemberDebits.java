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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the g7_member_debits database table.
 * 
 */
@Entity
@Table(name="g7_member_debits")
@NamedQuery(name="G7MemberDebits.findAll", query="SELECT d FROM G7MemberDebits d")
public class G7MemberDebits implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gmd_code")
	private Long gmdCode;

	//bi-directional many-to-one association to G7Members Table
	@ManyToOne
	@JoinColumn(name="gmd_gmem_code")
	private G7Members g7Member;

	@Column(name="gmd_debit_no")
	private String gmdDebitNo;
	
	//bi-directional many-to-one association to g7_debit_types Table
	@OneToOne(mappedBy="g7MemberDebit")
	private G7DebitTypes g7DebitType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gmd_generated_date")
	private Date gmdGeneratedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gmd_due_date")
	private Date gmdDueDate;
	
	@Column(name="gmd_amount")
	private BigDecimal gmdAmount;
	
	@Column(name="gmd_settled")
	private String gmdSettled;
	
	@Column(name="gmd_int_acr_amt")
	private BigDecimal gmdIntAcrAmt;
	
	public G7MemberDebits() {
	}

	public Long getGmdCode() {
		return gmdCode;
	}

	public void setGmdCode(Long gmdCode) {
		this.gmdCode = gmdCode;
	}


	public G7Members getG7Member() {
		return g7Member;
	}

	public void setG7Member(G7Members g7Member) {
		this.g7Member = g7Member;
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
	
	public G7DebitTypes getG7DebitType() {
		return g7DebitType;
	}

	public void setG7DebitType(G7DebitTypes g7DebitType) {
		this.g7DebitType = g7DebitType;
	}
	

}
