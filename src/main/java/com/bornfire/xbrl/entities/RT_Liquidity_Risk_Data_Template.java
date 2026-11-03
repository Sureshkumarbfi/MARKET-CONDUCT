package com.bornfire.xbrl.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@IdClass(RT_Liquidity_Risk_Data_Template_class.class)
@Entity 
@Table(name = "BCBUAE_LIQUIDITY_RISK_DATA_TEMPLATE")
public class RT_Liquidity_Risk_Data_Template {

    
    @Column(name = "SL_NO")
    private BigDecimal slno;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "DATA_DATE")
    private Date dataDate;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "HEAD_OFFICE_SUBSIDIARY")
    private String headOfficeSubsidiary;

    @Column(name = "BANK_SYMBOL")
    private String bankSymbol;

    @Column(name = "CONVENTIONAL_ISLAMIC")
    private String conventionalIslamic;

    @Column(name = "LOCAL_FOREIGN")
    private String localForeign;

    @Column(name = "CBUAE_TIERING")
    private String cbuaeTiering;

    @Id
    @Column(name = "GL_LEVEL_1")
    private String glLevel1;

    @Id
    @Column(name = "GL_LEVEL_2")
    private String glLevel2;

    @Id
    @Column(name = "GL_LEVEL_3")
    private String glLevel3;

    @Id
    @Column(name = "OPTION_TYPE")
    private String optionType;

    @Id
    @Column(name = "RATE_TYPE")
    private String rateType;

    @Id
    @Column(name = "REFERENCE_RATE")
    private String referenceRate;
    
    @Id
    @Column(name = "INSTRUMENT_CURRENCY")
    private String instrumentCurrency;

    @Column(name = "OUTSTANDING_BALANCE")
    private BigDecimal outstandingBalance;

    @Column(name = "OVERNIGHT")
    private BigDecimal overnight;

    @Column(name = "ON_TO_1M")
    private BigDecimal onTo1m;

    @Column(name = "ONE_M_TO_3M")
    private BigDecimal oneMTo3m;

    @Column(name = "THREE_M_TO_6M")
    private BigDecimal threeMTo6m;

    @Column(name = "SIX_M_TO_9M")
    private BigDecimal sixMTo9m;

    @Column(name = "NINE_M_TO_1Y")
    private BigDecimal nineMTo1y;

    @Column(name = "ONE_Y_TO_1_5Y")
    private BigDecimal oneYTo1_5y;

    @Column(name = "ONE_5Y_TO_2Y")
    private BigDecimal one5yTo2y;

    @Column(name = "TWO_Y_TO_3Y")
    private BigDecimal twoYTo3y;

    @Column(name = "THREE_Y_TO_4Y")
    private BigDecimal threeYTo4y;

    @Column(name = "FOUR_Y_TO_5Y")
    private BigDecimal fourYTo5y;

    @Column(name = "FIVE_Y_TO_6Y")
    private BigDecimal fiveYTo6y;

    @Column(name = "SIX_Y_TO_7Y")
    private BigDecimal sixYTo7y;

    @Column(name = "SEVEN_Y_TO_8Y")
    private BigDecimal sevenYTo8y;

    @Column(name = "EIGHT_Y_TO_9Y")
    private BigDecimal eightYTo9y;

    @Column(name = "NINE_Y_TO_10Y")
    private BigDecimal nineYTo10y;

    @Column(name = "TEN_Y_TO_15Y")
    private BigDecimal tenYTo15y;

    @Column(name = "FIFTEEN_Y_TO_20Y")
    private BigDecimal fifteenYTo20y;

    @Column(name = "TWENTY_Y_ABOVE")
    private BigDecimal twentyYAbove;

    @Column(name = "NON_MATURING")
    private BigDecimal nonMaturing;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_SUBMIT_DATE")
    private Date reportSubmitDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_FROM_DATE")
    private Date reportFromDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_TO_DATE")
    private Date reportToDate;

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "REPORT_CODE")
    private String reportCode;

    @Column(name = "ENTRY_USER")
    private String entryUser;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

	public BigDecimal getSlno() {
		return slno;
	}

	public void setSlno(BigDecimal slno) {
		this.slno = slno;
	}

	public Date getDataDate() {
		return dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getHeadOfficeSubsidiary() {
		return headOfficeSubsidiary;
	}

	public void setHeadOfficeSubsidiary(String headOfficeSubsidiary) {
		this.headOfficeSubsidiary = headOfficeSubsidiary;
	}

	public String getBankSymbol() {
		return bankSymbol;
	}

	public void setBankSymbol(String bankSymbol) {
		this.bankSymbol = bankSymbol;
	}

	public String getConventionalIslamic() {
		return conventionalIslamic;
	}

	public void setConventionalIslamic(String conventionalIslamic) {
		this.conventionalIslamic = conventionalIslamic;
	}

	public String getLocalForeign() {
		return localForeign;
	}

	public void setLocalForeign(String localForeign) {
		this.localForeign = localForeign;
	}

	public String getCbuaeTiering() {
		return cbuaeTiering;
	}

	public void setCbuaeTiering(String cbuaeTiering) {
		this.cbuaeTiering = cbuaeTiering;
	}

	public String getGlLevel1() {
		return glLevel1;
	}

	public void setGlLevel1(String glLevel1) {
		this.glLevel1 = glLevel1;
	}

	public String getGlLevel2() {
		return glLevel2;
	}

	public void setGlLevel2(String glLevel2) {
		this.glLevel2 = glLevel2;
	}

	public String getGlLevel3() {
		return glLevel3;
	}

	public void setGlLevel3(String glLevel3) {
		this.glLevel3 = glLevel3;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getReferenceRate() {
		return referenceRate;
	}

	public void setReferenceRate(String referenceRate) {
		this.referenceRate = referenceRate;
	}

	public String getInstrumentCurrency() {
		return instrumentCurrency;
	}

	public void setInstrumentCurrency(String instrumentCurrency) {
		this.instrumentCurrency = instrumentCurrency;
	}

	public BigDecimal getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(BigDecimal outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public BigDecimal getOvernight() {
		return overnight;
	}

	public void setOvernight(BigDecimal overnight) {
		this.overnight = overnight;
	}

	public BigDecimal getOnTo1m() {
		return onTo1m;
	}

	public void setOnTo1m(BigDecimal onTo1m) {
		this.onTo1m = onTo1m;
	}

	public BigDecimal getOneMTo3m() {
		return oneMTo3m;
	}

	public void setOneMTo3m(BigDecimal oneMTo3m) {
		this.oneMTo3m = oneMTo3m;
	}

	public BigDecimal getThreeMTo6m() {
		return threeMTo6m;
	}

	public void setThreeMTo6m(BigDecimal threeMTo6m) {
		this.threeMTo6m = threeMTo6m;
	}

	public BigDecimal getSixMTo9m() {
		return sixMTo9m;
	}

	public void setSixMTo9m(BigDecimal sixMTo9m) {
		this.sixMTo9m = sixMTo9m;
	}

	public BigDecimal getNineMTo1y() {
		return nineMTo1y;
	}

	public void setNineMTo1y(BigDecimal nineMTo1y) {
		this.nineMTo1y = nineMTo1y;
	}

	public BigDecimal getOneYTo1_5y() {
		return oneYTo1_5y;
	}

	public void setOneYTo1_5y(BigDecimal oneYTo1_5y) {
		this.oneYTo1_5y = oneYTo1_5y;
	}

	public BigDecimal getOne5yTo2y() {
		return one5yTo2y;
	}

	public void setOne5yTo2y(BigDecimal one5yTo2y) {
		this.one5yTo2y = one5yTo2y;
	}

	public BigDecimal getTwoYTo3y() {
		return twoYTo3y;
	}

	public void setTwoYTo3y(BigDecimal twoYTo3y) {
		this.twoYTo3y = twoYTo3y;
	}

	public BigDecimal getThreeYTo4y() {
		return threeYTo4y;
	}

	public void setThreeYTo4y(BigDecimal threeYTo4y) {
		this.threeYTo4y = threeYTo4y;
	}

	public BigDecimal getFourYTo5y() {
		return fourYTo5y;
	}

	public void setFourYTo5y(BigDecimal fourYTo5y) {
		this.fourYTo5y = fourYTo5y;
	}

	public BigDecimal getFiveYTo6y() {
		return fiveYTo6y;
	}

	public void setFiveYTo6y(BigDecimal fiveYTo6y) {
		this.fiveYTo6y = fiveYTo6y;
	}

	public BigDecimal getSixYTo7y() {
		return sixYTo7y;
	}

	public void setSixYTo7y(BigDecimal sixYTo7y) {
		this.sixYTo7y = sixYTo7y;
	}

	public BigDecimal getSevenYTo8y() {
		return sevenYTo8y;
	}

	public void setSevenYTo8y(BigDecimal sevenYTo8y) {
		this.sevenYTo8y = sevenYTo8y;
	}

	public BigDecimal getEightYTo9y() {
		return eightYTo9y;
	}

	public void setEightYTo9y(BigDecimal eightYTo9y) {
		this.eightYTo9y = eightYTo9y;
	}

	public BigDecimal getNineYTo10y() {
		return nineYTo10y;
	}

	public void setNineYTo10y(BigDecimal nineYTo10y) {
		this.nineYTo10y = nineYTo10y;
	}

	public BigDecimal getTenYTo15y() {
		return tenYTo15y;
	}

	public void setTenYTo15y(BigDecimal tenYTo15y) {
		this.tenYTo15y = tenYTo15y;
	}

	public BigDecimal getFifteenYTo20y() {
		return fifteenYTo20y;
	}

	public void setFifteenYTo20y(BigDecimal fifteenYTo20y) {
		this.fifteenYTo20y = fifteenYTo20y;
	}

	public BigDecimal getTwentyYAbove() {
		return twentyYAbove;
	}

	public void setTwentyYAbove(BigDecimal twentyYAbove) {
		this.twentyYAbove = twentyYAbove;
	}

	public BigDecimal getNonMaturing() {
		return nonMaturing;
	}

	public void setNonMaturing(BigDecimal nonMaturing) {
		this.nonMaturing = nonMaturing;
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

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public RT_Liquidity_Risk_Data_Template(BigDecimal slno, Date dataDate, String bankName, String headOfficeSubsidiary,
			String bankSymbol, String conventionalIslamic, String localForeign, String cbuaeTiering, String glLevel1,
			String glLevel2, String glLevel3, String optionType, String rateType, String referenceRate,
			String instrumentCurrency, BigDecimal outstandingBalance, BigDecimal overnight, BigDecimal onTo1m,
			BigDecimal oneMTo3m, BigDecimal threeMTo6m, BigDecimal sixMTo9m, BigDecimal nineMTo1y,
			BigDecimal oneYTo1_5y, BigDecimal one5yTo2y, BigDecimal twoYTo3y, BigDecimal threeYTo4y,
			BigDecimal fourYTo5y, BigDecimal fiveYTo6y, BigDecimal sixYTo7y, BigDecimal sevenYTo8y,
			BigDecimal eightYTo9y, BigDecimal nineYTo10y, BigDecimal tenYTo15y, BigDecimal fifteenYTo20y,
			BigDecimal twentyYAbove, BigDecimal nonMaturing, Date reportSubmitDate, Date reportFromDate,
			Date reportToDate, Date reportDate, String entityFlg, String modifyFlg, String delFlg, String reportCode,
			String entryUser, String modifyUser, String verifyUser, Date entryTime, Date modifyTime, Date verifyTime) {
		super();
		this.slno = slno;
		this.dataDate = dataDate;
		this.bankName = bankName;
		this.headOfficeSubsidiary = headOfficeSubsidiary;
		this.bankSymbol = bankSymbol;
		this.conventionalIslamic = conventionalIslamic;
		this.localForeign = localForeign;
		this.cbuaeTiering = cbuaeTiering;
		this.glLevel1 = glLevel1;
		this.glLevel2 = glLevel2;
		this.glLevel3 = glLevel3;
		this.optionType = optionType;
		this.rateType = rateType;
		this.referenceRate = referenceRate;
		this.instrumentCurrency = instrumentCurrency;
		this.outstandingBalance = outstandingBalance;
		this.overnight = overnight;
		this.onTo1m = onTo1m;
		this.oneMTo3m = oneMTo3m;
		this.threeMTo6m = threeMTo6m;
		this.sixMTo9m = sixMTo9m;
		this.nineMTo1y = nineMTo1y;
		this.oneYTo1_5y = oneYTo1_5y;
		this.one5yTo2y = one5yTo2y;
		this.twoYTo3y = twoYTo3y;
		this.threeYTo4y = threeYTo4y;
		this.fourYTo5y = fourYTo5y;
		this.fiveYTo6y = fiveYTo6y;
		this.sixYTo7y = sixYTo7y;
		this.sevenYTo8y = sevenYTo8y;
		this.eightYTo9y = eightYTo9y;
		this.nineYTo10y = nineYTo10y;
		this.tenYTo15y = tenYTo15y;
		this.fifteenYTo20y = fifteenYTo20y;
		this.twentyYAbove = twentyYAbove;
		this.nonMaturing = nonMaturing;
		this.reportSubmitDate = reportSubmitDate;
		this.reportFromDate = reportFromDate;
		this.reportToDate = reportToDate;
		this.reportDate = reportDate;
		this.entityFlg = entityFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
		this.reportCode = reportCode;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.verifyUser = verifyUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
		this.verifyTime = verifyTime;
	}

	public RT_Liquidity_Risk_Data_Template() {
		super();
		// TODO Auto-generated constructor stub
	}


    
}
