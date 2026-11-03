package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class mc_invdealreportid implements Serializable{

	 private String dealId;
	    private Date reportDate;
		public String getDealId() {
			return dealId;
		}
		public void setDealId(String dealId) {
			this.dealId = dealId;
		}
		public Date getReportDate() {
			return reportDate;
		}
		public void setReportDate(Date reportDate) {
			this.reportDate = reportDate;
		}
	    
}
