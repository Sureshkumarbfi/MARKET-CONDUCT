package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RT_MC_TABLE9_REPO extends JpaRepository<RT_MC_TABLE9_ENTITY, MCReportId> {

	@Query(value = "SELECT * FROM RT_MC_TABLE9 WHERE REPORT_DATE = TO_DATE(:reportDate, 'DD-MM-YYYY') AND BRANCH_CODE <> 'DEPT' ORDER BY REPORT_DATE DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	List<RT_MC_TABLE9_ENTITY> findByReportDate(@Param("reportDate") String reportDate);

	@Query(value = "SELECT * FROM RT_MC_TABLE9 WHERE BRANCH_CODE = :branch ORDER BY REPORT_DATE DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	List<RT_MC_TABLE9_ENTITY> findBybranchcode(@Param("branch") String branch);

	@Query(value = "SELECT * FROM RT_MC_TABLE9 WHERE REPORT_DATE = TO_DATE(:reportDate, 'DD-MM-YYYY') AND BRANCH_CODE = :branchCode ORDER BY REPORT_DATE DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	List<RT_MC_TABLE9_ENTITY> findByReportDateAndBranchCode(@Param("reportDate") String reportDate,
			@Param("branchCode") String branchCode);

	@Modifying
	@Transactional
	@Query("UPDATE RT_MC_TABLE9_ENTITY r SET r.VERIFY_FLG = :verifyFlg, r.REMARKS = :remarks "
			+ "WHERE r.REPORT_DATE = :reportDate AND r.BRANCH_CODE = :timeperiod")
	int updateVerifyFlgAndRemarks(@Param("verifyFlg") String verifyFlg, @Param("remarks") String remarks,
			@Param("reportDate") Date reportDate, @Param("timeperiod") String timeperiod);

	@Query(value = "SELECT * FROM RT_MC_TABLE9 WHERE REPORT_DATE IN ("
			+ " SELECT DISTINCT REPORT_DATE FROM RT_MC_TABLE9 "
			+ " WHERE REPORT_DATE <= TO_DATE(:reportDate, 'DD-MM-YYYY') " + " AND BRANCH_CODE = :timeperiod "
			+ " ORDER BY REPORT_DATE DESC " + " FETCH FIRST 4 ROWS ONLY" + ") AND BRANCH_CODE = :timeperiod "
			+ " ORDER BY REPORT_DATE DESC", nativeQuery = true)
	List<RT_MC_TABLE9_ENTITY> findLastFourReports(@Param("reportDate") String reportDate,
			@Param("timeperiod") String timeperiod);

	@Query(value = "SELECT * FROM RT_MC_TABLE9 WHERE REPORT_DATE IN ("
			+ " SELECT DISTINCT REPORT_DATE FROM RT_MC_TABLE9 "
			+ " WHERE REPORT_DATE <= TO_DATE(:reportDate, 'DD-MM-YYYY') " + " AND BRANCH_CODE = :timeperiod "
			+ " ORDER BY REPORT_DATE DESC " + " FETCH FIRST 2 ROWS ONLY" + ") AND BRANCH_CODE = :timeperiod "
			+ " ORDER BY REPORT_DATE DESC", nativeQuery = true)
	List<RT_MC_TABLE9_ENTITY> findLastTwoReports(@Param("reportDate") String reportDate,
			@Param("timeperiod") String timeperiod);
	
	@Modifying
	@Transactional
	@Query("UPDATE RT_MC_TABLE9_ENTITY r SET r.ENTITY_FLG = :entityFlg, r.SIGNOFF_REMARKS = :signoffremarks "
			+ "WHERE r.REPORT_DATE = TO_DATE(:reportDate, 'DD-MM-YYYY') AND r.BRANCH_CODE = :timeperiod")
	int updateEntityFlgAndSignOffRemarks(@Param("entityFlg") String entityFlg,
			@Param("signoffremarks") String signoffremarks, @Param("reportDate") String reportDate,
			@Param("timeperiod") String timeperiod);
	
	@Query(value = "SELECT COUNT(*) FROM RT_MC_TABLE9 WHERE REPORT_DATE = TO_DATE(:reportDate, 'DD-MM-YYYY') AND BRANCH_CODE = :branchCode ", nativeQuery = true)
	int countByReportDateAndTimeperiod(@Param("reportDate") String reportDate,
			@Param("branchCode") String branchCode);

}
