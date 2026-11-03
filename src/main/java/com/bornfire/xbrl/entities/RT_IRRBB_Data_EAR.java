package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@IdClass(RT_IRRBB_Data_EVE_Template_Idclass.class)
@Entity
@Table (name="BCBUAE_IRRBB_EAR")
public class RT_IRRBB_Data_EAR {
	

		@Column(name = "SI_NO")
		private BigDecimal SI_NO;
		
		@Id
	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_DATE")
	    private Date reportDate;

	    @Column(name = "BANK_NAME")
	    private String bankName;

	    @Column(name = "GROUP_HEAD_OFFICE_SUBSIDIARY")
	    private String groupHeadOfficeSubsidiary;

	    @Column(name = "BANK_SYMBOL")
	    private String bankSymbol;

	    @Column(name = "CONVENTIONAL_OR_ISLAMIC")
	    private String conventionalOrIslamic;

	    @Column(name = "LOCAL_OR_FOREIGN")
	    private String localOrForeign;

	    @Column(name = "CBUAE_TIERING")
	    private String cbuaeTiering;

	    @Column(name = "SUBSIDIARY")
	    private String subsidiary;
	    
	    @Id
	    @Column(name = "SCENARIO")
	    private String scenario;
	    
	    @Id
	    @Column(name = "GL_LEVEL_1")
	    private String glLevel1;
	    
	    @Id
	    @Column(name = "GL_LEVEL_2")
	    private String glLevel2;
	    
	    @Id
	    @Column(name = "GL_LEVEL_3")
	    private String glLevel3;

	    @Column(name = "OPTION_TYPE")
	    private String optionType;

	    @Column(name = "RATE_TYPE")
	    private String rateType;

	    @Column(name = "REFERENCE_RATE")
	    private String referenceRate;

	    @Id
	    @Column(name = "INSTRUMENT_CURRENCY")
	    private String instrumentCurrency;

	    @Column(name = "PASS_THROUGH_RATE", precision = 24, scale = 4)
	    private BigDecimal passThroughRate;

	    @Column(name = "OVERNIGHT", precision = 24, scale = 4)
	    private BigDecimal overnight;

	    @Column(name = "ON_TO_TWO_W", precision = 24, scale = 4)
	    private BigDecimal onToTwoW;

	    @Column(name = "TWO_W_TO_ONE_M", precision = 24, scale = 4)
	    private BigDecimal twoWToOneM;

	    @Column(name = "ONE_M_TO_TWO_M", precision = 24, scale = 4)
	    private BigDecimal oneMToTwoM;

	    @Column(name = "TWO_M_TO_THREE_M", precision = 24, scale = 4)
	    private BigDecimal twoMToThreeM;

	    @Column(name = "THREE_M_TO_FOUR_M", precision = 24, scale = 4)
	    private BigDecimal threeMToFourM;

	    @Column(name = "FOUR_M_TO_FIVE_M", precision = 24, scale = 4)
	    private BigDecimal fourMToFiveM;

	    @Column(name = "FIVE_M_TO_SIX_M", precision = 24, scale = 4)
	    private BigDecimal fiveMToSixM;

	    @Column(name = "SIX_M_TO_SEVEN_M", precision = 24, scale = 4)
	    private BigDecimal sixMToSevenM;

	    @Column(name = "SEVEN_M_TO_EIGHT_M", precision = 24, scale = 4)
	    private BigDecimal sevenMToEightM;

	    @Column(name = "EIGHT_M_TO_NINE_M", precision = 24, scale = 4)
	    private BigDecimal eightMToNineM;

	    @Column(name = "NINE_M_TO_TEN_M", precision = 24, scale = 4)
	    private BigDecimal nineMToTenM;

	    @Column(name = "TEN_M_TO_ELEVEN_M", precision = 24, scale = 4)
	    private BigDecimal tenMToElevenM;

	    @Column(name = "ELEVEN_M_TO_TWELVE_M", precision = 24, scale = 4)
	    private BigDecimal elevenMToTwelveM;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_FROM_DATE")
	    private Date reportFromDate;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_TO_DATE")
	    private Date reportToDate;

	    @Column(name = "ENTITY_FLG")
	    private String entityFlg;

	    @Column(name = "MODIFY_FLG")
	    private String modifyFlg;

	    @Column(name = "DEL_FLG")
	    private String delFlg;

	    @Column(name = "REPORT_CODE")
	    private String reportCode;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_SUBMIT_DATE")
	    private Date reportSubmitDate;

	    @Column(name = "ENTRY_USER")
	    private String entryUser;

	    @Column(name = "MODIFY_USER")
	    private String modifyUser;

	    @Column(name = "VERIFY_USER")
	    private String verifyUser;

	    
	    @Column(name = "ENTRY_TIME")
	    private Date entryTime;

	    
	    @Column(name = "MODIFY_TIME")
	    private Date modifyTime;

	    
	    @Column(name = "VERIFY_TIME")
	    private Date verifyTime;


		public BigDecimal getSI_NO() {
			return SI_NO;
		}


		public void setSI_NO(BigDecimal sI_NO) {
			SI_NO = sI_NO;
		}


		public Date getReportDate() {
			return reportDate;
		}


		public void setReportDate(Date reportDate) {
			this.reportDate = reportDate;
		}


		public String getBankName() {
			return bankName;
		}


		public void setBankName(String bankName) {
			this.bankName = bankName;
		}


		public String getGroupHeadOfficeSubsidiary() {
			return groupHeadOfficeSubsidiary;
		}


		public void setGroupHeadOfficeSubsidiary(String groupHeadOfficeSubsidiary) {
			this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
		}


		public String getBankSymbol() {
			return bankSymbol;
		}


		public void setBankSymbol(String bankSymbol) {
			this.bankSymbol = bankSymbol;
		}


		public String getConventionalOrIslamic() {
			return conventionalOrIslamic;
		}


		public void setConventionalOrIslamic(String conventionalOrIslamic) {
			this.conventionalOrIslamic = conventionalOrIslamic;
		}


		public String getLocalOrForeign() {
			return localOrForeign;
		}


		public void setLocalOrForeign(String localOrForeign) {
			this.localOrForeign = localOrForeign;
		}


		public String getCbuaeTiering() {
			return cbuaeTiering;
		}


		public void setCbuaeTiering(String cbuaeTiering) {
			this.cbuaeTiering = cbuaeTiering;
		}


		public String getSubsidiary() {
			return subsidiary;
		}


		public void setSubsidiary(String subsidiary) {
			this.subsidiary = subsidiary;
		}


		public String getScenario() {
			return scenario;
		}


		public void setScenario(String scenario) {
			this.scenario = scenario;
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


		public BigDecimal getPassThroughRate() {
			return passThroughRate;
		}


		public void setPassThroughRate(BigDecimal passThroughRate) {
			this.passThroughRate = passThroughRate;
		}


		public BigDecimal getOvernight() {
			return overnight;
		}


		public void setOvernight(BigDecimal overnight) {
			this.overnight = overnight;
		}


		public BigDecimal getOnToTwoW() {
			return onToTwoW;
		}


		public void setOnToTwoW(BigDecimal onToTwoW) {
			this.onToTwoW = onToTwoW;
		}


		public BigDecimal getTwoWToOneM() {
			return twoWToOneM;
		}


		public void setTwoWToOneM(BigDecimal twoWToOneM) {
			this.twoWToOneM = twoWToOneM;
		}


		public BigDecimal getOneMToTwoM() {
			return oneMToTwoM;
		}


		public void setOneMToTwoM(BigDecimal oneMToTwoM) {
			this.oneMToTwoM = oneMToTwoM;
		}


		public BigDecimal getTwoMToThreeM() {
			return twoMToThreeM;
		}


		public void setTwoMToThreeM(BigDecimal twoMToThreeM) {
			this.twoMToThreeM = twoMToThreeM;
		}


		public BigDecimal getThreeMToFourM() {
			return threeMToFourM;
		}


		public void setThreeMToFourM(BigDecimal threeMToFourM) {
			this.threeMToFourM = threeMToFourM;
		}


		public BigDecimal getFourMToFiveM() {
			return fourMToFiveM;
		}


		public void setFourMToFiveM(BigDecimal fourMToFiveM) {
			this.fourMToFiveM = fourMToFiveM;
		}


		public BigDecimal getFiveMToSixM() {
			return fiveMToSixM;
		}


		public void setFiveMToSixM(BigDecimal fiveMToSixM) {
			this.fiveMToSixM = fiveMToSixM;
		}


		public BigDecimal getSixMToSevenM() {
			return sixMToSevenM;
		}


		public void setSixMToSevenM(BigDecimal sixMToSevenM) {
			this.sixMToSevenM = sixMToSevenM;
		}


		public BigDecimal getSevenMToEightM() {
			return sevenMToEightM;
		}


		public void setSevenMToEightM(BigDecimal sevenMToEightM) {
			this.sevenMToEightM = sevenMToEightM;
		}


		public BigDecimal getEightMToNineM() {
			return eightMToNineM;
		}


		public void setEightMToNineM(BigDecimal eightMToNineM) {
			this.eightMToNineM = eightMToNineM;
		}


		public BigDecimal getNineMToTenM() {
			return nineMToTenM;
		}


		public void setNineMToTenM(BigDecimal nineMToTenM) {
			this.nineMToTenM = nineMToTenM;
		}


		public BigDecimal getTenMToElevenM() {
			return tenMToElevenM;
		}


		public void setTenMToElevenM(BigDecimal tenMToElevenM) {
			this.tenMToElevenM = tenMToElevenM;
		}


		public BigDecimal getElevenMToTwelveM() {
			return elevenMToTwelveM;
		}


		public void setElevenMToTwelveM(BigDecimal elevenMToTwelveM) {
			this.elevenMToTwelveM = elevenMToTwelveM;
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


		public Date getReportSubmitDate() {
			return reportSubmitDate;
		}


		public void setReportSubmitDate(Date reportSubmitDate) {
			this.reportSubmitDate = reportSubmitDate;
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


		public RT_IRRBB_Data_EAR(BigDecimal sI_NO, Date reportDate, String bankName, String groupHeadOfficeSubsidiary,
				String bankSymbol, String conventionalOrIslamic, String localOrForeign, String cbuaeTiering,
				String subsidiary, String scenario, String glLevel1, String glLevel2, String glLevel3,
				String optionType, String rateType, String referenceRate, String instrumentCurrency,
				BigDecimal passThroughRate, BigDecimal overnight, BigDecimal onToTwoW, BigDecimal twoWToOneM,
				BigDecimal oneMToTwoM, BigDecimal twoMToThreeM, BigDecimal threeMToFourM, BigDecimal fourMToFiveM,
				BigDecimal fiveMToSixM, BigDecimal sixMToSevenM, BigDecimal sevenMToEightM, BigDecimal eightMToNineM,
				BigDecimal nineMToTenM, BigDecimal tenMToElevenM, BigDecimal elevenMToTwelveM, Date reportFromDate,
				Date reportToDate, String entityFlg, String modifyFlg, String delFlg, String reportCode,
				Date reportSubmitDate, String entryUser, String modifyUser, String verifyUser, Date entryTime,
				Date modifyTime, Date verifyTime) {
			super();
			SI_NO = sI_NO;
			this.reportDate = reportDate;
			this.bankName = bankName;
			this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
			this.bankSymbol = bankSymbol;
			this.conventionalOrIslamic = conventionalOrIslamic;
			this.localOrForeign = localOrForeign;
			this.cbuaeTiering = cbuaeTiering;
			this.subsidiary = subsidiary;
			this.scenario = scenario;
			this.glLevel1 = glLevel1;
			this.glLevel2 = glLevel2;
			this.glLevel3 = glLevel3;
			this.optionType = optionType;
			this.rateType = rateType;
			this.referenceRate = referenceRate;
			this.instrumentCurrency = instrumentCurrency;
			this.passThroughRate = passThroughRate;
			this.overnight = overnight;
			this.onToTwoW = onToTwoW;
			this.twoWToOneM = twoWToOneM;
			this.oneMToTwoM = oneMToTwoM;
			this.twoMToThreeM = twoMToThreeM;
			this.threeMToFourM = threeMToFourM;
			this.fourMToFiveM = fourMToFiveM;
			this.fiveMToSixM = fiveMToSixM;
			this.sixMToSevenM = sixMToSevenM;
			this.sevenMToEightM = sevenMToEightM;
			this.eightMToNineM = eightMToNineM;
			this.nineMToTenM = nineMToTenM;
			this.tenMToElevenM = tenMToElevenM;
			this.elevenMToTwelveM = elevenMToTwelveM;
			this.reportFromDate = reportFromDate;
			this.reportToDate = reportToDate;
			this.entityFlg = entityFlg;
			this.modifyFlg = modifyFlg;
			this.delFlg = delFlg;
			this.reportCode = reportCode;
			this.reportSubmitDate = reportSubmitDate;
			this.entryUser = entryUser;
			this.modifyUser = modifyUser;
			this.verifyUser = verifyUser;
			this.entryTime = entryTime;
			this.modifyTime = modifyTime;
			this.verifyTime = verifyTime;
		}


		public RT_IRRBB_Data_EAR() {
			super();
			// TODO Auto-generated constructor stub
		}

}
