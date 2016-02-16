package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_sub_classes database table.
 * 
 */
@Entity
@Table(name="product_sub_classes")
@NamedQuery(name="ProductSubClass.findAll", query="SELECT p FROM ProductSubClass p")
public class ProductSubClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLP_CODE")
	private Long clpCode;

	@Column(name="CLP_MANDATORY")
	private String clpMandatory;

	@Column(name="CLP_PRO_SHT_DESC")
	private String clpProShtDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="CLP_WEF")
	private Date clpWef;

	@Temporal(TemporalType.DATE)
	@Column(name="CLP_WET")
	private Date clpWet;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="CLP_PRO_CODE")
	private Product product;

	//bi-directional many-to-one association to SubClass
	@ManyToOne
	@JoinColumn(name="CLP_SCL_CODE")
	private SubClass subClass;
	
	@Transient
	private String subclassName;
	
	@Transient
	private Long proCode;
	
	@Transient
	private Long sclCode;
	


	public ProductSubClass() {
	}

	public Long getClpCode() {
		return this.clpCode;
	}

	public void setClpCode(Long clpCode) {
		this.clpCode = clpCode;
	}

	public String getClpMandatory() {
		return this.clpMandatory;
	}

	public void setClpMandatory(String clpMandatory) {
		this.clpMandatory = clpMandatory;
	}

	public String getClpProShtDesc() {
		return this.clpProShtDesc;
	}

	public void setClpProShtDesc(String clpProShtDesc) {
		this.clpProShtDesc = clpProShtDesc;
	}

	public Date getClpWef() {
		return this.clpWef;
	}

	public void setClpWef(Date clpWef) {
		this.clpWef = clpWef;
	}

	public Date getClpWet() {
		return this.clpWet;
	}

	public void setClpWet(Date clpWet) {
		this.clpWet = clpWet;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SubClass getSubClass() {
		return this.subClass;
	}

	public void setSubClass(SubClass subClass) {
		this.subClass = subClass;
	}

	public String getSubclassName() {
		return subclassName;
	}

	public void setSubclassName(String subclassName) {
		this.subclassName = subclassName;
	}

	public Long getProCode() {
		return proCode;
	}

	public void setProCode(Long proCode) {
		this.proCode = proCode;
	}

	public Long getSclCode() {
		return sclCode;
	}

	public void setSclCode(Long sclCode) {
		this.sclCode = sclCode;
	}

	
	
	

}