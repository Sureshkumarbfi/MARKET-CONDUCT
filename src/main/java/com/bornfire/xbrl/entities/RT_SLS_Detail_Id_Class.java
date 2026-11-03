package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class RT_SLS_Detail_Id_Class implements Serializable {

	 private String foracid;
	 private Date reportDate;
	 
	 public String getForacid() {
		 return foracid;
	 }
	 public void setForacid(String foracid) {
		 this.foracid = foracid;
	 }
	 public Date getReportDate() {
		 return reportDate;
	 }
	 public void setReportDate(Date reportDate) {
		 this.reportDate = reportDate;
	 }
	 
	 
	 
	
}
