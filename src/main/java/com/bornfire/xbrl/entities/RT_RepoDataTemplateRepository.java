package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_RepoDataTemplateRepository extends JpaRepository<RT_RepoDataTemplate, Long> {

	   @Query(value = "SELECT * FROM BCBUAE_REPO_DATA_TEMPLATE WHERE DEL_FLG != 'Y' and REPORT_DATE=?1", nativeQuery = true)
	    List<RT_RepoDataTemplate> getlist(Date REPORT_DATE);
	    
	    @Query(value = "SELECT " +
	            "DATA_DATE, BANK_NAME, HEAD_OFFICE_SUBSIDIARY, SUBSIDIARY, " +
	            "BANK_SYMBOL, CONVENTIONAL_ISLAMIC, LOCAL_FOREIGN, CBUAE_TIERING, " +
	            "COUNTERPARTY_NAME, COUNTERPARTY_INTERNAL_REF, FINAL_RATING_BANKS, " +
	            "FINAL_RATING_CBUAE, COUNTRY_OF_RISK, CBUAE_GEO_ZONE, CBUAE_INTERNAL_REF, " +
	            "TRANSACTION_TYPE, DEAL_NO, REPO_START_DATE, REPO_MATURITY_DATE, " +
	            "INITIAL_MATURITY, INITIAL_MATURITY_ROUNDED, INITIAL_MATURITY_PERIOD, " +
	            "RESIDUAL_MATURITY_DATE, MATURITY_PERIOD, REPO_CURRENCY, " +
	            "UNDERLYING_SECURITY_ISIN, REHYPOTHECATION_STATUS, SECURITY_CURRENCY, " +
	            "OBLIGOR, ISSUER_TYPE, INDUSTRY, SECTOR, UNDERLYING_BOND_DETAILS, " +
	            "SECURITY_FINAL_RATING, FINAL_SECURITY_RATING_CBUAE, SECURITY_COUNTRY_OF_RISK, " +
	            "CBUAE_GEO_ZONE_2, BOND_SUKUK_NOMINAL, SECURITY_MATURITY_DATE, " +
	            "SECURITY_RESIDUAL_MATURITY, SECURITY_MATURITY_PERIOD, GMRA_EFFECTIVE_HAIRCUT, " +
	            "SECURITY_START_PRICE, SECURITY_START_CASH_AMOUNT, START_CASH_AMOUNT, " +
	            "INTEREST_PROFIT_RATE, FIXED_RATE, FLOATING_RATE_TYPE, REPO_MARGIN, " + // Note: Replaced 'Repo Interest/Profit rate Margin (Only in case of Floating Rate)' with 'REPO_MARGIN' as per entity.
	            "INTEREST_ACCRUALS, REPO_VALUATION, DIRTY_PRICE, GMRA_COLLATERAL_MTM, " +
	            "MIN_TRANSFER_AMOUNT, THRESHOLD, MARGIN_CALL_FREQ " +
	            "FROM BCBUAE_REPO_DATA_TEMPLATE where REPORT_DATE=?1", nativeQuery = true)
	    List<Object[]> getRepoDataList(Date REPORT_DATE);
	    
		
		@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_REPO_DATA_TEMPLATE", nativeQuery = true)
		Timestamp findLastReportDate();
		
		@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_REPO_DATA_TEMPLATE WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_REPO_DATA_TEMPLATE)", nativeQuery = true)
		Timestamp findSecondLastReportDate();
}
