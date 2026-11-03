package com.bornfire.xbrl.dto;

public class EodAcctBalExcepUpdateDto {

	/** yyyy-MM-dd for this row; should match REPORT_DATE on the server. */
	private String rowReportDate;

	private String acid;
	private String tranId;
	private String partTranSrlNum;
	private String schmType;
	private String schmCode;
	private String acctNumber;

	public String getRowReportDate() {
		return rowReportDate;
	}

	public void setRowReportDate(String rowReportDate) {
		this.rowReportDate = rowReportDate;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getPartTranSrlNum() {
		return partTranSrlNum;
	}

	public void setPartTranSrlNum(String partTranSrlNum) {
		this.partTranSrlNum = partTranSrlNum;
	}

	public String getSchmType() {
		return schmType;
	}

	public void setSchmType(String schmType) {
		this.schmType = schmType;
	}

	public String getSchmCode() {
		return schmCode;
	}

	public void setSchmCode(String schmCode) {
		this.schmCode = schmCode;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
}
