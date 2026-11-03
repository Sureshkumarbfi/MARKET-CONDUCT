package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

public class RT_Bank_bill_data_pojo {
	
	private Date report_date;
	private String sol_;
	private String cust_id;
	private String foracid;
	private String sub_head_gl_code;
	private String bill_id;
	private Date bill_date;
	private Date due_date;
	private String bil;
	private BigDecimal bill_os_amt;
	private BigDecimal bill_os_amt_aed;
	private String drawee_bank_code;
	private String bank_name;
	private String trimmed_name;
	private String rw;
	private BigDecimal bill_disc_rwa;
	public String getSol_() {
		return sol_;
	}
	public void setSol_(String sol_) {
		this.sol_ = sol_;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getSub_head_gl_code() {
		return sub_head_gl_code;
	}
	public void setSub_head_gl_code(String sub_head_gl_code) {
		this.sub_head_gl_code = sub_head_gl_code;
	}
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getBil() {
		return bil;
	}
	public void setBil(String bil) {
		this.bil = bil;
	}
	public BigDecimal getBill_os_amt() {
		return bill_os_amt;
	}
	public void setBill_os_amt(BigDecimal bill_os_amt) {
		this.bill_os_amt = bill_os_amt;
	}
	public BigDecimal getBill_os_amt_aed() {
		return bill_os_amt_aed;
	}
	public void setBill_os_amt_aed(BigDecimal bill_os_amt_aed) {
		this.bill_os_amt_aed = bill_os_amt_aed;
	}
	public String getDrawee_bank_code() {
		return drawee_bank_code;
	}
	public void setDrawee_bank_code(String drawee_bank_code) {
		this.drawee_bank_code = drawee_bank_code;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getTrimmed_name() {
		return trimmed_name;
	}
	public void setTrimmed_name(String trimmed_name) {
		this.trimmed_name = trimmed_name;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	public BigDecimal getBill_disc_rwa() {
		return bill_disc_rwa;
	}
	public void setBill_disc_rwa(BigDecimal bill_disc_rwa) {
		this.bill_disc_rwa = bill_disc_rwa;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	@Override
	public String toString() {
		return "RT_Bank_bill_data_pojo [report_date=" + report_date + ", sol_=" + sol_ + ", cust_id=" + cust_id
				+ ", foracid=" + foracid + ", sub_head_gl_code=" + sub_head_gl_code + ", bill_id=" + bill_id
				+ ", bill_date=" + bill_date + ", due_date=" + due_date + ", bil=" + bil + ", bill_os_amt="
				+ bill_os_amt + ", bill_os_amt_aed=" + bill_os_amt_aed + ", drawee_bank_code=" + drawee_bank_code
				+ ", bank_name=" + bank_name + ", trimmed_name=" + trimmed_name + ", rw=" + rw + ", bill_disc_rwa="
				+ bill_disc_rwa + "]";
	}
	public RT_Bank_bill_data_pojo(Date report_date, String sol_, String cust_id, String foracid,
			String sub_head_gl_code, String bill_id, Date bill_date, Date due_date, String bil, BigDecimal bill_os_amt,
			BigDecimal bill_os_amt_aed, String drawee_bank_code, String bank_name, String trimmed_name, String rw,
			BigDecimal bill_disc_rwa) {
		super();
		this.report_date = report_date;
		this.sol_ = sol_;
		this.cust_id = cust_id;
		this.foracid = foracid;
		this.sub_head_gl_code = sub_head_gl_code;
		this.bill_id = bill_id;
		this.bill_date = bill_date;
		this.due_date = due_date;
		this.bil = bil;
		this.bill_os_amt = bill_os_amt;
		this.bill_os_amt_aed = bill_os_amt_aed;
		this.drawee_bank_code = drawee_bank_code;
		this.bank_name = bank_name;
		this.trimmed_name = trimmed_name;
		this.rw = rw;
		this.bill_disc_rwa = bill_disc_rwa;
	}
	public RT_Bank_bill_data_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
