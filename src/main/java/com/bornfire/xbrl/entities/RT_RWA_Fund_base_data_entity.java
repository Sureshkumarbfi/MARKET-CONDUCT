package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



//This is RWA Fund Base Data entity is used for BRF95 and Other credit Risk Analysis

@Entity
@Table(name="BRF95_RWA_DATA_FUNDBASED")
@IdClass(RT_RWA_Fund_base_id_class.class)
public class RT_RWA_Fund_base_data_entity implements Serializable {
	@Id
	private Date	report_date;
	private BigDecimal	moc;
	private String	territory;
	private String	branch_name;
	private String	cust_id;
	@Id
	private String	account_id;
	private String	account_name;
	private String	gl_code;
	private String	gl_code_description;
	private String	const_id;
	private String	const_description;
	private String	purpose;
	private String	purpose_description;
	private String	scheme;
	private String	schm_code_desc;
	private String	nationality;
	private String	legal_entity;
	private Date	open_date;
	private String	rwa_class;
	private String	sub_class;
	private Date	npa_date;
	private BigDecimal	int_suspense;
	private BigDecimal	tot_provision;
	private BigDecimal	prov_pcnt;
	private String	category;
	private String	sub_category;
	private BigDecimal	bs_turnover;
	private BigDecimal	net_worth;
	private Date	reshdl_date;
	private BigDecimal	res_sec_value;
	private String	ltv;
	private BigDecimal	gov_guarantee;
	private String	currency;
	private BigDecimal	limit;
	private BigDecimal	balance;
	private BigDecimal	exposure;
	private BigDecimal	security_fdr;
	private String	fdr_currency;
	private BigDecimal	adjusted_fdr;
	private BigDecimal	crm;
	private BigDecimal	crm_adj_bal;
	private BigDecimal	crm_gnt_adj_bal;
	private BigDecimal	rw;
	private BigDecimal	rwa;
	private BigDecimal	bill_amount;
	private BigDecimal	bill_disc_rwa;
	private BigDecimal	total_drawn_rwa;
	private String	bill_disc_dtls;
	private String	conditional_cancel;
	private BigDecimal	undrwn_balance;
	private BigDecimal	disb_amt1;
	private BigDecimal	disb_amt2;
	private BigDecimal	loan_disb_amt;
	private BigDecimal	undrwn_ccf;
	private BigDecimal	undrwn_crm;
	private BigDecimal	undrwn_adj_crm;
	private BigDecimal	undrwn_ccf_balance;
	private BigDecimal	undrwn_rwa;
	private String	undrwn_disb;
	private BigDecimal	ac_rwp;
	private String	rating;
	private Date	rating_date;
	private Date	rating_expiry;
	private String	pan_number;
	private BigDecimal	ind_report_order;
	private String	ind_desc;
	private BigDecimal	int_rate;
	private BigDecimal	no_of_employees;
	private String	int_tbl_code;
	private Date	maturity_date;
	private String	frequency;
	private String	brf_1_classification;
	private BigDecimal	total_rwa;
	private String	dpd;
	private String	sma;
	private String	ecl_stage_class;
	private BigDecimal	ecl_management_overlay;
	private String	sector_classification;
	private String	economic_activity_code;
	private String	sub_sector_classification;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getMoc() {
		return moc;
	}
	public void setMoc(BigDecimal moc) {
		this.moc = moc;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGl_code_description() {
		return gl_code_description;
	}
	public void setGl_code_description(String gl_code_description) {
		this.gl_code_description = gl_code_description;
	}
	public String getConst_id() {
		return const_id;
	}
	public void setConst_id(String const_id) {
		this.const_id = const_id;
	}
	public String getConst_description() {
		return const_description;
	}
	public void setConst_description(String const_description) {
		this.const_description = const_description;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPurpose_description() {
		return purpose_description;
	}
	public void setPurpose_description(String purpose_description) {
		this.purpose_description = purpose_description;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getSchm_code_desc() {
		return schm_code_desc;
	}
	public void setSchm_code_desc(String schm_code_desc) {
		this.schm_code_desc = schm_code_desc;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getLegal_entity() {
		return legal_entity;
	}
	public void setLegal_entity(String legal_entity) {
		this.legal_entity = legal_entity;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getRwa_class() {
		return rwa_class;
	}
	public void setRwa_class(String rwa_class) {
		this.rwa_class = rwa_class;
	}
	public String getSub_class() {
		return sub_class;
	}
	public void setSub_class(String sub_class) {
		this.sub_class = sub_class;
	}
	public Date getNpa_date() {
		return npa_date;
	}
	public void setNpa_date(Date npa_date) {
		this.npa_date = npa_date;
	}
	public BigDecimal getInt_suspense() {
		return int_suspense;
	}
	public void setInt_suspense(BigDecimal int_suspense) {
		this.int_suspense = int_suspense;
	}
	public BigDecimal getTot_provision() {
		return tot_provision;
	}
	public void setTot_provision(BigDecimal tot_provision) {
		this.tot_provision = tot_provision;
	}
	public BigDecimal getProv_pcnt() {
		return prov_pcnt;
	}
	public void setProv_pcnt(BigDecimal prov_pcnt) {
		this.prov_pcnt = prov_pcnt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public BigDecimal getBs_turnover() {
		return bs_turnover;
	}
	public void setBs_turnover(BigDecimal bs_turnover) {
		this.bs_turnover = bs_turnover;
	}
	public BigDecimal getNet_worth() {
		return net_worth;
	}
	public void setNet_worth(BigDecimal net_worth) {
		this.net_worth = net_worth;
	}
	public Date getReshdl_date() {
		return reshdl_date;
	}
	public void setReshdl_date(Date reshdl_date) {
		this.reshdl_date = reshdl_date;
	}
	public BigDecimal getRes_sec_value() {
		return res_sec_value;
	}
	public void setRes_sec_value(BigDecimal res_sec_value) {
		this.res_sec_value = res_sec_value;
	}
	public String getLtv() {
		return ltv;
	}
	public void setLtv(String ltv) {
		this.ltv = ltv;
	}
	public BigDecimal getGov_guarantee() {
		return gov_guarantee;
	}
	public void setGov_guarantee(BigDecimal gov_guarantee) {
		this.gov_guarantee = gov_guarantee;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getExposure() {
		return exposure;
	}
	public void setExposure(BigDecimal exposure) {
		this.exposure = exposure;
	}
	public BigDecimal getSecurity_fdr() {
		return security_fdr;
	}
	public void setSecurity_fdr(BigDecimal security_fdr) {
		this.security_fdr = security_fdr;
	}
	public String getFdr_currency() {
		return fdr_currency;
	}
	public void setFdr_currency(String fdr_currency) {
		this.fdr_currency = fdr_currency;
	}
	public BigDecimal getAdjusted_fdr() {
		return adjusted_fdr;
	}
	public void setAdjusted_fdr(BigDecimal adjusted_fdr) {
		this.adjusted_fdr = adjusted_fdr;
	}
	public BigDecimal getCrm() {
		return crm;
	}
	public void setCrm(BigDecimal crm) {
		this.crm = crm;
	}
	public BigDecimal getCrm_adj_bal() {
		return crm_adj_bal;
	}
	public void setCrm_adj_bal(BigDecimal crm_adj_bal) {
		this.crm_adj_bal = crm_adj_bal;
	}
	public BigDecimal getCrm_gnt_adj_bal() {
		return crm_gnt_adj_bal;
	}
	public void setCrm_gnt_adj_bal(BigDecimal crm_gnt_adj_bal) {
		this.crm_gnt_adj_bal = crm_gnt_adj_bal;
	}
	public BigDecimal getRw() {
		return rw;
	}
	public void setRw(BigDecimal rw) {
		this.rw = rw;
	}
	public BigDecimal getRwa() {
		return rwa;
	}
	public void setRwa(BigDecimal rwa) {
		this.rwa = rwa;
	}
	public BigDecimal getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(BigDecimal bill_amount) {
		this.bill_amount = bill_amount;
	}
	public BigDecimal getBill_disc_rwa() {
		return bill_disc_rwa;
	}
	public void setBill_disc_rwa(BigDecimal bill_disc_rwa) {
		this.bill_disc_rwa = bill_disc_rwa;
	}
	public BigDecimal getTotal_drawn_rwa() {
		return total_drawn_rwa;
	}
	public void setTotal_drawn_rwa(BigDecimal total_drawn_rwa) {
		this.total_drawn_rwa = total_drawn_rwa;
	}
	public String getBill_disc_dtls() {
		return bill_disc_dtls;
	}
	public void setBill_disc_dtls(String bill_disc_dtls) {
		this.bill_disc_dtls = bill_disc_dtls;
	}
	public String getConditional_cancel() {
		return conditional_cancel;
	}
	public void setConditional_cancel(String conditional_cancel) {
		this.conditional_cancel = conditional_cancel;
	}
	public BigDecimal getUndrwn_balance() {
		return undrwn_balance;
	}
	public void setUndrwn_balance(BigDecimal undrwn_balance) {
		this.undrwn_balance = undrwn_balance;
	}
	public BigDecimal getDisb_amt1() {
		return disb_amt1;
	}
	public void setDisb_amt1(BigDecimal disb_amt1) {
		this.disb_amt1 = disb_amt1;
	}
	public BigDecimal getDisb_amt2() {
		return disb_amt2;
	}
	public void setDisb_amt2(BigDecimal disb_amt2) {
		this.disb_amt2 = disb_amt2;
	}
	public BigDecimal getLoan_disb_amt() {
		return loan_disb_amt;
	}
	public void setLoan_disb_amt(BigDecimal loan_disb_amt) {
		this.loan_disb_amt = loan_disb_amt;
	}
	public BigDecimal getUndrwn_ccf() {
		return undrwn_ccf;
	}
	public void setUndrwn_ccf(BigDecimal undrwn_ccf) {
		this.undrwn_ccf = undrwn_ccf;
	}
	public BigDecimal getUndrwn_crm() {
		return undrwn_crm;
	}
	public void setUndrwn_crm(BigDecimal undrwn_crm) {
		this.undrwn_crm = undrwn_crm;
	}
	public BigDecimal getUndrwn_adj_crm() {
		return undrwn_adj_crm;
	}
	public void setUndrwn_adj_crm(BigDecimal undrwn_adj_crm) {
		this.undrwn_adj_crm = undrwn_adj_crm;
	}
	public BigDecimal getUndrwn_ccf_balance() {
		return undrwn_ccf_balance;
	}
	public void setUndrwn_ccf_balance(BigDecimal undrwn_ccf_balance) {
		this.undrwn_ccf_balance = undrwn_ccf_balance;
	}
	public BigDecimal getUndrwn_rwa() {
		return undrwn_rwa;
	}
	public void setUndrwn_rwa(BigDecimal undrwn_rwa) {
		this.undrwn_rwa = undrwn_rwa;
	}
	public String getUndrwn_disb() {
		return undrwn_disb;
	}
	public void setUndrwn_disb(String undrwn_disb) {
		this.undrwn_disb = undrwn_disb;
	}
	public BigDecimal getAc_rwp() {
		return ac_rwp;
	}
	public void setAc_rwp(BigDecimal ac_rwp) {
		this.ac_rwp = ac_rwp;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getRating_date() {
		return rating_date;
	}
	public void setRating_date(Date rating_date) {
		this.rating_date = rating_date;
	}
	public Date getRating_expiry() {
		return rating_expiry;
	}
	public void setRating_expiry(Date rating_expiry) {
		this.rating_expiry = rating_expiry;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public BigDecimal getInd_report_order() {
		return ind_report_order;
	}
	public void setInd_report_order(BigDecimal ind_report_order) {
		this.ind_report_order = ind_report_order;
	}
	public String getInd_desc() {
		return ind_desc;
	}
	public void setInd_desc(String ind_desc) {
		this.ind_desc = ind_desc;
	}
	public BigDecimal getInt_rate() {
		return int_rate;
	}
	public void setInt_rate(BigDecimal int_rate) {
		this.int_rate = int_rate;
	}
	public BigDecimal getNo_of_employees() {
		return no_of_employees;
	}
	public void setNo_of_employees(BigDecimal no_of_employees) {
		this.no_of_employees = no_of_employees;
	}
	public String getInt_tbl_code() {
		return int_tbl_code;
	}
	public void setInt_tbl_code(String int_tbl_code) {
		this.int_tbl_code = int_tbl_code;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getBrf_1_classification() {
		return brf_1_classification;
	}
	public void setBrf_1_classification(String brf_1_classification) {
		this.brf_1_classification = brf_1_classification;
	}
	public BigDecimal getTotal_rwa() {
		return total_rwa;
	}
	public void setTotal_rwa(BigDecimal total_rwa) {
		this.total_rwa = total_rwa;
	}
	public String getDpd() {
		return dpd;
	}
	public void setDpd(String dpd) {
		this.dpd = dpd;
	}
	public String getSma() {
		return sma;
	}
	public void setSma(String sma) {
		this.sma = sma;
	}
	public String getEcl_stage_class() {
		return ecl_stage_class;
	}
	public void setEcl_stage_class(String ecl_stage_class) {
		this.ecl_stage_class = ecl_stage_class;
	}
	public BigDecimal getEcl_management_overlay() {
		return ecl_management_overlay;
	}
	public void setEcl_management_overlay(BigDecimal ecl_management_overlay) {
		this.ecl_management_overlay = ecl_management_overlay;
	}
	public String getSector_classification() {
		return sector_classification;
	}
	public void setSector_classification(String sector_classification) {
		this.sector_classification = sector_classification;
	}
	public String getEconomic_activity_code() {
		return economic_activity_code;
	}
	public void setEconomic_activity_code(String economic_activity_code) {
		this.economic_activity_code = economic_activity_code;
	}
	public String getSub_sector_classification() {
		return sub_sector_classification;
	}
	public void setSub_sector_classification(String sub_sector_classification) {
		this.sub_sector_classification = sub_sector_classification;
	}
	@Override
	public String toString() {
		return "RT_RWA_Fund_base_data_entity [report_date=" + report_date + ", moc=" + moc + ", territory=" + territory
				+ ", branch_name=" + branch_name + ", cust_id=" + cust_id + ", account_id=" + account_id
				+ ", account_name=" + account_name + ", gl_code=" + gl_code + ", gl_code_description="
				+ gl_code_description + ", const_id=" + const_id + ", const_description=" + const_description
				+ ", purpose=" + purpose + ", purpose_description=" + purpose_description + ", scheme=" + scheme
				+ ", schm_code_desc=" + schm_code_desc + ", nationality=" + nationality + ", legal_entity="
				+ legal_entity + ", open_date=" + open_date + ", rwa_class=" + rwa_class + ", sub_class=" + sub_class
				+ ", npa_date=" + npa_date + ", int_suspense=" + int_suspense + ", tot_provision=" + tot_provision
				+ ", prov_pcnt=" + prov_pcnt + ", category=" + category + ", sub_category=" + sub_category
				+ ", bs_turnover=" + bs_turnover + ", net_worth=" + net_worth + ", reshdl_date=" + reshdl_date
				+ ", res_sec_value=" + res_sec_value + ", ltv=" + ltv + ", gov_guarantee=" + gov_guarantee
				+ ", currency=" + currency + ", limit=" + limit + ", balance=" + balance + ", exposure=" + exposure
				+ ", security_fdr=" + security_fdr + ", fdr_currency=" + fdr_currency + ", adjusted_fdr=" + adjusted_fdr
				+ ", crm=" + crm + ", crm_adj_bal=" + crm_adj_bal + ", crm_gnt_adj_bal=" + crm_gnt_adj_bal + ", rw="
				+ rw + ", rwa=" + rwa + ", bill_amount=" + bill_amount + ", bill_disc_rwa=" + bill_disc_rwa
				+ ", total_drawn_rwa=" + total_drawn_rwa + ", bill_disc_dtls=" + bill_disc_dtls
				+ ", conditional_cancel=" + conditional_cancel + ", undrwn_balance=" + undrwn_balance + ", disb_amt1="
				+ disb_amt1 + ", disb_amt2=" + disb_amt2 + ", loan_disb_amt=" + loan_disb_amt + ", undrwn_ccf="
				+ undrwn_ccf + ", undrwn_crm=" + undrwn_crm + ", undrwn_adj_crm=" + undrwn_adj_crm
				+ ", undrwn_ccf_balance=" + undrwn_ccf_balance + ", undrwn_rwa=" + undrwn_rwa + ", undrwn_disb="
				+ undrwn_disb + ", ac_rwp=" + ac_rwp + ", rating=" + rating + ", rating_date=" + rating_date
				+ ", rating_expiry=" + rating_expiry + ", pan_number=" + pan_number + ", ind_report_order="
				+ ind_report_order + ", ind_desc=" + ind_desc + ", int_rate=" + int_rate + ", no_of_employees="
				+ no_of_employees + ", int_tbl_code=" + int_tbl_code + ", maturity_date=" + maturity_date
				+ ", frequency=" + frequency + ", brf_1_classification=" + brf_1_classification + ", total_rwa="
				+ total_rwa + ", dpd=" + dpd + ", sma=" + sma + ", ecl_stage_class=" + ecl_stage_class
				+ ", ecl_management_overlay=" + ecl_management_overlay + ", sector_classification="
				+ sector_classification + ", economic_activity_code=" + economic_activity_code
				+ ", sub_sector_classification=" + sub_sector_classification + "]";
	}
	public RT_RWA_Fund_base_data_entity(Date report_date, BigDecimal moc, String territory, String branch_name,
			String cust_id, String account_id, String account_name, String gl_code, String gl_code_description,
			String const_id, String const_description, String purpose, String purpose_description, String scheme,
			String schm_code_desc, String nationality, String legal_entity, Date open_date, String rwa_class,
			String sub_class, Date npa_date, BigDecimal int_suspense, BigDecimal tot_provision, BigDecimal prov_pcnt,
			String category, String sub_category, BigDecimal bs_turnover, BigDecimal net_worth, Date reshdl_date,
			BigDecimal res_sec_value, String ltv, BigDecimal gov_guarantee, String currency, BigDecimal limit,
			BigDecimal balance, BigDecimal exposure, BigDecimal security_fdr, String fdr_currency,
			BigDecimal adjusted_fdr, BigDecimal crm, BigDecimal crm_adj_bal, BigDecimal crm_gnt_adj_bal, BigDecimal rw,
			BigDecimal rwa, BigDecimal bill_amount, BigDecimal bill_disc_rwa, BigDecimal total_drawn_rwa,
			String bill_disc_dtls, String conditional_cancel, BigDecimal undrwn_balance, BigDecimal disb_amt1,
			BigDecimal disb_amt2, BigDecimal loan_disb_amt, BigDecimal undrwn_ccf, BigDecimal undrwn_crm,
			BigDecimal undrwn_adj_crm, BigDecimal undrwn_ccf_balance, BigDecimal undrwn_rwa, String undrwn_disb,
			BigDecimal ac_rwp, String rating, Date rating_date, Date rating_expiry, String pan_number,
			BigDecimal ind_report_order, String ind_desc, BigDecimal int_rate, BigDecimal no_of_employees,
			String int_tbl_code, Date maturity_date, String frequency, String brf_1_classification,
			BigDecimal total_rwa, String dpd, String sma, String ecl_stage_class, BigDecimal ecl_management_overlay,
			String sector_classification, String economic_activity_code, String sub_sector_classification) {
		super();
		this.report_date = report_date;
		this.moc = moc;
		this.territory = territory;
		this.branch_name = branch_name;
		this.cust_id = cust_id;
		this.account_id = account_id;
		this.account_name = account_name;
		this.gl_code = gl_code;
		this.gl_code_description = gl_code_description;
		this.const_id = const_id;
		this.const_description = const_description;
		this.purpose = purpose;
		this.purpose_description = purpose_description;
		this.scheme = scheme;
		this.schm_code_desc = schm_code_desc;
		this.nationality = nationality;
		this.legal_entity = legal_entity;
		this.open_date = open_date;
		this.rwa_class = rwa_class;
		this.sub_class = sub_class;
		this.npa_date = npa_date;
		this.int_suspense = int_suspense;
		this.tot_provision = tot_provision;
		this.prov_pcnt = prov_pcnt;
		this.category = category;
		this.sub_category = sub_category;
		this.bs_turnover = bs_turnover;
		this.net_worth = net_worth;
		this.reshdl_date = reshdl_date;
		this.res_sec_value = res_sec_value;
		this.ltv = ltv;
		this.gov_guarantee = gov_guarantee;
		this.currency = currency;
		this.limit = limit;
		this.balance = balance;
		this.exposure = exposure;
		this.security_fdr = security_fdr;
		this.fdr_currency = fdr_currency;
		this.adjusted_fdr = adjusted_fdr;
		this.crm = crm;
		this.crm_adj_bal = crm_adj_bal;
		this.crm_gnt_adj_bal = crm_gnt_adj_bal;
		this.rw = rw;
		this.rwa = rwa;
		this.bill_amount = bill_amount;
		this.bill_disc_rwa = bill_disc_rwa;
		this.total_drawn_rwa = total_drawn_rwa;
		this.bill_disc_dtls = bill_disc_dtls;
		this.conditional_cancel = conditional_cancel;
		this.undrwn_balance = undrwn_balance;
		this.disb_amt1 = disb_amt1;
		this.disb_amt2 = disb_amt2;
		this.loan_disb_amt = loan_disb_amt;
		this.undrwn_ccf = undrwn_ccf;
		this.undrwn_crm = undrwn_crm;
		this.undrwn_adj_crm = undrwn_adj_crm;
		this.undrwn_ccf_balance = undrwn_ccf_balance;
		this.undrwn_rwa = undrwn_rwa;
		this.undrwn_disb = undrwn_disb;
		this.ac_rwp = ac_rwp;
		this.rating = rating;
		this.rating_date = rating_date;
		this.rating_expiry = rating_expiry;
		this.pan_number = pan_number;
		this.ind_report_order = ind_report_order;
		this.ind_desc = ind_desc;
		this.int_rate = int_rate;
		this.no_of_employees = no_of_employees;
		this.int_tbl_code = int_tbl_code;
		this.maturity_date = maturity_date;
		this.frequency = frequency;
		this.brf_1_classification = brf_1_classification;
		this.total_rwa = total_rwa;
		this.dpd = dpd;
		this.sma = sma;
		this.ecl_stage_class = ecl_stage_class;
		this.ecl_management_overlay = ecl_management_overlay;
		this.sector_classification = sector_classification;
		this.economic_activity_code = economic_activity_code;
		this.sub_sector_classification = sub_sector_classification;
	}
	public RT_RWA_Fund_base_data_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
