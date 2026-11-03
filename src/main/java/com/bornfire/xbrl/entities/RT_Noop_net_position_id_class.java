package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class RT_Noop_net_position_id_class implements Serializable {

	private Date	report_date;
	private String	currency;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
