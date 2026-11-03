package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="BRF_MIS_FUND_BASED_ADVANCES")
@IdClass(RT_Mis_Fund_based_Advances_Id_Class.class)
public class RT_Mis_Fund_based_Advances_entity implements Serializable{
	@Id
	private String	acct_number;
	private String	acct_name;
	private String	cust_id;
	private String	schm_code;
	private String	schm_type;
	private String	acct_opn_date;
	private BigDecimal	int_rate;
	private BigDecimal	acct_balance_amt_ac;
	private String	acct_crncy_code;
	private String	country;
	@Id
	private Date	report_date;
	private String	acid;
	private String	gl_sub_head_code;
	private String	sol_id;
	private BigDecimal	act_balance_amt_lc;
	private String	constitution_code;
	private BigDecimal	hni_networth;
	private BigDecimal	turnover;
	private String	gl_code;
	private String	bacid;
	private String	purpose_of_advn;
	private String	legal_entity_type;
	private String	country_of_incorp;
	private String	nationality;
	private String	asst_category;
	private String	asst_cls;
	private String	economic_activity_code;
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
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getSchm_code() {
		return schm_code;
	}
	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}
	public String getSchm_type() {
		return schm_type;
	}
	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}
	public String getAcct_opn_date() {
		return acct_opn_date;
	}
	public void setAcct_opn_date(String acct_opn_date) {
		this.acct_opn_date = acct_opn_date;
	}
	public BigDecimal getInt_rate() {
		return int_rate;
	}
	public void setInt_rate(BigDecimal int_rate) {
		this.int_rate = int_rate;
	}
	public BigDecimal getAcct_balance_amt_ac() {
		return acct_balance_amt_ac;
	}
	public void setAcct_balance_amt_ac(BigDecimal acct_balance_amt_ac) {
		this.acct_balance_amt_ac = acct_balance_amt_ac;
	}
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public BigDecimal getAct_balance_amt_lc() {
		return act_balance_amt_lc;
	}
	public void setAct_balance_amt_lc(BigDecimal act_balance_amt_lc) {
		this.act_balance_amt_lc = act_balance_amt_lc;
	}
	public String getConstitution_code() {
		return constitution_code;
	}
	public void setConstitution_code(String constitution_code) {
		this.constitution_code = constitution_code;
	}
	public BigDecimal getHni_networth() {
		return hni_networth;
	}
	public void setHni_networth(BigDecimal hni_networth) {
		this.hni_networth = hni_networth;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getBacid() {
		return bacid;
	}
	public void setBacid(String bacid) {
		this.bacid = bacid;
	}
	public String getPurpose_of_advn() {
		return purpose_of_advn;
	}
	public void setPurpose_of_advn(String purpose_of_advn) {
		this.purpose_of_advn = purpose_of_advn;
	}
	public String getLegal_entity_type() {
		return legal_entity_type;
	}
	public void setLegal_entity_type(String legal_entity_type) {
		this.legal_entity_type = legal_entity_type;
	}
	public String getCountry_of_incorp() {
		return country_of_incorp;
	}
	public void setCountry_of_incorp(String country_of_incorp) {
		this.country_of_incorp = country_of_incorp;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAsst_category() {
		return asst_category;
	}
	public void setAsst_category(String asst_category) {
		this.asst_category = asst_category;
	}
	public String getAsst_cls() {
		return asst_cls;
	}
	public void setAsst_cls(String asst_cls) {
		this.asst_cls = asst_cls;
	}
	public String getEconomic_activity_code() {
		return economic_activity_code;
	}
	public void setEconomic_activity_code(String economic_activity_code) {
		this.economic_activity_code = economic_activity_code;
	}
	@Override
	public String toString() {
		return "RT_Mis_Fund_based_Advances_entity [acct_number=" + acct_number + ", acct_name=" + acct_name
				+ ", cust_id=" + cust_id + ", schm_code=" + schm_code + ", schm_type=" + schm_type + ", acct_opn_date="
				+ acct_opn_date + ", int_rate=" + int_rate + ", acct_balance_amt_ac=" + acct_balance_amt_ac
				+ ", acct_crncy_code=" + acct_crncy_code + ", country=" + country + ", report_date=" + report_date
				+ ", acid=" + acid + ", gl_sub_head_code=" + gl_sub_head_code + ", sol_id=" + sol_id
				+ ", act_balance_amt_lc=" + act_balance_amt_lc + ", constitution_code=" + constitution_code
				+ ", hni_networth=" + hni_networth + ", turnover=" + turnover + ", gl_code=" + gl_code + ", bacid="
				+ bacid + ", purpose_of_advn=" + purpose_of_advn + ", legal_entity_type=" + legal_entity_type
				+ ", country_of_incorp=" + country_of_incorp + ", nationality=" + nationality + ", asst_category="
				+ asst_category + ", asst_cls=" + asst_cls + ", economic_activity_code=" + economic_activity_code + "]";
	}
	public RT_Mis_Fund_based_Advances_entity(String acct_number, String acct_name, String cust_id, String schm_code,
			String schm_type, String acct_opn_date, BigDecimal int_rate, BigDecimal acct_balance_amt_ac,
			String acct_crncy_code, String country, Date report_date, String acid, String gl_sub_head_code,
			String sol_id, BigDecimal act_balance_amt_lc, String constitution_code, BigDecimal hni_networth,
			BigDecimal turnover, String gl_code, String bacid, String purpose_of_advn, String legal_entity_type,
			String country_of_incorp, String nationality, String asst_category, String asst_cls,
			String economic_activity_code) {
		super();
		this.acct_number = acct_number;
		this.acct_name = acct_name;
		this.cust_id = cust_id;
		this.schm_code = schm_code;
		this.schm_type = schm_type;
		this.acct_opn_date = acct_opn_date;
		this.int_rate = int_rate;
		this.acct_balance_amt_ac = acct_balance_amt_ac;
		this.acct_crncy_code = acct_crncy_code;
		this.country = country;
		this.report_date = report_date;
		this.acid = acid;
		this.gl_sub_head_code = gl_sub_head_code;
		this.sol_id = sol_id;
		this.act_balance_amt_lc = act_balance_amt_lc;
		this.constitution_code = constitution_code;
		this.hni_networth = hni_networth;
		this.turnover = turnover;
		this.gl_code = gl_code;
		this.bacid = bacid;
		this.purpose_of_advn = purpose_of_advn;
		this.legal_entity_type = legal_entity_type;
		this.country_of_incorp = country_of_incorp;
		this.nationality = nationality;
		this.asst_category = asst_category;
		this.asst_cls = asst_cls;
		this.economic_activity_code = economic_activity_code;
	}
	public RT_Mis_Fund_based_Advances_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
