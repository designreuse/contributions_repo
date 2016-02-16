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
 * The persistent class for the g7_settled_transactions database table.
 * 
 */
@Entity
@Table(name="g7_settled_transactions")
@NamedQuery(name="G7SettledTransactions.findAll", query="SELECT s FROM G7SettledTransactions s")
public class G7SettledTransactions implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gst_code")
	private Long gstCode;
	
	//bi-directional many-to-one association to G7MemberDebits Table
	@ManyToOne
	@JoinColumn(name="gst_gmd_code")
	private G7MemberDebits g7MemberDebit;
	
	//bi-directional many-to-one association to G7MemberDebits Table
	@ManyToOne
	@JoinColumn(name="gst_gmc_code")
	private G7MemberCredits g7MemberCredit;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gst_settle_date")
	private Date gstSettleDate;
	
	public Long getGstCode() {
		return gstCode;
	}

	public void setGstCode(Long gstCode) {
		this.gstCode = gstCode;
	}

	public G7MemberDebits getG7MemberDebit() {
		return g7MemberDebit;
	}

	public void setG7MemberDebit(G7MemberDebits g7MemberDebit) {
		this.g7MemberDebit = g7MemberDebit;
	}

	public G7MemberCredits getG7MemberCredit() {
		return g7MemberCredit;
	}

	public void setG7MemberCredit(G7MemberCredits g7MemberCredit) {
		this.g7MemberCredit = g7MemberCredit;
	}

	public Date getGstSettleDate() {
		return gstSettleDate;
	}

	public void setGstSettleDate(Date gstSettleDate) {
		this.gstSettleDate = gstSettleDate;
	}

	public BigDecimal getGstSettleAmt() {
		return gstSettleAmt;
	}

	public void setGstSettleAmt(BigDecimal gstSettleAmt) {
		this.gstSettleAmt = gstSettleAmt;
	}

	@Column(name="gst_settle_amt")
	private BigDecimal gstSettleAmt;

}
