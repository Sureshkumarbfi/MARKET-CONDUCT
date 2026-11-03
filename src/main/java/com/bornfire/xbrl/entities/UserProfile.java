package com.bornfire.xbrl.entities;

import java.sql.Blob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BRF_USER_PROFILE_TABLE")
public class UserProfile implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String bank_code;
	private String bank_name;
	private String branch_code;
	private String branch_name;
	
	@Column(name = "emp_id")
	private String empid;
	private String emp_name;
	
	@Id
	@Column(name="user_id")
	private String userid;
	
	@Column(name = "user_name")
	private String username;
	private String inactive_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date acc_exp_date;
	private String login_low;
	private String login_high;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date disable_start_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date disable_end_date;
	private String password;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date pass_exp_date;
	private String user_status;
	private String login_status;
	private String virtual_flg;
	private String work_class;
	private String mob_number;
	private String email_id;
	private String role_id;
	private String role_desc;
	private String permissions;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private String per_effctive_date;
	private String admin;
	private String xbrl_configuration;
	private String xbrl_report;
	private String scheduler;
	private String execution;
	private String mis_reports;
	private String xml_reports;
	private String archivel;
	private String general_inq;
	private String audit_inq;
	private String channel;
	private String entry_user;
	private Date entry_time;
	private String auth_user;
	private Date auth_time;
	private String modify_user;
	private Date modify_time;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;
	private String session_id;
	private String login_flg;
	private String user_locked_flg;
	private Integer no_of_attmp;
	private String disable_flg;
	private Blob photo;
	private String domain_id;
    private String acct_access_code;
    private String brf181_login;
    private String	pass_exp_days;
    private String	log_in_count;
    private String designation;
    private String department;
   
	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
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

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInactive_time() {
		return inactive_time;
	}

	public void setInactive_time(String inactive_time) {
		this.inactive_time = inactive_time;
	}

	public Date getAcc_exp_date() {
		return acc_exp_date;
	}

	public void setAcc_exp_date(Date acc_exp_date) {
		this.acc_exp_date = acc_exp_date;
	}

	public String getLogin_low() {
		return login_low;
	}

	public void setLogin_low(String login_low) {
		this.login_low = login_low;
	}

	public String getLogin_high() {
		return login_high;
	}

	public void setLogin_high(String login_high) {
		this.login_high = login_high;
	}

	public Date getDisable_start_date() {
		return disable_start_date;
	}

	public void setDisable_start_date(Date disable_start_date) {
		this.disable_start_date = disable_start_date;
	}

	public Date getDisable_end_date() {
		return disable_end_date;
	}

	public void setDisable_end_date(Date disable_end_date) {
		this.disable_end_date = disable_end_date;
	}
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPass_exp_date() {
		return pass_exp_date;
	}

	public void setPass_exp_date(Date pass_exp_date) {
		this.pass_exp_date = pass_exp_date;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getLogin_status() {
		return login_status;
	}

	public void setLogin_status(String login_status) {
		this.login_status = login_status;
	}

	public String getVirtual_flg() {
		return virtual_flg;
	}

	public void setVirtual_flg(String virtual_flg) {
		this.virtual_flg = virtual_flg;
	}

	public String getWork_class() {
		return work_class;
	}

	public void setWork_class(String work_class) {
		this.work_class = work_class;
	}

	public String getMob_number() {
		return mob_number;
	}

	public void setMob_number(String mob_number) {
		this.mob_number = mob_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getPer_effctive_date() {
		return per_effctive_date;
	}

	public void setPer_effctive_date(String per_effctive_date) {
		this.per_effctive_date = per_effctive_date;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getXbrl_configuration() {
		return xbrl_configuration;
	}

	public void setXbrl_configuration(String xbrl_configuration) {
		this.xbrl_configuration = xbrl_configuration;
	}

	public String getXbrl_report() {
		return xbrl_report;
	}

	public void setXbrl_report(String xbrl_report) {
		this.xbrl_report = xbrl_report;
	}

	public String getScheduler() {
		return scheduler;
	}

	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getMis_reports() {
		return mis_reports;
	}

	public void setMis_reports(String mis_reports) {
		this.mis_reports = mis_reports;
	}

	public String getXml_reports() {
		return xml_reports;
	}

	public void setXml_reports(String xml_reports) {
		this.xml_reports = xml_reports;
	}

	public String getArchivel() {
		return archivel;
	}

	public void setArchivel(String archivel) {
		this.archivel = archivel;
	}

	public String getGeneral_inq() {
		return general_inq;
	}

	public void setGeneral_inq(String general_inq) {
		this.general_inq = general_inq;
	}

	public String getAudit_inq() {
		return audit_inq;
	}

	public void setAudit_inq(String audit_inq) {
		this.audit_inq = audit_inq;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public String getAuth_flg() {
		return auth_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
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

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getLogin_flg() {
		return login_flg;
	}

	public void setLogin_flg(String login_flg) {
		this.login_flg = login_flg;
	}

	public String getUser_locked_flg() {
		return user_locked_flg;
	}

	public void setUser_locked_flg(String user_locked_flg) {
		this.user_locked_flg = user_locked_flg;
	}

	public Integer getNo_of_attmp() {
		return no_of_attmp;
	}

	public void setNo_of_attmp(Integer no_of_attmp) {
		this.no_of_attmp = no_of_attmp;
	}

	public String getDisable_flg() {
		return disable_flg;
	}

	public void setDisable_flg(String disable_flg) {
		this.disable_flg = disable_flg;
	}

	@JsonIgnore
	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getDomain_id() {
		return domain_id;
	}

	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}

	public String getAcct_access_code() {
		return acct_access_code;
	}

	public void setAcct_access_code(String acct_access_code) {
		this.acct_access_code = acct_access_code;
	}

	public String getBrf181_login() {
		return brf181_login;
	}

	public void setBrf181_login(String brf181_login) {
		this.brf181_login = brf181_login;
	}

	public String getPass_exp_days() {
		return pass_exp_days;
	}

	public void setPass_exp_days(String pass_exp_days) {
		this.pass_exp_days = pass_exp_days;
	}

	public String getLog_in_count() {
		return log_in_count;
	}

	public void setLog_in_count(String log_in_count) {
		this.log_in_count = log_in_count;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		if (this.getAcc_exp_date().after(new Date())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		if (this.getUser_status().equals("Inactive")) {

			return false;
		} else {
			
			return true;
		}

	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		if (this.getPass_exp_date().after(new Date())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		
		Date currDate = new Date();
		if (this.getDisable_flg().equals("Y") || (currDate.after(this.getDisable_start_date()) && currDate.before(this.disable_end_date)) || this.entity_flg.equals("N")) {
			return false;
		} else {
			return true;
		}
	}
	
	@JsonIgnore
	public boolean isEnabledUser() {
		
		if (this.getLogin_status().equals("Inactive")) {
			return false;
		} else {
			return true;
		}
	}
	
	@JsonIgnore
	public boolean isverifiedUser() {
		
		if (this.entity_flg.equals("N")) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isLoginAllowed() {
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm");
		
		try {
			Date loginHigh = dateFormat.parse(this.login_high);
			Date loginLow = dateFormat.parse(this.login_low);
			
			LocalTime high = LocalDateTime.ofInstant(loginHigh.toInstant(), ZoneId.systemDefault()).toLocalTime();
			LocalTime low = LocalDateTime.ofInstant(loginLow.toInstant(), ZoneId.systemDefault()).toLocalTime();
			LocalTime currTime = java.time.LocalTime.now();
			
			if(currTime.isAfter(low) && entity_flg.equals("Y")) {
				
			if(currTime.isBefore(high)) {

				{
					return true;
				}
			}
			else {
				/* Always return true to allow login any time */
				return true;
			}
				
			
			}
			} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}


}