package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "BRF95_RWA_DATA_NONFUNDBASED")
@IdClass(RT_RWA_NonFund_base_id_class.class) // Create a similar ID class as Fund Based
public class RT_RWA_NonFund_base_data_entity implements Serializable {
	@Id
	private Date report_date;
	private BigDecimal moc;
	private String territory;
	private String branch_name;
	private String cust_id;
	private String cust_name;
	private String type;
	@Id
	private String lcbg_id;
	private String gl_code;
	private String gl_code_description;
	private String const_id;
	private String const_description;
	private String purpose;
	private String purpose_description;
	private String nationality;
	private String legal_entity;
	@Column(name = "CLASS")
	private String class_val; // 'CLASS' is a reserved keyword in some DBs, mapping to CLASS column
	private String sub_class;
	private Date npa_date;
	private BigDecimal tot_provision;
	private BigDecimal lcbg_prov;
	private String provision_percent;
	private String category;
	private String sub_category;
	private BigDecimal bs_turnover;
	private BigDecimal net_worth;
	private BigDecimal lcbg_limit;
	private BigDecimal security_fd_primary;
	private BigDecimal security_fd_collat;
	private String currency;
	private BigDecimal lcbg_balance;
	private BigDecimal lcbg_exposure;
	private BigDecimal ccf;
	private BigDecimal lcbg_ccf_adj_amt;
	private BigDecimal lcbg_crm;
	private BigDecimal crm;
	private BigDecimal crm_adj_bal;
	private BigDecimal acceptance_amount;
	private BigDecimal risk_pcnt;
	private BigDecimal rwa;
	private BigDecimal ac_rwp;
	private BigDecimal undrwn_balance;
	private BigDecimal undrwn_ccf;
	private BigDecimal undrwn_ccf_balance;
	private BigDecimal undrwn_crm;
	private BigDecimal undrwn_adj_crm;
	private BigDecimal undrwn_rwa;
	private String bg_type;
	private BigDecimal rrp_exp;
	private String lc_nature;
	private String rating;
	private Date rating_date;
	private Date rating_expiry;
	private BigDecimal ind_report_order;
	private String ind_desc;
	private BigDecimal no_of_employees;
	private Date maturity_date;
	private String sector_classification;
	private String sub_sector_classification;
	private String group_name;

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

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLcbg_id() {
		return lcbg_id;
	}

	public void setLcbg_id(String lcbg_id) {
		this.lcbg_id = lcbg_id;
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

	public String getClass_val() {
		return class_val;
	}

	public void setClass_val(String class_val) {
		this.class_val = class_val;
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

	public BigDecimal getTot_provision() {
		return tot_provision;
	}

	public void setTot_provision(BigDecimal tot_provision) {
		this.tot_provision = tot_provision;
	}

	public BigDecimal getLcbg_prov() {
		return lcbg_prov;
	}

	public void setLcbg_prov(BigDecimal lcbg_prov) {
		this.lcbg_prov = lcbg_prov;
	}

	public String getProvision_percent() {
		return provision_percent;
	}

	public void setProvision_percent(String provision_percent) {
		this.provision_percent = provision_percent;
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

	public BigDecimal getLcbg_limit() {
		return lcbg_limit;
	}

	public void setLcbg_limit(BigDecimal lcbg_limit) {
		this.lcbg_limit = lcbg_limit;
	}

	public BigDecimal getSecurity_fd_primary() {
		return security_fd_primary;
	}

	public void setSecurity_fd_primary(BigDecimal security_fd_primary) {
		this.security_fd_primary = security_fd_primary;
	}

	public BigDecimal getSecurity_fd_collat() {
		return security_fd_collat;
	}

	public void setSecurity_fd_collat(BigDecimal security_fd_collat) {
		this.security_fd_collat = security_fd_collat;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getLcbg_balance() {
		return lcbg_balance;
	}

	public void setLcbg_balance(BigDecimal lcbg_balance) {
		this.lcbg_balance = lcbg_balance;
	}

	public BigDecimal getLcbg_exposure() {
		return lcbg_exposure;
	}

	public void setLcbg_exposure(BigDecimal lcbg_exposure) {
		this.lcbg_exposure = lcbg_exposure;
	}

	public BigDecimal getCcf() {
		return ccf;
	}

	public void setCcf(BigDecimal ccf) {
		this.ccf = ccf;
	}

	public BigDecimal getLcbg_ccf_adj_amt() {
		return lcbg_ccf_adj_amt;
	}

	public void setLcbg_ccf_adj_amt(BigDecimal lcbg_ccf_adj_amt) {
		this.lcbg_ccf_adj_amt = lcbg_ccf_adj_amt;
	}

	public BigDecimal getLcbg_crm() {
		return lcbg_crm;
	}

	public void setLcbg_crm(BigDecimal lcbg_crm) {
		this.lcbg_crm = lcbg_crm;
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

	public BigDecimal getAcceptance_amount() {
		return acceptance_amount;
	}

	public void setAcceptance_amount(BigDecimal acceptance_amount) {
		this.acceptance_amount = acceptance_amount;
	}

	public BigDecimal getRisk_pcnt() {
		return risk_pcnt;
	}

	public void setRisk_pcnt(BigDecimal risk_pcnt) {
		this.risk_pcnt = risk_pcnt;
	}

	public BigDecimal getRwa() {
		return rwa;
	}

	public void setRwa(BigDecimal rwa) {
		this.rwa = rwa;
	}

	public BigDecimal getAc_rwp() {
		return ac_rwp;
	}

	public void setAc_rwp(BigDecimal ac_rwp) {
		this.ac_rwp = ac_rwp;
	}

	public BigDecimal getUndrwn_balance() {
		return undrwn_balance;
	}

	public void setUndrwn_balance(BigDecimal undrwn_balance) {
		this.undrwn_balance = undrwn_balance;
	}

	public BigDecimal getUndrwn_ccf() {
		return undrwn_ccf;
	}

	public void setUndrwn_ccf(BigDecimal undrwn_ccf) {
		this.undrwn_ccf = undrwn_ccf;
	}

	public BigDecimal getUndrwn_ccf_balance() {
		return undrwn_ccf_balance;
	}

	public void setUndrwn_ccf_balance(BigDecimal undrwn_ccf_balance) {
		this.undrwn_ccf_balance = undrwn_ccf_balance;
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

	public BigDecimal getUndrwn_rwa() {
		return undrwn_rwa;
	}

	public void setUndrwn_rwa(BigDecimal undrwn_rwa) {
		this.undrwn_rwa = undrwn_rwa;
	}

	public String getBg_type() {
		return bg_type;
	}

	public void setBg_type(String bg_type) {
		this.bg_type = bg_type;
	}

	public BigDecimal getRrp_exp() {
		return rrp_exp;
	}

	public void setRrp_exp(BigDecimal rrp_exp) {
		this.rrp_exp = rrp_exp;
	}

	public String getLc_nature() {
		return lc_nature;
	}

	public void setLc_nature(String lc_nature) {
		this.lc_nature = lc_nature;
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

	public BigDecimal getNo_of_employees() {
		return no_of_employees;
	}

	public void setNo_of_employees(BigDecimal no_of_employees) {
		this.no_of_employees = no_of_employees;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public String getSector_classification() {
		return sector_classification;
	}

	public void setSector_classification(String sector_classification) {
		this.sector_classification = sector_classification;
	}

	public String getSub_sector_classification() {
		return sub_sector_classification;
	}

	public void setSub_sector_classification(String sub_sector_classification) {
		this.sub_sector_classification = sub_sector_classification;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public RT_RWA_NonFund_base_data_entity(Date report_date, BigDecimal moc, String territory, String branch_name,
			String cust_id, String cust_name, String type, String lcbg_id, String gl_code, String gl_code_description,
			String const_id, String const_description, String purpose, String purpose_description, String nationality,
			String legal_entity, String class_val, String sub_class, Date npa_date, BigDecimal tot_provision,
			BigDecimal lcbg_prov, String provision_percent, String category, String sub_category,
			BigDecimal bs_turnover, BigDecimal net_worth, BigDecimal lcbg_limit, BigDecimal security_fd_primary,
			BigDecimal security_fd_collat, String currency, BigDecimal lcbg_balance, BigDecimal lcbg_exposure,
			BigDecimal ccf, BigDecimal lcbg_ccf_adj_amt, BigDecimal lcbg_crm, BigDecimal crm, BigDecimal crm_adj_bal,
			BigDecimal acceptance_amount, BigDecimal risk_pcnt, BigDecimal rwa, BigDecimal ac_rwp,
			BigDecimal undrwn_balance, BigDecimal undrwn_ccf, BigDecimal undrwn_ccf_balance, BigDecimal undrwn_crm,
			BigDecimal undrwn_adj_crm, BigDecimal undrwn_rwa, String bg_type, BigDecimal rrp_exp, String lc_nature,
			String rating, Date rating_date, Date rating_expiry, BigDecimal ind_report_order, String ind_desc,
			BigDecimal no_of_employees, Date maturity_date, String sector_classification,
			String sub_sector_classification, String group_name) {
		super();
		this.report_date = report_date;
		this.moc = moc;
		this.territory = territory;
		this.branch_name = branch_name;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.type = type;
		this.lcbg_id = lcbg_id;
		this.gl_code = gl_code;
		this.gl_code_description = gl_code_description;
		this.const_id = const_id;
		this.const_description = const_description;
		this.purpose = purpose;
		this.purpose_description = purpose_description;
		this.nationality = nationality;
		this.legal_entity = legal_entity;
		this.class_val = class_val;
		this.sub_class = sub_class;
		this.npa_date = npa_date;
		this.tot_provision = tot_provision;
		this.lcbg_prov = lcbg_prov;
		this.provision_percent = provision_percent;
		this.category = category;
		this.sub_category = sub_category;
		this.bs_turnover = bs_turnover;
		this.net_worth = net_worth;
		this.lcbg_limit = lcbg_limit;
		this.security_fd_primary = security_fd_primary;
		this.security_fd_collat = security_fd_collat;
		this.currency = currency;
		this.lcbg_balance = lcbg_balance;
		this.lcbg_exposure = lcbg_exposure;
		this.ccf = ccf;
		this.lcbg_ccf_adj_amt = lcbg_ccf_adj_amt;
		this.lcbg_crm = lcbg_crm;
		this.crm = crm;
		this.crm_adj_bal = crm_adj_bal;
		this.acceptance_amount = acceptance_amount;
		this.risk_pcnt = risk_pcnt;
		this.rwa = rwa;
		this.ac_rwp = ac_rwp;
		this.undrwn_balance = undrwn_balance;
		this.undrwn_ccf = undrwn_ccf;
		this.undrwn_ccf_balance = undrwn_ccf_balance;
		this.undrwn_crm = undrwn_crm;
		this.undrwn_adj_crm = undrwn_adj_crm;
		this.undrwn_rwa = undrwn_rwa;
		this.bg_type = bg_type;
		this.rrp_exp = rrp_exp;
		this.lc_nature = lc_nature;
		this.rating = rating;
		this.rating_date = rating_date;
		this.rating_expiry = rating_expiry;
		this.ind_report_order = ind_report_order;
		this.ind_desc = ind_desc;
		this.no_of_employees = no_of_employees;
		this.maturity_date = maturity_date;
		this.sector_classification = sector_classification;
		this.sub_sector_classification = sub_sector_classification;
		this.group_name = group_name;
	}

	@Override
	public String toString() {
		return "RT_RWA_NonFund_base_data_entity [report_date=" + report_date + ", moc=" + moc + ", territory="
				+ territory + ", branch_name=" + branch_name + ", cust_id=" + cust_id + ", cust_name=" + cust_name
				+ ", type=" + type + ", lcbg_id=" + lcbg_id + ", gl_code=" + gl_code + ", gl_code_description="
				+ gl_code_description + ", const_id=" + const_id + ", const_description=" + const_description
				+ ", purpose=" + purpose + ", purpose_description=" + purpose_description + ", nationality="
				+ nationality + ", legal_entity=" + legal_entity + ", class_val=" + class_val + ", sub_class="
				+ sub_class + ", npa_date=" + npa_date + ", tot_provision=" + tot_provision + ", lcbg_prov=" + lcbg_prov
				+ ", provision_percent=" + provision_percent + ", category=" + category + ", sub_category="
				+ sub_category + ", bs_turnover=" + bs_turnover + ", net_worth=" + net_worth + ", lcbg_limit="
				+ lcbg_limit + ", security_fd_primary=" + security_fd_primary + ", security_fd_collat="
				+ security_fd_collat + ", currency=" + currency + ", lcbg_balance=" + lcbg_balance + ", lcbg_exposure="
				+ lcbg_exposure + ", ccf=" + ccf + ", lcbg_ccf_adj_amt=" + lcbg_ccf_adj_amt + ", lcbg_crm=" + lcbg_crm
				+ ", crm=" + crm + ", crm_adj_bal=" + crm_adj_bal + ", acceptance_amount=" + acceptance_amount
				+ ", risk_pcnt=" + risk_pcnt + ", rwa=" + rwa + ", ac_rwp=" + ac_rwp + ", undrwn_balance="
				+ undrwn_balance + ", undrwn_ccf=" + undrwn_ccf + ", undrwn_ccf_balance=" + undrwn_ccf_balance
				+ ", undrwn_crm=" + undrwn_crm + ", undrwn_adj_crm=" + undrwn_adj_crm + ", undrwn_rwa=" + undrwn_rwa
				+ ", bg_type=" + bg_type + ", rrp_exp=" + rrp_exp + ", lc_nature=" + lc_nature + ", rating=" + rating
				+ ", rating_date=" + rating_date + ", rating_expiry=" + rating_expiry + ", ind_report_order="
				+ ind_report_order + ", ind_desc=" + ind_desc + ", no_of_employees=" + no_of_employees
				+ ", maturity_date=" + maturity_date + ", sector_classification=" + sector_classification
				+ ", sub_sector_classification=" + sub_sector_classification + ", group_name=" + group_name
				+ ", getReport_date()=" + getReport_date() + ", getMoc()=" + getMoc() + ", getTerritory()="
				+ getTerritory() + ", getBranch_name()=" + getBranch_name() + ", getCust_id()=" + getCust_id()
				+ ", getCust_name()=" + getCust_name() + ", getType()=" + getType() + ", getLcbg_id()=" + getLcbg_id()
				+ ", getGl_code()=" + getGl_code() + ", getGl_code_description()=" + getGl_code_description()
				+ ", getConst_id()=" + getConst_id() + ", getConst_description()=" + getConst_description()
				+ ", getPurpose()=" + getPurpose() + ", getPurpose_description()=" + getPurpose_description()
				+ ", getNationality()=" + getNationality() + ", getLegal_entity()=" + getLegal_entity()
				+ ", getClass_val()=" + getClass_val() + ", getSub_class()=" + getSub_class() + ", getNpa_date()="
				+ getNpa_date() + ", getTot_provision()=" + getTot_provision() + ", getLcbg_prov()=" + getLcbg_prov()
				+ ", getProvision_percent()=" + getProvision_percent() + ", getCategory()=" + getCategory()
				+ ", getSub_category()=" + getSub_category() + ", getBs_turnover()=" + getBs_turnover()
				+ ", getNet_worth()=" + getNet_worth() + ", getLcbg_limit()=" + getLcbg_limit()
				+ ", getSecurity_fd_primary()=" + getSecurity_fd_primary() + ", getSecurity_fd_collat()="
				+ getSecurity_fd_collat() + ", getCurrency()=" + getCurrency() + ", getLcbg_balance()="
				+ getLcbg_balance() + ", getLcbg_exposure()=" + getLcbg_exposure() + ", getCcf()=" + getCcf()
				+ ", getLcbg_ccf_adj_amt()=" + getLcbg_ccf_adj_amt() + ", getLcbg_crm()=" + getLcbg_crm()
				+ ", getCrm()=" + getCrm() + ", getCrm_adj_bal()=" + getCrm_adj_bal() + ", getAcceptance_amount()="
				+ getAcceptance_amount() + ", getRisk_pcnt()=" + getRisk_pcnt() + ", getRwa()=" + getRwa()
				+ ", getAc_rwp()=" + getAc_rwp() + ", getUndrwn_balance()=" + getUndrwn_balance() + ", getUndrwn_ccf()="
				+ getUndrwn_ccf() + ", getUndrwn_ccf_balance()=" + getUndrwn_ccf_balance() + ", getUndrwn_crm()="
				+ getUndrwn_crm() + ", getUndrwn_adj_crm()=" + getUndrwn_adj_crm() + ", getUndrwn_rwa()="
				+ getUndrwn_rwa() + ", getBg_type()=" + getBg_type() + ", getRrp_exp()=" + getRrp_exp()
				+ ", getLc_nature()=" + getLc_nature() + ", getRating()=" + getRating() + ", getRating_date()="
				+ getRating_date() + ", getRating_expiry()=" + getRating_expiry() + ", getInd_report_order()="
				+ getInd_report_order() + ", getInd_desc()=" + getInd_desc() + ", getNo_of_employees()="
				+ getNo_of_employees() + ", getMaturity_date()=" + getMaturity_date() + ", getSector_classification()="
				+ getSector_classification() + ", getSub_sector_classification()=" + getSub_sector_classification()
				+ ", getGroup_name()=" + getGroup_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public RT_RWA_NonFund_base_data_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}