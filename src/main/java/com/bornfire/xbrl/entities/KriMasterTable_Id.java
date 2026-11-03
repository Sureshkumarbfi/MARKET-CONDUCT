package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class KriMasterTable_Id implements Serializable {
	private BigDecimal sn;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date reportDate;
	private String delFlg;
	public BigDecimal getSn() {
		return sn;
	}
	public void setSn(BigDecimal sn) {
		this.sn = sn;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public KriMasterTable_Id(BigDecimal sn, Date reportDate, String delFlg) {
		super();
		this.sn = sn;
		this.reportDate = reportDate;
		this.delFlg = delFlg;
	}
	public KriMasterTable_Id() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
