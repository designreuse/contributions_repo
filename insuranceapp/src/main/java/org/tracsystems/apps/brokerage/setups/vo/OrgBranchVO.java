package org.tracsystems.apps.brokerage.setups.vo;

import java.io.Serializable;

public class OrgBranchVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long obId;

	private String obName;

	private String obShtDesc;
	

	
	public OrgBranchVO(Long obId, String obName, String obShtDesc) {
		this.obId = obId;
		this.obName = obName;
		this.obShtDesc = obShtDesc;
	}

	public Long getObId() {
		return obId;
	}

	public void setObId(Long obId) {
		this.obId = obId;
	}

	public String getObName() {
		return obName;
	}

	public void setObName(String obName) {
		this.obName = obName;
	}

	public String getObShtDesc() {
		return obShtDesc;
	}

	public void setObShtDesc(String obShtDesc) {
		this.obShtDesc = obShtDesc;
	}	

}
