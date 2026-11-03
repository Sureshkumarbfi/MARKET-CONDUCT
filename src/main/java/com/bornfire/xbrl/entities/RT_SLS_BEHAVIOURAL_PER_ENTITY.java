package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RT_SLS_BEHAVIOURAL_PER_SC_TABLE")
public class RT_SLS_BEHAVIOURAL_PER_ENTITY {
	@Id
	private String srl_no;
	private String quarter_name;
	private String segment;
	private String sb_q1_segment;
	private BigDecimal sb_q1__1_day_outflow;
	private BigDecimal sb_q1__2_7_days_out_flow;
	private BigDecimal sb_q1__8_14_days_outflow;
	private BigDecimal sb_q1__1_3_years;
	private BigDecimal sb_q1__above_5_years;
	private String sb_q2_segment;
	private BigDecimal sb_q2__1_day_outflow;
	private BigDecimal sb_q2__2_7_days_out_flow;
	private BigDecimal sb_q2__8_14_days_outflow;
	private BigDecimal sb_q2__1_3_years;
	private BigDecimal sb_q2__above_5_years;
	private String sb_q3_segment;
	private BigDecimal sb_q3__1_day_outflow;
	private BigDecimal sb_q3__2_7_days_out_flow;
	private BigDecimal sb_q3__8_14_days_outflow;
	private BigDecimal sb_q3__1_3_years;
	private BigDecimal sb_q3__above_5_years;
	private String sb_q4_segment;
	private BigDecimal sb_q4__1_day_outflow;
	private BigDecimal sb_q4__2_7_days_out_flow;
	private BigDecimal sb_q4__8_14_days_outflow;
	private BigDecimal sb_q4__1_3_years;
	private BigDecimal sb_q4__above_5_years;
	private String ca_q1_segment;
	private BigDecimal ca_q1__1_day_outflow;
	private BigDecimal ca_q1__2_7_days_out_flow;
	private BigDecimal ca_q1__8_14_days_outflow;
	private BigDecimal ca_q1__1_3_years;
	private BigDecimal ca_q1__above_5_years;
	private String ca_q2_segment;
	private BigDecimal ca_q2__1_day_outflow;
	private BigDecimal ca_q2__2_7_days_out_flow;
	private BigDecimal ca_q2__8_14_days_outflow;
	private BigDecimal ca_q2__1_3_years;
	private BigDecimal ca_q2__above_5_years;
	private String ca_q3_segment;
	private BigDecimal ca_q3__1_day_outflow;
	private BigDecimal ca_q3__2_7_days_out_flow;
	private BigDecimal ca_q3__8_14_days_outflow;
	private BigDecimal ca_q3__1_3_years;
	private BigDecimal ca_q3__above_5_years;
	private String ca_q4_segment;
	private BigDecimal ca_q4__1_day_outflow;
	private BigDecimal ca_q4__2_7_days_out_flow;
	private BigDecimal ca_q4__8_14_days_outflow;
	private BigDecimal ca_q4__1_3_years;
	private BigDecimal ca_q4__above_5_years;
	private String od_q1_segment;
	private BigDecimal od_q1__1_day_outflow;
	private BigDecimal od_q1__2_7_days_out_flow;
	private BigDecimal od_q1__8_14_days_outflow;
	private BigDecimal od_q1__1_3_years;
	private BigDecimal od_q1__above_5_years;
	private String od_q2_segment;
	private BigDecimal od_q2__1_day_outflow;
	private BigDecimal od_q2__2_7_days_out_flow;
	private BigDecimal od_q2__8_14_days_outflow;
	private BigDecimal od_q2__1_3_years;
	private BigDecimal od_q2__above_5_years;
	private String od_q3_segment;
	private BigDecimal od_q3__1_day_outflow;
	private BigDecimal od_q3__2_7_days_out_flow;
	private BigDecimal od_q3__8_14_days_outflow;
	private BigDecimal od_q3__1_3_years;
	private BigDecimal od_q3__above_5_years;
	private String od_q4_segment;
	private BigDecimal od_q4__1_day_outflow;
	private BigDecimal od_q4__2_7_days_out_flow;
	private BigDecimal od_q4__8_14_days_outflow;
	private BigDecimal od_q4__1_3_years;
	private BigDecimal od_q4__above_5_years;
	private String bills_payable_q1_segment;
	private BigDecimal bills_payable_q1__1_day_outflow;
	private BigDecimal bills_payable_q1__2_7_days_out_flow;
	private BigDecimal bills_payable_q1__8_14_days_outflow;
	private BigDecimal bills_payable_q1__1_3_years;
	private BigDecimal bills_payable_q1__above_5_years;
	private String bills_payable_q2_segment;
	private BigDecimal bills_payable_q2__1_day_outflow;
	private BigDecimal bills_payable_q2__2_7_days_out_flow;
	private BigDecimal bills_payable_q2__8_14_days_outflow;
	private BigDecimal bills_payable_q2__1_3_years;
	private BigDecimal bills_payable_q2__above_5_years;
	private String bills_payable_q3_segment;
	private BigDecimal bills_payable_q3__1_day_outflow;
	private BigDecimal bills_payable_q3__2_7_days_out_flow;
	private BigDecimal bills_payable_q3__8_14_days_outflow;
	private BigDecimal bills_payable_q3__1_3_years;
	private BigDecimal bills_payable_q3__above_5_years;
	private String bills_payable_q4_segment;
	private BigDecimal bills_payable_q4__1_day_outflow;
	private BigDecimal bills_payable_q4__2_7_days_out_flow;
	private BigDecimal bills_payable_q4__8_14_days_outflow;
	private BigDecimal bills_payable_q4__1_3_years;
	private BigDecimal bills_payable_q4__above_5_years;
	private BigDecimal term_deposit_retail__rollover_sdr;
	private BigDecimal term_deposit_retail__rollover_fdr;
	private BigDecimal term_deposit_retail__premature_sdr;
	private BigDecimal term_deposit_retail__premature_fdr;
	private String undrawn_balance_q1_segment;
	private BigDecimal undrawn_balance_q1__total;
	private BigDecimal undrawn_balance_q1__day_1;
	private BigDecimal undrawn_balance_q1__2_7_days;
	private BigDecimal undrawn_balance_q1__8_14_days;
	private BigDecimal undrawn_balance_q1__15_30_days;
	private BigDecimal undrawn_balance_q1__31_days_to_2_months;
	private BigDecimal undrawn_balance_q1__more_than_2m_to_3m;
	private BigDecimal undrawn_balance_q1__over_3m_to_6m;
	private BigDecimal undrawn_balance_q1__over_6m_to_1y;
	private String undrawn_balance_q2_segment;
	private BigDecimal undrawn_balance_q2__total;
	private BigDecimal undrawn_balance_q2__day_1;
	private BigDecimal undrawn_balance_q2__2_7_days;
	private BigDecimal undrawn_balance_q2__8_14_days;
	private BigDecimal undrawn_balance_q2__15_30_days;
	private BigDecimal undrawn_balance_q2__31_days_to_2_months;
	private BigDecimal undrawn_balance_q2__more_than_2m_to_3m;
	private BigDecimal undrawn_balance_q2__over_3m_to_6m;
	private BigDecimal undrawn_balance_q2__over_6m_to_1y;
	private String undrawn_balance_q3_segment;
	private BigDecimal undrawn_balance_q3__total;
	private BigDecimal undrawn_balance_q3__day_1;
	private BigDecimal undrawn_balance_q3__2_7_days;
	private BigDecimal undrawn_balance_q3__8_14_days;
	private BigDecimal undrawn_balance_q3__15_30_days;
	private BigDecimal undrawn_balance_q3__31_days_to_2_months;
	private BigDecimal undrawn_balance_q3__more_than_2m_to_3m;
	private BigDecimal undrawn_balance_q3__over_3m_to_6m;
	private BigDecimal undrawn_balance_q3__over_6m_to_1y;
	private String undrawn_balance_q4_segment;
	private BigDecimal undrawn_balance_q4__total;
	private BigDecimal undrawn_balance_q4__day_1;
	private BigDecimal undrawn_balance_q4__2_7_days;
	private BigDecimal undrawn_balance_q4__8_14_days;
	private BigDecimal undrawn_balance_q4__15_30_days;
	private BigDecimal undrawn_balance_q4__31_days_to_2_months;
	private BigDecimal undrawn_balance_q4__more_than_2m_to_3m;
	private BigDecimal undrawn_balance_q4__over_3m_to_6m;
	private BigDecimal undrawn_balance_q4__over_6m_to_1y;
	private String nonfund_lc_bg_q1_segment;
	private BigDecimal nonfund_lc_bg_q1__1_day;
	private BigDecimal nonfund_lc_bg_q1__2_7_days;
	private BigDecimal nonfund_lc_bg_q1__8_14_days;
	private BigDecimal nonfund_lc_bg_q1__15_30_days;
	private BigDecimal nonfund_lc_bg_q1__31_60_days;
	private BigDecimal nonfund_lc_bg_q1__61_90_days;
	private String nonfund_lc_bg_q2_segment;
	private BigDecimal nonfund_lc_bg_q2__1_day;
	private BigDecimal nonfund_lc_bg_q2__2_7_days;
	private BigDecimal nonfund_lc_bg_q2__8_14_days;
	private BigDecimal nonfund_lc_bg_q2__15_30_days;
	private BigDecimal nonfund_lc_bg_q2__31_60_days;
	private BigDecimal nonfund_lc_bg_q2__61_90_days;
	private String nonfund_lc_bg_q3_segment;
	private BigDecimal nonfund_lc_bg_q3__1_day;
	private BigDecimal nonfund_lc_bg_q3__2_7_days;
	private BigDecimal nonfund_lc_bg_q3__8_14_days;
	private BigDecimal nonfund_lc_bg_q3__15_30_days;
	private BigDecimal nonfund_lc_bg_q3__31_60_days;
	private BigDecimal nonfund_lc_bg_q3__61_90_days;
	private String nonfund_lc_bg_q4_segment;
	private BigDecimal nonfund_lc_bg_q4__1_day;
	private BigDecimal nonfund_lc_bg_q4__2_7_days;
	private BigDecimal nonfund_lc_bg_q4__8_14_days;
	private BigDecimal nonfund_lc_bg_q4__15_30_days;
	private BigDecimal nonfund_lc_bg_q4__31_60_days;
	private BigDecimal nonfund_lc_bg_q4__61_90_days;
	private BigDecimal sp_prepayment;
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date reportDate;
	@Temporal(TemporalType.DATE)
	private Date report_from_date;
	@Temporal(TemporalType.DATE)
	private Date report_to_date;
	private String create_user;
	@Temporal(TemporalType.DATE)
	private Date create_time;
	private String modify_user;
	@Temporal(TemporalType.DATE)
	private Date modify_time;
	private String verify_user;
	@Temporal(TemporalType.DATE)
	private Date verify_time;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public String getQuarter_name() {
		return quarter_name;
	}
	public void setQuarter_name(String quarter_name) {
		this.quarter_name = quarter_name;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getSb_q1_segment() {
		return sb_q1_segment;
	}
	public void setSb_q1_segment(String sb_q1_segment) {
		this.sb_q1_segment = sb_q1_segment;
	}
	public BigDecimal getSb_q1__1_day_outflow() {
		return sb_q1__1_day_outflow;
	}
	public void setSb_q1__1_day_outflow(BigDecimal sb_q1__1_day_outflow) {
		this.sb_q1__1_day_outflow = sb_q1__1_day_outflow;
	}
	public BigDecimal getSb_q1__2_7_days_out_flow() {
		return sb_q1__2_7_days_out_flow;
	}
	public void setSb_q1__2_7_days_out_flow(BigDecimal sb_q1__2_7_days_out_flow) {
		this.sb_q1__2_7_days_out_flow = sb_q1__2_7_days_out_flow;
	}
	public BigDecimal getSb_q1__8_14_days_outflow() {
		return sb_q1__8_14_days_outflow;
	}
	public void setSb_q1__8_14_days_outflow(BigDecimal sb_q1__8_14_days_outflow) {
		this.sb_q1__8_14_days_outflow = sb_q1__8_14_days_outflow;
	}
	public BigDecimal getSb_q1__1_3_years() {
		return sb_q1__1_3_years;
	}
	public void setSb_q1__1_3_years(BigDecimal sb_q1__1_3_years) {
		this.sb_q1__1_3_years = sb_q1__1_3_years;
	}
	public BigDecimal getSb_q1__above_5_years() {
		return sb_q1__above_5_years;
	}
	public void setSb_q1__above_5_years(BigDecimal sb_q1__above_5_years) {
		this.sb_q1__above_5_years = sb_q1__above_5_years;
	}
	public String getSb_q2_segment() {
		return sb_q2_segment;
	}
	public void setSb_q2_segment(String sb_q2_segment) {
		this.sb_q2_segment = sb_q2_segment;
	}
	public BigDecimal getSb_q2__1_day_outflow() {
		return sb_q2__1_day_outflow;
	}
	public void setSb_q2__1_day_outflow(BigDecimal sb_q2__1_day_outflow) {
		this.sb_q2__1_day_outflow = sb_q2__1_day_outflow;
	}
	public BigDecimal getSb_q2__2_7_days_out_flow() {
		return sb_q2__2_7_days_out_flow;
	}
	public void setSb_q2__2_7_days_out_flow(BigDecimal sb_q2__2_7_days_out_flow) {
		this.sb_q2__2_7_days_out_flow = sb_q2__2_7_days_out_flow;
	}
	public BigDecimal getSb_q2__8_14_days_outflow() {
		return sb_q2__8_14_days_outflow;
	}
	public void setSb_q2__8_14_days_outflow(BigDecimal sb_q2__8_14_days_outflow) {
		this.sb_q2__8_14_days_outflow = sb_q2__8_14_days_outflow;
	}
	public BigDecimal getSb_q2__1_3_years() {
		return sb_q2__1_3_years;
	}
	public void setSb_q2__1_3_years(BigDecimal sb_q2__1_3_years) {
		this.sb_q2__1_3_years = sb_q2__1_3_years;
	}
	public BigDecimal getSb_q2__above_5_years() {
		return sb_q2__above_5_years;
	}
	public void setSb_q2__above_5_years(BigDecimal sb_q2__above_5_years) {
		this.sb_q2__above_5_years = sb_q2__above_5_years;
	}
	public String getSb_q3_segment() {
		return sb_q3_segment;
	}
	public void setSb_q3_segment(String sb_q3_segment) {
		this.sb_q3_segment = sb_q3_segment;
	}
	public BigDecimal getSb_q3__1_day_outflow() {
		return sb_q3__1_day_outflow;
	}
	public void setSb_q3__1_day_outflow(BigDecimal sb_q3__1_day_outflow) {
		this.sb_q3__1_day_outflow = sb_q3__1_day_outflow;
	}
	public BigDecimal getSb_q3__2_7_days_out_flow() {
		return sb_q3__2_7_days_out_flow;
	}
	public void setSb_q3__2_7_days_out_flow(BigDecimal sb_q3__2_7_days_out_flow) {
		this.sb_q3__2_7_days_out_flow = sb_q3__2_7_days_out_flow;
	}
	public BigDecimal getSb_q3__8_14_days_outflow() {
		return sb_q3__8_14_days_outflow;
	}
	public void setSb_q3__8_14_days_outflow(BigDecimal sb_q3__8_14_days_outflow) {
		this.sb_q3__8_14_days_outflow = sb_q3__8_14_days_outflow;
	}
	public BigDecimal getSb_q3__1_3_years() {
		return sb_q3__1_3_years;
	}
	public void setSb_q3__1_3_years(BigDecimal sb_q3__1_3_years) {
		this.sb_q3__1_3_years = sb_q3__1_3_years;
	}
	public BigDecimal getSb_q3__above_5_years() {
		return sb_q3__above_5_years;
	}
	public void setSb_q3__above_5_years(BigDecimal sb_q3__above_5_years) {
		this.sb_q3__above_5_years = sb_q3__above_5_years;
	}
	public String getSb_q4_segment() {
		return sb_q4_segment;
	}
	public void setSb_q4_segment(String sb_q4_segment) {
		this.sb_q4_segment = sb_q4_segment;
	}
	public BigDecimal getSb_q4__1_day_outflow() {
		return sb_q4__1_day_outflow;
	}
	public void setSb_q4__1_day_outflow(BigDecimal sb_q4__1_day_outflow) {
		this.sb_q4__1_day_outflow = sb_q4__1_day_outflow;
	}
	public BigDecimal getSb_q4__2_7_days_out_flow() {
		return sb_q4__2_7_days_out_flow;
	}
	public void setSb_q4__2_7_days_out_flow(BigDecimal sb_q4__2_7_days_out_flow) {
		this.sb_q4__2_7_days_out_flow = sb_q4__2_7_days_out_flow;
	}
	public BigDecimal getSb_q4__8_14_days_outflow() {
		return sb_q4__8_14_days_outflow;
	}
	public void setSb_q4__8_14_days_outflow(BigDecimal sb_q4__8_14_days_outflow) {
		this.sb_q4__8_14_days_outflow = sb_q4__8_14_days_outflow;
	}
	public BigDecimal getSb_q4__1_3_years() {
		return sb_q4__1_3_years;
	}
	public void setSb_q4__1_3_years(BigDecimal sb_q4__1_3_years) {
		this.sb_q4__1_3_years = sb_q4__1_3_years;
	}
	public BigDecimal getSb_q4__above_5_years() {
		return sb_q4__above_5_years;
	}
	public void setSb_q4__above_5_years(BigDecimal sb_q4__above_5_years) {
		this.sb_q4__above_5_years = sb_q4__above_5_years;
	}
	public String getCa_q1_segment() {
		return ca_q1_segment;
	}
	public void setCa_q1_segment(String ca_q1_segment) {
		this.ca_q1_segment = ca_q1_segment;
	}
	public BigDecimal getCa_q1__1_day_outflow() {
		return ca_q1__1_day_outflow;
	}
	public void setCa_q1__1_day_outflow(BigDecimal ca_q1__1_day_outflow) {
		this.ca_q1__1_day_outflow = ca_q1__1_day_outflow;
	}
	public BigDecimal getCa_q1__2_7_days_out_flow() {
		return ca_q1__2_7_days_out_flow;
	}
	public void setCa_q1__2_7_days_out_flow(BigDecimal ca_q1__2_7_days_out_flow) {
		this.ca_q1__2_7_days_out_flow = ca_q1__2_7_days_out_flow;
	}
	public BigDecimal getCa_q1__8_14_days_outflow() {
		return ca_q1__8_14_days_outflow;
	}
	public void setCa_q1__8_14_days_outflow(BigDecimal ca_q1__8_14_days_outflow) {
		this.ca_q1__8_14_days_outflow = ca_q1__8_14_days_outflow;
	}
	public BigDecimal getCa_q1__1_3_years() {
		return ca_q1__1_3_years;
	}
	public void setCa_q1__1_3_years(BigDecimal ca_q1__1_3_years) {
		this.ca_q1__1_3_years = ca_q1__1_3_years;
	}
	public BigDecimal getCa_q1__above_5_years() {
		return ca_q1__above_5_years;
	}
	public void setCa_q1__above_5_years(BigDecimal ca_q1__above_5_years) {
		this.ca_q1__above_5_years = ca_q1__above_5_years;
	}
	public String getCa_q2_segment() {
		return ca_q2_segment;
	}
	public void setCa_q2_segment(String ca_q2_segment) {
		this.ca_q2_segment = ca_q2_segment;
	}
	public BigDecimal getCa_q2__1_day_outflow() {
		return ca_q2__1_day_outflow;
	}
	public void setCa_q2__1_day_outflow(BigDecimal ca_q2__1_day_outflow) {
		this.ca_q2__1_day_outflow = ca_q2__1_day_outflow;
	}
	public BigDecimal getCa_q2__2_7_days_out_flow() {
		return ca_q2__2_7_days_out_flow;
	}
	public void setCa_q2__2_7_days_out_flow(BigDecimal ca_q2__2_7_days_out_flow) {
		this.ca_q2__2_7_days_out_flow = ca_q2__2_7_days_out_flow;
	}
	public BigDecimal getCa_q2__8_14_days_outflow() {
		return ca_q2__8_14_days_outflow;
	}
	public void setCa_q2__8_14_days_outflow(BigDecimal ca_q2__8_14_days_outflow) {
		this.ca_q2__8_14_days_outflow = ca_q2__8_14_days_outflow;
	}
	public BigDecimal getCa_q2__1_3_years() {
		return ca_q2__1_3_years;
	}
	public void setCa_q2__1_3_years(BigDecimal ca_q2__1_3_years) {
		this.ca_q2__1_3_years = ca_q2__1_3_years;
	}
	public BigDecimal getCa_q2__above_5_years() {
		return ca_q2__above_5_years;
	}
	public void setCa_q2__above_5_years(BigDecimal ca_q2__above_5_years) {
		this.ca_q2__above_5_years = ca_q2__above_5_years;
	}
	public String getCa_q3_segment() {
		return ca_q3_segment;
	}
	public void setCa_q3_segment(String ca_q3_segment) {
		this.ca_q3_segment = ca_q3_segment;
	}
	public BigDecimal getCa_q3__1_day_outflow() {
		return ca_q3__1_day_outflow;
	}
	public void setCa_q3__1_day_outflow(BigDecimal ca_q3__1_day_outflow) {
		this.ca_q3__1_day_outflow = ca_q3__1_day_outflow;
	}
	public BigDecimal getCa_q3__2_7_days_out_flow() {
		return ca_q3__2_7_days_out_flow;
	}
	public void setCa_q3__2_7_days_out_flow(BigDecimal ca_q3__2_7_days_out_flow) {
		this.ca_q3__2_7_days_out_flow = ca_q3__2_7_days_out_flow;
	}
	public BigDecimal getCa_q3__8_14_days_outflow() {
		return ca_q3__8_14_days_outflow;
	}
	public void setCa_q3__8_14_days_outflow(BigDecimal ca_q3__8_14_days_outflow) {
		this.ca_q3__8_14_days_outflow = ca_q3__8_14_days_outflow;
	}
	public BigDecimal getCa_q3__1_3_years() {
		return ca_q3__1_3_years;
	}
	public void setCa_q3__1_3_years(BigDecimal ca_q3__1_3_years) {
		this.ca_q3__1_3_years = ca_q3__1_3_years;
	}
	public BigDecimal getCa_q3__above_5_years() {
		return ca_q3__above_5_years;
	}
	public void setCa_q3__above_5_years(BigDecimal ca_q3__above_5_years) {
		this.ca_q3__above_5_years = ca_q3__above_5_years;
	}
	public String getCa_q4_segment() {
		return ca_q4_segment;
	}
	public void setCa_q4_segment(String ca_q4_segment) {
		this.ca_q4_segment = ca_q4_segment;
	}
	public BigDecimal getCa_q4__1_day_outflow() {
		return ca_q4__1_day_outflow;
	}
	public void setCa_q4__1_day_outflow(BigDecimal ca_q4__1_day_outflow) {
		this.ca_q4__1_day_outflow = ca_q4__1_day_outflow;
	}
	public BigDecimal getCa_q4__2_7_days_out_flow() {
		return ca_q4__2_7_days_out_flow;
	}
	public void setCa_q4__2_7_days_out_flow(BigDecimal ca_q4__2_7_days_out_flow) {
		this.ca_q4__2_7_days_out_flow = ca_q4__2_7_days_out_flow;
	}
	public BigDecimal getCa_q4__8_14_days_outflow() {
		return ca_q4__8_14_days_outflow;
	}
	public void setCa_q4__8_14_days_outflow(BigDecimal ca_q4__8_14_days_outflow) {
		this.ca_q4__8_14_days_outflow = ca_q4__8_14_days_outflow;
	}
	public BigDecimal getCa_q4__1_3_years() {
		return ca_q4__1_3_years;
	}
	public void setCa_q4__1_3_years(BigDecimal ca_q4__1_3_years) {
		this.ca_q4__1_3_years = ca_q4__1_3_years;
	}
	public BigDecimal getCa_q4__above_5_years() {
		return ca_q4__above_5_years;
	}
	public void setCa_q4__above_5_years(BigDecimal ca_q4__above_5_years) {
		this.ca_q4__above_5_years = ca_q4__above_5_years;
	}
	public String getOd_q1_segment() {
		return od_q1_segment;
	}
	public void setOd_q1_segment(String od_q1_segment) {
		this.od_q1_segment = od_q1_segment;
	}
	public BigDecimal getOd_q1__1_day_outflow() {
		return od_q1__1_day_outflow;
	}
	public void setOd_q1__1_day_outflow(BigDecimal od_q1__1_day_outflow) {
		this.od_q1__1_day_outflow = od_q1__1_day_outflow;
	}
	public BigDecimal getOd_q1__2_7_days_out_flow() {
		return od_q1__2_7_days_out_flow;
	}
	public void setOd_q1__2_7_days_out_flow(BigDecimal od_q1__2_7_days_out_flow) {
		this.od_q1__2_7_days_out_flow = od_q1__2_7_days_out_flow;
	}
	public BigDecimal getOd_q1__8_14_days_outflow() {
		return od_q1__8_14_days_outflow;
	}
	public void setOd_q1__8_14_days_outflow(BigDecimal od_q1__8_14_days_outflow) {
		this.od_q1__8_14_days_outflow = od_q1__8_14_days_outflow;
	}
	public BigDecimal getOd_q1__1_3_years() {
		return od_q1__1_3_years;
	}
	public void setOd_q1__1_3_years(BigDecimal od_q1__1_3_years) {
		this.od_q1__1_3_years = od_q1__1_3_years;
	}
	public BigDecimal getOd_q1__above_5_years() {
		return od_q1__above_5_years;
	}
	public void setOd_q1__above_5_years(BigDecimal od_q1__above_5_years) {
		this.od_q1__above_5_years = od_q1__above_5_years;
	}
	public String getOd_q2_segment() {
		return od_q2_segment;
	}
	public void setOd_q2_segment(String od_q2_segment) {
		this.od_q2_segment = od_q2_segment;
	}
	public BigDecimal getOd_q2__1_day_outflow() {
		return od_q2__1_day_outflow;
	}
	public void setOd_q2__1_day_outflow(BigDecimal od_q2__1_day_outflow) {
		this.od_q2__1_day_outflow = od_q2__1_day_outflow;
	}
	public BigDecimal getOd_q2__2_7_days_out_flow() {
		return od_q2__2_7_days_out_flow;
	}
	public void setOd_q2__2_7_days_out_flow(BigDecimal od_q2__2_7_days_out_flow) {
		this.od_q2__2_7_days_out_flow = od_q2__2_7_days_out_flow;
	}
	public BigDecimal getOd_q2__8_14_days_outflow() {
		return od_q2__8_14_days_outflow;
	}
	public void setOd_q2__8_14_days_outflow(BigDecimal od_q2__8_14_days_outflow) {
		this.od_q2__8_14_days_outflow = od_q2__8_14_days_outflow;
	}
	public BigDecimal getOd_q2__1_3_years() {
		return od_q2__1_3_years;
	}
	public void setOd_q2__1_3_years(BigDecimal od_q2__1_3_years) {
		this.od_q2__1_3_years = od_q2__1_3_years;
	}
	public BigDecimal getOd_q2__above_5_years() {
		return od_q2__above_5_years;
	}
	public void setOd_q2__above_5_years(BigDecimal od_q2__above_5_years) {
		this.od_q2__above_5_years = od_q2__above_5_years;
	}
	public String getOd_q3_segment() {
		return od_q3_segment;
	}
	public void setOd_q3_segment(String od_q3_segment) {
		this.od_q3_segment = od_q3_segment;
	}
	public BigDecimal getOd_q3__1_day_outflow() {
		return od_q3__1_day_outflow;
	}
	public void setOd_q3__1_day_outflow(BigDecimal od_q3__1_day_outflow) {
		this.od_q3__1_day_outflow = od_q3__1_day_outflow;
	}
	public BigDecimal getOd_q3__2_7_days_out_flow() {
		return od_q3__2_7_days_out_flow;
	}
	public void setOd_q3__2_7_days_out_flow(BigDecimal od_q3__2_7_days_out_flow) {
		this.od_q3__2_7_days_out_flow = od_q3__2_7_days_out_flow;
	}
	public BigDecimal getOd_q3__8_14_days_outflow() {
		return od_q3__8_14_days_outflow;
	}
	public void setOd_q3__8_14_days_outflow(BigDecimal od_q3__8_14_days_outflow) {
		this.od_q3__8_14_days_outflow = od_q3__8_14_days_outflow;
	}
	public BigDecimal getOd_q3__1_3_years() {
		return od_q3__1_3_years;
	}
	public void setOd_q3__1_3_years(BigDecimal od_q3__1_3_years) {
		this.od_q3__1_3_years = od_q3__1_3_years;
	}
	public BigDecimal getOd_q3__above_5_years() {
		return od_q3__above_5_years;
	}
	public void setOd_q3__above_5_years(BigDecimal od_q3__above_5_years) {
		this.od_q3__above_5_years = od_q3__above_5_years;
	}
	public String getOd_q4_segment() {
		return od_q4_segment;
	}
	public void setOd_q4_segment(String od_q4_segment) {
		this.od_q4_segment = od_q4_segment;
	}
	public BigDecimal getOd_q4__1_day_outflow() {
		return od_q4__1_day_outflow;
	}
	public void setOd_q4__1_day_outflow(BigDecimal od_q4__1_day_outflow) {
		this.od_q4__1_day_outflow = od_q4__1_day_outflow;
	}
	public BigDecimal getOd_q4__2_7_days_out_flow() {
		return od_q4__2_7_days_out_flow;
	}
	public void setOd_q4__2_7_days_out_flow(BigDecimal od_q4__2_7_days_out_flow) {
		this.od_q4__2_7_days_out_flow = od_q4__2_7_days_out_flow;
	}
	public BigDecimal getOd_q4__8_14_days_outflow() {
		return od_q4__8_14_days_outflow;
	}
	public void setOd_q4__8_14_days_outflow(BigDecimal od_q4__8_14_days_outflow) {
		this.od_q4__8_14_days_outflow = od_q4__8_14_days_outflow;
	}
	public BigDecimal getOd_q4__1_3_years() {
		return od_q4__1_3_years;
	}
	public void setOd_q4__1_3_years(BigDecimal od_q4__1_3_years) {
		this.od_q4__1_3_years = od_q4__1_3_years;
	}
	public BigDecimal getOd_q4__above_5_years() {
		return od_q4__above_5_years;
	}
	public void setOd_q4__above_5_years(BigDecimal od_q4__above_5_years) {
		this.od_q4__above_5_years = od_q4__above_5_years;
	}
	public String getBills_payable_q1_segment() {
		return bills_payable_q1_segment;
	}
	public void setBills_payable_q1_segment(String bills_payable_q1_segment) {
		this.bills_payable_q1_segment = bills_payable_q1_segment;
	}
	public BigDecimal getBills_payable_q1__1_day_outflow() {
		return bills_payable_q1__1_day_outflow;
	}
	public void setBills_payable_q1__1_day_outflow(BigDecimal bills_payable_q1__1_day_outflow) {
		this.bills_payable_q1__1_day_outflow = bills_payable_q1__1_day_outflow;
	}
	public BigDecimal getBills_payable_q1__2_7_days_out_flow() {
		return bills_payable_q1__2_7_days_out_flow;
	}
	public void setBills_payable_q1__2_7_days_out_flow(BigDecimal bills_payable_q1__2_7_days_out_flow) {
		this.bills_payable_q1__2_7_days_out_flow = bills_payable_q1__2_7_days_out_flow;
	}
	public BigDecimal getBills_payable_q1__8_14_days_outflow() {
		return bills_payable_q1__8_14_days_outflow;
	}
	public void setBills_payable_q1__8_14_days_outflow(BigDecimal bills_payable_q1__8_14_days_outflow) {
		this.bills_payable_q1__8_14_days_outflow = bills_payable_q1__8_14_days_outflow;
	}
	public BigDecimal getBills_payable_q1__1_3_years() {
		return bills_payable_q1__1_3_years;
	}
	public void setBills_payable_q1__1_3_years(BigDecimal bills_payable_q1__1_3_years) {
		this.bills_payable_q1__1_3_years = bills_payable_q1__1_3_years;
	}
	public BigDecimal getBills_payable_q1__above_5_years() {
		return bills_payable_q1__above_5_years;
	}
	public void setBills_payable_q1__above_5_years(BigDecimal bills_payable_q1__above_5_years) {
		this.bills_payable_q1__above_5_years = bills_payable_q1__above_5_years;
	}
	public String getBills_payable_q2_segment() {
		return bills_payable_q2_segment;
	}
	public void setBills_payable_q2_segment(String bills_payable_q2_segment) {
		this.bills_payable_q2_segment = bills_payable_q2_segment;
	}
	public BigDecimal getBills_payable_q2__1_day_outflow() {
		return bills_payable_q2__1_day_outflow;
	}
	public void setBills_payable_q2__1_day_outflow(BigDecimal bills_payable_q2__1_day_outflow) {
		this.bills_payable_q2__1_day_outflow = bills_payable_q2__1_day_outflow;
	}
	public BigDecimal getBills_payable_q2__2_7_days_out_flow() {
		return bills_payable_q2__2_7_days_out_flow;
	}
	public void setBills_payable_q2__2_7_days_out_flow(BigDecimal bills_payable_q2__2_7_days_out_flow) {
		this.bills_payable_q2__2_7_days_out_flow = bills_payable_q2__2_7_days_out_flow;
	}
	public BigDecimal getBills_payable_q2__8_14_days_outflow() {
		return bills_payable_q2__8_14_days_outflow;
	}
	public void setBills_payable_q2__8_14_days_outflow(BigDecimal bills_payable_q2__8_14_days_outflow) {
		this.bills_payable_q2__8_14_days_outflow = bills_payable_q2__8_14_days_outflow;
	}
	public BigDecimal getBills_payable_q2__1_3_years() {
		return bills_payable_q2__1_3_years;
	}
	public void setBills_payable_q2__1_3_years(BigDecimal bills_payable_q2__1_3_years) {
		this.bills_payable_q2__1_3_years = bills_payable_q2__1_3_years;
	}
	public BigDecimal getBills_payable_q2__above_5_years() {
		return bills_payable_q2__above_5_years;
	}
	public void setBills_payable_q2__above_5_years(BigDecimal bills_payable_q2__above_5_years) {
		this.bills_payable_q2__above_5_years = bills_payable_q2__above_5_years;
	}
	public String getBills_payable_q3_segment() {
		return bills_payable_q3_segment;
	}
	public void setBills_payable_q3_segment(String bills_payable_q3_segment) {
		this.bills_payable_q3_segment = bills_payable_q3_segment;
	}
	public BigDecimal getBills_payable_q3__1_day_outflow() {
		return bills_payable_q3__1_day_outflow;
	}
	public void setBills_payable_q3__1_day_outflow(BigDecimal bills_payable_q3__1_day_outflow) {
		this.bills_payable_q3__1_day_outflow = bills_payable_q3__1_day_outflow;
	}
	public BigDecimal getBills_payable_q3__2_7_days_out_flow() {
		return bills_payable_q3__2_7_days_out_flow;
	}
	public void setBills_payable_q3__2_7_days_out_flow(BigDecimal bills_payable_q3__2_7_days_out_flow) {
		this.bills_payable_q3__2_7_days_out_flow = bills_payable_q3__2_7_days_out_flow;
	}
	public BigDecimal getBills_payable_q3__8_14_days_outflow() {
		return bills_payable_q3__8_14_days_outflow;
	}
	public void setBills_payable_q3__8_14_days_outflow(BigDecimal bills_payable_q3__8_14_days_outflow) {
		this.bills_payable_q3__8_14_days_outflow = bills_payable_q3__8_14_days_outflow;
	}
	public BigDecimal getBills_payable_q3__1_3_years() {
		return bills_payable_q3__1_3_years;
	}
	public void setBills_payable_q3__1_3_years(BigDecimal bills_payable_q3__1_3_years) {
		this.bills_payable_q3__1_3_years = bills_payable_q3__1_3_years;
	}
	public BigDecimal getBills_payable_q3__above_5_years() {
		return bills_payable_q3__above_5_years;
	}
	public void setBills_payable_q3__above_5_years(BigDecimal bills_payable_q3__above_5_years) {
		this.bills_payable_q3__above_5_years = bills_payable_q3__above_5_years;
	}
	public String getBills_payable_q4_segment() {
		return bills_payable_q4_segment;
	}
	public void setBills_payable_q4_segment(String bills_payable_q4_segment) {
		this.bills_payable_q4_segment = bills_payable_q4_segment;
	}
	public BigDecimal getBills_payable_q4__1_day_outflow() {
		return bills_payable_q4__1_day_outflow;
	}
	public void setBills_payable_q4__1_day_outflow(BigDecimal bills_payable_q4__1_day_outflow) {
		this.bills_payable_q4__1_day_outflow = bills_payable_q4__1_day_outflow;
	}
	public BigDecimal getBills_payable_q4__2_7_days_out_flow() {
		return bills_payable_q4__2_7_days_out_flow;
	}
	public void setBills_payable_q4__2_7_days_out_flow(BigDecimal bills_payable_q4__2_7_days_out_flow) {
		this.bills_payable_q4__2_7_days_out_flow = bills_payable_q4__2_7_days_out_flow;
	}
	public BigDecimal getBills_payable_q4__8_14_days_outflow() {
		return bills_payable_q4__8_14_days_outflow;
	}
	public void setBills_payable_q4__8_14_days_outflow(BigDecimal bills_payable_q4__8_14_days_outflow) {
		this.bills_payable_q4__8_14_days_outflow = bills_payable_q4__8_14_days_outflow;
	}
	public BigDecimal getBills_payable_q4__1_3_years() {
		return bills_payable_q4__1_3_years;
	}
	public void setBills_payable_q4__1_3_years(BigDecimal bills_payable_q4__1_3_years) {
		this.bills_payable_q4__1_3_years = bills_payable_q4__1_3_years;
	}
	public BigDecimal getBills_payable_q4__above_5_years() {
		return bills_payable_q4__above_5_years;
	}
	public void setBills_payable_q4__above_5_years(BigDecimal bills_payable_q4__above_5_years) {
		this.bills_payable_q4__above_5_years = bills_payable_q4__above_5_years;
	}
	public BigDecimal getTerm_deposit_retail__rollover_sdr() {
		return term_deposit_retail__rollover_sdr;
	}
	public void setTerm_deposit_retail__rollover_sdr(BigDecimal term_deposit_retail__rollover_sdr) {
		this.term_deposit_retail__rollover_sdr = term_deposit_retail__rollover_sdr;
	}
	public BigDecimal getTerm_deposit_retail__rollover_fdr() {
		return term_deposit_retail__rollover_fdr;
	}
	public void setTerm_deposit_retail__rollover_fdr(BigDecimal term_deposit_retail__rollover_fdr) {
		this.term_deposit_retail__rollover_fdr = term_deposit_retail__rollover_fdr;
	}
	public BigDecimal getTerm_deposit_retail__premature_sdr() {
		return term_deposit_retail__premature_sdr;
	}
	public void setTerm_deposit_retail__premature_sdr(BigDecimal term_deposit_retail__premature_sdr) {
		this.term_deposit_retail__premature_sdr = term_deposit_retail__premature_sdr;
	}
	public BigDecimal getTerm_deposit_retail__premature_fdr() {
		return term_deposit_retail__premature_fdr;
	}
	public void setTerm_deposit_retail__premature_fdr(BigDecimal term_deposit_retail__premature_fdr) {
		this.term_deposit_retail__premature_fdr = term_deposit_retail__premature_fdr;
	}
	public String getUndrawn_balance_q1_segment() {
		return undrawn_balance_q1_segment;
	}
	public void setUndrawn_balance_q1_segment(String undrawn_balance_q1_segment) {
		this.undrawn_balance_q1_segment = undrawn_balance_q1_segment;
	}
	public BigDecimal getUndrawn_balance_q1__total() {
		return undrawn_balance_q1__total;
	}
	public void setUndrawn_balance_q1__total(BigDecimal undrawn_balance_q1__total) {
		this.undrawn_balance_q1__total = undrawn_balance_q1__total;
	}
	public BigDecimal getUndrawn_balance_q1__day_1() {
		return undrawn_balance_q1__day_1;
	}
	public void setUndrawn_balance_q1__day_1(BigDecimal undrawn_balance_q1__day_1) {
		this.undrawn_balance_q1__day_1 = undrawn_balance_q1__day_1;
	}
	public BigDecimal getUndrawn_balance_q1__2_7_days() {
		return undrawn_balance_q1__2_7_days;
	}
	public void setUndrawn_balance_q1__2_7_days(BigDecimal undrawn_balance_q1__2_7_days) {
		this.undrawn_balance_q1__2_7_days = undrawn_balance_q1__2_7_days;
	}
	public BigDecimal getUndrawn_balance_q1__8_14_days() {
		return undrawn_balance_q1__8_14_days;
	}
	public void setUndrawn_balance_q1__8_14_days(BigDecimal undrawn_balance_q1__8_14_days) {
		this.undrawn_balance_q1__8_14_days = undrawn_balance_q1__8_14_days;
	}
	public BigDecimal getUndrawn_balance_q1__15_30_days() {
		return undrawn_balance_q1__15_30_days;
	}
	public void setUndrawn_balance_q1__15_30_days(BigDecimal undrawn_balance_q1__15_30_days) {
		this.undrawn_balance_q1__15_30_days = undrawn_balance_q1__15_30_days;
	}
	public BigDecimal getUndrawn_balance_q1__31_days_to_2_months() {
		return undrawn_balance_q1__31_days_to_2_months;
	}
	public void setUndrawn_balance_q1__31_days_to_2_months(BigDecimal undrawn_balance_q1__31_days_to_2_months) {
		this.undrawn_balance_q1__31_days_to_2_months = undrawn_balance_q1__31_days_to_2_months;
	}
	public BigDecimal getUndrawn_balance_q1__more_than_2m_to_3m() {
		return undrawn_balance_q1__more_than_2m_to_3m;
	}
	public void setUndrawn_balance_q1__more_than_2m_to_3m(BigDecimal undrawn_balance_q1__more_than_2m_to_3m) {
		this.undrawn_balance_q1__more_than_2m_to_3m = undrawn_balance_q1__more_than_2m_to_3m;
	}
	public BigDecimal getUndrawn_balance_q1__over_3m_to_6m() {
		return undrawn_balance_q1__over_3m_to_6m;
	}
	public void setUndrawn_balance_q1__over_3m_to_6m(BigDecimal undrawn_balance_q1__over_3m_to_6m) {
		this.undrawn_balance_q1__over_3m_to_6m = undrawn_balance_q1__over_3m_to_6m;
	}
	public BigDecimal getUndrawn_balance_q1__over_6m_to_1y() {
		return undrawn_balance_q1__over_6m_to_1y;
	}
	public void setUndrawn_balance_q1__over_6m_to_1y(BigDecimal undrawn_balance_q1__over_6m_to_1y) {
		this.undrawn_balance_q1__over_6m_to_1y = undrawn_balance_q1__over_6m_to_1y;
	}
	public String getUndrawn_balance_q2_segment() {
		return undrawn_balance_q2_segment;
	}
	public void setUndrawn_balance_q2_segment(String undrawn_balance_q2_segment) {
		this.undrawn_balance_q2_segment = undrawn_balance_q2_segment;
	}
	public BigDecimal getUndrawn_balance_q2__total() {
		return undrawn_balance_q2__total;
	}
	public void setUndrawn_balance_q2__total(BigDecimal undrawn_balance_q2__total) {
		this.undrawn_balance_q2__total = undrawn_balance_q2__total;
	}
	public BigDecimal getUndrawn_balance_q2__day_1() {
		return undrawn_balance_q2__day_1;
	}
	public void setUndrawn_balance_q2__day_1(BigDecimal undrawn_balance_q2__day_1) {
		this.undrawn_balance_q2__day_1 = undrawn_balance_q2__day_1;
	}
	public BigDecimal getUndrawn_balance_q2__2_7_days() {
		return undrawn_balance_q2__2_7_days;
	}
	public void setUndrawn_balance_q2__2_7_days(BigDecimal undrawn_balance_q2__2_7_days) {
		this.undrawn_balance_q2__2_7_days = undrawn_balance_q2__2_7_days;
	}
	public BigDecimal getUndrawn_balance_q2__8_14_days() {
		return undrawn_balance_q2__8_14_days;
	}
	public void setUndrawn_balance_q2__8_14_days(BigDecimal undrawn_balance_q2__8_14_days) {
		this.undrawn_balance_q2__8_14_days = undrawn_balance_q2__8_14_days;
	}
	public BigDecimal getUndrawn_balance_q2__15_30_days() {
		return undrawn_balance_q2__15_30_days;
	}
	public void setUndrawn_balance_q2__15_30_days(BigDecimal undrawn_balance_q2__15_30_days) {
		this.undrawn_balance_q2__15_30_days = undrawn_balance_q2__15_30_days;
	}
	public BigDecimal getUndrawn_balance_q2__31_days_to_2_months() {
		return undrawn_balance_q2__31_days_to_2_months;
	}
	public void setUndrawn_balance_q2__31_days_to_2_months(BigDecimal undrawn_balance_q2__31_days_to_2_months) {
		this.undrawn_balance_q2__31_days_to_2_months = undrawn_balance_q2__31_days_to_2_months;
	}
	public BigDecimal getUndrawn_balance_q2__more_than_2m_to_3m() {
		return undrawn_balance_q2__more_than_2m_to_3m;
	}
	public void setUndrawn_balance_q2__more_than_2m_to_3m(BigDecimal undrawn_balance_q2__more_than_2m_to_3m) {
		this.undrawn_balance_q2__more_than_2m_to_3m = undrawn_balance_q2__more_than_2m_to_3m;
	}
	public BigDecimal getUndrawn_balance_q2__over_3m_to_6m() {
		return undrawn_balance_q2__over_3m_to_6m;
	}
	public void setUndrawn_balance_q2__over_3m_to_6m(BigDecimal undrawn_balance_q2__over_3m_to_6m) {
		this.undrawn_balance_q2__over_3m_to_6m = undrawn_balance_q2__over_3m_to_6m;
	}
	public BigDecimal getUndrawn_balance_q2__over_6m_to_1y() {
		return undrawn_balance_q2__over_6m_to_1y;
	}
	public void setUndrawn_balance_q2__over_6m_to_1y(BigDecimal undrawn_balance_q2__over_6m_to_1y) {
		this.undrawn_balance_q2__over_6m_to_1y = undrawn_balance_q2__over_6m_to_1y;
	}
	public String getUndrawn_balance_q3_segment() {
		return undrawn_balance_q3_segment;
	}
	public void setUndrawn_balance_q3_segment(String undrawn_balance_q3_segment) {
		this.undrawn_balance_q3_segment = undrawn_balance_q3_segment;
	}
	public BigDecimal getUndrawn_balance_q3__total() {
		return undrawn_balance_q3__total;
	}
	public void setUndrawn_balance_q3__total(BigDecimal undrawn_balance_q3__total) {
		this.undrawn_balance_q3__total = undrawn_balance_q3__total;
	}
	public BigDecimal getUndrawn_balance_q3__day_1() {
		return undrawn_balance_q3__day_1;
	}
	public void setUndrawn_balance_q3__day_1(BigDecimal undrawn_balance_q3__day_1) {
		this.undrawn_balance_q3__day_1 = undrawn_balance_q3__day_1;
	}
	public BigDecimal getUndrawn_balance_q3__2_7_days() {
		return undrawn_balance_q3__2_7_days;
	}
	public void setUndrawn_balance_q3__2_7_days(BigDecimal undrawn_balance_q3__2_7_days) {
		this.undrawn_balance_q3__2_7_days = undrawn_balance_q3__2_7_days;
	}
	public BigDecimal getUndrawn_balance_q3__8_14_days() {
		return undrawn_balance_q3__8_14_days;
	}
	public void setUndrawn_balance_q3__8_14_days(BigDecimal undrawn_balance_q3__8_14_days) {
		this.undrawn_balance_q3__8_14_days = undrawn_balance_q3__8_14_days;
	}
	public BigDecimal getUndrawn_balance_q3__15_30_days() {
		return undrawn_balance_q3__15_30_days;
	}
	public void setUndrawn_balance_q3__15_30_days(BigDecimal undrawn_balance_q3__15_30_days) {
		this.undrawn_balance_q3__15_30_days = undrawn_balance_q3__15_30_days;
	}
	public BigDecimal getUndrawn_balance_q3__31_days_to_2_months() {
		return undrawn_balance_q3__31_days_to_2_months;
	}
	public void setUndrawn_balance_q3__31_days_to_2_months(BigDecimal undrawn_balance_q3__31_days_to_2_months) {
		this.undrawn_balance_q3__31_days_to_2_months = undrawn_balance_q3__31_days_to_2_months;
	}
	public BigDecimal getUndrawn_balance_q3__more_than_2m_to_3m() {
		return undrawn_balance_q3__more_than_2m_to_3m;
	}
	public void setUndrawn_balance_q3__more_than_2m_to_3m(BigDecimal undrawn_balance_q3__more_than_2m_to_3m) {
		this.undrawn_balance_q3__more_than_2m_to_3m = undrawn_balance_q3__more_than_2m_to_3m;
	}
	public BigDecimal getUndrawn_balance_q3__over_3m_to_6m() {
		return undrawn_balance_q3__over_3m_to_6m;
	}
	public void setUndrawn_balance_q3__over_3m_to_6m(BigDecimal undrawn_balance_q3__over_3m_to_6m) {
		this.undrawn_balance_q3__over_3m_to_6m = undrawn_balance_q3__over_3m_to_6m;
	}
	public BigDecimal getUndrawn_balance_q3__over_6m_to_1y() {
		return undrawn_balance_q3__over_6m_to_1y;
	}
	public void setUndrawn_balance_q3__over_6m_to_1y(BigDecimal undrawn_balance_q3__over_6m_to_1y) {
		this.undrawn_balance_q3__over_6m_to_1y = undrawn_balance_q3__over_6m_to_1y;
	}
	public String getUndrawn_balance_q4_segment() {
		return undrawn_balance_q4_segment;
	}
	public void setUndrawn_balance_q4_segment(String undrawn_balance_q4_segment) {
		this.undrawn_balance_q4_segment = undrawn_balance_q4_segment;
	}
	public BigDecimal getUndrawn_balance_q4__total() {
		return undrawn_balance_q4__total;
	}
	public void setUndrawn_balance_q4__total(BigDecimal undrawn_balance_q4__total) {
		this.undrawn_balance_q4__total = undrawn_balance_q4__total;
	}
	public BigDecimal getUndrawn_balance_q4__day_1() {
		return undrawn_balance_q4__day_1;
	}
	public void setUndrawn_balance_q4__day_1(BigDecimal undrawn_balance_q4__day_1) {
		this.undrawn_balance_q4__day_1 = undrawn_balance_q4__day_1;
	}
	public BigDecimal getUndrawn_balance_q4__2_7_days() {
		return undrawn_balance_q4__2_7_days;
	}
	public void setUndrawn_balance_q4__2_7_days(BigDecimal undrawn_balance_q4__2_7_days) {
		this.undrawn_balance_q4__2_7_days = undrawn_balance_q4__2_7_days;
	}
	public BigDecimal getUndrawn_balance_q4__8_14_days() {
		return undrawn_balance_q4__8_14_days;
	}
	public void setUndrawn_balance_q4__8_14_days(BigDecimal undrawn_balance_q4__8_14_days) {
		this.undrawn_balance_q4__8_14_days = undrawn_balance_q4__8_14_days;
	}
	public BigDecimal getUndrawn_balance_q4__15_30_days() {
		return undrawn_balance_q4__15_30_days;
	}
	public void setUndrawn_balance_q4__15_30_days(BigDecimal undrawn_balance_q4__15_30_days) {
		this.undrawn_balance_q4__15_30_days = undrawn_balance_q4__15_30_days;
	}
	public BigDecimal getUndrawn_balance_q4__31_days_to_2_months() {
		return undrawn_balance_q4__31_days_to_2_months;
	}
	public void setUndrawn_balance_q4__31_days_to_2_months(BigDecimal undrawn_balance_q4__31_days_to_2_months) {
		this.undrawn_balance_q4__31_days_to_2_months = undrawn_balance_q4__31_days_to_2_months;
	}
	public BigDecimal getUndrawn_balance_q4__more_than_2m_to_3m() {
		return undrawn_balance_q4__more_than_2m_to_3m;
	}
	public void setUndrawn_balance_q4__more_than_2m_to_3m(BigDecimal undrawn_balance_q4__more_than_2m_to_3m) {
		this.undrawn_balance_q4__more_than_2m_to_3m = undrawn_balance_q4__more_than_2m_to_3m;
	}
	public BigDecimal getUndrawn_balance_q4__over_3m_to_6m() {
		return undrawn_balance_q4__over_3m_to_6m;
	}
	public void setUndrawn_balance_q4__over_3m_to_6m(BigDecimal undrawn_balance_q4__over_3m_to_6m) {
		this.undrawn_balance_q4__over_3m_to_6m = undrawn_balance_q4__over_3m_to_6m;
	}
	public BigDecimal getUndrawn_balance_q4__over_6m_to_1y() {
		return undrawn_balance_q4__over_6m_to_1y;
	}
	public void setUndrawn_balance_q4__over_6m_to_1y(BigDecimal undrawn_balance_q4__over_6m_to_1y) {
		this.undrawn_balance_q4__over_6m_to_1y = undrawn_balance_q4__over_6m_to_1y;
	}
	public String getNonfund_lc_bg_q1_segment() {
		return nonfund_lc_bg_q1_segment;
	}
	public void setNonfund_lc_bg_q1_segment(String nonfund_lc_bg_q1_segment) {
		this.nonfund_lc_bg_q1_segment = nonfund_lc_bg_q1_segment;
	}
	public BigDecimal getNonfund_lc_bg_q1__1_day() {
		return nonfund_lc_bg_q1__1_day;
	}
	public void setNonfund_lc_bg_q1__1_day(BigDecimal nonfund_lc_bg_q1__1_day) {
		this.nonfund_lc_bg_q1__1_day = nonfund_lc_bg_q1__1_day;
	}
	public BigDecimal getNonfund_lc_bg_q1__2_7_days() {
		return nonfund_lc_bg_q1__2_7_days;
	}
	public void setNonfund_lc_bg_q1__2_7_days(BigDecimal nonfund_lc_bg_q1__2_7_days) {
		this.nonfund_lc_bg_q1__2_7_days = nonfund_lc_bg_q1__2_7_days;
	}
	public BigDecimal getNonfund_lc_bg_q1__8_14_days() {
		return nonfund_lc_bg_q1__8_14_days;
	}
	public void setNonfund_lc_bg_q1__8_14_days(BigDecimal nonfund_lc_bg_q1__8_14_days) {
		this.nonfund_lc_bg_q1__8_14_days = nonfund_lc_bg_q1__8_14_days;
	}
	public BigDecimal getNonfund_lc_bg_q1__15_30_days() {
		return nonfund_lc_bg_q1__15_30_days;
	}
	public void setNonfund_lc_bg_q1__15_30_days(BigDecimal nonfund_lc_bg_q1__15_30_days) {
		this.nonfund_lc_bg_q1__15_30_days = nonfund_lc_bg_q1__15_30_days;
	}
	public BigDecimal getNonfund_lc_bg_q1__31_60_days() {
		return nonfund_lc_bg_q1__31_60_days;
	}
	public void setNonfund_lc_bg_q1__31_60_days(BigDecimal nonfund_lc_bg_q1__31_60_days) {
		this.nonfund_lc_bg_q1__31_60_days = nonfund_lc_bg_q1__31_60_days;
	}
	public BigDecimal getNonfund_lc_bg_q1__61_90_days() {
		return nonfund_lc_bg_q1__61_90_days;
	}
	public void setNonfund_lc_bg_q1__61_90_days(BigDecimal nonfund_lc_bg_q1__61_90_days) {
		this.nonfund_lc_bg_q1__61_90_days = nonfund_lc_bg_q1__61_90_days;
	}
	public String getNonfund_lc_bg_q2_segment() {
		return nonfund_lc_bg_q2_segment;
	}
	public void setNonfund_lc_bg_q2_segment(String nonfund_lc_bg_q2_segment) {
		this.nonfund_lc_bg_q2_segment = nonfund_lc_bg_q2_segment;
	}
	public BigDecimal getNonfund_lc_bg_q2__1_day() {
		return nonfund_lc_bg_q2__1_day;
	}
	public void setNonfund_lc_bg_q2__1_day(BigDecimal nonfund_lc_bg_q2__1_day) {
		this.nonfund_lc_bg_q2__1_day = nonfund_lc_bg_q2__1_day;
	}
	public BigDecimal getNonfund_lc_bg_q2__2_7_days() {
		return nonfund_lc_bg_q2__2_7_days;
	}
	public void setNonfund_lc_bg_q2__2_7_days(BigDecimal nonfund_lc_bg_q2__2_7_days) {
		this.nonfund_lc_bg_q2__2_7_days = nonfund_lc_bg_q2__2_7_days;
	}
	public BigDecimal getNonfund_lc_bg_q2__8_14_days() {
		return nonfund_lc_bg_q2__8_14_days;
	}
	public void setNonfund_lc_bg_q2__8_14_days(BigDecimal nonfund_lc_bg_q2__8_14_days) {
		this.nonfund_lc_bg_q2__8_14_days = nonfund_lc_bg_q2__8_14_days;
	}
	public BigDecimal getNonfund_lc_bg_q2__15_30_days() {
		return nonfund_lc_bg_q2__15_30_days;
	}
	public void setNonfund_lc_bg_q2__15_30_days(BigDecimal nonfund_lc_bg_q2__15_30_days) {
		this.nonfund_lc_bg_q2__15_30_days = nonfund_lc_bg_q2__15_30_days;
	}
	public BigDecimal getNonfund_lc_bg_q2__31_60_days() {
		return nonfund_lc_bg_q2__31_60_days;
	}
	public void setNonfund_lc_bg_q2__31_60_days(BigDecimal nonfund_lc_bg_q2__31_60_days) {
		this.nonfund_lc_bg_q2__31_60_days = nonfund_lc_bg_q2__31_60_days;
	}
	public BigDecimal getNonfund_lc_bg_q2__61_90_days() {
		return nonfund_lc_bg_q2__61_90_days;
	}
	public void setNonfund_lc_bg_q2__61_90_days(BigDecimal nonfund_lc_bg_q2__61_90_days) {
		this.nonfund_lc_bg_q2__61_90_days = nonfund_lc_bg_q2__61_90_days;
	}
	public String getNonfund_lc_bg_q3_segment() {
		return nonfund_lc_bg_q3_segment;
	}
	public void setNonfund_lc_bg_q3_segment(String nonfund_lc_bg_q3_segment) {
		this.nonfund_lc_bg_q3_segment = nonfund_lc_bg_q3_segment;
	}
	public BigDecimal getNonfund_lc_bg_q3__1_day() {
		return nonfund_lc_bg_q3__1_day;
	}
	public void setNonfund_lc_bg_q3__1_day(BigDecimal nonfund_lc_bg_q3__1_day) {
		this.nonfund_lc_bg_q3__1_day = nonfund_lc_bg_q3__1_day;
	}
	public BigDecimal getNonfund_lc_bg_q3__2_7_days() {
		return nonfund_lc_bg_q3__2_7_days;
	}
	public void setNonfund_lc_bg_q3__2_7_days(BigDecimal nonfund_lc_bg_q3__2_7_days) {
		this.nonfund_lc_bg_q3__2_7_days = nonfund_lc_bg_q3__2_7_days;
	}
	public BigDecimal getNonfund_lc_bg_q3__8_14_days() {
		return nonfund_lc_bg_q3__8_14_days;
	}
	public void setNonfund_lc_bg_q3__8_14_days(BigDecimal nonfund_lc_bg_q3__8_14_days) {
		this.nonfund_lc_bg_q3__8_14_days = nonfund_lc_bg_q3__8_14_days;
	}
	public BigDecimal getNonfund_lc_bg_q3__15_30_days() {
		return nonfund_lc_bg_q3__15_30_days;
	}
	public void setNonfund_lc_bg_q3__15_30_days(BigDecimal nonfund_lc_bg_q3__15_30_days) {
		this.nonfund_lc_bg_q3__15_30_days = nonfund_lc_bg_q3__15_30_days;
	}
	public BigDecimal getNonfund_lc_bg_q3__31_60_days() {
		return nonfund_lc_bg_q3__31_60_days;
	}
	public void setNonfund_lc_bg_q3__31_60_days(BigDecimal nonfund_lc_bg_q3__31_60_days) {
		this.nonfund_lc_bg_q3__31_60_days = nonfund_lc_bg_q3__31_60_days;
	}
	public BigDecimal getNonfund_lc_bg_q3__61_90_days() {
		return nonfund_lc_bg_q3__61_90_days;
	}
	public void setNonfund_lc_bg_q3__61_90_days(BigDecimal nonfund_lc_bg_q3__61_90_days) {
		this.nonfund_lc_bg_q3__61_90_days = nonfund_lc_bg_q3__61_90_days;
	}
	public String getNonfund_lc_bg_q4_segment() {
		return nonfund_lc_bg_q4_segment;
	}
	public void setNonfund_lc_bg_q4_segment(String nonfund_lc_bg_q4_segment) {
		this.nonfund_lc_bg_q4_segment = nonfund_lc_bg_q4_segment;
	}
	public BigDecimal getNonfund_lc_bg_q4__1_day() {
		return nonfund_lc_bg_q4__1_day;
	}
	public void setNonfund_lc_bg_q4__1_day(BigDecimal nonfund_lc_bg_q4__1_day) {
		this.nonfund_lc_bg_q4__1_day = nonfund_lc_bg_q4__1_day;
	}
	public BigDecimal getNonfund_lc_bg_q4__2_7_days() {
		return nonfund_lc_bg_q4__2_7_days;
	}
	public void setNonfund_lc_bg_q4__2_7_days(BigDecimal nonfund_lc_bg_q4__2_7_days) {
		this.nonfund_lc_bg_q4__2_7_days = nonfund_lc_bg_q4__2_7_days;
	}
	public BigDecimal getNonfund_lc_bg_q4__8_14_days() {
		return nonfund_lc_bg_q4__8_14_days;
	}
	public void setNonfund_lc_bg_q4__8_14_days(BigDecimal nonfund_lc_bg_q4__8_14_days) {
		this.nonfund_lc_bg_q4__8_14_days = nonfund_lc_bg_q4__8_14_days;
	}
	public BigDecimal getNonfund_lc_bg_q4__15_30_days() {
		return nonfund_lc_bg_q4__15_30_days;
	}
	public void setNonfund_lc_bg_q4__15_30_days(BigDecimal nonfund_lc_bg_q4__15_30_days) {
		this.nonfund_lc_bg_q4__15_30_days = nonfund_lc_bg_q4__15_30_days;
	}
	public BigDecimal getNonfund_lc_bg_q4__31_60_days() {
		return nonfund_lc_bg_q4__31_60_days;
	}
	public void setNonfund_lc_bg_q4__31_60_days(BigDecimal nonfund_lc_bg_q4__31_60_days) {
		this.nonfund_lc_bg_q4__31_60_days = nonfund_lc_bg_q4__31_60_days;
	}
	public BigDecimal getNonfund_lc_bg_q4__61_90_days() {
		return nonfund_lc_bg_q4__61_90_days;
	}
	public void setNonfund_lc_bg_q4__61_90_days(BigDecimal nonfund_lc_bg_q4__61_90_days) {
		this.nonfund_lc_bg_q4__61_90_days = nonfund_lc_bg_q4__61_90_days;
	}
	public BigDecimal getSp_prepayment() {
		return sp_prepayment;
	}
	public void setSp_prepayment(BigDecimal sp_prepayment) {
		this.sp_prepayment = sp_prepayment;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
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
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
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
	@Override
	public String toString() {
		return "RT_SLS_BEHAVIOURAL_PER_ENTITY [srl_no=" + srl_no + ", quarter_name=" + quarter_name + ", segment="
				+ segment + ", sb_q1_segment=" + sb_q1_segment + ", sb_q1__1_day_outflow=" + sb_q1__1_day_outflow
				+ ", sb_q1__2_7_days_out_flow=" + sb_q1__2_7_days_out_flow + ", sb_q1__8_14_days_outflow="
				+ sb_q1__8_14_days_outflow + ", sb_q1__1_3_years=" + sb_q1__1_3_years + ", sb_q1__above_5_years="
				+ sb_q1__above_5_years + ", sb_q2_segment=" + sb_q2_segment + ", sb_q2__1_day_outflow="
				+ sb_q2__1_day_outflow + ", sb_q2__2_7_days_out_flow=" + sb_q2__2_7_days_out_flow
				+ ", sb_q2__8_14_days_outflow=" + sb_q2__8_14_days_outflow + ", sb_q2__1_3_years=" + sb_q2__1_3_years
				+ ", sb_q2__above_5_years=" + sb_q2__above_5_years + ", sb_q3_segment=" + sb_q3_segment
				+ ", sb_q3__1_day_outflow=" + sb_q3__1_day_outflow + ", sb_q3__2_7_days_out_flow="
				+ sb_q3__2_7_days_out_flow + ", sb_q3__8_14_days_outflow=" + sb_q3__8_14_days_outflow
				+ ", sb_q3__1_3_years=" + sb_q3__1_3_years + ", sb_q3__above_5_years=" + sb_q3__above_5_years
				+ ", sb_q4_segment=" + sb_q4_segment + ", sb_q4__1_day_outflow=" + sb_q4__1_day_outflow
				+ ", sb_q4__2_7_days_out_flow=" + sb_q4__2_7_days_out_flow + ", sb_q4__8_14_days_outflow="
				+ sb_q4__8_14_days_outflow + ", sb_q4__1_3_years=" + sb_q4__1_3_years + ", sb_q4__above_5_years="
				+ sb_q4__above_5_years + ", ca_q1_segment=" + ca_q1_segment + ", ca_q1__1_day_outflow="
				+ ca_q1__1_day_outflow + ", ca_q1__2_7_days_out_flow=" + ca_q1__2_7_days_out_flow
				+ ", ca_q1__8_14_days_outflow=" + ca_q1__8_14_days_outflow + ", ca_q1__1_3_years=" + ca_q1__1_3_years
				+ ", ca_q1__above_5_years=" + ca_q1__above_5_years + ", ca_q2_segment=" + ca_q2_segment
				+ ", ca_q2__1_day_outflow=" + ca_q2__1_day_outflow + ", ca_q2__2_7_days_out_flow="
				+ ca_q2__2_7_days_out_flow + ", ca_q2__8_14_days_outflow=" + ca_q2__8_14_days_outflow
				+ ", ca_q2__1_3_years=" + ca_q2__1_3_years + ", ca_q2__above_5_years=" + ca_q2__above_5_years
				+ ", ca_q3_segment=" + ca_q3_segment + ", ca_q3__1_day_outflow=" + ca_q3__1_day_outflow
				+ ", ca_q3__2_7_days_out_flow=" + ca_q3__2_7_days_out_flow + ", ca_q3__8_14_days_outflow="
				+ ca_q3__8_14_days_outflow + ", ca_q3__1_3_years=" + ca_q3__1_3_years + ", ca_q3__above_5_years="
				+ ca_q3__above_5_years + ", ca_q4_segment=" + ca_q4_segment + ", ca_q4__1_day_outflow="
				+ ca_q4__1_day_outflow + ", ca_q4__2_7_days_out_flow=" + ca_q4__2_7_days_out_flow
				+ ", ca_q4__8_14_days_outflow=" + ca_q4__8_14_days_outflow + ", ca_q4__1_3_years=" + ca_q4__1_3_years
				+ ", ca_q4__above_5_years=" + ca_q4__above_5_years + ", od_q1_segment=" + od_q1_segment
				+ ", od_q1__1_day_outflow=" + od_q1__1_day_outflow + ", od_q1__2_7_days_out_flow="
				+ od_q1__2_7_days_out_flow + ", od_q1__8_14_days_outflow=" + od_q1__8_14_days_outflow
				+ ", od_q1__1_3_years=" + od_q1__1_3_years + ", od_q1__above_5_years=" + od_q1__above_5_years
				+ ", od_q2_segment=" + od_q2_segment + ", od_q2__1_day_outflow=" + od_q2__1_day_outflow
				+ ", od_q2__2_7_days_out_flow=" + od_q2__2_7_days_out_flow + ", od_q2__8_14_days_outflow="
				+ od_q2__8_14_days_outflow + ", od_q2__1_3_years=" + od_q2__1_3_years + ", od_q2__above_5_years="
				+ od_q2__above_5_years + ", od_q3_segment=" + od_q3_segment + ", od_q3__1_day_outflow="
				+ od_q3__1_day_outflow + ", od_q3__2_7_days_out_flow=" + od_q3__2_7_days_out_flow
				+ ", od_q3__8_14_days_outflow=" + od_q3__8_14_days_outflow + ", od_q3__1_3_years=" + od_q3__1_3_years
				+ ", od_q3__above_5_years=" + od_q3__above_5_years + ", od_q4_segment=" + od_q4_segment
				+ ", od_q4__1_day_outflow=" + od_q4__1_day_outflow + ", od_q4__2_7_days_out_flow="
				+ od_q4__2_7_days_out_flow + ", od_q4__8_14_days_outflow=" + od_q4__8_14_days_outflow
				+ ", od_q4__1_3_years=" + od_q4__1_3_years + ", od_q4__above_5_years=" + od_q4__above_5_years
				+ ", bills_payable_q1_segment=" + bills_payable_q1_segment + ", bills_payable_q1__1_day_outflow="
				+ bills_payable_q1__1_day_outflow + ", bills_payable_q1__2_7_days_out_flow="
				+ bills_payable_q1__2_7_days_out_flow + ", bills_payable_q1__8_14_days_outflow="
				+ bills_payable_q1__8_14_days_outflow + ", bills_payable_q1__1_3_years=" + bills_payable_q1__1_3_years
				+ ", bills_payable_q1__above_5_years=" + bills_payable_q1__above_5_years + ", bills_payable_q2_segment="
				+ bills_payable_q2_segment + ", bills_payable_q2__1_day_outflow=" + bills_payable_q2__1_day_outflow
				+ ", bills_payable_q2__2_7_days_out_flow=" + bills_payable_q2__2_7_days_out_flow
				+ ", bills_payable_q2__8_14_days_outflow=" + bills_payable_q2__8_14_days_outflow
				+ ", bills_payable_q2__1_3_years=" + bills_payable_q2__1_3_years + ", bills_payable_q2__above_5_years="
				+ bills_payable_q2__above_5_years + ", bills_payable_q3_segment=" + bills_payable_q3_segment
				+ ", bills_payable_q3__1_day_outflow=" + bills_payable_q3__1_day_outflow
				+ ", bills_payable_q3__2_7_days_out_flow=" + bills_payable_q3__2_7_days_out_flow
				+ ", bills_payable_q3__8_14_days_outflow=" + bills_payable_q3__8_14_days_outflow
				+ ", bills_payable_q3__1_3_years=" + bills_payable_q3__1_3_years + ", bills_payable_q3__above_5_years="
				+ bills_payable_q3__above_5_years + ", bills_payable_q4_segment=" + bills_payable_q4_segment
				+ ", bills_payable_q4__1_day_outflow=" + bills_payable_q4__1_day_outflow
				+ ", bills_payable_q4__2_7_days_out_flow=" + bills_payable_q4__2_7_days_out_flow
				+ ", bills_payable_q4__8_14_days_outflow=" + bills_payable_q4__8_14_days_outflow
				+ ", bills_payable_q4__1_3_years=" + bills_payable_q4__1_3_years + ", bills_payable_q4__above_5_years="
				+ bills_payable_q4__above_5_years + ", term_deposit_retail__rollover_sdr="
				+ term_deposit_retail__rollover_sdr + ", term_deposit_retail__rollover_fdr="
				+ term_deposit_retail__rollover_fdr + ", term_deposit_retail__premature_sdr="
				+ term_deposit_retail__premature_sdr + ", term_deposit_retail__premature_fdr="
				+ term_deposit_retail__premature_fdr + ", undrawn_balance_q1_segment=" + undrawn_balance_q1_segment
				+ ", undrawn_balance_q1__total=" + undrawn_balance_q1__total + ", undrawn_balance_q1__day_1="
				+ undrawn_balance_q1__day_1 + ", undrawn_balance_q1__2_7_days=" + undrawn_balance_q1__2_7_days
				+ ", undrawn_balance_q1__8_14_days=" + undrawn_balance_q1__8_14_days
				+ ", undrawn_balance_q1__15_30_days=" + undrawn_balance_q1__15_30_days
				+ ", undrawn_balance_q1__31_days_to_2_months=" + undrawn_balance_q1__31_days_to_2_months
				+ ", undrawn_balance_q1__more_than_2m_to_3m=" + undrawn_balance_q1__more_than_2m_to_3m
				+ ", undrawn_balance_q1__over_3m_to_6m=" + undrawn_balance_q1__over_3m_to_6m
				+ ", undrawn_balance_q1__over_6m_to_1y=" + undrawn_balance_q1__over_6m_to_1y
				+ ", undrawn_balance_q2_segment=" + undrawn_balance_q2_segment + ", undrawn_balance_q2__total="
				+ undrawn_balance_q2__total + ", undrawn_balance_q2__day_1=" + undrawn_balance_q2__day_1
				+ ", undrawn_balance_q2__2_7_days=" + undrawn_balance_q2__2_7_days + ", undrawn_balance_q2__8_14_days="
				+ undrawn_balance_q2__8_14_days + ", undrawn_balance_q2__15_30_days=" + undrawn_balance_q2__15_30_days
				+ ", undrawn_balance_q2__31_days_to_2_months=" + undrawn_balance_q2__31_days_to_2_months
				+ ", undrawn_balance_q2__more_than_2m_to_3m=" + undrawn_balance_q2__more_than_2m_to_3m
				+ ", undrawn_balance_q2__over_3m_to_6m=" + undrawn_balance_q2__over_3m_to_6m
				+ ", undrawn_balance_q2__over_6m_to_1y=" + undrawn_balance_q2__over_6m_to_1y
				+ ", undrawn_balance_q3_segment=" + undrawn_balance_q3_segment + ", undrawn_balance_q3__total="
				+ undrawn_balance_q3__total + ", undrawn_balance_q3__day_1=" + undrawn_balance_q3__day_1
				+ ", undrawn_balance_q3__2_7_days=" + undrawn_balance_q3__2_7_days + ", undrawn_balance_q3__8_14_days="
				+ undrawn_balance_q3__8_14_days + ", undrawn_balance_q3__15_30_days=" + undrawn_balance_q3__15_30_days
				+ ", undrawn_balance_q3__31_days_to_2_months=" + undrawn_balance_q3__31_days_to_2_months
				+ ", undrawn_balance_q3__more_than_2m_to_3m=" + undrawn_balance_q3__more_than_2m_to_3m
				+ ", undrawn_balance_q3__over_3m_to_6m=" + undrawn_balance_q3__over_3m_to_6m
				+ ", undrawn_balance_q3__over_6m_to_1y=" + undrawn_balance_q3__over_6m_to_1y
				+ ", undrawn_balance_q4_segment=" + undrawn_balance_q4_segment + ", undrawn_balance_q4__total="
				+ undrawn_balance_q4__total + ", undrawn_balance_q4__day_1=" + undrawn_balance_q4__day_1
				+ ", undrawn_balance_q4__2_7_days=" + undrawn_balance_q4__2_7_days + ", undrawn_balance_q4__8_14_days="
				+ undrawn_balance_q4__8_14_days + ", undrawn_balance_q4__15_30_days=" + undrawn_balance_q4__15_30_days
				+ ", undrawn_balance_q4__31_days_to_2_months=" + undrawn_balance_q4__31_days_to_2_months
				+ ", undrawn_balance_q4__more_than_2m_to_3m=" + undrawn_balance_q4__more_than_2m_to_3m
				+ ", undrawn_balance_q4__over_3m_to_6m=" + undrawn_balance_q4__over_3m_to_6m
				+ ", undrawn_balance_q4__over_6m_to_1y=" + undrawn_balance_q4__over_6m_to_1y
				+ ", nonfund_lc_bg_q1_segment=" + nonfund_lc_bg_q1_segment + ", nonfund_lc_bg_q1__1_day="
				+ nonfund_lc_bg_q1__1_day + ", nonfund_lc_bg_q1__2_7_days=" + nonfund_lc_bg_q1__2_7_days
				+ ", nonfund_lc_bg_q1__8_14_days=" + nonfund_lc_bg_q1__8_14_days + ", nonfund_lc_bg_q1__15_30_days="
				+ nonfund_lc_bg_q1__15_30_days + ", nonfund_lc_bg_q1__31_60_days=" + nonfund_lc_bg_q1__31_60_days
				+ ", nonfund_lc_bg_q1__61_90_days=" + nonfund_lc_bg_q1__61_90_days + ", nonfund_lc_bg_q2_segment="
				+ nonfund_lc_bg_q2_segment + ", nonfund_lc_bg_q2__1_day=" + nonfund_lc_bg_q2__1_day
				+ ", nonfund_lc_bg_q2__2_7_days=" + nonfund_lc_bg_q2__2_7_days + ", nonfund_lc_bg_q2__8_14_days="
				+ nonfund_lc_bg_q2__8_14_days + ", nonfund_lc_bg_q2__15_30_days=" + nonfund_lc_bg_q2__15_30_days
				+ ", nonfund_lc_bg_q2__31_60_days=" + nonfund_lc_bg_q2__31_60_days + ", nonfund_lc_bg_q2__61_90_days="
				+ nonfund_lc_bg_q2__61_90_days + ", nonfund_lc_bg_q3_segment=" + nonfund_lc_bg_q3_segment
				+ ", nonfund_lc_bg_q3__1_day=" + nonfund_lc_bg_q3__1_day + ", nonfund_lc_bg_q3__2_7_days="
				+ nonfund_lc_bg_q3__2_7_days + ", nonfund_lc_bg_q3__8_14_days=" + nonfund_lc_bg_q3__8_14_days
				+ ", nonfund_lc_bg_q3__15_30_days=" + nonfund_lc_bg_q3__15_30_days + ", nonfund_lc_bg_q3__31_60_days="
				+ nonfund_lc_bg_q3__31_60_days + ", nonfund_lc_bg_q3__61_90_days=" + nonfund_lc_bg_q3__61_90_days
				+ ", nonfund_lc_bg_q4_segment=" + nonfund_lc_bg_q4_segment + ", nonfund_lc_bg_q4__1_day="
				+ nonfund_lc_bg_q4__1_day + ", nonfund_lc_bg_q4__2_7_days=" + nonfund_lc_bg_q4__2_7_days
				+ ", nonfund_lc_bg_q4__8_14_days=" + nonfund_lc_bg_q4__8_14_days + ", nonfund_lc_bg_q4__15_30_days="
				+ nonfund_lc_bg_q4__15_30_days + ", nonfund_lc_bg_q4__31_60_days=" + nonfund_lc_bg_q4__31_60_days
				+ ", nonfund_lc_bg_q4__61_90_days=" + nonfund_lc_bg_q4__61_90_days + ", sp_prepayment=" + sp_prepayment
				+ ", reportDate=" + reportDate + ", report_from_date=" + report_from_date + ", report_to_date="
				+ report_to_date + ", create_user=" + create_user + ", create_time=" + create_time + ", modify_user="
				+ modify_user + ", modify_time=" + modify_time + ", verify_user=" + verify_user + ", verify_time="
				+ verify_time + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", getSrl_no()=" + getSrl_no() + ", getQuarter_name()=" + getQuarter_name() + ", getSegment()="
				+ getSegment() + ", getSb_q1_segment()=" + getSb_q1_segment() + ", getSb_q1__1_day_outflow()="
				+ getSb_q1__1_day_outflow() + ", getSb_q1__2_7_days_out_flow()=" + getSb_q1__2_7_days_out_flow()
				+ ", getSb_q1__8_14_days_outflow()=" + getSb_q1__8_14_days_outflow() + ", getSb_q1__1_3_years()="
				+ getSb_q1__1_3_years() + ", getSb_q1__above_5_years()=" + getSb_q1__above_5_years()
				+ ", getSb_q2_segment()=" + getSb_q2_segment() + ", getSb_q2__1_day_outflow()="
				+ getSb_q2__1_day_outflow() + ", getSb_q2__2_7_days_out_flow()=" + getSb_q2__2_7_days_out_flow()
				+ ", getSb_q2__8_14_days_outflow()=" + getSb_q2__8_14_days_outflow() + ", getSb_q2__1_3_years()="
				+ getSb_q2__1_3_years() + ", getSb_q2__above_5_years()=" + getSb_q2__above_5_years()
				+ ", getSb_q3_segment()=" + getSb_q3_segment() + ", getSb_q3__1_day_outflow()="
				+ getSb_q3__1_day_outflow() + ", getSb_q3__2_7_days_out_flow()=" + getSb_q3__2_7_days_out_flow()
				+ ", getSb_q3__8_14_days_outflow()=" + getSb_q3__8_14_days_outflow() + ", getSb_q3__1_3_years()="
				+ getSb_q3__1_3_years() + ", getSb_q3__above_5_years()=" + getSb_q3__above_5_years()
				+ ", getSb_q4_segment()=" + getSb_q4_segment() + ", getSb_q4__1_day_outflow()="
				+ getSb_q4__1_day_outflow() + ", getSb_q4__2_7_days_out_flow()=" + getSb_q4__2_7_days_out_flow()
				+ ", getSb_q4__8_14_days_outflow()=" + getSb_q4__8_14_days_outflow() + ", getSb_q4__1_3_years()="
				+ getSb_q4__1_3_years() + ", getSb_q4__above_5_years()=" + getSb_q4__above_5_years()
				+ ", getCa_q1_segment()=" + getCa_q1_segment() + ", getCa_q1__1_day_outflow()="
				+ getCa_q1__1_day_outflow() + ", getCa_q1__2_7_days_out_flow()=" + getCa_q1__2_7_days_out_flow()
				+ ", getCa_q1__8_14_days_outflow()=" + getCa_q1__8_14_days_outflow() + ", getCa_q1__1_3_years()="
				+ getCa_q1__1_3_years() + ", getCa_q1__above_5_years()=" + getCa_q1__above_5_years()
				+ ", getCa_q2_segment()=" + getCa_q2_segment() + ", getCa_q2__1_day_outflow()="
				+ getCa_q2__1_day_outflow() + ", getCa_q2__2_7_days_out_flow()=" + getCa_q2__2_7_days_out_flow()
				+ ", getCa_q2__8_14_days_outflow()=" + getCa_q2__8_14_days_outflow() + ", getCa_q2__1_3_years()="
				+ getCa_q2__1_3_years() + ", getCa_q2__above_5_years()=" + getCa_q2__above_5_years()
				+ ", getCa_q3_segment()=" + getCa_q3_segment() + ", getCa_q3__1_day_outflow()="
				+ getCa_q3__1_day_outflow() + ", getCa_q3__2_7_days_out_flow()=" + getCa_q3__2_7_days_out_flow()
				+ ", getCa_q3__8_14_days_outflow()=" + getCa_q3__8_14_days_outflow() + ", getCa_q3__1_3_years()="
				+ getCa_q3__1_3_years() + ", getCa_q3__above_5_years()=" + getCa_q3__above_5_years()
				+ ", getCa_q4_segment()=" + getCa_q4_segment() + ", getCa_q4__1_day_outflow()="
				+ getCa_q4__1_day_outflow() + ", getCa_q4__2_7_days_out_flow()=" + getCa_q4__2_7_days_out_flow()
				+ ", getCa_q4__8_14_days_outflow()=" + getCa_q4__8_14_days_outflow() + ", getCa_q4__1_3_years()="
				+ getCa_q4__1_3_years() + ", getCa_q4__above_5_years()=" + getCa_q4__above_5_years()
				+ ", getOd_q1_segment()=" + getOd_q1_segment() + ", getOd_q1__1_day_outflow()="
				+ getOd_q1__1_day_outflow() + ", getOd_q1__2_7_days_out_flow()=" + getOd_q1__2_7_days_out_flow()
				+ ", getOd_q1__8_14_days_outflow()=" + getOd_q1__8_14_days_outflow() + ", getOd_q1__1_3_years()="
				+ getOd_q1__1_3_years() + ", getOd_q1__above_5_years()=" + getOd_q1__above_5_years()
				+ ", getOd_q2_segment()=" + getOd_q2_segment() + ", getOd_q2__1_day_outflow()="
				+ getOd_q2__1_day_outflow() + ", getOd_q2__2_7_days_out_flow()=" + getOd_q2__2_7_days_out_flow()
				+ ", getOd_q2__8_14_days_outflow()=" + getOd_q2__8_14_days_outflow() + ", getOd_q2__1_3_years()="
				+ getOd_q2__1_3_years() + ", getOd_q2__above_5_years()=" + getOd_q2__above_5_years()
				+ ", getOd_q3_segment()=" + getOd_q3_segment() + ", getOd_q3__1_day_outflow()="
				+ getOd_q3__1_day_outflow() + ", getOd_q3__2_7_days_out_flow()=" + getOd_q3__2_7_days_out_flow()
				+ ", getOd_q3__8_14_days_outflow()=" + getOd_q3__8_14_days_outflow() + ", getOd_q3__1_3_years()="
				+ getOd_q3__1_3_years() + ", getOd_q3__above_5_years()=" + getOd_q3__above_5_years()
				+ ", getOd_q4_segment()=" + getOd_q4_segment() + ", getOd_q4__1_day_outflow()="
				+ getOd_q4__1_day_outflow() + ", getOd_q4__2_7_days_out_flow()=" + getOd_q4__2_7_days_out_flow()
				+ ", getOd_q4__8_14_days_outflow()=" + getOd_q4__8_14_days_outflow() + ", getOd_q4__1_3_years()="
				+ getOd_q4__1_3_years() + ", getOd_q4__above_5_years()=" + getOd_q4__above_5_years()
				+ ", getBills_payable_q1_segment()=" + getBills_payable_q1_segment()
				+ ", getBills_payable_q1__1_day_outflow()=" + getBills_payable_q1__1_day_outflow()
				+ ", getBills_payable_q1__2_7_days_out_flow()=" + getBills_payable_q1__2_7_days_out_flow()
				+ ", getBills_payable_q1__8_14_days_outflow()=" + getBills_payable_q1__8_14_days_outflow()
				+ ", getBills_payable_q1__1_3_years()=" + getBills_payable_q1__1_3_years()
				+ ", getBills_payable_q1__above_5_years()=" + getBills_payable_q1__above_5_years()
				+ ", getBills_payable_q2_segment()=" + getBills_payable_q2_segment()
				+ ", getBills_payable_q2__1_day_outflow()=" + getBills_payable_q2__1_day_outflow()
				+ ", getBills_payable_q2__2_7_days_out_flow()=" + getBills_payable_q2__2_7_days_out_flow()
				+ ", getBills_payable_q2__8_14_days_outflow()=" + getBills_payable_q2__8_14_days_outflow()
				+ ", getBills_payable_q2__1_3_years()=" + getBills_payable_q2__1_3_years()
				+ ", getBills_payable_q2__above_5_years()=" + getBills_payable_q2__above_5_years()
				+ ", getBills_payable_q3_segment()=" + getBills_payable_q3_segment()
				+ ", getBills_payable_q3__1_day_outflow()=" + getBills_payable_q3__1_day_outflow()
				+ ", getBills_payable_q3__2_7_days_out_flow()=" + getBills_payable_q3__2_7_days_out_flow()
				+ ", getBills_payable_q3__8_14_days_outflow()=" + getBills_payable_q3__8_14_days_outflow()
				+ ", getBills_payable_q3__1_3_years()=" + getBills_payable_q3__1_3_years()
				+ ", getBills_payable_q3__above_5_years()=" + getBills_payable_q3__above_5_years()
				+ ", getBills_payable_q4_segment()=" + getBills_payable_q4_segment()
				+ ", getBills_payable_q4__1_day_outflow()=" + getBills_payable_q4__1_day_outflow()
				+ ", getBills_payable_q4__2_7_days_out_flow()=" + getBills_payable_q4__2_7_days_out_flow()
				+ ", getBills_payable_q4__8_14_days_outflow()=" + getBills_payable_q4__8_14_days_outflow()
				+ ", getBills_payable_q4__1_3_years()=" + getBills_payable_q4__1_3_years()
				+ ", getBills_payable_q4__above_5_years()=" + getBills_payable_q4__above_5_years()
				+ ", getTerm_deposit_retail__rollover_sdr()=" + getTerm_deposit_retail__rollover_sdr()
				+ ", getTerm_deposit_retail__rollover_fdr()=" + getTerm_deposit_retail__rollover_fdr()
				+ ", getTerm_deposit_retail__premature_sdr()=" + getTerm_deposit_retail__premature_sdr()
				+ ", getTerm_deposit_retail__premature_fdr()=" + getTerm_deposit_retail__premature_fdr()
				+ ", getUndrawn_balance_q1_segment()=" + getUndrawn_balance_q1_segment()
				+ ", getUndrawn_balance_q1__total()=" + getUndrawn_balance_q1__total()
				+ ", getUndrawn_balance_q1__day_1()=" + getUndrawn_balance_q1__day_1()
				+ ", getUndrawn_balance_q1__2_7_days()=" + getUndrawn_balance_q1__2_7_days()
				+ ", getUndrawn_balance_q1__8_14_days()=" + getUndrawn_balance_q1__8_14_days()
				+ ", getUndrawn_balance_q1__15_30_days()=" + getUndrawn_balance_q1__15_30_days()
				+ ", getUndrawn_balance_q1__31_days_to_2_months()=" + getUndrawn_balance_q1__31_days_to_2_months()
				+ ", getUndrawn_balance_q1__more_than_2m_to_3m()=" + getUndrawn_balance_q1__more_than_2m_to_3m()
				+ ", getUndrawn_balance_q1__over_3m_to_6m()=" + getUndrawn_balance_q1__over_3m_to_6m()
				+ ", getUndrawn_balance_q1__over_6m_to_1y()=" + getUndrawn_balance_q1__over_6m_to_1y()
				+ ", getUndrawn_balance_q2_segment()=" + getUndrawn_balance_q2_segment()
				+ ", getUndrawn_balance_q2__total()=" + getUndrawn_balance_q2__total()
				+ ", getUndrawn_balance_q2__day_1()=" + getUndrawn_balance_q2__day_1()
				+ ", getUndrawn_balance_q2__2_7_days()=" + getUndrawn_balance_q2__2_7_days()
				+ ", getUndrawn_balance_q2__8_14_days()=" + getUndrawn_balance_q2__8_14_days()
				+ ", getUndrawn_balance_q2__15_30_days()=" + getUndrawn_balance_q2__15_30_days()
				+ ", getUndrawn_balance_q2__31_days_to_2_months()=" + getUndrawn_balance_q2__31_days_to_2_months()
				+ ", getUndrawn_balance_q2__more_than_2m_to_3m()=" + getUndrawn_balance_q2__more_than_2m_to_3m()
				+ ", getUndrawn_balance_q2__over_3m_to_6m()=" + getUndrawn_balance_q2__over_3m_to_6m()
				+ ", getUndrawn_balance_q2__over_6m_to_1y()=" + getUndrawn_balance_q2__over_6m_to_1y()
				+ ", getUndrawn_balance_q3_segment()=" + getUndrawn_balance_q3_segment()
				+ ", getUndrawn_balance_q3__total()=" + getUndrawn_balance_q3__total()
				+ ", getUndrawn_balance_q3__day_1()=" + getUndrawn_balance_q3__day_1()
				+ ", getUndrawn_balance_q3__2_7_days()=" + getUndrawn_balance_q3__2_7_days()
				+ ", getUndrawn_balance_q3__8_14_days()=" + getUndrawn_balance_q3__8_14_days()
				+ ", getUndrawn_balance_q3__15_30_days()=" + getUndrawn_balance_q3__15_30_days()
				+ ", getUndrawn_balance_q3__31_days_to_2_months()=" + getUndrawn_balance_q3__31_days_to_2_months()
				+ ", getUndrawn_balance_q3__more_than_2m_to_3m()=" + getUndrawn_balance_q3__more_than_2m_to_3m()
				+ ", getUndrawn_balance_q3__over_3m_to_6m()=" + getUndrawn_balance_q3__over_3m_to_6m()
				+ ", getUndrawn_balance_q3__over_6m_to_1y()=" + getUndrawn_balance_q3__over_6m_to_1y()
				+ ", getUndrawn_balance_q4_segment()=" + getUndrawn_balance_q4_segment()
				+ ", getUndrawn_balance_q4__total()=" + getUndrawn_balance_q4__total()
				+ ", getUndrawn_balance_q4__day_1()=" + getUndrawn_balance_q4__day_1()
				+ ", getUndrawn_balance_q4__2_7_days()=" + getUndrawn_balance_q4__2_7_days()
				+ ", getUndrawn_balance_q4__8_14_days()=" + getUndrawn_balance_q4__8_14_days()
				+ ", getUndrawn_balance_q4__15_30_days()=" + getUndrawn_balance_q4__15_30_days()
				+ ", getUndrawn_balance_q4__31_days_to_2_months()=" + getUndrawn_balance_q4__31_days_to_2_months()
				+ ", getUndrawn_balance_q4__more_than_2m_to_3m()=" + getUndrawn_balance_q4__more_than_2m_to_3m()
				+ ", getUndrawn_balance_q4__over_3m_to_6m()=" + getUndrawn_balance_q4__over_3m_to_6m()
				+ ", getUndrawn_balance_q4__over_6m_to_1y()=" + getUndrawn_balance_q4__over_6m_to_1y()
				+ ", getNonfund_lc_bg_q1_segment()=" + getNonfund_lc_bg_q1_segment() + ", getNonfund_lc_bg_q1__1_day()="
				+ getNonfund_lc_bg_q1__1_day() + ", getNonfund_lc_bg_q1__2_7_days()=" + getNonfund_lc_bg_q1__2_7_days()
				+ ", getNonfund_lc_bg_q1__8_14_days()=" + getNonfund_lc_bg_q1__8_14_days()
				+ ", getNonfund_lc_bg_q1__15_30_days()=" + getNonfund_lc_bg_q1__15_30_days()
				+ ", getNonfund_lc_bg_q1__31_60_days()=" + getNonfund_lc_bg_q1__31_60_days()
				+ ", getNonfund_lc_bg_q1__61_90_days()=" + getNonfund_lc_bg_q1__61_90_days()
				+ ", getNonfund_lc_bg_q2_segment()=" + getNonfund_lc_bg_q2_segment() + ", getNonfund_lc_bg_q2__1_day()="
				+ getNonfund_lc_bg_q2__1_day() + ", getNonfund_lc_bg_q2__2_7_days()=" + getNonfund_lc_bg_q2__2_7_days()
				+ ", getNonfund_lc_bg_q2__8_14_days()=" + getNonfund_lc_bg_q2__8_14_days()
				+ ", getNonfund_lc_bg_q2__15_30_days()=" + getNonfund_lc_bg_q2__15_30_days()
				+ ", getNonfund_lc_bg_q2__31_60_days()=" + getNonfund_lc_bg_q2__31_60_days()
				+ ", getNonfund_lc_bg_q2__61_90_days()=" + getNonfund_lc_bg_q2__61_90_days()
				+ ", getNonfund_lc_bg_q3_segment()=" + getNonfund_lc_bg_q3_segment() + ", getNonfund_lc_bg_q3__1_day()="
				+ getNonfund_lc_bg_q3__1_day() + ", getNonfund_lc_bg_q3__2_7_days()=" + getNonfund_lc_bg_q3__2_7_days()
				+ ", getNonfund_lc_bg_q3__8_14_days()=" + getNonfund_lc_bg_q3__8_14_days()
				+ ", getNonfund_lc_bg_q3__15_30_days()=" + getNonfund_lc_bg_q3__15_30_days()
				+ ", getNonfund_lc_bg_q3__31_60_days()=" + getNonfund_lc_bg_q3__31_60_days()
				+ ", getNonfund_lc_bg_q3__61_90_days()=" + getNonfund_lc_bg_q3__61_90_days()
				+ ", getNonfund_lc_bg_q4_segment()=" + getNonfund_lc_bg_q4_segment() + ", getNonfund_lc_bg_q4__1_day()="
				+ getNonfund_lc_bg_q4__1_day() + ", getNonfund_lc_bg_q4__2_7_days()=" + getNonfund_lc_bg_q4__2_7_days()
				+ ", getNonfund_lc_bg_q4__8_14_days()=" + getNonfund_lc_bg_q4__8_14_days()
				+ ", getNonfund_lc_bg_q4__15_30_days()=" + getNonfund_lc_bg_q4__15_30_days()
				+ ", getNonfund_lc_bg_q4__31_60_days()=" + getNonfund_lc_bg_q4__31_60_days()
				+ ", getNonfund_lc_bg_q4__61_90_days()=" + getNonfund_lc_bg_q4__61_90_days() + ", getSp_prepayment()="
				+ getSp_prepayment() + ", getReportDate()=" + getReportDate() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getCreate_user()="
				+ getCreate_user() + ", getCreate_time()=" + getCreate_time() + ", getModify_user()=" + getModify_user()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_user()=" + getVerify_user()
				+ ", getVerify_time()=" + getVerify_time() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public RT_SLS_BEHAVIOURAL_PER_ENTITY(String srl_no, String quarter_name, String segment, String sb_q1_segment,
			BigDecimal sb_q1__1_day_outflow, BigDecimal sb_q1__2_7_days_out_flow, BigDecimal sb_q1__8_14_days_outflow,
			BigDecimal sb_q1__1_3_years, BigDecimal sb_q1__above_5_years, String sb_q2_segment,
			BigDecimal sb_q2__1_day_outflow, BigDecimal sb_q2__2_7_days_out_flow, BigDecimal sb_q2__8_14_days_outflow,
			BigDecimal sb_q2__1_3_years, BigDecimal sb_q2__above_5_years, String sb_q3_segment,
			BigDecimal sb_q3__1_day_outflow, BigDecimal sb_q3__2_7_days_out_flow, BigDecimal sb_q3__8_14_days_outflow,
			BigDecimal sb_q3__1_3_years, BigDecimal sb_q3__above_5_years, String sb_q4_segment,
			BigDecimal sb_q4__1_day_outflow, BigDecimal sb_q4__2_7_days_out_flow, BigDecimal sb_q4__8_14_days_outflow,
			BigDecimal sb_q4__1_3_years, BigDecimal sb_q4__above_5_years, String ca_q1_segment,
			BigDecimal ca_q1__1_day_outflow, BigDecimal ca_q1__2_7_days_out_flow, BigDecimal ca_q1__8_14_days_outflow,
			BigDecimal ca_q1__1_3_years, BigDecimal ca_q1__above_5_years, String ca_q2_segment,
			BigDecimal ca_q2__1_day_outflow, BigDecimal ca_q2__2_7_days_out_flow, BigDecimal ca_q2__8_14_days_outflow,
			BigDecimal ca_q2__1_3_years, BigDecimal ca_q2__above_5_years, String ca_q3_segment,
			BigDecimal ca_q3__1_day_outflow, BigDecimal ca_q3__2_7_days_out_flow, BigDecimal ca_q3__8_14_days_outflow,
			BigDecimal ca_q3__1_3_years, BigDecimal ca_q3__above_5_years, String ca_q4_segment,
			BigDecimal ca_q4__1_day_outflow, BigDecimal ca_q4__2_7_days_out_flow, BigDecimal ca_q4__8_14_days_outflow,
			BigDecimal ca_q4__1_3_years, BigDecimal ca_q4__above_5_years, String od_q1_segment,
			BigDecimal od_q1__1_day_outflow, BigDecimal od_q1__2_7_days_out_flow, BigDecimal od_q1__8_14_days_outflow,
			BigDecimal od_q1__1_3_years, BigDecimal od_q1__above_5_years, String od_q2_segment,
			BigDecimal od_q2__1_day_outflow, BigDecimal od_q2__2_7_days_out_flow, BigDecimal od_q2__8_14_days_outflow,
			BigDecimal od_q2__1_3_years, BigDecimal od_q2__above_5_years, String od_q3_segment,
			BigDecimal od_q3__1_day_outflow, BigDecimal od_q3__2_7_days_out_flow, BigDecimal od_q3__8_14_days_outflow,
			BigDecimal od_q3__1_3_years, BigDecimal od_q3__above_5_years, String od_q4_segment,
			BigDecimal od_q4__1_day_outflow, BigDecimal od_q4__2_7_days_out_flow, BigDecimal od_q4__8_14_days_outflow,
			BigDecimal od_q4__1_3_years, BigDecimal od_q4__above_5_years, String bills_payable_q1_segment,
			BigDecimal bills_payable_q1__1_day_outflow, BigDecimal bills_payable_q1__2_7_days_out_flow,
			BigDecimal bills_payable_q1__8_14_days_outflow, BigDecimal bills_payable_q1__1_3_years,
			BigDecimal bills_payable_q1__above_5_years, String bills_payable_q2_segment,
			BigDecimal bills_payable_q2__1_day_outflow, BigDecimal bills_payable_q2__2_7_days_out_flow,
			BigDecimal bills_payable_q2__8_14_days_outflow, BigDecimal bills_payable_q2__1_3_years,
			BigDecimal bills_payable_q2__above_5_years, String bills_payable_q3_segment,
			BigDecimal bills_payable_q3__1_day_outflow, BigDecimal bills_payable_q3__2_7_days_out_flow,
			BigDecimal bills_payable_q3__8_14_days_outflow, BigDecimal bills_payable_q3__1_3_years,
			BigDecimal bills_payable_q3__above_5_years, String bills_payable_q4_segment,
			BigDecimal bills_payable_q4__1_day_outflow, BigDecimal bills_payable_q4__2_7_days_out_flow,
			BigDecimal bills_payable_q4__8_14_days_outflow, BigDecimal bills_payable_q4__1_3_years,
			BigDecimal bills_payable_q4__above_5_years, BigDecimal term_deposit_retail__rollover_sdr,
			BigDecimal term_deposit_retail__rollover_fdr, BigDecimal term_deposit_retail__premature_sdr,
			BigDecimal term_deposit_retail__premature_fdr, String undrawn_balance_q1_segment,
			BigDecimal undrawn_balance_q1__total, BigDecimal undrawn_balance_q1__day_1,
			BigDecimal undrawn_balance_q1__2_7_days, BigDecimal undrawn_balance_q1__8_14_days,
			BigDecimal undrawn_balance_q1__15_30_days, BigDecimal undrawn_balance_q1__31_days_to_2_months,
			BigDecimal undrawn_balance_q1__more_than_2m_to_3m, BigDecimal undrawn_balance_q1__over_3m_to_6m,
			BigDecimal undrawn_balance_q1__over_6m_to_1y, String undrawn_balance_q2_segment,
			BigDecimal undrawn_balance_q2__total, BigDecimal undrawn_balance_q2__day_1,
			BigDecimal undrawn_balance_q2__2_7_days, BigDecimal undrawn_balance_q2__8_14_days,
			BigDecimal undrawn_balance_q2__15_30_days, BigDecimal undrawn_balance_q2__31_days_to_2_months,
			BigDecimal undrawn_balance_q2__more_than_2m_to_3m, BigDecimal undrawn_balance_q2__over_3m_to_6m,
			BigDecimal undrawn_balance_q2__over_6m_to_1y, String undrawn_balance_q3_segment,
			BigDecimal undrawn_balance_q3__total, BigDecimal undrawn_balance_q3__day_1,
			BigDecimal undrawn_balance_q3__2_7_days, BigDecimal undrawn_balance_q3__8_14_days,
			BigDecimal undrawn_balance_q3__15_30_days, BigDecimal undrawn_balance_q3__31_days_to_2_months,
			BigDecimal undrawn_balance_q3__more_than_2m_to_3m, BigDecimal undrawn_balance_q3__over_3m_to_6m,
			BigDecimal undrawn_balance_q3__over_6m_to_1y, String undrawn_balance_q4_segment,
			BigDecimal undrawn_balance_q4__total, BigDecimal undrawn_balance_q4__day_1,
			BigDecimal undrawn_balance_q4__2_7_days, BigDecimal undrawn_balance_q4__8_14_days,
			BigDecimal undrawn_balance_q4__15_30_days, BigDecimal undrawn_balance_q4__31_days_to_2_months,
			BigDecimal undrawn_balance_q4__more_than_2m_to_3m, BigDecimal undrawn_balance_q4__over_3m_to_6m,
			BigDecimal undrawn_balance_q4__over_6m_to_1y, String nonfund_lc_bg_q1_segment,
			BigDecimal nonfund_lc_bg_q1__1_day, BigDecimal nonfund_lc_bg_q1__2_7_days,
			BigDecimal nonfund_lc_bg_q1__8_14_days, BigDecimal nonfund_lc_bg_q1__15_30_days,
			BigDecimal nonfund_lc_bg_q1__31_60_days, BigDecimal nonfund_lc_bg_q1__61_90_days,
			String nonfund_lc_bg_q2_segment, BigDecimal nonfund_lc_bg_q2__1_day, BigDecimal nonfund_lc_bg_q2__2_7_days,
			BigDecimal nonfund_lc_bg_q2__8_14_days, BigDecimal nonfund_lc_bg_q2__15_30_days,
			BigDecimal nonfund_lc_bg_q2__31_60_days, BigDecimal nonfund_lc_bg_q2__61_90_days,
			String nonfund_lc_bg_q3_segment, BigDecimal nonfund_lc_bg_q3__1_day, BigDecimal nonfund_lc_bg_q3__2_7_days,
			BigDecimal nonfund_lc_bg_q3__8_14_days, BigDecimal nonfund_lc_bg_q3__15_30_days,
			BigDecimal nonfund_lc_bg_q3__31_60_days, BigDecimal nonfund_lc_bg_q3__61_90_days,
			String nonfund_lc_bg_q4_segment, BigDecimal nonfund_lc_bg_q4__1_day, BigDecimal nonfund_lc_bg_q4__2_7_days,
			BigDecimal nonfund_lc_bg_q4__8_14_days, BigDecimal nonfund_lc_bg_q4__15_30_days,
			BigDecimal nonfund_lc_bg_q4__31_60_days, BigDecimal nonfund_lc_bg_q4__61_90_days, BigDecimal sp_prepayment,
			Date reportDate, Date report_from_date, Date report_to_date, String create_user, Date create_time,
			String modify_user, Date modify_time, String verify_user, Date verify_time, String entity_flg,
			String modify_flg, String del_flg) {
		super();
		this.srl_no = srl_no;
		this.quarter_name = quarter_name;
		this.segment = segment;
		this.sb_q1_segment = sb_q1_segment;
		this.sb_q1__1_day_outflow = sb_q1__1_day_outflow;
		this.sb_q1__2_7_days_out_flow = sb_q1__2_7_days_out_flow;
		this.sb_q1__8_14_days_outflow = sb_q1__8_14_days_outflow;
		this.sb_q1__1_3_years = sb_q1__1_3_years;
		this.sb_q1__above_5_years = sb_q1__above_5_years;
		this.sb_q2_segment = sb_q2_segment;
		this.sb_q2__1_day_outflow = sb_q2__1_day_outflow;
		this.sb_q2__2_7_days_out_flow = sb_q2__2_7_days_out_flow;
		this.sb_q2__8_14_days_outflow = sb_q2__8_14_days_outflow;
		this.sb_q2__1_3_years = sb_q2__1_3_years;
		this.sb_q2__above_5_years = sb_q2__above_5_years;
		this.sb_q3_segment = sb_q3_segment;
		this.sb_q3__1_day_outflow = sb_q3__1_day_outflow;
		this.sb_q3__2_7_days_out_flow = sb_q3__2_7_days_out_flow;
		this.sb_q3__8_14_days_outflow = sb_q3__8_14_days_outflow;
		this.sb_q3__1_3_years = sb_q3__1_3_years;
		this.sb_q3__above_5_years = sb_q3__above_5_years;
		this.sb_q4_segment = sb_q4_segment;
		this.sb_q4__1_day_outflow = sb_q4__1_day_outflow;
		this.sb_q4__2_7_days_out_flow = sb_q4__2_7_days_out_flow;
		this.sb_q4__8_14_days_outflow = sb_q4__8_14_days_outflow;
		this.sb_q4__1_3_years = sb_q4__1_3_years;
		this.sb_q4__above_5_years = sb_q4__above_5_years;
		this.ca_q1_segment = ca_q1_segment;
		this.ca_q1__1_day_outflow = ca_q1__1_day_outflow;
		this.ca_q1__2_7_days_out_flow = ca_q1__2_7_days_out_flow;
		this.ca_q1__8_14_days_outflow = ca_q1__8_14_days_outflow;
		this.ca_q1__1_3_years = ca_q1__1_3_years;
		this.ca_q1__above_5_years = ca_q1__above_5_years;
		this.ca_q2_segment = ca_q2_segment;
		this.ca_q2__1_day_outflow = ca_q2__1_day_outflow;
		this.ca_q2__2_7_days_out_flow = ca_q2__2_7_days_out_flow;
		this.ca_q2__8_14_days_outflow = ca_q2__8_14_days_outflow;
		this.ca_q2__1_3_years = ca_q2__1_3_years;
		this.ca_q2__above_5_years = ca_q2__above_5_years;
		this.ca_q3_segment = ca_q3_segment;
		this.ca_q3__1_day_outflow = ca_q3__1_day_outflow;
		this.ca_q3__2_7_days_out_flow = ca_q3__2_7_days_out_flow;
		this.ca_q3__8_14_days_outflow = ca_q3__8_14_days_outflow;
		this.ca_q3__1_3_years = ca_q3__1_3_years;
		this.ca_q3__above_5_years = ca_q3__above_5_years;
		this.ca_q4_segment = ca_q4_segment;
		this.ca_q4__1_day_outflow = ca_q4__1_day_outflow;
		this.ca_q4__2_7_days_out_flow = ca_q4__2_7_days_out_flow;
		this.ca_q4__8_14_days_outflow = ca_q4__8_14_days_outflow;
		this.ca_q4__1_3_years = ca_q4__1_3_years;
		this.ca_q4__above_5_years = ca_q4__above_5_years;
		this.od_q1_segment = od_q1_segment;
		this.od_q1__1_day_outflow = od_q1__1_day_outflow;
		this.od_q1__2_7_days_out_flow = od_q1__2_7_days_out_flow;
		this.od_q1__8_14_days_outflow = od_q1__8_14_days_outflow;
		this.od_q1__1_3_years = od_q1__1_3_years;
		this.od_q1__above_5_years = od_q1__above_5_years;
		this.od_q2_segment = od_q2_segment;
		this.od_q2__1_day_outflow = od_q2__1_day_outflow;
		this.od_q2__2_7_days_out_flow = od_q2__2_7_days_out_flow;
		this.od_q2__8_14_days_outflow = od_q2__8_14_days_outflow;
		this.od_q2__1_3_years = od_q2__1_3_years;
		this.od_q2__above_5_years = od_q2__above_5_years;
		this.od_q3_segment = od_q3_segment;
		this.od_q3__1_day_outflow = od_q3__1_day_outflow;
		this.od_q3__2_7_days_out_flow = od_q3__2_7_days_out_flow;
		this.od_q3__8_14_days_outflow = od_q3__8_14_days_outflow;
		this.od_q3__1_3_years = od_q3__1_3_years;
		this.od_q3__above_5_years = od_q3__above_5_years;
		this.od_q4_segment = od_q4_segment;
		this.od_q4__1_day_outflow = od_q4__1_day_outflow;
		this.od_q4__2_7_days_out_flow = od_q4__2_7_days_out_flow;
		this.od_q4__8_14_days_outflow = od_q4__8_14_days_outflow;
		this.od_q4__1_3_years = od_q4__1_3_years;
		this.od_q4__above_5_years = od_q4__above_5_years;
		this.bills_payable_q1_segment = bills_payable_q1_segment;
		this.bills_payable_q1__1_day_outflow = bills_payable_q1__1_day_outflow;
		this.bills_payable_q1__2_7_days_out_flow = bills_payable_q1__2_7_days_out_flow;
		this.bills_payable_q1__8_14_days_outflow = bills_payable_q1__8_14_days_outflow;
		this.bills_payable_q1__1_3_years = bills_payable_q1__1_3_years;
		this.bills_payable_q1__above_5_years = bills_payable_q1__above_5_years;
		this.bills_payable_q2_segment = bills_payable_q2_segment;
		this.bills_payable_q2__1_day_outflow = bills_payable_q2__1_day_outflow;
		this.bills_payable_q2__2_7_days_out_flow = bills_payable_q2__2_7_days_out_flow;
		this.bills_payable_q2__8_14_days_outflow = bills_payable_q2__8_14_days_outflow;
		this.bills_payable_q2__1_3_years = bills_payable_q2__1_3_years;
		this.bills_payable_q2__above_5_years = bills_payable_q2__above_5_years;
		this.bills_payable_q3_segment = bills_payable_q3_segment;
		this.bills_payable_q3__1_day_outflow = bills_payable_q3__1_day_outflow;
		this.bills_payable_q3__2_7_days_out_flow = bills_payable_q3__2_7_days_out_flow;
		this.bills_payable_q3__8_14_days_outflow = bills_payable_q3__8_14_days_outflow;
		this.bills_payable_q3__1_3_years = bills_payable_q3__1_3_years;
		this.bills_payable_q3__above_5_years = bills_payable_q3__above_5_years;
		this.bills_payable_q4_segment = bills_payable_q4_segment;
		this.bills_payable_q4__1_day_outflow = bills_payable_q4__1_day_outflow;
		this.bills_payable_q4__2_7_days_out_flow = bills_payable_q4__2_7_days_out_flow;
		this.bills_payable_q4__8_14_days_outflow = bills_payable_q4__8_14_days_outflow;
		this.bills_payable_q4__1_3_years = bills_payable_q4__1_3_years;
		this.bills_payable_q4__above_5_years = bills_payable_q4__above_5_years;
		this.term_deposit_retail__rollover_sdr = term_deposit_retail__rollover_sdr;
		this.term_deposit_retail__rollover_fdr = term_deposit_retail__rollover_fdr;
		this.term_deposit_retail__premature_sdr = term_deposit_retail__premature_sdr;
		this.term_deposit_retail__premature_fdr = term_deposit_retail__premature_fdr;
		this.undrawn_balance_q1_segment = undrawn_balance_q1_segment;
		this.undrawn_balance_q1__total = undrawn_balance_q1__total;
		this.undrawn_balance_q1__day_1 = undrawn_balance_q1__day_1;
		this.undrawn_balance_q1__2_7_days = undrawn_balance_q1__2_7_days;
		this.undrawn_balance_q1__8_14_days = undrawn_balance_q1__8_14_days;
		this.undrawn_balance_q1__15_30_days = undrawn_balance_q1__15_30_days;
		this.undrawn_balance_q1__31_days_to_2_months = undrawn_balance_q1__31_days_to_2_months;
		this.undrawn_balance_q1__more_than_2m_to_3m = undrawn_balance_q1__more_than_2m_to_3m;
		this.undrawn_balance_q1__over_3m_to_6m = undrawn_balance_q1__over_3m_to_6m;
		this.undrawn_balance_q1__over_6m_to_1y = undrawn_balance_q1__over_6m_to_1y;
		this.undrawn_balance_q2_segment = undrawn_balance_q2_segment;
		this.undrawn_balance_q2__total = undrawn_balance_q2__total;
		this.undrawn_balance_q2__day_1 = undrawn_balance_q2__day_1;
		this.undrawn_balance_q2__2_7_days = undrawn_balance_q2__2_7_days;
		this.undrawn_balance_q2__8_14_days = undrawn_balance_q2__8_14_days;
		this.undrawn_balance_q2__15_30_days = undrawn_balance_q2__15_30_days;
		this.undrawn_balance_q2__31_days_to_2_months = undrawn_balance_q2__31_days_to_2_months;
		this.undrawn_balance_q2__more_than_2m_to_3m = undrawn_balance_q2__more_than_2m_to_3m;
		this.undrawn_balance_q2__over_3m_to_6m = undrawn_balance_q2__over_3m_to_6m;
		this.undrawn_balance_q2__over_6m_to_1y = undrawn_balance_q2__over_6m_to_1y;
		this.undrawn_balance_q3_segment = undrawn_balance_q3_segment;
		this.undrawn_balance_q3__total = undrawn_balance_q3__total;
		this.undrawn_balance_q3__day_1 = undrawn_balance_q3__day_1;
		this.undrawn_balance_q3__2_7_days = undrawn_balance_q3__2_7_days;
		this.undrawn_balance_q3__8_14_days = undrawn_balance_q3__8_14_days;
		this.undrawn_balance_q3__15_30_days = undrawn_balance_q3__15_30_days;
		this.undrawn_balance_q3__31_days_to_2_months = undrawn_balance_q3__31_days_to_2_months;
		this.undrawn_balance_q3__more_than_2m_to_3m = undrawn_balance_q3__more_than_2m_to_3m;
		this.undrawn_balance_q3__over_3m_to_6m = undrawn_balance_q3__over_3m_to_6m;
		this.undrawn_balance_q3__over_6m_to_1y = undrawn_balance_q3__over_6m_to_1y;
		this.undrawn_balance_q4_segment = undrawn_balance_q4_segment;
		this.undrawn_balance_q4__total = undrawn_balance_q4__total;
		this.undrawn_balance_q4__day_1 = undrawn_balance_q4__day_1;
		this.undrawn_balance_q4__2_7_days = undrawn_balance_q4__2_7_days;
		this.undrawn_balance_q4__8_14_days = undrawn_balance_q4__8_14_days;
		this.undrawn_balance_q4__15_30_days = undrawn_balance_q4__15_30_days;
		this.undrawn_balance_q4__31_days_to_2_months = undrawn_balance_q4__31_days_to_2_months;
		this.undrawn_balance_q4__more_than_2m_to_3m = undrawn_balance_q4__more_than_2m_to_3m;
		this.undrawn_balance_q4__over_3m_to_6m = undrawn_balance_q4__over_3m_to_6m;
		this.undrawn_balance_q4__over_6m_to_1y = undrawn_balance_q4__over_6m_to_1y;
		this.nonfund_lc_bg_q1_segment = nonfund_lc_bg_q1_segment;
		this.nonfund_lc_bg_q1__1_day = nonfund_lc_bg_q1__1_day;
		this.nonfund_lc_bg_q1__2_7_days = nonfund_lc_bg_q1__2_7_days;
		this.nonfund_lc_bg_q1__8_14_days = nonfund_lc_bg_q1__8_14_days;
		this.nonfund_lc_bg_q1__15_30_days = nonfund_lc_bg_q1__15_30_days;
		this.nonfund_lc_bg_q1__31_60_days = nonfund_lc_bg_q1__31_60_days;
		this.nonfund_lc_bg_q1__61_90_days = nonfund_lc_bg_q1__61_90_days;
		this.nonfund_lc_bg_q2_segment = nonfund_lc_bg_q2_segment;
		this.nonfund_lc_bg_q2__1_day = nonfund_lc_bg_q2__1_day;
		this.nonfund_lc_bg_q2__2_7_days = nonfund_lc_bg_q2__2_7_days;
		this.nonfund_lc_bg_q2__8_14_days = nonfund_lc_bg_q2__8_14_days;
		this.nonfund_lc_bg_q2__15_30_days = nonfund_lc_bg_q2__15_30_days;
		this.nonfund_lc_bg_q2__31_60_days = nonfund_lc_bg_q2__31_60_days;
		this.nonfund_lc_bg_q2__61_90_days = nonfund_lc_bg_q2__61_90_days;
		this.nonfund_lc_bg_q3_segment = nonfund_lc_bg_q3_segment;
		this.nonfund_lc_bg_q3__1_day = nonfund_lc_bg_q3__1_day;
		this.nonfund_lc_bg_q3__2_7_days = nonfund_lc_bg_q3__2_7_days;
		this.nonfund_lc_bg_q3__8_14_days = nonfund_lc_bg_q3__8_14_days;
		this.nonfund_lc_bg_q3__15_30_days = nonfund_lc_bg_q3__15_30_days;
		this.nonfund_lc_bg_q3__31_60_days = nonfund_lc_bg_q3__31_60_days;
		this.nonfund_lc_bg_q3__61_90_days = nonfund_lc_bg_q3__61_90_days;
		this.nonfund_lc_bg_q4_segment = nonfund_lc_bg_q4_segment;
		this.nonfund_lc_bg_q4__1_day = nonfund_lc_bg_q4__1_day;
		this.nonfund_lc_bg_q4__2_7_days = nonfund_lc_bg_q4__2_7_days;
		this.nonfund_lc_bg_q4__8_14_days = nonfund_lc_bg_q4__8_14_days;
		this.nonfund_lc_bg_q4__15_30_days = nonfund_lc_bg_q4__15_30_days;
		this.nonfund_lc_bg_q4__31_60_days = nonfund_lc_bg_q4__31_60_days;
		this.nonfund_lc_bg_q4__61_90_days = nonfund_lc_bg_q4__61_90_days;
		this.sp_prepayment = sp_prepayment;
		this.reportDate = reportDate;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public RT_SLS_BEHAVIOURAL_PER_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
