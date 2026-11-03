package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RT_FX_POSITION_TABLE")
public class RT_FX_Position_Entity {
	@Id
	private String srl_no;
	private String position_type;
	private BigDecimal gbp;
	private BigDecimal usd;
	private BigDecimal jpy;
	private BigDecimal chf;
	private BigDecimal eur;
	private BigDecimal inr;
	private BigDecimal sgd;
	private BigDecimal sar;
	private BigDecimal aed;
	private BigDecimal kwd;
	private BigDecimal qar;
	@Temporal(TemporalType.DATE)
	private Date report_date;
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

	public String getPosition_type() {
		return position_type;
	}

	public void setPosition_type(String position_type) {
		this.position_type = position_type;
	}

	public BigDecimal getGbp() {
		return gbp;
	}

	public void setGbp(BigDecimal gbp) {
		this.gbp = gbp;
	}

	public BigDecimal getUsd() {
		return usd;
	}

	public void setUsd(BigDecimal usd) {
		this.usd = usd;
	}

	public BigDecimal getJpy() {
		return jpy;
	}

	public void setJpy(BigDecimal jpy) {
		this.jpy = jpy;
	}

	public BigDecimal getChf() {
		return chf;
	}

	public void setChf(BigDecimal chf) {
		this.chf = chf;
	}

	public BigDecimal getEur() {
		return eur;
	}

	public void setEur(BigDecimal eur) {
		this.eur = eur;
	}

	public BigDecimal getInr() {
		return inr;
	}

	public void setInr(BigDecimal inr) {
		this.inr = inr;
	}

	public BigDecimal getSgd() {
		return sgd;
	}

	public void setSgd(BigDecimal sgd) {
		this.sgd = sgd;
	}

	public BigDecimal getSar() {
		return sar;
	}

	public void setSar(BigDecimal sar) {
		this.sar = sar;
	}

	public BigDecimal getAed() {
		return aed;
	}

	public void setAed(BigDecimal aed) {
		this.aed = aed;
	}

	public BigDecimal getKwd() {
		return kwd;
	}

	public void setKwd(BigDecimal kwd) {
		this.kwd = kwd;
	}

	public BigDecimal getQar() {
		return qar;
	}

	public void setQar(BigDecimal qar) {
		this.qar = qar;
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

	public RT_FX_Position_Entity(String srl_no, String position_type, BigDecimal gbp, BigDecimal usd, BigDecimal jpy,
			BigDecimal chf, BigDecimal eur, BigDecimal inr, BigDecimal sgd, BigDecimal sar, BigDecimal aed,
			BigDecimal kwd, BigDecimal qar, Date report_date, Date report_from_date, Date report_to_date,
			String create_user, Date create_time, String modify_user, Date modify_time, String verify_user,
			Date verify_time, String entity_flg, String modify_flg, String del_flg) {
		super();
		this.srl_no = srl_no;
		this.position_type = position_type;
		this.gbp = gbp;
		this.usd = usd;
		this.jpy = jpy;
		this.chf = chf;
		this.eur = eur;
		this.inr = inr;
		this.sgd = sgd;
		this.sar = sar;
		this.aed = aed;
		this.kwd = kwd;
		this.qar = qar;
		this.report_date = report_date;
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

	@Override
	public String toString() {
		return "RT_FX_Position_Entity [srl_no=" + srl_no + ", position_type=" + position_type + ", gbp=" + gbp
				+ ", usd=" + usd + ", jpy=" + jpy + ", chf=" + chf + ", eur=" + eur + ", inr=" + inr + ", sgd=" + sgd
				+ ", sar=" + sar + ", aed=" + aed + ", kwd=" + kwd + ", qar=" + qar + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", create_user="
				+ create_user + ", create_time=" + create_time + ", modify_user=" + modify_user + ", modify_time="
				+ modify_time + ", verify_user=" + verify_user + ", verify_time=" + verify_time + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", getSrl_no()=" + getSrl_no()
				+ ", getPosition_type()=" + getPosition_type() + ", getGbp()=" + getGbp() + ", getUsd()=" + getUsd()
				+ ", getJpy()=" + getJpy() + ", getChf()=" + getChf() + ", getEur()=" + getEur() + ", getInr()="
				+ getInr() + ", getSgd()=" + getSgd() + ", getSar()=" + getSar() + ", getAed()=" + getAed()
				+ ", getKwd()=" + getKwd() + ", getQar()=" + getQar() + ", getReport_date()=" + getReport_date()
				+ ", getReport_from_date()=" + getReport_from_date() + ", getReport_to_date()=" + getReport_to_date()
				+ ", getCreate_user()=" + getCreate_user() + ", getCreate_time()=" + getCreate_time()
				+ ", getModify_user()=" + getModify_user() + ", getModify_time()=" + getModify_time()
				+ ", getVerify_user()=" + getVerify_user() + ", getVerify_time()=" + getVerify_time()
				+ ", getEntity_flg()=" + getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()="
				+ getDel_flg() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public RT_FX_Position_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
