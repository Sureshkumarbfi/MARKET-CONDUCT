package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class RT_Treasury_swd_id_class implements Serializable{
	
	private String	gl_code;
	private String	curr;
	private Date	report_date;
	private String	security_id;
	
	
	public String getSecurity_id() {
		return security_id;
	}
	public void setSecurity_id(String security_id) {
		this.security_id = security_id;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	
	

}
