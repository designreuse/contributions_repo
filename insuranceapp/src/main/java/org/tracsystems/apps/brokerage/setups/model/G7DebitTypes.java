package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the g7_debit_types database table.
 * 
 */
@Entity
@Table(name="g7_debit_types")
@NamedQuery(name="G7DebitTypes.findAll", query="SELECT t FROM G7DebitTypes t")
public class G7DebitTypes  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gdt_code")
	private Long gdtCode;
	
	@Column(name="gdt_sht_desc")
	private String gdtShtDesc;
	
	@Column(name="gdt_desc")
	private String gdtDesc;
	
	//bi-directional many-to-one association to G7Members Table
	@OneToOne
	@JoinColumn(name="gmd_gdt_code")
	private G7MemberDebits g7MemberDebit;
	
	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="g7DebitType")
	private List<G7DebitTypesAmounts> g7DebitTypesAmount;

	@Column(name="gdt_mandatory")
	private String gdtMandatory;

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


	public G7MemberDebits getG7MemberDebit() {
		return g7MemberDebit;
	}


	public void setG7MemberDebit(G7MemberDebits g7MemberDebit) {
		this.g7MemberDebit = g7MemberDebit;
	}
	
	public List<G7DebitTypesAmounts> getG7DebitTypesAmount() {
		return g7DebitTypesAmount;
	}


	public void setG7DebitTypesAmount(List<G7DebitTypesAmounts> g7DebitTypesAmount) {
		this.g7DebitTypesAmount = g7DebitTypesAmount;
	}
	
	public String getGdtMandatory() {
		return gdtMandatory;
	}


	public void setGdtMandatory(String gdtMandatory) {
		this.gdtMandatory = gdtMandatory;
	}
	


}
