package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class mc_mmreportid implements Serializable  {


	private Date report_date;
		  private String deal_no;
		  private String customer_id;
		  public Date getReport_date() {
			  return report_date;
		  }
		  public void setReport_date(Date report_date) {
			  this.report_date = report_date;
		  }
		  public String getDeal_no() {
			  return deal_no;
		  }
		  public void setDeal_no(String deal_no) {
			  this.deal_no = deal_no;
		  }
		  public String getCustomer_id() {
			  return customer_id;
		  }
		  public void setCustomer_id(String customer_id) {
			  this.customer_id = customer_id;
		  }
		 





}
