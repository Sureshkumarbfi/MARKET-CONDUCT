package com.bornfire.xbrl.entities;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RT_IRS_DETAILTABLE")
public class RT_IRS_DETAIL_ENTITY {

	    @Id
	    @Column(name = "CUST_ID")
	    private String custId;

	    @Column(name = "FORACID")
	    private String foracid;

	    @Column(name = "ACCT_NAME")
	    private String acctName;

	    @Column(name = "EAB_LC")
	    private BigDecimal eabLc;

	    @Column(name = "ACCT_BALANCE_LC")
	    private BigDecimal acctBalanceLc;

	    @Column(name = "ACCT_BALANCE_AC")
	    private BigDecimal acctBalanceAc;

	    @Column(name = "ACCT_CRNCY_CODE")
	    private String acctCrncyCode;

	    @Column(name = "GL_CODE")
	    private String glCode;

	    @Column(name = "GLSH_CODE")
	    private String glshCode;

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

	    @Column(name = "ACID")
	    private String acid;

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

	    @Column(name = "REPORT_LABEL_NAME")
	    private String reportLabelName;

	    @Column(name = "REPORT_LABEL")
	    private String reportLabel;

	    @Column(name = "REPORT_ADDL_CRITERIA_1")
	    private String reportAddlCriteria1;

	    @Column(name = "REPORT_ADDL_CRITERIA_2")
	    private String reportAddlCriteria2;

	    @Column(name = "REPORT_ADDL_CRITERIA_3")
	    private String reportAddlCriteria3;

	    @Column(name = "CREATE_USER")
	    private String createUser;
	    
	    @Column(name = "CREATE_TIME")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date createTime;

	    @Column(name = "MODIFY_USER")
	    private String modifyUser;
	    
	    @Column(name = "MODIFY_TIME")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date modifyTime;
	    

	    @Column(name = "VERIFY_USER")
	    private String verifyUser;
	    
	    @Column(name = "VERIFY_TIME")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date verifyTime;

	    @Column(name = "ENTITY_FLG")
	    private String entityFlg;

	    @Column(name = "MODIFY_FLG")
	    private String modifyFlg;

	    @Column(name = "DEL_FLG")
	    private String delFlg;

	    @Column(name = "NRE_STATUS")
	    private String nreStatus;

	    @Column(name = "REPORT_DATE")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date reportDate;
	    
	    @Column(name = "MATURITY_DATE")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date maturityDate;

	    @Column(name = "VERSION")
	    private String version;

	    @Column(name = "REMARKS")
	    private String remarks;
	    
	    @Column(name = "TD_VALUE_DATE")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date tdValueDate;

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

		public String getAcctName() {
			return acctName;
		}

		public void setAcctName(String acctName) {
			this.acctName = acctName;
		}

		public BigDecimal getEabLc() {
			return eabLc;
		}

		public void setEabLc(BigDecimal eabLc) {
			this.eabLc = eabLc;
		}

		public BigDecimal getAcctBalanceLc() {
			return acctBalanceLc;
		}

		public void setAcctBalanceLc(BigDecimal acctBalanceLc) {
			this.acctBalanceLc = acctBalanceLc;
		}

		public BigDecimal getAcctBalanceAc() {
			return acctBalanceAc;
		}

		public void setAcctBalanceAc(BigDecimal acctBalanceAc) {
			this.acctBalanceAc = acctBalanceAc;
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

		public String getGlshCode() {
			return glshCode;
		}

		public void setGlshCode(String glshCode) {
			this.glshCode = glshCode;
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

		public String getAcid() {
			return acid;
		}

		public void setAcid(String acid) {
			this.acid = acid;
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

		public String getReportLabelName() {
			return reportLabelName;
		}

		public void setReportLabelName(String reportLabelName) {
			this.reportLabelName = reportLabelName;
		}

		public String getReportLabel() {
			return reportLabel;
		}

		public void setReportLabel(String reportLabel) {
			this.reportLabel = reportLabel;
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

		public Date getTdValueDate() {
			return tdValueDate;
		}

		public void setTdValueDate(Date tdValueDate) {
			this.tdValueDate = tdValueDate;
		}

		public RT_IRS_DETAIL_ENTITY() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

	 
	
}
