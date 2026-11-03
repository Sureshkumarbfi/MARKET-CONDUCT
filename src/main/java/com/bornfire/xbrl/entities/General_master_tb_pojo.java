package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

public class General_master_tb_pojo {

	private String acct_crncy_code;
	private String gl_sub_head_code;
	private String schm_type;
	private String schm_code;
	private String cust_id;
	private String acct_number;
	private String acct_name;
	private Date report_date;
	private BigDecimal acct_balance_amt_ac;
	private String acid;
	private String sol_id;
	private Date acct_opn_date;
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}
	public String getSchm_type() {
		return schm_type;
	}
	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}
	public String getSchm_code() {
		return schm_code;
	}
	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAcct_number() {
		return acct_number;
	}
	public void setAcct_number(String acct_number) {
		this.acct_number = acct_number;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getAcct_balance_amt_ac() {
		return acct_balance_amt_ac;
	}
	public void setAcct_balance_amt_ac(BigDecimal acct_balance_amt_ac) {
		this.acct_balance_amt_ac = acct_balance_amt_ac;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public Date getAcct_opn_date() {
		return acct_opn_date;
	}
	public void setAcct_opn_date(Date acct_opn_date) {
		this.acct_opn_date = acct_opn_date;
	}
	@Override
	public String toString() {
		return "General_master_tb_pojo [acct_crncy_code=" + acct_crncy_code + ", gl_sub_head_code=" + gl_sub_head_code
				+ ", schm_type=" + schm_type + ", schm_code=" + schm_code + ", cust_id=" + cust_id + ", acct_number="
				+ acct_number + ", acct_name=" + acct_name + ", report_date=" + report_date + ", acct_balance_amt_ac="
				+ acct_balance_amt_ac + ", acid=" + acid + ", sol_id=" + sol_id + ", acct_opn_date=" + acct_opn_date
				+ "]";
	}
	public General_master_tb_pojo(String acct_crncy_code, String gl_sub_head_code, String schm_type, String schm_code,
			String cust_id, String acct_number, String acct_name, Date report_date, BigDecimal acct_balance_amt_ac,
			String acid, String sol_id, Date acct_opn_date) {
		super();
		this.acct_crncy_code = acct_crncy_code;
		this.gl_sub_head_code = gl_sub_head_code;
		this.schm_type = schm_type;
		this.schm_code = schm_code;
		this.cust_id = cust_id;
		this.acct_number = acct_number;
		this.acct_name = acct_name;
		this.report_date = report_date;
		this.acct_balance_amt_ac = acct_balance_amt_ac;
		this.acid = acid;
		this.sol_id = sol_id;
		this.acct_opn_date = acct_opn_date;
	}
	public General_master_tb_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
