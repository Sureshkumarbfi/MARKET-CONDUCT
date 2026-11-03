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
@Table(name="BRF40B_SUMMARYTABLE")
public class BRF40_Entity2 {
	private String	r42_asset_classes;
	private BigDecimal	r42_outstanding_balance;
	private BigDecimal	r42_provision_suspense;
	private BigDecimal	r42_stage3_provision;
	private BigDecimal	r42_other_alloate;
	private BigDecimal	r42_1_asset;
	private BigDecimal	r42_2_asset;
	private BigDecimal	r42_3a_asset;
	private BigDecimal	r42_3b_asset;
	private BigDecimal	r42_3c_asset;
	private BigDecimal	r42_1_provision;
	private BigDecimal	r42_2_provision;
	private BigDecimal	r42_3a_provision;
	private BigDecimal	r42_3b_provision;
	private BigDecimal	r42_3c_provision;
	private BigDecimal	r42_current;
	private BigDecimal	r42_lessthan_30;
	private BigDecimal	r42_exclusive_90days;
	private BigDecimal	r42_exclusive_120days;
	private BigDecimal	r42_exclusive_180days;
	private BigDecimal	r42_exclusive_over_180days;
	private BigDecimal	r42_total_past;
	private BigDecimal	r42_new_stage3;
	private BigDecimal	r42_new_specific;
	private BigDecimal	r42_new_other;
	private BigDecimal	r42_performing_accounts;
	private BigDecimal	r42_non_performing_accounts;
	private String	r42_outstanding_check;
	private String	r42_provision_check;
	private String	r42_past_due_date;
	private String	r43_asset_classes;
	private BigDecimal	r43_outstanding_balance;
	private BigDecimal	r43_provision_suspense;
	private BigDecimal	r43_stage3_provision;
	private BigDecimal	r43_other_alloate;
	private BigDecimal	r43_1_asset;
	private BigDecimal	r43_2_asset;
	private BigDecimal	r43_3a_asset;
	private BigDecimal	r43_3b_asset;
	private BigDecimal	r43_3c_asset;
	private BigDecimal	r43_1_provision;
	private BigDecimal	r43_2_provision;
	private BigDecimal	r43_3a_provision;
	private BigDecimal	r43_3b_provision;
	private BigDecimal	r43_3c_provision;
	private BigDecimal	r43_current;
	private BigDecimal	r43_lessthan_30;
	private BigDecimal	r43_exclusive_90days;
	private BigDecimal	r43_exclusive_120days;
	private BigDecimal	r43_exclusive_180days;
	private BigDecimal	r43_exclusive_over_180days;
	private BigDecimal	r43_total_past;
	private BigDecimal	r43_new_stage3;
	private BigDecimal	r43_new_specific;
	private BigDecimal	r43_new_other;
	private BigDecimal	r43_performing_accounts;
	private BigDecimal	r43_non_performing_accounts;
	private String	r43_outstanding_check;
	private String	r43_provision_check;
	private String	r43_past_due_date;
	private String	r44_asset_classes;
	private BigDecimal	r44_outstanding_balance;
	private BigDecimal	r44_provision_suspense;
	private BigDecimal	r44_stage3_provision;
	private BigDecimal	r44_other_alloate;
	private BigDecimal	r44_1_asset;
	private BigDecimal	r44_2_asset;
	private BigDecimal	r44_3a_asset;
	private BigDecimal	r44_3b_asset;
	private BigDecimal	r44_3c_asset;
	private BigDecimal	r44_1_provision;
	private BigDecimal	r44_2_provision;
	private BigDecimal	r44_3a_provision;
	private BigDecimal	r44_3b_provision;
	private BigDecimal	r44_3c_provision;
	private BigDecimal	r44_current;
	private BigDecimal	r44_lessthan_30;
	private BigDecimal	r44_exclusive_90days;
	private BigDecimal	r44_exclusive_120days;
	private BigDecimal	r44_exclusive_180days;
	private BigDecimal	r44_exclusive_over_180days;
	private BigDecimal	r44_total_past;
	private BigDecimal	r44_new_stage3;
	private BigDecimal	r44_new_specific;
	private BigDecimal	r44_new_other;
	private BigDecimal	r44_performing_accounts;
	private BigDecimal	r44_non_performing_accounts;
	private String	r44_outstanding_check;
	private String	r44_provision_check;
	private String	r44_past_due_date;
	private String	r45_asset_classes;
	private BigDecimal	r45_outstanding_balance;
	private BigDecimal	r45_provision_suspense;
	private BigDecimal	r45_stage3_provision;
	private BigDecimal	r45_other_alloate;
	private BigDecimal	r45_1_asset;
	private BigDecimal	r45_2_asset;
	private BigDecimal	r45_3a_asset;
	private BigDecimal	r45_3b_asset;
	private BigDecimal	r45_3c_asset;
	private BigDecimal	r45_1_provision;
	private BigDecimal	r45_2_provision;
	private BigDecimal	r45_3a_provision;
	private BigDecimal	r45_3b_provision;
	private BigDecimal	r45_3c_provision;
	private BigDecimal	r45_current;
	private BigDecimal	r45_lessthan_30;
	private BigDecimal	r45_exclusive_90days;
	private BigDecimal	r45_exclusive_120days;
	private BigDecimal	r45_exclusive_180days;
	private BigDecimal	r45_exclusive_over_180days;
	private BigDecimal	r45_total_past;
	private BigDecimal	r45_new_stage3;
	private BigDecimal	r45_new_specific;
	private BigDecimal	r45_new_other;
	private BigDecimal	r45_performing_accounts;
	private BigDecimal	r45_non_performing_accounts;
	private String	r45_outstanding_check;
	private String	r45_provision_check;
	private String	r45_past_due_date;
	private String	r46_asset_classes;
	private BigDecimal	r46_outstanding_balance;
	private BigDecimal	r46_provision_suspense;
	private BigDecimal	r46_stage3_provision;
	private BigDecimal	r46_other_alloate;
	private BigDecimal	r46_1_asset;
	private BigDecimal	r46_2_asset;
	private BigDecimal	r46_3a_asset;
	private BigDecimal	r46_3b_asset;
	private BigDecimal	r46_3c_asset;
	private BigDecimal	r46_1_provision;
	private BigDecimal	r46_2_provision;
	private BigDecimal	r46_3a_provision;
	private BigDecimal	r46_3b_provision;
	private BigDecimal	r46_3c_provision;
	private BigDecimal	r46_current;
	private BigDecimal	r46_lessthan_30;
	private BigDecimal	r46_exclusive_90days;
	private BigDecimal	r46_exclusive_120days;
	private BigDecimal	r46_exclusive_180days;
	private BigDecimal	r46_exclusive_over_180days;
	private BigDecimal	r46_total_past;
	private BigDecimal	r46_new_stage3;
	private BigDecimal	r46_new_specific;
	private BigDecimal	r46_new_other;
	private BigDecimal	r46_performing_accounts;
	private BigDecimal	r46_non_performing_accounts;
	private String	r46_outstanding_check;
	private String	r46_provision_check;
	private String	r46_past_due_date;
	private String	r47_asset_classes;
	private BigDecimal	r47_outstanding_balance;
	private BigDecimal	r47_provision_suspense;
	private BigDecimal	r47_stage3_provision;
	private BigDecimal	r47_other_alloate;
	private BigDecimal	r47_1_asset;
	private BigDecimal	r47_2_asset;
	private BigDecimal	r47_3a_asset;
	private BigDecimal	r47_3b_asset;
	private BigDecimal	r47_3c_asset;
	private BigDecimal	r47_1_provision;
	private BigDecimal	r47_2_provision;
	private BigDecimal	r47_3a_provision;
	private BigDecimal	r47_3b_provision;
	private BigDecimal	r47_3c_provision;
	private BigDecimal	r47_current;
	private BigDecimal	r47_lessthan_30;
	private BigDecimal	r47_exclusive_90days;
	private BigDecimal	r47_exclusive_120days;
	private BigDecimal	r47_exclusive_180days;
	private BigDecimal	r47_exclusive_over_180days;
	private BigDecimal	r47_total_past;
	private BigDecimal	r47_new_stage3;
	private BigDecimal	r47_new_specific;
	private BigDecimal	r47_new_other;
	private BigDecimal	r47_performing_accounts;
	private BigDecimal	r47_non_performing_accounts;
	private String	r47_outstanding_check;
	private String	r47_provision_check;
	private String	r47_past_due_date;
	private String	r48_asset_classes;
	private BigDecimal	r48_outstanding_balance;
	private BigDecimal	r48_provision_suspense;
	private BigDecimal	r48_stage3_provision;
	private BigDecimal	r48_other_alloate;
	private BigDecimal	r48_1_asset;
	private BigDecimal	r48_2_asset;
	private BigDecimal	r48_3a_asset;
	private BigDecimal	r48_3b_asset;
	private BigDecimal	r48_3c_asset;
	private BigDecimal	r48_1_provision;
	private BigDecimal	r48_2_provision;
	private BigDecimal	r48_3a_provision;
	private BigDecimal	r48_3b_provision;
	private BigDecimal	r48_3c_provision;
	private BigDecimal	r48_current;
	private BigDecimal	r48_lessthan_30;
	private BigDecimal	r48_exclusive_90days;
	private BigDecimal	r48_exclusive_120days;
	private BigDecimal	r48_exclusive_180days;
	private BigDecimal	r48_exclusive_over_180days;
	private BigDecimal	r48_total_past;
	private BigDecimal	r48_new_stage3;
	private BigDecimal	r48_new_specific;
	private BigDecimal	r48_new_other;
	private BigDecimal	r48_performing_accounts;
	private BigDecimal	r48_non_performing_accounts;
	private String	r48_outstanding_check;
	private String	r48_provision_check;
	private String	r48_past_due_date;
	private String	r49_asset_classes;
	private BigDecimal	r49_outstanding_balance;
	private BigDecimal	r49_provision_suspense;
	private BigDecimal	r49_stage3_provision;
	private BigDecimal	r49_other_alloate;
	private BigDecimal	r49_1_asset;
	private BigDecimal	r49_2_asset;
	private BigDecimal	r49_3a_asset;
	private BigDecimal	r49_3b_asset;
	private BigDecimal	r49_3c_asset;
	private BigDecimal	r49_1_provision;
	private BigDecimal	r49_2_provision;
	private BigDecimal	r49_3a_provision;
	private BigDecimal	r49_3b_provision;
	private BigDecimal	r49_3c_provision;
	private BigDecimal	r49_current;
	private BigDecimal	r49_lessthan_30;
	private BigDecimal	r49_exclusive_90days;
	private BigDecimal	r49_exclusive_120days;
	private BigDecimal	r49_exclusive_180days;
	private BigDecimal	r49_exclusive_over_180days;
	private BigDecimal	r49_total_past;
	private BigDecimal	r49_new_stage3;
	private BigDecimal	r49_new_specific;
	private BigDecimal	r49_new_other;
	private BigDecimal	r49_performing_accounts;
	private BigDecimal	r49_non_performing_accounts;
	private String	r49_outstanding_check;
	private String	r49_provision_check;
	private String	r49_past_due_date;
	private String	r50_asset_classes;
	private BigDecimal	r50_outstanding_balance;
	private BigDecimal	r50_provision_suspense;
	private BigDecimal	r50_stage3_provision;
	private BigDecimal	r50_other_alloate;
	private BigDecimal	r50_1_asset;
	private BigDecimal	r50_2_asset;
	private BigDecimal	r50_3a_asset;
	private BigDecimal	r50_3b_asset;
	private BigDecimal	r50_3c_asset;
	private BigDecimal	r50_1_provision;
	private BigDecimal	r50_2_provision;
	private BigDecimal	r50_3a_provision;
	private BigDecimal	r50_3b_provision;
	private BigDecimal	r50_3c_provision;
	private BigDecimal	r50_current;
	private BigDecimal	r50_lessthan_30;
	private BigDecimal	r50_exclusive_90days;
	private BigDecimal	r50_exclusive_120days;
	private BigDecimal	r50_exclusive_180days;
	private BigDecimal	r50_exclusive_over_180days;
	private BigDecimal	r50_total_past;
	private BigDecimal	r50_new_stage3;
	private BigDecimal	r50_new_specific;
	private BigDecimal	r50_new_other;
	private BigDecimal	r50_performing_accounts;
	private BigDecimal	r50_non_performing_accounts;
	private String	r50_outstanding_check;
	private String	r50_provision_check;
	private String	r50_past_due_date;
	private String	r51_asset_classes;
	private BigDecimal	r51_outstanding_balance;
	private BigDecimal	r51_provision_suspense;
	private BigDecimal	r51_stage3_provision;
	private BigDecimal	r51_other_alloate;
	private BigDecimal	r51_1_asset;
	private BigDecimal	r51_2_asset;
	private BigDecimal	r51_3a_asset;
	private BigDecimal	r51_3b_asset;
	private BigDecimal	r51_3c_asset;
	private BigDecimal	r51_1_provision;
	private BigDecimal	r51_2_provision;
	private BigDecimal	r51_3a_provision;
	private BigDecimal	r51_3b_provision;
	private BigDecimal	r51_3c_provision;
	private BigDecimal	r51_current;
	private BigDecimal	r51_lessthan_30;
	private BigDecimal	r51_exclusive_90days;
	private BigDecimal	r51_exclusive_120days;
	private BigDecimal	r51_exclusive_180days;
	private BigDecimal	r51_exclusive_over_180days;
	private BigDecimal	r51_total_past;
	private BigDecimal	r51_new_stage3;
	private BigDecimal	r51_new_specific;
	private BigDecimal	r51_new_other;
	private BigDecimal	r51_performing_accounts;
	private BigDecimal	r51_non_performing_accounts;
	private String	r51_outstanding_check;
	private String	r51_provision_check;
	private String	r51_past_due_date;
	private String	r52_asset_classes;
	private BigDecimal	r52_outstanding_balance;
	private BigDecimal	r52_provision_suspense;
	private BigDecimal	r52_stage3_provision;
	private BigDecimal	r52_other_alloate;
	private BigDecimal	r52_1_asset;
	private BigDecimal	r52_2_asset;
	private BigDecimal	r52_3a_asset;
	private BigDecimal	r52_3b_asset;
	private BigDecimal	r52_3c_asset;
	private BigDecimal	r52_1_provision;
	private BigDecimal	r52_2_provision;
	private BigDecimal	r52_3a_provision;
	private BigDecimal	r52_3b_provision;
	private BigDecimal	r52_3c_provision;
	private BigDecimal	r52_current;
	private BigDecimal	r52_lessthan_30;
	private BigDecimal	r52_exclusive_90days;
	private BigDecimal	r52_exclusive_120days;
	private BigDecimal	r52_exclusive_180days;
	private BigDecimal	r52_exclusive_over_180days;
	private BigDecimal	r52_total_past;
	private BigDecimal	r52_new_stage3;
	private BigDecimal	r52_new_specific;
	private BigDecimal	r52_new_other;
	private BigDecimal	r52_performing_accounts;
	private BigDecimal	r52_non_performing_accounts;
	private String	r52_outstanding_check;
	private String	r52_provision_check;
	private String	r52_past_due_date;
	private String	r53_asset_classes;
	private BigDecimal	r53_outstanding_balance;
	private BigDecimal	r53_provision_suspense;
	private BigDecimal	r53_stage3_provision;
	private BigDecimal	r53_other_alloate;
	private BigDecimal	r53_1_asset;
	private BigDecimal	r53_2_asset;
	private BigDecimal	r53_3a_asset;
	private BigDecimal	r53_3b_asset;
	private BigDecimal	r53_3c_asset;
	private BigDecimal	r53_1_provision;
	private BigDecimal	r53_2_provision;
	private BigDecimal	r53_3a_provision;
	private BigDecimal	r53_3b_provision;
	private BigDecimal	r53_3c_provision;
	private BigDecimal	r53_current;
	private BigDecimal	r53_lessthan_30;
	private BigDecimal	r53_exclusive_90days;
	private BigDecimal	r53_exclusive_120days;
	private BigDecimal	r53_exclusive_180days;
	private BigDecimal	r53_exclusive_over_180days;
	private BigDecimal	r53_total_past;
	private BigDecimal	r53_new_stage3;
	private BigDecimal	r53_new_specific;
	private BigDecimal	r53_new_other;
	private BigDecimal	r53_performing_accounts;
	private BigDecimal	r53_non_performing_accounts;
	private String	r53_outstanding_check;
	private String	r53_provision_check;
	private String	r53_past_due_date;
	private String	r54_asset_classes;
	private BigDecimal	r54_outstanding_balance;
	private BigDecimal	r54_provision_suspense;
	private BigDecimal	r54_stage3_provision;
	private BigDecimal	r54_other_alloate;
	private BigDecimal	r54_1_asset;
	private BigDecimal	r54_2_asset;
	private BigDecimal	r54_3a_asset;
	private BigDecimal	r54_3b_asset;
	private BigDecimal	r54_3c_asset;
	private BigDecimal	r54_1_provision;
	private BigDecimal	r54_2_provision;
	private BigDecimal	r54_3a_provision;
	private BigDecimal	r54_3b_provision;
	private BigDecimal	r54_3c_provision;
	private BigDecimal	r54_current;
	private BigDecimal	r54_lessthan_30;
	private BigDecimal	r54_exclusive_90days;
	private BigDecimal	r54_exclusive_120days;
	private BigDecimal	r54_exclusive_180days;
	private BigDecimal	r54_exclusive_over_180days;
	private BigDecimal	r54_total_past;
	private BigDecimal	r54_new_stage3;
	private BigDecimal	r54_new_specific;
	private BigDecimal	r54_new_other;
	private BigDecimal	r54_performing_accounts;
	private BigDecimal	r54_non_performing_accounts;
	private String	r54_outstanding_check;
	private String	r54_provision_check;
	private String	r54_past_due_date;
	private String	r55_asset_classes;
	private String	r55_outstanding_balance;
	private String	r55_provision_suspense;
	private String	r55_stage3_provision;
	private String	r55_other_alloate;
	private String	r55_1_asset;
	private String	r55_2_asset;
	private String	r55_3a_asset;
	private String	r55_3b_asset;
	private String	r55_3c_asset;
	private String	r55_1_provision;
	private String	r55_2_provision;
	private String	r55_3a_provision;
	private String	r55_3b_provision;
	private String	r55_3c_provision;
	private String	r55_current;
	private String	r55_lessthan_30;
	private String	r55_exclusive_90days;
	private String	r55_exclusive_120days;
	private String	r55_exclusive_180days;
	private String	r55_exclusive_over_180days;
	private String	r55_total_past;
	private String	r55_new_stage3;
	private String	r55_new_specific;
	private String	r55_new_other;
	private String	r55_performing_accounts;
	private String	r55_non_performing_accounts;
	private String	r55_outstanding_check;
	private String	r55_provision_check;
	private String	r55_past_due_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private String	repdesc;
	private String	frequency;
	public String getR42_asset_classes() {
		return r42_asset_classes;
	}
	public void setR42_asset_classes(String r42_asset_classes) {
		this.r42_asset_classes = r42_asset_classes;
	}
	public BigDecimal getR42_outstanding_balance() {
		return r42_outstanding_balance;
	}
	public void setR42_outstanding_balance(BigDecimal r42_outstanding_balance) {
		this.r42_outstanding_balance = r42_outstanding_balance;
	}
	public BigDecimal getR42_provision_suspense() {
		return r42_provision_suspense;
	}
	public void setR42_provision_suspense(BigDecimal r42_provision_suspense) {
		this.r42_provision_suspense = r42_provision_suspense;
	}
	public BigDecimal getR42_stage3_provision() {
		return r42_stage3_provision;
	}
	public void setR42_stage3_provision(BigDecimal r42_stage3_provision) {
		this.r42_stage3_provision = r42_stage3_provision;
	}
	public BigDecimal getR42_other_alloate() {
		return r42_other_alloate;
	}
	public void setR42_other_alloate(BigDecimal r42_other_alloate) {
		this.r42_other_alloate = r42_other_alloate;
	}
	public BigDecimal getR42_1_asset() {
		return r42_1_asset;
	}
	public void setR42_1_asset(BigDecimal r42_1_asset) {
		this.r42_1_asset = r42_1_asset;
	}
	public BigDecimal getR42_2_asset() {
		return r42_2_asset;
	}
	public void setR42_2_asset(BigDecimal r42_2_asset) {
		this.r42_2_asset = r42_2_asset;
	}
	public BigDecimal getR42_3a_asset() {
		return r42_3a_asset;
	}
	public void setR42_3a_asset(BigDecimal r42_3a_asset) {
		this.r42_3a_asset = r42_3a_asset;
	}
	public BigDecimal getR42_3b_asset() {
		return r42_3b_asset;
	}
	public void setR42_3b_asset(BigDecimal r42_3b_asset) {
		this.r42_3b_asset = r42_3b_asset;
	}
	public BigDecimal getR42_3c_asset() {
		return r42_3c_asset;
	}
	public void setR42_3c_asset(BigDecimal r42_3c_asset) {
		this.r42_3c_asset = r42_3c_asset;
	}
	public BigDecimal getR42_1_provision() {
		return r42_1_provision;
	}
	public void setR42_1_provision(BigDecimal r42_1_provision) {
		this.r42_1_provision = r42_1_provision;
	}
	public BigDecimal getR42_2_provision() {
		return r42_2_provision;
	}
	public void setR42_2_provision(BigDecimal r42_2_provision) {
		this.r42_2_provision = r42_2_provision;
	}
	public BigDecimal getR42_3a_provision() {
		return r42_3a_provision;
	}
	public void setR42_3a_provision(BigDecimal r42_3a_provision) {
		this.r42_3a_provision = r42_3a_provision;
	}
	public BigDecimal getR42_3b_provision() {
		return r42_3b_provision;
	}
	public void setR42_3b_provision(BigDecimal r42_3b_provision) {
		this.r42_3b_provision = r42_3b_provision;
	}
	public BigDecimal getR42_3c_provision() {
		return r42_3c_provision;
	}
	public void setR42_3c_provision(BigDecimal r42_3c_provision) {
		this.r42_3c_provision = r42_3c_provision;
	}
	public BigDecimal getR42_current() {
		return r42_current;
	}
	public void setR42_current(BigDecimal r42_current) {
		this.r42_current = r42_current;
	}
	public BigDecimal getR42_lessthan_30() {
		return r42_lessthan_30;
	}
	public void setR42_lessthan_30(BigDecimal r42_lessthan_30) {
		this.r42_lessthan_30 = r42_lessthan_30;
	}
	public BigDecimal getR42_exclusive_90days() {
		return r42_exclusive_90days;
	}
	public void setR42_exclusive_90days(BigDecimal r42_exclusive_90days) {
		this.r42_exclusive_90days = r42_exclusive_90days;
	}
	public BigDecimal getR42_exclusive_120days() {
		return r42_exclusive_120days;
	}
	public void setR42_exclusive_120days(BigDecimal r42_exclusive_120days) {
		this.r42_exclusive_120days = r42_exclusive_120days;
	}
	public BigDecimal getR42_exclusive_180days() {
		return r42_exclusive_180days;
	}
	public void setR42_exclusive_180days(BigDecimal r42_exclusive_180days) {
		this.r42_exclusive_180days = r42_exclusive_180days;
	}
	public BigDecimal getR42_exclusive_over_180days() {
		return r42_exclusive_over_180days;
	}
	public void setR42_exclusive_over_180days(BigDecimal r42_exclusive_over_180days) {
		this.r42_exclusive_over_180days = r42_exclusive_over_180days;
	}
	public BigDecimal getR42_total_past() {
		return r42_total_past;
	}
	public void setR42_total_past(BigDecimal r42_total_past) {
		this.r42_total_past = r42_total_past;
	}
	public BigDecimal getR42_new_stage3() {
		return r42_new_stage3;
	}
	public void setR42_new_stage3(BigDecimal r42_new_stage3) {
		this.r42_new_stage3 = r42_new_stage3;
	}
	public BigDecimal getR42_new_specific() {
		return r42_new_specific;
	}
	public void setR42_new_specific(BigDecimal r42_new_specific) {
		this.r42_new_specific = r42_new_specific;
	}
	public BigDecimal getR42_new_other() {
		return r42_new_other;
	}
	public void setR42_new_other(BigDecimal r42_new_other) {
		this.r42_new_other = r42_new_other;
	}
	public BigDecimal getR42_performing_accounts() {
		return r42_performing_accounts;
	}
	public void setR42_performing_accounts(BigDecimal r42_performing_accounts) {
		this.r42_performing_accounts = r42_performing_accounts;
	}
	public BigDecimal getR42_non_performing_accounts() {
		return r42_non_performing_accounts;
	}
	public void setR42_non_performing_accounts(BigDecimal r42_non_performing_accounts) {
		this.r42_non_performing_accounts = r42_non_performing_accounts;
	}
	public String getR42_outstanding_check() {
		return r42_outstanding_check;
	}
	public void setR42_outstanding_check(String r42_outstanding_check) {
		this.r42_outstanding_check = r42_outstanding_check;
	}
	public String getR42_provision_check() {
		return r42_provision_check;
	}
	public void setR42_provision_check(String r42_provision_check) {
		this.r42_provision_check = r42_provision_check;
	}
	public String getR42_past_due_date() {
		return r42_past_due_date;
	}
	public void setR42_past_due_date(String r42_past_due_date) {
		this.r42_past_due_date = r42_past_due_date;
	}
	public String getR43_asset_classes() {
		return r43_asset_classes;
	}
	public void setR43_asset_classes(String r43_asset_classes) {
		this.r43_asset_classes = r43_asset_classes;
	}
	public BigDecimal getR43_outstanding_balance() {
		return r43_outstanding_balance;
	}
	public void setR43_outstanding_balance(BigDecimal r43_outstanding_balance) {
		this.r43_outstanding_balance = r43_outstanding_balance;
	}
	public BigDecimal getR43_provision_suspense() {
		return r43_provision_suspense;
	}
	public void setR43_provision_suspense(BigDecimal r43_provision_suspense) {
		this.r43_provision_suspense = r43_provision_suspense;
	}
	public BigDecimal getR43_stage3_provision() {
		return r43_stage3_provision;
	}
	public void setR43_stage3_provision(BigDecimal r43_stage3_provision) {
		this.r43_stage3_provision = r43_stage3_provision;
	}
	public BigDecimal getR43_other_alloate() {
		return r43_other_alloate;
	}
	public void setR43_other_alloate(BigDecimal r43_other_alloate) {
		this.r43_other_alloate = r43_other_alloate;
	}
	public BigDecimal getR43_1_asset() {
		return r43_1_asset;
	}
	public void setR43_1_asset(BigDecimal r43_1_asset) {
		this.r43_1_asset = r43_1_asset;
	}
	public BigDecimal getR43_2_asset() {
		return r43_2_asset;
	}
	public void setR43_2_asset(BigDecimal r43_2_asset) {
		this.r43_2_asset = r43_2_asset;
	}
	public BigDecimal getR43_3a_asset() {
		return r43_3a_asset;
	}
	public void setR43_3a_asset(BigDecimal r43_3a_asset) {
		this.r43_3a_asset = r43_3a_asset;
	}
	public BigDecimal getR43_3b_asset() {
		return r43_3b_asset;
	}
	public void setR43_3b_asset(BigDecimal r43_3b_asset) {
		this.r43_3b_asset = r43_3b_asset;
	}
	public BigDecimal getR43_3c_asset() {
		return r43_3c_asset;
	}
	public void setR43_3c_asset(BigDecimal r43_3c_asset) {
		this.r43_3c_asset = r43_3c_asset;
	}
	public BigDecimal getR43_1_provision() {
		return r43_1_provision;
	}
	public void setR43_1_provision(BigDecimal r43_1_provision) {
		this.r43_1_provision = r43_1_provision;
	}
	public BigDecimal getR43_2_provision() {
		return r43_2_provision;
	}
	public void setR43_2_provision(BigDecimal r43_2_provision) {
		this.r43_2_provision = r43_2_provision;
	}
	public BigDecimal getR43_3a_provision() {
		return r43_3a_provision;
	}
	public void setR43_3a_provision(BigDecimal r43_3a_provision) {
		this.r43_3a_provision = r43_3a_provision;
	}
	public BigDecimal getR43_3b_provision() {
		return r43_3b_provision;
	}
	public void setR43_3b_provision(BigDecimal r43_3b_provision) {
		this.r43_3b_provision = r43_3b_provision;
	}
	public BigDecimal getR43_3c_provision() {
		return r43_3c_provision;
	}
	public void setR43_3c_provision(BigDecimal r43_3c_provision) {
		this.r43_3c_provision = r43_3c_provision;
	}
	public BigDecimal getR43_current() {
		return r43_current;
	}
	public void setR43_current(BigDecimal r43_current) {
		this.r43_current = r43_current;
	}
	public BigDecimal getR43_lessthan_30() {
		return r43_lessthan_30;
	}
	public void setR43_lessthan_30(BigDecimal r43_lessthan_30) {
		this.r43_lessthan_30 = r43_lessthan_30;
	}
	public BigDecimal getR43_exclusive_90days() {
		return r43_exclusive_90days;
	}
	public void setR43_exclusive_90days(BigDecimal r43_exclusive_90days) {
		this.r43_exclusive_90days = r43_exclusive_90days;
	}
	public BigDecimal getR43_exclusive_120days() {
		return r43_exclusive_120days;
	}
	public void setR43_exclusive_120days(BigDecimal r43_exclusive_120days) {
		this.r43_exclusive_120days = r43_exclusive_120days;
	}
	public BigDecimal getR43_exclusive_180days() {
		return r43_exclusive_180days;
	}
	public void setR43_exclusive_180days(BigDecimal r43_exclusive_180days) {
		this.r43_exclusive_180days = r43_exclusive_180days;
	}
	public BigDecimal getR43_exclusive_over_180days() {
		return r43_exclusive_over_180days;
	}
	public void setR43_exclusive_over_180days(BigDecimal r43_exclusive_over_180days) {
		this.r43_exclusive_over_180days = r43_exclusive_over_180days;
	}
	public BigDecimal getR43_total_past() {
		return r43_total_past;
	}
	public void setR43_total_past(BigDecimal r43_total_past) {
		this.r43_total_past = r43_total_past;
	}
	public BigDecimal getR43_new_stage3() {
		return r43_new_stage3;
	}
	public void setR43_new_stage3(BigDecimal r43_new_stage3) {
		this.r43_new_stage3 = r43_new_stage3;
	}
	public BigDecimal getR43_new_specific() {
		return r43_new_specific;
	}
	public void setR43_new_specific(BigDecimal r43_new_specific) {
		this.r43_new_specific = r43_new_specific;
	}
	public BigDecimal getR43_new_other() {
		return r43_new_other;
	}
	public void setR43_new_other(BigDecimal r43_new_other) {
		this.r43_new_other = r43_new_other;
	}
	public BigDecimal getR43_performing_accounts() {
		return r43_performing_accounts;
	}
	public void setR43_performing_accounts(BigDecimal r43_performing_accounts) {
		this.r43_performing_accounts = r43_performing_accounts;
	}
	public BigDecimal getR43_non_performing_accounts() {
		return r43_non_performing_accounts;
	}
	public void setR43_non_performing_accounts(BigDecimal r43_non_performing_accounts) {
		this.r43_non_performing_accounts = r43_non_performing_accounts;
	}
	public String getR43_outstanding_check() {
		return r43_outstanding_check;
	}
	public void setR43_outstanding_check(String r43_outstanding_check) {
		this.r43_outstanding_check = r43_outstanding_check;
	}
	public String getR43_provision_check() {
		return r43_provision_check;
	}
	public void setR43_provision_check(String r43_provision_check) {
		this.r43_provision_check = r43_provision_check;
	}
	public String getR43_past_due_date() {
		return r43_past_due_date;
	}
	public void setR43_past_due_date(String r43_past_due_date) {
		this.r43_past_due_date = r43_past_due_date;
	}
	public String getR44_asset_classes() {
		return r44_asset_classes;
	}
	public void setR44_asset_classes(String r44_asset_classes) {
		this.r44_asset_classes = r44_asset_classes;
	}
	public BigDecimal getR44_outstanding_balance() {
		return r44_outstanding_balance;
	}
	public void setR44_outstanding_balance(BigDecimal r44_outstanding_balance) {
		this.r44_outstanding_balance = r44_outstanding_balance;
	}
	public BigDecimal getR44_provision_suspense() {
		return r44_provision_suspense;
	}
	public void setR44_provision_suspense(BigDecimal r44_provision_suspense) {
		this.r44_provision_suspense = r44_provision_suspense;
	}
	public BigDecimal getR44_stage3_provision() {
		return r44_stage3_provision;
	}
	public void setR44_stage3_provision(BigDecimal r44_stage3_provision) {
		this.r44_stage3_provision = r44_stage3_provision;
	}
	public BigDecimal getR44_other_alloate() {
		return r44_other_alloate;
	}
	public void setR44_other_alloate(BigDecimal r44_other_alloate) {
		this.r44_other_alloate = r44_other_alloate;
	}
	public BigDecimal getR44_1_asset() {
		return r44_1_asset;
	}
	public void setR44_1_asset(BigDecimal r44_1_asset) {
		this.r44_1_asset = r44_1_asset;
	}
	public BigDecimal getR44_2_asset() {
		return r44_2_asset;
	}
	public void setR44_2_asset(BigDecimal r44_2_asset) {
		this.r44_2_asset = r44_2_asset;
	}
	public BigDecimal getR44_3a_asset() {
		return r44_3a_asset;
	}
	public void setR44_3a_asset(BigDecimal r44_3a_asset) {
		this.r44_3a_asset = r44_3a_asset;
	}
	public BigDecimal getR44_3b_asset() {
		return r44_3b_asset;
	}
	public void setR44_3b_asset(BigDecimal r44_3b_asset) {
		this.r44_3b_asset = r44_3b_asset;
	}
	public BigDecimal getR44_3c_asset() {
		return r44_3c_asset;
	}
	public void setR44_3c_asset(BigDecimal r44_3c_asset) {
		this.r44_3c_asset = r44_3c_asset;
	}
	public BigDecimal getR44_1_provision() {
		return r44_1_provision;
	}
	public void setR44_1_provision(BigDecimal r44_1_provision) {
		this.r44_1_provision = r44_1_provision;
	}
	public BigDecimal getR44_2_provision() {
		return r44_2_provision;
	}
	public void setR44_2_provision(BigDecimal r44_2_provision) {
		this.r44_2_provision = r44_2_provision;
	}
	public BigDecimal getR44_3a_provision() {
		return r44_3a_provision;
	}
	public void setR44_3a_provision(BigDecimal r44_3a_provision) {
		this.r44_3a_provision = r44_3a_provision;
	}
	public BigDecimal getR44_3b_provision() {
		return r44_3b_provision;
	}
	public void setR44_3b_provision(BigDecimal r44_3b_provision) {
		this.r44_3b_provision = r44_3b_provision;
	}
	public BigDecimal getR44_3c_provision() {
		return r44_3c_provision;
	}
	public void setR44_3c_provision(BigDecimal r44_3c_provision) {
		this.r44_3c_provision = r44_3c_provision;
	}
	public BigDecimal getR44_current() {
		return r44_current;
	}
	public void setR44_current(BigDecimal r44_current) {
		this.r44_current = r44_current;
	}
	public BigDecimal getR44_lessthan_30() {
		return r44_lessthan_30;
	}
	public void setR44_lessthan_30(BigDecimal r44_lessthan_30) {
		this.r44_lessthan_30 = r44_lessthan_30;
	}
	public BigDecimal getR44_exclusive_90days() {
		return r44_exclusive_90days;
	}
	public void setR44_exclusive_90days(BigDecimal r44_exclusive_90days) {
		this.r44_exclusive_90days = r44_exclusive_90days;
	}
	public BigDecimal getR44_exclusive_120days() {
		return r44_exclusive_120days;
	}
	public void setR44_exclusive_120days(BigDecimal r44_exclusive_120days) {
		this.r44_exclusive_120days = r44_exclusive_120days;
	}
	public BigDecimal getR44_exclusive_180days() {
		return r44_exclusive_180days;
	}
	public void setR44_exclusive_180days(BigDecimal r44_exclusive_180days) {
		this.r44_exclusive_180days = r44_exclusive_180days;
	}
	public BigDecimal getR44_exclusive_over_180days() {
		return r44_exclusive_over_180days;
	}
	public void setR44_exclusive_over_180days(BigDecimal r44_exclusive_over_180days) {
		this.r44_exclusive_over_180days = r44_exclusive_over_180days;
	}
	public BigDecimal getR44_total_past() {
		return r44_total_past;
	}
	public void setR44_total_past(BigDecimal r44_total_past) {
		this.r44_total_past = r44_total_past;
	}
	public BigDecimal getR44_new_stage3() {
		return r44_new_stage3;
	}
	public void setR44_new_stage3(BigDecimal r44_new_stage3) {
		this.r44_new_stage3 = r44_new_stage3;
	}
	public BigDecimal getR44_new_specific() {
		return r44_new_specific;
	}
	public void setR44_new_specific(BigDecimal r44_new_specific) {
		this.r44_new_specific = r44_new_specific;
	}
	public BigDecimal getR44_new_other() {
		return r44_new_other;
	}
	public void setR44_new_other(BigDecimal r44_new_other) {
		this.r44_new_other = r44_new_other;
	}
	public BigDecimal getR44_performing_accounts() {
		return r44_performing_accounts;
	}
	public void setR44_performing_accounts(BigDecimal r44_performing_accounts) {
		this.r44_performing_accounts = r44_performing_accounts;
	}
	public BigDecimal getR44_non_performing_accounts() {
		return r44_non_performing_accounts;
	}
	public void setR44_non_performing_accounts(BigDecimal r44_non_performing_accounts) {
		this.r44_non_performing_accounts = r44_non_performing_accounts;
	}
	public String getR44_outstanding_check() {
		return r44_outstanding_check;
	}
	public void setR44_outstanding_check(String r44_outstanding_check) {
		this.r44_outstanding_check = r44_outstanding_check;
	}
	public String getR44_provision_check() {
		return r44_provision_check;
	}
	public void setR44_provision_check(String r44_provision_check) {
		this.r44_provision_check = r44_provision_check;
	}
	public String getR44_past_due_date() {
		return r44_past_due_date;
	}
	public void setR44_past_due_date(String r44_past_due_date) {
		this.r44_past_due_date = r44_past_due_date;
	}
	public String getR45_asset_classes() {
		return r45_asset_classes;
	}
	public void setR45_asset_classes(String r45_asset_classes) {
		this.r45_asset_classes = r45_asset_classes;
	}
	public BigDecimal getR45_outstanding_balance() {
		return r45_outstanding_balance;
	}
	public void setR45_outstanding_balance(BigDecimal r45_outstanding_balance) {
		this.r45_outstanding_balance = r45_outstanding_balance;
	}
	public BigDecimal getR45_provision_suspense() {
		return r45_provision_suspense;
	}
	public void setR45_provision_suspense(BigDecimal r45_provision_suspense) {
		this.r45_provision_suspense = r45_provision_suspense;
	}
	public BigDecimal getR45_stage3_provision() {
		return r45_stage3_provision;
	}
	public void setR45_stage3_provision(BigDecimal r45_stage3_provision) {
		this.r45_stage3_provision = r45_stage3_provision;
	}
	public BigDecimal getR45_other_alloate() {
		return r45_other_alloate;
	}
	public void setR45_other_alloate(BigDecimal r45_other_alloate) {
		this.r45_other_alloate = r45_other_alloate;
	}
	public BigDecimal getR45_1_asset() {
		return r45_1_asset;
	}
	public void setR45_1_asset(BigDecimal r45_1_asset) {
		this.r45_1_asset = r45_1_asset;
	}
	public BigDecimal getR45_2_asset() {
		return r45_2_asset;
	}
	public void setR45_2_asset(BigDecimal r45_2_asset) {
		this.r45_2_asset = r45_2_asset;
	}
	public BigDecimal getR45_3a_asset() {
		return r45_3a_asset;
	}
	public void setR45_3a_asset(BigDecimal r45_3a_asset) {
		this.r45_3a_asset = r45_3a_asset;
	}
	public BigDecimal getR45_3b_asset() {
		return r45_3b_asset;
	}
	public void setR45_3b_asset(BigDecimal r45_3b_asset) {
		this.r45_3b_asset = r45_3b_asset;
	}
	public BigDecimal getR45_3c_asset() {
		return r45_3c_asset;
	}
	public void setR45_3c_asset(BigDecimal r45_3c_asset) {
		this.r45_3c_asset = r45_3c_asset;
	}
	public BigDecimal getR45_1_provision() {
		return r45_1_provision;
	}
	public void setR45_1_provision(BigDecimal r45_1_provision) {
		this.r45_1_provision = r45_1_provision;
	}
	public BigDecimal getR45_2_provision() {
		return r45_2_provision;
	}
	public void setR45_2_provision(BigDecimal r45_2_provision) {
		this.r45_2_provision = r45_2_provision;
	}
	public BigDecimal getR45_3a_provision() {
		return r45_3a_provision;
	}
	public void setR45_3a_provision(BigDecimal r45_3a_provision) {
		this.r45_3a_provision = r45_3a_provision;
	}
	public BigDecimal getR45_3b_provision() {
		return r45_3b_provision;
	}
	public void setR45_3b_provision(BigDecimal r45_3b_provision) {
		this.r45_3b_provision = r45_3b_provision;
	}
	public BigDecimal getR45_3c_provision() {
		return r45_3c_provision;
	}
	public void setR45_3c_provision(BigDecimal r45_3c_provision) {
		this.r45_3c_provision = r45_3c_provision;
	}
	public BigDecimal getR45_current() {
		return r45_current;
	}
	public void setR45_current(BigDecimal r45_current) {
		this.r45_current = r45_current;
	}
	public BigDecimal getR45_lessthan_30() {
		return r45_lessthan_30;
	}
	public void setR45_lessthan_30(BigDecimal r45_lessthan_30) {
		this.r45_lessthan_30 = r45_lessthan_30;
	}
	public BigDecimal getR45_exclusive_90days() {
		return r45_exclusive_90days;
	}
	public void setR45_exclusive_90days(BigDecimal r45_exclusive_90days) {
		this.r45_exclusive_90days = r45_exclusive_90days;
	}
	public BigDecimal getR45_exclusive_120days() {
		return r45_exclusive_120days;
	}
	public void setR45_exclusive_120days(BigDecimal r45_exclusive_120days) {
		this.r45_exclusive_120days = r45_exclusive_120days;
	}
	public BigDecimal getR45_exclusive_180days() {
		return r45_exclusive_180days;
	}
	public void setR45_exclusive_180days(BigDecimal r45_exclusive_180days) {
		this.r45_exclusive_180days = r45_exclusive_180days;
	}
	public BigDecimal getR45_exclusive_over_180days() {
		return r45_exclusive_over_180days;
	}
	public void setR45_exclusive_over_180days(BigDecimal r45_exclusive_over_180days) {
		this.r45_exclusive_over_180days = r45_exclusive_over_180days;
	}
	public BigDecimal getR45_total_past() {
		return r45_total_past;
	}
	public void setR45_total_past(BigDecimal r45_total_past) {
		this.r45_total_past = r45_total_past;
	}
	public BigDecimal getR45_new_stage3() {
		return r45_new_stage3;
	}
	public void setR45_new_stage3(BigDecimal r45_new_stage3) {
		this.r45_new_stage3 = r45_new_stage3;
	}
	public BigDecimal getR45_new_specific() {
		return r45_new_specific;
	}
	public void setR45_new_specific(BigDecimal r45_new_specific) {
		this.r45_new_specific = r45_new_specific;
	}
	public BigDecimal getR45_new_other() {
		return r45_new_other;
	}
	public void setR45_new_other(BigDecimal r45_new_other) {
		this.r45_new_other = r45_new_other;
	}
	public BigDecimal getR45_performing_accounts() {
		return r45_performing_accounts;
	}
	public void setR45_performing_accounts(BigDecimal r45_performing_accounts) {
		this.r45_performing_accounts = r45_performing_accounts;
	}
	public BigDecimal getR45_non_performing_accounts() {
		return r45_non_performing_accounts;
	}
	public void setR45_non_performing_accounts(BigDecimal r45_non_performing_accounts) {
		this.r45_non_performing_accounts = r45_non_performing_accounts;
	}
	public String getR45_outstanding_check() {
		return r45_outstanding_check;
	}
	public void setR45_outstanding_check(String r45_outstanding_check) {
		this.r45_outstanding_check = r45_outstanding_check;
	}
	public String getR45_provision_check() {
		return r45_provision_check;
	}
	public void setR45_provision_check(String r45_provision_check) {
		this.r45_provision_check = r45_provision_check;
	}
	public String getR45_past_due_date() {
		return r45_past_due_date;
	}
	public void setR45_past_due_date(String r45_past_due_date) {
		this.r45_past_due_date = r45_past_due_date;
	}
	public String getR46_asset_classes() {
		return r46_asset_classes;
	}
	public void setR46_asset_classes(String r46_asset_classes) {
		this.r46_asset_classes = r46_asset_classes;
	}
	public BigDecimal getR46_outstanding_balance() {
		return r46_outstanding_balance;
	}
	public void setR46_outstanding_balance(BigDecimal r46_outstanding_balance) {
		this.r46_outstanding_balance = r46_outstanding_balance;
	}
	public BigDecimal getR46_provision_suspense() {
		return r46_provision_suspense;
	}
	public void setR46_provision_suspense(BigDecimal r46_provision_suspense) {
		this.r46_provision_suspense = r46_provision_suspense;
	}
	public BigDecimal getR46_stage3_provision() {
		return r46_stage3_provision;
	}
	public void setR46_stage3_provision(BigDecimal r46_stage3_provision) {
		this.r46_stage3_provision = r46_stage3_provision;
	}
	public BigDecimal getR46_other_alloate() {
		return r46_other_alloate;
	}
	public void setR46_other_alloate(BigDecimal r46_other_alloate) {
		this.r46_other_alloate = r46_other_alloate;
	}
	public BigDecimal getR46_1_asset() {
		return r46_1_asset;
	}
	public void setR46_1_asset(BigDecimal r46_1_asset) {
		this.r46_1_asset = r46_1_asset;
	}
	public BigDecimal getR46_2_asset() {
		return r46_2_asset;
	}
	public void setR46_2_asset(BigDecimal r46_2_asset) {
		this.r46_2_asset = r46_2_asset;
	}
	public BigDecimal getR46_3a_asset() {
		return r46_3a_asset;
	}
	public void setR46_3a_asset(BigDecimal r46_3a_asset) {
		this.r46_3a_asset = r46_3a_asset;
	}
	public BigDecimal getR46_3b_asset() {
		return r46_3b_asset;
	}
	public void setR46_3b_asset(BigDecimal r46_3b_asset) {
		this.r46_3b_asset = r46_3b_asset;
	}
	public BigDecimal getR46_3c_asset() {
		return r46_3c_asset;
	}
	public void setR46_3c_asset(BigDecimal r46_3c_asset) {
		this.r46_3c_asset = r46_3c_asset;
	}
	public BigDecimal getR46_1_provision() {
		return r46_1_provision;
	}
	public void setR46_1_provision(BigDecimal r46_1_provision) {
		this.r46_1_provision = r46_1_provision;
	}
	public BigDecimal getR46_2_provision() {
		return r46_2_provision;
	}
	public void setR46_2_provision(BigDecimal r46_2_provision) {
		this.r46_2_provision = r46_2_provision;
	}
	public BigDecimal getR46_3a_provision() {
		return r46_3a_provision;
	}
	public void setR46_3a_provision(BigDecimal r46_3a_provision) {
		this.r46_3a_provision = r46_3a_provision;
	}
	public BigDecimal getR46_3b_provision() {
		return r46_3b_provision;
	}
	public void setR46_3b_provision(BigDecimal r46_3b_provision) {
		this.r46_3b_provision = r46_3b_provision;
	}
	public BigDecimal getR46_3c_provision() {
		return r46_3c_provision;
	}
	public void setR46_3c_provision(BigDecimal r46_3c_provision) {
		this.r46_3c_provision = r46_3c_provision;
	}
	public BigDecimal getR46_current() {
		return r46_current;
	}
	public void setR46_current(BigDecimal r46_current) {
		this.r46_current = r46_current;
	}
	public BigDecimal getR46_lessthan_30() {
		return r46_lessthan_30;
	}
	public void setR46_lessthan_30(BigDecimal r46_lessthan_30) {
		this.r46_lessthan_30 = r46_lessthan_30;
	}
	public BigDecimal getR46_exclusive_90days() {
		return r46_exclusive_90days;
	}
	public void setR46_exclusive_90days(BigDecimal r46_exclusive_90days) {
		this.r46_exclusive_90days = r46_exclusive_90days;
	}
	public BigDecimal getR46_exclusive_120days() {
		return r46_exclusive_120days;
	}
	public void setR46_exclusive_120days(BigDecimal r46_exclusive_120days) {
		this.r46_exclusive_120days = r46_exclusive_120days;
	}
	public BigDecimal getR46_exclusive_180days() {
		return r46_exclusive_180days;
	}
	public void setR46_exclusive_180days(BigDecimal r46_exclusive_180days) {
		this.r46_exclusive_180days = r46_exclusive_180days;
	}
	public BigDecimal getR46_exclusive_over_180days() {
		return r46_exclusive_over_180days;
	}
	public void setR46_exclusive_over_180days(BigDecimal r46_exclusive_over_180days) {
		this.r46_exclusive_over_180days = r46_exclusive_over_180days;
	}
	public BigDecimal getR46_total_past() {
		return r46_total_past;
	}
	public void setR46_total_past(BigDecimal r46_total_past) {
		this.r46_total_past = r46_total_past;
	}
	public BigDecimal getR46_new_stage3() {
		return r46_new_stage3;
	}
	public void setR46_new_stage3(BigDecimal r46_new_stage3) {
		this.r46_new_stage3 = r46_new_stage3;
	}
	public BigDecimal getR46_new_specific() {
		return r46_new_specific;
	}
	public void setR46_new_specific(BigDecimal r46_new_specific) {
		this.r46_new_specific = r46_new_specific;
	}
	public BigDecimal getR46_new_other() {
		return r46_new_other;
	}
	public void setR46_new_other(BigDecimal r46_new_other) {
		this.r46_new_other = r46_new_other;
	}
	public BigDecimal getR46_performing_accounts() {
		return r46_performing_accounts;
	}
	public void setR46_performing_accounts(BigDecimal r46_performing_accounts) {
		this.r46_performing_accounts = r46_performing_accounts;
	}
	public BigDecimal getR46_non_performing_accounts() {
		return r46_non_performing_accounts;
	}
	public void setR46_non_performing_accounts(BigDecimal r46_non_performing_accounts) {
		this.r46_non_performing_accounts = r46_non_performing_accounts;
	}
	public String getR46_outstanding_check() {
		return r46_outstanding_check;
	}
	public void setR46_outstanding_check(String r46_outstanding_check) {
		this.r46_outstanding_check = r46_outstanding_check;
	}
	public String getR46_provision_check() {
		return r46_provision_check;
	}
	public void setR46_provision_check(String r46_provision_check) {
		this.r46_provision_check = r46_provision_check;
	}
	public String getR46_past_due_date() {
		return r46_past_due_date;
	}
	public void setR46_past_due_date(String r46_past_due_date) {
		this.r46_past_due_date = r46_past_due_date;
	}
	public String getR47_asset_classes() {
		return r47_asset_classes;
	}
	public void setR47_asset_classes(String r47_asset_classes) {
		this.r47_asset_classes = r47_asset_classes;
	}
	public BigDecimal getR47_outstanding_balance() {
		return r47_outstanding_balance;
	}
	public void setR47_outstanding_balance(BigDecimal r47_outstanding_balance) {
		this.r47_outstanding_balance = r47_outstanding_balance;
	}
	public BigDecimal getR47_provision_suspense() {
		return r47_provision_suspense;
	}
	public void setR47_provision_suspense(BigDecimal r47_provision_suspense) {
		this.r47_provision_suspense = r47_provision_suspense;
	}
	public BigDecimal getR47_stage3_provision() {
		return r47_stage3_provision;
	}
	public void setR47_stage3_provision(BigDecimal r47_stage3_provision) {
		this.r47_stage3_provision = r47_stage3_provision;
	}
	public BigDecimal getR47_other_alloate() {
		return r47_other_alloate;
	}
	public void setR47_other_alloate(BigDecimal r47_other_alloate) {
		this.r47_other_alloate = r47_other_alloate;
	}
	public BigDecimal getR47_1_asset() {
		return r47_1_asset;
	}
	public void setR47_1_asset(BigDecimal r47_1_asset) {
		this.r47_1_asset = r47_1_asset;
	}
	public BigDecimal getR47_2_asset() {
		return r47_2_asset;
	}
	public void setR47_2_asset(BigDecimal r47_2_asset) {
		this.r47_2_asset = r47_2_asset;
	}
	public BigDecimal getR47_3a_asset() {
		return r47_3a_asset;
	}
	public void setR47_3a_asset(BigDecimal r47_3a_asset) {
		this.r47_3a_asset = r47_3a_asset;
	}
	public BigDecimal getR47_3b_asset() {
		return r47_3b_asset;
	}
	public void setR47_3b_asset(BigDecimal r47_3b_asset) {
		this.r47_3b_asset = r47_3b_asset;
	}
	public BigDecimal getR47_3c_asset() {
		return r47_3c_asset;
	}
	public void setR47_3c_asset(BigDecimal r47_3c_asset) {
		this.r47_3c_asset = r47_3c_asset;
	}
	public BigDecimal getR47_1_provision() {
		return r47_1_provision;
	}
	public void setR47_1_provision(BigDecimal r47_1_provision) {
		this.r47_1_provision = r47_1_provision;
	}
	public BigDecimal getR47_2_provision() {
		return r47_2_provision;
	}
	public void setR47_2_provision(BigDecimal r47_2_provision) {
		this.r47_2_provision = r47_2_provision;
	}
	public BigDecimal getR47_3a_provision() {
		return r47_3a_provision;
	}
	public void setR47_3a_provision(BigDecimal r47_3a_provision) {
		this.r47_3a_provision = r47_3a_provision;
	}
	public BigDecimal getR47_3b_provision() {
		return r47_3b_provision;
	}
	public void setR47_3b_provision(BigDecimal r47_3b_provision) {
		this.r47_3b_provision = r47_3b_provision;
	}
	public BigDecimal getR47_3c_provision() {
		return r47_3c_provision;
	}
	public void setR47_3c_provision(BigDecimal r47_3c_provision) {
		this.r47_3c_provision = r47_3c_provision;
	}
	public BigDecimal getR47_current() {
		return r47_current;
	}
	public void setR47_current(BigDecimal r47_current) {
		this.r47_current = r47_current;
	}
	public BigDecimal getR47_lessthan_30() {
		return r47_lessthan_30;
	}
	public void setR47_lessthan_30(BigDecimal r47_lessthan_30) {
		this.r47_lessthan_30 = r47_lessthan_30;
	}
	public BigDecimal getR47_exclusive_90days() {
		return r47_exclusive_90days;
	}
	public void setR47_exclusive_90days(BigDecimal r47_exclusive_90days) {
		this.r47_exclusive_90days = r47_exclusive_90days;
	}
	public BigDecimal getR47_exclusive_120days() {
		return r47_exclusive_120days;
	}
	public void setR47_exclusive_120days(BigDecimal r47_exclusive_120days) {
		this.r47_exclusive_120days = r47_exclusive_120days;
	}
	public BigDecimal getR47_exclusive_180days() {
		return r47_exclusive_180days;
	}
	public void setR47_exclusive_180days(BigDecimal r47_exclusive_180days) {
		this.r47_exclusive_180days = r47_exclusive_180days;
	}
	public BigDecimal getR47_exclusive_over_180days() {
		return r47_exclusive_over_180days;
	}
	public void setR47_exclusive_over_180days(BigDecimal r47_exclusive_over_180days) {
		this.r47_exclusive_over_180days = r47_exclusive_over_180days;
	}
	public BigDecimal getR47_total_past() {
		return r47_total_past;
	}
	public void setR47_total_past(BigDecimal r47_total_past) {
		this.r47_total_past = r47_total_past;
	}
	public BigDecimal getR47_new_stage3() {
		return r47_new_stage3;
	}
	public void setR47_new_stage3(BigDecimal r47_new_stage3) {
		this.r47_new_stage3 = r47_new_stage3;
	}
	public BigDecimal getR47_new_specific() {
		return r47_new_specific;
	}
	public void setR47_new_specific(BigDecimal r47_new_specific) {
		this.r47_new_specific = r47_new_specific;
	}
	public BigDecimal getR47_new_other() {
		return r47_new_other;
	}
	public void setR47_new_other(BigDecimal r47_new_other) {
		this.r47_new_other = r47_new_other;
	}
	public BigDecimal getR47_performing_accounts() {
		return r47_performing_accounts;
	}
	public void setR47_performing_accounts(BigDecimal r47_performing_accounts) {
		this.r47_performing_accounts = r47_performing_accounts;
	}
	public BigDecimal getR47_non_performing_accounts() {
		return r47_non_performing_accounts;
	}
	public void setR47_non_performing_accounts(BigDecimal r47_non_performing_accounts) {
		this.r47_non_performing_accounts = r47_non_performing_accounts;
	}
	public String getR47_outstanding_check() {
		return r47_outstanding_check;
	}
	public void setR47_outstanding_check(String r47_outstanding_check) {
		this.r47_outstanding_check = r47_outstanding_check;
	}
	public String getR47_provision_check() {
		return r47_provision_check;
	}
	public void setR47_provision_check(String r47_provision_check) {
		this.r47_provision_check = r47_provision_check;
	}
	public String getR47_past_due_date() {
		return r47_past_due_date;
	}
	public void setR47_past_due_date(String r47_past_due_date) {
		this.r47_past_due_date = r47_past_due_date;
	}
	public String getR48_asset_classes() {
		return r48_asset_classes;
	}
	public void setR48_asset_classes(String r48_asset_classes) {
		this.r48_asset_classes = r48_asset_classes;
	}
	public BigDecimal getR48_outstanding_balance() {
		return r48_outstanding_balance;
	}
	public void setR48_outstanding_balance(BigDecimal r48_outstanding_balance) {
		this.r48_outstanding_balance = r48_outstanding_balance;
	}
	public BigDecimal getR48_provision_suspense() {
		return r48_provision_suspense;
	}
	public void setR48_provision_suspense(BigDecimal r48_provision_suspense) {
		this.r48_provision_suspense = r48_provision_suspense;
	}
	public BigDecimal getR48_stage3_provision() {
		return r48_stage3_provision;
	}
	public void setR48_stage3_provision(BigDecimal r48_stage3_provision) {
		this.r48_stage3_provision = r48_stage3_provision;
	}
	public BigDecimal getR48_other_alloate() {
		return r48_other_alloate;
	}
	public void setR48_other_alloate(BigDecimal r48_other_alloate) {
		this.r48_other_alloate = r48_other_alloate;
	}
	public BigDecimal getR48_1_asset() {
		return r48_1_asset;
	}
	public void setR48_1_asset(BigDecimal r48_1_asset) {
		this.r48_1_asset = r48_1_asset;
	}
	public BigDecimal getR48_2_asset() {
		return r48_2_asset;
	}
	public void setR48_2_asset(BigDecimal r48_2_asset) {
		this.r48_2_asset = r48_2_asset;
	}
	public BigDecimal getR48_3a_asset() {
		return r48_3a_asset;
	}
	public void setR48_3a_asset(BigDecimal r48_3a_asset) {
		this.r48_3a_asset = r48_3a_asset;
	}
	public BigDecimal getR48_3b_asset() {
		return r48_3b_asset;
	}
	public void setR48_3b_asset(BigDecimal r48_3b_asset) {
		this.r48_3b_asset = r48_3b_asset;
	}
	public BigDecimal getR48_3c_asset() {
		return r48_3c_asset;
	}
	public void setR48_3c_asset(BigDecimal r48_3c_asset) {
		this.r48_3c_asset = r48_3c_asset;
	}
	public BigDecimal getR48_1_provision() {
		return r48_1_provision;
	}
	public void setR48_1_provision(BigDecimal r48_1_provision) {
		this.r48_1_provision = r48_1_provision;
	}
	public BigDecimal getR48_2_provision() {
		return r48_2_provision;
	}
	public void setR48_2_provision(BigDecimal r48_2_provision) {
		this.r48_2_provision = r48_2_provision;
	}
	public BigDecimal getR48_3a_provision() {
		return r48_3a_provision;
	}
	public void setR48_3a_provision(BigDecimal r48_3a_provision) {
		this.r48_3a_provision = r48_3a_provision;
	}
	public BigDecimal getR48_3b_provision() {
		return r48_3b_provision;
	}
	public void setR48_3b_provision(BigDecimal r48_3b_provision) {
		this.r48_3b_provision = r48_3b_provision;
	}
	public BigDecimal getR48_3c_provision() {
		return r48_3c_provision;
	}
	public void setR48_3c_provision(BigDecimal r48_3c_provision) {
		this.r48_3c_provision = r48_3c_provision;
	}
	public BigDecimal getR48_current() {
		return r48_current;
	}
	public void setR48_current(BigDecimal r48_current) {
		this.r48_current = r48_current;
	}
	public BigDecimal getR48_lessthan_30() {
		return r48_lessthan_30;
	}
	public void setR48_lessthan_30(BigDecimal r48_lessthan_30) {
		this.r48_lessthan_30 = r48_lessthan_30;
	}
	public BigDecimal getR48_exclusive_90days() {
		return r48_exclusive_90days;
	}
	public void setR48_exclusive_90days(BigDecimal r48_exclusive_90days) {
		this.r48_exclusive_90days = r48_exclusive_90days;
	}
	public BigDecimal getR48_exclusive_120days() {
		return r48_exclusive_120days;
	}
	public void setR48_exclusive_120days(BigDecimal r48_exclusive_120days) {
		this.r48_exclusive_120days = r48_exclusive_120days;
	}
	public BigDecimal getR48_exclusive_180days() {
		return r48_exclusive_180days;
	}
	public void setR48_exclusive_180days(BigDecimal r48_exclusive_180days) {
		this.r48_exclusive_180days = r48_exclusive_180days;
	}
	public BigDecimal getR48_exclusive_over_180days() {
		return r48_exclusive_over_180days;
	}
	public void setR48_exclusive_over_180days(BigDecimal r48_exclusive_over_180days) {
		this.r48_exclusive_over_180days = r48_exclusive_over_180days;
	}
	public BigDecimal getR48_total_past() {
		return r48_total_past;
	}
	public void setR48_total_past(BigDecimal r48_total_past) {
		this.r48_total_past = r48_total_past;
	}
	public BigDecimal getR48_new_stage3() {
		return r48_new_stage3;
	}
	public void setR48_new_stage3(BigDecimal r48_new_stage3) {
		this.r48_new_stage3 = r48_new_stage3;
	}
	public BigDecimal getR48_new_specific() {
		return r48_new_specific;
	}
	public void setR48_new_specific(BigDecimal r48_new_specific) {
		this.r48_new_specific = r48_new_specific;
	}
	public BigDecimal getR48_new_other() {
		return r48_new_other;
	}
	public void setR48_new_other(BigDecimal r48_new_other) {
		this.r48_new_other = r48_new_other;
	}
	public BigDecimal getR48_performing_accounts() {
		return r48_performing_accounts;
	}
	public void setR48_performing_accounts(BigDecimal r48_performing_accounts) {
		this.r48_performing_accounts = r48_performing_accounts;
	}
	public BigDecimal getR48_non_performing_accounts() {
		return r48_non_performing_accounts;
	}
	public void setR48_non_performing_accounts(BigDecimal r48_non_performing_accounts) {
		this.r48_non_performing_accounts = r48_non_performing_accounts;
	}
	public String getR48_outstanding_check() {
		return r48_outstanding_check;
	}
	public void setR48_outstanding_check(String r48_outstanding_check) {
		this.r48_outstanding_check = r48_outstanding_check;
	}
	public String getR48_provision_check() {
		return r48_provision_check;
	}
	public void setR48_provision_check(String r48_provision_check) {
		this.r48_provision_check = r48_provision_check;
	}
	public String getR48_past_due_date() {
		return r48_past_due_date;
	}
	public void setR48_past_due_date(String r48_past_due_date) {
		this.r48_past_due_date = r48_past_due_date;
	}
	public String getR49_asset_classes() {
		return r49_asset_classes;
	}
	public void setR49_asset_classes(String r49_asset_classes) {
		this.r49_asset_classes = r49_asset_classes;
	}
	public BigDecimal getR49_outstanding_balance() {
		return r49_outstanding_balance;
	}
	public void setR49_outstanding_balance(BigDecimal r49_outstanding_balance) {
		this.r49_outstanding_balance = r49_outstanding_balance;
	}
	public BigDecimal getR49_provision_suspense() {
		return r49_provision_suspense;
	}
	public void setR49_provision_suspense(BigDecimal r49_provision_suspense) {
		this.r49_provision_suspense = r49_provision_suspense;
	}
	public BigDecimal getR49_stage3_provision() {
		return r49_stage3_provision;
	}
	public void setR49_stage3_provision(BigDecimal r49_stage3_provision) {
		this.r49_stage3_provision = r49_stage3_provision;
	}
	public BigDecimal getR49_other_alloate() {
		return r49_other_alloate;
	}
	public void setR49_other_alloate(BigDecimal r49_other_alloate) {
		this.r49_other_alloate = r49_other_alloate;
	}
	public BigDecimal getR49_1_asset() {
		return r49_1_asset;
	}
	public void setR49_1_asset(BigDecimal r49_1_asset) {
		this.r49_1_asset = r49_1_asset;
	}
	public BigDecimal getR49_2_asset() {
		return r49_2_asset;
	}
	public void setR49_2_asset(BigDecimal r49_2_asset) {
		this.r49_2_asset = r49_2_asset;
	}
	public BigDecimal getR49_3a_asset() {
		return r49_3a_asset;
	}
	public void setR49_3a_asset(BigDecimal r49_3a_asset) {
		this.r49_3a_asset = r49_3a_asset;
	}
	public BigDecimal getR49_3b_asset() {
		return r49_3b_asset;
	}
	public void setR49_3b_asset(BigDecimal r49_3b_asset) {
		this.r49_3b_asset = r49_3b_asset;
	}
	public BigDecimal getR49_3c_asset() {
		return r49_3c_asset;
	}
	public void setR49_3c_asset(BigDecimal r49_3c_asset) {
		this.r49_3c_asset = r49_3c_asset;
	}
	public BigDecimal getR49_1_provision() {
		return r49_1_provision;
	}
	public void setR49_1_provision(BigDecimal r49_1_provision) {
		this.r49_1_provision = r49_1_provision;
	}
	public BigDecimal getR49_2_provision() {
		return r49_2_provision;
	}
	public void setR49_2_provision(BigDecimal r49_2_provision) {
		this.r49_2_provision = r49_2_provision;
	}
	public BigDecimal getR49_3a_provision() {
		return r49_3a_provision;
	}
	public void setR49_3a_provision(BigDecimal r49_3a_provision) {
		this.r49_3a_provision = r49_3a_provision;
	}
	public BigDecimal getR49_3b_provision() {
		return r49_3b_provision;
	}
	public void setR49_3b_provision(BigDecimal r49_3b_provision) {
		this.r49_3b_provision = r49_3b_provision;
	}
	public BigDecimal getR49_3c_provision() {
		return r49_3c_provision;
	}
	public void setR49_3c_provision(BigDecimal r49_3c_provision) {
		this.r49_3c_provision = r49_3c_provision;
	}
	public BigDecimal getR49_current() {
		return r49_current;
	}
	public void setR49_current(BigDecimal r49_current) {
		this.r49_current = r49_current;
	}
	public BigDecimal getR49_lessthan_30() {
		return r49_lessthan_30;
	}
	public void setR49_lessthan_30(BigDecimal r49_lessthan_30) {
		this.r49_lessthan_30 = r49_lessthan_30;
	}
	public BigDecimal getR49_exclusive_90days() {
		return r49_exclusive_90days;
	}
	public void setR49_exclusive_90days(BigDecimal r49_exclusive_90days) {
		this.r49_exclusive_90days = r49_exclusive_90days;
	}
	public BigDecimal getR49_exclusive_120days() {
		return r49_exclusive_120days;
	}
	public void setR49_exclusive_120days(BigDecimal r49_exclusive_120days) {
		this.r49_exclusive_120days = r49_exclusive_120days;
	}
	public BigDecimal getR49_exclusive_180days() {
		return r49_exclusive_180days;
	}
	public void setR49_exclusive_180days(BigDecimal r49_exclusive_180days) {
		this.r49_exclusive_180days = r49_exclusive_180days;
	}
	public BigDecimal getR49_exclusive_over_180days() {
		return r49_exclusive_over_180days;
	}
	public void setR49_exclusive_over_180days(BigDecimal r49_exclusive_over_180days) {
		this.r49_exclusive_over_180days = r49_exclusive_over_180days;
	}
	public BigDecimal getR49_total_past() {
		return r49_total_past;
	}
	public void setR49_total_past(BigDecimal r49_total_past) {
		this.r49_total_past = r49_total_past;
	}
	public BigDecimal getR49_new_stage3() {
		return r49_new_stage3;
	}
	public void setR49_new_stage3(BigDecimal r49_new_stage3) {
		this.r49_new_stage3 = r49_new_stage3;
	}
	public BigDecimal getR49_new_specific() {
		return r49_new_specific;
	}
	public void setR49_new_specific(BigDecimal r49_new_specific) {
		this.r49_new_specific = r49_new_specific;
	}
	public BigDecimal getR49_new_other() {
		return r49_new_other;
	}
	public void setR49_new_other(BigDecimal r49_new_other) {
		this.r49_new_other = r49_new_other;
	}
	public BigDecimal getR49_performing_accounts() {
		return r49_performing_accounts;
	}
	public void setR49_performing_accounts(BigDecimal r49_performing_accounts) {
		this.r49_performing_accounts = r49_performing_accounts;
	}
	public BigDecimal getR49_non_performing_accounts() {
		return r49_non_performing_accounts;
	}
	public void setR49_non_performing_accounts(BigDecimal r49_non_performing_accounts) {
		this.r49_non_performing_accounts = r49_non_performing_accounts;
	}
	public String getR49_outstanding_check() {
		return r49_outstanding_check;
	}
	public void setR49_outstanding_check(String r49_outstanding_check) {
		this.r49_outstanding_check = r49_outstanding_check;
	}
	public String getR49_provision_check() {
		return r49_provision_check;
	}
	public void setR49_provision_check(String r49_provision_check) {
		this.r49_provision_check = r49_provision_check;
	}
	public String getR49_past_due_date() {
		return r49_past_due_date;
	}
	public void setR49_past_due_date(String r49_past_due_date) {
		this.r49_past_due_date = r49_past_due_date;
	}
	public String getR50_asset_classes() {
		return r50_asset_classes;
	}
	public void setR50_asset_classes(String r50_asset_classes) {
		this.r50_asset_classes = r50_asset_classes;
	}
	public BigDecimal getR50_outstanding_balance() {
		return r50_outstanding_balance;
	}
	public void setR50_outstanding_balance(BigDecimal r50_outstanding_balance) {
		this.r50_outstanding_balance = r50_outstanding_balance;
	}
	public BigDecimal getR50_provision_suspense() {
		return r50_provision_suspense;
	}
	public void setR50_provision_suspense(BigDecimal r50_provision_suspense) {
		this.r50_provision_suspense = r50_provision_suspense;
	}
	public BigDecimal getR50_stage3_provision() {
		return r50_stage3_provision;
	}
	public void setR50_stage3_provision(BigDecimal r50_stage3_provision) {
		this.r50_stage3_provision = r50_stage3_provision;
	}
	public BigDecimal getR50_other_alloate() {
		return r50_other_alloate;
	}
	public void setR50_other_alloate(BigDecimal r50_other_alloate) {
		this.r50_other_alloate = r50_other_alloate;
	}
	public BigDecimal getR50_1_asset() {
		return r50_1_asset;
	}
	public void setR50_1_asset(BigDecimal r50_1_asset) {
		this.r50_1_asset = r50_1_asset;
	}
	public BigDecimal getR50_2_asset() {
		return r50_2_asset;
	}
	public void setR50_2_asset(BigDecimal r50_2_asset) {
		this.r50_2_asset = r50_2_asset;
	}
	public BigDecimal getR50_3a_asset() {
		return r50_3a_asset;
	}
	public void setR50_3a_asset(BigDecimal r50_3a_asset) {
		this.r50_3a_asset = r50_3a_asset;
	}
	public BigDecimal getR50_3b_asset() {
		return r50_3b_asset;
	}
	public void setR50_3b_asset(BigDecimal r50_3b_asset) {
		this.r50_3b_asset = r50_3b_asset;
	}
	public BigDecimal getR50_3c_asset() {
		return r50_3c_asset;
	}
	public void setR50_3c_asset(BigDecimal r50_3c_asset) {
		this.r50_3c_asset = r50_3c_asset;
	}
	public BigDecimal getR50_1_provision() {
		return r50_1_provision;
	}
	public void setR50_1_provision(BigDecimal r50_1_provision) {
		this.r50_1_provision = r50_1_provision;
	}
	public BigDecimal getR50_2_provision() {
		return r50_2_provision;
	}
	public void setR50_2_provision(BigDecimal r50_2_provision) {
		this.r50_2_provision = r50_2_provision;
	}
	public BigDecimal getR50_3a_provision() {
		return r50_3a_provision;
	}
	public void setR50_3a_provision(BigDecimal r50_3a_provision) {
		this.r50_3a_provision = r50_3a_provision;
	}
	public BigDecimal getR50_3b_provision() {
		return r50_3b_provision;
	}
	public void setR50_3b_provision(BigDecimal r50_3b_provision) {
		this.r50_3b_provision = r50_3b_provision;
	}
	public BigDecimal getR50_3c_provision() {
		return r50_3c_provision;
	}
	public void setR50_3c_provision(BigDecimal r50_3c_provision) {
		this.r50_3c_provision = r50_3c_provision;
	}
	public BigDecimal getR50_current() {
		return r50_current;
	}
	public void setR50_current(BigDecimal r50_current) {
		this.r50_current = r50_current;
	}
	public BigDecimal getR50_lessthan_30() {
		return r50_lessthan_30;
	}
	public void setR50_lessthan_30(BigDecimal r50_lessthan_30) {
		this.r50_lessthan_30 = r50_lessthan_30;
	}
	public BigDecimal getR50_exclusive_90days() {
		return r50_exclusive_90days;
	}
	public void setR50_exclusive_90days(BigDecimal r50_exclusive_90days) {
		this.r50_exclusive_90days = r50_exclusive_90days;
	}
	public BigDecimal getR50_exclusive_120days() {
		return r50_exclusive_120days;
	}
	public void setR50_exclusive_120days(BigDecimal r50_exclusive_120days) {
		this.r50_exclusive_120days = r50_exclusive_120days;
	}
	public BigDecimal getR50_exclusive_180days() {
		return r50_exclusive_180days;
	}
	public void setR50_exclusive_180days(BigDecimal r50_exclusive_180days) {
		this.r50_exclusive_180days = r50_exclusive_180days;
	}
	public BigDecimal getR50_exclusive_over_180days() {
		return r50_exclusive_over_180days;
	}
	public void setR50_exclusive_over_180days(BigDecimal r50_exclusive_over_180days) {
		this.r50_exclusive_over_180days = r50_exclusive_over_180days;
	}
	public BigDecimal getR50_total_past() {
		return r50_total_past;
	}
	public void setR50_total_past(BigDecimal r50_total_past) {
		this.r50_total_past = r50_total_past;
	}
	public BigDecimal getR50_new_stage3() {
		return r50_new_stage3;
	}
	public void setR50_new_stage3(BigDecimal r50_new_stage3) {
		this.r50_new_stage3 = r50_new_stage3;
	}
	public BigDecimal getR50_new_specific() {
		return r50_new_specific;
	}
	public void setR50_new_specific(BigDecimal r50_new_specific) {
		this.r50_new_specific = r50_new_specific;
	}
	public BigDecimal getR50_new_other() {
		return r50_new_other;
	}
	public void setR50_new_other(BigDecimal r50_new_other) {
		this.r50_new_other = r50_new_other;
	}
	public BigDecimal getR50_performing_accounts() {
		return r50_performing_accounts;
	}
	public void setR50_performing_accounts(BigDecimal r50_performing_accounts) {
		this.r50_performing_accounts = r50_performing_accounts;
	}
	public BigDecimal getR50_non_performing_accounts() {
		return r50_non_performing_accounts;
	}
	public void setR50_non_performing_accounts(BigDecimal r50_non_performing_accounts) {
		this.r50_non_performing_accounts = r50_non_performing_accounts;
	}
	public String getR50_outstanding_check() {
		return r50_outstanding_check;
	}
	public void setR50_outstanding_check(String r50_outstanding_check) {
		this.r50_outstanding_check = r50_outstanding_check;
	}
	public String getR50_provision_check() {
		return r50_provision_check;
	}
	public void setR50_provision_check(String r50_provision_check) {
		this.r50_provision_check = r50_provision_check;
	}
	public String getR50_past_due_date() {
		return r50_past_due_date;
	}
	public void setR50_past_due_date(String r50_past_due_date) {
		this.r50_past_due_date = r50_past_due_date;
	}
	public String getR51_asset_classes() {
		return r51_asset_classes;
	}
	public void setR51_asset_classes(String r51_asset_classes) {
		this.r51_asset_classes = r51_asset_classes;
	}
	public BigDecimal getR51_outstanding_balance() {
		return r51_outstanding_balance;
	}
	public void setR51_outstanding_balance(BigDecimal r51_outstanding_balance) {
		this.r51_outstanding_balance = r51_outstanding_balance;
	}
	public BigDecimal getR51_provision_suspense() {
		return r51_provision_suspense;
	}
	public void setR51_provision_suspense(BigDecimal r51_provision_suspense) {
		this.r51_provision_suspense = r51_provision_suspense;
	}
	public BigDecimal getR51_stage3_provision() {
		return r51_stage3_provision;
	}
	public void setR51_stage3_provision(BigDecimal r51_stage3_provision) {
		this.r51_stage3_provision = r51_stage3_provision;
	}
	public BigDecimal getR51_other_alloate() {
		return r51_other_alloate;
	}
	public void setR51_other_alloate(BigDecimal r51_other_alloate) {
		this.r51_other_alloate = r51_other_alloate;
	}
	public BigDecimal getR51_1_asset() {
		return r51_1_asset;
	}
	public void setR51_1_asset(BigDecimal r51_1_asset) {
		this.r51_1_asset = r51_1_asset;
	}
	public BigDecimal getR51_2_asset() {
		return r51_2_asset;
	}
	public void setR51_2_asset(BigDecimal r51_2_asset) {
		this.r51_2_asset = r51_2_asset;
	}
	public BigDecimal getR51_3a_asset() {
		return r51_3a_asset;
	}
	public void setR51_3a_asset(BigDecimal r51_3a_asset) {
		this.r51_3a_asset = r51_3a_asset;
	}
	public BigDecimal getR51_3b_asset() {
		return r51_3b_asset;
	}
	public void setR51_3b_asset(BigDecimal r51_3b_asset) {
		this.r51_3b_asset = r51_3b_asset;
	}
	public BigDecimal getR51_3c_asset() {
		return r51_3c_asset;
	}
	public void setR51_3c_asset(BigDecimal r51_3c_asset) {
		this.r51_3c_asset = r51_3c_asset;
	}
	public BigDecimal getR51_1_provision() {
		return r51_1_provision;
	}
	public void setR51_1_provision(BigDecimal r51_1_provision) {
		this.r51_1_provision = r51_1_provision;
	}
	public BigDecimal getR51_2_provision() {
		return r51_2_provision;
	}
	public void setR51_2_provision(BigDecimal r51_2_provision) {
		this.r51_2_provision = r51_2_provision;
	}
	public BigDecimal getR51_3a_provision() {
		return r51_3a_provision;
	}
	public void setR51_3a_provision(BigDecimal r51_3a_provision) {
		this.r51_3a_provision = r51_3a_provision;
	}
	public BigDecimal getR51_3b_provision() {
		return r51_3b_provision;
	}
	public void setR51_3b_provision(BigDecimal r51_3b_provision) {
		this.r51_3b_provision = r51_3b_provision;
	}
	public BigDecimal getR51_3c_provision() {
		return r51_3c_provision;
	}
	public void setR51_3c_provision(BigDecimal r51_3c_provision) {
		this.r51_3c_provision = r51_3c_provision;
	}
	public BigDecimal getR51_current() {
		return r51_current;
	}
	public void setR51_current(BigDecimal r51_current) {
		this.r51_current = r51_current;
	}
	public BigDecimal getR51_lessthan_30() {
		return r51_lessthan_30;
	}
	public void setR51_lessthan_30(BigDecimal r51_lessthan_30) {
		this.r51_lessthan_30 = r51_lessthan_30;
	}
	public BigDecimal getR51_exclusive_90days() {
		return r51_exclusive_90days;
	}
	public void setR51_exclusive_90days(BigDecimal r51_exclusive_90days) {
		this.r51_exclusive_90days = r51_exclusive_90days;
	}
	public BigDecimal getR51_exclusive_120days() {
		return r51_exclusive_120days;
	}
	public void setR51_exclusive_120days(BigDecimal r51_exclusive_120days) {
		this.r51_exclusive_120days = r51_exclusive_120days;
	}
	public BigDecimal getR51_exclusive_180days() {
		return r51_exclusive_180days;
	}
	public void setR51_exclusive_180days(BigDecimal r51_exclusive_180days) {
		this.r51_exclusive_180days = r51_exclusive_180days;
	}
	public BigDecimal getR51_exclusive_over_180days() {
		return r51_exclusive_over_180days;
	}
	public void setR51_exclusive_over_180days(BigDecimal r51_exclusive_over_180days) {
		this.r51_exclusive_over_180days = r51_exclusive_over_180days;
	}
	public BigDecimal getR51_total_past() {
		return r51_total_past;
	}
	public void setR51_total_past(BigDecimal r51_total_past) {
		this.r51_total_past = r51_total_past;
	}
	public BigDecimal getR51_new_stage3() {
		return r51_new_stage3;
	}
	public void setR51_new_stage3(BigDecimal r51_new_stage3) {
		this.r51_new_stage3 = r51_new_stage3;
	}
	public BigDecimal getR51_new_specific() {
		return r51_new_specific;
	}
	public void setR51_new_specific(BigDecimal r51_new_specific) {
		this.r51_new_specific = r51_new_specific;
	}
	public BigDecimal getR51_new_other() {
		return r51_new_other;
	}
	public void setR51_new_other(BigDecimal r51_new_other) {
		this.r51_new_other = r51_new_other;
	}
	public BigDecimal getR51_performing_accounts() {
		return r51_performing_accounts;
	}
	public void setR51_performing_accounts(BigDecimal r51_performing_accounts) {
		this.r51_performing_accounts = r51_performing_accounts;
	}
	public BigDecimal getR51_non_performing_accounts() {
		return r51_non_performing_accounts;
	}
	public void setR51_non_performing_accounts(BigDecimal r51_non_performing_accounts) {
		this.r51_non_performing_accounts = r51_non_performing_accounts;
	}
	public String getR51_outstanding_check() {
		return r51_outstanding_check;
	}
	public void setR51_outstanding_check(String r51_outstanding_check) {
		this.r51_outstanding_check = r51_outstanding_check;
	}
	public String getR51_provision_check() {
		return r51_provision_check;
	}
	public void setR51_provision_check(String r51_provision_check) {
		this.r51_provision_check = r51_provision_check;
	}
	public String getR51_past_due_date() {
		return r51_past_due_date;
	}
	public void setR51_past_due_date(String r51_past_due_date) {
		this.r51_past_due_date = r51_past_due_date;
	}
	public String getR52_asset_classes() {
		return r52_asset_classes;
	}
	public void setR52_asset_classes(String r52_asset_classes) {
		this.r52_asset_classes = r52_asset_classes;
	}
	public BigDecimal getR52_outstanding_balance() {
		return r52_outstanding_balance;
	}
	public void setR52_outstanding_balance(BigDecimal r52_outstanding_balance) {
		this.r52_outstanding_balance = r52_outstanding_balance;
	}
	public BigDecimal getR52_provision_suspense() {
		return r52_provision_suspense;
	}
	public void setR52_provision_suspense(BigDecimal r52_provision_suspense) {
		this.r52_provision_suspense = r52_provision_suspense;
	}
	public BigDecimal getR52_stage3_provision() {
		return r52_stage3_provision;
	}
	public void setR52_stage3_provision(BigDecimal r52_stage3_provision) {
		this.r52_stage3_provision = r52_stage3_provision;
	}
	public BigDecimal getR52_other_alloate() {
		return r52_other_alloate;
	}
	public void setR52_other_alloate(BigDecimal r52_other_alloate) {
		this.r52_other_alloate = r52_other_alloate;
	}
	public BigDecimal getR52_1_asset() {
		return r52_1_asset;
	}
	public void setR52_1_asset(BigDecimal r52_1_asset) {
		this.r52_1_asset = r52_1_asset;
	}
	public BigDecimal getR52_2_asset() {
		return r52_2_asset;
	}
	public void setR52_2_asset(BigDecimal r52_2_asset) {
		this.r52_2_asset = r52_2_asset;
	}
	public BigDecimal getR52_3a_asset() {
		return r52_3a_asset;
	}
	public void setR52_3a_asset(BigDecimal r52_3a_asset) {
		this.r52_3a_asset = r52_3a_asset;
	}
	public BigDecimal getR52_3b_asset() {
		return r52_3b_asset;
	}
	public void setR52_3b_asset(BigDecimal r52_3b_asset) {
		this.r52_3b_asset = r52_3b_asset;
	}
	public BigDecimal getR52_3c_asset() {
		return r52_3c_asset;
	}
	public void setR52_3c_asset(BigDecimal r52_3c_asset) {
		this.r52_3c_asset = r52_3c_asset;
	}
	public BigDecimal getR52_1_provision() {
		return r52_1_provision;
	}
	public void setR52_1_provision(BigDecimal r52_1_provision) {
		this.r52_1_provision = r52_1_provision;
	}
	public BigDecimal getR52_2_provision() {
		return r52_2_provision;
	}
	public void setR52_2_provision(BigDecimal r52_2_provision) {
		this.r52_2_provision = r52_2_provision;
	}
	public BigDecimal getR52_3a_provision() {
		return r52_3a_provision;
	}
	public void setR52_3a_provision(BigDecimal r52_3a_provision) {
		this.r52_3a_provision = r52_3a_provision;
	}
	public BigDecimal getR52_3b_provision() {
		return r52_3b_provision;
	}
	public void setR52_3b_provision(BigDecimal r52_3b_provision) {
		this.r52_3b_provision = r52_3b_provision;
	}
	public BigDecimal getR52_3c_provision() {
		return r52_3c_provision;
	}
	public void setR52_3c_provision(BigDecimal r52_3c_provision) {
		this.r52_3c_provision = r52_3c_provision;
	}
	public BigDecimal getR52_current() {
		return r52_current;
	}
	public void setR52_current(BigDecimal r52_current) {
		this.r52_current = r52_current;
	}
	public BigDecimal getR52_lessthan_30() {
		return r52_lessthan_30;
	}
	public void setR52_lessthan_30(BigDecimal r52_lessthan_30) {
		this.r52_lessthan_30 = r52_lessthan_30;
	}
	public BigDecimal getR52_exclusive_90days() {
		return r52_exclusive_90days;
	}
	public void setR52_exclusive_90days(BigDecimal r52_exclusive_90days) {
		this.r52_exclusive_90days = r52_exclusive_90days;
	}
	public BigDecimal getR52_exclusive_120days() {
		return r52_exclusive_120days;
	}
	public void setR52_exclusive_120days(BigDecimal r52_exclusive_120days) {
		this.r52_exclusive_120days = r52_exclusive_120days;
	}
	public BigDecimal getR52_exclusive_180days() {
		return r52_exclusive_180days;
	}
	public void setR52_exclusive_180days(BigDecimal r52_exclusive_180days) {
		this.r52_exclusive_180days = r52_exclusive_180days;
	}
	public BigDecimal getR52_exclusive_over_180days() {
		return r52_exclusive_over_180days;
	}
	public void setR52_exclusive_over_180days(BigDecimal r52_exclusive_over_180days) {
		this.r52_exclusive_over_180days = r52_exclusive_over_180days;
	}
	public BigDecimal getR52_total_past() {
		return r52_total_past;
	}
	public void setR52_total_past(BigDecimal r52_total_past) {
		this.r52_total_past = r52_total_past;
	}
	public BigDecimal getR52_new_stage3() {
		return r52_new_stage3;
	}
	public void setR52_new_stage3(BigDecimal r52_new_stage3) {
		this.r52_new_stage3 = r52_new_stage3;
	}
	public BigDecimal getR52_new_specific() {
		return r52_new_specific;
	}
	public void setR52_new_specific(BigDecimal r52_new_specific) {
		this.r52_new_specific = r52_new_specific;
	}
	public BigDecimal getR52_new_other() {
		return r52_new_other;
	}
	public void setR52_new_other(BigDecimal r52_new_other) {
		this.r52_new_other = r52_new_other;
	}
	public BigDecimal getR52_performing_accounts() {
		return r52_performing_accounts;
	}
	public void setR52_performing_accounts(BigDecimal r52_performing_accounts) {
		this.r52_performing_accounts = r52_performing_accounts;
	}
	public BigDecimal getR52_non_performing_accounts() {
		return r52_non_performing_accounts;
	}
	public void setR52_non_performing_accounts(BigDecimal r52_non_performing_accounts) {
		this.r52_non_performing_accounts = r52_non_performing_accounts;
	}
	public String getR52_outstanding_check() {
		return r52_outstanding_check;
	}
	public void setR52_outstanding_check(String r52_outstanding_check) {
		this.r52_outstanding_check = r52_outstanding_check;
	}
	public String getR52_provision_check() {
		return r52_provision_check;
	}
	public void setR52_provision_check(String r52_provision_check) {
		this.r52_provision_check = r52_provision_check;
	}
	public String getR52_past_due_date() {
		return r52_past_due_date;
	}
	public void setR52_past_due_date(String r52_past_due_date) {
		this.r52_past_due_date = r52_past_due_date;
	}
	public String getR53_asset_classes() {
		return r53_asset_classes;
	}
	public void setR53_asset_classes(String r53_asset_classes) {
		this.r53_asset_classes = r53_asset_classes;
	}
	public BigDecimal getR53_outstanding_balance() {
		return r53_outstanding_balance;
	}
	public void setR53_outstanding_balance(BigDecimal r53_outstanding_balance) {
		this.r53_outstanding_balance = r53_outstanding_balance;
	}
	public BigDecimal getR53_provision_suspense() {
		return r53_provision_suspense;
	}
	public void setR53_provision_suspense(BigDecimal r53_provision_suspense) {
		this.r53_provision_suspense = r53_provision_suspense;
	}
	public BigDecimal getR53_stage3_provision() {
		return r53_stage3_provision;
	}
	public void setR53_stage3_provision(BigDecimal r53_stage3_provision) {
		this.r53_stage3_provision = r53_stage3_provision;
	}
	public BigDecimal getR53_other_alloate() {
		return r53_other_alloate;
	}
	public void setR53_other_alloate(BigDecimal r53_other_alloate) {
		this.r53_other_alloate = r53_other_alloate;
	}
	public BigDecimal getR53_1_asset() {
		return r53_1_asset;
	}
	public void setR53_1_asset(BigDecimal r53_1_asset) {
		this.r53_1_asset = r53_1_asset;
	}
	public BigDecimal getR53_2_asset() {
		return r53_2_asset;
	}
	public void setR53_2_asset(BigDecimal r53_2_asset) {
		this.r53_2_asset = r53_2_asset;
	}
	public BigDecimal getR53_3a_asset() {
		return r53_3a_asset;
	}
	public void setR53_3a_asset(BigDecimal r53_3a_asset) {
		this.r53_3a_asset = r53_3a_asset;
	}
	public BigDecimal getR53_3b_asset() {
		return r53_3b_asset;
	}
	public void setR53_3b_asset(BigDecimal r53_3b_asset) {
		this.r53_3b_asset = r53_3b_asset;
	}
	public BigDecimal getR53_3c_asset() {
		return r53_3c_asset;
	}
	public void setR53_3c_asset(BigDecimal r53_3c_asset) {
		this.r53_3c_asset = r53_3c_asset;
	}
	public BigDecimal getR53_1_provision() {
		return r53_1_provision;
	}
	public void setR53_1_provision(BigDecimal r53_1_provision) {
		this.r53_1_provision = r53_1_provision;
	}
	public BigDecimal getR53_2_provision() {
		return r53_2_provision;
	}
	public void setR53_2_provision(BigDecimal r53_2_provision) {
		this.r53_2_provision = r53_2_provision;
	}
	public BigDecimal getR53_3a_provision() {
		return r53_3a_provision;
	}
	public void setR53_3a_provision(BigDecimal r53_3a_provision) {
		this.r53_3a_provision = r53_3a_provision;
	}
	public BigDecimal getR53_3b_provision() {
		return r53_3b_provision;
	}
	public void setR53_3b_provision(BigDecimal r53_3b_provision) {
		this.r53_3b_provision = r53_3b_provision;
	}
	public BigDecimal getR53_3c_provision() {
		return r53_3c_provision;
	}
	public void setR53_3c_provision(BigDecimal r53_3c_provision) {
		this.r53_3c_provision = r53_3c_provision;
	}
	public BigDecimal getR53_current() {
		return r53_current;
	}
	public void setR53_current(BigDecimal r53_current) {
		this.r53_current = r53_current;
	}
	public BigDecimal getR53_lessthan_30() {
		return r53_lessthan_30;
	}
	public void setR53_lessthan_30(BigDecimal r53_lessthan_30) {
		this.r53_lessthan_30 = r53_lessthan_30;
	}
	public BigDecimal getR53_exclusive_90days() {
		return r53_exclusive_90days;
	}
	public void setR53_exclusive_90days(BigDecimal r53_exclusive_90days) {
		this.r53_exclusive_90days = r53_exclusive_90days;
	}
	public BigDecimal getR53_exclusive_120days() {
		return r53_exclusive_120days;
	}
	public void setR53_exclusive_120days(BigDecimal r53_exclusive_120days) {
		this.r53_exclusive_120days = r53_exclusive_120days;
	}
	public BigDecimal getR53_exclusive_180days() {
		return r53_exclusive_180days;
	}
	public void setR53_exclusive_180days(BigDecimal r53_exclusive_180days) {
		this.r53_exclusive_180days = r53_exclusive_180days;
	}
	public BigDecimal getR53_exclusive_over_180days() {
		return r53_exclusive_over_180days;
	}
	public void setR53_exclusive_over_180days(BigDecimal r53_exclusive_over_180days) {
		this.r53_exclusive_over_180days = r53_exclusive_over_180days;
	}
	public BigDecimal getR53_total_past() {
		return r53_total_past;
	}
	public void setR53_total_past(BigDecimal r53_total_past) {
		this.r53_total_past = r53_total_past;
	}
	public BigDecimal getR53_new_stage3() {
		return r53_new_stage3;
	}
	public void setR53_new_stage3(BigDecimal r53_new_stage3) {
		this.r53_new_stage3 = r53_new_stage3;
	}
	public BigDecimal getR53_new_specific() {
		return r53_new_specific;
	}
	public void setR53_new_specific(BigDecimal r53_new_specific) {
		this.r53_new_specific = r53_new_specific;
	}
	public BigDecimal getR53_new_other() {
		return r53_new_other;
	}
	public void setR53_new_other(BigDecimal r53_new_other) {
		this.r53_new_other = r53_new_other;
	}
	public BigDecimal getR53_performing_accounts() {
		return r53_performing_accounts;
	}
	public void setR53_performing_accounts(BigDecimal r53_performing_accounts) {
		this.r53_performing_accounts = r53_performing_accounts;
	}
	public BigDecimal getR53_non_performing_accounts() {
		return r53_non_performing_accounts;
	}
	public void setR53_non_performing_accounts(BigDecimal r53_non_performing_accounts) {
		this.r53_non_performing_accounts = r53_non_performing_accounts;
	}
	public String getR53_outstanding_check() {
		return r53_outstanding_check;
	}
	public void setR53_outstanding_check(String r53_outstanding_check) {
		this.r53_outstanding_check = r53_outstanding_check;
	}
	public String getR53_provision_check() {
		return r53_provision_check;
	}
	public void setR53_provision_check(String r53_provision_check) {
		this.r53_provision_check = r53_provision_check;
	}
	public String getR53_past_due_date() {
		return r53_past_due_date;
	}
	public void setR53_past_due_date(String r53_past_due_date) {
		this.r53_past_due_date = r53_past_due_date;
	}
	public String getR54_asset_classes() {
		return r54_asset_classes;
	}
	public void setR54_asset_classes(String r54_asset_classes) {
		this.r54_asset_classes = r54_asset_classes;
	}
	public BigDecimal getR54_outstanding_balance() {
		return r54_outstanding_balance;
	}
	public void setR54_outstanding_balance(BigDecimal r54_outstanding_balance) {
		this.r54_outstanding_balance = r54_outstanding_balance;
	}
	public BigDecimal getR54_provision_suspense() {
		return r54_provision_suspense;
	}
	public void setR54_provision_suspense(BigDecimal r54_provision_suspense) {
		this.r54_provision_suspense = r54_provision_suspense;
	}
	public BigDecimal getR54_stage3_provision() {
		return r54_stage3_provision;
	}
	public void setR54_stage3_provision(BigDecimal r54_stage3_provision) {
		this.r54_stage3_provision = r54_stage3_provision;
	}
	public BigDecimal getR54_other_alloate() {
		return r54_other_alloate;
	}
	public void setR54_other_alloate(BigDecimal r54_other_alloate) {
		this.r54_other_alloate = r54_other_alloate;
	}
	public BigDecimal getR54_1_asset() {
		return r54_1_asset;
	}
	public void setR54_1_asset(BigDecimal r54_1_asset) {
		this.r54_1_asset = r54_1_asset;
	}
	public BigDecimal getR54_2_asset() {
		return r54_2_asset;
	}
	public void setR54_2_asset(BigDecimal r54_2_asset) {
		this.r54_2_asset = r54_2_asset;
	}
	public BigDecimal getR54_3a_asset() {
		return r54_3a_asset;
	}
	public void setR54_3a_asset(BigDecimal r54_3a_asset) {
		this.r54_3a_asset = r54_3a_asset;
	}
	public BigDecimal getR54_3b_asset() {
		return r54_3b_asset;
	}
	public void setR54_3b_asset(BigDecimal r54_3b_asset) {
		this.r54_3b_asset = r54_3b_asset;
	}
	public BigDecimal getR54_3c_asset() {
		return r54_3c_asset;
	}
	public void setR54_3c_asset(BigDecimal r54_3c_asset) {
		this.r54_3c_asset = r54_3c_asset;
	}
	public BigDecimal getR54_1_provision() {
		return r54_1_provision;
	}
	public void setR54_1_provision(BigDecimal r54_1_provision) {
		this.r54_1_provision = r54_1_provision;
	}
	public BigDecimal getR54_2_provision() {
		return r54_2_provision;
	}
	public void setR54_2_provision(BigDecimal r54_2_provision) {
		this.r54_2_provision = r54_2_provision;
	}
	public BigDecimal getR54_3a_provision() {
		return r54_3a_provision;
	}
	public void setR54_3a_provision(BigDecimal r54_3a_provision) {
		this.r54_3a_provision = r54_3a_provision;
	}
	public BigDecimal getR54_3b_provision() {
		return r54_3b_provision;
	}
	public void setR54_3b_provision(BigDecimal r54_3b_provision) {
		this.r54_3b_provision = r54_3b_provision;
	}
	public BigDecimal getR54_3c_provision() {
		return r54_3c_provision;
	}
	public void setR54_3c_provision(BigDecimal r54_3c_provision) {
		this.r54_3c_provision = r54_3c_provision;
	}
	public BigDecimal getR54_current() {
		return r54_current;
	}
	public void setR54_current(BigDecimal r54_current) {
		this.r54_current = r54_current;
	}
	public BigDecimal getR54_lessthan_30() {
		return r54_lessthan_30;
	}
	public void setR54_lessthan_30(BigDecimal r54_lessthan_30) {
		this.r54_lessthan_30 = r54_lessthan_30;
	}
	public BigDecimal getR54_exclusive_90days() {
		return r54_exclusive_90days;
	}
	public void setR54_exclusive_90days(BigDecimal r54_exclusive_90days) {
		this.r54_exclusive_90days = r54_exclusive_90days;
	}
	public BigDecimal getR54_exclusive_120days() {
		return r54_exclusive_120days;
	}
	public void setR54_exclusive_120days(BigDecimal r54_exclusive_120days) {
		this.r54_exclusive_120days = r54_exclusive_120days;
	}
	public BigDecimal getR54_exclusive_180days() {
		return r54_exclusive_180days;
	}
	public void setR54_exclusive_180days(BigDecimal r54_exclusive_180days) {
		this.r54_exclusive_180days = r54_exclusive_180days;
	}
	public BigDecimal getR54_exclusive_over_180days() {
		return r54_exclusive_over_180days;
	}
	public void setR54_exclusive_over_180days(BigDecimal r54_exclusive_over_180days) {
		this.r54_exclusive_over_180days = r54_exclusive_over_180days;
	}
	public BigDecimal getR54_total_past() {
		return r54_total_past;
	}
	public void setR54_total_past(BigDecimal r54_total_past) {
		this.r54_total_past = r54_total_past;
	}
	public BigDecimal getR54_new_stage3() {
		return r54_new_stage3;
	}
	public void setR54_new_stage3(BigDecimal r54_new_stage3) {
		this.r54_new_stage3 = r54_new_stage3;
	}
	public BigDecimal getR54_new_specific() {
		return r54_new_specific;
	}
	public void setR54_new_specific(BigDecimal r54_new_specific) {
		this.r54_new_specific = r54_new_specific;
	}
	public BigDecimal getR54_new_other() {
		return r54_new_other;
	}
	public void setR54_new_other(BigDecimal r54_new_other) {
		this.r54_new_other = r54_new_other;
	}
	public BigDecimal getR54_performing_accounts() {
		return r54_performing_accounts;
	}
	public void setR54_performing_accounts(BigDecimal r54_performing_accounts) {
		this.r54_performing_accounts = r54_performing_accounts;
	}
	public BigDecimal getR54_non_performing_accounts() {
		return r54_non_performing_accounts;
	}
	public void setR54_non_performing_accounts(BigDecimal r54_non_performing_accounts) {
		this.r54_non_performing_accounts = r54_non_performing_accounts;
	}
	public String getR54_outstanding_check() {
		return r54_outstanding_check;
	}
	public void setR54_outstanding_check(String r54_outstanding_check) {
		this.r54_outstanding_check = r54_outstanding_check;
	}
	public String getR54_provision_check() {
		return r54_provision_check;
	}
	public void setR54_provision_check(String r54_provision_check) {
		this.r54_provision_check = r54_provision_check;
	}
	public String getR54_past_due_date() {
		return r54_past_due_date;
	}
	public void setR54_past_due_date(String r54_past_due_date) {
		this.r54_past_due_date = r54_past_due_date;
	}
	public String getR55_asset_classes() {
		return r55_asset_classes;
	}
	public void setR55_asset_classes(String r55_asset_classes) {
		this.r55_asset_classes = r55_asset_classes;
	}
	public String getR55_outstanding_balance() {
		return r55_outstanding_balance;
	}
	public void setR55_outstanding_balance(String r55_outstanding_balance) {
		this.r55_outstanding_balance = r55_outstanding_balance;
	}
	public String getR55_provision_suspense() {
		return r55_provision_suspense;
	}
	public void setR55_provision_suspense(String r55_provision_suspense) {
		this.r55_provision_suspense = r55_provision_suspense;
	}
	public String getR55_stage3_provision() {
		return r55_stage3_provision;
	}
	public void setR55_stage3_provision(String r55_stage3_provision) {
		this.r55_stage3_provision = r55_stage3_provision;
	}
	public String getR55_other_alloate() {
		return r55_other_alloate;
	}
	public void setR55_other_alloate(String r55_other_alloate) {
		this.r55_other_alloate = r55_other_alloate;
	}
	public String getR55_1_asset() {
		return r55_1_asset;
	}
	public void setR55_1_asset(String r55_1_asset) {
		this.r55_1_asset = r55_1_asset;
	}
	public String getR55_2_asset() {
		return r55_2_asset;
	}
	public void setR55_2_asset(String r55_2_asset) {
		this.r55_2_asset = r55_2_asset;
	}
	public String getR55_3a_asset() {
		return r55_3a_asset;
	}
	public void setR55_3a_asset(String r55_3a_asset) {
		this.r55_3a_asset = r55_3a_asset;
	}
	public String getR55_3b_asset() {
		return r55_3b_asset;
	}
	public void setR55_3b_asset(String r55_3b_asset) {
		this.r55_3b_asset = r55_3b_asset;
	}
	public String getR55_3c_asset() {
		return r55_3c_asset;
	}
	public void setR55_3c_asset(String r55_3c_asset) {
		this.r55_3c_asset = r55_3c_asset;
	}
	public String getR55_1_provision() {
		return r55_1_provision;
	}
	public void setR55_1_provision(String r55_1_provision) {
		this.r55_1_provision = r55_1_provision;
	}
	public String getR55_2_provision() {
		return r55_2_provision;
	}
	public void setR55_2_provision(String r55_2_provision) {
		this.r55_2_provision = r55_2_provision;
	}
	public String getR55_3a_provision() {
		return r55_3a_provision;
	}
	public void setR55_3a_provision(String r55_3a_provision) {
		this.r55_3a_provision = r55_3a_provision;
	}
	public String getR55_3b_provision() {
		return r55_3b_provision;
	}
	public void setR55_3b_provision(String r55_3b_provision) {
		this.r55_3b_provision = r55_3b_provision;
	}
	public String getR55_3c_provision() {
		return r55_3c_provision;
	}
	public void setR55_3c_provision(String r55_3c_provision) {
		this.r55_3c_provision = r55_3c_provision;
	}
	public String getR55_current() {
		return r55_current;
	}
	public void setR55_current(String r55_current) {
		this.r55_current = r55_current;
	}
	public String getR55_lessthan_30() {
		return r55_lessthan_30;
	}
	public void setR55_lessthan_30(String r55_lessthan_30) {
		this.r55_lessthan_30 = r55_lessthan_30;
	}
	public String getR55_exclusive_90days() {
		return r55_exclusive_90days;
	}
	public void setR55_exclusive_90days(String r55_exclusive_90days) {
		this.r55_exclusive_90days = r55_exclusive_90days;
	}
	public String getR55_exclusive_120days() {
		return r55_exclusive_120days;
	}
	public void setR55_exclusive_120days(String r55_exclusive_120days) {
		this.r55_exclusive_120days = r55_exclusive_120days;
	}
	public String getR55_exclusive_180days() {
		return r55_exclusive_180days;
	}
	public void setR55_exclusive_180days(String r55_exclusive_180days) {
		this.r55_exclusive_180days = r55_exclusive_180days;
	}
	public String getR55_exclusive_over_180days() {
		return r55_exclusive_over_180days;
	}
	public void setR55_exclusive_over_180days(String r55_exclusive_over_180days) {
		this.r55_exclusive_over_180days = r55_exclusive_over_180days;
	}
	public String getR55_total_past() {
		return r55_total_past;
	}
	public void setR55_total_past(String r55_total_past) {
		this.r55_total_past = r55_total_past;
	}
	public String getR55_new_stage3() {
		return r55_new_stage3;
	}
	public void setR55_new_stage3(String r55_new_stage3) {
		this.r55_new_stage3 = r55_new_stage3;
	}
	public String getR55_new_specific() {
		return r55_new_specific;
	}
	public void setR55_new_specific(String r55_new_specific) {
		this.r55_new_specific = r55_new_specific;
	}
	public String getR55_new_other() {
		return r55_new_other;
	}
	public void setR55_new_other(String r55_new_other) {
		this.r55_new_other = r55_new_other;
	}
	public String getR55_performing_accounts() {
		return r55_performing_accounts;
	}
	public void setR55_performing_accounts(String r55_performing_accounts) {
		this.r55_performing_accounts = r55_performing_accounts;
	}
	public String getR55_non_performing_accounts() {
		return r55_non_performing_accounts;
	}
	public void setR55_non_performing_accounts(String r55_non_performing_accounts) {
		this.r55_non_performing_accounts = r55_non_performing_accounts;
	}
	public String getR55_outstanding_check() {
		return r55_outstanding_check;
	}
	public void setR55_outstanding_check(String r55_outstanding_check) {
		this.r55_outstanding_check = r55_outstanding_check;
	}
	public String getR55_provision_check() {
		return r55_provision_check;
	}
	public void setR55_provision_check(String r55_provision_check) {
		this.r55_provision_check = r55_provision_check;
	}
	public String getR55_past_due_date() {
		return r55_past_due_date;
	}
	public void setR55_past_due_date(String r55_past_due_date) {
		this.r55_past_due_date = r55_past_due_date;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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
	public BRF40_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}
}