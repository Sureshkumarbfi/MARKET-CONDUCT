package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Eod_acct_balance_pojo {
	
	private String acid;
	private Date eod_date;
	private BigDecimal tran_date_bal;
	private BigDecimal tran_date_tot_tran;
	private BigDecimal value_date_bal;
	private BigDecimal value_date_tot_tran;
	private Date end_eod_date;
	private String lchg_user_id;
	private Date lchg_time;
	private String rcre_user_id;
	private Date rcre_time;
	private String ts_cnt;
	private String eab_crncy_code;
	private String bank_id;
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public Date getEod_date() {
		return eod_date;
	}
	public void setEod_date(Date eod_date) {
		this.eod_date = eod_date;
	}
	public BigDecimal getTran_date_bal() {
		return tran_date_bal;
	}
	public void setTran_date_bal(BigDecimal tran_date_bal) {
		this.tran_date_bal = tran_date_bal;
	}
	public BigDecimal getTran_date_tot_tran() {
		return tran_date_tot_tran;
	}
	public void setTran_date_tot_tran(BigDecimal tran_date_tot_tran) {
		this.tran_date_tot_tran = tran_date_tot_tran;
	}
	public BigDecimal getValue_date_bal() {
		return value_date_bal;
	}
	public void setValue_date_bal(BigDecimal value_date_bal) {
		this.value_date_bal = value_date_bal;
	}
	public BigDecimal getValue_date_tot_tran() {
		return value_date_tot_tran;
	}
	public void setValue_date_tot_tran(BigDecimal value_date_tot_tran) {
		this.value_date_tot_tran = value_date_tot_tran;
	}
	public Date getEnd_eod_date() {
		return end_eod_date;
	}
	public void setEnd_eod_date(Date end_eod_date) {
		this.end_eod_date = end_eod_date;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getTs_cnt() {
		return ts_cnt;
	}
	public void setTs_cnt(String ts_cnt) {
		this.ts_cnt = ts_cnt;
	}
	public String getEab_crncy_code() {
		return eab_crncy_code;
	}
	public void setEab_crncy_code(String eab_crncy_code) {
		this.eab_crncy_code = eab_crncy_code;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	@Override
	public String toString() {
		return "Eod_acct_balance_pojo [acid=" + acid + ", eod_date=" + eod_date + ", tran_date_bal=" + tran_date_bal
				+ ", tran_date_tot_tran=" + tran_date_tot_tran + ", value_date_bal=" + value_date_bal
				+ ", value_date_tot_tran=" + value_date_tot_tran + ", end_eod_date=" + end_eod_date + ", lchg_user_id="
				+ lchg_user_id + ", lchg_time=" + lchg_time + ", rcre_user_id=" + rcre_user_id + ", rcre_time="
				+ rcre_time + ", ts_cnt=" + ts_cnt + ", eab_crncy_code=" + eab_crncy_code + ", bank_id=" + bank_id
				+ "]";
	}
	public Eod_acct_balance_pojo(String acid, Date eod_date, BigDecimal tran_date_bal, BigDecimal tran_date_tot_tran,
			BigDecimal value_date_bal, BigDecimal value_date_tot_tran, Date end_eod_date, String lchg_user_id,
			Date lchg_time, String rcre_user_id, Date rcre_time, String ts_cnt, String eab_crncy_code, String bank_id) {
		super();
		this.acid = acid;
		this.eod_date = eod_date;
		this.tran_date_bal = tran_date_bal;
		this.tran_date_tot_tran = tran_date_tot_tran;
		this.value_date_bal = value_date_bal;
		this.value_date_tot_tran = value_date_tot_tran;
		this.end_eod_date = end_eod_date;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.ts_cnt = ts_cnt;
		this.eab_crncy_code = eab_crncy_code;
		this.bank_id = bank_id;
	}
	public Eod_acct_balance_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
