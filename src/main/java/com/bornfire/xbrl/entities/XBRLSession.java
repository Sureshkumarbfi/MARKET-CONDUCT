package com.bornfire.xbrl.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "SESSION_TABLE")
public class XBRLSession {

	private String menu;
	private String menu_id;
	private String session_id;
	private String user_id;
	private String ip_addr;
	@Id
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm a")
	private Date entry_time;
	private String status;
	
	public XBRLSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public XBRLSession(String menu, String menu_id, String session_id, String user_id, String ip_addr, Date entry_time,
			String status) {
		super();
		this.menu = menu;
		this.menu_id = menu_id;
		this.session_id = session_id;
		this.user_id = user_id;
		this.ip_addr = ip_addr;
		this.entry_time = entry_time;
		this.status = status;
	}

}
