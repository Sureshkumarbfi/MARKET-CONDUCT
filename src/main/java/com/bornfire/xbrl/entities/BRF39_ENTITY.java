package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF39_SUMMARYTABLE")
public class BRF39_ENTITY {
	private BigDecimal capital_case;
	private String name_of_borrower;
	private String cin;
	private String borrower_type;
	private String group_name;
	private String residency_status;
	private String country_incorporated;
	private String credit_rating;
	private String credit_rating_type;
	private String economic_status;
	private String currency;
	private BigDecimal funded_os;
	private BigDecimal credit_risk;
	private BigDecimal debt_securities;
	private BigDecimal equities;
	private BigDecimal unfunded_os;
	private BigDecimal ccf_equivalent_of_unfunded_os;
	private BigDecimal ccf_equivalent_limits;
	private BigDecimal total_exposure_without_credit_risk;
	private BigDecimal total_exposure_net;
	private BigDecimal tier_1_capital_without_credit_risk;
	private BigDecimal tier_1_capital_without_net;
	@Id
	private String row_label;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

	public BigDecimal getCapital_case() {
		return capital_case;
	}

	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}

	public String getName_of_borrower() {
		return name_of_borrower;
	}

	public void setName_of_borrower(String name_of_borrower) {
		this.name_of_borrower = name_of_borrower;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getBorrower_type() {
		return borrower_type;
	}

	public void setBorrower_type(String borrower_type) {
		this.borrower_type = borrower_type;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getResidency_status() {
		return residency_status;
	}

	public void setResidency_status(String residency_status) {
		this.residency_status = residency_status;
	}

	public String getCountry_incorporated() {
		return country_incorporated;
	}

	public void setCountry_incorporated(String country_incorporated) {
		this.country_incorporated = country_incorporated;
	}

	public String getCredit_rating() {
		return credit_rating;
	}

	public void setCredit_rating(String credit_rating) {
		this.credit_rating = credit_rating;
	}

	public String getCredit_rating_type() {
		return credit_rating_type;
	}

	public void setCredit_rating_type(String credit_rating_type) {
		this.credit_rating_type = credit_rating_type;
	}

	public String getEconomic_status() {
		return economic_status;
	}

	public void setEconomic_status(String economic_status) {
		this.economic_status = economic_status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getFunded_os() {
		return funded_os;
	}

	public void setFunded_os(BigDecimal funded_os) {
		this.funded_os = funded_os;
	}

	public BigDecimal getCredit_risk() {
		return credit_risk;
	}

	public void setCredit_risk(BigDecimal credit_risk) {
		this.credit_risk = credit_risk;
	}

	public BigDecimal getDebt_securities() {
		return debt_securities;
	}

	public void setDebt_securities(BigDecimal debt_securities) {
		this.debt_securities = debt_securities;
	}

	public BigDecimal getEquities() {
		return equities;
	}

	public void setEquities(BigDecimal equities) {
		this.equities = equities;
	}

	public BigDecimal getUnfunded_os() {
		return unfunded_os;
	}

	public void setUnfunded_os(BigDecimal unfunded_os) {
		this.unfunded_os = unfunded_os;
	}

	public BigDecimal getCcf_equivalent_of_unfunded_os() {
		return ccf_equivalent_of_unfunded_os;
	}

	public void setCcf_equivalent_of_unfunded_os(BigDecimal ccf_equivalent_of_unfunded_os) {
		this.ccf_equivalent_of_unfunded_os = ccf_equivalent_of_unfunded_os;
	}

	public BigDecimal getCcf_equivalent_limits() {
		return ccf_equivalent_limits;
	}

	public void setCcf_equivalent_limits(BigDecimal ccf_equivalent_limits) {
		this.ccf_equivalent_limits = ccf_equivalent_limits;
	}

	public BigDecimal getTotal_exposure_without_credit_risk() {
		return total_exposure_without_credit_risk;
	}

	public void setTotal_exposure_without_credit_risk(BigDecimal total_exposure_without_credit_risk) {
		this.total_exposure_without_credit_risk = total_exposure_without_credit_risk;
	}

	public BigDecimal getTotal_exposure_net() {
		return total_exposure_net;
	}

	public void setTotal_exposure_net(BigDecimal total_exposure_net) {
		this.total_exposure_net = total_exposure_net;
	}

	public BigDecimal getTier_1_capital_without_credit_risk() {
		return tier_1_capital_without_credit_risk;
	}

	public void setTier_1_capital_without_credit_risk(BigDecimal tier_1_capital_without_credit_risk) {
		this.tier_1_capital_without_credit_risk = tier_1_capital_without_credit_risk;
	}

	public BigDecimal getTier_1_capital_without_net() {
		return tier_1_capital_without_net;
	}

	public void setTier_1_capital_without_net(BigDecimal tier_1_capital_without_net) {
		this.tier_1_capital_without_net = tier_1_capital_without_net;
	}

	public String getRow_label() {
		return row_label;
	}

	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF39_ENTITY(BigDecimal capital_case, String name_of_borrower, String cin, String borrower_type,
			String group_name, String residency_status, String country_incorporated, String credit_rating,
			String credit_rating_type, String economic_status, String currency, BigDecimal funded_os,
			BigDecimal credit_risk, BigDecimal debt_securities, BigDecimal equities, BigDecimal unfunded_os,
			BigDecimal ccf_equivalent_of_unfunded_os, BigDecimal ccf_equivalent_limits,
			BigDecimal total_exposure_without_credit_risk, BigDecimal total_exposure_net,
			BigDecimal tier_1_capital_without_credit_risk, BigDecimal tier_1_capital_without_net, String row_label,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code, Date report_submit_date, String repdesc, String frequency) {
		super();
		this.capital_case = capital_case;
		this.name_of_borrower = name_of_borrower;
		this.cin = cin;
		this.borrower_type = borrower_type;
		this.group_name = group_name;
		this.residency_status = residency_status;
		this.country_incorporated = country_incorporated;
		this.credit_rating = credit_rating;
		this.credit_rating_type = credit_rating_type;
		this.economic_status = economic_status;
		this.currency = currency;
		this.funded_os = funded_os;
		this.credit_risk = credit_risk;
		this.debt_securities = debt_securities;
		this.equities = equities;
		this.unfunded_os = unfunded_os;
		this.ccf_equivalent_of_unfunded_os = ccf_equivalent_of_unfunded_os;
		this.ccf_equivalent_limits = ccf_equivalent_limits;
		this.total_exposure_without_credit_risk = total_exposure_without_credit_risk;
		this.total_exposure_net = total_exposure_net;
		this.tier_1_capital_without_credit_risk = tier_1_capital_without_credit_risk;
		this.tier_1_capital_without_net = tier_1_capital_without_net;
		this.row_label = row_label;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF39_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}