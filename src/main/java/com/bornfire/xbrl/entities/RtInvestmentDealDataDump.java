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
@IdClass(mc_invdealreportid.class)
@Table(name = "RT_INVESTMENT_DEAL_DATA_DUMP")
public class RtInvestmentDealDataDump {

    @Id
    @Column(name = "DEAL_ID")
    private String dealId;

    @Column(name = "TYPE_OF_DEAL")
    private String typeOfDeal;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "OPTION_TYPE")
    private String optionType;

    @Column(name = "TYPE_OF_EVENT")
    private String typeOfEvent;

    @Column(name = "BLK_NO")
    private BigDecimal blkNo;

    @Column(name = "AMOUNT1")
    private BigDecimal amount1;

    @Column(name = "AMOUNT2")
    private BigDecimal amount2;

    @Column(name = "RATE_PRICE")
    private BigDecimal ratePrice;

    @Column(name = "STRIKE")
    private BigDecimal strike;

    @Column(name = "CL_RATE")
    private BigDecimal clRate;

    @Column(name = "CL_MARGIN")
    private BigDecimal clMargin;

    @Column(name = "SECURITY")
    private String security;

    @Column(name = "SECURITY_NAME")
    private String securityName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "TRADE_DATE")
    private Date tradeDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "VALUE_DATE")
    private Date valueDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MAT_DATE")
    private Date matDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "LIQUIDATION_DATE")
    private Date liquidationDate;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    @Column(name = "BROKER")
    private String broker;

    @Column(name = "CPTY")
    private String cpty;

    @Column(name = "CPTY_NAME")
    private String cptyName;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "LAST_USER")
    private String lastUser;

    @Column(name = "FOLDER")
    private String folder;

    @Column(name = "COMMENTS")
    private String comments;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "LAST_DATE")
    private Date lastDate;

    @Column(name = "DOWNLOAD_KEY")
    private String downloadKey;

    @Column(name = "CAPTURE_TIMESTAMP")
    private String captureTimestamp;

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

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "BRANCH_CODE")
    private String branchCode;

    @Column(name = "BRANCH_NAME")
    private String branchName;

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getTypeOfDeal() {
		return typeOfDeal;
	}

	public void setTypeOfDeal(String typeOfDeal) {
		this.typeOfDeal = typeOfDeal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getTypeOfEvent() {
		return typeOfEvent;
	}

	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}

	public BigDecimal getBlkNo() {
		return blkNo;
	}

	public void setBlkNo(BigDecimal BigDecimal) {
		this.blkNo = BigDecimal;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAmount2() {
		return amount2;
	}

	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}

	public BigDecimal getRatePrice() {
		return ratePrice;
	}

	public void setRatePrice(BigDecimal ratePrice) {
		this.ratePrice = ratePrice;
	}

	public BigDecimal getStrike() {
		return strike;
	}

	public void setStrike(BigDecimal strike) {
		this.strike = strike;
	}

	public BigDecimal getClRate() {
		return clRate;
	}

	public void setClRate(BigDecimal clRate) {
		this.clRate = clRate;
	}

	public BigDecimal getClMargin() {
		return clMargin;
	}

	public void setClMargin(BigDecimal clMargin) {
		this.clMargin = clMargin;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Date getMatDate() {
		return matDate;
	}

	public void setMatDate(Date matDate) {
		this.matDate = matDate;
	}

	public Date getLiquidationDate() {
		return liquidationDate;
	}

	public void setLiquidationDate(Date liquidationDate) {
		this.liquidationDate = liquidationDate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getCpty() {
		return cpty;
	}

	public void setCpty(String cpty) {
		this.cpty = cpty;
	}

	public String getCptyName() {
		return cptyName;
	}

	public void setCptyName(String cptyName) {
		this.cptyName = cptyName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLastUser() {
		return lastUser;
	}

	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getDownloadKey() {
		return downloadKey;
	}

	public void setDownloadKey(String downloadKey) {
		this.downloadKey = downloadKey;
	}

	public String getCaptureTimestamp() {
		return captureTimestamp;
	}

	public void setCaptureTimestamp(String captureTimestamp) {
		this.captureTimestamp = captureTimestamp;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public RtInvestmentDealDataDump(String dealId, String typeOfDeal, String type, String optionType,
			String typeOfEvent, BigDecimal blkNo, BigDecimal amount1, BigDecimal amount2, BigDecimal ratePrice, BigDecimal strike,
			BigDecimal clRate, BigDecimal clMargin, String security, String securityName, Date tradeDate, Date valueDate,
			Date matDate, Date liquidationDate, BigDecimal quantity, String broker, String cpty, String cptyName,
			String userId, String lastUser, String folder, String comments, Date lastDate, String downloadKey,
			String captureTimestamp, String createUser, Date createTime, String modifyUser, Date modifyTime,
			String verifyUser, Date verifyTime, String entityFlg, String modifyFlg, Date reportDate, String branchCode,
			String branchName) {
		super();
		this.dealId = dealId;
		this.typeOfDeal = typeOfDeal;
		this.type = type;
		this.optionType = optionType;
		this.typeOfEvent = typeOfEvent;
		this.blkNo = blkNo;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.ratePrice = ratePrice;
		this.strike = strike;
		this.clRate = clRate;
		this.clMargin = clMargin;
		this.security = security;
		this.securityName = securityName;
		this.tradeDate = tradeDate;
		this.valueDate = valueDate;
		this.matDate = matDate;
		this.liquidationDate = liquidationDate;
		this.quantity = quantity;
		this.broker = broker;
		this.cpty = cpty;
		this.cptyName = cptyName;
		this.userId = userId;
		this.lastUser = lastUser;
		this.folder = folder;
		this.comments = comments;
		this.lastDate = lastDate;
		this.downloadKey = downloadKey;
		this.captureTimestamp = captureTimestamp;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.reportDate = reportDate;
		this.branchCode = branchCode;
		this.branchName = branchName;
	}

	public RtInvestmentDealDataDump() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
