package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="BRF_TREASURY_SWD_TB")
@IdClass(RT_Treasury_swd_id_class.class)
public class RT_Treasury_swd_data_entity implements Serializable {
	
	
	private String	data_category;
	@Id
	private String	gl_code;
	private String	portfolio;
	private String	instrument;
	private String	isin_number;
	@Id
	private String	security_id;
	private String	security_description;
	private Date	maturity_date;
	private String	issuer_id;
	private String	cpn_rate;
	private String	cpn_freq;
	private String	basis;
	private BigDecimal	no_of_securities;
	@Id
	private String	curr;
	private BigDecimal	fv_per_sec;
	private BigDecimal	face_value;
	private BigDecimal	book_value;
	private BigDecimal	curr_mkt_rate;
	private Date	curr_rate_date;
	private BigDecimal	market_value;
	private BigDecimal	app_dep_prov;
	private BigDecimal	accrued_interest;
	private BigDecimal	asset_class;
	private String	asset_class_description;
	private Date	date_of_npi;
	private BigDecimal	provision_amt;
	private String	issuer_group;
	private Date	opt_start_date;
	private Date	opt_end_date;
	private String	pan_no;
	private String	option_type;
	private String	issuer_country_id;
	private String	issuer_country_name;
	private String	group_name;
	private String	level_no;
	private BigDecimal	amort_prem;
	private BigDecimal	mtm_reserve;
	private BigDecimal	deal_value;
	private String	sector_code;
	@Id
	private Date	report_date;
	private String	del_flg;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
	private Date	verify_time;
	public String getData_category() {
		return data_category;
	}
	public void setData_category(String data_category) {
		this.data_category = data_category;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getIsin_number() {
		return isin_number;
	}
	public void setIsin_number(String isin_number) {
		this.isin_number = isin_number;
	}
	public String getSecurity_id() {
		return security_id;
	}
	public void setSecurity_id(String security_id) {
		this.security_id = security_id;
	}
	public String getSecurity_description() {
		return security_description;
	}
	public void setSecurity_description(String security_description) {
		this.security_description = security_description;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(String issuer_id) {
		this.issuer_id = issuer_id;
	}
	public String getCpn_rate() {
		return cpn_rate;
	}
	public void setCpn_rate(String cpn_rate) {
		this.cpn_rate = cpn_rate;
	}
	public String getCpn_freq() {
		return cpn_freq;
	}
	public void setCpn_freq(String cpn_freq) {
		this.cpn_freq = cpn_freq;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public BigDecimal getNo_of_securities() {
		return no_of_securities;
	}
	public void setNo_of_securities(BigDecimal no_of_securities) {
		this.no_of_securities = no_of_securities;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public BigDecimal getFv_per_sec() {
		return fv_per_sec;
	}
	public void setFv_per_sec(BigDecimal fv_per_sec) {
		this.fv_per_sec = fv_per_sec;
	}
	public BigDecimal getFace_value() {
		return face_value;
	}
	public void setFace_value(BigDecimal face_value) {
		this.face_value = face_value;
	}
	public BigDecimal getBook_value() {
		return book_value;
	}
	public void setBook_value(BigDecimal book_value) {
		this.book_value = book_value;
	}
	public BigDecimal getCurr_mkt_rate() {
		return curr_mkt_rate;
	}
	public void setCurr_mkt_rate(BigDecimal curr_mkt_rate) {
		this.curr_mkt_rate = curr_mkt_rate;
	}
	public Date getCurr_rate_date() {
		return curr_rate_date;
	}
	public void setCurr_rate_date(Date curr_rate_date) {
		this.curr_rate_date = curr_rate_date;
	}
	public BigDecimal getMarket_value() {
		return market_value;
	}
	public void setMarket_value(BigDecimal market_value) {
		this.market_value = market_value;
	}
	public BigDecimal getApp_dep_prov() {
		return app_dep_prov;
	}
	public void setApp_dep_prov(BigDecimal app_dep_prov) {
		this.app_dep_prov = app_dep_prov;
	}
	public BigDecimal getAccrued_interest() {
		return accrued_interest;
	}
	public void setAccrued_interest(BigDecimal accrued_interest) {
		this.accrued_interest = accrued_interest;
	}
	public BigDecimal getAsset_class() {
		return asset_class;
	}
	public void setAsset_class(BigDecimal asset_class) {
		this.asset_class = asset_class;
	}
	public String getAsset_class_description() {
		return asset_class_description;
	}
	public void setAsset_class_description(String asset_class_description) {
		this.asset_class_description = asset_class_description;
	}
	public Date getDate_of_npi() {
		return date_of_npi;
	}
	public void setDate_of_npi(Date date_of_npi) {
		this.date_of_npi = date_of_npi;
	}
	public BigDecimal getProvision_amt() {
		return provision_amt;
	}
	public void setProvision_amt(BigDecimal provision_amt) {
		this.provision_amt = provision_amt;
	}
	public String getIssuer_group() {
		return issuer_group;
	}
	public void setIssuer_group(String issuer_group) {
		this.issuer_group = issuer_group;
	}
	public Date getOpt_start_date() {
		return opt_start_date;
	}
	public void setOpt_start_date(Date opt_start_date) {
		this.opt_start_date = opt_start_date;
	}
	public Date getOpt_end_date() {
		return opt_end_date;
	}
	public void setOpt_end_date(Date opt_end_date) {
		this.opt_end_date = opt_end_date;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getOption_type() {
		return option_type;
	}
	public void setOption_type(String option_type) {
		this.option_type = option_type;
	}
	public String getIssuer_country_id() {
		return issuer_country_id;
	}
	public void setIssuer_country_id(String issuer_country_id) {
		this.issuer_country_id = issuer_country_id;
	}
	public String getIssuer_country_name() {
		return issuer_country_name;
	}
	public void setIssuer_country_name(String issuer_country_name) {
		this.issuer_country_name = issuer_country_name;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getLevel_no() {
		return level_no;
	}
	public void setLevel_no(String level_no) {
		this.level_no = level_no;
	}
	public BigDecimal getAmort_prem() {
		return amort_prem;
	}
	public void setAmort_prem(BigDecimal amort_prem) {
		this.amort_prem = amort_prem;
	}
	public BigDecimal getMtm_reserve() {
		return mtm_reserve;
	}
	public void setMtm_reserve(BigDecimal mtm_reserve) {
		this.mtm_reserve = mtm_reserve;
	}
	public BigDecimal getDeal_value() {
		return deal_value;
	}
	public void setDeal_value(BigDecimal deal_value) {
		this.deal_value = deal_value;
	}
	public String getSector_code() {
		return sector_code;
	}
	public void setSector_code(String sector_code) {
		this.sector_code = sector_code;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getVerify_user_id() {
		return verify_user_id;
	}
	public void setVerify_user_id(String verify_user_id) {
		this.verify_user_id = verify_user_id;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	@Override
	public String toString() {
		return "RT_Treasury_swd_data_entity [data_category=" + data_category + ", gl_code=" + gl_code + ", portfolio="
				+ portfolio + ", instrument=" + instrument + ", isin_number=" + isin_number + ", security_id="
				+ security_id + ", security_description=" + security_description + ", maturity_date=" + maturity_date
				+ ", issuer_id=" + issuer_id + ", cpn_rate=" + cpn_rate + ", cpn_freq=" + cpn_freq + ", basis=" + basis
				+ ", no_of_securities=" + no_of_securities + ", curr=" + curr + ", fv_per_sec=" + fv_per_sec
				+ ", face_value=" + face_value + ", book_value=" + book_value + ", curr_mkt_rate=" + curr_mkt_rate
				+ ", curr_rate_date=" + curr_rate_date + ", market_value=" + market_value + ", app_dep_prov="
				+ app_dep_prov + ", accrued_interest=" + accrued_interest + ", asset_class=" + asset_class
				+ ", asset_class_description=" + asset_class_description + ", date_of_npi=" + date_of_npi
				+ ", provision_amt=" + provision_amt + ", issuer_group=" + issuer_group + ", opt_start_date="
				+ opt_start_date + ", opt_end_date=" + opt_end_date + ", pan_no=" + pan_no + ", option_type="
				+ option_type + ", issuer_country_id=" + issuer_country_id + ", issuer_country_name="
				+ issuer_country_name + ", group_name=" + group_name + ", level_no=" + level_no + ", amort_prem="
				+ amort_prem + ", mtm_reserve=" + mtm_reserve + ", deal_value=" + deal_value + ", sector_code="
				+ sector_code + ", report_date=" + report_date + ", del_flg=" + del_flg + ", rcre_user_id="
				+ rcre_user_id + ", rcre_time=" + rcre_time + ", lchg_user_id=" + lchg_user_id + ", lchg_time="
				+ lchg_time + ", verify_user_id=" + verify_user_id + ", verify_time=" + verify_time + "]";
	}
	public RT_Treasury_swd_data_entity(String data_category, String gl_code, String portfolio, String instrument,
			String isin_number, String security_id, String security_description, Date maturity_date, String issuer_id,
			String cpn_rate, String cpn_freq, String basis, BigDecimal no_of_securities, String curr,
			BigDecimal fv_per_sec, BigDecimal face_value, BigDecimal book_value, BigDecimal curr_mkt_rate,
			Date curr_rate_date, BigDecimal market_value, BigDecimal app_dep_prov, BigDecimal accrued_interest,
			BigDecimal asset_class, String asset_class_description, Date date_of_npi, BigDecimal provision_amt,
			String issuer_group, Date opt_start_date, Date opt_end_date, String pan_no, String option_type,
			String issuer_country_id, String issuer_country_name, String group_name, String level_no,
			BigDecimal amort_prem, BigDecimal mtm_reserve, BigDecimal deal_value, String sector_code, Date report_date,
			String del_flg, String rcre_user_id, Date rcre_time, String lchg_user_id, Date lchg_time,
			String verify_user_id, Date verify_time) {
		super();
		this.data_category = data_category;
		this.gl_code = gl_code;
		this.portfolio = portfolio;
		this.instrument = instrument;
		this.isin_number = isin_number;
		this.security_id = security_id;
		this.security_description = security_description;
		this.maturity_date = maturity_date;
		this.issuer_id = issuer_id;
		this.cpn_rate = cpn_rate;
		this.cpn_freq = cpn_freq;
		this.basis = basis;
		this.no_of_securities = no_of_securities;
		this.curr = curr;
		this.fv_per_sec = fv_per_sec;
		this.face_value = face_value;
		this.book_value = book_value;
		this.curr_mkt_rate = curr_mkt_rate;
		this.curr_rate_date = curr_rate_date;
		this.market_value = market_value;
		this.app_dep_prov = app_dep_prov;
		this.accrued_interest = accrued_interest;
		this.asset_class = asset_class;
		this.asset_class_description = asset_class_description;
		this.date_of_npi = date_of_npi;
		this.provision_amt = provision_amt;
		this.issuer_group = issuer_group;
		this.opt_start_date = opt_start_date;
		this.opt_end_date = opt_end_date;
		this.pan_no = pan_no;
		this.option_type = option_type;
		this.issuer_country_id = issuer_country_id;
		this.issuer_country_name = issuer_country_name;
		this.group_name = group_name;
		this.level_no = level_no;
		this.amort_prem = amort_prem;
		this.mtm_reserve = mtm_reserve;
		this.deal_value = deal_value;
		this.sector_code = sector_code;
		this.report_date = report_date;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
	}
	public RT_Treasury_swd_data_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
