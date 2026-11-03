package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIS_BANK_LIMITS")
public class BankLimit_Entity {
	@Id
	@Column(name = "S_NO")
	private String s_no;

	@Column(name = "TERRITORY_NAME")
	private String territory_name;

	@Column(name = "BANK_NAME")
	private String bank_name;

	@Column(name = "COUNTRY_OF_ORIGIN")
	private String country_of_origin;

	@Column(name = "RATING")
	private String rating;

	@Column(name = "REG_LIMIT")
	private BigDecimal reg_limit;

	@Column(name = "ADHOC_LIMIT")
	private BigDecimal adhoc_limit;

	@Column(name = "TOTAL_LIMIT")
	private BigDecimal total_limit;

	@Column(name = "TOTAL_EXPOSURE")
	private BigDecimal total_exposure;

	@Column(name = "CREDIT_LIMIT")
	private BigDecimal credit_limit;

	@Column(name = "CREDIT_EXPOSURE")
	private BigDecimal credit_exposure;

	@Column(name = "SETTLEMENT_LIMIT")
	private BigDecimal settlement_limit;

	@Column(name = "SETTLEMENT_EXPOSURE")
	private BigDecimal settlement_exposure;

	@Column(name = "MONEY_MARKET_LIMIT")
	private BigDecimal money_market_limit;

	@Column(name = "MONEY_MARKET_EXPOSURE")
	private BigDecimal money_market_exposure;

	@Column(name = "TRADE_FINANCE_LIMITS")
	private BigDecimal trade_finance_limits;

	@Column(name = "TF_LIMITS_AVLBLE")
	private BigDecimal tf_limits_avlble;

	@Column(name = "TRADE_FINANCE_EXPOSURE")
	private BigDecimal trade_finance_exposure;

	@Column(name = "FX_EXPOSURE")
	private BigDecimal fx_exposure;

	@Column(name = "CHECK_FOR_TOTAL_LIMIT")
	private BigDecimal check_for_total_limit;

	@Column(name = "EXPOSURE_TO_CAPITAL")
	private BigDecimal exposure_to_capital;

	@Column(name = "CREDIT_LIMIT_CHECK")
	private BigDecimal credit_limit_check;

	@Column(name = "MONEY_MARKET_LIMIT_CHECK")
	private BigDecimal money_market_limit_check;

	@Column(name = "SETTLEMENT_LIMIT_CHECK")
	private BigDecimal settlement_limit_check;

	@Column(name = "TF_LIMIT_CHECK")
	private BigDecimal tf_limit_check;

	@Column(name = "LIMIT_UTILIZATION")
	private String limit_utilization;

	@Column(name = "CREATE_USER")
	private String create_user;

	@Column(name = "CREATE_TIME")
	private Date create_time;

	@Column(name = "MODIFY_USER")
	private String modify_user;

	@Column(name = "MODIFY_TIME")
	private Date modify_time;

	@Column(name = "VERIFY_USER")
	private String verify_user;

	@Column(name = "VERIFY_TIME")
	private Date verify_time;

	@Column(name = "ENTITY_FLG")
	private String entity_flg;

	@Column(name = "MODIFY_FLG")
	private String modify_flg;

	@Column(name = "REPORT_DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date report_date;

	@Column(name = "BRANCH_CODE")
	private String branch_code;

	@Column(name = "BRANCH_NAME")
	private String branch_name;

	public String getS_no() {
		return s_no;
	}

	public String getTerritory_name() {
		return territory_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public String getCountry_of_origin() {
		return country_of_origin;
	}

	public String getRating() {
		return rating;
	}

	public BigDecimal getReg_limit() {
		return reg_limit;
	}

	public BigDecimal getAdhoc_limit() {
		return adhoc_limit;
	}

	public BigDecimal getTotal_limit() {
		return total_limit;
	}

	public BigDecimal getTotal_exposure() {
		return total_exposure;
	}

	public BigDecimal getCredit_limit() {
		return credit_limit;
	}

	public BigDecimal getCredit_exposure() {
		return credit_exposure;
	}

	public BigDecimal getSettlement_limit() {
		return settlement_limit;
	}

	public BigDecimal getSettlement_exposure() {
		return settlement_exposure;
	}

	public BigDecimal getMoney_market_limit() {
		return money_market_limit;
	}

	public BigDecimal getMoney_market_exposure() {
		return money_market_exposure;
	}

	public BigDecimal getTrade_finance_limits() {
		return trade_finance_limits;
	}

	public BigDecimal getTf_limits_avlble() {
		return tf_limits_avlble;
	}

	public BigDecimal getTrade_finance_exposure() {
		return trade_finance_exposure;
	}

	public BigDecimal getFx_exposure() {
		return fx_exposure;
	}

	public BigDecimal getCheck_for_total_limit() {
		return check_for_total_limit;
	}

	public BigDecimal getExposure_to_capital() {
		return exposure_to_capital;
	}

	public BigDecimal getCredit_limit_check() {
		return credit_limit_check;
	}

	public BigDecimal getMoney_market_limit_check() {
		return money_market_limit_check;
	}

	public BigDecimal getSettlement_limit_check() {
		return settlement_limit_check;
	}

	public BigDecimal getTf_limit_check() {
		return tf_limit_check;
	}

	public String getLimit_utilization() {
		return limit_utilization;
	}

	public String getCreate_user() {
		return create_user;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public Date getReport_date() {
		return report_date;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public void setTerritory_name(String territory_name) {
		this.territory_name = territory_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public void setCountry_of_origin(String country_of_origin) {
		this.country_of_origin = country_of_origin;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setReg_limit(BigDecimal reg_limit) {
		this.reg_limit = reg_limit;
	}

	public void setAdhoc_limit(BigDecimal adhoc_limit) {
		this.adhoc_limit = adhoc_limit;
	}

	public void setTotal_limit(BigDecimal total_limit) {
		this.total_limit = total_limit;
	}

	public void setTotal_exposure(BigDecimal total_exposure) {
		this.total_exposure = total_exposure;
	}

	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}

	public void setCredit_exposure(BigDecimal credit_exposure) {
		this.credit_exposure = credit_exposure;
	}

	public void setSettlement_limit(BigDecimal settlement_limit) {
		this.settlement_limit = settlement_limit;
	}

	public void setSettlement_exposure(BigDecimal settlement_exposure) {
		this.settlement_exposure = settlement_exposure;
	}

	public void setMoney_market_limit(BigDecimal money_market_limit) {
		this.money_market_limit = money_market_limit;
	}

	public void setMoney_market_exposure(BigDecimal money_market_exposure) {
		this.money_market_exposure = money_market_exposure;
	}

	public void setTrade_finance_limits(BigDecimal trade_finance_limits) {
		this.trade_finance_limits = trade_finance_limits;
	}

	public void setTf_limits_avlble(BigDecimal tf_limits_avlble) {
		this.tf_limits_avlble = tf_limits_avlble;
	}

	public void setTrade_finance_exposure(BigDecimal trade_finance_exposure) {
		this.trade_finance_exposure = trade_finance_exposure;
	}

	public void setFx_exposure(BigDecimal fx_exposure) {
		this.fx_exposure = fx_exposure;
	}

	public void setCheck_for_total_limit(BigDecimal check_for_total_limit) {
		this.check_for_total_limit = check_for_total_limit;
	}

	public void setExposure_to_capital(BigDecimal exposure_to_capital) {
		this.exposure_to_capital = exposure_to_capital;
	}

	public void setCredit_limit_check(BigDecimal credit_limit_check) {
		this.credit_limit_check = credit_limit_check;
	}

	public void setMoney_market_limit_check(BigDecimal money_market_limit_check) {
		this.money_market_limit_check = money_market_limit_check;
	}

	public void setSettlement_limit_check(BigDecimal settlement_limit_check) {
		this.settlement_limit_check = settlement_limit_check;
	}

	public void setTf_limit_check(BigDecimal tf_limit_check) {
		this.tf_limit_check = tf_limit_check;
	}

	public void setLimit_utilization(String limit_utilization) {
		this.limit_utilization = limit_utilization;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public BankLimit_Entity(String s_no, String territory_name, String bank_name, String country_of_origin,
			String rating, BigDecimal reg_limit, BigDecimal adhoc_limit, BigDecimal total_limit,
			BigDecimal total_exposure, BigDecimal credit_limit, BigDecimal credit_exposure, BigDecimal settlement_limit,
			BigDecimal settlement_exposure, BigDecimal money_market_limit, BigDecimal money_market_exposure,
			BigDecimal trade_finance_limits, BigDecimal tf_limits_avlble, BigDecimal trade_finance_exposure,
			BigDecimal fx_exposure, BigDecimal check_for_total_limit, BigDecimal exposure_to_capital,
			BigDecimal credit_limit_check, BigDecimal money_market_limit_check, BigDecimal settlement_limit_check,
			BigDecimal tf_limit_check, String limit_utilization, String create_user, Date create_time,
			String modify_user, Date modify_time, String verify_user, Date verify_time, String entity_flg,
			String modify_flg, Date report_date, String branch_code, String branch_name) {
		super();
		this.s_no = s_no;
		this.territory_name = territory_name;
		this.bank_name = bank_name;
		this.country_of_origin = country_of_origin;
		this.rating = rating;
		this.reg_limit = reg_limit;
		this.adhoc_limit = adhoc_limit;
		this.total_limit = total_limit;
		this.total_exposure = total_exposure;
		this.credit_limit = credit_limit;
		this.credit_exposure = credit_exposure;
		this.settlement_limit = settlement_limit;
		this.settlement_exposure = settlement_exposure;
		this.money_market_limit = money_market_limit;
		this.money_market_exposure = money_market_exposure;
		this.trade_finance_limits = trade_finance_limits;
		this.tf_limits_avlble = tf_limits_avlble;
		this.trade_finance_exposure = trade_finance_exposure;
		this.fx_exposure = fx_exposure;
		this.check_for_total_limit = check_for_total_limit;
		this.exposure_to_capital = exposure_to_capital;
		this.credit_limit_check = credit_limit_check;
		this.money_market_limit_check = money_market_limit_check;
		this.settlement_limit_check = settlement_limit_check;
		this.tf_limit_check = tf_limit_check;
		this.limit_utilization = limit_utilization;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.report_date = report_date;
		this.branch_code = branch_code;
		this.branch_name = branch_name;
	}

	public BankLimit_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
