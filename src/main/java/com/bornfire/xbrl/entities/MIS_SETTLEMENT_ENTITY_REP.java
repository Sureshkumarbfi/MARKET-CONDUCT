package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MIS_SETTLEMENT_ENTITY_REP extends JpaRepository<MIS_SETTLEMENT_ENTITY, String> {
	
	
	
	
@Query(value = "SELECT * FROM MIS_SETTLEMENT WHERE REPORT_DATE = :reportDate", nativeQuery = true)
List<MIS_SETTLEMENT_ENTITY> getAllListByDate(@Param("reportDate") Date reportDate);


@Query(value = "SELECT * FROM MIS_SETTLEMENT WHERE REPORT_DATE = ?1 AND BRANCH_CODE=?2", nativeQuery = true)
List<MIS_SETTLEMENT_ENTITY> getByReportDateAndBR(Date reportDate,String BRANCH_CODE);
    


@Modifying
@Query("DELETE FROM MIS_SETTLEMENT_ENTITY e WHERE e.reportDate = :reportDate AND e.branchName = :branchName")
void deleteByReportDate(@Param("reportDate") Date reportDate, @Param("branchName") String iBranchName);

}