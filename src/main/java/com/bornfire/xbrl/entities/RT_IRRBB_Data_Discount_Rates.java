package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BCBUAE_IRRBB_DISCOUNT_RATES")
public class RT_IRRBB_Data_Discount_Rates {
	
	@Id
	@Column(name = "SI_NO")
	private BigDecimal SI_NO;

	    @Column(name = "DERIVED_TENOR")
	    private String derivedTenor;

	    @Column(name = "OVERNIGHT")
	    private BigDecimal overnight;

	    @Column(name = "ONE_WEEK")
	    private BigDecimal oneWeek;

	    @Column(name = "ONE_MONTH")
	    private BigDecimal oneMonth;

	    @Column(name = "TWO_MONTH")
	    private BigDecimal twoMonth;

	    @Column(name = "THREE_MONTH")
	    private BigDecimal threeMonth;

	    @Column(name = "SIX_MONTH")
	    private BigDecimal sixMonth;

	    @Column(name = "NINE_MONTH")
	    private BigDecimal nineMonth;

	    @Column(name = "ONE_YEAR")
	    private BigDecimal oneYear;

	    @Column(name = "ONE_POINT_FIVE_YEAR")
	    private BigDecimal onePointFiveYear;

	    @Column(name = "TWO_YEAR")
	    private BigDecimal twoYear;

	    @Column(name = "THREE_YEAR")
	    private BigDecimal threeYear;

	    @Column(name = "FOUR_YEAR")
	    private BigDecimal fourYear;

	    @Column(name = "FIVE_YEAR")
	    private BigDecimal fiveYear;

	    @Column(name = "SIX_YEAR")
	    private BigDecimal sixYear;

	    @Column(name = "SEVEN_YEAR")
	    private BigDecimal sevenYear;

	    @Column(name = "EIGHT_YEAR")
	    private BigDecimal eightYear;

	    @Column(name = "NINE_YEAR")
	    private BigDecimal nineYear;

	    @Column(name = "TEN_YEAR")
	    private BigDecimal tenYear;

	    @Column(name = "TWELVE_YEAR")
	    private BigDecimal twelveYear;

	    @Column(name = "FIFTEEN_YEAR")
	    private BigDecimal fifteenYear;

	    @Column(name = "TWENTY_YEAR")
	    private BigDecimal twentyYear;

	    @Column(name = "THIRTY_YEAR")
	    private BigDecimal thirtyYear;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_DATE")
	   
	    private Date reportDate;

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

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "ENTRY_TIME")
	  
	    private Date entryTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "MODIFY_TIME")
	  
	    private Date modifyTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "VERIFY_TIME")
	  
	    private Date verifyTime;

		public BigDecimal getSI_NO() {
			return SI_NO;
		}

		public void setSI_NO(BigDecimal sI_NO) {
			SI_NO = sI_NO;
		}

		public String getDerivedTenor() {
			return derivedTenor;
		}

		public void setDerivedTenor(String derivedTenor) {
			this.derivedTenor = derivedTenor;
		}

		public BigDecimal getOvernight() {
			return overnight;
		}

		public void setOvernight(BigDecimal overnight) {
			this.overnight = overnight;
		}

		public BigDecimal getOneWeek() {
			return oneWeek;
		}

		public void setOneWeek(BigDecimal oneWeek) {
			this.oneWeek = oneWeek;
		}

		public BigDecimal getOneMonth() {
			return oneMonth;
		}

		public void setOneMonth(BigDecimal oneMonth) {
			this.oneMonth = oneMonth;
		}

		public BigDecimal getTwoMonth() {
			return twoMonth;
		}

		public void setTwoMonth(BigDecimal twoMonth) {
			this.twoMonth = twoMonth;
		}

		public BigDecimal getThreeMonth() {
			return threeMonth;
		}

		public void setThreeMonth(BigDecimal threeMonth) {
			this.threeMonth = threeMonth;
		}

		public BigDecimal getSixMonth() {
			return sixMonth;
		}

		public void setSixMonth(BigDecimal sixMonth) {
			this.sixMonth = sixMonth;
		}

		public BigDecimal getNineMonth() {
			return nineMonth;
		}

		public void setNineMonth(BigDecimal nineMonth) {
			this.nineMonth = nineMonth;
		}

		public BigDecimal getOneYear() {
			return oneYear;
		}

		public void setOneYear(BigDecimal oneYear) {
			this.oneYear = oneYear;
		}

		public BigDecimal getOnePointFiveYear() {
			return onePointFiveYear;
		}

		public void setOnePointFiveYear(BigDecimal onePointFiveYear) {
			this.onePointFiveYear = onePointFiveYear;
		}

		public BigDecimal getTwoYear() {
			return twoYear;
		}

		public void setTwoYear(BigDecimal twoYear) {
			this.twoYear = twoYear;
		}

		public BigDecimal getThreeYear() {
			return threeYear;
		}

		public void setThreeYear(BigDecimal threeYear) {
			this.threeYear = threeYear;
		}

		public BigDecimal getFourYear() {
			return fourYear;
		}

		public void setFourYear(BigDecimal fourYear) {
			this.fourYear = fourYear;
		}

		public BigDecimal getFiveYear() {
			return fiveYear;
		}

		public void setFiveYear(BigDecimal fiveYear) {
			this.fiveYear = fiveYear;
		}

		public BigDecimal getSixYear() {
			return sixYear;
		}

		public void setSixYear(BigDecimal sixYear) {
			this.sixYear = sixYear;
		}

		public BigDecimal getSevenYear() {
			return sevenYear;
		}

		public void setSevenYear(BigDecimal sevenYear) {
			this.sevenYear = sevenYear;
		}

		public BigDecimal getEightYear() {
			return eightYear;
		}

		public void setEightYear(BigDecimal eightYear) {
			this.eightYear = eightYear;
		}

		public BigDecimal getNineYear() {
			return nineYear;
		}

		public void setNineYear(BigDecimal nineYear) {
			this.nineYear = nineYear;
		}

		public BigDecimal getTenYear() {
			return tenYear;
		}

		public void setTenYear(BigDecimal tenYear) {
			this.tenYear = tenYear;
		}

		public BigDecimal getTwelveYear() {
			return twelveYear;
		}

		public void setTwelveYear(BigDecimal twelveYear) {
			this.twelveYear = twelveYear;
		}

		public BigDecimal getFifteenYear() {
			return fifteenYear;
		}

		public void setFifteenYear(BigDecimal fifteenYear) {
			this.fifteenYear = fifteenYear;
		}

		public BigDecimal getTwentyYear() {
			return twentyYear;
		}

		public void setTwentyYear(BigDecimal twentyYear) {
			this.twentyYear = twentyYear;
		}

		public BigDecimal getThirtyYear() {
			return thirtyYear;
		}

		public void setThirtyYear(BigDecimal thirtyYear) {
			this.thirtyYear = thirtyYear;
		}

		public Date getReportDate() {
			return reportDate;
		}

		public void setReportDate(Date reportDate) {
			this.reportDate = reportDate;
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

		public RT_IRRBB_Data_Discount_Rates(BigDecimal sI_NO, String derivedTenor, BigDecimal overnight,
				BigDecimal oneWeek, BigDecimal oneMonth, BigDecimal twoMonth, BigDecimal threeMonth,
				BigDecimal sixMonth, BigDecimal nineMonth, BigDecimal oneYear, BigDecimal onePointFiveYear,
				BigDecimal twoYear, BigDecimal threeYear, BigDecimal fourYear, BigDecimal fiveYear, BigDecimal sixYear,
				BigDecimal sevenYear, BigDecimal eightYear, BigDecimal nineYear, BigDecimal tenYear,
				BigDecimal twelveYear, BigDecimal fifteenYear, BigDecimal twentyYear, BigDecimal thirtyYear,
				Date reportDate, Date reportFromDate, Date reportToDate, String entityFlg, String modifyFlg,
				String delFlg, String reportCode, Date reportSubmitDate, String entryUser, String modifyUser,
				String verifyUser, Date entryTime, Date modifyTime, Date verifyTime) {
			super();
			SI_NO = sI_NO;
			this.derivedTenor = derivedTenor;
			this.overnight = overnight;
			this.oneWeek = oneWeek;
			this.oneMonth = oneMonth;
			this.twoMonth = twoMonth;
			this.threeMonth = threeMonth;
			this.sixMonth = sixMonth;
			this.nineMonth = nineMonth;
			this.oneYear = oneYear;
			this.onePointFiveYear = onePointFiveYear;
			this.twoYear = twoYear;
			this.threeYear = threeYear;
			this.fourYear = fourYear;
			this.fiveYear = fiveYear;
			this.sixYear = sixYear;
			this.sevenYear = sevenYear;
			this.eightYear = eightYear;
			this.nineYear = nineYear;
			this.tenYear = tenYear;
			this.twelveYear = twelveYear;
			this.fifteenYear = fifteenYear;
			this.twentyYear = twentyYear;
			this.thirtyYear = thirtyYear;
			this.reportDate = reportDate;
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

		public RT_IRRBB_Data_Discount_Rates() {
			super();
			// TODO Auto-generated constructor stub
		}


}
