package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class InvestmentSecuritiesreportid implements Serializable {

	 private Date dataDate;
	 private String isinCode;
	 public Date getDataDate() {
		 return dataDate;
	 }
	 public void setDataDate(Date dataDate) {
		 this.dataDate = dataDate;
	 }
	 public String getIsinCode() {
		 return isinCode;
	 }
	 public void setIsinCode(String isinCode) {
		 this.isinCode = isinCode;
	 }
	 
}
