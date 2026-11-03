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
public interface RT_Overnight_Foreign_Ccy_Data_Repo
		extends JpaRepository<RT_Overnight_Foreign_Ccy_Data_Entity, RT_Overnight_Foreign_Ccy_Data_Id> {

	@Query("SELECT e FROM RT_Overnight_Foreign_Ccy_Data_Entity e WHERE e.report_date = :d ORDER BY e.currency ASC")
	List<RT_Overnight_Foreign_Ccy_Data_Entity> findByReportDate(@Param("d") Date reportDate);

	@Query("SELECT e FROM RT_Overnight_Foreign_Ccy_Data_Entity e WHERE e.report_date BETWEEN :start AND :end ORDER BY e.report_date ASC, e.currency ASC")
	List<RT_Overnight_Foreign_Ccy_Data_Entity> findByReportDateBetween(@Param("start") Date start,
			@Param("end") Date end);

	@Query(value = "SELECT REPORT_DATE, CURRENCY, CLOSING_POSITION FROM RT_OVERNIGHT_FOREIGN_CCY_DATA "
			+ "WHERE TRUNC(REPORT_DATE) = TRUNC(:reportDate) ORDER BY CURRENCY", nativeQuery = true)
	List<Object[]> getByReportDate(@Param("reportDate") Date reportDate);

	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM RT_OVERNIGHT_FOREIGN_CCY_DATA ORDER BY 1 DESC",
			nativeQuery = true)
	List<Date> findDistinctReportDates();

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM RT_OVERNIGHT_FOREIGN_CCY_DATA WHERE TRUNC(REPORT_DATE) = TRUNC(?1)",
			nativeQuery = true)
	void deleteByReportDate(Date reportDate);

	@Query(value = "SELECT COUNT(*) FROM RT_OVERNIGHT_FOREIGN_CCY_DATA WHERE TRUNC(REPORT_DATE) = TRUNC(?1)",
			nativeQuery = true)
	long countByReportDate(Date reportDate);
}
