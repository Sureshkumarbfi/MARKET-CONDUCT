package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(RT_Nostro_IdClass.class)
@Table(name = "BCBUAE_NOSTRO_ACC_BAL_DATA")
public class RT_NostroAccBalData {

	@Id
	@Column(name = "ACCOUNT_NO")
	private String accountNo;

	@Column(name = "DATA_DATE")
	@Temporal(TemporalType.DATE)
	private Date dataDate;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "HEAD_OFFICE_SUBSIDIARY")
	private String headOfficeSubsidiary;

	@Column(name = "SUBSIDIARY")
	private String subsidiary;

	@Column(name = "BANK_SYMBOL")
	private String bankSymbol;

	@Column(name = "CONVENTIONAL_ISLAMIC")
	private String conventionalIslamic;

	@Column(name = "LOCAL_FOREIGN")
	private String localForeign;

	@Column(name = "CBUAE_TIERING")
	private String cbuaeTiering;

	@Column(name = "COUNTERPARTY_NOSTRO_ACCOUNT")
	private String counterpartyNostroAccount;

	@Column(name = "FINAL_RATING_BANKS")
	private String finalRatingBanks;

	@Column(name = "FINAL_RATING_CBUAE")
	private String finalRatingCbuae;

	@Column(name = "COUNTRY_OF_RISK")
	private String countryOfRisk;

	@Column(name = "CBUAE_GEOGRAPHICAL_ZONE")
	private String cbuaeGeographicalZone;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "COUNTERPARTY_SETTLEMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date counterpartySettlementDate;

	@Column(name = "COUNTERPARTY_BALANCE")
	private BigDecimal counterpartyBalance;

	@Column(name = "COUNTERPARTY_BALANCE_AED")
	private BigDecimal counterpartyBalanceAed;

	@Column(name = "BANK_INTERNAL_SETTLEMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date bankInternalSettlementDate;

	@Column(name = "BANK_BALANCE")
	private BigDecimal bankBalance;

	@Column(name = "BANK_BALANCE_AED")
	private BigDecimal bankBalanceAed;

	@Column(name = "GAP")
	private BigDecimal gap;

	@Column(name = "REPORT_SUBMIT_DATE")
	@Temporal(TemporalType.DATE)
	private Date reportSubmitDate;

	@Id
	@Column(name = "REPORT_DATE")
	@Temporal(TemporalType.DATE)
	private Date reportDate;

	@Column(name = "ENTITY_FLG")
	private String entityFlg;

	@Column(name = "MODIFY_FLG")
	private String modifyFlg;

	@Column(name = "DEL_FLG")
	private String delFlg;

	@Column(name = "REPORT_FROM_DATE")
	@Temporal(TemporalType.DATE)
	private Date reportFromDate;

	@Column(name = "REPORT_TO_DATE")
	@Temporal(TemporalType.DATE)
	private Date reportToDate;

	 @Column(name = "REPORT_CODE", length = 10)
	    private String reportCode;

	   
	    @Column(name = "ENTRY_USER", length = 20)
	    private String entryUser;

	    @Column(name = "MODIFY_USER", length = 20)
	    private String modifyUser;

	    @Column(name = "VERIFY_USER", length = 20)
	    private String verifyUser;

	    @Column(name = "ENTRY_TIME")
	    private Date entryTime;

	    @Column(name = "MODIFY_TIME")
	    private Date modifyTime;
	    
	    
	public String getAccountNo() {
		return accountNo;
	}

	public Date getDataDate() {
		return dataDate;
	}

	public String getBankName() {
		return bankName;
	}

	public String getHeadOfficeSubsidiary() {
		return headOfficeSubsidiary;
	}

	public String getSubsidiary() {
		return subsidiary;
	}

	public String getBankSymbol() {
		return bankSymbol;
	}

	public String getConventionalIslamic() {
		return conventionalIslamic;
	}

	public String getLocalForeign() {
		return localForeign;
	}

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public String getCounterpartyNostroAccount() {
		return counterpartyNostroAccount;
	}

	public String getFinalRatingBanks() {
		return finalRatingBanks;
	}

	public String getFinalRatingCbuae() {
		return finalRatingCbuae;
	}

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public String getCbuaeGeographicalZone() {
		return cbuaeGeographicalZone;
	}

	public String getCurrency() {
		return currency;
	}

	public Date getCounterpartySettlementDate() {
		return counterpartySettlementDate;
	}

	public BigDecimal getCounterpartyBalance() {
		return counterpartyBalance;
	}

	public BigDecimal getCounterpartyBalanceAed() {
		return counterpartyBalanceAed;
	}

	public Date getBankInternalSettlementDate() {
		return bankInternalSettlementDate;
	}

	public BigDecimal getBankBalance() {
		return bankBalance;
	}

	public BigDecimal getBankBalanceAed() {
		return bankBalanceAed;
	}

	public BigDecimal getGap() {
		return gap;
	}

	public Date getReportSubmitDate() {
		return reportSubmitDate;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	
	public String getDelFlg() {
		return delFlg;
	}

	public Date getReportFromDate() {
		return reportFromDate;
	}

	public Date getReportToDate() {
		return reportToDate;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setHeadOfficeSubsidiary(String headOfficeSubsidiary) {
		this.headOfficeSubsidiary = headOfficeSubsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	public void setBankSymbol(String bankSymbol) {
		this.bankSymbol = bankSymbol;
	}

	public void setConventionalIslamic(String conventionalIslamic) {
		this.conventionalIslamic = conventionalIslamic;
	}

	public void setLocalForeign(String localForeign) {
		this.localForeign = localForeign;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

	public void setCounterpartyNostroAccount(String counterpartyNostroAccount) {
		this.counterpartyNostroAccount = counterpartyNostroAccount;
	}

	public void setFinalRatingBanks(String finalRatingBanks) {
		this.finalRatingBanks = finalRatingBanks;
	}

	public void setFinalRatingCbuae(String finalRatingCbuae) {
		this.finalRatingCbuae = finalRatingCbuae;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public void setCbuaeGeographicalZone(String cbuaeGeographicalZone) {
		this.cbuaeGeographicalZone = cbuaeGeographicalZone;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCounterpartySettlementDate(Date counterpartySettlementDate) {
		this.counterpartySettlementDate = counterpartySettlementDate;
	}

	public void setCounterpartyBalance(BigDecimal counterpartyBalance) {
		this.counterpartyBalance = counterpartyBalance;
	}

	public void setCounterpartyBalanceAed(BigDecimal counterpartyBalanceAed) {
		this.counterpartyBalanceAed = counterpartyBalanceAed;
	}

	public void setBankInternalSettlementDate(Date bankInternalSettlementDate) {
		this.bankInternalSettlementDate = bankInternalSettlementDate;
	}

	public void setBankBalance(BigDecimal bankBalance) {
		this.bankBalance = bankBalance;
	}

	public void setBankBalanceAed(BigDecimal bankBalanceAed) {
		this.bankBalanceAed = bankBalanceAed;
	}

	public void setGap(BigDecimal gap) {
		this.gap = gap;
	}

	public void setReportSubmitDate(Date reportSubmitDate) {
		this.reportSubmitDate = reportSubmitDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public void setReportFromDate(Date reportFromDate) {
		this.reportFromDate = reportFromDate;
	}

	public void setReportToDate(Date reportToDate) {
		this.reportToDate = reportToDate;
	}
	

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "NostroAccBalData [accountNo=" + accountNo + ", dataDate=" + dataDate + ", bankName=" + bankName
				+ ", headOfficeSubsidiary=" + headOfficeSubsidiary + ", subsidiary=" + subsidiary + ", bankSymbol="
				+ bankSymbol + ", conventionalIslamic=" + conventionalIslamic + ", localForeign=" + localForeign
				+ ", cbuaeTiering=" + cbuaeTiering + ", counterpartyNostroAccount=" + counterpartyNostroAccount
				+ ", finalRatingBanks=" + finalRatingBanks + ", finalRatingCbuae=" + finalRatingCbuae
				+ ", countryOfRisk=" + countryOfRisk + ", cbuaeGeographicalZone=" + cbuaeGeographicalZone
				+ ", currency=" + currency + ", counterpartySettlementDate=" + counterpartySettlementDate
				+ ", counterpartyBalance=" + counterpartyBalance + ", counterpartyBalanceAed=" + counterpartyBalanceAed
				+ ", bankInternalSettlementDate=" + bankInternalSettlementDate + ", bankBalance=" + bankBalance
				+ ", bankBalanceAed=" + bankBalanceAed + ", gap=" + gap + ", reportSubmitDate=" + reportSubmitDate
				+ ", reportDate=" + reportDate + ", entityFlg=" + entityFlg + ", modifyFlg=" + modifyFlg + ", delFlg="
				+ delFlg + ", reportFromDate=" + reportFromDate + ", reportToDate=" + reportToDate + "]";
	}

	
	public RT_NostroAccBalData(String accountNo, Date dataDate, String bankName, String headOfficeSubsidiary,
			String subsidiary, String bankSymbol, String conventionalIslamic, String localForeign, String cbuaeTiering,
			String counterpartyNostroAccount, String finalRatingBanks, String finalRatingCbuae, String countryOfRisk,
			String cbuaeGeographicalZone, String currency, Date counterpartySettlementDate,
			BigDecimal counterpartyBalance, BigDecimal counterpartyBalanceAed, Date bankInternalSettlementDate,
			BigDecimal bankBalance, BigDecimal bankBalanceAed, BigDecimal gap, Date reportSubmitDate, Date reportDate,
			String entityFlg, String modifyFlg, String delFlg, Date reportFromDate, Date reportToDate,
			String reportCode, String entryUser, String modifyUser, String verifyUser, Date entryTime,
			Date modifyTime) {
		super();
		this.accountNo = accountNo;
		this.dataDate = dataDate;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.subsidiary = subsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.counterpartyNostroAccount = counterpartyNostroAccount;
		this.finalRatingBanks = finalRatingBanks;
		this.finalRatingCbuae = finalRatingCbuae;
		this.countryOfRisk = countryOfRisk;
		this.cbuaeGeographicalZone = cbuaeGeographicalZone;
		this.currency = currency;
		this.counterpartySettlementDate = counterpartySettlementDate;
		this.counterpartyBalance = counterpartyBalance;
		this.counterpartyBalanceAed = counterpartyBalanceAed;
		this.bankInternalSettlementDate = bankInternalSettlementDate;
		this.bankBalance = bankBalance;
		this.bankBalanceAed = bankBalanceAed;
		this.gap = gap;
		this.reportSubmitDate = reportSubmitDate;
		this.reportDate = reportDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportCode = reportCode;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
	}

	public RT_NostroAccBalData() {
		super();
		// TODO Auto-generated constructor stub
	}

}
