package org.tracsystems.apps.brokerage.setups.vo;

import java.util.Date;

public class G7MembersVO {

	public Long getGmemCode() {
		return gmemCode;
	}
	
	private Long gmemCode;
	private String gmemOtherNames;
	private String gmemSurname;
	private String fullName;
	private String gmemTel;
	private String gmemEmail;
	private Date gmemRegisterDate;
	private String gmemActive;
	private String gmemActiveDecoded;
	
	
	
	public G7MembersVO(Long gmemCode, String gmemOtherNames, String gmemSurname, String fullName, String gmemTel,
			String gmemEmail, Date gmemRegisterDate, String gmemActive, String gmemActiveDecoded) {
		super();
		this.gmemCode = gmemCode;
		this.gmemOtherNames = gmemOtherNames;
		this.gmemSurname = gmemSurname;
		this.fullName = fullName;
		this.gmemTel = gmemTel;
		this.gmemEmail = gmemEmail;
		this.gmemRegisterDate = gmemRegisterDate;
		this.gmemActive = gmemActive;
		this.gmemActiveDecoded = gmemActiveDecoded;
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
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGmemActiveDecoded() {
		return gmemActiveDecoded;
	}

	public void setGmemActiveDecoded(String gmemActiveDecoded) {
		this.gmemActiveDecoded = gmemActiveDecoded;
	}
}
