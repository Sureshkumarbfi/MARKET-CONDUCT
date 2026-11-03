package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(KriMasterTable_Id.class)
@Table(name = "KRI_MASTER_TABLE")
public class KriMasterTable {
	
	@Id
	@Column(name = "SN")
    private BigDecimal sn;

    @Column(name = "KRI_NAME")
    private String kriName;

    @Column(name = "KRI_DEFINITION")
    private String kriDefinition;

    @Column(name = "SAS_GCM_KRI_ID")
    private String sasGcmKriId;

    @Column(name = "APPROVAL")
    private String approval;

    @Column(name = "KRI_OWNER_DEPT")
    private String kriOwnerDept;

    @Column(name = "DATA_SOURCE")
    private String dataSource;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "LOWER_THRESHOLD")
    private BigDecimal lowerThreshold;

    @Column(name = "UPPER_THRESHOLD")
    private BigDecimal upperThreshold;

    @Column(name = "YEARLY_VALUE")
    private BigDecimal yearlyValue;

    @Column(name = "DEPT_SIGN")
    private String deptSign;

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
    
    @Column(name = "VERIFY_FLG")
    private String verifyFlg;
    
    
    @Id
    @Column(name = "DEL_FLG")
    private String delFlg;
    
    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

	public BigDecimal getSn() {
		return sn;
	}

	public void setSn(BigDecimal sn) {
		this.sn = sn;
	}

	public String getKriName() {
		return kriName;
	}

	public void setKriName(String kriName) {
		this.kriName = kriName;
	}

	public String getKriDefinition() {
		return kriDefinition;
	}

	public void setKriDefinition(String kriDefinition) {
		this.kriDefinition = kriDefinition;
	}

	public String getSasGcmKriId() {
		return sasGcmKriId;
	}

	public void setSasGcmKriId(String sasGcmKriId) {
		this.sasGcmKriId = sasGcmKriId;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getKriOwnerDept() {
		return kriOwnerDept;
	}

	public void setKriOwnerDept(String kriOwnerDept) {
		this.kriOwnerDept = kriOwnerDept;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BigDecimal getLowerThreshold() {
		return lowerThreshold;
	}

	public void setLowerThreshold(BigDecimal lowerThreshold) {
		this.lowerThreshold = lowerThreshold;
	}

	public BigDecimal getUpperThreshold() {
		return upperThreshold;
	}

	public void setUpperThreshold(BigDecimal upperThreshold) {
		this.upperThreshold = upperThreshold;
	}

	public BigDecimal getYearlyValue() {
		return yearlyValue;
	}

	public void setYearlyValue(BigDecimal yearlyValue) {
		this.yearlyValue = yearlyValue;
	}

	public String getDeptSign() {
		return deptSign;
	}

	public void setDeptSign(String deptSign) {
		this.deptSign = deptSign;
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

	public String getVerifyFlg() {
		return verifyFlg;
	}

	public void setVerifyFlg(String verifyFlg) {
		this.verifyFlg = verifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public KriMasterTable(BigDecimal sn, String kriName, String kriDefinition, String sasGcmKriId, String approval,
			String kriOwnerDept, String dataSource, String frequency, BigDecimal lowerThreshold,
			BigDecimal upperThreshold, BigDecimal yearlyValue, String deptSign, String createUser, Date createTime,
			String modifyUser, Date modifyTime, String verifyUser, Date verifyTime, String entityFlg, String modifyFlg,
			String verifyFlg, String delFlg, Date reportDate) {
		super();
		this.sn = sn;
		this.kriName = kriName;
		this.kriDefinition = kriDefinition;
		this.sasGcmKriId = sasGcmKriId;
		this.approval = approval;
		this.kriOwnerDept = kriOwnerDept;
		this.dataSource = dataSource;
		this.frequency = frequency;
		this.lowerThreshold = lowerThreshold;
		this.upperThreshold = upperThreshold;
		this.yearlyValue = yearlyValue;
		this.deptSign = deptSign;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.verifyFlg = verifyFlg;
		this.delFlg = delFlg;
		this.reportDate = reportDate;
	}

	public KriMasterTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    

}
