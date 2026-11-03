package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BCBUAE_LIQUIDITY_RISK_DASHBOARD_TEMPLATE")
public class RT_Liquidity_Risk_Dashboard_Template {
	  @Id
	  private String SI_NO;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "REPORT_DATE")
	    private Date reportDate;

	    @Column(name = "BANK_NAME")
	    private String bankName;

	    @Column(name = "GROUP_HEAD_OFFICE_SUBSIDIARY")
	    private String groupHeadOfficeSubsidiary;

	    @Column(name = "SUBSIDIARY")
	    private String subsidiary;

	    @Column(name = "BANK_SYMBOL")
	    private String bankSymbol;

	    @Column(name = "CONVENTIONAL_ISLAMIC")
	    private String conventionalIslamic;

	    @Column(name = "LOCAL_FOREIGN")
	    private String localForeign;

	    @Column(name = "CBUAE_TIERING")
	    private String cbuAeTiering;

	    @Column(name = "ASSET_BALANCE_SHEET_SIZE_AED")
	    private BigDecimal assetBalanceSheetSizeAed;

	    @Column(name = "CASH_AED")
	    private BigDecimal cashAed;

	    @Column(name = "CASH_PERCENT")
	    private BigDecimal cashPercent;

	    @Column(name = "DUE_FROM_CENTRAL_BANK_AED")
	    private BigDecimal dueFromCentralBankAed;

	    @Column(name = "DUE_FROM_CENTRAL_BANK_PERCENT")
	    private BigDecimal dueFromCentralBankPercent;

	    @Column(name = "DUE_FROM_HO_BRANCH_SUBS_AED")
	    private BigDecimal dueFromHoBranchSubsAed;

	    @Column(name = "DUE_FROM_HO_BRANCH_SUBS_PERCENT")
	    private BigDecimal dueFromHoBranchSubsPercent;

	    @Column(name = "DUE_FROM_BANKS_AED")
	    private BigDecimal dueFromBanksAed;

	    @Column(name = "DUE_FROM_BANKS_PERCENT")
	    private BigDecimal dueFromBanksPercent;

	    @Column(name = "DUE_FROM_NBFI_AED")
	    private BigDecimal dueFromNbfiAed;

	    @Column(name = "DUE_FROM_NBFI_PERCENT")
	    private BigDecimal dueFromNbfiPercent;

	    @Column(name = "INVESTMENT_AED")
	    private BigDecimal investmentAed;

	    @Column(name = "INVESTMENT_PERCENT")
	    private BigDecimal investmentPercent;

	    @Column(name = "OTHER_INVESTMENTS_AED")
	    private BigDecimal otherInvestmentsAed;

	    @Column(name = "OTHER_INVESTMENTS_PERCENT")
	    private BigDecimal otherInvestmentsPercent;

	    @Column(name = "NET_CREDIT_PORTFOLIO_AED")
	    private BigDecimal netCreditPortfolioAed;

	    @Column(name = "NET_CREDIT_PORTFOLIO_PERCENT")
	    private BigDecimal netCreditPortfolioPercent;

	    @Column(name = "TRADE_BILLS_AED")
	    private BigDecimal tradeBillsAed;

	    @Column(name = "TRADE_BILLS_PERCENT")
	    private BigDecimal tradeBillsPercent;

	    @Column(name = "NET_FIXED_OTHER_ASSETS_AED")
	    private BigDecimal netFixedOtherAssetsAed;

	    @Column(name = "NET_FIXED_OTHER_ASSETS_PERCENT")
	    private BigDecimal netFixedOtherAssetsPercent;

	    @Column(name = "POSITIVE_FV_DERIVATIVES_AED")
	    private BigDecimal positiveFvDerivativesAed;

	    @Column(name = "POSITIVE_FV_DERIVATIVES_PERCENT")
	    private BigDecimal positiveFvDerivativesPercent;

	    @Column(name = "LIABILITY_BALANCE_SHEET_SIZE_AED")
	    private BigDecimal liabilityBalanceSheetSizeAed;

	    @Column(name = "DUE_TO_CENTRAL_BANK_AED")
	    private BigDecimal dueToCentralBankAed;

	    @Column(name = "DUE_TO_CENTRAL_BANK_PERCENT")
	    private BigDecimal dueToCentralBankPercent;

	    @Column(name = "DUE_TO_HO_BRANCH_SUBS_AED")
	    private BigDecimal dueToHoBranchSubsAed;

	    @Column(name = "DUE_TO_HO_PERCENT")
	    private BigDecimal dueToHoPercent;

	    @Column(name = "DUE_TO_BANKS_AED")
	    private BigDecimal dueToBanksAed;

	    @Column(name = "DUE_TO_BANKS_PERCENT")
	    private BigDecimal dueToBanksPercent;

	    @Column(name = "DUE_TO_NBFI_AED")
	    private BigDecimal dueToNbfiAed;

	    @Column(name = "DUE_TO_NBFI_PERCENT")
	    private BigDecimal dueToNbfiPercent;

	    @Column(name = "CUSTOMER_DEPOSIT_AED")
	    private BigDecimal customerDepositAed;

	    @Column(name = "CUSTOMER_DEPOSIT_PERCENT")
	    private BigDecimal customerDepositPercent;

	    @Column(name = "LONG_TERM_FUNDING_AED")
	    private BigDecimal longTermFundingAed;

	    @Column(name = "LONG_TERM_FUNDING_PERCENT")
	    private BigDecimal longTermFundingPercent;

	    @Column(name = "OTHER_LIABILITIES_AED")
	    private BigDecimal otherLiabilitiesAed;

	    @Column(name = "OTHER_LIABILITIES_PERCENT")
	    private BigDecimal otherLiabilitiesPercent;

	    @Column(name = "NEGATIVE_FV_DERIVATIVES_AED")
	    private BigDecimal negativeFvDerivativesAed;

	    @Column(name = "NEGATIVE_FV_DERIVATIVES_PERCENT")
	    private BigDecimal negativeFvDerivativesPercent;

	    @Column(name = "CAPITAL_RESERVES_AED")
	    private BigDecimal capitalReservesAed;

	    @Column(name = "CAPITAL_RESERVES_PERCENT")
	    private BigDecimal capitalReservesPercent;

	    @Column(name = "SHORT_TERM_REG_RATIO_REQ")
	    private String shortTermRegRatioReq;
	    
	    
	    @Column(name = "HQ_ASSETS_CONVERTED_AED")
	    private BigDecimal hqAssetsConvertedAed;

	    @Column(name = "OUTFLOWS_30D_AED")
	    private BigDecimal outflows30dAed;

	    @Column(name = "INFLOWS_30D_AED")
	    private BigDecimal inflows30dAed;

	    @Column(name = "LCR")
	    private BigDecimal lcr;

	    @Column(name = "AED_HQ_ASSETS")
	    private BigDecimal aedHqAssets;

	    @Column(name = "AED_OUTFLOWS_30D")
	    private BigDecimal aedOutflows30d;

	    @Column(name = "AED_INFLOWS_30D")
	    private BigDecimal aedInflows30d;

	    @Column(name = "AED_LCR")
	    private BigDecimal aedLcr;

	    @Column(name = "USD_HQ_ASSETS")
	    private BigDecimal usdHqAssets;

	    @Column(name = "USD_OUTFLOWS_30D")
	    private BigDecimal usdOutflows30d;

	    @Column(name = "USD_INFLOWS_30D")
	    private BigDecimal usdInflows30d;

	    @Column(name = "USD_LCR")
	    private BigDecimal usdLcr;

	    @Column(name = "ELAR_HQ_ASSETS_CONVERTED_AED")
	    private BigDecimal elarHqAssetsConvertedAed;

	    @Column(name = "TOTAL_LIABILITIES_CONVERTED_AED")
	    private BigDecimal totalLiabilitiesConvertedAed;

	    @Column(name = "ELIGIBLE_ASSET_RATIO")
	    private BigDecimal eligibleAssetRatio;

	    @Column(name = "AED_ELAR_HQ_ASSETS")
	    private BigDecimal aedElarHqAssets;

	    @Column(name = "AED_TOTAL_LIABILITIES")
	    private BigDecimal aedTotalLiabilities;

	    @Column(name = "AED_ELIGIBLR_ASSET_RATIO")
	    private BigDecimal aedEligiblrAssetRatio;

	    @Column(name = "USD_ELAR_HQ_ASSETS")
	    private BigDecimal usdElarHqAssets;

	    @Column(name = "USD_TOTAL_LIABILITIES")
	    private BigDecimal usdTotalLiabilities;

	    @Column(name = "USD_EIGIBLE_ASSET_RATIO")
	    private BigDecimal usdEigibleAssetRatio;

	    @Column(name = "ASF_CONVERTED_AED")
	    private BigDecimal asfConvertedAed;

	    @Column(name = "RSF_CONVERTED_AED")
	    private BigDecimal rsfConvertedAed;

	    @Column(name = "NSFR")
	    private BigDecimal nsfr;

	    @Column(name = "AED_ASF")
	    private BigDecimal aedAsf;

	    @Column(name = "AED_RSF")
	    private BigDecimal aedRsf;

	    @Column(name = "AED_NSFR")
	    private BigDecimal aedNsfr;

	    @Column(name = "USD_ASF")
	    private BigDecimal usdAsf;

	    @Column(name = "USD_RSF")
	    private BigDecimal usdRsf;

	    @Column(name = "USD_NSFR")
	    private BigDecimal usdNsfr;

	    @Column(name = "LOANS_ADVANCES_CONVERTED_AED")
	    private BigDecimal loansAdvancesConvertedAed;

	    @Column(name = "STABLE_RESOURCES_CONVERTED_AED")
	    private BigDecimal stableResourcesConvertedAed;

	    @Column(name = "LOANS_TO_STABLE_RESOURCES_RATIO")
	    private BigDecimal loansToStableResourcesRatio;

	    @Column(name = "AED_LOANS_ADVANCES")
	    private BigDecimal aedLoansAdvances;

	    @Column(name = "AED_STABLE_RESOURCES")
	    private BigDecimal aedStableResources;

	    @Column(name = "AED_LTS_RATIO")
	    private BigDecimal aedLtsRatio;

	    @Column(name = "USD_LOANS_ADVANCES")
	    private BigDecimal usdLoansAdvances;

	    @Column(name = "USD_STABLE_RESOURCES")
	    private BigDecimal usdStableResources;

	    @Column(name = "USD_LTS_RATIO")
	    private BigDecimal usdLtsRatio;

	    @Column(name = "STABLE_TERM_DEPOSIT_AED")
	    private BigDecimal stableTermDepositAed;

	    @Column(name = "VOLATILE_TERM_DEPOSIT_AED")
	    private BigDecimal volatileTermDepositAed;

	    @Column(name = "STABLE_CASA_AED")
	    private BigDecimal stableCasaAed;

	    @Column(name = "VOLATILE_CASA_AED")
	    private BigDecimal volatileCasaAed;

	    @Column(name = "TERM_DEPOSIT_AED")
	    private BigDecimal termDepositAed;

	    @Column(name = "CASA_AED")
	    private BigDecimal casaAed;

	    @Column(name = "LOANS_TO_DEPOSITS_RATIO")
	    private BigDecimal loansToDepositsRatio;

	    @Column(name = "STABLE_TERM_DEPOSIT_TO_ASSETS")
	    private BigDecimal stableTermDepositToAssets;

	    @Column(name = "VOLATILE_TERM_DEPOSIT_TO_ASSETS")
	    private BigDecimal volatileTermDepositToAssets;

	    @Column(name = "STABLE_CASA_TO_ASSETS")
	    private BigDecimal stableCasaToAssets;

	    @Column(name = "VOLATILE_CASA_TO_ASSETS")
	    private BigDecimal volatileCasaToAssets;

	    @Column(name = "LIQUID_ASSETS_TO_TOTAL_DEPOSITS")
	    private BigDecimal liquidAssetsToTotalDeposits;

	    @Column(name = "LIQUID_ASSETS_TO_TOTAL_CASA")
	    private BigDecimal liquidAssetsToTotalCasa;

	    @Column(name = "SIX_MONTH_CASH_FLOW_GAP_AED")
	    private BigDecimal sixMonthCashFlowGapAed;

	    @Column(name = "TOTAL_LIABILITIES_EXCL_CAPITAL")
	    private BigDecimal totalLiabilitiesExclCapital;

	    @Column(name = "SIX_MONTH_GAP_RATIO")
	    private BigDecimal sixMonthGapRatio;

	    @Column(name = "AED_SIX_MONTH_CASH_FLOW_GAP")
	    private BigDecimal aedSixMonthCashFlowGap;

	    @Column(name = "AED_LIABILITIES_EXCL_CAPITAL")
	    private BigDecimal aedLiabilitiesExclCapital;

	    @Column(name = "AED_SIX_MONTH_GAP_RATIO")
	    private BigDecimal aedSixMonthGapRatio;

	    @Column(name = "USD_SIX_MONTH_CASH_FLOW_GAP")
	    private BigDecimal usdSixMonthCashFlowGap;

	    @Column(name = "USD_LIABILITIES_EXCL_CAPITAL")
	    private BigDecimal usdLiabilitiesExclCapital;

	    @Column(name = "USD_SIX_MONTH_GAP_RATIO")
	    private BigDecimal usdSixMonthGapRatio;

	    @Column(name = "THREE_MONTH_CASH_FLOW_GAP_AED")
	    private BigDecimal threeMonthCashFlowGapAed;

	    @Column(name = "THREE_MONTH_GAP_RATIO")
	    private BigDecimal threeMonthGapRatio;

	    @Column(name = "ONE_MONTH_CASH_FLOW_GAP_AED")
	    private BigDecimal oneMonthCashFlowGapAed;

	    @Column(name = "ONE_MONTH_GAP_RATIO")
	    private BigDecimal oneMonthGapRatio;

	    @Column(name = "SEVEN_DAY_CASH_FLOW_GAP_AED")
	    private BigDecimal sevenDayCashFlowGapAed;

	    @Column(name = "SEVEN_DAY_GAP_RATIO")
	    private BigDecimal sevenDayGapRatio;

	    @Column(name = "UNENCUMBERED_LIQUID_ASSETS_AED")
	    private BigDecimal unencumberedLiquidAssetsAed;

	    @Column(name = "ONE_MONTH_CASH_FLOW_GAP_COPY")
	    private BigDecimal oneMonthCashFlowGapCopy;

	    @Column(name = "UNENCUMBERED_TO_1M_GAP_RATIO")
	    private BigDecimal unencumberedTo1mGapRatio;

	    @Column(name = "CBUAE_CASH_BALANCES")
	    private BigDecimal cbuaeCashBalances;

	    @Column(name = "CBUAE_CASH_BALANCES_PERCENT")
	    private BigDecimal cbuaeCashBalancesPercent;

	    @Column(name = "MONEY_MKT_PLACEMENTS_LT_6M")
	    private BigDecimal moneyMktPlacementsLt6m;

	    @Column(name = "MONEY_MKT_PLACEMENTS_LT_6M_PERCENT")
	    private BigDecimal moneyMktPlacementsLt6mPercent;

	    @Column(name = "LOCAL_CURRENCY_GOVT_BONDS")
	    private BigDecimal localCurrencyGovtBonds;

	    @Column(name = "LOCAL_CURRENCY_GOVT_BONDS_PERCENT")
	    private BigDecimal localCurrencyGovtBondsPercent;

	    @Column(name = "HARD_CURRENCY_GOVT_BONDS")
	    private BigDecimal hardCurrencyGovtBonds;

	    @Column(name = "HARD_CURRENCY_GOVT_BONDS_PERCENT")
	    private BigDecimal hardCurrencyGovtBondsPercent;

	    @Column(name = "FOREIGN_GOVT_BONDS")
	    private BigDecimal foreignGovtBonds;

	    @Column(name = "FOREIGN_GOVT_BONDS_PERCENT")
	    private BigDecimal foreignGovtBondsPercent;

	    @Column(name = "PLEDGE_SECURITIES")
	    private BigDecimal pledgeSecurities;

	    @Column(name = "TOTAL_PLEDGEABLE_SECURITIES")
	    private BigDecimal totalPledgeableSecurities;

	    @Column(name = "PLEDGE_RATIO")
	    private BigDecimal pledgeRatio;

	    @Column(name = "TOTAL_COMPLEX_FIN_INSTRUMENTS")
	    private BigDecimal totalComplexFinInstruments;

	    @Column(name = "TOTAL_TRADABLE_ASSETS")
	    private BigDecimal totalTradableAssets;

	    @Column(name = "COMPLEX_TO_TRADABLE_RATIO")
	    private BigDecimal complexToTradableRatio;

	    @Column(name = "TOP_10_DEPOSITS")
	    private BigDecimal top10Deposits;

	    @Column(name = "TOTAL_DEPOSITS_AED1")
	    private BigDecimal totalDepositsAed1;

	    @Column(name = "TOP_10_TO_TOTAL_RATIO")
	    private BigDecimal top10ToTotalRatio;

	    @Column(name = "ST_IB_BORROWING_LT_3M")
	    private BigDecimal stIbBorrowingLt3m;

	    @Column(name = "ST_REPO_LT_3M")
	    private BigDecimal stRepoLt3m;

	    @Column(name = "INTERBANK_BORROWING")
	    private BigDecimal interbankBorrowing;

	    @Column(name = "REPO_AGREEMENTS")
	    private BigDecimal repoAgreements;

	    @Column(name = "TOTAL_DEPOSITS_AED2")
	    private BigDecimal totalDepositsAed2;

	    @Column(name = "LONG_TERM_FUNDING_COPY")
	    private BigDecimal longTermFundingCopy;

	    @Column(name = "ST_IB_REPO_TO_TOTAL_FUNDING_RATIO")
	    private BigDecimal stIbRepoToTotalFundingRatio;

	    @Column(name = "LARGEST_SINGLE_DEPOSITOR")
	    private BigDecimal largestSingleDepositor;

	    @Column(name = "INDIVIDUAL_COUNTERPARTY_TO_TOTAL_FUNDING_RATIO")
	    private BigDecimal individualCounterpartyToTotalFundingRatio;

	    @Column(name = "UNUTILIZED_LOANS_CREDIT_LINES")
	    private BigDecimal unutilizedLoansCreditLines;

	    @Column(name = "DERIVATIVES_EXPECTED_NEG_EXPOSURE")
	    private BigDecimal derivativesExpectedNegExposure;

	    @Column(name = "DERIVATIVES_EXPECTED_NEG_EXPOSURE_PROXY")
	    private BigDecimal derivativesExpectedNegExposureProxy;

	    @Column(name = "CONTINGENT_LIABILITIES")
	    private BigDecimal contingentLiabilities;

	    @Column(name = "CONTINGENT_LIABILITIES_TO_TOTAL_FUNDING_RATIO")
	    private BigDecimal contingentLiabilitiesToTotalFundingRatio;

	    @Column(name = "TOP_5_INDUSTRY_DEPOSITS")
	    private BigDecimal top5IndustryDeposits;

	    @Column(name = "TOP_5_TO_TOTAL_DEPOSITS_RATIO")
	    private BigDecimal top5ToTotalDepositsRatio;

	    @Column(name = "LONG_TERM_LIABILITIES_TO_TOTAL_LIABILITIES_RATIO")
	    private BigDecimal longTermLiabilitiesToTotalLiabilitiesRatio;

	    // Date and meta info fields
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

		public String getSI_NO() {
			return SI_NO;
		}

		public void setSI_NO(String sI_NO) {
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

		public String getLocalForeign() {
			return localForeign;
		}

		public void setLocalForeign(String localForeign) {
			this.localForeign = localForeign;
		}

		public String getCbuAeTiering() {
			return cbuAeTiering;
		}

		public void setCbuAeTiering(String cbuAeTiering) {
			this.cbuAeTiering = cbuAeTiering;
		}

		public BigDecimal getAssetBalanceSheetSizeAed() {
			return assetBalanceSheetSizeAed;
		}

		public void setAssetBalanceSheetSizeAed(BigDecimal assetBalanceSheetSizeAed) {
			this.assetBalanceSheetSizeAed = assetBalanceSheetSizeAed;
		}

		public BigDecimal getCashAed() {
			return cashAed;
		}

		public void setCashAed(BigDecimal cashAed) {
			this.cashAed = cashAed;
		}

		public BigDecimal getCashPercent() {
			return cashPercent;
		}

		public void setCashPercent(BigDecimal cashPercent) {
			this.cashPercent = cashPercent;
		}

		public BigDecimal getDueFromCentralBankAed() {
			return dueFromCentralBankAed;
		}

		public void setDueFromCentralBankAed(BigDecimal dueFromCentralBankAed) {
			this.dueFromCentralBankAed = dueFromCentralBankAed;
		}

		public BigDecimal getDueFromCentralBankPercent() {
			return dueFromCentralBankPercent;
		}

		public void setDueFromCentralBankPercent(BigDecimal dueFromCentralBankPercent) {
			this.dueFromCentralBankPercent = dueFromCentralBankPercent;
		}

		public BigDecimal getDueFromHoBranchSubsAed() {
			return dueFromHoBranchSubsAed;
		}

		public void setDueFromHoBranchSubsAed(BigDecimal dueFromHoBranchSubsAed) {
			this.dueFromHoBranchSubsAed = dueFromHoBranchSubsAed;
		}

		public BigDecimal getDueFromHoBranchSubsPercent() {
			return dueFromHoBranchSubsPercent;
		}

		public void setDueFromHoBranchSubsPercent(BigDecimal dueFromHoBranchSubsPercent) {
			this.dueFromHoBranchSubsPercent = dueFromHoBranchSubsPercent;
		}

		public BigDecimal getDueFromBanksAed() {
			return dueFromBanksAed;
		}

		public void setDueFromBanksAed(BigDecimal dueFromBanksAed) {
			this.dueFromBanksAed = dueFromBanksAed;
		}

		public BigDecimal getDueFromBanksPercent() {
			return dueFromBanksPercent;
		}

		public void setDueFromBanksPercent(BigDecimal dueFromBanksPercent) {
			this.dueFromBanksPercent = dueFromBanksPercent;
		}

		public BigDecimal getDueFromNbfiAed() {
			return dueFromNbfiAed;
		}

		public void setDueFromNbfiAed(BigDecimal dueFromNbfiAed) {
			this.dueFromNbfiAed = dueFromNbfiAed;
		}

		public BigDecimal getDueFromNbfiPercent() {
			return dueFromNbfiPercent;
		}

		public void setDueFromNbfiPercent(BigDecimal dueFromNbfiPercent) {
			this.dueFromNbfiPercent = dueFromNbfiPercent;
		}

		public BigDecimal getInvestmentAed() {
			return investmentAed;
		}

		public void setInvestmentAed(BigDecimal investmentAed) {
			this.investmentAed = investmentAed;
		}

		public BigDecimal getInvestmentPercent() {
			return investmentPercent;
		}

		public void setInvestmentPercent(BigDecimal investmentPercent) {
			this.investmentPercent = investmentPercent;
		}

		public BigDecimal getOtherInvestmentsAed() {
			return otherInvestmentsAed;
		}

		public void setOtherInvestmentsAed(BigDecimal otherInvestmentsAed) {
			this.otherInvestmentsAed = otherInvestmentsAed;
		}

		public BigDecimal getOtherInvestmentsPercent() {
			return otherInvestmentsPercent;
		}

		public void setOtherInvestmentsPercent(BigDecimal otherInvestmentsPercent) {
			this.otherInvestmentsPercent = otherInvestmentsPercent;
		}

		public BigDecimal getNetCreditPortfolioAed() {
			return netCreditPortfolioAed;
		}

		public void setNetCreditPortfolioAed(BigDecimal netCreditPortfolioAed) {
			this.netCreditPortfolioAed = netCreditPortfolioAed;
		}

		public BigDecimal getNetCreditPortfolioPercent() {
			return netCreditPortfolioPercent;
		}

		public void setNetCreditPortfolioPercent(BigDecimal netCreditPortfolioPercent) {
			this.netCreditPortfolioPercent = netCreditPortfolioPercent;
		}

		public BigDecimal getTradeBillsAed() {
			return tradeBillsAed;
		}

		public void setTradeBillsAed(BigDecimal tradeBillsAed) {
			this.tradeBillsAed = tradeBillsAed;
		}

		public BigDecimal getTradeBillsPercent() {
			return tradeBillsPercent;
		}

		public void setTradeBillsPercent(BigDecimal tradeBillsPercent) {
			this.tradeBillsPercent = tradeBillsPercent;
		}

		public BigDecimal getNetFixedOtherAssetsAed() {
			return netFixedOtherAssetsAed;
		}

		public void setNetFixedOtherAssetsAed(BigDecimal netFixedOtherAssetsAed) {
			this.netFixedOtherAssetsAed = netFixedOtherAssetsAed;
		}

		public BigDecimal getNetFixedOtherAssetsPercent() {
			return netFixedOtherAssetsPercent;
		}

		public void setNetFixedOtherAssetsPercent(BigDecimal netFixedOtherAssetsPercent) {
			this.netFixedOtherAssetsPercent = netFixedOtherAssetsPercent;
		}

		public BigDecimal getPositiveFvDerivativesAed() {
			return positiveFvDerivativesAed;
		}

		public void setPositiveFvDerivativesAed(BigDecimal positiveFvDerivativesAed) {
			this.positiveFvDerivativesAed = positiveFvDerivativesAed;
		}

		public BigDecimal getPositiveFvDerivativesPercent() {
			return positiveFvDerivativesPercent;
		}

		public void setPositiveFvDerivativesPercent(BigDecimal positiveFvDerivativesPercent) {
			this.positiveFvDerivativesPercent = positiveFvDerivativesPercent;
		}

		public BigDecimal getLiabilityBalanceSheetSizeAed() {
			return liabilityBalanceSheetSizeAed;
		}

		public void setLiabilityBalanceSheetSizeAed(BigDecimal liabilityBalanceSheetSizeAed) {
			this.liabilityBalanceSheetSizeAed = liabilityBalanceSheetSizeAed;
		}

		public BigDecimal getDueToCentralBankAed() {
			return dueToCentralBankAed;
		}

		public void setDueToCentralBankAed(BigDecimal dueToCentralBankAed) {
			this.dueToCentralBankAed = dueToCentralBankAed;
		}

		public BigDecimal getDueToCentralBankPercent() {
			return dueToCentralBankPercent;
		}

		public void setDueToCentralBankPercent(BigDecimal dueToCentralBankPercent) {
			this.dueToCentralBankPercent = dueToCentralBankPercent;
		}

		public BigDecimal getDueToHoBranchSubsAed() {
			return dueToHoBranchSubsAed;
		}

		public void setDueToHoBranchSubsAed(BigDecimal dueToHoBranchSubsAed) {
			this.dueToHoBranchSubsAed = dueToHoBranchSubsAed;
		}

		public BigDecimal getDueToHoPercent() {
			return dueToHoPercent;
		}

		public void setDueToHoPercent(BigDecimal dueToHoPercent) {
			this.dueToHoPercent = dueToHoPercent;
		}

		public BigDecimal getDueToBanksAed() {
			return dueToBanksAed;
		}

		public void setDueToBanksAed(BigDecimal dueToBanksAed) {
			this.dueToBanksAed = dueToBanksAed;
		}

		public BigDecimal getDueToBanksPercent() {
			return dueToBanksPercent;
		}

		public void setDueToBanksPercent(BigDecimal dueToBanksPercent) {
			this.dueToBanksPercent = dueToBanksPercent;
		}

		public BigDecimal getDueToNbfiAed() {
			return dueToNbfiAed;
		}

		public void setDueToNbfiAed(BigDecimal dueToNbfiAed) {
			this.dueToNbfiAed = dueToNbfiAed;
		}

		public BigDecimal getDueToNbfiPercent() {
			return dueToNbfiPercent;
		}

		public void setDueToNbfiPercent(BigDecimal dueToNbfiPercent) {
			this.dueToNbfiPercent = dueToNbfiPercent;
		}

		public BigDecimal getCustomerDepositAed() {
			return customerDepositAed;
		}

		public void setCustomerDepositAed(BigDecimal customerDepositAed) {
			this.customerDepositAed = customerDepositAed;
		}

		public BigDecimal getCustomerDepositPercent() {
			return customerDepositPercent;
		}

		public void setCustomerDepositPercent(BigDecimal customerDepositPercent) {
			this.customerDepositPercent = customerDepositPercent;
		}

		public BigDecimal getLongTermFundingAed() {
			return longTermFundingAed;
		}

		public void setLongTermFundingAed(BigDecimal longTermFundingAed) {
			this.longTermFundingAed = longTermFundingAed;
		}

		public BigDecimal getLongTermFundingPercent() {
			return longTermFundingPercent;
		}

		public void setLongTermFundingPercent(BigDecimal longTermFundingPercent) {
			this.longTermFundingPercent = longTermFundingPercent;
		}

		public BigDecimal getOtherLiabilitiesAed() {
			return otherLiabilitiesAed;
		}

		public void setOtherLiabilitiesAed(BigDecimal otherLiabilitiesAed) {
			this.otherLiabilitiesAed = otherLiabilitiesAed;
		}

		public BigDecimal getOtherLiabilitiesPercent() {
			return otherLiabilitiesPercent;
		}

		public void setOtherLiabilitiesPercent(BigDecimal otherLiabilitiesPercent) {
			this.otherLiabilitiesPercent = otherLiabilitiesPercent;
		}

		public BigDecimal getNegativeFvDerivativesAed() {
			return negativeFvDerivativesAed;
		}

		public void setNegativeFvDerivativesAed(BigDecimal negativeFvDerivativesAed) {
			this.negativeFvDerivativesAed = negativeFvDerivativesAed;
		}

		public BigDecimal getNegativeFvDerivativesPercent() {
			return negativeFvDerivativesPercent;
		}

		public void setNegativeFvDerivativesPercent(BigDecimal negativeFvDerivativesPercent) {
			this.negativeFvDerivativesPercent = negativeFvDerivativesPercent;
		}

		public BigDecimal getCapitalReservesAed() {
			return capitalReservesAed;
		}

		public void setCapitalReservesAed(BigDecimal capitalReservesAed) {
			this.capitalReservesAed = capitalReservesAed;
		}

		public BigDecimal getCapitalReservesPercent() {
			return capitalReservesPercent;
		}

		public void setCapitalReservesPercent(BigDecimal capitalReservesPercent) {
			this.capitalReservesPercent = capitalReservesPercent;
		}

		public String getShortTermRegRatioReq() {
			return shortTermRegRatioReq;
		}

		public void setShortTermRegRatioReq(String shortTermRegRatioReq) {
			this.shortTermRegRatioReq = shortTermRegRatioReq;
		}

		public BigDecimal getHqAssetsConvertedAed() {
			return hqAssetsConvertedAed;
		}

		public void setHqAssetsConvertedAed(BigDecimal hqAssetsConvertedAed) {
			this.hqAssetsConvertedAed = hqAssetsConvertedAed;
		}

		public BigDecimal getOutflows30dAed() {
			return outflows30dAed;
		}

		public void setOutflows30dAed(BigDecimal outflows30dAed) {
			this.outflows30dAed = outflows30dAed;
		}

		public BigDecimal getInflows30dAed() {
			return inflows30dAed;
		}

		public void setInflows30dAed(BigDecimal inflows30dAed) {
			this.inflows30dAed = inflows30dAed;
		}

		public BigDecimal getLcr() {
			return lcr;
		}

		public void setLcr(BigDecimal lcr) {
			this.lcr = lcr;
		}

		public BigDecimal getAedHqAssets() {
			return aedHqAssets;
		}

		public void setAedHqAssets(BigDecimal aedHqAssets) {
			this.aedHqAssets = aedHqAssets;
		}

		public BigDecimal getAedOutflows30d() {
			return aedOutflows30d;
		}

		public void setAedOutflows30d(BigDecimal aedOutflows30d) {
			this.aedOutflows30d = aedOutflows30d;
		}

		public BigDecimal getAedInflows30d() {
			return aedInflows30d;
		}

		public void setAedInflows30d(BigDecimal aedInflows30d) {
			this.aedInflows30d = aedInflows30d;
		}

		public BigDecimal getAedLcr() {
			return aedLcr;
		}

		public void setAedLcr(BigDecimal aedLcr) {
			this.aedLcr = aedLcr;
		}

		public BigDecimal getUsdHqAssets() {
			return usdHqAssets;
		}

		public void setUsdHqAssets(BigDecimal usdHqAssets) {
			this.usdHqAssets = usdHqAssets;
		}

		public BigDecimal getUsdOutflows30d() {
			return usdOutflows30d;
		}

		public void setUsdOutflows30d(BigDecimal usdOutflows30d) {
			this.usdOutflows30d = usdOutflows30d;
		}

		public BigDecimal getUsdInflows30d() {
			return usdInflows30d;
		}

		public void setUsdInflows30d(BigDecimal usdInflows30d) {
			this.usdInflows30d = usdInflows30d;
		}

		public BigDecimal getUsdLcr() {
			return usdLcr;
		}

		public void setUsdLcr(BigDecimal usdLcr) {
			this.usdLcr = usdLcr;
		}

		public BigDecimal getElarHqAssetsConvertedAed() {
			return elarHqAssetsConvertedAed;
		}

		public void setElarHqAssetsConvertedAed(BigDecimal elarHqAssetsConvertedAed) {
			this.elarHqAssetsConvertedAed = elarHqAssetsConvertedAed;
		}

		public BigDecimal getTotalLiabilitiesConvertedAed() {
			return totalLiabilitiesConvertedAed;
		}

		public void setTotalLiabilitiesConvertedAed(BigDecimal totalLiabilitiesConvertedAed) {
			this.totalLiabilitiesConvertedAed = totalLiabilitiesConvertedAed;
		}

		public BigDecimal getEligibleAssetRatio() {
			return eligibleAssetRatio;
		}

		public void setEligibleAssetRatio(BigDecimal eligibleAssetRatio) {
			this.eligibleAssetRatio = eligibleAssetRatio;
		}

		public BigDecimal getAedElarHqAssets() {
			return aedElarHqAssets;
		}

		public void setAedElarHqAssets(BigDecimal aedElarHqAssets) {
			this.aedElarHqAssets = aedElarHqAssets;
		}

		public BigDecimal getAedTotalLiabilities() {
			return aedTotalLiabilities;
		}

		public void setAedTotalLiabilities(BigDecimal aedTotalLiabilities) {
			this.aedTotalLiabilities = aedTotalLiabilities;
		}

		public BigDecimal getAedEligiblrAssetRatio() {
			return aedEligiblrAssetRatio;
		}

		public void setAedEligiblrAssetRatio(BigDecimal aedEligiblrAssetRatio) {
			this.aedEligiblrAssetRatio = aedEligiblrAssetRatio;
		}

		public BigDecimal getUsdElarHqAssets() {
			return usdElarHqAssets;
		}

		public void setUsdElarHqAssets(BigDecimal usdElarHqAssets) {
			this.usdElarHqAssets = usdElarHqAssets;
		}

		public BigDecimal getUsdTotalLiabilities() {
			return usdTotalLiabilities;
		}

		public void setUsdTotalLiabilities(BigDecimal usdTotalLiabilities) {
			this.usdTotalLiabilities = usdTotalLiabilities;
		}

		public BigDecimal getUsdEigibleAssetRatio() {
			return usdEigibleAssetRatio;
		}

		public void setUsdEigibleAssetRatio(BigDecimal usdEigibleAssetRatio) {
			this.usdEigibleAssetRatio = usdEigibleAssetRatio;
		}

		public BigDecimal getAsfConvertedAed() {
			return asfConvertedAed;
		}

		public void setAsfConvertedAed(BigDecimal asfConvertedAed) {
			this.asfConvertedAed = asfConvertedAed;
		}

		public BigDecimal getRsfConvertedAed() {
			return rsfConvertedAed;
		}

		public void setRsfConvertedAed(BigDecimal rsfConvertedAed) {
			this.rsfConvertedAed = rsfConvertedAed;
		}

		public BigDecimal getNsfr() {
			return nsfr;
		}

		public void setNsfr(BigDecimal nsfr) {
			this.nsfr = nsfr;
		}

		public BigDecimal getAedAsf() {
			return aedAsf;
		}

		public void setAedAsf(BigDecimal aedAsf) {
			this.aedAsf = aedAsf;
		}

		public BigDecimal getAedRsf() {
			return aedRsf;
		}

		public void setAedRsf(BigDecimal aedRsf) {
			this.aedRsf = aedRsf;
		}

		public BigDecimal getAedNsfr() {
			return aedNsfr;
		}

		public void setAedNsfr(BigDecimal aedNsfr) {
			this.aedNsfr = aedNsfr;
		}

		public BigDecimal getUsdAsf() {
			return usdAsf;
		}

		public void setUsdAsf(BigDecimal usdAsf) {
			this.usdAsf = usdAsf;
		}

		public BigDecimal getUsdRsf() {
			return usdRsf;
		}

		public void setUsdRsf(BigDecimal usdRsf) {
			this.usdRsf = usdRsf;
		}

		public BigDecimal getUsdNsfr() {
			return usdNsfr;
		}

		public void setUsdNsfr(BigDecimal usdNsfr) {
			this.usdNsfr = usdNsfr;
		}

		public BigDecimal getLoansAdvancesConvertedAed() {
			return loansAdvancesConvertedAed;
		}

		public void setLoansAdvancesConvertedAed(BigDecimal loansAdvancesConvertedAed) {
			this.loansAdvancesConvertedAed = loansAdvancesConvertedAed;
		}

		public BigDecimal getStableResourcesConvertedAed() {
			return stableResourcesConvertedAed;
		}

		public void setStableResourcesConvertedAed(BigDecimal stableResourcesConvertedAed) {
			this.stableResourcesConvertedAed = stableResourcesConvertedAed;
		}

		public BigDecimal getLoansToStableResourcesRatio() {
			return loansToStableResourcesRatio;
		}

		public void setLoansToStableResourcesRatio(BigDecimal loansToStableResourcesRatio) {
			this.loansToStableResourcesRatio = loansToStableResourcesRatio;
		}

		public BigDecimal getAedLoansAdvances() {
			return aedLoansAdvances;
		}

		public void setAedLoansAdvances(BigDecimal aedLoansAdvances) {
			this.aedLoansAdvances = aedLoansAdvances;
		}

		public BigDecimal getAedStableResources() {
			return aedStableResources;
		}

		public void setAedStableResources(BigDecimal aedStableResources) {
			this.aedStableResources = aedStableResources;
		}

		public BigDecimal getAedLtsRatio() {
			return aedLtsRatio;
		}

		public void setAedLtsRatio(BigDecimal aedLtsRatio) {
			this.aedLtsRatio = aedLtsRatio;
		}

		public BigDecimal getUsdLoansAdvances() {
			return usdLoansAdvances;
		}

		public void setUsdLoansAdvances(BigDecimal usdLoansAdvances) {
			this.usdLoansAdvances = usdLoansAdvances;
		}

		public BigDecimal getUsdStableResources() {
			return usdStableResources;
		}

		public void setUsdStableResources(BigDecimal usdStableResources) {
			this.usdStableResources = usdStableResources;
		}

		public BigDecimal getUsdLtsRatio() {
			return usdLtsRatio;
		}

		public void setUsdLtsRatio(BigDecimal usdLtsRatio) {
			this.usdLtsRatio = usdLtsRatio;
		}

		public BigDecimal getStableTermDepositAed() {
			return stableTermDepositAed;
		}

		public void setStableTermDepositAed(BigDecimal stableTermDepositAed) {
			this.stableTermDepositAed = stableTermDepositAed;
		}

		public BigDecimal getVolatileTermDepositAed() {
			return volatileTermDepositAed;
		}

		public void setVolatileTermDepositAed(BigDecimal volatileTermDepositAed) {
			this.volatileTermDepositAed = volatileTermDepositAed;
		}

		public BigDecimal getStableCasaAed() {
			return stableCasaAed;
		}

		public void setStableCasaAed(BigDecimal stableCasaAed) {
			this.stableCasaAed = stableCasaAed;
		}

		public BigDecimal getVolatileCasaAed() {
			return volatileCasaAed;
		}

		public void setVolatileCasaAed(BigDecimal volatileCasaAed) {
			this.volatileCasaAed = volatileCasaAed;
		}

		public BigDecimal getTermDepositAed() {
			return termDepositAed;
		}

		public void setTermDepositAed(BigDecimal termDepositAed) {
			this.termDepositAed = termDepositAed;
		}

		public BigDecimal getCasaAed() {
			return casaAed;
		}

		public void setCasaAed(BigDecimal casaAed) {
			this.casaAed = casaAed;
		}

		public BigDecimal getLoansToDepositsRatio() {
			return loansToDepositsRatio;
		}

		public void setLoansToDepositsRatio(BigDecimal loansToDepositsRatio) {
			this.loansToDepositsRatio = loansToDepositsRatio;
		}

		public BigDecimal getStableTermDepositToAssets() {
			return stableTermDepositToAssets;
		}

		public void setStableTermDepositToAssets(BigDecimal stableTermDepositToAssets) {
			this.stableTermDepositToAssets = stableTermDepositToAssets;
		}

		public BigDecimal getVolatileTermDepositToAssets() {
			return volatileTermDepositToAssets;
		}

		public void setVolatileTermDepositToAssets(BigDecimal volatileTermDepositToAssets) {
			this.volatileTermDepositToAssets = volatileTermDepositToAssets;
		}

		public BigDecimal getStableCasaToAssets() {
			return stableCasaToAssets;
		}

		public void setStableCasaToAssets(BigDecimal stableCasaToAssets) {
			this.stableCasaToAssets = stableCasaToAssets;
		}

		public BigDecimal getVolatileCasaToAssets() {
			return volatileCasaToAssets;
		}

		public void setVolatileCasaToAssets(BigDecimal volatileCasaToAssets) {
			this.volatileCasaToAssets = volatileCasaToAssets;
		}

		public BigDecimal getLiquidAssetsToTotalDeposits() {
			return liquidAssetsToTotalDeposits;
		}

		public void setLiquidAssetsToTotalDeposits(BigDecimal liquidAssetsToTotalDeposits) {
			this.liquidAssetsToTotalDeposits = liquidAssetsToTotalDeposits;
		}

		public BigDecimal getLiquidAssetsToTotalCasa() {
			return liquidAssetsToTotalCasa;
		}

		public void setLiquidAssetsToTotalCasa(BigDecimal liquidAssetsToTotalCasa) {
			this.liquidAssetsToTotalCasa = liquidAssetsToTotalCasa;
		}

		public BigDecimal getSixMonthCashFlowGapAed() {
			return sixMonthCashFlowGapAed;
		}

		public void setSixMonthCashFlowGapAed(BigDecimal sixMonthCashFlowGapAed) {
			this.sixMonthCashFlowGapAed = sixMonthCashFlowGapAed;
		}

		public BigDecimal getTotalLiabilitiesExclCapital() {
			return totalLiabilitiesExclCapital;
		}

		public void setTotalLiabilitiesExclCapital(BigDecimal totalLiabilitiesExclCapital) {
			this.totalLiabilitiesExclCapital = totalLiabilitiesExclCapital;
		}

		public BigDecimal getSixMonthGapRatio() {
			return sixMonthGapRatio;
		}

		public void setSixMonthGapRatio(BigDecimal sixMonthGapRatio) {
			this.sixMonthGapRatio = sixMonthGapRatio;
		}

		public BigDecimal getAedSixMonthCashFlowGap() {
			return aedSixMonthCashFlowGap;
		}

		public void setAedSixMonthCashFlowGap(BigDecimal aedSixMonthCashFlowGap) {
			this.aedSixMonthCashFlowGap = aedSixMonthCashFlowGap;
		}

		public BigDecimal getAedLiabilitiesExclCapital() {
			return aedLiabilitiesExclCapital;
		}

		public void setAedLiabilitiesExclCapital(BigDecimal aedLiabilitiesExclCapital) {
			this.aedLiabilitiesExclCapital = aedLiabilitiesExclCapital;
		}

		public BigDecimal getAedSixMonthGapRatio() {
			return aedSixMonthGapRatio;
		}

		public void setAedSixMonthGapRatio(BigDecimal aedSixMonthGapRatio) {
			this.aedSixMonthGapRatio = aedSixMonthGapRatio;
		}

		public BigDecimal getUsdSixMonthCashFlowGap() {
			return usdSixMonthCashFlowGap;
		}

		public void setUsdSixMonthCashFlowGap(BigDecimal usdSixMonthCashFlowGap) {
			this.usdSixMonthCashFlowGap = usdSixMonthCashFlowGap;
		}

		public BigDecimal getUsdLiabilitiesExclCapital() {
			return usdLiabilitiesExclCapital;
		}

		public void setUsdLiabilitiesExclCapital(BigDecimal usdLiabilitiesExclCapital) {
			this.usdLiabilitiesExclCapital = usdLiabilitiesExclCapital;
		}

		public BigDecimal getUsdSixMonthGapRatio() {
			return usdSixMonthGapRatio;
		}

		public void setUsdSixMonthGapRatio(BigDecimal usdSixMonthGapRatio) {
			this.usdSixMonthGapRatio = usdSixMonthGapRatio;
		}

		public BigDecimal getThreeMonthCashFlowGapAed() {
			return threeMonthCashFlowGapAed;
		}

		public void setThreeMonthCashFlowGapAed(BigDecimal threeMonthCashFlowGapAed) {
			this.threeMonthCashFlowGapAed = threeMonthCashFlowGapAed;
		}

		public BigDecimal getThreeMonthGapRatio() {
			return threeMonthGapRatio;
		}

		public void setThreeMonthGapRatio(BigDecimal threeMonthGapRatio) {
			this.threeMonthGapRatio = threeMonthGapRatio;
		}

		public BigDecimal getOneMonthCashFlowGapAed() {
			return oneMonthCashFlowGapAed;
		}

		public void setOneMonthCashFlowGapAed(BigDecimal oneMonthCashFlowGapAed) {
			this.oneMonthCashFlowGapAed = oneMonthCashFlowGapAed;
		}

		public BigDecimal getOneMonthGapRatio() {
			return oneMonthGapRatio;
		}

		public void setOneMonthGapRatio(BigDecimal oneMonthGapRatio) {
			this.oneMonthGapRatio = oneMonthGapRatio;
		}

		public BigDecimal getSevenDayCashFlowGapAed() {
			return sevenDayCashFlowGapAed;
		}

		public void setSevenDayCashFlowGapAed(BigDecimal sevenDayCashFlowGapAed) {
			this.sevenDayCashFlowGapAed = sevenDayCashFlowGapAed;
		}

		public BigDecimal getSevenDayGapRatio() {
			return sevenDayGapRatio;
		}

		public void setSevenDayGapRatio(BigDecimal sevenDayGapRatio) {
			this.sevenDayGapRatio = sevenDayGapRatio;
		}

		public BigDecimal getUnencumberedLiquidAssetsAed() {
			return unencumberedLiquidAssetsAed;
		}

		public void setUnencumberedLiquidAssetsAed(BigDecimal unencumberedLiquidAssetsAed) {
			this.unencumberedLiquidAssetsAed = unencumberedLiquidAssetsAed;
		}

		public BigDecimal getOneMonthCashFlowGapCopy() {
			return oneMonthCashFlowGapCopy;
		}

		public void setOneMonthCashFlowGapCopy(BigDecimal oneMonthCashFlowGapCopy) {
			this.oneMonthCashFlowGapCopy = oneMonthCashFlowGapCopy;
		}

		public BigDecimal getUnencumberedTo1mGapRatio() {
			return unencumberedTo1mGapRatio;
		}

		public void setUnencumberedTo1mGapRatio(BigDecimal unencumberedTo1mGapRatio) {
			this.unencumberedTo1mGapRatio = unencumberedTo1mGapRatio;
		}

		public BigDecimal getCbuaeCashBalances() {
			return cbuaeCashBalances;
		}

		public void setCbuaeCashBalances(BigDecimal cbuaeCashBalances) {
			this.cbuaeCashBalances = cbuaeCashBalances;
		}

		public BigDecimal getCbuaeCashBalancesPercent() {
			return cbuaeCashBalancesPercent;
		}

		public void setCbuaeCashBalancesPercent(BigDecimal cbuaeCashBalancesPercent) {
			this.cbuaeCashBalancesPercent = cbuaeCashBalancesPercent;
		}

		public BigDecimal getMoneyMktPlacementsLt6m() {
			return moneyMktPlacementsLt6m;
		}

		public void setMoneyMktPlacementsLt6m(BigDecimal moneyMktPlacementsLt6m) {
			this.moneyMktPlacementsLt6m = moneyMktPlacementsLt6m;
		}

		public BigDecimal getMoneyMktPlacementsLt6mPercent() {
			return moneyMktPlacementsLt6mPercent;
		}

		public void setMoneyMktPlacementsLt6mPercent(BigDecimal moneyMktPlacementsLt6mPercent) {
			this.moneyMktPlacementsLt6mPercent = moneyMktPlacementsLt6mPercent;
		}

		public BigDecimal getLocalCurrencyGovtBonds() {
			return localCurrencyGovtBonds;
		}

		public void setLocalCurrencyGovtBonds(BigDecimal localCurrencyGovtBonds) {
			this.localCurrencyGovtBonds = localCurrencyGovtBonds;
		}

		public BigDecimal getLocalCurrencyGovtBondsPercent() {
			return localCurrencyGovtBondsPercent;
		}

		public void setLocalCurrencyGovtBondsPercent(BigDecimal localCurrencyGovtBondsPercent) {
			this.localCurrencyGovtBondsPercent = localCurrencyGovtBondsPercent;
		}

		public BigDecimal getHardCurrencyGovtBonds() {
			return hardCurrencyGovtBonds;
		}

		public void setHardCurrencyGovtBonds(BigDecimal hardCurrencyGovtBonds) {
			this.hardCurrencyGovtBonds = hardCurrencyGovtBonds;
		}

		public BigDecimal getHardCurrencyGovtBondsPercent() {
			return hardCurrencyGovtBondsPercent;
		}

		public void setHardCurrencyGovtBondsPercent(BigDecimal hardCurrencyGovtBondsPercent) {
			this.hardCurrencyGovtBondsPercent = hardCurrencyGovtBondsPercent;
		}

		public BigDecimal getForeignGovtBonds() {
			return foreignGovtBonds;
		}

		public void setForeignGovtBonds(BigDecimal foreignGovtBonds) {
			this.foreignGovtBonds = foreignGovtBonds;
		}

		public BigDecimal getForeignGovtBondsPercent() {
			return foreignGovtBondsPercent;
		}

		public void setForeignGovtBondsPercent(BigDecimal foreignGovtBondsPercent) {
			this.foreignGovtBondsPercent = foreignGovtBondsPercent;
		}

		public BigDecimal getPledgeSecurities() {
			return pledgeSecurities;
		}

		public void setPledgeSecurities(BigDecimal pledgeSecurities) {
			this.pledgeSecurities = pledgeSecurities;
		}

		public BigDecimal getTotalPledgeableSecurities() {
			return totalPledgeableSecurities;
		}

		public void setTotalPledgeableSecurities(BigDecimal totalPledgeableSecurities) {
			this.totalPledgeableSecurities = totalPledgeableSecurities;
		}

		public BigDecimal getPledgeRatio() {
			return pledgeRatio;
		}

		public void setPledgeRatio(BigDecimal pledgeRatio) {
			this.pledgeRatio = pledgeRatio;
		}

		public BigDecimal getTotalComplexFinInstruments() {
			return totalComplexFinInstruments;
		}

		public void setTotalComplexFinInstruments(BigDecimal totalComplexFinInstruments) {
			this.totalComplexFinInstruments = totalComplexFinInstruments;
		}

		public BigDecimal getTotalTradableAssets() {
			return totalTradableAssets;
		}

		public void setTotalTradableAssets(BigDecimal totalTradableAssets) {
			this.totalTradableAssets = totalTradableAssets;
		}

		public BigDecimal getComplexToTradableRatio() {
			return complexToTradableRatio;
		}

		public void setComplexToTradableRatio(BigDecimal complexToTradableRatio) {
			this.complexToTradableRatio = complexToTradableRatio;
		}

		public BigDecimal getTop10Deposits() {
			return top10Deposits;
		}

		public void setTop10Deposits(BigDecimal top10Deposits) {
			this.top10Deposits = top10Deposits;
		}

		public BigDecimal getTotalDepositsAed1() {
			return totalDepositsAed1;
		}

		public void setTotalDepositsAed1(BigDecimal totalDepositsAed1) {
			this.totalDepositsAed1 = totalDepositsAed1;
		}

		public BigDecimal getTop10ToTotalRatio() {
			return top10ToTotalRatio;
		}

		public void setTop10ToTotalRatio(BigDecimal top10ToTotalRatio) {
			this.top10ToTotalRatio = top10ToTotalRatio;
		}

		public BigDecimal getStIbBorrowingLt3m() {
			return stIbBorrowingLt3m;
		}

		public void setStIbBorrowingLt3m(BigDecimal stIbBorrowingLt3m) {
			this.stIbBorrowingLt3m = stIbBorrowingLt3m;
		}

		public BigDecimal getStRepoLt3m() {
			return stRepoLt3m;
		}

		public void setStRepoLt3m(BigDecimal stRepoLt3m) {
			this.stRepoLt3m = stRepoLt3m;
		}

		public BigDecimal getInterbankBorrowing() {
			return interbankBorrowing;
		}

		public void setInterbankBorrowing(BigDecimal interbankBorrowing) {
			this.interbankBorrowing = interbankBorrowing;
		}

		public BigDecimal getRepoAgreements() {
			return repoAgreements;
		}

		public void setRepoAgreements(BigDecimal repoAgreements) {
			this.repoAgreements = repoAgreements;
		}

		public BigDecimal getTotalDepositsAed2() {
			return totalDepositsAed2;
		}

		public void setTotalDepositsAed2(BigDecimal totalDepositsAed2) {
			this.totalDepositsAed2 = totalDepositsAed2;
		}

		public BigDecimal getLongTermFundingCopy() {
			return longTermFundingCopy;
		}

		public void setLongTermFundingCopy(BigDecimal longTermFundingCopy) {
			this.longTermFundingCopy = longTermFundingCopy;
		}

		public BigDecimal getStIbRepoToTotalFundingRatio() {
			return stIbRepoToTotalFundingRatio;
		}

		public void setStIbRepoToTotalFundingRatio(BigDecimal stIbRepoToTotalFundingRatio) {
			this.stIbRepoToTotalFundingRatio = stIbRepoToTotalFundingRatio;
		}

		public BigDecimal getLargestSingleDepositor() {
			return largestSingleDepositor;
		}

		public void setLargestSingleDepositor(BigDecimal largestSingleDepositor) {
			this.largestSingleDepositor = largestSingleDepositor;
		}

		public BigDecimal getIndividualCounterpartyToTotalFundingRatio() {
			return individualCounterpartyToTotalFundingRatio;
		}

		public void setIndividualCounterpartyToTotalFundingRatio(BigDecimal individualCounterpartyToTotalFundingRatio) {
			this.individualCounterpartyToTotalFundingRatio = individualCounterpartyToTotalFundingRatio;
		}

		public BigDecimal getUnutilizedLoansCreditLines() {
			return unutilizedLoansCreditLines;
		}

		public void setUnutilizedLoansCreditLines(BigDecimal unutilizedLoansCreditLines) {
			this.unutilizedLoansCreditLines = unutilizedLoansCreditLines;
		}

		public BigDecimal getDerivativesExpectedNegExposure() {
			return derivativesExpectedNegExposure;
		}

		public void setDerivativesExpectedNegExposure(BigDecimal derivativesExpectedNegExposure) {
			this.derivativesExpectedNegExposure = derivativesExpectedNegExposure;
		}

		public BigDecimal getDerivativesExpectedNegExposureProxy() {
			return derivativesExpectedNegExposureProxy;
		}

		public void setDerivativesExpectedNegExposureProxy(BigDecimal derivativesExpectedNegExposureProxy) {
			this.derivativesExpectedNegExposureProxy = derivativesExpectedNegExposureProxy;
		}

		public BigDecimal getContingentLiabilities() {
			return contingentLiabilities;
		}

		public void setContingentLiabilities(BigDecimal contingentLiabilities) {
			this.contingentLiabilities = contingentLiabilities;
		}

		public BigDecimal getContingentLiabilitiesToTotalFundingRatio() {
			return contingentLiabilitiesToTotalFundingRatio;
		}

		public void setContingentLiabilitiesToTotalFundingRatio(BigDecimal contingentLiabilitiesToTotalFundingRatio) {
			this.contingentLiabilitiesToTotalFundingRatio = contingentLiabilitiesToTotalFundingRatio;
		}

		public BigDecimal getTop5IndustryDeposits() {
			return top5IndustryDeposits;
		}

		public void setTop5IndustryDeposits(BigDecimal top5IndustryDeposits) {
			this.top5IndustryDeposits = top5IndustryDeposits;
		}

		public BigDecimal getTop5ToTotalDepositsRatio() {
			return top5ToTotalDepositsRatio;
		}

		public void setTop5ToTotalDepositsRatio(BigDecimal top5ToTotalDepositsRatio) {
			this.top5ToTotalDepositsRatio = top5ToTotalDepositsRatio;
		}

		public BigDecimal getLongTermLiabilitiesToTotalLiabilitiesRatio() {
			return longTermLiabilitiesToTotalLiabilitiesRatio;
		}

		public void setLongTermLiabilitiesToTotalLiabilitiesRatio(BigDecimal longTermLiabilitiesToTotalLiabilitiesRatio) {
			this.longTermLiabilitiesToTotalLiabilitiesRatio = longTermLiabilitiesToTotalLiabilitiesRatio;
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

		public RT_Liquidity_Risk_Dashboard_Template(String sI_NO, Date reportDate, String bankName,
				String groupHeadOfficeSubsidiary, String subsidiary, String bankSymbol, String conventionalIslamic,
				String localForeign, String cbuAeTiering, BigDecimal assetBalanceSheetSizeAed, BigDecimal cashAed,
				BigDecimal cashPercent, BigDecimal dueFromCentralBankAed, BigDecimal dueFromCentralBankPercent,
				BigDecimal dueFromHoBranchSubsAed, BigDecimal dueFromHoBranchSubsPercent, BigDecimal dueFromBanksAed,
				BigDecimal dueFromBanksPercent, BigDecimal dueFromNbfiAed, BigDecimal dueFromNbfiPercent,
				BigDecimal investmentAed, BigDecimal investmentPercent, BigDecimal otherInvestmentsAed,
				BigDecimal otherInvestmentsPercent, BigDecimal netCreditPortfolioAed,
				BigDecimal netCreditPortfolioPercent, BigDecimal tradeBillsAed, BigDecimal tradeBillsPercent,
				BigDecimal netFixedOtherAssetsAed, BigDecimal netFixedOtherAssetsPercent,
				BigDecimal positiveFvDerivativesAed, BigDecimal positiveFvDerivativesPercent,
				BigDecimal liabilityBalanceSheetSizeAed, BigDecimal dueToCentralBankAed,
				BigDecimal dueToCentralBankPercent, BigDecimal dueToHoBranchSubsAed, BigDecimal dueToHoPercent,
				BigDecimal dueToBanksAed, BigDecimal dueToBanksPercent, BigDecimal dueToNbfiAed,
				BigDecimal dueToNbfiPercent, BigDecimal customerDepositAed, BigDecimal customerDepositPercent,
				BigDecimal longTermFundingAed, BigDecimal longTermFundingPercent, BigDecimal otherLiabilitiesAed,
				BigDecimal otherLiabilitiesPercent, BigDecimal negativeFvDerivativesAed,
				BigDecimal negativeFvDerivativesPercent, BigDecimal capitalReservesAed,
				BigDecimal capitalReservesPercent, String shortTermRegRatioReq, BigDecimal hqAssetsConvertedAed,
				BigDecimal outflows30dAed, BigDecimal inflows30dAed, BigDecimal lcr, BigDecimal aedHqAssets,
				BigDecimal aedOutflows30d, BigDecimal aedInflows30d, BigDecimal aedLcr, BigDecimal usdHqAssets,
				BigDecimal usdOutflows30d, BigDecimal usdInflows30d, BigDecimal usdLcr,
				BigDecimal elarHqAssetsConvertedAed, BigDecimal totalLiabilitiesConvertedAed,
				BigDecimal eligibleAssetRatio, BigDecimal aedElarHqAssets, BigDecimal aedTotalLiabilities,
				BigDecimal aedEligiblrAssetRatio, BigDecimal usdElarHqAssets, BigDecimal usdTotalLiabilities,
				BigDecimal usdEigibleAssetRatio, BigDecimal asfConvertedAed, BigDecimal rsfConvertedAed,
				BigDecimal nsfr, BigDecimal aedAsf, BigDecimal aedRsf, BigDecimal aedNsfr, BigDecimal usdAsf,
				BigDecimal usdRsf, BigDecimal usdNsfr, BigDecimal loansAdvancesConvertedAed,
				BigDecimal stableResourcesConvertedAed, BigDecimal loansToStableResourcesRatio,
				BigDecimal aedLoansAdvances, BigDecimal aedStableResources, BigDecimal aedLtsRatio,
				BigDecimal usdLoansAdvances, BigDecimal usdStableResources, BigDecimal usdLtsRatio,
				BigDecimal stableTermDepositAed, BigDecimal volatileTermDepositAed, BigDecimal stableCasaAed,
				BigDecimal volatileCasaAed, BigDecimal termDepositAed, BigDecimal casaAed,
				BigDecimal loansToDepositsRatio, BigDecimal stableTermDepositToAssets,
				BigDecimal volatileTermDepositToAssets, BigDecimal stableCasaToAssets, BigDecimal volatileCasaToAssets,
				BigDecimal liquidAssetsToTotalDeposits, BigDecimal liquidAssetsToTotalCasa,
				BigDecimal sixMonthCashFlowGapAed, BigDecimal totalLiabilitiesExclCapital, BigDecimal sixMonthGapRatio,
				BigDecimal aedSixMonthCashFlowGap, BigDecimal aedLiabilitiesExclCapital, BigDecimal aedSixMonthGapRatio,
				BigDecimal usdSixMonthCashFlowGap, BigDecimal usdLiabilitiesExclCapital, BigDecimal usdSixMonthGapRatio,
				BigDecimal threeMonthCashFlowGapAed, BigDecimal threeMonthGapRatio, BigDecimal oneMonthCashFlowGapAed,
				BigDecimal oneMonthGapRatio, BigDecimal sevenDayCashFlowGapAed, BigDecimal sevenDayGapRatio,
				BigDecimal unencumberedLiquidAssetsAed, BigDecimal oneMonthCashFlowGapCopy,
				BigDecimal unencumberedTo1mGapRatio, BigDecimal cbuaeCashBalances, BigDecimal cbuaeCashBalancesPercent,
				BigDecimal moneyMktPlacementsLt6m, BigDecimal moneyMktPlacementsLt6mPercent,
				BigDecimal localCurrencyGovtBonds, BigDecimal localCurrencyGovtBondsPercent,
				BigDecimal hardCurrencyGovtBonds, BigDecimal hardCurrencyGovtBondsPercent, BigDecimal foreignGovtBonds,
				BigDecimal foreignGovtBondsPercent, BigDecimal pledgeSecurities, BigDecimal totalPledgeableSecurities,
				BigDecimal pledgeRatio, BigDecimal totalComplexFinInstruments, BigDecimal totalTradableAssets,
				BigDecimal complexToTradableRatio, BigDecimal top10Deposits, BigDecimal totalDepositsAed1,
				BigDecimal top10ToTotalRatio, BigDecimal stIbBorrowingLt3m, BigDecimal stRepoLt3m,
				BigDecimal interbankBorrowing, BigDecimal repoAgreements, BigDecimal totalDepositsAed2,
				BigDecimal longTermFundingCopy, BigDecimal stIbRepoToTotalFundingRatio,
				BigDecimal largestSingleDepositor, BigDecimal individualCounterpartyToTotalFundingRatio,
				BigDecimal unutilizedLoansCreditLines, BigDecimal derivativesExpectedNegExposure,
				BigDecimal derivativesExpectedNegExposureProxy, BigDecimal contingentLiabilities,
				BigDecimal contingentLiabilitiesToTotalFundingRatio, BigDecimal top5IndustryDeposits,
				BigDecimal top5ToTotalDepositsRatio, BigDecimal longTermLiabilitiesToTotalLiabilitiesRatio,
				Date reportFromDate, Date reportToDate, String entityFlg, String modifyFlg, String delFlg,
				String reportCode, Date reportSubmitDate, String entryUser, String modifyUser, String verifyUser,
				Date entryTime, Date modifyTime, Date verifyTime) {
			super();
			SI_NO = sI_NO;
			this.reportDate = reportDate;
			this.bankName = bankName;
			this.groupHeadOfficeSubsidiary = groupHeadOfficeSubsidiary;
			this.subsidiary = subsidiary;
			this.bankSymbol = bankSymbol;
			this.conventionalIslamic = conventionalIslamic;
			this.localForeign = localForeign;
			this.cbuAeTiering = cbuAeTiering;
			this.assetBalanceSheetSizeAed = assetBalanceSheetSizeAed;
			this.cashAed = cashAed;
			this.cashPercent = cashPercent;
			this.dueFromCentralBankAed = dueFromCentralBankAed;
			this.dueFromCentralBankPercent = dueFromCentralBankPercent;
			this.dueFromHoBranchSubsAed = dueFromHoBranchSubsAed;
			this.dueFromHoBranchSubsPercent = dueFromHoBranchSubsPercent;
			this.dueFromBanksAed = dueFromBanksAed;
			this.dueFromBanksPercent = dueFromBanksPercent;
			this.dueFromNbfiAed = dueFromNbfiAed;
			this.dueFromNbfiPercent = dueFromNbfiPercent;
			this.investmentAed = investmentAed;
			this.investmentPercent = investmentPercent;
			this.otherInvestmentsAed = otherInvestmentsAed;
			this.otherInvestmentsPercent = otherInvestmentsPercent;
			this.netCreditPortfolioAed = netCreditPortfolioAed;
			this.netCreditPortfolioPercent = netCreditPortfolioPercent;
			this.tradeBillsAed = tradeBillsAed;
			this.tradeBillsPercent = tradeBillsPercent;
			this.netFixedOtherAssetsAed = netFixedOtherAssetsAed;
			this.netFixedOtherAssetsPercent = netFixedOtherAssetsPercent;
			this.positiveFvDerivativesAed = positiveFvDerivativesAed;
			this.positiveFvDerivativesPercent = positiveFvDerivativesPercent;
			this.liabilityBalanceSheetSizeAed = liabilityBalanceSheetSizeAed;
			this.dueToCentralBankAed = dueToCentralBankAed;
			this.dueToCentralBankPercent = dueToCentralBankPercent;
			this.dueToHoBranchSubsAed = dueToHoBranchSubsAed;
			this.dueToHoPercent = dueToHoPercent;
			this.dueToBanksAed = dueToBanksAed;
			this.dueToBanksPercent = dueToBanksPercent;
			this.dueToNbfiAed = dueToNbfiAed;
			this.dueToNbfiPercent = dueToNbfiPercent;
			this.customerDepositAed = customerDepositAed;
			this.customerDepositPercent = customerDepositPercent;
			this.longTermFundingAed = longTermFundingAed;
			this.longTermFundingPercent = longTermFundingPercent;
			this.otherLiabilitiesAed = otherLiabilitiesAed;
			this.otherLiabilitiesPercent = otherLiabilitiesPercent;
			this.negativeFvDerivativesAed = negativeFvDerivativesAed;
			this.negativeFvDerivativesPercent = negativeFvDerivativesPercent;
			this.capitalReservesAed = capitalReservesAed;
			this.capitalReservesPercent = capitalReservesPercent;
			this.shortTermRegRatioReq = shortTermRegRatioReq;
			this.hqAssetsConvertedAed = hqAssetsConvertedAed;
			this.outflows30dAed = outflows30dAed;
			this.inflows30dAed = inflows30dAed;
			this.lcr = lcr;
			this.aedHqAssets = aedHqAssets;
			this.aedOutflows30d = aedOutflows30d;
			this.aedInflows30d = aedInflows30d;
			this.aedLcr = aedLcr;
			this.usdHqAssets = usdHqAssets;
			this.usdOutflows30d = usdOutflows30d;
			this.usdInflows30d = usdInflows30d;
			this.usdLcr = usdLcr;
			this.elarHqAssetsConvertedAed = elarHqAssetsConvertedAed;
			this.totalLiabilitiesConvertedAed = totalLiabilitiesConvertedAed;
			this.eligibleAssetRatio = eligibleAssetRatio;
			this.aedElarHqAssets = aedElarHqAssets;
			this.aedTotalLiabilities = aedTotalLiabilities;
			this.aedEligiblrAssetRatio = aedEligiblrAssetRatio;
			this.usdElarHqAssets = usdElarHqAssets;
			this.usdTotalLiabilities = usdTotalLiabilities;
			this.usdEigibleAssetRatio = usdEigibleAssetRatio;
			this.asfConvertedAed = asfConvertedAed;
			this.rsfConvertedAed = rsfConvertedAed;
			this.nsfr = nsfr;
			this.aedAsf = aedAsf;
			this.aedRsf = aedRsf;
			this.aedNsfr = aedNsfr;
			this.usdAsf = usdAsf;
			this.usdRsf = usdRsf;
			this.usdNsfr = usdNsfr;
			this.loansAdvancesConvertedAed = loansAdvancesConvertedAed;
			this.stableResourcesConvertedAed = stableResourcesConvertedAed;
			this.loansToStableResourcesRatio = loansToStableResourcesRatio;
			this.aedLoansAdvances = aedLoansAdvances;
			this.aedStableResources = aedStableResources;
			this.aedLtsRatio = aedLtsRatio;
			this.usdLoansAdvances = usdLoansAdvances;
			this.usdStableResources = usdStableResources;
			this.usdLtsRatio = usdLtsRatio;
			this.stableTermDepositAed = stableTermDepositAed;
			this.volatileTermDepositAed = volatileTermDepositAed;
			this.stableCasaAed = stableCasaAed;
			this.volatileCasaAed = volatileCasaAed;
			this.termDepositAed = termDepositAed;
			this.casaAed = casaAed;
			this.loansToDepositsRatio = loansToDepositsRatio;
			this.stableTermDepositToAssets = stableTermDepositToAssets;
			this.volatileTermDepositToAssets = volatileTermDepositToAssets;
			this.stableCasaToAssets = stableCasaToAssets;
			this.volatileCasaToAssets = volatileCasaToAssets;
			this.liquidAssetsToTotalDeposits = liquidAssetsToTotalDeposits;
			this.liquidAssetsToTotalCasa = liquidAssetsToTotalCasa;
			this.sixMonthCashFlowGapAed = sixMonthCashFlowGapAed;
			this.totalLiabilitiesExclCapital = totalLiabilitiesExclCapital;
			this.sixMonthGapRatio = sixMonthGapRatio;
			this.aedSixMonthCashFlowGap = aedSixMonthCashFlowGap;
			this.aedLiabilitiesExclCapital = aedLiabilitiesExclCapital;
			this.aedSixMonthGapRatio = aedSixMonthGapRatio;
			this.usdSixMonthCashFlowGap = usdSixMonthCashFlowGap;
			this.usdLiabilitiesExclCapital = usdLiabilitiesExclCapital;
			this.usdSixMonthGapRatio = usdSixMonthGapRatio;
			this.threeMonthCashFlowGapAed = threeMonthCashFlowGapAed;
			this.threeMonthGapRatio = threeMonthGapRatio;
			this.oneMonthCashFlowGapAed = oneMonthCashFlowGapAed;
			this.oneMonthGapRatio = oneMonthGapRatio;
			this.sevenDayCashFlowGapAed = sevenDayCashFlowGapAed;
			this.sevenDayGapRatio = sevenDayGapRatio;
			this.unencumberedLiquidAssetsAed = unencumberedLiquidAssetsAed;
			this.oneMonthCashFlowGapCopy = oneMonthCashFlowGapCopy;
			this.unencumberedTo1mGapRatio = unencumberedTo1mGapRatio;
			this.cbuaeCashBalances = cbuaeCashBalances;
			this.cbuaeCashBalancesPercent = cbuaeCashBalancesPercent;
			this.moneyMktPlacementsLt6m = moneyMktPlacementsLt6m;
			this.moneyMktPlacementsLt6mPercent = moneyMktPlacementsLt6mPercent;
			this.localCurrencyGovtBonds = localCurrencyGovtBonds;
			this.localCurrencyGovtBondsPercent = localCurrencyGovtBondsPercent;
			this.hardCurrencyGovtBonds = hardCurrencyGovtBonds;
			this.hardCurrencyGovtBondsPercent = hardCurrencyGovtBondsPercent;
			this.foreignGovtBonds = foreignGovtBonds;
			this.foreignGovtBondsPercent = foreignGovtBondsPercent;
			this.pledgeSecurities = pledgeSecurities;
			this.totalPledgeableSecurities = totalPledgeableSecurities;
			this.pledgeRatio = pledgeRatio;
			this.totalComplexFinInstruments = totalComplexFinInstruments;
			this.totalTradableAssets = totalTradableAssets;
			this.complexToTradableRatio = complexToTradableRatio;
			this.top10Deposits = top10Deposits;
			this.totalDepositsAed1 = totalDepositsAed1;
			this.top10ToTotalRatio = top10ToTotalRatio;
			this.stIbBorrowingLt3m = stIbBorrowingLt3m;
			this.stRepoLt3m = stRepoLt3m;
			this.interbankBorrowing = interbankBorrowing;
			this.repoAgreements = repoAgreements;
			this.totalDepositsAed2 = totalDepositsAed2;
			this.longTermFundingCopy = longTermFundingCopy;
			this.stIbRepoToTotalFundingRatio = stIbRepoToTotalFundingRatio;
			this.largestSingleDepositor = largestSingleDepositor;
			this.individualCounterpartyToTotalFundingRatio = individualCounterpartyToTotalFundingRatio;
			this.unutilizedLoansCreditLines = unutilizedLoansCreditLines;
			this.derivativesExpectedNegExposure = derivativesExpectedNegExposure;
			this.derivativesExpectedNegExposureProxy = derivativesExpectedNegExposureProxy;
			this.contingentLiabilities = contingentLiabilities;
			this.contingentLiabilitiesToTotalFundingRatio = contingentLiabilitiesToTotalFundingRatio;
			this.top5IndustryDeposits = top5IndustryDeposits;
			this.top5ToTotalDepositsRatio = top5ToTotalDepositsRatio;
			this.longTermLiabilitiesToTotalLiabilitiesRatio = longTermLiabilitiesToTotalLiabilitiesRatio;
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

		public RT_Liquidity_Risk_Dashboard_Template() {
			super();
			// TODO Auto-generated constructor stub
		}

		

}
