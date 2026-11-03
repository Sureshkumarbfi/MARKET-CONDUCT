package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_MC_SERVICE_AUDIT_TABLE")
public class MC_Service_audit_entity {
	@Id
	private String audit_ref_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date audit_date;
	private String audit_table;
	private String audit_screen;
	private String session_id;
	private String event_id;
	private String event_name;
	@Lob
	private String modi_details;
	private String entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	private String remarks;
	private String auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date auth_time;
	private String func_code;
	private String field_name;
	private String old_value;
	private String new_value;
	private String domain_id;
	private String entry_user_name;
	private String auth_user_name;
	private String FIELD_HEADER;
	private String ISMODIFIED;

	public String getISMODIFIED() {
		return ISMODIFIED;
	}

	public void setISMODIFIED(String iSMODIFIED) {
		ISMODIFIED = iSMODIFIED;
	}

	public String getFIELD_HEADER() {
		return FIELD_HEADER;
	}

	public void setFIELD_HEADER(String fIELD_HEADER) {
		FIELD_HEADER = fIELD_HEADER;
	}

	public String getAudit_ref_no() {
		return audit_ref_no;
	}

	public void setAudit_ref_no(String audit_ref_no) {
		this.audit_ref_no = audit_ref_no;
	}

	public Date getAudit_date() {
		return audit_date;
	}

	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}

	public String getAudit_table() {
		return audit_table;
	}

	public void setAudit_table(String audit_table) {
		this.audit_table = audit_table;
	}

	public String getAudit_screen() {
		return audit_screen;
	}

	public void setAudit_screen(String audit_screen) {
		this.audit_screen = audit_screen;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getModi_details() {
		return modi_details;
	}

	public void setModi_details(String modi_details) {
		this.modi_details = modi_details;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}

	public String getFunc_code() {
		return func_code;
	}

	public void setFunc_code(String func_code) {
		this.func_code = func_code;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getOld_value() {
		return old_value;
	}

	public void setOld_value(String old_value) {
		this.old_value = old_value;
	}

	public String getNew_value() {
		return new_value;
	}

	public void setNew_value(String new_value) {
		this.new_value = new_value;
	}

	public String getDomain_id() {
		return domain_id;
	}

	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}

	public String getEntry_user_name() {
		return entry_user_name;
	}

	public void setEntry_user_name(String entry_user_name) {
		this.entry_user_name = entry_user_name;
	}

	public String getAuth_user_name() {
		return auth_user_name;
	}

	public void setAuth_user_name(String auth_user_name) {
		this.auth_user_name = auth_user_name;
	}

}
