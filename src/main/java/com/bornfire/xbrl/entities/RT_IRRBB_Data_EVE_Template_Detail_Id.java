package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class RT_IRRBB_Data_EVE_Template_Detail_Id implements Serializable {
	
	private String foracid;
	private Date date;
	private String scenario;
	private String instrumentCurrency;
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getInstrumentCurrency() {
		return instrumentCurrency;
	}
	public void setInstrumentCurrency(String instrumentCurrency) {
		this.instrumentCurrency = instrumentCurrency;
	}
	public RT_IRRBB_Data_EVE_Template_Detail_Id(String foracid, Date date, String scenario, String instrumentCurrency) {
		super();
		this.foracid = foracid;
		this.date = date;
		this.scenario = scenario;
		this.instrumentCurrency = instrumentCurrency;
	}
	public RT_IRRBB_Data_EVE_Template_Detail_Id() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	

}
