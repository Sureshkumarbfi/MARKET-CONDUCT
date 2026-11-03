package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BCBUAE_DATACONTROL")
public class RT_DataControl {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_control_seq_gen")
    @SequenceGenerator(name = "data_control_seq_gen", sequenceName = "DATA_CONTROL_SEQ", allocationSize = 1)
    @Column(name = "SI_NO")
    private Integer siNo;

    @Column(name = "PORTFOLIO_DATE")
    @Temporal(TemporalType.DATE)
    private Date portfolioDate;

    @Column(name = "SUBMITTING_INSTITUTION", length = 100)
    private String submittingInstitution;

    @Column(name = "CONTACT_EMPLOYEE1_NAME1", length = 100)
    private String contactEmployee1Name1;

    @Column(name = "CONTACT_EMPLOYEE1_TITLE1", length = 100)
    private String contactEmployee1Title1;

    @Column(name = "CONTACT_EMPLOYEE1_EMAIL1", length = 100)
    private String contactEmployee1Email1;

    @Column(name = "CONTACT_EMPLOYEE2_NAME2", length = 100)
    private String contactEmployee2Name2;

    @Column(name = "CONTACT_EMPLOYEE2_TITLE2", length = 100)
    private String contactEmployee2Title2;

    @Column(name = "CONTACT_EMPLOYEE2_EMAIL2", length = 100)
    private String contactEmployee2Email2;

    @Column(name = "SIGN_OFF_CRO_NAME", length = 100)
    private String signOffCroName;

    @Column(name = "SIGN_OFF_CRO_EMAIL", length = 100)
    private String signOffCroEmail;

    @Column(name = "SIGN_OFF_CFO_NAME", length = 100)
    private String signOffCfoName;

    @Column(name = "SIGN_OFF_CFO_EMAIL", length = 100)
    private String signOffCfoEmail;

    @Column(name = "SIGN_OFF_HEAD_OF_TREASURY_NAME", length = 100)
    private String signOffHeadOfTreasuryName;

    @Column(name = "SIGN_OFF_HEAD_OF_TREASURY_EMAIL", length = 100)
    private String signOffHeadOfTreasuryEmail;

    @Column(name = "Report_name", length = 100)
    private String Report_name;
    
    @Column(name = "AUDITED_DATA", length = 100)
    private String auditedData;

    @Column(name = "REPORT_SUBMIT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportSubmitDate;

    @Column(name = "REPORT_FROM_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportFromDate;

    @Column(name = "REPORT_TO_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportToDate;

    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Column(name = "ENTITY_FLG", length = 1)
    private String entityFlg;

    @Column(name = "MODIFY_FLG", length = 1)
    private String modifyFlg;

    @Column(name = "DEL_FLG", length = 1)
    private String delFlg;

    
    
	public Integer getSiNo() {
		return siNo;
	}

	public void setSiNo(Integer siNo) {
		this.siNo = siNo;
	}

	public Date getPortfolioDate() {
		return portfolioDate;
	}

	public void setPortfolioDate(Date portfolioDate) {
		this.portfolioDate = portfolioDate;
	}

	public String getSubmittingInstitution() {
		return submittingInstitution;
	}

	public void setSubmittingInstitution(String submittingInstitution) {
		this.submittingInstitution = submittingInstitution;
	}

	public String getContactEmployee1Name1() {
		return contactEmployee1Name1;
	}

	public void setContactEmployee1Name1(String contactEmployee1Name1) {
		this.contactEmployee1Name1 = contactEmployee1Name1;
	}

	public String getContactEmployee1Title1() {
		return contactEmployee1Title1;
	}

	public void setContactEmployee1Title1(String contactEmployee1Title1) {
		this.contactEmployee1Title1 = contactEmployee1Title1;
	}

	public String getContactEmployee1Email1() {
		return contactEmployee1Email1;
	}

	public void setContactEmployee1Email1(String contactEmployee1Email1) {
		this.contactEmployee1Email1 = contactEmployee1Email1;
	}

	public String getContactEmployee2Name2() {
		return contactEmployee2Name2;
	}

	public void setContactEmployee2Name2(String contactEmployee2Name2) {
		this.contactEmployee2Name2 = contactEmployee2Name2;
	}

	public String getContactEmployee2Title2() {
		return contactEmployee2Title2;
	}

	public void setContactEmployee2Title2(String contactEmployee2Title2) {
		this.contactEmployee2Title2 = contactEmployee2Title2;
	}

	public String getContactEmployee2Email2() {
		return contactEmployee2Email2;
	}

	public void setContactEmployee2Email2(String contactEmployee2Email2) {
		this.contactEmployee2Email2 = contactEmployee2Email2;
	}

	public String getSignOffCroName() {
		return signOffCroName;
	}

	public void setSignOffCroName(String signOffCroName) {
		this.signOffCroName = signOffCroName;
	}

	public String getSignOffCroEmail() {
		return signOffCroEmail;
	}

	public void setSignOffCroEmail(String signOffCroEmail) {
		this.signOffCroEmail = signOffCroEmail;
	}

	public String getSignOffCfoName() {
		return signOffCfoName;
	}

	public void setSignOffCfoName(String signOffCfoName) {
		this.signOffCfoName = signOffCfoName;
	}

	public String getSignOffCfoEmail() {
		return signOffCfoEmail;
	}

	public void setSignOffCfoEmail(String signOffCfoEmail) {
		this.signOffCfoEmail = signOffCfoEmail;
	}

	public String getSignOffHeadOfTreasuryName() {
		return signOffHeadOfTreasuryName;
	}

	public void setSignOffHeadOfTreasuryName(String signOffHeadOfTreasuryName) {
		this.signOffHeadOfTreasuryName = signOffHeadOfTreasuryName;
	}

	public String getSignOffHeadOfTreasuryEmail() {
		return signOffHeadOfTreasuryEmail;
	}

	public void setSignOffHeadOfTreasuryEmail(String signOffHeadOfTreasuryEmail) {
		this.signOffHeadOfTreasuryEmail = signOffHeadOfTreasuryEmail;
	}

	public String getAuditedData() {
		return auditedData;
	}

	public void setAuditedData(String auditedData) {
		this.auditedData = auditedData;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
	}

	public Date getReportFromDate() {
		return reportFromDate;
	}

	public void setReportFromDate(Date reportFromDate) {
		this.reportFromDate = reportFromDate;
	}

	public Date getReportToDate() {
		return reportToDate;
	}

	public void setReportToDate(Date reportToDate) {
		this.reportToDate = reportToDate;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getReport_name() {
		return Report_name;
	}

	public void setReport_name(String report_name) {
		Report_name = report_name;
	}

	

	public RT_DataControl(Date portfolioDate, String submittingInstitution, String contactEmployee1Name1,
			String contactEmployee1Title1, String contactEmployee1Email1, String contactEmployee2Name2,
			String contactEmployee2Title2, String contactEmployee2Email2, String signOffCroName, String signOffCroEmail,
			String signOffCfoName, String signOffCfoEmail, String signOffHeadOfTreasuryName,
			String signOffHeadOfTreasuryEmail, String report_name, String auditedData, Date reportSubmitDate,
			Date reportFromDate, Date reportToDate, Date reportDate, String entityFlg, String modifyFlg,
			String delFlg,Integer siNo ) {
		super();
		this.portfolioDate = portfolioDate;
		this.submittingInstitution = submittingInstitution;
		this.contactEmployee1Name1 = contactEmployee1Name1;
		this.contactEmployee1Title1 = contactEmployee1Title1;
		this.contactEmployee1Email1 = contactEmployee1Email1;
		this.contactEmployee2Name2 = contactEmployee2Name2;
		this.contactEmployee2Title2 = contactEmployee2Title2;
		this.contactEmployee2Email2 = contactEmployee2Email2;
		this.signOffCroName = signOffCroName;
		this.signOffCroEmail = signOffCroEmail;
		this.signOffCfoName = signOffCfoName;
		this.signOffCfoEmail = signOffCfoEmail;
		this.signOffHeadOfTreasuryName = signOffHeadOfTreasuryName;
		this.signOffHeadOfTreasuryEmail = signOffHeadOfTreasuryEmail;
		Report_name = report_name;
		this.auditedData = auditedData;
		this.reportSubmitDate = reportSubmitDate;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportDate = reportDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.siNo=siNo;
	}

	public RT_DataControl() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    // --- Getters and Setters ---

    // Auto-generate or add manually as per your IDE setup
}
