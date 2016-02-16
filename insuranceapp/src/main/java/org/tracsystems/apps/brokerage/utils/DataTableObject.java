package org.tracsystems.apps.brokerage.utils;

import java.io.Serializable;
import java.util.List;

import org.tracsystems.apps.brokerage.setups.model.Country;

public class DataTableObject<T> implements Serializable {
	
	
	
	    /**
	 * 
	 */
	   private static final long serialVersionUID = 1L;

		Long iTotalRecords;
	 
	    Long iTotalDisplayRecords;
	 
	    String sEcho;
	 
	    String sColumns;
	 
	    List<T> aaData;
	    
	    

		public DataTableObject(Long iTotalRecords, Long iTotalDisplayRecords, List<T> aaData) {
			this.iTotalRecords = iTotalRecords;
			this.iTotalDisplayRecords = iTotalDisplayRecords;
			this.aaData = aaData;
		}

		public Long getiTotalRecords() {
			return iTotalRecords;
		}

		public void setiTotalRecords(Long iTotalRecords) {
			this.iTotalRecords = iTotalRecords;
		}

		public Long getiTotalDisplayRecords() {
			return iTotalDisplayRecords;
		}

		public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}

		public String getsEcho() {
			return sEcho;
		}

		public void setsEcho(String sEcho) {
			this.sEcho = sEcho;
		}

		public String getsColumns() {
			return sColumns;
		}

		public void setsColumns(String sColumns) {
			this.sColumns = sColumns;
		}

		public List<T> getAaData() {
			return aaData;
		}

		public void setAaData(List<T> aaData) {
			this.aaData = aaData;
		}
	    
	    

}
