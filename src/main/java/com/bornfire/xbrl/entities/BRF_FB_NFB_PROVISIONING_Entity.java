package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(BRF_FB_NFB_PROVISIONING_id.class)
@Table(name = "BRF_FB_NFB_PROVISIONING_TABLE")
public class BRF_FB_NFB_PROVISIONING_Entity {
	
	    @Id
	    @Column(name = "FORACID") 
	    private String foracid;

	    @Column(name = "SOL_ID")
	    private String solId;

	    @Column(name = "CUST_ID")
	    private String custId;

	    @Column(name = "ACCT_NAME")
	    private String acctName;

	    @Column(name = "ASSET_CLASS")
	    private String assetClass;

	    @Column(name = "CLASS_NEW")
	    private String classNew;

	    @Column(name = "OS_AMT")
	    private BigDecimal osAmt;

	    @Column(name = "ACCOUNT_CRNCY")
	    private String accountCrncy;

	    @Column(name = "DEDUCTION_AMT")
	    private BigDecimal deductionAmt;

	    @Column(name = "INT_SUSP_AMT")
	    private BigDecimal intSuspAmt;

	    @Column(name = "NET_OS_AMT")
	    private BigDecimal netOsAmt;

	    @Column(name = "ALLOC_SEC_AMT")
	    private BigDecimal allocSecAmt;

	    @Column(name = "SEC_AMT")
	    private BigDecimal secAmt;

	    @Column(name = "UNSEC_AMT")
	    private BigDecimal unsecAmt;

	    @Column(name = "HOME_SEC_PROV")
	    private BigDecimal homeSecProv;

	    @Column(name = "HOME_UNSEC_PROV")
	    private BigDecimal homeUnsecProv;

	    @Column(name = "HOME_TOT_PROV")
	    private BigDecimal homeTotProv;

	    @Column(name = "COLLACC_DISC")
	    private BigDecimal collaccDisc;

	    @Column(name = "NET_EXPOSURE")
	    private BigDecimal netExposure;

	    @Column(name = "HOST_PROV")
	    private BigDecimal hostProv;

	    @Column(name = "HOST_PROV_OLD")
	    private BigDecimal hostProvOld;

	    @Column(name = "HOST_PROV_NEW")
	    private BigDecimal hostProvNew;

	    @Column(name = "STRINGENT_PROV")
	    private BigDecimal stringentProv;

	    @Column(name = "ADD_PROV")
	    private BigDecimal addProv;

	    @Column(name = "TOTAL_PROV")
	    private BigDecimal totalProv;

	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "NPA_DATE")
	    private Date npaDate;

	    @Id
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(name = "LST_EXEDATE")
	    private Date lstExeDate;

	    @Column(name = "DEL_FLG")
	    private String delFlg;

	    @Column(name = "ORIG_VAL_BG_AMT")
	    private BigDecimal origValBgAmt;

	    @Column(name = "DC_BILL_UTIL_AMT")
	    private BigDecimal dcBillUtilAmt;

	    @Column(name = "CONT_LIAB_AMT")
	    private BigDecimal contLiabAmt;

		public String getForacid() {
			return foracid;
		}

		public void setForacid(String foracid) {
			this.foracid = foracid;
		}

		public String getSolId() {
			return solId;
		}

		public void setSolId(String solId) {
			this.solId = solId;
		}

		public String getCustId() {
			return custId;
		}

		public void setCustId(String custId) {
			this.custId = custId;
		}

		public String getAcctName() {
			return acctName;
		}

		public void setAcctName(String acctName) {
			this.acctName = acctName;
		}

		public String getAssetClass() {
			return assetClass;
		}

		public void setAssetClass(String assetClass) {
			this.assetClass = assetClass;
		}

		public String getClassNew() {
			return classNew;
		}

		public void setClassNew(String classNew) {
			this.classNew = classNew;
		}

		public BigDecimal getOsAmt() {
			return osAmt;
		}

		public void setOsAmt(BigDecimal osAmt) {
			this.osAmt = osAmt;
		}

		public String getAccountCrncy() {
			return accountCrncy;
		}

		public void setAccountCrncy(String accountCrncy) {
			this.accountCrncy = accountCrncy;
		}

		public BigDecimal getDeductionAmt() {
			return deductionAmt;
		}

		public void setDeductionAmt(BigDecimal deductionAmt) {
			this.deductionAmt = deductionAmt;
		}

		public BigDecimal getIntSuspAmt() {
			return intSuspAmt;
		}

		public void setIntSuspAmt(BigDecimal intSuspAmt) {
			this.intSuspAmt = intSuspAmt;
		}

		public BigDecimal getNetOsAmt() {
			return netOsAmt;
		}

		public void setNetOsAmt(BigDecimal netOsAmt) {
			this.netOsAmt = netOsAmt;
		}

		public BigDecimal getAllocSecAmt() {
			return allocSecAmt;
		}

		public void setAllocSecAmt(BigDecimal allocSecAmt) {
			this.allocSecAmt = allocSecAmt;
		}

		public BigDecimal getSecAmt() {
			return secAmt;
		}

		public void setSecAmt(BigDecimal secAmt) {
			this.secAmt = secAmt;
		}

		public BigDecimal getUnsecAmt() {
			return unsecAmt;
		}

		public void setUnsecAmt(BigDecimal unsecAmt) {
			this.unsecAmt = unsecAmt;
		}

		public BigDecimal getHomeSecProv() {
			return homeSecProv;
		}

		public void setHomeSecProv(BigDecimal homeSecProv) {
			this.homeSecProv = homeSecProv;
		}

		public BigDecimal getHomeUnsecProv() {
			return homeUnsecProv;
		}

		public void setHomeUnsecProv(BigDecimal homeUnsecProv) {
			this.homeUnsecProv = homeUnsecProv;
		}

		public BigDecimal getHomeTotProv() {
			return homeTotProv;
		}

		public void setHomeTotProv(BigDecimal homeTotProv) {
			this.homeTotProv = homeTotProv;
		}

		public BigDecimal getCollaccDisc() {
			return collaccDisc;
		}

		public void setCollaccDisc(BigDecimal collaccDisc) {
			this.collaccDisc = collaccDisc;
		}

		public BigDecimal getNetExposure() {
			return netExposure;
		}

		public void setNetExposure(BigDecimal netExposure) {
			this.netExposure = netExposure;
		}

		public BigDecimal getHostProv() {
			return hostProv;
		}

		public void setHostProv(BigDecimal hostProv) {
			this.hostProv = hostProv;
		}

		public BigDecimal getHostProvOld() {
			return hostProvOld;
		}

		public void setHostProvOld(BigDecimal hostProvOld) {
			this.hostProvOld = hostProvOld;
		}

		public BigDecimal getHostProvNew() {
			return hostProvNew;
		}

		public void setHostProvNew(BigDecimal hostProvNew) {
			this.hostProvNew = hostProvNew;
		}

		public BigDecimal getStringentProv() {
			return stringentProv;
		}

		public void setStringentProv(BigDecimal stringentProv) {
			this.stringentProv = stringentProv;
		}

		public BigDecimal getAddProv() {
			return addProv;
		}

		public void setAddProv(BigDecimal addProv) {
			this.addProv = addProv;
		}

		public BigDecimal getTotalProv() {
			return totalProv;
		}

		public void setTotalProv(BigDecimal totalProv) {
			this.totalProv = totalProv;
		}

		public Date getNpaDate() {
			return npaDate;
		}

		public void setNpaDate(Date npaDate) {
			this.npaDate = npaDate;
		}

		public Date getLstExeDate() {
			return lstExeDate;
		}

		public void setLstExeDate(Date lstExeDate) {
			this.lstExeDate = lstExeDate;
		}

		public String getDelFlg() {
			return delFlg;
		}

		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}

		public BigDecimal getOrigValBgAmt() {
			return origValBgAmt;
		}

		public void setOrigValBgAmt(BigDecimal origValBgAmt) {
			this.origValBgAmt = origValBgAmt;
		}

		public BigDecimal getDcBillUtilAmt() {
			return dcBillUtilAmt;
		}

		public void setDcBillUtilAmt(BigDecimal dcBillUtilAmt) {
			this.dcBillUtilAmt = dcBillUtilAmt;
		}

		public BigDecimal getContLiabAmt() {
			return contLiabAmt;
		}

		public void setContLiabAmt(BigDecimal contLiabAmt) {
			this.contLiabAmt = contLiabAmt;
		}

		public BRF_FB_NFB_PROVISIONING_Entity(String foracid, String solId, String custId, String acctName,
				String assetClass, String classNew, BigDecimal osAmt, String accountCrncy, BigDecimal deductionAmt,
				BigDecimal intSuspAmt, BigDecimal netOsAmt, BigDecimal allocSecAmt, BigDecimal secAmt,
				BigDecimal unsecAmt, BigDecimal homeSecProv, BigDecimal homeUnsecProv, BigDecimal homeTotProv,
				BigDecimal collaccDisc, BigDecimal netExposure, BigDecimal hostProv, BigDecimal hostProvOld,
				BigDecimal hostProvNew, BigDecimal stringentProv, BigDecimal addProv, BigDecimal totalProv,
				Date npaDate, Date lstExeDate, String delFlg, BigDecimal origValBgAmt, BigDecimal dcBillUtilAmt,
				BigDecimal contLiabAmt) {
			super();
			this.foracid = foracid;
			this.solId = solId;
			this.custId = custId;
			this.acctName = acctName;
			this.assetClass = assetClass;
			this.classNew = classNew;
			this.osAmt = osAmt;
			this.accountCrncy = accountCrncy;
			this.deductionAmt = deductionAmt;
			this.intSuspAmt = intSuspAmt;
			this.netOsAmt = netOsAmt;
			this.allocSecAmt = allocSecAmt;
			this.secAmt = secAmt;
			this.unsecAmt = unsecAmt;
			this.homeSecProv = homeSecProv;
			this.homeUnsecProv = homeUnsecProv;
			this.homeTotProv = homeTotProv;
			this.collaccDisc = collaccDisc;
			this.netExposure = netExposure;
			this.hostProv = hostProv;
			this.hostProvOld = hostProvOld;
			this.hostProvNew = hostProvNew;
			this.stringentProv = stringentProv;
			this.addProv = addProv;
			this.totalProv = totalProv;
			this.npaDate = npaDate;
			this.lstExeDate = lstExeDate;
			this.delFlg = delFlg;
			this.origValBgAmt = origValBgAmt;
			this.dcBillUtilAmt = dcBillUtilAmt;
			this.contLiabAmt = contLiabAmt;
		}

		public BRF_FB_NFB_PROVISIONING_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}

	    


}
