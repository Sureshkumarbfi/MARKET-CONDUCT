package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class RT_Treasury_master_tb_id_class implements Serializable {
	
	private String	acct_no;
	private String	currency;
	private Date	report_date;
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	
}
