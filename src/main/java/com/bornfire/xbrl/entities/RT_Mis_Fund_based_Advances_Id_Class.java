package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class RT_Mis_Fund_based_Advances_Id_Class implements Serializable {
	
	private String	acct_number;
	private Date	report_date;
	public String getAcct_number() {
		return acct_number;
	}
	public void setAcct_number(String acct_number) {
		this.acct_number = acct_number;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	
	

}
