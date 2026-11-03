package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Mis_treasury_placement_repo extends JpaRepository<MIS_TREASURY_PLACEMENT_ENTITY,MIS_Treasury_placement_id_class > {

	@Query(value="Select * from MIS_TREASURY_PLACEMENT where report_date =?1",nativeQuery=true)
	List<MIS_TREASURY_PLACEMENT_ENTITY> Gettreasurydata(Date Report_date);
	
	@Query(value = "SELECT * FROM MIS_TREASURY_PLACEMENT", nativeQuery = true)
    List<MIS_TREASURY_PLACEMENT_ENTITY> findall();
    
	
    @Transactional
    @Modifying
    @Query(value = "Delete From MIS_TREASURY_PLACEMENT where report_date = ?1 and branch_name =?2", nativeQuery = true)
    void Deletedatabyreport_date(Date report_date,String Branchname);
    
    @Transactional
    @Modifying
    @Query(value = "Delete From MIS_TREASURY_PLACEMENT where report_date = ?1", nativeQuery = true)
    void Deletebydaterecord(Date report_date);
    
    @Query(value = "SELECT * FROM MIS_TREASURY_PLACEMENT WHERE REPORT_DATE = ?1", nativeQuery = true)
    List<MIS_TREASURY_PLACEMENT_ENTITY> getAllListByDate(Date report_date);
    
    @Query(value = "SELECT * FROM MIS_TREASURY_PLACEMENT WHERE REPORT_DATE = ?1 AND BRANCH_CODE = ?2 ORDER BY NUM_OPERATION", nativeQuery = true)
    List<MIS_TREASURY_PLACEMENT_ENTITY> getByReportDateAndBR(Date report_date, String branch_code);

	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM MIS_TREASURY_PLACEMENT", nativeQuery = true)
	List<Date> findDistinctReportDates();

}
