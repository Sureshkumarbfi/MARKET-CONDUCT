package com.bornfire.xbrl.entities;

import java.io.Serializable;
import java.util.Date;

public class RT_EAR_IDCLASS implements Serializable {

	private Date REPORT_DATE;
	private String REPORT_TYPE;

	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}

	public String getREPORT_TYPE() {
		return REPORT_TYPE;
	}

	public void setREPORT_TYPE(String rEPORT_TYPE) {
		REPORT_TYPE = rEPORT_TYPE;
	}

}