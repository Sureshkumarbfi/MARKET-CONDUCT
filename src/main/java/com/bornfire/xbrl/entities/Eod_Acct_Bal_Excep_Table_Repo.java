package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Eod_Acct_Bal_Excep_Table_Repo
		extends JpaRepository<Eod_Acct_Bal_Excep_Table_Entity, Eod_Acct_Bal_Excep_Table_Id> {

	@Query(value = "SELECT * FROM EOD_ACCT_BAL_EXCEP_TABLE WHERE TRUNC(REPORT_DATE) = TRUNC(:reportDate) "
			+ "ORDER BY ACCT_NUMBER", nativeQuery = true)
	List<Eod_Acct_Bal_Excep_Table_Entity> findByReportDate(@Param("reportDate") Date reportDate);

	/**
	 * Resolves the same rows as on-screen: calendar date via TO_DATE (avoids JDBC Date vs TRUNC timezone drift)
	 * and TRIM on keys (Oracle CHAR padding / trailing spaces).
	 */
	@Query(value = "SELECT * FROM EOD_ACCT_BAL_EXCEP_TABLE WHERE TRUNC(REPORT_DATE) = TO_DATE(:reportDateStr, 'YYYY-MM-DD') "
			+ "AND TRIM(ACID) = TRIM(:acid) AND TRIM(TRAN_ID) = TRIM(:tranId) AND TRIM(PART_TRAN_SRL_NUM) = TRIM(:partTranSrlNum)",
			nativeQuery = true)
	List<Eod_Acct_Bal_Excep_Table_Entity> findByReportDateStrAndKeys(@Param("reportDateStr") String reportDateStr,
			@Param("acid") String acid, @Param("tranId") String tranId, @Param("partTranSrlNum") String partTranSrlNum);
}
