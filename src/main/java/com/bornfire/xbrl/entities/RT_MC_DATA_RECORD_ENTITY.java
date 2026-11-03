package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RT_MC_DATA_RECORD")
@IdClass(MCReportDataRecordId.class)
public class RT_MC_DATA_RECORD_ENTITY {
	@Column(name = "ID")
	private BigDecimal id;

	@Id
	@Column(name = "FORM_MODE")
	private String formMode;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date reportDate;

	@Column(name = "VERIFY_FLG")
	private String verifyFlg;

	@Column(name = "MODIFY_FLG")
	private String modifyFlg;

	@Column(name = "COLUMN_HEADER")
	private String columnHeader;

	@Column(name = "ROW_COL2_VALUE")
	private String rowCol2Value;

	@Id
	@Column(name = "CELL_NAME")
	private String cellName;

	@Column(name = "CELL_ID")
	private String cellId;

	@Column(name = "DATA_VALUE")
	private String dataValue;

	@Column(name = "JUSTIFICATION")
	private String justification;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_REPORT_DATE")
	private Date submittedReportDate;

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "REMARKS")
	private String remarks;

	@Id
	@Column(name = "TIMEPERIOD")
	private String timeperiod;

	@Column(name = "CHECKER_JUSTIFICATION")
	private String checkerJustification;

	@Column(name = "FILE_NAME_1")
	private String fileName1;
	@Column(name = "FILE_NAME_2")
	private String fileName2;
	@Column(name = "FILE_NAME_3")
	private String fileName3;
	@Column(name = "FILE_NAME_4")
	private String fileName4;
	@Column(name = "FILE_NAME_5")
	private String fileName5;
	@Column(name = "FILE_NAME_6")
	private String fileName6;
	@Column(name = "FILE_NAME_7")
	private String fileName7;
	@Column(name = "FILE_NAME_8")
	private String fileName8;
	@Column(name = "FILE_NAME_9")
	private String fileName9;
	@Column(name = "FILE_NAME_10")
	private String fileName10;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_1")
	private byte[] fileData1;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_2")
	private byte[] fileData2;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_3")
	private byte[] fileData3;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_4")
	private byte[] fileData4;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_5")
	private byte[] fileData5;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_6")
	private byte[] fileData6;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_7")
	private byte[] fileData7;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_8")
	private byte[] fileData8;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_9")
	private byte[] fileData9;
	@JsonIgnore
	@Lob
	@Column(name = "FILE_DATA_10")
	private byte[] fileData10;

	@Column(name = "CRO_VERIFY_FLG")
	private String croVerifyFlg;

	@Column(name = "CRO_REMARKS")
	private String croRemarks;

	@Column(name = "CCO_VERIFY_FLG")
	private String ccoVerifyFlg;

	@Column(name = "CCO_REMARKS")
	private String ccoRemarks;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFormMode() {
		return formMode;
	}

	public void setFormMode(String formMode) {
		this.formMode = formMode;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getVerifyFlg() {
		return verifyFlg;
	}

	public void setVerifyFlg(String verifyFlg) {
		this.verifyFlg = verifyFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getColumnHeader() {
		return columnHeader;
	}

	public void setColumnHeader(String columnHeader) {
		this.columnHeader = columnHeader;
	}

	public String getRowCol2Value() {
		return rowCol2Value;
	}

	public void setRowCol2Value(String rowCol2Value) {
		this.rowCol2Value = rowCol2Value;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public String getFileName3() {
		return fileName3;
	}

	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}

	public String getFileName4() {
		return fileName4;
	}

	public void setFileName4(String fileName4) {
		this.fileName4 = fileName4;
	}

	public String getFileName5() {
		return fileName5;
	}

	public void setFileName5(String fileName5) {
		this.fileName5 = fileName5;
	}

	public String getFileName6() {
		return fileName6;
	}

	public void setFileName6(String fileName6) {
		this.fileName6 = fileName6;
	}

	public String getFileName7() {
		return fileName7;
	}

	public void setFileName7(String fileName7) {
		this.fileName7 = fileName7;
	}

	public String getFileName8() {
		return fileName8;
	}

	public void setFileName8(String fileName8) {
		this.fileName8 = fileName8;
	}

	public String getFileName9() {
		return fileName9;
	}

	public void setFileName9(String fileName9) {
		this.fileName9 = fileName9;
	}

	public String getFileName10() {
		return fileName10;
	}

	public void setFileName10(String fileName10) {
		this.fileName10 = fileName10;
	}

	public byte[] getFileData1() {
		return fileData1;
	}

	public void setFileData1(byte[] fileData1) {
		this.fileData1 = fileData1;
	}

	public byte[] getFileData2() {
		return fileData2;
	}

	public void setFileData2(byte[] fileData2) {
		this.fileData2 = fileData2;
	}

	public byte[] getFileData3() {
		return fileData3;
	}

	public void setFileData3(byte[] fileData3) {
		this.fileData3 = fileData3;
	}

	public byte[] getFileData4() {
		return fileData4;
	}

	public void setFileData4(byte[] fileData4) {
		this.fileData4 = fileData4;
	}

	public byte[] getFileData5() {
		return fileData5;
	}

	public void setFileData5(byte[] fileData5) {
		this.fileData5 = fileData5;
	}

	public byte[] getFileData6() {
		return fileData6;
	}

	public void setFileData6(byte[] fileData6) {
		this.fileData6 = fileData6;
	}

	public byte[] getFileData7() {
		return fileData7;
	}

	public void setFileData7(byte[] fileData7) {
		this.fileData7 = fileData7;
	}

	public byte[] getFileData8() {
		return fileData8;
	}

	public void setFileData8(byte[] fileData8) {
		this.fileData8 = fileData8;
	}

	public byte[] getFileData9() {
		return fileData9;
	}

	public void setFileData9(byte[] fileData9) {
		this.fileData9 = fileData9;
	}

	public byte[] getFileData10() {
		return fileData10;
	}

	public void setFileData10(byte[] fileData10) {
		this.fileData10 = fileData10;
	}

	public Date getSubmittedReportDate() {
		return submittedReportDate;
	}

	public void setSubmittedReportDate(Date submittedReportDate) {
		this.submittedReportDate = submittedReportDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTimeperiod() {
		return timeperiod;
	}

	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

	public String getCheckerJustification() {
		return checkerJustification;
	}

	public void setCheckerJustification(String checkerJustification) {
		this.checkerJustification = checkerJustification;
	}

	public String getCroVerifyFlg() {
		return croVerifyFlg;
	}

	public void setCroVerifyFlg(String croVerifyFlg) {
		this.croVerifyFlg = croVerifyFlg;
	}

	public String getCroRemarks() {
		return croRemarks;
	}

	public void setCroRemarks(String croRemarks) {
		this.croRemarks = croRemarks;
	}

	public String getCcoVerifyFlg() {
		return ccoVerifyFlg;
	}

	public void setCcoVerifyFlg(String ccoVerifyFlg) {
		this.ccoVerifyFlg = ccoVerifyFlg;
	}

	public String getCcoRemarks() {
		return ccoRemarks;
	}

	public void setCcoRemarks(String ccoRemarks) {
		this.ccoRemarks = ccoRemarks;
	}

}
