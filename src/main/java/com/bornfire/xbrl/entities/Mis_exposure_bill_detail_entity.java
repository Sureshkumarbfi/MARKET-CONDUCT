package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MIS_ASL_EXPOSURE_BILL_DETAIL_TABLE")
public class Mis_exposure_bill_detail_entity {
	
	@Id
	private String	srl_no;
	private String	branch_name;
	private String	country;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_loan;
	private BigDecimal	trade_loan_amt_usd;
	private BigDecimal	trade_loan_amt_eq_aed;
	private BigDecimal	interest_rate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	due_date;
	private String	name_of_the_bank;
	private String	bill_id;
	private String	customer_name;
	private String	account_no;
	private String	bill_status;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	private String	del_flg;
	private String	verify_flg;
	private String	modify_flg;
	private String	entry_flg;
	private Date report_date;
	private String counterparty_status;
	
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDate_of_loan() {
		return date_of_loan;
	}
	public void setDate_of_loan(Date date_of_loan) {
		this.date_of_loan = date_of_loan;
	}
	public BigDecimal getTrade_loan_amt_usd() {
		return trade_loan_amt_usd;
	}
	public void setTrade_loan_amt_usd(BigDecimal trade_loan_amt_usd) {
		this.trade_loan_amt_usd = trade_loan_amt_usd;
	}
	public BigDecimal getTrade_loan_amt_eq_aed() {
		return trade_loan_amt_eq_aed;
	}
	public void setTrade_loan_amt_eq_aed(BigDecimal trade_loan_amt_eq_aed) {
		this.trade_loan_amt_eq_aed = trade_loan_amt_eq_aed;
	}
	public BigDecimal getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getName_of_the_bank() {
		return name_of_the_bank;
	}
	public void setName_of_the_bank(String name_of_the_bank) {
		this.name_of_the_bank = name_of_the_bank;
	}
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
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
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getEntry_flg() {
		return entry_flg;
	}
	public void setEntry_flg(String entry_flg) {
		this.entry_flg = entry_flg;
	}	
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getCounterparty_status() {
		return counterparty_status;
	}
	public void setCounterparty_status(String counterparty_status) {
		this.counterparty_status = counterparty_status;
	}
	@Override
	public String toString() {
		return "Mis_exposure_bill_detail_entity [srl_no=" + srl_no + ", branch_name=" + branch_name + ", country="
				+ country + ", date_of_loan=" + date_of_loan + ", trade_loan_amt_usd=" + trade_loan_amt_usd
				+ ", trade_loan_amt_eq_aed=" + trade_loan_amt_eq_aed + ", interest_rate=" + interest_rate
				+ ", due_date=" + due_date + ", name_of_the_bank=" + name_of_the_bank + ", bill_id=" + bill_id
				+ ", customer_name=" + customer_name + ", account_no=" + account_no + ", bill_status=" + bill_status
				+ ", entry_user=" + entry_user + ", modify_user=" + modify_user + ", verify_user=" + verify_user
				+ ", entry_time=" + entry_time + ", modify_time=" + modify_time + ", verify_time=" + verify_time
				+ ", del_flg=" + del_flg + ", verify_flg=" + verify_flg + ", modify_flg=" + modify_flg + ", entry_flg="
				+ entry_flg + ", report_date=" + report_date + ", counterparty_status=" + counterparty_status + "]";
	}
	public Mis_exposure_bill_detail_entity(String srl_no, String branch_name, String country, Date date_of_loan,
			BigDecimal trade_loan_amt_usd, BigDecimal trade_loan_amt_eq_aed, BigDecimal interest_rate, Date due_date,
			String name_of_the_bank, String bill_id, String customer_name, String account_no, String bill_status,
			String entry_user, String modify_user, String verify_user, Date entry_time, Date modify_time,
			Date verify_time, String del_flg, String verify_flg, String modify_flg, String entry_flg, Date report_date,
			String counterparty_status) {
		super();
		this.srl_no = srl_no;
		this.branch_name = branch_name;
		this.country = country;
		this.date_of_loan = date_of_loan;
		this.trade_loan_amt_usd = trade_loan_amt_usd;
		this.trade_loan_amt_eq_aed = trade_loan_amt_eq_aed;
		this.interest_rate = interest_rate;
		this.due_date = due_date;
		this.name_of_the_bank = name_of_the_bank;
		this.bill_id = bill_id;
		this.customer_name = customer_name;
		this.account_no = account_no;
		this.bill_status = bill_status;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.verify_flg = verify_flg;
		this.modify_flg = modify_flg;
		this.entry_flg = entry_flg;
		this.report_date = report_date;
		this.counterparty_status = counterparty_status;
	}
	public Mis_exposure_bill_detail_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
