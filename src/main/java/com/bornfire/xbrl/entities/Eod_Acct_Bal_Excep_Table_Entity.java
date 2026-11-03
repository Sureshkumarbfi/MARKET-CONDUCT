package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EOD_ACCT_BAL_EXCEP_TABLE")
@IdClass(Eod_Acct_Bal_Excep_Table_Id.class)
public class Eod_Acct_Bal_Excep_Table_Entity {

	@Column(name = "ACCT_CRNCY_CODE", length = 3)
	private String acct_crncy_code;

	@Column(name = "GL_SUB_HEAD_CODE", length = 5)
	private String gl_sub_head_code;

	@Column(name = "SCHM_TYPE", length = 3)
	private String schm_type;

	@Column(name = "SCHM_CODE", length = 5)
	private String schm_code;

	@Column(name = "CUST_ID", length = 15)
	private String cust_id;

	@Column(name = "ACCT_NUMBER", length = 14)
	private String acct_number;

	@Column(name = "ACCT_NAME", length = 500)
	private String acct_name;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", nullable = false)
	private Date report_date;

	@Column(name = "ACCT_BALANCE_AMT_AC", precision = 24, scale = 2)
	private BigDecimal acct_balance_amt_ac;

	@Id
	@Column(name = "ACID", length = 14, nullable = false)
	private String acid;

	@Column(name = "SOL_ID", length = 14)
	private String sol_id;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCT_OPN_DATE")
	private Date acct_opn_date;

	@Id
	@Column(name = "TRAN_ID", length = 14, nullable = false)
	private String tran_id;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_DATE")
	private Date tran_date;

	@Column(name = "PART_TRAN_TYPE", length = 14)
	private String part_tran_type;

	@Id
	@Column(name = "PART_TRAN_SRL_NUM", length = 14, nullable = false)
	private String part_tran_srl_num;

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

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public String getPart_tran_type() {
		return part_tran_type;
	}

	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}

	public String getPart_tran_srl_num() {
		return part_tran_srl_num;
	}

	public void setPart_tran_srl_num(String part_tran_srl_num) {
		this.part_tran_srl_num = part_tran_srl_num;
	}
}
