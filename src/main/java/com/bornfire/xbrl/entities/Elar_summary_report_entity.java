package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF8_SUMMARYTABLE")
public class Elar_summary_report_entity {
	
	private String	r1_product;
	private BigDecimal	r1_nominal_amount;
	private String	r2_product;
	private BigDecimal	r2_nominal_amount;
	private String	r3_product;
	private BigDecimal	r3_nominal_amount;
	private String	r4_product;
	private BigDecimal	r4_nominal_amount;
	private String	r5_product;
	private BigDecimal	r5_nominal_amount;
	private String	r6_product;
	private BigDecimal	r6_nominal_amount;
	private BigDecimal	r6_eligi_liq_assets;
	private String	r7_product;
	private BigDecimal	r7_nominal_amount;
	private String	r8_product;
	private BigDecimal	r8_nominal_amount;
	private String	r9_product;
	private BigDecimal	r9_nominal_amount;
	private String	r10_product;
	private BigDecimal	r10_nominal_amount;
	private String	r11_product;
	private BigDecimal	r11_nominal_amount;
	private BigDecimal	r11_eligi_liq_assets;
	private String	r12_product;
	private BigDecimal	r12_nominal_amount;
	private BigDecimal	r12_eligi_liq_assets;
	private String	r13_product;
	private BigDecimal	r13_nominal_amount;
	private BigDecimal	r13_eligi_liq_assets;
	private String	r14_product;
	private BigDecimal	r14_eligi_liq_assets;
	private String	r15_product;
	private BigDecimal	r15_eligi_liq_assets;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_nominal_amount() {
		return r1_nominal_amount;
	}
	public void setR1_nominal_amount(BigDecimal r1_nominal_amount) {
		this.r1_nominal_amount = r1_nominal_amount;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_nominal_amount() {
		return r2_nominal_amount;
	}
	public void setR2_nominal_amount(BigDecimal r2_nominal_amount) {
		this.r2_nominal_amount = r2_nominal_amount;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_nominal_amount() {
		return r3_nominal_amount;
	}
	public void setR3_nominal_amount(BigDecimal r3_nominal_amount) {
		this.r3_nominal_amount = r3_nominal_amount;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_nominal_amount() {
		return r4_nominal_amount;
	}
	public void setR4_nominal_amount(BigDecimal r4_nominal_amount) {
		this.r4_nominal_amount = r4_nominal_amount;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_nominal_amount() {
		return r5_nominal_amount;
	}
	public void setR5_nominal_amount(BigDecimal r5_nominal_amount) {
		this.r5_nominal_amount = r5_nominal_amount;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_nominal_amount() {
		return r6_nominal_amount;
	}
	public void setR6_nominal_amount(BigDecimal r6_nominal_amount) {
		this.r6_nominal_amount = r6_nominal_amount;
	}
	public BigDecimal getR6_eligi_liq_assets() {
		return r6_eligi_liq_assets;
	}
	public void setR6_eligi_liq_assets(BigDecimal r6_eligi_liq_assets) {
		this.r6_eligi_liq_assets = r6_eligi_liq_assets;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_nominal_amount() {
		return r7_nominal_amount;
	}
	public void setR7_nominal_amount(BigDecimal r7_nominal_amount) {
		this.r7_nominal_amount = r7_nominal_amount;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_nominal_amount() {
		return r8_nominal_amount;
	}
	public void setR8_nominal_amount(BigDecimal r8_nominal_amount) {
		this.r8_nominal_amount = r8_nominal_amount;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_nominal_amount() {
		return r9_nominal_amount;
	}
	public void setR9_nominal_amount(BigDecimal r9_nominal_amount) {
		this.r9_nominal_amount = r9_nominal_amount;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_nominal_amount() {
		return r10_nominal_amount;
	}
	public void setR10_nominal_amount(BigDecimal r10_nominal_amount) {
		this.r10_nominal_amount = r10_nominal_amount;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_nominal_amount() {
		return r11_nominal_amount;
	}
	public void setR11_nominal_amount(BigDecimal r11_nominal_amount) {
		this.r11_nominal_amount = r11_nominal_amount;
	}
	public BigDecimal getR11_eligi_liq_assets() {
		return r11_eligi_liq_assets;
	}
	public void setR11_eligi_liq_assets(BigDecimal r11_eligi_liq_assets) {
		this.r11_eligi_liq_assets = r11_eligi_liq_assets;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_nominal_amount() {
		return r12_nominal_amount;
	}
	public void setR12_nominal_amount(BigDecimal r12_nominal_amount) {
		this.r12_nominal_amount = r12_nominal_amount;
	}
	public BigDecimal getR12_eligi_liq_assets() {
		return r12_eligi_liq_assets;
	}
	public void setR12_eligi_liq_assets(BigDecimal r12_eligi_liq_assets) {
		this.r12_eligi_liq_assets = r12_eligi_liq_assets;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_nominal_amount() {
		return r13_nominal_amount;
	}
	public void setR13_nominal_amount(BigDecimal r13_nominal_amount) {
		this.r13_nominal_amount = r13_nominal_amount;
	}
	public BigDecimal getR13_eligi_liq_assets() {
		return r13_eligi_liq_assets;
	}
	public void setR13_eligi_liq_assets(BigDecimal r13_eligi_liq_assets) {
		this.r13_eligi_liq_assets = r13_eligi_liq_assets;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_eligi_liq_assets() {
		return r14_eligi_liq_assets;
	}
	public void setR14_eligi_liq_assets(BigDecimal r14_eligi_liq_assets) {
		this.r14_eligi_liq_assets = r14_eligi_liq_assets;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_eligi_liq_assets() {
		return r15_eligi_liq_assets;
	}
	public void setR15_eligi_liq_assets(BigDecimal r15_eligi_liq_assets) {
		this.r15_eligi_liq_assets = r15_eligi_liq_assets;
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
	@Override
	public String toString() {
		return "Elar_summary_report_entity [r1_product=" + r1_product + ", r1_nominal_amount=" + r1_nominal_amount
				+ ", r2_product=" + r2_product + ", r2_nominal_amount=" + r2_nominal_amount + ", r3_product="
				+ r3_product + ", r3_nominal_amount=" + r3_nominal_amount + ", r4_product=" + r4_product
				+ ", r4_nominal_amount=" + r4_nominal_amount + ", r5_product=" + r5_product + ", r5_nominal_amount="
				+ r5_nominal_amount + ", r6_product=" + r6_product + ", r6_nominal_amount=" + r6_nominal_amount
				+ ", r6_eligi_liq_assets=" + r6_eligi_liq_assets + ", r7_product=" + r7_product + ", r7_nominal_amount="
				+ r7_nominal_amount + ", r8_product=" + r8_product + ", r8_nominal_amount=" + r8_nominal_amount
				+ ", r9_product=" + r9_product + ", r9_nominal_amount=" + r9_nominal_amount + ", r10_product="
				+ r10_product + ", r10_nominal_amount=" + r10_nominal_amount + ", r11_product=" + r11_product
				+ ", r11_nominal_amount=" + r11_nominal_amount + ", r11_eligi_liq_assets=" + r11_eligi_liq_assets
				+ ", r12_product=" + r12_product + ", r12_nominal_amount=" + r12_nominal_amount
				+ ", r12_eligi_liq_assets=" + r12_eligi_liq_assets + ", r13_product=" + r13_product
				+ ", r13_nominal_amount=" + r13_nominal_amount + ", r13_eligi_liq_assets=" + r13_eligi_liq_assets
				+ ", r14_product=" + r14_product + ", r14_eligi_liq_assets=" + r14_eligi_liq_assets + ", r15_product="
				+ r15_product + ", r15_eligi_liq_assets=" + r15_eligi_liq_assets + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", report_code=" + report_code
				+ ", report_submit_date=" + report_submit_date + ", repdesc=" + repdesc + ", frequency=" + frequency
				+ "]";
	}
	public Elar_summary_report_entity(String r1_product, BigDecimal r1_nominal_amount, String r2_product,
			BigDecimal r2_nominal_amount, String r3_product, BigDecimal r3_nominal_amount, String r4_product,
			BigDecimal r4_nominal_amount, String r5_product, BigDecimal r5_nominal_amount, String r6_product,
			BigDecimal r6_nominal_amount, BigDecimal r6_eligi_liq_assets, String r7_product,
			BigDecimal r7_nominal_amount, String r8_product, BigDecimal r8_nominal_amount, String r9_product,
			BigDecimal r9_nominal_amount, String r10_product, BigDecimal r10_nominal_amount, String r11_product,
			BigDecimal r11_nominal_amount, BigDecimal r11_eligi_liq_assets, String r12_product,
			BigDecimal r12_nominal_amount, BigDecimal r12_eligi_liq_assets, String r13_product,
			BigDecimal r13_nominal_amount, BigDecimal r13_eligi_liq_assets, String r14_product,
			BigDecimal r14_eligi_liq_assets, String r15_product, BigDecimal r15_eligi_liq_assets, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String repdesc, String frequency) {
		super();
		this.r1_product = r1_product;
		this.r1_nominal_amount = r1_nominal_amount;
		this.r2_product = r2_product;
		this.r2_nominal_amount = r2_nominal_amount;
		this.r3_product = r3_product;
		this.r3_nominal_amount = r3_nominal_amount;
		this.r4_product = r4_product;
		this.r4_nominal_amount = r4_nominal_amount;
		this.r5_product = r5_product;
		this.r5_nominal_amount = r5_nominal_amount;
		this.r6_product = r6_product;
		this.r6_nominal_amount = r6_nominal_amount;
		this.r6_eligi_liq_assets = r6_eligi_liq_assets;
		this.r7_product = r7_product;
		this.r7_nominal_amount = r7_nominal_amount;
		this.r8_product = r8_product;
		this.r8_nominal_amount = r8_nominal_amount;
		this.r9_product = r9_product;
		this.r9_nominal_amount = r9_nominal_amount;
		this.r10_product = r10_product;
		this.r10_nominal_amount = r10_nominal_amount;
		this.r11_product = r11_product;
		this.r11_nominal_amount = r11_nominal_amount;
		this.r11_eligi_liq_assets = r11_eligi_liq_assets;
		this.r12_product = r12_product;
		this.r12_nominal_amount = r12_nominal_amount;
		this.r12_eligi_liq_assets = r12_eligi_liq_assets;
		this.r13_product = r13_product;
		this.r13_nominal_amount = r13_nominal_amount;
		this.r13_eligi_liq_assets = r13_eligi_liq_assets;
		this.r14_product = r14_product;
		this.r14_eligi_liq_assets = r14_eligi_liq_assets;
		this.r15_product = r15_product;
		this.r15_eligi_liq_assets = r15_eligi_liq_assets;
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
	public Elar_summary_report_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
