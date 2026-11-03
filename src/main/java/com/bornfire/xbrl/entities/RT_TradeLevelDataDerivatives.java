package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BCBUAE_TRADE_LEVEL_DERIVATIVES")

public class RT_TradeLevelDataDerivatives {

	@Id
	private String SI_NO;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	bank_date;
	private String	bank_name;
	private String	head_office_subsidiary;
	private String	subsidiary;
	private String	bank_symbol;
	private String	conventional_islamic;
	private String	cbuae_tiering1;
	private String	cbuae_tiering2;
	private String	cpty_name;
	private String	internal_counterparty_ref;
	private String	internal_transaction_ref;
	private String	underlying_asset_class;
	private String	derivatives_type;
	private String	transaction_rationale;
	private String	bundle_transaction;
	private String	back_to_back_transaction;
	private String	instruments_characteristics;
	private String	currency_valuation;
	private BigDecimal	aed_fx_spot_rate_conversion;
	private Date	start_date;
	private Date	effective_delivery_date;
	private Date	final_maturity_date;
	private BigDecimal	residual_maturity;
	private BigDecimal	residual_maturity_rounded;
	private BigDecimal	maturity_period;
	private String	position;
	private String	notional_type;
	private String	cancellable;
	private Date	cancellable_date;
	private String	cancellable_option_type;
	private BigDecimal	notional1_assets;
	private String	notional1_currency;
	private String	pay_receive1;
	private BigDecimal	coupon_fixed_rate1;
	private BigDecimal	margin1;
	private String	benchmark_floating_rate1;
	private String	benchmark_rate_tenor1;
	private BigDecimal	notional2_liabilities;
	private String	notional2_currency;
	private String	pay_receive2;
	private BigDecimal	coupon_fixed_rate2;
	private BigDecimal	margin2;
	private String	benchmark_floating_rate2;
	private String	benchmark_rate_tenor2;
	private BigDecimal	clean_value_aed;
	private BigDecimal	accrued_interest_aed;
	private BigDecimal	dv01_aed;
	private BigDecimal	br01_aed;
	private BigDecimal	dollar_delta_aed;
	private BigDecimal	dollar_vega_aed;
	private BigDecimal	dollar_gamma_aed;
	private BigDecimal	dollar_theta_aed;
	private BigDecimal	uleg1_notional;
	private String	uleg1_currency;
	private String	uleg1_pay_receive;
	private BigDecimal	uleg1_coupon;
	private BigDecimal	uleg1_margin;
	private String	uleg1_benchmark;
	private String	uleg1_tenor;
	private String	underlying_leg1;
	private String	uleg1_details;
	private BigDecimal	uleg2_notional;
	private String	uleg2_currency;
	private String	uleg2_pay_receive;
	private BigDecimal	uleg2_coupon;
	private BigDecimal	uleg2_margin;
	private String	uleg2_benchmark;
	private String	uleg2_tenor;
	private String	underlying_leg2;
	private String	uleg2_details;
	private BigDecimal	uleg2_clean_value_aed;
	private BigDecimal	uleg2_accrued_interest_aed;
	private BigDecimal	uleg2_dv01_aed;
	private String	cds_type;
	private String	cds_underlyings;
	private String	quanto;
	private BigDecimal	nominal;
	private BigDecimal	cleanvalue_aed;
	private BigDecimal	ir_dv01_aed;
	private BigDecimal	cs01_aed;
	private String	future_type;
	private String	future_underlying_contract;
	private BigDecimal	future_qty;
	private BigDecimal	future_contract_size;
	private BigDecimal	future_contract_rate;
	private BigDecimal	future_market_rate;
	private BigDecimal	future_contract_valuation;
	private BigDecimal	future_sensitivity_aed;
	private String	options_list;
	private String	option_type;
	private String	option_underlying_type;
	private String	option_underlying_details;
	private BigDecimal	strike;
	private BigDecimal	option_market_rate;
	private String	barrier_type;
	private BigDecimal	barrier_upper_range;
	private BigDecimal	barrier_lower_range;
	private BigDecimal	option_fair_value_aed;
	private BigDecimal	option_dollar_delta;
	private BigDecimal	option_dollar_vega;
	private BigDecimal	option_dollar_gamma;
	private BigDecimal	option_dollar_rho;
	private BigDecimal	option_dollar_theta;
	private BigDecimal	overall_mtm_aed;
	private BigDecimal	irs_positive_mtm;
	private BigDecimal	asset_swap_positive_mtm;
	private BigDecimal	cds_positive_mtm;
	private BigDecimal	future_contract_positive_mtm;
	private BigDecimal	option_positive_mtm;
	private BigDecimal	overall_positive_mtm;
	private BigDecimal	individual_positive_contribution;
	private BigDecimal	irs_negative_mtm;
	private BigDecimal	asset_swap_negative_mtm;
	private BigDecimal	cds_negative_mtm;
	private BigDecimal	future_contract_negative_mtm;
	private BigDecimal	option_negative_mtm;
	private BigDecimal	overall_negative_mtm;
	private BigDecimal	individual_negative_contribution;
	private Date	report_submit_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
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
	public String getCbuae_tiering1() {
		return cbuae_tiering1;
	}
	public void setCbuae_tiering1(String cbuae_tiering1) {
		this.cbuae_tiering1 = cbuae_tiering1;
	}
	public String getCbuae_tiering2() {
		return cbuae_tiering2;
	}
	public void setCbuae_tiering2(String cbuae_tiering2) {
		this.cbuae_tiering2 = cbuae_tiering2;
	}
	public String getCpty_name() {
		return cpty_name;
	}
	public void setCpty_name(String cpty_name) {
		this.cpty_name = cpty_name;
	}
	public String getInternal_counterparty_ref() {
		return internal_counterparty_ref;
	}
	public void setInternal_counterparty_ref(String internal_counterparty_ref) {
		this.internal_counterparty_ref = internal_counterparty_ref;
	}
	public String getInternal_transaction_ref() {
		return internal_transaction_ref;
	}
	public void setInternal_transaction_ref(String internal_transaction_ref) {
		this.internal_transaction_ref = internal_transaction_ref;
	}
	public String getUnderlying_asset_class() {
		return underlying_asset_class;
	}
	public void setUnderlying_asset_class(String underlying_asset_class) {
		this.underlying_asset_class = underlying_asset_class;
	}
	public String getDerivatives_type() {
		return derivatives_type;
	}
	public void setDerivatives_type(String derivatives_type) {
		this.derivatives_type = derivatives_type;
	}
	public String getTransaction_rationale() {
		return transaction_rationale;
	}
	public void setTransaction_rationale(String transaction_rationale) {
		this.transaction_rationale = transaction_rationale;
	}
	public String getBundle_transaction() {
		return bundle_transaction;
	}
	public void setBundle_transaction(String bundle_transaction) {
		this.bundle_transaction = bundle_transaction;
	}
	public String getBack_to_back_transaction() {
		return back_to_back_transaction;
	}
	public void setBack_to_back_transaction(String back_to_back_transaction) {
		this.back_to_back_transaction = back_to_back_transaction;
	}
	public String getInstruments_characteristics() {
		return instruments_characteristics;
	}
	public void setInstruments_characteristics(String instruments_characteristics) {
		this.instruments_characteristics = instruments_characteristics;
	}
	public String getCurrency_valuation() {
		return currency_valuation;
	}
	public void setCurrency_valuation(String currency_valuation) {
		this.currency_valuation = currency_valuation;
	}
	public BigDecimal getAed_fx_spot_rate_conversion() {
		return aed_fx_spot_rate_conversion;
	}
	public void setAed_fx_spot_rate_conversion(BigDecimal aed_fx_spot_rate_conversion) {
		this.aed_fx_spot_rate_conversion = aed_fx_spot_rate_conversion;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEffective_delivery_date() {
		return effective_delivery_date;
	}
	public void setEffective_delivery_date(Date effective_delivery_date) {
		this.effective_delivery_date = effective_delivery_date;
	}
	public Date getFinal_maturity_date() {
		return final_maturity_date;
	}
	public void setFinal_maturity_date(Date final_maturity_date) {
		this.final_maturity_date = final_maturity_date;
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
	public BigDecimal getMaturity_period() {
		return maturity_period;
	}
	public void setMaturity_period(BigDecimal maturity_period) {
		this.maturity_period = maturity_period;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNotional_type() {
		return notional_type;
	}
	public void setNotional_type(String notional_type) {
		this.notional_type = notional_type;
	}
	public String getCancellable() {
		return cancellable;
	}
	public void setCancellable(String cancellable) {
		this.cancellable = cancellable;
	}
	public Date getCancellable_date() {
		return cancellable_date;
	}
	public void setCancellable_date(Date cancellable_date) {
		this.cancellable_date = cancellable_date;
	}
	public String getCancellable_option_type() {
		return cancellable_option_type;
	}
	public void setCancellable_option_type(String cancellable_option_type) {
		this.cancellable_option_type = cancellable_option_type;
	}
	public BigDecimal getNotional1_assets() {
		return notional1_assets;
	}
	public void setNotional1_assets(BigDecimal notional1_assets) {
		this.notional1_assets = notional1_assets;
	}
	public String getNotional1_currency() {
		return notional1_currency;
	}
	public void setNotional1_currency(String notional1_currency) {
		this.notional1_currency = notional1_currency;
	}
	public String getPay_receive1() {
		return pay_receive1;
	}
	public void setPay_receive1(String pay_receive1) {
		this.pay_receive1 = pay_receive1;
	}
	public BigDecimal getCoupon_fixed_rate1() {
		return coupon_fixed_rate1;
	}
	public void setCoupon_fixed_rate1(BigDecimal coupon_fixed_rate1) {
		this.coupon_fixed_rate1 = coupon_fixed_rate1;
	}
	public BigDecimal getMargin1() {
		return margin1;
	}
	public void setMargin1(BigDecimal margin1) {
		this.margin1 = margin1;
	}
	public String getBenchmark_floating_rate1() {
		return benchmark_floating_rate1;
	}
	public void setBenchmark_floating_rate1(String benchmark_floating_rate1) {
		this.benchmark_floating_rate1 = benchmark_floating_rate1;
	}
	public String getBenchmark_rate_tenor1() {
		return benchmark_rate_tenor1;
	}
	public void setBenchmark_rate_tenor1(String benchmark_rate_tenor1) {
		this.benchmark_rate_tenor1 = benchmark_rate_tenor1;
	}
	public BigDecimal getNotional2_liabilities() {
		return notional2_liabilities;
	}
	public void setNotional2_liabilities(BigDecimal notional2_liabilities) {
		this.notional2_liabilities = notional2_liabilities;
	}
	public String getNotional2_currency() {
		return notional2_currency;
	}
	public void setNotional2_currency(String notional2_currency) {
		this.notional2_currency = notional2_currency;
	}
	public String getPay_receive2() {
		return pay_receive2;
	}
	public void setPay_receive2(String pay_receive2) {
		this.pay_receive2 = pay_receive2;
	}
	public BigDecimal getCoupon_fixed_rate2() {
		return coupon_fixed_rate2;
	}
	public void setCoupon_fixed_rate2(BigDecimal coupon_fixed_rate2) {
		this.coupon_fixed_rate2 = coupon_fixed_rate2;
	}
	public BigDecimal getMargin2() {
		return margin2;
	}
	public void setMargin2(BigDecimal margin2) {
		this.margin2 = margin2;
	}
	public String getBenchmark_floating_rate2() {
		return benchmark_floating_rate2;
	}
	public void setBenchmark_floating_rate2(String benchmark_floating_rate2) {
		this.benchmark_floating_rate2 = benchmark_floating_rate2;
	}
	public String getBenchmark_rate_tenor2() {
		return benchmark_rate_tenor2;
	}
	public void setBenchmark_rate_tenor2(String benchmark_rate_tenor2) {
		this.benchmark_rate_tenor2 = benchmark_rate_tenor2;
	}
	public BigDecimal getClean_value_aed() {
		return clean_value_aed;
	}
	public void setClean_value_aed(BigDecimal clean_value_aed) {
		this.clean_value_aed = clean_value_aed;
	}
	public BigDecimal getAccrued_interest_aed() {
		return accrued_interest_aed;
	}
	public void setAccrued_interest_aed(BigDecimal accrued_interest_aed) {
		this.accrued_interest_aed = accrued_interest_aed;
	}
	public BigDecimal getDv01_aed() {
		return dv01_aed;
	}
	public void setDv01_aed(BigDecimal dv01_aed) {
		this.dv01_aed = dv01_aed;
	}
	public BigDecimal getBr01_aed() {
		return br01_aed;
	}
	public void setBr01_aed(BigDecimal br01_aed) {
		this.br01_aed = br01_aed;
	}
	public BigDecimal getDollar_delta_aed() {
		return dollar_delta_aed;
	}
	public void setDollar_delta_aed(BigDecimal dollar_delta_aed) {
		this.dollar_delta_aed = dollar_delta_aed;
	}
	public BigDecimal getDollar_vega_aed() {
		return dollar_vega_aed;
	}
	public void setDollar_vega_aed(BigDecimal dollar_vega_aed) {
		this.dollar_vega_aed = dollar_vega_aed;
	}
	public BigDecimal getDollar_gamma_aed() {
		return dollar_gamma_aed;
	}
	public void setDollar_gamma_aed(BigDecimal dollar_gamma_aed) {
		this.dollar_gamma_aed = dollar_gamma_aed;
	}
	public BigDecimal getDollar_theta_aed() {
		return dollar_theta_aed;
	}
	public void setDollar_theta_aed(BigDecimal dollar_theta_aed) {
		this.dollar_theta_aed = dollar_theta_aed;
	}
	public BigDecimal getUleg1_notional() {
		return uleg1_notional;
	}
	public void setUleg1_notional(BigDecimal uleg1_notional) {
		this.uleg1_notional = uleg1_notional;
	}
	public String getUleg1_currency() {
		return uleg1_currency;
	}
	public void setUleg1_currency(String uleg1_currency) {
		this.uleg1_currency = uleg1_currency;
	}
	public String getUleg1_pay_receive() {
		return uleg1_pay_receive;
	}
	public void setUleg1_pay_receive(String uleg1_pay_receive) {
		this.uleg1_pay_receive = uleg1_pay_receive;
	}
	public BigDecimal getUleg1_coupon() {
		return uleg1_coupon;
	}
	public void setUleg1_coupon(BigDecimal uleg1_coupon) {
		this.uleg1_coupon = uleg1_coupon;
	}
	public BigDecimal getUleg1_margin() {
		return uleg1_margin;
	}
	public void setUleg1_margin(BigDecimal uleg1_margin) {
		this.uleg1_margin = uleg1_margin;
	}
	public String getUleg1_benchmark() {
		return uleg1_benchmark;
	}
	public void setUleg1_benchmark(String uleg1_benchmark) {
		this.uleg1_benchmark = uleg1_benchmark;
	}
	public String getUleg1_tenor() {
		return uleg1_tenor;
	}
	public void setUleg1_tenor(String uleg1_tenor) {
		this.uleg1_tenor = uleg1_tenor;
	}
	public String getUnderlying_leg1() {
		return underlying_leg1;
	}
	public void setUnderlying_leg1(String underlying_leg1) {
		this.underlying_leg1 = underlying_leg1;
	}
	public String getUleg1_details() {
		return uleg1_details;
	}
	public void setUleg1_details(String uleg1_details) {
		this.uleg1_details = uleg1_details;
	}
	public BigDecimal getUleg2_notional() {
		return uleg2_notional;
	}
	public void setUleg2_notional(BigDecimal uleg2_notional) {
		this.uleg2_notional = uleg2_notional;
	}
	public String getUleg2_currency() {
		return uleg2_currency;
	}
	public void setUleg2_currency(String uleg2_currency) {
		this.uleg2_currency = uleg2_currency;
	}
	public String getUleg2_pay_receive() {
		return uleg2_pay_receive;
	}
	public void setUleg2_pay_receive(String uleg2_pay_receive) {
		this.uleg2_pay_receive = uleg2_pay_receive;
	}
	public BigDecimal getUleg2_coupon() {
		return uleg2_coupon;
	}
	public void setUleg2_coupon(BigDecimal uleg2_coupon) {
		this.uleg2_coupon = uleg2_coupon;
	}
	public BigDecimal getUleg2_margin() {
		return uleg2_margin;
	}
	public void setUleg2_margin(BigDecimal uleg2_margin) {
		this.uleg2_margin = uleg2_margin;
	}
	public String getUleg2_benchmark() {
		return uleg2_benchmark;
	}
	public void setUleg2_benchmark(String uleg2_benchmark) {
		this.uleg2_benchmark = uleg2_benchmark;
	}
	public String getUleg2_tenor() {
		return uleg2_tenor;
	}
	public void setUleg2_tenor(String uleg2_tenor) {
		this.uleg2_tenor = uleg2_tenor;
	}
	public String getUnderlying_leg2() {
		return underlying_leg2;
	}
	public void setUnderlying_leg2(String underlying_leg2) {
		this.underlying_leg2 = underlying_leg2;
	}
	public String getUleg2_details() {
		return uleg2_details;
	}
	public void setUleg2_details(String uleg2_details) {
		this.uleg2_details = uleg2_details;
	}
	public BigDecimal getUleg2_clean_value_aed() {
		return uleg2_clean_value_aed;
	}
	public void setUleg2_clean_value_aed(BigDecimal uleg2_clean_value_aed) {
		this.uleg2_clean_value_aed = uleg2_clean_value_aed;
	}
	public BigDecimal getUleg2_accrued_interest_aed() {
		return uleg2_accrued_interest_aed;
	}
	public void setUleg2_accrued_interest_aed(BigDecimal uleg2_accrued_interest_aed) {
		this.uleg2_accrued_interest_aed = uleg2_accrued_interest_aed;
	}
	public BigDecimal getUleg2_dv01_aed() {
		return uleg2_dv01_aed;
	}
	public void setUleg2_dv01_aed(BigDecimal uleg2_dv01_aed) {
		this.uleg2_dv01_aed = uleg2_dv01_aed;
	}
	public String getCds_type() {
		return cds_type;
	}
	public void setCds_type(String cds_type) {
		this.cds_type = cds_type;
	}
	public String getCds_underlyings() {
		return cds_underlyings;
	}
	public void setCds_underlyings(String cds_underlyings) {
		this.cds_underlyings = cds_underlyings;
	}
	public String getQuanto() {
		return quanto;
	}
	public void setQuanto(String quanto) {
		this.quanto = quanto;
	}
	public BigDecimal getNominal() {
		return nominal;
	}
	public void setNominal(BigDecimal nominal) {
		this.nominal = nominal;
	}
	public BigDecimal getCleanvalue_aed() {
		return cleanvalue_aed;
	}
	public void setCleanvalue_aed(BigDecimal cleanvalue_aed) {
		this.cleanvalue_aed = cleanvalue_aed;
	}
	public BigDecimal getIr_dv01_aed() {
		return ir_dv01_aed;
	}
	public void setIr_dv01_aed(BigDecimal ir_dv01_aed) {
		this.ir_dv01_aed = ir_dv01_aed;
	}
	public BigDecimal getCs01_aed() {
		return cs01_aed;
	}
	public void setCs01_aed(BigDecimal cs01_aed) {
		this.cs01_aed = cs01_aed;
	}
	public String getFuture_type() {
		return future_type;
	}
	public void setFuture_type(String future_type) {
		this.future_type = future_type;
	}
	public String getFuture_underlying_contract() {
		return future_underlying_contract;
	}
	public void setFuture_underlying_contract(String future_underlying_contract) {
		this.future_underlying_contract = future_underlying_contract;
	}
	public BigDecimal getFuture_qty() {
		return future_qty;
	}
	public void setFuture_qty(BigDecimal future_qty) {
		this.future_qty = future_qty;
	}
	public BigDecimal getFuture_contract_size() {
		return future_contract_size;
	}
	public void setFuture_contract_size(BigDecimal future_contract_size) {
		this.future_contract_size = future_contract_size;
	}
	public BigDecimal getFuture_contract_rate() {
		return future_contract_rate;
	}
	public void setFuture_contract_rate(BigDecimal future_contract_rate) {
		this.future_contract_rate = future_contract_rate;
	}
	public BigDecimal getFuture_market_rate() {
		return future_market_rate;
	}
	public void setFuture_market_rate(BigDecimal future_market_rate) {
		this.future_market_rate = future_market_rate;
	}
	public BigDecimal getFuture_contract_valuation() {
		return future_contract_valuation;
	}
	public void setFuture_contract_valuation(BigDecimal future_contract_valuation) {
		this.future_contract_valuation = future_contract_valuation;
	}
	public BigDecimal getFuture_sensitivity_aed() {
		return future_sensitivity_aed;
	}
	public void setFuture_sensitivity_aed(BigDecimal future_sensitivity_aed) {
		this.future_sensitivity_aed = future_sensitivity_aed;
	}
	public String getOptions_list() {
		return options_list;
	}
	public void setOptions_list(String options_list) {
		this.options_list = options_list;
	}
	public String getOption_type() {
		return option_type;
	}
	public void setOption_type(String option_type) {
		this.option_type = option_type;
	}
	public String getOption_underlying_type() {
		return option_underlying_type;
	}
	public void setOption_underlying_type(String option_underlying_type) {
		this.option_underlying_type = option_underlying_type;
	}
	public String getOption_underlying_details() {
		return option_underlying_details;
	}
	public void setOption_underlying_details(String option_underlying_details) {
		this.option_underlying_details = option_underlying_details;
	}
	public BigDecimal getStrike() {
		return strike;
	}
	public void setStrike(BigDecimal strike) {
		this.strike = strike;
	}
	public BigDecimal getOption_market_rate() {
		return option_market_rate;
	}
	public void setOption_market_rate(BigDecimal option_market_rate) {
		this.option_market_rate = option_market_rate;
	}
	public String getBarrier_type() {
		return barrier_type;
	}
	public void setBarrier_type(String barrier_type) {
		this.barrier_type = barrier_type;
	}
	public BigDecimal getBarrier_upper_range() {
		return barrier_upper_range;
	}
	public void setBarrier_upper_range(BigDecimal barrier_upper_range) {
		this.barrier_upper_range = barrier_upper_range;
	}
	public BigDecimal getBarrier_lower_range() {
		return barrier_lower_range;
	}
	public void setBarrier_lower_range(BigDecimal barrier_lower_range) {
		this.barrier_lower_range = barrier_lower_range;
	}
	public BigDecimal getOption_fair_value_aed() {
		return option_fair_value_aed;
	}
	public void setOption_fair_value_aed(BigDecimal option_fair_value_aed) {
		this.option_fair_value_aed = option_fair_value_aed;
	}
	public BigDecimal getOption_dollar_delta() {
		return option_dollar_delta;
	}
	public void setOption_dollar_delta(BigDecimal option_dollar_delta) {
		this.option_dollar_delta = option_dollar_delta;
	}
	public BigDecimal getOption_dollar_vega() {
		return option_dollar_vega;
	}
	public void setOption_dollar_vega(BigDecimal option_dollar_vega) {
		this.option_dollar_vega = option_dollar_vega;
	}
	public BigDecimal getOption_dollar_gamma() {
		return option_dollar_gamma;
	}
	public void setOption_dollar_gamma(BigDecimal option_dollar_gamma) {
		this.option_dollar_gamma = option_dollar_gamma;
	}
	public BigDecimal getOption_dollar_rho() {
		return option_dollar_rho;
	}
	public void setOption_dollar_rho(BigDecimal option_dollar_rho) {
		this.option_dollar_rho = option_dollar_rho;
	}
	public BigDecimal getOption_dollar_theta() {
		return option_dollar_theta;
	}
	public void setOption_dollar_theta(BigDecimal option_dollar_theta) {
		this.option_dollar_theta = option_dollar_theta;
	}
	public BigDecimal getOverall_mtm_aed() {
		return overall_mtm_aed;
	}
	public void setOverall_mtm_aed(BigDecimal overall_mtm_aed) {
		this.overall_mtm_aed = overall_mtm_aed;
	}
	public BigDecimal getIrs_positive_mtm() {
		return irs_positive_mtm;
	}
	public void setIrs_positive_mtm(BigDecimal irs_positive_mtm) {
		this.irs_positive_mtm = irs_positive_mtm;
	}
	public BigDecimal getAsset_swap_positive_mtm() {
		return asset_swap_positive_mtm;
	}
	public void setAsset_swap_positive_mtm(BigDecimal asset_swap_positive_mtm) {
		this.asset_swap_positive_mtm = asset_swap_positive_mtm;
	}
	public BigDecimal getCds_positive_mtm() {
		return cds_positive_mtm;
	}
	public void setCds_positive_mtm(BigDecimal cds_positive_mtm) {
		this.cds_positive_mtm = cds_positive_mtm;
	}
	public BigDecimal getFuture_contract_positive_mtm() {
		return future_contract_positive_mtm;
	}
	public void setFuture_contract_positive_mtm(BigDecimal future_contract_positive_mtm) {
		this.future_contract_positive_mtm = future_contract_positive_mtm;
	}
	public BigDecimal getOption_positive_mtm() {
		return option_positive_mtm;
	}
	public void setOption_positive_mtm(BigDecimal option_positive_mtm) {
		this.option_positive_mtm = option_positive_mtm;
	}
	public BigDecimal getOverall_positive_mtm() {
		return overall_positive_mtm;
	}
	public void setOverall_positive_mtm(BigDecimal overall_positive_mtm) {
		this.overall_positive_mtm = overall_positive_mtm;
	}
	public BigDecimal getIndividual_positive_contribution() {
		return individual_positive_contribution;
	}
	public void setIndividual_positive_contribution(BigDecimal individual_positive_contribution) {
		this.individual_positive_contribution = individual_positive_contribution;
	}
	public BigDecimal getIrs_negative_mtm() {
		return irs_negative_mtm;
	}
	public void setIrs_negative_mtm(BigDecimal irs_negative_mtm) {
		this.irs_negative_mtm = irs_negative_mtm;
	}
	public BigDecimal getAsset_swap_negative_mtm() {
		return asset_swap_negative_mtm;
	}
	public void setAsset_swap_negative_mtm(BigDecimal asset_swap_negative_mtm) {
		this.asset_swap_negative_mtm = asset_swap_negative_mtm;
	}
	public BigDecimal getCds_negative_mtm() {
		return cds_negative_mtm;
	}
	public void setCds_negative_mtm(BigDecimal cds_negative_mtm) {
		this.cds_negative_mtm = cds_negative_mtm;
	}
	public BigDecimal getFuture_contract_negative_mtm() {
		return future_contract_negative_mtm;
	}
	public void setFuture_contract_negative_mtm(BigDecimal future_contract_negative_mtm) {
		this.future_contract_negative_mtm = future_contract_negative_mtm;
	}
	public BigDecimal getOption_negative_mtm() {
		return option_negative_mtm;
	}
	public void setOption_negative_mtm(BigDecimal option_negative_mtm) {
		this.option_negative_mtm = option_negative_mtm;
	}
	public BigDecimal getOverall_negative_mtm() {
		return overall_negative_mtm;
	}
	public void setOverall_negative_mtm(BigDecimal overall_negative_mtm) {
		this.overall_negative_mtm = overall_negative_mtm;
	}
	public BigDecimal getIndividual_negative_contribution() {
		return individual_negative_contribution;
	}
	public void setIndividual_negative_contribution(BigDecimal individual_negative_contribution) {
		this.individual_negative_contribution = individual_negative_contribution;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public RT_TradeLevelDataDerivatives(String sI_NO, Date bank_date, String bank_name, String head_office_subsidiary,
			String subsidiary, String bank_symbol, String conventional_islamic, String cbuae_tiering1,
			String cbuae_tiering2, String cpty_name, String internal_counterparty_ref, String internal_transaction_ref,
			String underlying_asset_class, String derivatives_type, String transaction_rationale,
			String bundle_transaction, String back_to_back_transaction, String instruments_characteristics,
			String currency_valuation, BigDecimal aed_fx_spot_rate_conversion, Date start_date,
			Date effective_delivery_date, Date final_maturity_date, BigDecimal residual_maturity,
			BigDecimal residual_maturity_rounded, BigDecimal maturity_period, String position, String notional_type,
			String cancellable, Date cancellable_date, String cancellable_option_type, BigDecimal notional1_assets,
			String notional1_currency, String pay_receive1, BigDecimal coupon_fixed_rate1, BigDecimal margin1,
			String benchmark_floating_rate1, String benchmark_rate_tenor1, BigDecimal notional2_liabilities,
			String notional2_currency, String pay_receive2, BigDecimal coupon_fixed_rate2, BigDecimal margin2,
			String benchmark_floating_rate2, String benchmark_rate_tenor2, BigDecimal clean_value_aed,
			BigDecimal accrued_interest_aed, BigDecimal dv01_aed, BigDecimal br01_aed, BigDecimal dollar_delta_aed,
			BigDecimal dollar_vega_aed, BigDecimal dollar_gamma_aed, BigDecimal dollar_theta_aed,
			BigDecimal uleg1_notional, String uleg1_currency, String uleg1_pay_receive, BigDecimal uleg1_coupon,
			BigDecimal uleg1_margin, String uleg1_benchmark, String uleg1_tenor, String underlying_leg1,
			String uleg1_details, BigDecimal uleg2_notional, String uleg2_currency, String uleg2_pay_receive,
			BigDecimal uleg2_coupon, BigDecimal uleg2_margin, String uleg2_benchmark, String uleg2_tenor,
			String underlying_leg2, String uleg2_details, BigDecimal uleg2_clean_value_aed,
			BigDecimal uleg2_accrued_interest_aed, BigDecimal uleg2_dv01_aed, String cds_type, String cds_underlyings,
			String quanto, BigDecimal nominal, BigDecimal cleanvalue_aed, BigDecimal ir_dv01_aed, BigDecimal cs01_aed,
			String future_type, String future_underlying_contract, BigDecimal future_qty,
			BigDecimal future_contract_size, BigDecimal future_contract_rate, BigDecimal future_market_rate,
			BigDecimal future_contract_valuation, BigDecimal future_sensitivity_aed, String options_list,
			String option_type, String option_underlying_type, String option_underlying_details, BigDecimal strike,
			BigDecimal option_market_rate, String barrier_type, BigDecimal barrier_upper_range,
			BigDecimal barrier_lower_range, BigDecimal option_fair_value_aed, BigDecimal option_dollar_delta,
			BigDecimal option_dollar_vega, BigDecimal option_dollar_gamma, BigDecimal option_dollar_rho,
			BigDecimal option_dollar_theta, BigDecimal overall_mtm_aed, BigDecimal irs_positive_mtm,
			BigDecimal asset_swap_positive_mtm, BigDecimal cds_positive_mtm, BigDecimal future_contract_positive_mtm,
			BigDecimal option_positive_mtm, BigDecimal overall_positive_mtm,
			BigDecimal individual_positive_contribution, BigDecimal irs_negative_mtm,
			BigDecimal asset_swap_negative_mtm, BigDecimal cds_negative_mtm, BigDecimal future_contract_negative_mtm,
			BigDecimal option_negative_mtm, BigDecimal overall_negative_mtm,
			BigDecimal individual_negative_contribution, Date report_submit_date, Date report_from_date,
			Date report_to_date, Date report_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, String entry_user, String modify_user, String verify_user, Date entry_time,
			Date modify_time, Date verify_time) {
		super();
		SI_NO = sI_NO;
		this.bank_date = bank_date;
		this.bank_name = bank_name;
		this.head_office_subsidiary = head_office_subsidiary;
		this.subsidiary = subsidiary;
		this.bank_symbol = bank_symbol;
		this.conventional_islamic = conventional_islamic;
		this.cbuae_tiering1 = cbuae_tiering1;
		this.cbuae_tiering2 = cbuae_tiering2;
		this.cpty_name = cpty_name;
		this.internal_counterparty_ref = internal_counterparty_ref;
		this.internal_transaction_ref = internal_transaction_ref;
		this.underlying_asset_class = underlying_asset_class;
		this.derivatives_type = derivatives_type;
		this.transaction_rationale = transaction_rationale;
		this.bundle_transaction = bundle_transaction;
		this.back_to_back_transaction = back_to_back_transaction;
		this.instruments_characteristics = instruments_characteristics;
		this.currency_valuation = currency_valuation;
		this.aed_fx_spot_rate_conversion = aed_fx_spot_rate_conversion;
		this.start_date = start_date;
		this.effective_delivery_date = effective_delivery_date;
		this.final_maturity_date = final_maturity_date;
		this.residual_maturity = residual_maturity;
		this.residual_maturity_rounded = residual_maturity_rounded;
		this.maturity_period = maturity_period;
		this.position = position;
		this.notional_type = notional_type;
		this.cancellable = cancellable;
		this.cancellable_date = cancellable_date;
		this.cancellable_option_type = cancellable_option_type;
		this.notional1_assets = notional1_assets;
		this.notional1_currency = notional1_currency;
		this.pay_receive1 = pay_receive1;
		this.coupon_fixed_rate1 = coupon_fixed_rate1;
		this.margin1 = margin1;
		this.benchmark_floating_rate1 = benchmark_floating_rate1;
		this.benchmark_rate_tenor1 = benchmark_rate_tenor1;
		this.notional2_liabilities = notional2_liabilities;
		this.notional2_currency = notional2_currency;
		this.pay_receive2 = pay_receive2;
		this.coupon_fixed_rate2 = coupon_fixed_rate2;
		this.margin2 = margin2;
		this.benchmark_floating_rate2 = benchmark_floating_rate2;
		this.benchmark_rate_tenor2 = benchmark_rate_tenor2;
		this.clean_value_aed = clean_value_aed;
		this.accrued_interest_aed = accrued_interest_aed;
		this.dv01_aed = dv01_aed;
		this.br01_aed = br01_aed;
		this.dollar_delta_aed = dollar_delta_aed;
		this.dollar_vega_aed = dollar_vega_aed;
		this.dollar_gamma_aed = dollar_gamma_aed;
		this.dollar_theta_aed = dollar_theta_aed;
		this.uleg1_notional = uleg1_notional;
		this.uleg1_currency = uleg1_currency;
		this.uleg1_pay_receive = uleg1_pay_receive;
		this.uleg1_coupon = uleg1_coupon;
		this.uleg1_margin = uleg1_margin;
		this.uleg1_benchmark = uleg1_benchmark;
		this.uleg1_tenor = uleg1_tenor;
		this.underlying_leg1 = underlying_leg1;
		this.uleg1_details = uleg1_details;
		this.uleg2_notional = uleg2_notional;
		this.uleg2_currency = uleg2_currency;
		this.uleg2_pay_receive = uleg2_pay_receive;
		this.uleg2_coupon = uleg2_coupon;
		this.uleg2_margin = uleg2_margin;
		this.uleg2_benchmark = uleg2_benchmark;
		this.uleg2_tenor = uleg2_tenor;
		this.underlying_leg2 = underlying_leg2;
		this.uleg2_details = uleg2_details;
		this.uleg2_clean_value_aed = uleg2_clean_value_aed;
		this.uleg2_accrued_interest_aed = uleg2_accrued_interest_aed;
		this.uleg2_dv01_aed = uleg2_dv01_aed;
		this.cds_type = cds_type;
		this.cds_underlyings = cds_underlyings;
		this.quanto = quanto;
		this.nominal = nominal;
		this.cleanvalue_aed = cleanvalue_aed;
		this.ir_dv01_aed = ir_dv01_aed;
		this.cs01_aed = cs01_aed;
		this.future_type = future_type;
		this.future_underlying_contract = future_underlying_contract;
		this.future_qty = future_qty;
		this.future_contract_size = future_contract_size;
		this.future_contract_rate = future_contract_rate;
		this.future_market_rate = future_market_rate;
		this.future_contract_valuation = future_contract_valuation;
		this.future_sensitivity_aed = future_sensitivity_aed;
		this.options_list = options_list;
		this.option_type = option_type;
		this.option_underlying_type = option_underlying_type;
		this.option_underlying_details = option_underlying_details;
		this.strike = strike;
		this.option_market_rate = option_market_rate;
		this.barrier_type = barrier_type;
		this.barrier_upper_range = barrier_upper_range;
		this.barrier_lower_range = barrier_lower_range;
		this.option_fair_value_aed = option_fair_value_aed;
		this.option_dollar_delta = option_dollar_delta;
		this.option_dollar_vega = option_dollar_vega;
		this.option_dollar_gamma = option_dollar_gamma;
		this.option_dollar_rho = option_dollar_rho;
		this.option_dollar_theta = option_dollar_theta;
		this.overall_mtm_aed = overall_mtm_aed;
		this.irs_positive_mtm = irs_positive_mtm;
		this.asset_swap_positive_mtm = asset_swap_positive_mtm;
		this.cds_positive_mtm = cds_positive_mtm;
		this.future_contract_positive_mtm = future_contract_positive_mtm;
		this.option_positive_mtm = option_positive_mtm;
		this.overall_positive_mtm = overall_positive_mtm;
		this.individual_positive_contribution = individual_positive_contribution;
		this.irs_negative_mtm = irs_negative_mtm;
		this.asset_swap_negative_mtm = asset_swap_negative_mtm;
		this.cds_negative_mtm = cds_negative_mtm;
		this.future_contract_negative_mtm = future_contract_negative_mtm;
		this.option_negative_mtm = option_negative_mtm;
		this.overall_negative_mtm = overall_negative_mtm;
		this.individual_negative_contribution = individual_negative_contribution;
		this.report_submit_date = report_submit_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_date = report_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
	}
	public RT_TradeLevelDataDerivatives() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

