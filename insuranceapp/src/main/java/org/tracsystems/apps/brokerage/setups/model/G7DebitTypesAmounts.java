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
 * The persistent class for the g7_debit_type_amounts database table.
 * 
 */
@Entity
@Table(name="g7_debit_type_amounts")
@NamedQuery(name="G7DebitTypesAmounts.findAll", query="SELECT t FROM G7DebitTypesAmounts t")
public class G7DebitTypesAmounts implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gdta_code")
	private Long gdtaCode;
	
	//bi-directional many-to-one association to G7Members Table
	@ManyToOne
	@JoinColumn(name="gdta_gdt_code")
	private G7DebitTypes g7DebitType;
	
	@Column(name="gdta_amount")
	private BigDecimal gdtaAmount;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gdta_wef")
	private Date gdtaWef;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gdta_wet")
	private Date gdtaWet;

	public Long getGdtaCode() {
		return gdtaCode;
	}

	public void setGdtaCode(Long gdtaCode) {
		this.gdtaCode = gdtaCode;
	}

	public G7DebitTypes getG7DebitType() {
		return g7DebitType;
	}

	public void setG7DebitType(G7DebitTypes g7DebitType) {
		this.g7DebitType = g7DebitType;
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
