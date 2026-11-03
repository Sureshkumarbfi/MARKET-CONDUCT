package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_MID_FX_DEAL_REPO extends JpaRepository<RT_MID_FX_DEAL_DC, String> {

	// Deletes records for a specific date to prevent duplicates
	@Transactional
	@Modifying
	@Query("DELETE FROM RT_MID_FX_DEAL_DC a WHERE a.reportDate = ?1")
	void deleteByReportDate(Date reportDate);
	
	@Query(value = "Select TO_CHAR(REPORT_DATE,'DD-MM-YYYY'),nvl(AED_FOREX,0), nvl(AED_INT_RATE,0), nvl(AED_INVEST_BONDS,0),"
			+ " nvl(AED_MONEY_MARKET_CP_CD,0), nvl(AED_TOTAL_PV01,0)"
			+ " from RT_MID_FX_DEAL Where report_date between Trunc(?1,'MM') "
			+ "and Last_day(Trunc(?1,'MM')) Order by report_date Asc",nativeQuery = true)
	List<Object[]> GetselectedmonthBPVdata(Date Selecteddate);
	
    boolean existsByReportDate(Date reportDate);

    @Query("SELECT DISTINCT r.reportDate FROM RT_MID_FX_DEAL_DC r")
    List<Date> findUploadedDates();
	
}