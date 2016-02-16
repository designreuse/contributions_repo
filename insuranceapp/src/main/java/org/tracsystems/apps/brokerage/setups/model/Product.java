package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRO_CODE")
	private Long proCode;

	@Column(name="PRO_CLAIM_PREFIX")
	private String proClaimPrefix;

	@Column(name="PRO_DESC")
	private String proDesc;

	@Column(name="PRO_MIN_PREM")
	private BigDecimal proMinPrem;

	@Column(name="PRO_MULT_CLASS")
	private String proMultClass;

	@Column(name="PRO_POLICY_PREFIX")
	private String proPolicyPrefix;

	@Column(name="PRO_RENEWABLE")
	private String proRenewable;

	@Column(name="PRO_SAME_DAY_RENEWAL")
	private String proSameDayRenewal;

	@Column(name="PRO_SHT_DESC")
	private String proShtDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="PRO_WEF")
	private Date proWef;

	@Temporal(TemporalType.DATE)
	@Column(name="PRO_WET")
	private Date proWet;

	//bi-directional many-to-one association to ProductSubClass
	@OneToMany(mappedBy="product")
	private List<ProductSubClass> productSubClasses;

	//bi-directional many-to-one association to ProductGroup
	@ManyToOne
	@JoinColumn(name="PRO_PRG_CODE")
	private ProductGroup productGroup;
	
	@Transient
	private Long prgCode;

	public Product() {
	}

	public Long getProCode() {
		return this.proCode;
	}

	public void setProCode(Long proCode) {
		this.proCode = proCode;
	}

	public String getProClaimPrefix() {
		return this.proClaimPrefix;
	}

	public void setProClaimPrefix(String proClaimPrefix) {
		this.proClaimPrefix = proClaimPrefix;
	}

	public String getProDesc() {
		return this.proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public BigDecimal getProMinPrem() {
		return this.proMinPrem;
	}

	public void setProMinPrem(BigDecimal proMinPrem) {
		this.proMinPrem = proMinPrem;
	}

	public String getProMultClass() {
		return this.proMultClass;
	}

	public void setProMultClass(String proMultClass) {
		this.proMultClass = proMultClass;
	}

	public String getProPolicyPrefix() {
		return this.proPolicyPrefix;
	}

	public void setProPolicyPrefix(String proPolicyPrefix) {
		this.proPolicyPrefix = proPolicyPrefix;
	}

	public String getProRenewable() {
		return this.proRenewable;
	}

	public void setProRenewable(String proRenewable) {
		this.proRenewable = proRenewable;
	}

	public String getProSameDayRenewal() {
		return this.proSameDayRenewal;
	}

	public void setProSameDayRenewal(String proSameDayRenewal) {
		this.proSameDayRenewal = proSameDayRenewal;
	}

	public String getProShtDesc() {
		return this.proShtDesc;
	}

	public void setProShtDesc(String proShtDesc) {
		this.proShtDesc = proShtDesc;
	}

	public Date getProWef() {
		return this.proWef;
	}

	public void setProWef(Date proWef) {
		this.proWef = proWef;
	}

	public Date getProWet() {
		return this.proWet;
	}

	public void setProWet(Date proWet) {
		this.proWet = proWet;
	}

	public List<ProductSubClass> getProductSubClasses() {
		return this.productSubClasses;
	}

	public void setProductSubClasses(List<ProductSubClass> productSubClasses) {
		this.productSubClasses = productSubClasses;
	}

	public ProductSubClass addProductSubClass(ProductSubClass productSubClass) {
		getProductSubClasses().add(productSubClass);
		productSubClass.setProduct(this);

		return productSubClass;
	}

	public ProductSubClass removeProductSubClass(ProductSubClass productSubClass) {
		getProductSubClasses().remove(productSubClass);
		productSubClass.setProduct(null);

		return productSubClass;
	}

	public ProductGroup getProductGroup() {
		return this.productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

	public Long getPrgCode() {
		return prgCode;
	}

	public void setPrgCode(Long prgCode) {
		this.prgCode = prgCode;
	}
	
	
	
	

}