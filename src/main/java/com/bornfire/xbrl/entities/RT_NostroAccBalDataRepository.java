package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_NostroAccBalDataRepository extends JpaRepository<RT_NostroAccBalData, RT_Nostro_IdClass> {
	// Add custom queries if needed

	@Query(value = "select * from BCBUAE_NOSTRO_ACC_BAL_DATA where DEL_FLG != 'Y' and  REPORT_DATE=?1", nativeQuery = true)
	List<RT_NostroAccBalData> getlist(Date REPORT_DATE);
	
	@Query(value = "select * from BCBUAE_NOSTRO_ACC_BAL_DATA where DEL_FLG != 'Y' and  REPORT_DATE=?1 and  ACCOUNT_NO =?2 ", nativeQuery = true)
	RT_NostroAccBalData getbyAcctNoReportDate(Date REPORT_DATE,String accountNo);


	@Query(value = "SELECT " + "DATA_DATE, BANK_NAME, HEAD_OFFICE_SUBSIDIARY, SUBSIDIARY, "
			+ "BANK_SYMBOL, CONVENTIONAL_ISLAMIC, LOCAL_FOREIGN, CBUAE_TIERING, "
			+ "COUNTERPARTY_NOSTRO_ACCOUNT, FINAL_RATING_BANKS, FINAL_RATING_CBUAE, "
			+ "COUNTRY_OF_RISK, CBUAE_GEOGRAPHICAL_ZONE, CURRENCY, "
			+ "COUNTERPARTY_SETTLEMENT_DATE, COUNTERPARTY_BALANCE, COUNTERPARTY_BALANCE_AED, "
			+ "BANK_INTERNAL_SETTLEMENT_DATE, BANK_BALANCE, BANK_BALANCE_AED, " + "ACCOUNT_NO, GAP "
			+ "FROM BCBUAE_NOSTRO_ACC_BAL_DATA where REPORT_DATE=?1", nativeQuery = true)
	List<Object[]> getnostrodatalistdata1(Date Report_date);

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_NOSTRO_ACC_BAL_DATA", nativeQuery = true)
	Timestamp findLastReportDate();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_NOSTRO_ACC_BAL_DATA WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_NOSTRO_ACC_BAL_DATA)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
}
