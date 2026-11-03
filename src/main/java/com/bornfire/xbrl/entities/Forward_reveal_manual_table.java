package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="BRF_FORWARD_REVEAL_MANUAL_TABLE")
@IdClass(Forward_reveal_manual_id.class)
public class Forward_reveal_manual_table implements Serializable {
	
	@Id
	private BigDecimal	num_operation;
	private BigDecimal	gl_values;
	private String	op_reference;
	private String	poste;
	private Date	dealdate;
	private Date	valuedate;
	private Date	maturitydate;
	private String	currency1;
	private String	currency2;
	private BigDecimal	nominal_1;
	private BigDecimal	ramount;
	private BigDecimal	no_of_days;
	private BigDecimal	amount1;
	private BigDecimal	dealrate;
	private BigDecimal	amount2;
	private BigDecimal	reval_rate;
	private BigDecimal	reval_amount;
	private BigDecimal	profitloss;
	private String	contrepartie;
	private String	branch_code;
	private BigDecimal	lcyrate;
	private BigDecimal	lcyprofitloss;
	@Id
	private Date	report_date;
	private String	entry_user;
	private Date	entry_time;
	private String	modify_user;
	private Date	modify_time;
	private String	verify_user;
	private Date	verify_time;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	public BigDecimal getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(BigDecimal num_operation) {
		this.num_operation = num_operation;
	}
	public BigDecimal getGl_values() {
		return gl_values;
	}
	public void setGl_values(BigDecimal gl_values) {
		this.gl_values = gl_values;
	}
	public String getOp_reference() {
		return op_reference;
	}
	public void setOp_reference(String op_reference) {
		this.op_reference = op_reference;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Date getDealdate() {
		return dealdate;
	}
	public void setDealdate(Date dealdate) {
		this.dealdate = dealdate;
	}
	public Date getValuedate() {
		return valuedate;
	}
	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}
	public Date getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(Date maturitydate) {
		this.maturitydate = maturitydate;
	}
	public String getCurrency1() {
		return currency1;
	}
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}
	public String getCurrency2() {
		return currency2;
	}
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	public BigDecimal getNominal_1() {
		return nominal_1;
	}
	public void setNominal_1(BigDecimal nominal_1) {
		this.nominal_1 = nominal_1;
	}
	public BigDecimal getRamount() {
		return ramount;
	}
	public void setRamount(BigDecimal ramount) {
		this.ramount = ramount;
	}
	public BigDecimal getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(BigDecimal no_of_days) {
		this.no_of_days = no_of_days;
	}
	public BigDecimal getAmount1() {
		return amount1;
	}
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	public BigDecimal getDealrate() {
		return dealrate;
	}
	public void setDealrate(BigDecimal dealrate) {
		this.dealrate = dealrate;
	}
	public BigDecimal getAmount2() {
		return amount2;
	}
	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
	public BigDecimal getReval_rate() {
		return reval_rate;
	}
	public void setReval_rate(BigDecimal reval_rate) {
		this.reval_rate = reval_rate;
	}
	public BigDecimal getReval_amount() {
		return reval_amount;
	}
	public void setReval_amount(BigDecimal reval_amount) {
		this.reval_amount = reval_amount;
	}
	public BigDecimal getProfitloss() {
		return profitloss;
	}
	public void setProfitloss(BigDecimal profitloss) {
		this.profitloss = profitloss;
	}
	public String getContrepartie() {
		return contrepartie;
	}
	public void setContrepartie(String contrepartie) {
		this.contrepartie = contrepartie;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public BigDecimal getLcyrate() {
		return lcyrate;
	}
	public void setLcyrate(BigDecimal lcyrate) {
		this.lcyrate = lcyrate;
	}
	public BigDecimal getLcyprofitloss() {
		return lcyprofitloss;
	}
	public void setLcyprofitloss(BigDecimal lcyprofitloss) {
		this.lcyprofitloss = lcyprofitloss;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
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
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
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
	@Override
	public String toString() {
		return "Forward_reveal_manual_table [num_operation=" + num_operation + ", gl_values=" + gl_values
				+ ", op_reference=" + op_reference + ", poste=" + poste + ", dealdate=" + dealdate + ", valuedate="
				+ valuedate + ", maturitydate=" + maturitydate + ", currency1=" + currency1 + ", currency2=" + currency2
				+ ", nominal_1=" + nominal_1 + ", ramount=" + ramount + ", no_of_days=" + no_of_days + ", amount1="
				+ amount1 + ", dealrate=" + dealrate + ", amount2=" + amount2 + ", reval_rate=" + reval_rate
				+ ", reval_amount=" + reval_amount + ", profitloss=" + profitloss + ", contrepartie=" + contrepartie
				+ ", branch_code=" + branch_code + ", lcyrate=" + lcyrate + ", lcyprofitloss=" + lcyprofitloss
				+ ", report_date=" + report_date + ", entry_user=" + entry_user + ", entry_time=" + entry_time
				+ ", modify_user=" + modify_user + ", modify_time=" + modify_time + ", verify_user=" + verify_user
				+ ", verify_time=" + verify_time + ", del_flg=" + del_flg + ", entity_flg=" + entity_flg
				+ ", modify_flg=" + modify_flg + "]";
	}
	public Forward_reveal_manual_table(BigDecimal num_operation, BigDecimal gl_values, String op_reference,
			String poste, Date dealdate, Date valuedate, Date maturitydate, String currency1, String currency2,
			BigDecimal nominal_1, BigDecimal ramount, BigDecimal no_of_days, BigDecimal amount1, BigDecimal dealrate,
			BigDecimal amount2, BigDecimal reval_rate, BigDecimal reval_amount, BigDecimal profitloss,
			String contrepartie, String branch_code, BigDecimal lcyrate, BigDecimal lcyprofitloss, Date report_date,
			String entry_user, Date entry_time, String modify_user, Date modify_time, String verify_user,
			Date verify_time, String del_flg, String entity_flg, String modify_flg) {
		super();
		this.num_operation = num_operation;
		this.gl_values = gl_values;
		this.op_reference = op_reference;
		this.poste = poste;
		this.dealdate = dealdate;
		this.valuedate = valuedate;
		this.maturitydate = maturitydate;
		this.currency1 = currency1;
		this.currency2 = currency2;
		this.nominal_1 = nominal_1;
		this.ramount = ramount;
		this.no_of_days = no_of_days;
		this.amount1 = amount1;
		this.dealrate = dealrate;
		this.amount2 = amount2;
		this.reval_rate = reval_rate;
		this.reval_amount = reval_amount;
		this.profitloss = profitloss;
		this.contrepartie = contrepartie;
		this.branch_code = branch_code;
		this.lcyrate = lcyrate;
		this.lcyprofitloss = lcyprofitloss;
		this.report_date = report_date;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
	}
	public Forward_reveal_manual_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
