package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_IRS_SENS_Repository extends JpaRepository<RT_IRS_SENS_ENTITIES, String> {

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT ORDER BY REPORT_DATE DESC, REPORT_CURRENCY, NVL(SENS_DAY_OFFSET, 0)",
			nativeQuery = true)
	List<RT_IRS_SENS_ENTITIES> findAllForGroupedList();

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT WHERE TRUNC(REPORT_DATE) = (SELECT TRUNC(MAX(REPORT_DATE)) FROM RT_IRS_SENS_REPORT) "
			+ "AND NVL(SENS_DAY_OFFSET, 0) = 0 "
			+ "AND TO_NUMBER(SRL_NO) = (SELECT MAX(TO_NUMBER(SRL_NO)) FROM RT_IRS_SENS_REPORT "
			+ "WHERE TRUNC(REPORT_DATE) = (SELECT TRUNC(MAX(REPORT_DATE)) FROM RT_IRS_SENS_REPORT) "
			+ "AND NVL(SENS_DAY_OFFSET, 0) = 0 AND REPORT_CURRENCY = RT_IRS_SENS_REPORT.REPORT_CURRENCY) "
			+ "AND ROWNUM = 1", nativeQuery = true)
	Optional<RT_IRS_SENS_ENTITIES> findLatestReport();

	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM RT_IRS_SENS_REPORT ORDER BY 1 DESC", nativeQuery = true)
	List<Date> findDistinctPositionDates();

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT WHERE TRUNC(REPORT_DATE) = TRUNC(:positionDate) "
			+ "AND REPORT_CURRENCY = :currency ORDER BY NVL(SENS_DAY_OFFSET, 0)", nativeQuery = true)
	List<RT_IRS_SENS_ENTITIES> findScenariosByPositionDateAndCurrency(@Param("positionDate") Date positionDate,
			@Param("currency") String currency);

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT WHERE TRUNC(REPORT_DATE) = TRUNC(:positionDate) "
			+ "AND REPORT_CURRENCY = :currency AND NVL(SENS_DAY_OFFSET, 0) = :dayOffset "
			+ "AND TO_NUMBER(SRL_NO) = (SELECT MAX(TO_NUMBER(SRL_NO)) FROM RT_IRS_SENS_REPORT "
			+ "WHERE TRUNC(REPORT_DATE) = TRUNC(:positionDate) AND REPORT_CURRENCY = :currency "
			+ "AND NVL(SENS_DAY_OFFSET, 0) = :dayOffset) AND ROWNUM = 1", nativeQuery = true)
	Optional<RT_IRS_SENS_ENTITIES> findByPositionDateAndDayOffsetAndCurrency(
			@Param("positionDate") Date positionDate, @Param("dayOffset") Integer dayOffset,
			@Param("currency") String currency);

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT WHERE TRUNC(REPORT_DATE) = TRUNC(:positionDate) "
			+ "AND TRUNC(AS_OF_DATE) = TRUNC(:asOfDate) AND REPORT_CURRENCY = :currency", nativeQuery = true)
	Optional<RT_IRS_SENS_ENTITIES> findByPositionDateAndAsOfDateAndCurrency(@Param("positionDate") Date positionDate,
			@Param("asOfDate") Date asOfDate, @Param("currency") String currency);

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT WHERE TRUNC(REPORT_DATE) = TRUNC(?1) "
			+ "AND REPORT_CURRENCY IN (SELECT DISTINCT REPORT_CURRENCY FROM RT_IRS_SENS_REPORT "
			+ "WHERE TRUNC(REPORT_DATE) = TRUNC(?1)) AND NVL(SENS_DAY_OFFSET, 0) = 0", nativeQuery = true)
	List<RT_IRS_SENS_ENTITIES> findCurrenciesByPositionDate(Date reportdate);

	@Query(value = "SELECT ROUND((NVL(t1.R39_OVER3Y_TO_5Y, 0) + NVL(t1.R39_OVER5Y_TO_7Y, 0) + NVL(t1.R39_OVER7Y_TO_10Y, 0) "
			+ "+ NVL(t1.R39_OVER10Y_TO_15Y, 0) + NVL(t1.R39_OVER15Y, 0)) / "
			+ "NULLIF(NVL(t2.R70_OVER3Y_TO_5Y, 0) + NVL(t2.R70_OVER5Y_TO_7Y, 0) + NVL(t2.R70_OVER7Y_TO_10Y, 0) "
			+ "+ NVL(t2.R70_OVER10Y_TO_15Y, 0) + NVL(t2.R70_OVER15Y, 0), 0), 4) * 100 "
			+ "FROM RT_IRS_SENS_REPORT t1 "
			+ "JOIN RT_IRS_SENS_REPORT2 t2 ON TRUNC(t1.REPORT_DATE) = TRUNC(t2.REPORT_DATE) "
			+ "AND t1.REPORT_CURRENCY = t2.REPORT_CURRENCY "
			+ "AND NVL(t1.SENS_DAY_OFFSET, 0) = NVL(t2.SENS_DAY_OFFSET, 0) "
			+ "WHERE TRUNC(t1.REPORT_DATE) = TRUNC(?1) AND t1.REPORT_CURRENCY = ?2 "
			+ "AND NVL(t1.SENS_DAY_OFFSET, 0) = NVL(?3, 0)", nativeQuery = true)
	List<BigDecimal> getIrsAnalyticalLongTermRatioS2(Date reportDate, String reportCurrency, Integer dayOffset);

	@Query(value = "SELECT ROUND((NVL(t1.R39_OVER6M_TO_1Y, 0) + NVL(t1.R39_OVER1Y_TO_3Y, 0) + NVL(t1.R39_OVER3Y_TO_5Y, 0) "
			+ "+ NVL(t1.R39_OVER5Y_TO_7Y, 0) + NVL(t1.R39_OVER7Y_TO_10Y, 0) + NVL(t1.R39_OVER10Y_TO_15Y, 0) + NVL(t1.R39_OVER15Y, 0)) / "
			+ "NULLIF(NVL(t2.R70_OVER6M_TO_1Y, 0) + NVL(t2.R70_OVER1Y_TO_3Y, 0) + NVL(t2.R70_OVER3Y_TO_5Y, 0) "
			+ "+ NVL(t2.R70_OVER5Y_TO_7Y, 0) + NVL(t2.R70_OVER7Y_TO_10Y, 0) + NVL(t2.R70_OVER10Y_TO_15Y, 0) + NVL(t2.R70_OVER15Y, 0), 0), 4) * 100 "
			+ "FROM RT_IRS_SENS_REPORT t1 "
			+ "JOIN RT_IRS_SENS_REPORT2 t2 ON TRUNC(t1.REPORT_DATE) = TRUNC(t2.REPORT_DATE) "
			+ "AND t1.REPORT_CURRENCY = t2.REPORT_CURRENCY "
			+ "AND NVL(t1.SENS_DAY_OFFSET, 0) = NVL(t2.SENS_DAY_OFFSET, 0) "
			+ "WHERE TRUNC(t1.REPORT_DATE) = TRUNC(?1) AND t1.REPORT_CURRENCY = ?2 "
			+ "AND NVL(t1.SENS_DAY_OFFSET, 0) = NVL(?3, 0)", nativeQuery = true)
	List<BigDecimal> getIrsAnalyticalMedLongTermRatioS2(Date reportDate, String reportCurrency, Integer dayOffset);
}
