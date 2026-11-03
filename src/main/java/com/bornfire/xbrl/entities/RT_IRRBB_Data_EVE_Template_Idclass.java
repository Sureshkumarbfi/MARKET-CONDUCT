package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RT_IRRBB_Data_EVE_Template_Idclass implements Serializable {
	
	private String scenario;
	private String glLevel1;
	private String glLevel2;
	private String glLevel3;
	private String instrumentCurrency;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reportDate;
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getGlLevel1() {
		return glLevel1;
	}
	public void setGlLevel1(String glLevel1) {
		this.glLevel1 = glLevel1;
	}
	public String getGlLevel2() {
		return glLevel2;
	}
	public void setGlLevel2(String glLevel2) {
		this.glLevel2 = glLevel2;
	}
	public String getGlLevel3() {
		return glLevel3;
	}
	public void setGlLevel3(String glLevel3) {
		this.glLevel3 = glLevel3;
	}
	public String getInstrumentCurrency() {
		return instrumentCurrency;
	}
	public void setInstrumentCurrency(String instrumentCurrency) {
		this.instrumentCurrency = instrumentCurrency;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public RT_IRRBB_Data_EVE_Template_Idclass(String scenario, String glLevel1, String glLevel2, String glLevel3,
			String instrumentCurrency, Date reportDate) {
		super();
		this.scenario = scenario;
		this.glLevel1 = glLevel1;
		this.glLevel2 = glLevel2;
		this.glLevel3 = glLevel3;
		this.instrumentCurrency = instrumentCurrency;
		this.reportDate = reportDate;
	}
	public RT_IRRBB_Data_EVE_Template_Idclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
