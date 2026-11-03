package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_FX_RISK_DATA")

public class RT_Fxriskdata {

	@Id
	private String SI_NO;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date bank_date;
	private String bank_name;
	private String bank_symbol;
	private String conventional_islamic;
	private String local_foreign;
	private String cbuae_tiering;
	private String currency;
	private BigDecimal fx_net_openposition;
	private BigDecimal off_balance_sheet_position;
	private BigDecimal on_balance_sheet_position;
	private BigDecimal fx_net_openposition_foreign_currency;
	private BigDecimal internal_long_limit;
	private String internal_long_limit_trigger_status;
	private BigDecimal internal_short_limit;
	private String internal_short_limit_trigger_status;
	private BigDecimal bank_core_tier1_capital;
	private BigDecimal bank_core_tier1_capital_lc;
	private BigDecimal percent_of_group_capital;
	private BigDecimal bank_core_tier1_capital_aed;
	private Date	report_submit_date;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getFx_net_openposition() {
		return fx_net_openposition;
	}
	public void setFx_net_openposition(BigDecimal fx_net_openposition) {
		this.fx_net_openposition = fx_net_openposition;
	}
	public BigDecimal getOff_balance_sheet_position() {
		return off_balance_sheet_position;
	}
	public void setOff_balance_sheet_position(BigDecimal off_balance_sheet_position) {
		this.off_balance_sheet_position = off_balance_sheet_position;
	}
	public BigDecimal getOn_balance_sheet_position() {
		return on_balance_sheet_position;
	}
	public void setOn_balance_sheet_position(BigDecimal on_balance_sheet_position) {
		this.on_balance_sheet_position = on_balance_sheet_position;
	}
	public BigDecimal getFx_net_openposition_foreign_currency() {
		return fx_net_openposition_foreign_currency;
	}
	public void setFx_net_openposition_foreign_currency(BigDecimal fx_net_openposition_foreign_currency) {
		this.fx_net_openposition_foreign_currency = fx_net_openposition_foreign_currency;
	}
	public BigDecimal getInternal_long_limit() {
		return internal_long_limit;
	}
	public void setInternal_long_limit(BigDecimal internal_long_limit) {
		this.internal_long_limit = internal_long_limit;
	}
	public String getInternal_long_limit_trigger_status() {
		return internal_long_limit_trigger_status;
	}
	public void setInternal_long_limit_trigger_status(String internal_long_limit_trigger_status) {
		this.internal_long_limit_trigger_status = internal_long_limit_trigger_status;
	}
	public BigDecimal getInternal_short_limit() {
		return internal_short_limit;
	}
	public void setInternal_short_limit(BigDecimal internal_short_limit) {
		this.internal_short_limit = internal_short_limit;
	}
	public String getInternal_short_limit_trigger_status() {
		return internal_short_limit_trigger_status;
	}
	public void setInternal_short_limit_trigger_status(String internal_short_limit_trigger_status) {
		this.internal_short_limit_trigger_status = internal_short_limit_trigger_status;
	}
	public BigDecimal getBank_core_tier1_capital() {
		return bank_core_tier1_capital;
	}
	public void setBank_core_tier1_capital(BigDecimal bank_core_tier1_capital) {
		this.bank_core_tier1_capital = bank_core_tier1_capital;
	}
	public BigDecimal getBank_core_tier1_capital_lc() {
		return bank_core_tier1_capital_lc;
	}
	public void setBank_core_tier1_capital_lc(BigDecimal bank_core_tier1_capital_lc) {
		this.bank_core_tier1_capital_lc = bank_core_tier1_capital_lc;
	}
	public BigDecimal getPercent_of_group_capital() {
		return percent_of_group_capital;
	}
	public void setPercent_of_group_capital(BigDecimal percent_of_group_capital) {
		this.percent_of_group_capital = percent_of_group_capital;
	}
	public BigDecimal getBank_core_tier1_capital_aed() {
		return bank_core_tier1_capital_aed;
	}
	public void setBank_core_tier1_capital_aed(BigDecimal bank_core_tier1_capital_aed) {
		this.bank_core_tier1_capital_aed = bank_core_tier1_capital_aed;
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
	public RT_Fxriskdata(String sI_NO, Date bank_date, String bank_name, String bank_symbol,
			String conventional_islamic, String local_foreign, String cbuae_tiering, String currency,
			BigDecimal fx_net_openposition, BigDecimal off_balance_sheet_position, BigDecimal on_balance_sheet_position,
			BigDecimal fx_net_openposition_foreign_currency, BigDecimal internal_long_limit,
			String internal_long_limit_trigger_status, BigDecimal internal_short_limit,
			String internal_short_limit_trigger_status, BigDecimal bank_core_tier1_capital,
			BigDecimal bank_core_tier1_capital_lc, BigDecimal percent_of_group_capital,
			BigDecimal bank_core_tier1_capital_aed, Date report_submit_date, Date report_date, String entity_flg,
			String modify_flg, String del_flg, Date report_from_date, Date report_to_date, String report_code,
			String entry_user, String modify_user, String verify_user, Date entry_time, Date modify_time) {
		super();
		SI_NO = sI_NO;
		this.bank_date = bank_date;
		this.bank_name = bank_name;
		this.bank_symbol = bank_symbol;
		this.conventional_islamic = conventional_islamic;
		this.local_foreign = local_foreign;
		this.cbuae_tiering = cbuae_tiering;
		this.currency = currency;
		this.fx_net_openposition = fx_net_openposition;
		this.off_balance_sheet_position = off_balance_sheet_position;
		this.on_balance_sheet_position = on_balance_sheet_position;
		this.fx_net_openposition_foreign_currency = fx_net_openposition_foreign_currency;
		this.internal_long_limit = internal_long_limit;
		this.internal_long_limit_trigger_status = internal_long_limit_trigger_status;
		this.internal_short_limit = internal_short_limit;
		this.internal_short_limit_trigger_status = internal_short_limit_trigger_status;
		this.bank_core_tier1_capital = bank_core_tier1_capital;
		this.bank_core_tier1_capital_lc = bank_core_tier1_capital_lc;
		this.percent_of_group_capital = percent_of_group_capital;
		this.bank_core_tier1_capital_aed = bank_core_tier1_capital_aed;
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
	public RT_Fxriskdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
