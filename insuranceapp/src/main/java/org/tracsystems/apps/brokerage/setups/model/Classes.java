package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the classes database table.
 * 
 */
@Entity
@Table(name="classes")
@NamedQuery(name="Class.findAll", query="SELECT c FROM Classes c")
public class Classes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLA_CODE")
	private Long claCode;

	@NotEmpty(message="Enter Class Description")
	@Column(name="CLA_DESCN")
	private String claDescn;

	@NotNull(message="Enter Class WEF")
	@Temporal(TemporalType.DATE)
	@Column(name="CLA_WEF")
	private Date claWef;

	@Temporal(TemporalType.DATE)
	@Column(name="CLA_WET")
	private Date claWet;

	//bi-directional many-to-one association to SubClass
	@OneToMany(mappedBy="classname")
	private List<SubClass> subClasses;

	public Classes() {
	}

	

	public Long getClaCode() {
		return claCode;
	}



	public void setClaCode(Long claCode) {
		this.claCode = claCode;
	}



	public String getClaDescn() {
		return this.claDescn;
	}

	public void setClaDescn(String claDescn) {
		this.claDescn = claDescn;
	}

	public Date getClaWef() {
		return this.claWef;
	}

	public void setClaWef(Date claWef) {
		this.claWef = claWef;
	}

	public Date getClaWet() {
		return this.claWet;
	}

	public void setClaWet(Date claWet) {
		this.claWet = claWet;
	}

	public List<SubClass> getSubClasses() {
		return this.subClasses;
	}

	public void setSubClasses(List<SubClass> subClasses) {
		this.subClasses = subClasses;
	}

	public SubClass addSubClass(SubClass subClass) {
		getSubClasses().add(subClass);
		subClass.setClassname(this);

		return subClass;
	}

	public SubClass removeSubClass(SubClass subClass) {
		getSubClasses().remove(subClass);
		subClass.setClassname(null);

		return subClass;
	}

}