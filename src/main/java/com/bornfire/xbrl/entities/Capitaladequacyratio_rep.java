package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Capitaladequacyratio_rep extends JpaRepository<Capitaladequacyratio_entity, Date> {

	@Query(value="Select * from BRF95_SUMMARYTABLE where report_date = ?1",nativeQuery=true)
	Capitaladequacyratio_entity Getcapitalrationdetail(Date Selecteddate);
	
	@Query(value="Select To_char(month_end,'DD-MM-YYYY') as month_end,R1_RATIOS2 from (\r\n"
			+ "With Eligibility_ratio as(Select (R1_RATIOS2) as R1_RATIOS2, REPORT_DATE from BRF95_SUMMARYTABLE),\r\n"
			+ "Month_end_data as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select month_end,NVL(R1_RATIOS2,0) AS R1_RATIOS2\r\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by month_end asc) Where R1_RATIOS2 <> 0",nativeQuery=true)
	List<Object[]> GetCapitalratio_curryear_report(Date Selecteddate);
	
	@Query(value = "Select To_char(month_dates,'DD-MM-YYYY') as month_end,R1_RATIOS2 from (\r\n"
			+ "With Eligibility_ratio as(Select (R1_RATIOS2) as R1_RATIOS2, REPORT_DATE from BRF95_SUMMARYTABLE),\r\n"
			+ "Current_month_date as (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select month_dates,NVL(R1_RATIOS2,0) AS R1_RATIOS2\r\n"
			+ "from Current_month_date a left join Eligibility_ratio b on a.month_dates = b.report_date Order by month_dates asc) \r\n"
			, nativeQuery = true)
	List<Object[]> GetCapitalratio_currentmonthgraph(Date Selecteddate);
	
	@Query(value = "Select Round(r15_ratios1/1000,2) as r15_ratios1,Round(r22_ratios2/1000,2) as r22_ratios2,Round(r16_ratios1/1000,2) as r16_ratios1,\r\n"
			+ "Round(r18_ratios1/1000,2) as r18_ratios1,Round(r23_ratios1/1000,2) as r23_ratios1,Round(r23_ratios2/1000,2) as r23_ratios2,\r\n"
			+ "Round(r45_ratios2/1000,2) as r45_ratios2,Round(r51_ratios2/1000,2) as r51_ratios2 from BRF95_SUMMARYTABLE Where report_date = ?1", nativeQuery = true)
	List<Object[]> GetCapitalAdequecyvalues(Date Selecteddate);
	
	@Query(value = "Select r15_ratios1 from BRF95_SUMMARYTABLE Where report_date in ("
			+ "Select max(report_date) from BRF95_SUMMARYTABLE)", nativeQuery = true)
	String GetCurrentyear_tier_1_capital();
	
}
