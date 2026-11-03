package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Report_Master_Repo extends JpaRepository<RT_Report_Master_Entity, BigDecimal> {

	/**
	 * Report Control Center: master row plus totals derived from {@code RT_REPORT_STEP} and
	 * {@code RT_REPORT_STEP_EXEC} for the selected calendar day ({@code :reportDay}).
	 * Overall status is computed from step counts vs. success/fail/pending on that day.
	 */
	@Query(value = "WITH Total_Steps AS ( "
			+ "SELECT REPORT_ID, COUNT(STEP_ID) AS TOTAL_STEPS "
			+ "FROM RT_REPORT_STEP GROUP BY REPORT_ID "
			+ "), Report_Exec AS ( "
			+ "SELECT e.REPORT_ID, "
			+ "SUM(CASE WHEN UPPER(TRIM(e.STATUS)) IN ('SUCCESS','SUCCEEDED','COMPLETE','COMPLETED') THEN 1 ELSE 0 END) AS SUCCESS_CNT, "
			+ "SUM(CASE WHEN UPPER(TRIM(e.STATUS)) IN ('FAILED','FAIL','ERROR') THEN 1 ELSE 0 END) AS FAIL_CNT, "
			+ "SUM(CASE WHEN UPPER(TRIM(e.STATUS)) = 'PENDING' THEN 1 ELSE 0 END) AS PENDING_CNT "
			+ "FROM RT_REPORT_STEP_EXEC e "
			+ "WHERE TRUNC(e.REPORT_DATE) = TRUNC(:reportDay) "
			+ "GROUP BY e.REPORT_ID "
			+ ") "
			+ "SELECT m.REPORT_ID, m.REPORT_NAME, m.IS_ACTIVE, m.REPORT_DATE, "
			+ "CASE "
			+ "WHEN NVL(ts.TOTAL_STEPS, 0) = 0 THEN m.REPORT_STATUS "
			+ "WHEN NVL(re.FAIL_CNT, 0) > 0 THEN 'FAILED' "
			+ "WHEN NVL(ts.TOTAL_STEPS, 0) > 0 "
			+ "AND NVL(re.SUCCESS_CNT, 0) + NVL(re.FAIL_CNT, 0) + NVL(re.PENDING_CNT, 0) = 0 THEN 'PENDING' "
			+ "WHEN NVL(re.SUCCESS_CNT, 0) >= NVL(ts.TOTAL_STEPS, 0) AND NVL(re.FAIL_CNT, 0) = 0 THEN 'SUCCESS' "
			+ "WHEN NVL(re.SUCCESS_CNT, 0) + NVL(re.FAIL_CNT, 0) + NVL(re.PENDING_CNT, 0) < NVL(ts.TOTAL_STEPS, 0) THEN 'IN_PROGRESS' "
			+ "ELSE NVL(m.REPORT_STATUS, 'IN_PROGRESS') "
			+ "END AS REPORT_STATUS, "
			+ "m.REPORT_FREQ, NVL(ts.TOTAL_STEPS, 0) AS TOTAL_STEPS, "
			+ "NVL(re.SUCCESS_CNT, 0) AS COMPLETED_STEPS, NVL(re.FAIL_CNT, 0) AS FAILED_STEPS "
			+ "FROM RT_REPORT_MASTER m "
			+ "LEFT JOIN Total_Steps ts ON ts.REPORT_ID = m.REPORT_ID "
			+ "LEFT JOIN Report_Exec re ON re.REPORT_ID = m.REPORT_ID "
			+ "ORDER BY m.REPORT_NAME", nativeQuery = true)
	List<RT_Report_Master_Entity> Get_Report_master(@Param("reportDay") Date reportDay);

}
