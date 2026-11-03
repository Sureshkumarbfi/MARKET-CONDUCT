package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_RWA_NonFund_base_data_rep extends JpaRepository<RT_RWA_NonFund_base_data_entity, RT_RWA_NonFund_base_id_class> {

	// 1. Logic for "Replace": Delete all records for the selected report date
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM BRF95_RWA_DATA_NONFUNDBASED WHERE REPORT_DATE = ?1", nativeQuery = true)
	void deleteByReportDate(Date report_date);
	
	@Query(value = "SELECT COUNT(*) FROM BRF95_RWA_DATA_NONFUNDBASED WHERE REPORT_DATE = ?1", nativeQuery = true)
	int existsReportDate(Date reportDate);

	    @Query(value = "SELECT DISTINCT REPORT_DATE FROM BRF95_RWA_DATA_NONFUNDBASED ORDER BY REPORT_DATE", nativeQuery = true)
	    List<Date> findUploadedDates();
	    
	// 2. Fetch unique customers for non-fund based
	@Query(value = "SELECT DISTINCT cust_id FROM BRF95_RWA_DATA_NONFUNDBASED FETCH FIRST 100 ROWS ONLY", nativeQuery = true)
	List<String> getCustomerDetails();

	// 3. Example Portfolio Summary for Non-Fund Based
	@Query(value = "SELECT branch_name, ROUND(SUM(lcbg_balance)/1000000, 2) AS exposure_bal, "
			+ "ROUND((SUM(lcbg_balance) / (SELECT SUM(lcbg_balance) FROM BRF95_RWA_DATA_NONFUNDBASED WHERE report_date = ?1)) * 100, 2) AS exposure_per "
			+ "FROM BRF95_RWA_DATA_NONFUNDBASED WHERE report_date = ?1 GROUP BY branch_name", nativeQuery = true)
	List<Object[]> getBranchWiseNonFundPortfolio(Date selectedDate);

	// 4. Get Top 10 Non-Fund Exposures by Branch
	@Query(value = "SELECT * FROM (SELECT branch_name, cust_name, lcbg_id, gl_code, class, lcbg_limit, lcbg_balance, rwa "
			+ "FROM BRF95_RWA_DATA_NONFUNDBASED WHERE report_date = ?1 AND branch_name = ?2 ORDER BY lcbg_balance DESC) "
			+ "WHERE ROWNUM <= 10", nativeQuery = true)
	List<Object[]> getTopNonFundExposureByBranch(Date selectedDate, String branchName);
}