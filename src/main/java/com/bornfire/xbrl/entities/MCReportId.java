package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class MCReportId implements Serializable {

	private Date REPORT_DATE;
	private String BRANCH_CODE;

	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}

}
