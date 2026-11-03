package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(mc_mmreportid.class)
@Table(name = "BCBUAE_MM_DATA")
public class RT_MmData {
	
	
	private String SI_NO;
	
	private Date bank_date;

    private String bank_name;
    private String head_office_subsidiary;
    private String subsidiary;
    private String bank_symbol;
    private String conventional_islamic;
    private String local_foreign;
    private String cbuae_tiering;

    @Id
    private String deal_no;
    @Id
    private String customer_id;
    private String counterparty_name;
    private String final_rating_banks;
    private String final_rating_cbuae;
    private String country_of_risk;
    private String cbuae_geographical_zone;
    private String deal_type;

    private Date value_date;
    private Date maturity_date;
     private BigDecimal initial_maturity;
    private BigDecimal initial_maturity_rounded;
    private String initial_maturity_period;
    private BigDecimal residual_maturity;
    private BigDecimal residual_maturity_rounded;
    private String maturity_period;
    private String currency;
    private BigDecimal principal;
    private BigDecimal principal_aed;
    private String interest_profit_rate;
    private String fixed_rate;
    private String floating_rate;
    private String floating_rate_basis;
    private Date	report_submit_date;
    @Id
    private Date	report_date;
    private String	entity_flg;
    private String	modify_flg;
    private String	del_flg;
    private Date	report_from_date;
    private Date	report_to_date;
    private String	report_code;
    private String	entry_user;
    private String	modify_user;
    private String	verify_user;
    private Date	entry_time;
    private Date	modify_time;
	public String getSI_NO() {
		return SI_NO;
	}
	public void setSI_NO(String sI_NO) {
		SI_NO = sI_NO;
	}
	public Date getBank_date() {
		return bank_date;
	}
	public void setBank_date(Date bank_date) {
		this.bank_date = bank_date;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getHead_office_subsidiary() {
		return head_office_subsidiary;
	}
	public void setHead_office_subsidiary(String head_office_subsidiary) {
		this.head_office_subsidiary = head_office_subsidiary;
	}
	public String getSubsidiary() {
		return subsidiary;
	}
	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}
	public String getBank_symbol() {
		return bank_symbol;
	}
	public void setBank_symbol(String bank_symbol) {
		this.bank_symbol = bank_symbol;
	}
	public String getConventional_islamic() {
		return conventional_islamic;
	}
	public void setConventional_islamic(String conventional_islamic) {
		this.conventional_islamic = conventional_islamic;
	}
	public String getLocal_foreign() {
		return local_foreign;
	}
	public void setLocal_foreign(String local_foreign) {
		this.local_foreign = local_foreign;
	}
	public String getCbuae_tiering() {
		return cbuae_tiering;
	}
	public void setCbuae_tiering(String cbuae_tiering) {
		this.cbuae_tiering = cbuae_tiering;
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
	public String getCounterparty_name() {
		return counterparty_name;
	}
	public void setCounterparty_name(String counterparty_name) {
		this.counterparty_name = counterparty_name;
	}
	public String getFinal_rating_banks() {
		return final_rating_banks;
	}
	public void setFinal_rating_banks(String final_rating_banks) {
		this.final_rating_banks = final_rating_banks;
	}
	public String getFinal_rating_cbuae() {
		return final_rating_cbuae;
	}
	public void setFinal_rating_cbuae(String final_rating_cbuae) {
		this.final_rating_cbuae = final_rating_cbuae;
	}
	public String getCountry_of_risk() {
		return country_of_risk;
	}
	public void setCountry_of_risk(String country_of_risk) {
		this.country_of_risk = country_of_risk;
	}
	public String getCbuae_geographical_zone() {
		return cbuae_geographical_zone;
	}
	public void setCbuae_geographical_zone(String cbuae_geographical_zone) {
		this.cbuae_geographical_zone = cbuae_geographical_zone;
	}
	public String getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(String deal_type) {
		this.deal_type = deal_type;
	}
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public BigDecimal getInitial_maturity() {
		return initial_maturity;
	}
	public void setInitial_maturity(BigDecimal initial_maturity) {
		this.initial_maturity = initial_maturity;
	}
	public BigDecimal getInitial_maturity_rounded() {
		return initial_maturity_rounded;
	}
	public void setInitial_maturity_rounded(BigDecimal initial_maturity_rounded) {
		this.initial_maturity_rounded = initial_maturity_rounded;
	}
	public String getInitial_maturity_period() {
		return initial_maturity_period;
	}
	public void setInitial_maturity_period(String initial_maturity_period) {
		this.initial_maturity_period = initial_maturity_period;
	}
	public BigDecimal getResidual_maturity() {
		return residual_maturity;
	}
	public void setResidual_maturity(BigDecimal residual_maturity) {
		this.residual_maturity = residual_maturity;
	}
	public BigDecimal getResidual_maturity_rounded() {
		return residual_maturity_rounded;
	}
	public void setResidual_maturity_rounded(BigDecimal residual_maturity_rounded) {
		this.residual_maturity_rounded = residual_maturity_rounded;
	}
	public String getMaturity_period() {
		return maturity_period;
	}
	public void setMaturity_period(String maturity_period) {
		this.maturity_period = maturity_period;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public BigDecimal getPrincipal_aed() {
		return principal_aed;
	}
	public void setPrincipal_aed(BigDecimal principal_aed) {
		this.principal_aed = principal_aed;
	}
	public String getInterest_profit_rate() {
		return interest_profit_rate;
	}
	public void setInterest_profit_rate(String interest_profit_rate) {
		this.interest_profit_rate = interest_profit_rate;
	}
	public String getFixed_rate() {
		return fixed_rate;
	}
	public void setFixed_rate(String fixed_rate) {
		this.fixed_rate = fixed_rate;
	}
	public String getFloating_rate() {
		return floating_rate;
	}
	public void setFloating_rate(String floating_rate) {
		this.floating_rate = floating_rate;
	}
	public String getFloating_rate_basis() {
		return floating_rate_basis;
	}
	public void setFloating_rate_basis(String floating_rate_basis) {
		this.floating_rate_basis = floating_rate_basis;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public RT_MmData(String sI_NO, Date bank_date, String bank_name, String head_office_subsidiary, String subsidiary,
			String bank_symbol, String conventional_islamic, String local_foreign, String cbuae_tiering,
			String deal_no, String customer_id, String counterparty_name, String final_rating_banks,
			String final_rating_cbuae, String country_of_risk, String cbuae_geographical_zone, String deal_type,
			Date value_date, Date maturity_date, BigDecimal initial_maturity, BigDecimal initial_maturity_rounded,
			String initial_maturity_period, BigDecimal residual_maturity, BigDecimal residual_maturity_rounded,
			String maturity_period, String currency, BigDecimal principal, BigDecimal principal_aed,
			String interest_profit_rate, String fixed_rate, String floating_rate, String floating_rate_basis,
			Date report_submit_date, Date report_date, String entity_flg,
			String modify_flg, String del_flg, Date report_from_date, Date report_to_date, String report_code,
			String entry_user, String modify_user, String verify_user, Date entry_time, Date modify_time) {
		super();
		SI_NO = sI_NO;
		this.bank_date = bank_date;
		this.bank_name = bank_name;
		this.head_office_subsidiary = head_office_subsidiary;
		this.subsidiary = subsidiary;
		this.bank_symbol = bank_symbol;
		this.conventional_islamic = conventional_islamic;
		this.local_foreign = local_foreign;
		this.cbuae_tiering = cbuae_tiering;
		this.deal_no = deal_no;
		this.customer_id = customer_id;
		this.counterparty_name = counterparty_name;
		this.final_rating_banks = final_rating_banks;
		this.final_rating_cbuae = final_rating_cbuae;
		this.country_of_risk = country_of_risk;
		this.cbuae_geographical_zone = cbuae_geographical_zone;
		this.deal_type = deal_type;
		this.value_date = value_date;
		this.maturity_date = maturity_date;
		this.initial_maturity = initial_maturity;
		this.initial_maturity_rounded = initial_maturity_rounded;
		this.initial_maturity_period = initial_maturity_period;
		this.residual_maturity = residual_maturity;
		this.residual_maturity_rounded = residual_maturity_rounded;
		this.maturity_period = maturity_period;
		this.currency = currency;
		this.principal = principal;
		this.principal_aed = principal_aed;
		this.interest_profit_rate = interest_profit_rate;
		this.fixed_rate = fixed_rate;
		this.floating_rate = floating_rate;
		this.floating_rate_basis = floating_rate_basis;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
	}
	public RT_MmData() {
		super();
		// TODO Auto-generated constructor stub
	}


     
}
