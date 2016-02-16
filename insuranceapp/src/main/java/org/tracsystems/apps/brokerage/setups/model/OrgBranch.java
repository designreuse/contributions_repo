package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the org_branches database table.
 * 
 */
@Entity
@Table(name="org_branches")
@NamedQuery(name="OrgBranch.findAll", query="SELECT o FROM OrgBranch o")
public class OrgBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ob_id")
	private Long obId;

	@Column(name="ob_name")
	private String obName;

	@Column(name="ob_sht_desc")
	private String obShtDesc;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="ob_org_code")
	private Organization organization;

	public OrgBranch() {
	}

	public Long getObId() {
		return this.obId;
	}

	public void setObId(Long obId) {
		this.obId = obId;
	}

	public String getObName() {
		return this.obName;
	}

	public void setObName(String obName) {
		this.obName = obName;
	}

	public String getObShtDesc() {
		return this.obShtDesc;
	}

	public void setObShtDesc(String obShtDesc) {
		this.obShtDesc = obShtDesc;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}