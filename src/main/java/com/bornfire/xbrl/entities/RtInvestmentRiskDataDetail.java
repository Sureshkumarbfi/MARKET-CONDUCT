package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_INVESTMENT_RISK_DATA_DETAIL_TABLE")
public class RtInvestmentRiskDataDetail {

	
    @Column(name = "ACID")
    private String acid;

    @Column(name = "CUST_ID")
    private String custId;
    
    @Id
    @Column(name = "FORACID")
    private String foracid;

    @Column(name = "ACT_BALANCE_AMT_LC")
    private BigDecimal actBalanceAmtLc;

    @Column(name = "ACT_BALANCE_AMT_AC")
    private BigDecimal actBalanceAmtAc;

    @Column(name = "ACCT_NAME")
    private String acctName;

    @Column(name = "ACCT_CRNCY_CODE")
    private String acctCrncyCode;

    @Column(name = "GL_CODE")
    private String glCode;

    @Column(name = "GL_SUB_HEAD_CODE")
    private String glSubHeadCode;

    @Column(name = "GL_SUB_HEAD_DESC")
    private String glSubHeadDesc;

    @Column(name = "COUNTRY_OF_INCORP")
    private String countryOfIncorp;

    @Column(name = "CUST_TYPE")
    private String custType;

    @Column(name = "SCHM_CODE")
    private String schmCode;

    @Column(name = "SCHM_TYPE")
    private String schmType;

    @Column(name = "SOL_ID")
    private String solId;

    @Column(name = "SEGMENT")
    private String segment;

    @Column(name = "SUB_SEGMENT")
    private String subSegment;

    @Column(name = "SECTOR")
    private BigDecimal sector;

    @Column(name = "SUB_SECTOR")
    private String subSector;

    @Column(name = "SECTOR_CODE")
    private String sectorCode;

    @Column(name = "GROUP_ID")
    private String groupId;

    @Column(name = "CONSTITUTION_CODE")
    private String constitutionCode;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "LEGAL_ENTITY_TYPE")
    private String legalEntityType;

    @Column(name = "CONSTITUTION_DESC")
    private String constitutionDesc;

    @Column(name = "PURPOSE_OF_ADVN")
    private String purposeOfAdvn;

    @Column(name = "HNI_NETWORTH")
    private BigDecimal hniNetworth;

    @Column(name = "TURNOVER")
    private String turnover;

    @Column(name = "BACID")
    private String bacid;

    @Column(name = "REPORT_NAME_1")
    private String reportName1;

    @Column(name = "REPORT_LABEL_1")
    private String reportLabel1;

    @Column(name = "REPORT_ADDL_CRITERIA_1")
    private String reportAddlCriteria1;

    @Column(name = "REPORT_ADDL_CRITERIA_2")
    private String reportAddlCriteria2;

    @Column(name = "REPORT_ADDL_CRITERIA_3")
    private String reportAddlCriteria3;

    @Column(name = "CREATE_USER")
    private String createUser;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "NRE_STATUS")
    private String nreStatus;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MATURITY_DATE")
    private Date maturityDate;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "NRE_FLG")
    private String nreFlg;

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getForacid() {
		return foracid;
	}

	public void setForacid(String foracid) {
		this.foracid = foracid;
	}

	public BigDecimal getActBalanceAmtLc() {
		return actBalanceAmtLc;
	}

	public void setActBalanceAmtLc(BigDecimal actBalanceAmtLc) {
		this.actBalanceAmtLc = actBalanceAmtLc;
	}

	public BigDecimal getActBalanceAmtAc() {
		return actBalanceAmtAc;
	}

	public void setActBalanceAmtAc(BigDecimal actBalanceAmtAc) {
		this.actBalanceAmtAc = actBalanceAmtAc;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctCrncyCode() {
		return acctCrncyCode;
	}

	public void setAcctCrncyCode(String acctCrncyCode) {
		this.acctCrncyCode = acctCrncyCode;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getGlSubHeadCode() {
		return glSubHeadCode;
	}

	public void setGlSubHeadCode(String glSubHeadCode) {
		this.glSubHeadCode = glSubHeadCode;
	}

	public String getGlSubHeadDesc() {
		return glSubHeadDesc;
	}

	public void setGlSubHeadDesc(String glSubHeadDesc) {
		this.glSubHeadDesc = glSubHeadDesc;
	}

	public String getCountryOfIncorp() {
		return countryOfIncorp;
	}

	public void setCountryOfIncorp(String countryOfIncorp) {
		this.countryOfIncorp = countryOfIncorp;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getSchmCode() {
		return schmCode;
	}

	public void setSchmCode(String schmCode) {
		this.schmCode = schmCode;
	}

	public String getSchmType() {
		return schmType;
	}

	public void setSchmType(String schmType) {
		this.schmType = schmType;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getSubSegment() {
		return subSegment;
	}

	public void setSubSegment(String subSegment) {
		this.subSegment = subSegment;
	}

	public BigDecimal getSector() {
		return sector;
	}

	public void setSector(BigDecimal sector) {
		this.sector = sector;
	}

	public String getSubSector() {
		return subSector;
	}

	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getConstitutionCode() {
		return constitutionCode;
	}

	public void setConstitutionCode(String constitutionCode) {
		this.constitutionCode = constitutionCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLegalEntityType() {
		return legalEntityType;
	}

	public void setLegalEntityType(String legalEntityType) {
		this.legalEntityType = legalEntityType;
	}

	public String getConstitutionDesc() {
		return constitutionDesc;
	}

	public void setConstitutionDesc(String constitutionDesc) {
		this.constitutionDesc = constitutionDesc;
	}

	public String getPurposeOfAdvn() {
		return purposeOfAdvn;
	}

	public void setPurposeOfAdvn(String purposeOfAdvn) {
		this.purposeOfAdvn = purposeOfAdvn;
	}

	public BigDecimal getHniNetworth() {
		return hniNetworth;
	}

	public void setHniNetworth(BigDecimal hniNetworth) {
		this.hniNetworth = hniNetworth;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getBacid() {
		return bacid;
	}

	public void setBacid(String bacid) {
		this.bacid = bacid;
	}

	public String getReportName1() {
		return reportName1;
	}

	public void setReportName1(String reportName1) {
		this.reportName1 = reportName1;
	}

	public String getReportLabel1() {
		return reportLabel1;
	}

	public void setReportLabel1(String reportLabel1) {
		this.reportLabel1 = reportLabel1;
	}

	public String getReportAddlCriteria1() {
		return reportAddlCriteria1;
	}

	public void setReportAddlCriteria1(String reportAddlCriteria1) {
		this.reportAddlCriteria1 = reportAddlCriteria1;
	}

	public String getReportAddlCriteria2() {
		return reportAddlCriteria2;
	}

	public void setReportAddlCriteria2(String reportAddlCriteria2) {
		this.reportAddlCriteria2 = reportAddlCriteria2;
	}

	public String getReportAddlCriteria3() {
		return reportAddlCriteria3;
	}

	public void setReportAddlCriteria3(String reportAddlCriteria3) {
		this.reportAddlCriteria3 = reportAddlCriteria3;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
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

	public String getNreStatus() {
		return nreStatus;
	}

	public void setNreStatus(String nreStatus) {
		this.nreStatus = nreStatus;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getNreFlg() {
		return nreFlg;
	}

	public void setNreFlg(String nreFlg) {
		this.nreFlg = nreFlg;
	}

	public RtInvestmentRiskDataDetail(String acid, String custId, String foracid, BigDecimal actBalanceAmtLc,
			BigDecimal actBalanceAmtAc, String acctName, String acctCrncyCode, String glCode, String glSubHeadCode,
			String glSubHeadDesc, String countryOfIncorp, String custType, String schmCode, String schmType,
			String solId, String segment, String subSegment, BigDecimal sector, String subSector, String sectorCode,
			String groupId, String constitutionCode, String country, String legalEntityType, String constitutionDesc,
			String purposeOfAdvn, BigDecimal hniNetworth, String turnover, String bacid, String reportName1,
			String reportLabel1, String reportAddlCriteria1, String reportAddlCriteria2, String reportAddlCriteria3,
			String createUser, Date createTime, String modifyUser, Date modifyTime, String verifyUser, Date verifyTime,
			String entityFlg, String modifyFlg, String delFlg, String nreStatus, Date reportDate, Date maturityDate,
			String gender, String version, String remarks, String nreFlg) {
		super();
		this.acid = acid;
		this.custId = custId;
		this.foracid = foracid;
		this.actBalanceAmtLc = actBalanceAmtLc;
		this.actBalanceAmtAc = actBalanceAmtAc;
		this.acctName = acctName;
		this.acctCrncyCode = acctCrncyCode;
		this.glCode = glCode;
		this.glSubHeadCode = glSubHeadCode;
		this.glSubHeadDesc = glSubHeadDesc;
		this.countryOfIncorp = countryOfIncorp;
		this.custType = custType;
		this.schmCode = schmCode;
		this.schmType = schmType;
		this.solId = solId;
		this.segment = segment;
		this.subSegment = subSegment;
		this.sector = sector;
		this.subSector = subSector;
		this.sectorCode = sectorCode;
		this.groupId = groupId;
		this.constitutionCode = constitutionCode;
		this.country = country;
		this.legalEntityType = legalEntityType;
		this.constitutionDesc = constitutionDesc;
		this.purposeOfAdvn = purposeOfAdvn;
		this.hniNetworth = hniNetworth;
		this.turnover = turnover;
		this.bacid = bacid;
		this.reportName1 = reportName1;
		this.reportLabel1 = reportLabel1;
		this.reportAddlCriteria1 = reportAddlCriteria1;
		this.reportAddlCriteria2 = reportAddlCriteria2;
		this.reportAddlCriteria3 = reportAddlCriteria3;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.nreStatus = nreStatus;
		this.reportDate = reportDate;
		this.maturityDate = maturityDate;
		this.gender = gender;
		this.version = version;
		this.remarks = remarks;
		this.nreFlg = nreFlg;
	}

	public RtInvestmentRiskDataDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
   
   
	
	
    
}
