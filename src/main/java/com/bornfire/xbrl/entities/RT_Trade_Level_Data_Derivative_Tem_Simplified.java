package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BCBUAE_TRADE_LEVEL_DATA_DRIVATIVES_TEM_SIMPLIFIED")

public class RT_Trade_Level_Data_Derivative_Tem_Simplified {
	
	 @Id
	 private Long siNo;
	  
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date reportDate;

	    private String bankName;
	    private String headOfficeSubsidiary;
	    private String subsidiary;
	    private String bankSymbol;
	    private String conventionalIslamic;
	    private String cbuaeTiering;
	    private String cbuaeTiering2;
	    private String cptyName;
	    private String internalCounterpartyRef;
	    private String internalTransactionRef;
	    private String underlyingAssetClass;
	    private String derivativesType;
	    private String transactionRationale;
	    private String bundleTransaction;
	    private String backToBackTransaction;
	    private String instrumentsCharacteristics;
	    private String currencyValuation;
	    private BigDecimal aedFxSpotRate;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date startDate;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date effectiveDate;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date finalMaturityDate;

	    private BigDecimal residualMaturity;
	    private BigDecimal residualMaturityRounded;
	    private String maturityPeriod;
	    private String appAllIntruPosition;
	    private String notionalType;
	    private String cancellableY;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date cancellableDate;

	    private String cancellableOptionType;
	    private BigDecimal notional1Assets;
	    private String notional1Currency;
	    private String payReceive1;
	    private BigDecimal couponFixed1;
	    private BigDecimal applicableToInteretMargin1;
	    private String applicableToInteretBenchmark1;
	    private String applicableToInteretBenchmarkTenor1;
	    private BigDecimal notional2Liabilities;
	    private String notional2Currency;
	    private String payReceive2;
	    private BigDecimal couponFixed2;
	    private BigDecimal margin2;
	    private String benchmark2;
	    private String benchmarkTenor2;
	    private BigDecimal cleanValue;
	    private BigDecimal accruedInterestProfit;
	    private BigDecimal dv01;
	    private BigDecimal br01;
	    private BigDecimal dollarDelta;
	    private BigDecimal dollarVega;
	    private BigDecimal dollarGamma;
	    private BigDecimal dollarTheta;

	    private BigDecimal notional1AssetsLeg1;
	    private String notional1CurrencyLeg1;
	    private String payReceive1Leg1;
	    private BigDecimal couponFixed1Leg1;
	    private BigDecimal appToTotMargin1Leg1;
	    private String appToTotBenchmark1Leg1;
	    private String appToTotBenchmarkTenor1Leg1;
	    private String underlyingLeg1;
	    private String underlyingLeg1Details;
	    private BigDecimal notional2LiabilitiesLeg2;
	    private String notional2CurrencyLeg2;
	    private String payReceive2Leg2;
	    private BigDecimal couponFixed2Leg2;
	    private BigDecimal appToTotMargin2Leg2;
	    private String appToTotBenchmark2Leg2;
	    private String appToTotBenchmarkTenor2Leg2;
	    private String appToTotUnderlyingLeg2;
	    private String appToTotUnderlyingLeg2Details;
	    private BigDecimal cleanValueLeg;
	    private BigDecimal accruedInterestProfitLeg;
	    private BigDecimal dv01Leg;
	    private String cdsType;
	    private String cdsUnderlying;
	    private String quantoY;
	    private BigDecimal nominal;
	    private BigDecimal cleanValueCds;
	    private BigDecimal irDv01;
	    private BigDecimal cs01;
	    private String futureType;
	    private String futureUnderlyingContract;
	    private BigDecimal qty;
	    private BigDecimal contractSize;
	    private BigDecimal contractRate;
	    private BigDecimal marketRate;
	    private BigDecimal contractValuation;
	    private BigDecimal sensitivity;
	    private String optionsList;
	    private String optionType;
	    private String underlyingType;
	    private String underlyingDetails;
	    private BigDecimal strike;
	    private BigDecimal marketRateOption;
	    private String barrierType;
	    private BigDecimal barrierUpper;
	    private BigDecimal barrierLower;
	    private BigDecimal optionFairValue;
	    private BigDecimal dollarDeltaOption;
	    private BigDecimal dollarVegaOption;
	    private BigDecimal dollarGammaOption;
	    private BigDecimal dollarRhoOption;
	    private BigDecimal dollarThetaOption;
	    private BigDecimal overallMtm;
	    private BigDecimal irsPrsCcsPosMtm;
	    private BigDecimal assetSwapPosMtm;
	    private BigDecimal cdsPosMtm;
	    private BigDecimal futurePosMtm;
	    private BigDecimal optionPosMtm;
	    private BigDecimal overallPosMtm;
	    private BigDecimal individualPosMtm;
	    private BigDecimal irsPrsCcsNegMtm;
	    private BigDecimal assetSwapNegMtm;
	    private BigDecimal cdsNegMtm;
	    private BigDecimal futureNegMtm;
	    private BigDecimal optionNegMtm;
	    private BigDecimal overallNegMtm;
	    private BigDecimal individualNegMtm;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date reportFromDate;
	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date reportToDate;

	    private String entityFlg;
	    private String modifyFlg;
	    private String delFlg;
	    private String reportCode;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date reportSubmitDate;

	    private String entryUser;
	    private String modifyUser;
	    private String verifyUser;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date entryTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date modifyTime;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date verifyTime;

		public Long getSiNo() {
			return siNo;
		}

		public void setSiNo(Long siNo) {
			this.siNo = siNo;
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

		public String getHeadOfficeSubsidiary() {
			return headOfficeSubsidiary;
		}

		public void setHeadOfficeSubsidiary(String headOfficeSubsidiary) {
			this.headOfficeSubsidiary = headOfficeSubsidiary;
		}

		public String getSubsidiary() {
			return subsidiary;
		}

		public void setSubsidiary(String subsidiary) {
			this.subsidiary = subsidiary;
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

		public String getCbuaeTiering() {
			return cbuaeTiering;
		}

		public void setCbuaeTiering(String cbuaeTiering) {
			this.cbuaeTiering = cbuaeTiering;
		}

		public String getCbuaeTiering2() {
			return cbuaeTiering2;
		}

		public void setCbuaeTiering2(String cbuaeTiering2) {
			this.cbuaeTiering2 = cbuaeTiering2;
		}

		public String getCptyName() {
			return cptyName;
		}

		public void setCptyName(String cptyName) {
			this.cptyName = cptyName;
		}

		public String getInternalCounterpartyRef() {
			return internalCounterpartyRef;
		}

		public void setInternalCounterpartyRef(String internalCounterpartyRef) {
			this.internalCounterpartyRef = internalCounterpartyRef;
		}

		public String getInternalTransactionRef() {
			return internalTransactionRef;
		}

		public void setInternalTransactionRef(String internalTransactionRef) {
			this.internalTransactionRef = internalTransactionRef;
		}

		public String getUnderlyingAssetClass() {
			return underlyingAssetClass;
		}

		public void setUnderlyingAssetClass(String underlyingAssetClass) {
			this.underlyingAssetClass = underlyingAssetClass;
		}

		public String getDerivativesType() {
			return derivativesType;
		}

		public void setDerivativesType(String derivativesType) {
			this.derivativesType = derivativesType;
		}

		public String getTransactionRationale() {
			return transactionRationale;
		}

		public void setTransactionRationale(String transactionRationale) {
			this.transactionRationale = transactionRationale;
		}

		public String getBundleTransaction() {
			return bundleTransaction;
		}

		public void setBundleTransaction(String bundleTransaction) {
			this.bundleTransaction = bundleTransaction;
		}

		public String getBackToBackTransaction() {
			return backToBackTransaction;
		}

		public void setBackToBackTransaction(String backToBackTransaction) {
			this.backToBackTransaction = backToBackTransaction;
		}

		public String getInstrumentsCharacteristics() {
			return instrumentsCharacteristics;
		}

		public void setInstrumentsCharacteristics(String instrumentsCharacteristics) {
			this.instrumentsCharacteristics = instrumentsCharacteristics;
		}

		public String getCurrencyValuation() {
			return currencyValuation;
		}

		public void setCurrencyValuation(String currencyValuation) {
			this.currencyValuation = currencyValuation;
		}

		public BigDecimal getAedFxSpotRate() {
			return aedFxSpotRate;
		}

		public void setAedFxSpotRate(BigDecimal aedFxSpotRate) {
			this.aedFxSpotRate = aedFxSpotRate;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEffectiveDate() {
			return effectiveDate;
		}

		public void setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
		}

		public Date getFinalMaturityDate() {
			return finalMaturityDate;
		}

		public void setFinalMaturityDate(Date finalMaturityDate) {
			this.finalMaturityDate = finalMaturityDate;
		}

		public BigDecimal getResidualMaturity() {
			return residualMaturity;
		}

		public void setResidualMaturity(BigDecimal residualMaturity) {
			this.residualMaturity = residualMaturity;
		}

		public BigDecimal getResidualMaturityRounded() {
			return residualMaturityRounded;
		}

		public void setResidualMaturityRounded(BigDecimal residualMaturityRounded) {
			this.residualMaturityRounded = residualMaturityRounded;
		}

		public String getMaturityPeriod() {
			return maturityPeriod;
		}

		public void setMaturityPeriod(String maturityPeriod) {
			this.maturityPeriod = maturityPeriod;
		}

		public String getAppAllIntruPosition() {
			return appAllIntruPosition;
		}

		public void setAppAllIntruPosition(String appAllIntruPosition) {
			this.appAllIntruPosition = appAllIntruPosition;
		}

		public String getNotionalType() {
			return notionalType;
		}

		public void setNotionalType(String notionalType) {
			this.notionalType = notionalType;
		}

		public String getCancellableY() {
			return cancellableY;
		}

		public void setCancellableY(String cancellableY) {
			this.cancellableY = cancellableY;
		}

		public Date getCancellableDate() {
			return cancellableDate;
		}

		public void setCancellableDate(Date cancellableDate) {
			this.cancellableDate = cancellableDate;
		}

		public String getCancellableOptionType() {
			return cancellableOptionType;
		}

		public void setCancellableOptionType(String cancellableOptionType) {
			this.cancellableOptionType = cancellableOptionType;
		}

		public BigDecimal getNotional1Assets() {
			return notional1Assets;
		}

		public void setNotional1Assets(BigDecimal notional1Assets) {
			this.notional1Assets = notional1Assets;
		}

		public String getNotional1Currency() {
			return notional1Currency;
		}

		public void setNotional1Currency(String notional1Currency) {
			this.notional1Currency = notional1Currency;
		}

		public String getPayReceive1() {
			return payReceive1;
		}

		public void setPayReceive1(String payReceive1) {
			this.payReceive1 = payReceive1;
		}

		public BigDecimal getCouponFixed1() {
			return couponFixed1;
		}

		public void setCouponFixed1(BigDecimal couponFixed1) {
			this.couponFixed1 = couponFixed1;
		}

		public BigDecimal getApplicableToInteretMargin1() {
			return applicableToInteretMargin1;
		}

		public void setApplicableToInteretMargin1(BigDecimal applicableToInteretMargin1) {
			this.applicableToInteretMargin1 = applicableToInteretMargin1;
		}

		public String getApplicableToInteretBenchmark1() {
			return applicableToInteretBenchmark1;
		}

		public void setApplicableToInteretBenchmark1(String applicableToInteretBenchmark1) {
			this.applicableToInteretBenchmark1 = applicableToInteretBenchmark1;
		}

		public String getApplicableToInteretBenchmarkTenor1() {
			return applicableToInteretBenchmarkTenor1;
		}

		public void setApplicableToInteretBenchmarkTenor1(String applicableToInteretBenchmarkTenor1) {
			this.applicableToInteretBenchmarkTenor1 = applicableToInteretBenchmarkTenor1;
		}

		public BigDecimal getNotional2Liabilities() {
			return notional2Liabilities;
		}

		public void setNotional2Liabilities(BigDecimal notional2Liabilities) {
			this.notional2Liabilities = notional2Liabilities;
		}

		public String getNotional2Currency() {
			return notional2Currency;
		}

		public void setNotional2Currency(String notional2Currency) {
			this.notional2Currency = notional2Currency;
		}

		public String getPayReceive2() {
			return payReceive2;
		}

		public void setPayReceive2(String payReceive2) {
			this.payReceive2 = payReceive2;
		}

		public BigDecimal getCouponFixed2() {
			return couponFixed2;
		}

		public void setCouponFixed2(BigDecimal couponFixed2) {
			this.couponFixed2 = couponFixed2;
		}

		public BigDecimal getMargin2() {
			return margin2;
		}

		public void setMargin2(BigDecimal margin2) {
			this.margin2 = margin2;
		}

		public String getBenchmark2() {
			return benchmark2;
		}

		public void setBenchmark2(String benchmark2) {
			this.benchmark2 = benchmark2;
		}

		public String getBenchmarkTenor2() {
			return benchmarkTenor2;
		}

		public void setBenchmarkTenor2(String benchmarkTenor2) {
			this.benchmarkTenor2 = benchmarkTenor2;
		}

		public BigDecimal getCleanValue() {
			return cleanValue;
		}

		public void setCleanValue(BigDecimal cleanValue) {
			this.cleanValue = cleanValue;
		}

		public BigDecimal getAccruedInterestProfit() {
			return accruedInterestProfit;
		}

		public void setAccruedInterestProfit(BigDecimal accruedInterestProfit) {
			this.accruedInterestProfit = accruedInterestProfit;
		}

		public BigDecimal getDv01() {
			return dv01;
		}

		public void setDv01(BigDecimal dv01) {
			this.dv01 = dv01;
		}

		public BigDecimal getBr01() {
			return br01;
		}

		public void setBr01(BigDecimal br01) {
			this.br01 = br01;
		}

		public BigDecimal getDollarDelta() {
			return dollarDelta;
		}

		public void setDollarDelta(BigDecimal dollarDelta) {
			this.dollarDelta = dollarDelta;
		}

		public BigDecimal getDollarVega() {
			return dollarVega;
		}

		public void setDollarVega(BigDecimal dollarVega) {
			this.dollarVega = dollarVega;
		}

		public BigDecimal getDollarGamma() {
			return dollarGamma;
		}

		public void setDollarGamma(BigDecimal dollarGamma) {
			this.dollarGamma = dollarGamma;
		}

		public BigDecimal getDollarTheta() {
			return dollarTheta;
		}

		public void setDollarTheta(BigDecimal dollarTheta) {
			this.dollarTheta = dollarTheta;
		}

		public BigDecimal getNotional1AssetsLeg1() {
			return notional1AssetsLeg1;
		}

		public void setNotional1AssetsLeg1(BigDecimal notional1AssetsLeg1) {
			this.notional1AssetsLeg1 = notional1AssetsLeg1;
		}

		public String getNotional1CurrencyLeg1() {
			return notional1CurrencyLeg1;
		}

		public void setNotional1CurrencyLeg1(String notional1CurrencyLeg1) {
			this.notional1CurrencyLeg1 = notional1CurrencyLeg1;
		}

		public String getPayReceive1Leg1() {
			return payReceive1Leg1;
		}

		public void setPayReceive1Leg1(String payReceive1Leg1) {
			this.payReceive1Leg1 = payReceive1Leg1;
		}

		public BigDecimal getCouponFixed1Leg1() {
			return couponFixed1Leg1;
		}

		public void setCouponFixed1Leg1(BigDecimal couponFixed1Leg1) {
			this.couponFixed1Leg1 = couponFixed1Leg1;
		}

		public BigDecimal getAppToTotMargin1Leg1() {
			return appToTotMargin1Leg1;
		}

		public void setAppToTotMargin1Leg1(BigDecimal appToTotMargin1Leg1) {
			this.appToTotMargin1Leg1 = appToTotMargin1Leg1;
		}

		public String getAppToTotBenchmark1Leg1() {
			return appToTotBenchmark1Leg1;
		}

		public void setAppToTotBenchmark1Leg1(String appToTotBenchmark1Leg1) {
			this.appToTotBenchmark1Leg1 = appToTotBenchmark1Leg1;
		}

		public String getAppToTotBenchmarkTenor1Leg1() {
			return appToTotBenchmarkTenor1Leg1;
		}

		public void setAppToTotBenchmarkTenor1Leg1(String appToTotBenchmarkTenor1Leg1) {
			this.appToTotBenchmarkTenor1Leg1 = appToTotBenchmarkTenor1Leg1;
		}

		public String getUnderlyingLeg1() {
			return underlyingLeg1;
		}

		public void setUnderlyingLeg1(String underlyingLeg1) {
			this.underlyingLeg1 = underlyingLeg1;
		}

		public String getUnderlyingLeg1Details() {
			return underlyingLeg1Details;
		}

		public void setUnderlyingLeg1Details(String underlyingLeg1Details) {
			this.underlyingLeg1Details = underlyingLeg1Details;
		}

		public BigDecimal getNotional2LiabilitiesLeg2() {
			return notional2LiabilitiesLeg2;
		}

		public void setNotional2LiabilitiesLeg2(BigDecimal notional2LiabilitiesLeg2) {
			this.notional2LiabilitiesLeg2 = notional2LiabilitiesLeg2;
		}

		public String getNotional2CurrencyLeg2() {
			return notional2CurrencyLeg2;
		}

		public void setNotional2CurrencyLeg2(String notional2CurrencyLeg2) {
			this.notional2CurrencyLeg2 = notional2CurrencyLeg2;
		}

		public String getPayReceive2Leg2() {
			return payReceive2Leg2;
		}

		public void setPayReceive2Leg2(String payReceive2Leg2) {
			this.payReceive2Leg2 = payReceive2Leg2;
		}

		public BigDecimal getCouponFixed2Leg2() {
			return couponFixed2Leg2;
		}

		public void setCouponFixed2Leg2(BigDecimal couponFixed2Leg2) {
			this.couponFixed2Leg2 = couponFixed2Leg2;
		}

		public BigDecimal getAppToTotMargin2Leg2() {
			return appToTotMargin2Leg2;
		}

		public void setAppToTotMargin2Leg2(BigDecimal appToTotMargin2Leg2) {
			this.appToTotMargin2Leg2 = appToTotMargin2Leg2;
		}

		public String getAppToTotBenchmark2Leg2() {
			return appToTotBenchmark2Leg2;
		}

		public void setAppToTotBenchmark2Leg2(String appToTotBenchmark2Leg2) {
			this.appToTotBenchmark2Leg2 = appToTotBenchmark2Leg2;
		}

		public String getAppToTotBenchmarkTenor2Leg2() {
			return appToTotBenchmarkTenor2Leg2;
		}

		public void setAppToTotBenchmarkTenor2Leg2(String appToTotBenchmarkTenor2Leg2) {
			this.appToTotBenchmarkTenor2Leg2 = appToTotBenchmarkTenor2Leg2;
		}

		public String getAppToTotUnderlyingLeg2() {
			return appToTotUnderlyingLeg2;
		}

		public void setAppToTotUnderlyingLeg2(String appToTotUnderlyingLeg2) {
			this.appToTotUnderlyingLeg2 = appToTotUnderlyingLeg2;
		}

		public String getAppToTotUnderlyingLeg2Details() {
			return appToTotUnderlyingLeg2Details;
		}

		public void setAppToTotUnderlyingLeg2Details(String appToTotUnderlyingLeg2Details) {
			this.appToTotUnderlyingLeg2Details = appToTotUnderlyingLeg2Details;
		}

		public BigDecimal getCleanValueLeg() {
			return cleanValueLeg;
		}

		public void setCleanValueLeg(BigDecimal cleanValueLeg) {
			this.cleanValueLeg = cleanValueLeg;
		}

		public BigDecimal getAccruedInterestProfitLeg() {
			return accruedInterestProfitLeg;
		}

		public void setAccruedInterestProfitLeg(BigDecimal accruedInterestProfitLeg) {
			this.accruedInterestProfitLeg = accruedInterestProfitLeg;
		}

		public BigDecimal getDv01Leg() {
			return dv01Leg;
		}

		public void setDv01Leg(BigDecimal dv01Leg) {
			this.dv01Leg = dv01Leg;
		}

		public String getCdsType() {
			return cdsType;
		}

		public void setCdsType(String cdsType) {
			this.cdsType = cdsType;
		}

		public String getCdsUnderlying() {
			return cdsUnderlying;
		}

		public void setCdsUnderlying(String cdsUnderlying) {
			this.cdsUnderlying = cdsUnderlying;
		}

		public String getQuantoY() {
			return quantoY;
		}

		public void setQuantoY(String quantoY) {
			this.quantoY = quantoY;
		}

		public BigDecimal getNominal() {
			return nominal;
		}

		public void setNominal(BigDecimal nominal) {
			this.nominal = nominal;
		}

		public BigDecimal getCleanValueCds() {
			return cleanValueCds;
		}

		public void setCleanValueCds(BigDecimal cleanValueCds) {
			this.cleanValueCds = cleanValueCds;
		}

		public BigDecimal getIrDv01() {
			return irDv01;
		}

		public void setIrDv01(BigDecimal irDv01) {
			this.irDv01 = irDv01;
		}

		public BigDecimal getCs01() {
			return cs01;
		}

		public void setCs01(BigDecimal cs01) {
			this.cs01 = cs01;
		}

		public String getFutureType() {
			return futureType;
		}

		public void setFutureType(String futureType) {
			this.futureType = futureType;
		}

		public String getFutureUnderlyingContract() {
			return futureUnderlyingContract;
		}

		public void setFutureUnderlyingContract(String futureUnderlyingContract) {
			this.futureUnderlyingContract = futureUnderlyingContract;
		}

		public BigDecimal getQty() {
			return qty;
		}

		public void setQty(BigDecimal qty) {
			this.qty = qty;
		}

		public BigDecimal getContractSize() {
			return contractSize;
		}

		public void setContractSize(BigDecimal contractSize) {
			this.contractSize = contractSize;
		}

		public BigDecimal getContractRate() {
			return contractRate;
		}

		public void setContractRate(BigDecimal contractRate) {
			this.contractRate = contractRate;
		}

		public BigDecimal getMarketRate() {
			return marketRate;
		}

		public void setMarketRate(BigDecimal marketRate) {
			this.marketRate = marketRate;
		}

		public BigDecimal getContractValuation() {
			return contractValuation;
		}

		public void setContractValuation(BigDecimal contractValuation) {
			this.contractValuation = contractValuation;
		}

		public BigDecimal getSensitivity() {
			return sensitivity;
		}

		public void setSensitivity(BigDecimal sensitivity) {
			this.sensitivity = sensitivity;
		}

		public String getOptionsList() {
			return optionsList;
		}

		public void setOptionsList(String optionsList) {
			this.optionsList = optionsList;
		}

		public String getOptionType() {
			return optionType;
		}

		public void setOptionType(String optionType) {
			this.optionType = optionType;
		}

		public String getUnderlyingType() {
			return underlyingType;
		}

		public void setUnderlyingType(String underlyingType) {
			this.underlyingType = underlyingType;
		}

		public String getUnderlyingDetails() {
			return underlyingDetails;
		}

		public void setUnderlyingDetails(String underlyingDetails) {
			this.underlyingDetails = underlyingDetails;
		}

		public BigDecimal getStrike() {
			return strike;
		}

		public void setStrike(BigDecimal strike) {
			this.strike = strike;
		}

		public BigDecimal getMarketRateOption() {
			return marketRateOption;
		}

		public void setMarketRateOption(BigDecimal marketRateOption) {
			this.marketRateOption = marketRateOption;
		}

		public String getBarrierType() {
			return barrierType;
		}

		public void setBarrierType(String barrierType) {
			this.barrierType = barrierType;
		}

		public BigDecimal getBarrierUpper() {
			return barrierUpper;
		}

		public void setBarrierUpper(BigDecimal barrierUpper) {
			this.barrierUpper = barrierUpper;
		}

		public BigDecimal getBarrierLower() {
			return barrierLower;
		}

		public void setBarrierLower(BigDecimal barrierLower) {
			this.barrierLower = barrierLower;
		}

		public BigDecimal getOptionFairValue() {
			return optionFairValue;
		}

		public void setOptionFairValue(BigDecimal optionFairValue) {
			this.optionFairValue = optionFairValue;
		}

		public BigDecimal getDollarDeltaOption() {
			return dollarDeltaOption;
		}

		public void setDollarDeltaOption(BigDecimal dollarDeltaOption) {
			this.dollarDeltaOption = dollarDeltaOption;
		}

		public BigDecimal getDollarVegaOption() {
			return dollarVegaOption;
		}

		public void setDollarVegaOption(BigDecimal dollarVegaOption) {
			this.dollarVegaOption = dollarVegaOption;
		}

		public BigDecimal getDollarGammaOption() {
			return dollarGammaOption;
		}

		public void setDollarGammaOption(BigDecimal dollarGammaOption) {
			this.dollarGammaOption = dollarGammaOption;
		}

		public BigDecimal getDollarRhoOption() {
			return dollarRhoOption;
		}

		public void setDollarRhoOption(BigDecimal dollarRhoOption) {
			this.dollarRhoOption = dollarRhoOption;
		}

		public BigDecimal getDollarThetaOption() {
			return dollarThetaOption;
		}

		public void setDollarThetaOption(BigDecimal dollarThetaOption) {
			this.dollarThetaOption = dollarThetaOption;
		}

		public BigDecimal getOverallMtm() {
			return overallMtm;
		}

		public void setOverallMtm(BigDecimal overallMtm) {
			this.overallMtm = overallMtm;
		}

		public BigDecimal getIrsPrsCcsPosMtm() {
			return irsPrsCcsPosMtm;
		}

		public void setIrsPrsCcsPosMtm(BigDecimal irsPrsCcsPosMtm) {
			this.irsPrsCcsPosMtm = irsPrsCcsPosMtm;
		}

		public BigDecimal getAssetSwapPosMtm() {
			return assetSwapPosMtm;
		}

		public void setAssetSwapPosMtm(BigDecimal assetSwapPosMtm) {
			this.assetSwapPosMtm = assetSwapPosMtm;
		}

		public BigDecimal getCdsPosMtm() {
			return cdsPosMtm;
		}

		public void setCdsPosMtm(BigDecimal cdsPosMtm) {
			this.cdsPosMtm = cdsPosMtm;
		}

		public BigDecimal getFuturePosMtm() {
			return futurePosMtm;
		}

		public void setFuturePosMtm(BigDecimal futurePosMtm) {
			this.futurePosMtm = futurePosMtm;
		}

		public BigDecimal getOptionPosMtm() {
			return optionPosMtm;
		}

		public void setOptionPosMtm(BigDecimal optionPosMtm) {
			this.optionPosMtm = optionPosMtm;
		}

		public BigDecimal getOverallPosMtm() {
			return overallPosMtm;
		}

		public void setOverallPosMtm(BigDecimal overallPosMtm) {
			this.overallPosMtm = overallPosMtm;
		}

		public BigDecimal getIndividualPosMtm() {
			return individualPosMtm;
		}

		public void setIndividualPosMtm(BigDecimal individualPosMtm) {
			this.individualPosMtm = individualPosMtm;
		}

		public BigDecimal getIrsPrsCcsNegMtm() {
			return irsPrsCcsNegMtm;
		}

		public void setIrsPrsCcsNegMtm(BigDecimal irsPrsCcsNegMtm) {
			this.irsPrsCcsNegMtm = irsPrsCcsNegMtm;
		}

		public BigDecimal getAssetSwapNegMtm() {
			return assetSwapNegMtm;
		}

		public void setAssetSwapNegMtm(BigDecimal assetSwapNegMtm) {
			this.assetSwapNegMtm = assetSwapNegMtm;
		}

		public BigDecimal getCdsNegMtm() {
			return cdsNegMtm;
		}

		public void setCdsNegMtm(BigDecimal cdsNegMtm) {
			this.cdsNegMtm = cdsNegMtm;
		}

		public BigDecimal getFutureNegMtm() {
			return futureNegMtm;
		}

		public void setFutureNegMtm(BigDecimal futureNegMtm) {
			this.futureNegMtm = futureNegMtm;
		}

		public BigDecimal getOptionNegMtm() {
			return optionNegMtm;
		}

		public void setOptionNegMtm(BigDecimal optionNegMtm) {
			this.optionNegMtm = optionNegMtm;
		}

		public BigDecimal getOverallNegMtm() {
			return overallNegMtm;
		}

		public void setOverallNegMtm(BigDecimal overallNegMtm) {
			this.overallNegMtm = overallNegMtm;
		}

		public BigDecimal getIndividualNegMtm() {
			return individualNegMtm;
		}

		public void setIndividualNegMtm(BigDecimal individualNegMtm) {
			this.individualNegMtm = individualNegMtm;
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

		public RT_Trade_Level_Data_Derivative_Tem_Simplified(Long siNo, Date reportDate, String bankName,
				String headOfficeSubsidiary, String subsidiary, String bankSymbol, String conventionalIslamic,
				String cbuaeTiering, String cbuaeTiering2, String cptyName, String internalCounterpartyRef,
				String internalTransactionRef, String underlyingAssetClass, String derivativesType,
				String transactionRationale, String bundleTransaction, String backToBackTransaction,
				String instrumentsCharacteristics, String currencyValuation, BigDecimal aedFxSpotRate, Date startDate,
				Date effectiveDate, Date finalMaturityDate, BigDecimal residualMaturity,
				BigDecimal residualMaturityRounded, String maturityPeriod, String appAllIntruPosition,
				String notionalType, String cancellableY, Date cancellableDate, String cancellableOptionType,
				BigDecimal notional1Assets, String notional1Currency, String payReceive1, BigDecimal couponFixed1,
				BigDecimal applicableToInteretMargin1, String applicableToInteretBenchmark1,
				String applicableToInteretBenchmarkTenor1, BigDecimal notional2Liabilities, String notional2Currency,
				String payReceive2, BigDecimal couponFixed2, BigDecimal margin2, String benchmark2,
				String benchmarkTenor2, BigDecimal cleanValue, BigDecimal accruedInterestProfit, BigDecimal dv01,
				BigDecimal br01, BigDecimal dollarDelta, BigDecimal dollarVega, BigDecimal dollarGamma,
				BigDecimal dollarTheta, BigDecimal notional1AssetsLeg1, String notional1CurrencyLeg1,
				String payReceive1Leg1, BigDecimal couponFixed1Leg1, BigDecimal appToTotMargin1Leg1,
				String appToTotBenchmark1Leg1, String appToTotBenchmarkTenor1Leg1, String underlyingLeg1,
				String underlyingLeg1Details, BigDecimal notional2LiabilitiesLeg2, String notional2CurrencyLeg2,
				String payReceive2Leg2, BigDecimal couponFixed2Leg2, BigDecimal appToTotMargin2Leg2,
				String appToTotBenchmark2Leg2, String appToTotBenchmarkTenor2Leg2, String appToTotUnderlyingLeg2,
				String appToTotUnderlyingLeg2Details, BigDecimal cleanValueLeg, BigDecimal accruedInterestProfitLeg,
				BigDecimal dv01Leg, String cdsType, String cdsUnderlying, String quantoY, BigDecimal nominal,
				BigDecimal cleanValueCds, BigDecimal irDv01, BigDecimal cs01, String futureType,
				String futureUnderlyingContract, BigDecimal qty, BigDecimal contractSize, BigDecimal contractRate,
				BigDecimal marketRate, BigDecimal contractValuation, BigDecimal sensitivity, String optionsList,
				String optionType, String underlyingType, String underlyingDetails, BigDecimal strike,
				BigDecimal marketRateOption, String barrierType, BigDecimal barrierUpper, BigDecimal barrierLower,
				BigDecimal optionFairValue, BigDecimal dollarDeltaOption, BigDecimal dollarVegaOption,
				BigDecimal dollarGammaOption, BigDecimal dollarRhoOption, BigDecimal dollarThetaOption,
				BigDecimal overallMtm, BigDecimal irsPrsCcsPosMtm, BigDecimal assetSwapPosMtm, BigDecimal cdsPosMtm,
				BigDecimal futurePosMtm, BigDecimal optionPosMtm, BigDecimal overallPosMtm, BigDecimal individualPosMtm,
				BigDecimal irsPrsCcsNegMtm, BigDecimal assetSwapNegMtm, BigDecimal cdsNegMtm, BigDecimal futureNegMtm,
				BigDecimal optionNegMtm, BigDecimal overallNegMtm, BigDecimal individualNegMtm, Date reportFromDate,
				Date reportToDate, String entityFlg, String modifyFlg, String delFlg, String reportCode,
				Date reportSubmitDate, String entryUser, String modifyUser, String verifyUser, Date entryTime,
				Date modifyTime, Date verifyTime) {
			super();
			this.siNo = siNo;
			this.reportDate = reportDate;
			this.bankName = bankName;
			this.headOfficeSubsidiary = headOfficeSubsidiary;
			this.subsidiary = subsidiary;
			this.bankSymbol = bankSymbol;
			this.conventionalIslamic = conventionalIslamic;
			this.cbuaeTiering = cbuaeTiering;
			this.cbuaeTiering2 = cbuaeTiering2;
			this.cptyName = cptyName;
			this.internalCounterpartyRef = internalCounterpartyRef;
			this.internalTransactionRef = internalTransactionRef;
			this.underlyingAssetClass = underlyingAssetClass;
			this.derivativesType = derivativesType;
			this.transactionRationale = transactionRationale;
			this.bundleTransaction = bundleTransaction;
			this.backToBackTransaction = backToBackTransaction;
			this.instrumentsCharacteristics = instrumentsCharacteristics;
			this.currencyValuation = currencyValuation;
			this.aedFxSpotRate = aedFxSpotRate;
			this.startDate = startDate;
			this.effectiveDate = effectiveDate;
			this.finalMaturityDate = finalMaturityDate;
			this.residualMaturity = residualMaturity;
			this.residualMaturityRounded = residualMaturityRounded;
			this.maturityPeriod = maturityPeriod;
			this.appAllIntruPosition = appAllIntruPosition;
			this.notionalType = notionalType;
			this.cancellableY = cancellableY;
			this.cancellableDate = cancellableDate;
			this.cancellableOptionType = cancellableOptionType;
			this.notional1Assets = notional1Assets;
			this.notional1Currency = notional1Currency;
			this.payReceive1 = payReceive1;
			this.couponFixed1 = couponFixed1;
			this.applicableToInteretMargin1 = applicableToInteretMargin1;
			this.applicableToInteretBenchmark1 = applicableToInteretBenchmark1;
			this.applicableToInteretBenchmarkTenor1 = applicableToInteretBenchmarkTenor1;
			this.notional2Liabilities = notional2Liabilities;
			this.notional2Currency = notional2Currency;
			this.payReceive2 = payReceive2;
			this.couponFixed2 = couponFixed2;
			this.margin2 = margin2;
			this.benchmark2 = benchmark2;
			this.benchmarkTenor2 = benchmarkTenor2;
			this.cleanValue = cleanValue;
			this.accruedInterestProfit = accruedInterestProfit;
			this.dv01 = dv01;
			this.br01 = br01;
			this.dollarDelta = dollarDelta;
			this.dollarVega = dollarVega;
			this.dollarGamma = dollarGamma;
			this.dollarTheta = dollarTheta;
			this.notional1AssetsLeg1 = notional1AssetsLeg1;
			this.notional1CurrencyLeg1 = notional1CurrencyLeg1;
			this.payReceive1Leg1 = payReceive1Leg1;
			this.couponFixed1Leg1 = couponFixed1Leg1;
			this.appToTotMargin1Leg1 = appToTotMargin1Leg1;
			this.appToTotBenchmark1Leg1 = appToTotBenchmark1Leg1;
			this.appToTotBenchmarkTenor1Leg1 = appToTotBenchmarkTenor1Leg1;
			this.underlyingLeg1 = underlyingLeg1;
			this.underlyingLeg1Details = underlyingLeg1Details;
			this.notional2LiabilitiesLeg2 = notional2LiabilitiesLeg2;
			this.notional2CurrencyLeg2 = notional2CurrencyLeg2;
			this.payReceive2Leg2 = payReceive2Leg2;
			this.couponFixed2Leg2 = couponFixed2Leg2;
			this.appToTotMargin2Leg2 = appToTotMargin2Leg2;
			this.appToTotBenchmark2Leg2 = appToTotBenchmark2Leg2;
			this.appToTotBenchmarkTenor2Leg2 = appToTotBenchmarkTenor2Leg2;
			this.appToTotUnderlyingLeg2 = appToTotUnderlyingLeg2;
			this.appToTotUnderlyingLeg2Details = appToTotUnderlyingLeg2Details;
			this.cleanValueLeg = cleanValueLeg;
			this.accruedInterestProfitLeg = accruedInterestProfitLeg;
			this.dv01Leg = dv01Leg;
			this.cdsType = cdsType;
			this.cdsUnderlying = cdsUnderlying;
			this.quantoY = quantoY;
			this.nominal = nominal;
			this.cleanValueCds = cleanValueCds;
			this.irDv01 = irDv01;
			this.cs01 = cs01;
			this.futureType = futureType;
			this.futureUnderlyingContract = futureUnderlyingContract;
			this.qty = qty;
			this.contractSize = contractSize;
			this.contractRate = contractRate;
			this.marketRate = marketRate;
			this.contractValuation = contractValuation;
			this.sensitivity = sensitivity;
			this.optionsList = optionsList;
			this.optionType = optionType;
			this.underlyingType = underlyingType;
			this.underlyingDetails = underlyingDetails;
			this.strike = strike;
			this.marketRateOption = marketRateOption;
			this.barrierType = barrierType;
			this.barrierUpper = barrierUpper;
			this.barrierLower = barrierLower;
			this.optionFairValue = optionFairValue;
			this.dollarDeltaOption = dollarDeltaOption;
			this.dollarVegaOption = dollarVegaOption;
			this.dollarGammaOption = dollarGammaOption;
			this.dollarRhoOption = dollarRhoOption;
			this.dollarThetaOption = dollarThetaOption;
			this.overallMtm = overallMtm;
			this.irsPrsCcsPosMtm = irsPrsCcsPosMtm;
			this.assetSwapPosMtm = assetSwapPosMtm;
			this.cdsPosMtm = cdsPosMtm;
			this.futurePosMtm = futurePosMtm;
			this.optionPosMtm = optionPosMtm;
			this.overallPosMtm = overallPosMtm;
			this.individualPosMtm = individualPosMtm;
			this.irsPrsCcsNegMtm = irsPrsCcsNegMtm;
			this.assetSwapNegMtm = assetSwapNegMtm;
			this.cdsNegMtm = cdsNegMtm;
			this.futureNegMtm = futureNegMtm;
			this.optionNegMtm = optionNegMtm;
			this.overallNegMtm = overallNegMtm;
			this.individualNegMtm = individualNegMtm;
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

		public RT_Trade_Level_Data_Derivative_Tem_Simplified() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	   


}
