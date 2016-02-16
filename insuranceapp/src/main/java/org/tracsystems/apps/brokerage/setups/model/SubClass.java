package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sub_classes database table.
 * 
 */
@Entity
@Table(name="sub_classes")
@NamedQuery(name="SubClass.findAll", query="SELECT s FROM SubClass s")
public class SubClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCL_CODE")
	private Long sclCode;

	@Column(name="SCL_CLAIM_PREFIX")
	private String sclClaimPrefix;

	@Column(name="SCL_DESC")
	private String sclDesc;

	@Column(name="SCL_POLICY_PREFIX")
	private String sclPolicyPrefix;

	@Column(name="SCL_SHT_DESC")
	private String sclShtDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="SCL_WEF")
	private Date sclWef;

	@Temporal(TemporalType.DATE)
	@Column(name="SCL_WET")
	private Date sclWet;

	//bi-directional many-to-one association to ProductSubClass
	@OneToMany(mappedBy="subClass")
	private List<ProductSubClass> productSubClasses;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name="SCL_CLA_CODE")
	private Classes classname;
	
	@Transient
	private Long claCode;
	
	

	public SubClass() {
	}

	public Long getSclCode() {
		return this.sclCode;
	}

	public void setSclCode(Long sclCode) {
		this.sclCode = sclCode;
	}

	public String getSclClaimPrefix() {
		return this.sclClaimPrefix;
	}

	public void setSclClaimPrefix(String sclClaimPrefix) {
		this.sclClaimPrefix = sclClaimPrefix;
	}

	public String getSclDesc() {
		return this.sclDesc;
	}

	public void setSclDesc(String sclDesc) {
		this.sclDesc = sclDesc;
	}

	public String getSclPolicyPrefix() {
		return this.sclPolicyPrefix;
	}

	public void setSclPolicyPrefix(String sclPolicyPrefix) {
		this.sclPolicyPrefix = sclPolicyPrefix;
	}

	public String getSclShtDesc() {
		return this.sclShtDesc;
	}

	public void setSclShtDesc(String sclShtDesc) {
		this.sclShtDesc = sclShtDesc;
	}

	public Date getSclWef() {
		return this.sclWef;
	}

	public void setSclWef(Date sclWef) {
		this.sclWef = sclWef;
	}

	public Date getSclWet() {
		return this.sclWet;
	}

	public void setSclWet(Date sclWet) {
		this.sclWet = sclWet;
	}

	public List<ProductSubClass> getProductSubClasses() {
		return this.productSubClasses;
	}

	public void setProductSubClasses(List<ProductSubClass> productSubClasses) {
		this.productSubClasses = productSubClasses;
	}

	public ProductSubClass addProductSubClass(ProductSubClass productSubClass) {
		getProductSubClasses().add(productSubClass);
		productSubClass.setSubClass(this);

		return productSubClass;
	}

	public ProductSubClass removeProductSubClass(ProductSubClass productSubClass) {
		getProductSubClasses().remove(productSubClass);
		productSubClass.setSubClass(null);

		return productSubClass;
	}

	public Classes getClassname() {
		return classname;
	}

	public void setClassname(Classes classname) {
		this.classname = classname;
	}

	public Long getClaCode() {
		return claCode;
	}

	public void setClaCode(Long claCode) {
		this.claCode = claCode;
	}

	

	

}