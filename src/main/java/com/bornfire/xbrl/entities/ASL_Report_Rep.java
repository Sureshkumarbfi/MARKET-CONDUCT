package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ASL_Report_Rep extends CrudRepository<ASL_Report_Entity,Long>{
	

	@Query(value = "select * from MIS_ASL_DETAIL_REPORT ORDER BY ID", nativeQuery = true)
	List<ASL_Report_Entity> getalllist();
	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT WHERE REPORT_DATE = ?1 ORDER BY ID", nativeQuery = true)
	List<ASL_Report_Entity> getByReportDate(Date reportDate);
	
	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT WHERE TRIM(I_BRANCH_NAME) = ?1 ORDER BY ID", nativeQuery = true)
	List<ASL_Report_Entity> getByReportDateBranch(String selected_branch);

	
	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT WHERE REPORT_DATE = ?1  AND TRIM(I_BRANCH_NAME)  = ?2 ORDER BY ID", nativeQuery = true)
	List<ASL_Report_Entity> getByReportDateBranch(Date reportDate, String selected_branch);

	@Modifying
	@Query("DELETE FROM ASL_Report_Entity e WHERE e.reportDate = :reportDate AND e.iBranchName = :iBranchName")
	void deleteByReportDate(@Param("reportDate") Date reportDate, @Param("iBranchName") String iBranchName);


	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT WHERE REPORT_DATE = ?1 AND I_BRANCH_CODE=?2 ORDER BY ID", nativeQuery = true)
	List<ASL_Report_Entity> getByReportDateAndBR(Date reportDate,String I_BRANCH_CODE);

	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT " +
            "WHERE REPORT_DATE = ?1 " +
            "AND LOWER(TRIM(I_BRANCH_NAME)) = LOWER(TRIM(?2)) " +
            "ORDER BY ID", nativeQuery = true)
List<ASL_Report_Entity> getAlls(Date reportDate, String iBranchName);

	
	@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT " +
            "WHERE CAST(REPORT_DATE AS DATE) = ?1 " +
            "AND TRIM(UPPER(I_BRANCH_NAME)) = TRIM(UPPER(?2)) " +
            "ORDER BY ID", nativeQuery = true)
List<ASL_Report_Entity> getListByDate(Date reportDate, String iBranchName);


@Query(value = "SELECT DISTINCT TRIM(I_BRANCH_NAME) AS branch FROM MIS_ASL_DETAIL_REPORT ORDER BY branch", nativeQuery = true)
List<String> getAllBranchNames();

	
@Query(value = "SELECT * FROM MIS_ASL_DETAIL_REPORT WHERE REPORT_DATE = :reportDate", nativeQuery = true)
List<ASL_Report_Entity> getAllListByDate(@Param("reportDate") Date reportDate);


	
}