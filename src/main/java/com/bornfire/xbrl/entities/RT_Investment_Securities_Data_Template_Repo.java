package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Investment_Securities_Data_Template_Repo
		extends JpaRepository<RT_Investment_Securities_Data_Template, String> {
	// Add custom queries if needed

	@Query(value = "select * from BCBUAE_INVESTMENT_SECURITIES_DATA where DEL_FLG != 'Y' And Report_date =?1", nativeQuery = true)
	List<RT_Investment_Securities_Data_Template> getsecDatalist(Date Report_date);

	@Query(value = "SELECT \r\n" + "    DATA_DATE,\r\n" + "    BANK_NAME,\r\n" + "    HEAD_OFFICE_SUBSIDIARY,\r\n"
			+ "    SUBSIDIARY,\r\n" + "    BANK_SYMBOL,\r\n" + "    CONVENTIONAL_ISLAMIC,\r\n"
			+ "    LOCAL_FOREIGN,\r\n" + "    CBUAE_TIERING,\r\n" + "    ACCOUNTING_CLASSIFICATION,\r\n"
			+ "    INSTRUMENT_TYPE,\r\n" + "    INSTRUMENT_SUBCATEGORY_TYPE,\r\n" + "    ISIN_CODE,\r\n"
			+ "    BANK_INTERNAL_PORTFOLIO_CODE,\r\n" + "    CBUAE_SECURITY_ID,\r\n"
			+ "    CBUAE_ACCESS_PRIMARY_KEY,\r\n" + "    SECURITY_DESCRIPTION,\r\n" + "    ASSET_CURRENCY,\r\n"
			+ "    OBLIGOR,\r\n" + "    COUNTRY_OF_RISK,\r\n" + "    CBUAE_GEOGRAPHICAL_ZONE,\r\n" + "    INDUSTRY,\r\n"
			+ "    SECTOR,\r\n" + "    ISSUER_TYPE,\r\n" + "    ISSUE_SIZE,\r\n" + "    PERCENT_ISSUE_SIZE,\r\n"
			+ "    NOMINAL_TRADE_CURRENCY,\r\n" + "    NOMINAL_AED_EQUIVALENT,\r\n"
			+ "    PREM_DISC_AED_EQUIVALENT,\r\n" + "    SPECIFIC_PROVISION_AED,\r\n"
			+ "    FIXED_INCOME_INFO_NET_BOOK_PRICE,\r\n" + "    NET_BOOK_VALUE_AED,\r\n"
			+ "    PURCHASE_YIELD_TO_MATURITY,\r\n" + "    CLEAN_PRICE,\r\n" + "    CLEAN_MARKET_VALUE_AED,\r\n"
			+ "    CURRENT_YIELD_TO_MATURITY,\r\n" + "    UNREALIZED_GAIN_LOSS_AED,\r\n"
			+ "    SUBORDINATED_DEBT_SUKUK,\r\n" + "    FINAL_RATING_BANKS,\r\n" + "    FINAL_RATING_CBUAE,\r\n"
			+ "    CREDIT_QUALITY,\r\n" + "    MATURITY_DATE,\r\n" + "    RESIDUAL_MATURITY,\r\n"
			+ "    MATURITY_PERIOD,\r\n" + "    PERCENT_HOLDINGS_FI,\r\n" + "    QTY_EQUITY_FUNDS,\r\n"
			+ "    EQUITY_FLOATING_FUND_ASSETS,\r\n" + "    TOTAL_FLOATING_SHARE_FUND_AUM,\r\n"
			+ "    SPECIFIC_PROVISION,\r\n" + "    NET_BOOK_VALUE,\r\n" + "    OTHER_SEC_INFO_NET_BOOK_PRICE,\r\n"
			+ "    MARKET_PRICE,\r\n" + "    FAIR_VALUE_AMOUNT_AED,\r\n" + "    UNREALIZED_GAIN_LOSS_AGAIN,\r\n"
			+ "    PERCENT_HOLDINGS_OTHER,\r\n" + "    TOTAL_NET_BOOK_VALUE_AED,\r\n"
			+ "    TOTAL_MARKET_VALUE_AED,\r\n" + "    TOTAL_UNREALIZED_GAIN_LOSS,\r\n"
			+ "    UNREALIZED_GAIN_LOSS_CONTRIB,\r\n" + "    PERCENT_HOLDINGS,\r\n" + "    EXISTING_PLEDGE_STATUS,\r\n"
			+ "    PLEDGED_AMOUNT_AED,\r\n" + "    UNENCUMBERED_AMOUNT_AED,\r\n" + "    PROPORTION_UNENCUMBERED,\r\n"
			+ "    HQLA_ELAR_ELIGIBILITY,\r\n" + "    LIQUIDITY_TYPE,\r\n" + "    SUKUK_TYPE,\r\n" + "    TTC_PD,\r\n"
			+ "    PIT_PD,\r\n" + "    ECL_1Y,\r\n" + "    ECL_LIFETIME,\r\n" + "    ECL_FINAL,\r\n"
			+ "    IFRS9_STAGING,\r\n" + "    BANK_CORE_TIER1_CAPITAL_AED\r\n" + "FROM \r\n"
			+ "    BCBUAE_INVESTMENT_SECURITIES_DATA", nativeQuery = true)
	List<Object[]> getInvestmentData();

	@Query(value = "SELECT * FROM BCBUAE_INVESTMENT_SECURITIES_DATA WHERE DEL_FLG = 'N' AND ENTITY_FLG = 'Y' ORDER BY SI_NO", nativeQuery = true)
	List<RT_Investment_Securities_Data_Template> getlist();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_INVESTMENT_SECURITIES_DATA", nativeQuery = true)
	Timestamp findLastReportDate();
		
     @Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_INVESTMENT_SECURITIES_DATA WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_INVESTMENT_SECURITIES_DATA)", nativeQuery = true)
    Timestamp findSecondLastReportDate();
     
 	@Query(value = "SELECT * FROM BCBUAE_INVESTMENT_SECURITIES_DATA where SI_NO =?1 ", nativeQuery = true)
 	RT_Investment_Securities_Data_Template getParticularDataBySI_NO(String SI_NO);
 	
	@Query(value = "select * from BCBUAE_INVESTMENT_SECURITIES_DATA where REPORT_DATE=?1", nativeQuery = true)
	List<RT_Investment_Securities_Data_Template> getlist(Date REPORT_DATE);
}
