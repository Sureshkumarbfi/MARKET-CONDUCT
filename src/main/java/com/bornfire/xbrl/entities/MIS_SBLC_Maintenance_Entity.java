package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIS_SBLC_MAINTENANCE_TABLE")
public class MIS_SBLC_Maintenance_Entity {

	@Id
	@Column(name = "ID")
	private BigDecimal id;

	@Column(name = "SRL_NO")
	private String srl_no;

	@Column(name = "SOL_ID")
	private String sol_id;

	@Column(name = "ACCOUNT_NO")
	private String account_no;

	@Column(name = "GL_SUBHEAD")
	private String gl_subhead;

	@Column(name = "CUSTOMER_NAME")
	private String customer_name;

	@Column(name = "BANK_NAME")
	private String bank_name;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "CREATE_USER")
	private String create_user;

	@Column(name = "CREATE_TIME")
	private Date create_time;

	@Column(name = "MODIFY_USER")
	private String modify_user;

	@Column(name = "MODIFY_TIME")
	private Date modify_time;

	@Column(name = "VERIFY_USER")
	private String verify_user;

	@Column(name = "VERIFY_TIME")
	private Date verify_time;

	@Column(name = "ENTITY_FLG")
	private String entity_flg;

	@Column(name = "MODIFY_FLG")
	private String modify_flg;

	@Column(name = "DEL_FLG")
	private String del_flg;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "REPORT_DATE")
	private Date report_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "OPEN_DATE")
	private Date open_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "EXPIRE_DATE")
	private Date expire_date;

	@Column(name = "BRANCH_CODE")
	private String branch_code;

	@Column(name = "BRANCH_NAME")
	private String branch_name;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getGl_subhead() {
		return gl_subhead;
	}

	public void setGl_subhead(String gl_subhead) {
		this.gl_subhead = gl_subhead;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public MIS_SBLC_Maintenance_Entity(BigDecimal id, String srl_no, String sol_id, String account_no,
			String gl_subhead, String customer_name, String bank_name, BigDecimal amount, String create_user,
			Date create_time, String modify_user, Date modify_time, String verify_user, Date verify_time,
			String entity_flg, String modify_flg, String del_flg, Date report_date, Date open_date, Date expire_date,
			String branch_code, String branch_name) {
		super();
		this.id = id;
		this.srl_no = srl_no;
		this.sol_id = sol_id;
		this.account_no = account_no;
		this.gl_subhead = gl_subhead;
		this.customer_name = customer_name;
		this.bank_name = bank_name;
		this.amount = amount;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_date = report_date;
		this.open_date = open_date;
		this.expire_date = expire_date;
		this.branch_code = branch_code;
		this.branch_name = branch_name;
	}

	public MIS_SBLC_Maintenance_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
