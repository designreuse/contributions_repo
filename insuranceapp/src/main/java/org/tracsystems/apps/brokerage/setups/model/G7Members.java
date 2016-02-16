package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the g7_members database table.
 * 
 */
@Entity
@Table(name="g7_members")
@NamedQuery(name="G7Members.findAll", query="SELECT m FROM G7Members m")
public class G7Members implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gmem_code")
	private Long gmemCode;

	@Column(name="gmem_other_names")
	private String gmemOtherNames;

	@Column(name="gmem_surname")
	private String gmemSurname;
	
	@Column(name="gmem_tel")
	private String gmemTel;
	
	@Column(name="gmem_email")
	private String gmemEmail;
	
	@Temporal(TemporalType.DATE)
	@Column(name="gmem_register_date")
	private Date gmemRegisterDate;
	
	@Column(name="gmem_active")
	private String gmemActive;
	
	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="g7Member")
	private List<G7MemberDebits> g7MemberDebit;
	

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="g7Member")
	private List<G7MemberCredits> g7MemberCredit;
	
	public G7Members() {
	}
	

	public Long getGmemCode() {
		return gmemCode;
	}

	public void setGmemCode(Long gmemCode) {
		this.gmemCode = gmemCode;
	}

	public String getGmemOtherNames() {
		return gmemOtherNames;
	}

	public void setGmemOtherNames(String gmemOtherNames) {
		this.gmemOtherNames = gmemOtherNames;
	}

	public String getGmemSurname() {
		return gmemSurname;
	}

	public void setGmemSurname(String gmemSurname) {
		this.gmemSurname = gmemSurname;
	}

	public String getGmemTel() {
		return gmemTel;
	}

	public void setGmemTel(String gmemTel) {
		this.gmemTel = gmemTel;
	}

	public String getGmemEmail() {
		return gmemEmail;
	}

	public void setGmemEmail(String gmemEmail) {
		this.gmemEmail = gmemEmail;
	}

	public Date getGmemRegisterDate() {
		return gmemRegisterDate;
	}

	public void setGmemRegisterDate(Date gmemRegisterDate) {
		this.gmemRegisterDate = gmemRegisterDate;
	}

	public String getGmemActive() {
		return gmemActive;
	}

	public void setGmemActive(String gmemActive) {
		this.gmemActive = gmemActive;
	}
	
	public List<G7MemberDebits> getG7MemberDebit() {
		return g7MemberDebit;
	}

	public void setG7MemberDebit(List<G7MemberDebits> g7MemberDebit) {
		this.g7MemberDebit = g7MemberDebit;
	}
	
	public G7MemberDebits addG7MemberDebits(G7MemberDebits g7MemberDebit) {
		getG7MemberDebit().add(g7MemberDebit);
		g7MemberDebit.setG7Member(this);

		return g7MemberDebit;
	}

	public G7MemberDebits removeG7MemberDebits(G7MemberDebits g7MemberDebit) {
		getG7MemberDebit().remove(g7MemberDebit);
		g7MemberDebit.setG7Member(null);

		return g7MemberDebit;
	}
	
	public List<G7MemberCredits> getG7MemberCredit() {
		return g7MemberCredit;
	}

	public void setG7MemberCredit(List<G7MemberCredits> g7MemberCredit) {
		this.g7MemberCredit = g7MemberCredit;
	}
	
	public G7MemberCredits addG7MemberCredits(G7MemberCredits g7MemberCredit) {
		getG7MemberCredit().add(g7MemberCredit);
		g7MemberCredit.setG7Member(this);

		return g7MemberCredit;
	}

	public G7MemberCredits removeG7MemberCredits(G7MemberCredits g7MemberCredit) {
		getG7MemberCredit().remove(g7MemberDebit);
		g7MemberCredit.setG7Member(null);

		return g7MemberCredit;
	}



}
