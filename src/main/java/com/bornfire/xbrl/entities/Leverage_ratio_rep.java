package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Leverage_ratio_rep extends JpaRepository<Leverage_ratio_entity, Date> {

	@Query(value="Select * from BRF96_SUMMARYTABLE Where report_date = ?1",nativeQuery=true)
	Leverage_ratio_entity GetLeverageration(Date Selecteddate);
	
	@Query(value="SELECT  Round(R21_TOTAL/1000,2) AS Tier_1_capital, Round(R22_TOTAL/1000,2) AS Total_exposures ,\r\n"
			+ "Round(R23_TOTAL /1000,2) AS Leverage_ratio, Round(R12_TOTAL/1000,2) AS Total_derivative_exposures ,\r\n"
			+ "Round(R20_TOTAL/1000,2) AS offbalance_sheet_expsoures,Round(R3_TOTAL/1000,2) AS onbalance_sheet_exposures FROM brf96_summarytable\r\n"
			+ "WHERE REPORT_DATE = ?1",nativeQuery=true)
	List<Object[]> GetLeverageratiodata(Date Selecteddate);
	
	@Query(value="Select To_Char(month_end,'DD-MM-YYYY'),R23_TOTAL from (With Eligibility_ratio as(Select (R23_TOTAL*100) as R23_TOTAL, REPORT_DATE from BRF96_SUMMARYTABLE),\r\n"
			+ "Month_end_data as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select a.month_end,NVL(R23_TOTAL,0) AS R23_TOTAL\r\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by a.month_end asc)"
			+ "Where R23_TOTAL <> 0",nativeQuery=true)
	List<Object[]> GetLeverageration_curryear_report(Date Selecteddate);
	
	@Query(value = "Select month_dates,R23_TOTAL from (\r\n"
			+ "With Eligibility_ratio as(Select (R23_TOTAL*100) as R23_TOTAL, REPORT_DATE from BRF96_SUMMARYTABLE),\r\n"
			+ "Current_month_date as (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select To_char(month_dates,'DD-MM-YYYY') as month_dates,NVL(R23_TOTAL,0) AS R23_TOTAL\r\n"
			+ "from Current_month_date a left join Eligibility_ratio b on \r\n"
			+ "a.month_dates = b.report_date Order by a.month_dates asc)", nativeQuery = true)
	List<Object[]> GetLeveragerationcurrentmonthgraph(Date Selecteddate);
}
