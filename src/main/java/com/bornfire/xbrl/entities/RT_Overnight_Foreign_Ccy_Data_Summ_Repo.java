package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Overnight_Foreign_Ccy_Data_Summ_Repo
		extends JpaRepository<RT_Overnight_Foreign_Ccy_Data_Summ_Entity, RT_Overnight_Foreign_Ccy_Data_Summ_Id> {

	@Query("SELECT e FROM RT_Overnight_Foreign_Ccy_Data_Summ_Entity e WHERE e.report_date = :d")
	Optional<RT_Overnight_Foreign_Ccy_Data_Summ_Entity> findByReportDate(@Param("d") Date reportDate);

	@Query("SELECT e FROM RT_Overnight_Foreign_Ccy_Data_Summ_Entity e WHERE e.report_date BETWEEN :start AND :end ORDER BY e.report_date ASC")
	List<RT_Overnight_Foreign_Ccy_Data_Summ_Entity> findByReportDateBetween(@Param("start") Date start,
			@Param("end") Date end);

	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM ORDER BY 1 DESC",
			nativeQuery = true)
	List<Date> findDistinctReportDates();

	@Query(value = "SELECT TO_CHAR(REPORT_DATE,'DD-MM-YYYY'), "
			+ "ONFC_OVER_BOUGHT, ONFC_OVER_SOLD, NOOP_OVER_BOUGHT, NOOP_OVER_SOLD, "
			+ "GAP_LIMIT, AGGREGATE_GAP_LIMIT_MAIN_CCY, AGGREGATE_GAP_LIMIT_OTHER_CCY, "
			+ "INDL_GAP_LIMIT_MAIN_CCY, INDL_GAP_LIMIT_OTHER_CCY, "
			+ "BREACH_OF_DAY_LIGHT_EXP, BREACH_OF_STOP_LOSS_LIMIT "
			+ "FROM RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM "
			+ "WHERE REPORT_DATE BETWEEN TRUNC(?1, 'MM') AND LAST_DAY(TRUNC(?1, 'MM')) "
			+ "ORDER BY REPORT_DATE", nativeQuery = true)
	List<Object[]> getDailyRiskLimitsForMonth(Date reportDate);
}
