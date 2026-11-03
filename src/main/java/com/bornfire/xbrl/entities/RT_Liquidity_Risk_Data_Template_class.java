package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RT_Liquidity_Risk_Data_Template_class implements Serializable{
	
	private String glLevel1;
	private String glLevel2;
	private String glLevel3;
	private String optionType;
	private String rateType;
	private String referenceRate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date reportDate;
	private String instrumentCurrency;
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
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getReferenceRate() {
		return referenceRate;
	}
	public void setReferenceRate(String referenceRate) {
		this.referenceRate = referenceRate;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getInstrumentCurrency() {
		return instrumentCurrency;
	}
	public void setInstrumentCurrency(String instrumentCurrency) {
		this.instrumentCurrency = instrumentCurrency;
	}
	public RT_Liquidity_Risk_Data_Template_class(String glLevel1, String glLevel2, String glLevel3, String optionType,
			String rateType, String referenceRate, Date reportDate, String instrumentCurrency) {
		super();
		this.glLevel1 = glLevel1;
		this.glLevel2 = glLevel2;
		this.glLevel3 = glLevel3;
		this.optionType = optionType;
		this.rateType = rateType;
		this.referenceRate = referenceRate;
		this.reportDate = reportDate;
		this.instrumentCurrency = instrumentCurrency;
	}
	public RT_Liquidity_Risk_Data_Template_class() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
