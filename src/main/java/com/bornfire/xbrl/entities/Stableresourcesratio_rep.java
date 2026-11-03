package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Stableresourcesratio_rep extends JpaRepository<Stableresourcesratio_entity, Date> {
	
	@Query(value="Select * from BRF7_SUMMARYTABLE where report_date=?1",nativeQuery=true)
	Stableresourcesratio_entity Getstableresourceration(Date Selecteddate);
	
	@Query(value="Select TO_CHAR(month_end,'DD-MM-YYYY') AS month_end,R27_AMOUNT from (\r\n"
			+ "With Eligibility_ratio as(\r\n"
			+ "Select (R27_AMOUNT) as R27_AMOUNT, REPORT_DATE from BRF7_SUMMARYTABLE),\r\n"
			+ "Month_end_data as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
			+ "Select month_end,NVL(R27_AMOUNT,0) AS R27_AMOUNT\r\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by A.month_end asc)",nativeQuery=true)
	List<Object[]> GetAsrr_curryear_report(Date Selecteddate);
	
	@Query(value = "Select month_dates,R27_AMOUNT from (\r\n"
			+ "			With Eligibility_ratio as(\r\n"
			+ "			Select (R27_AMOUNT) as R27_AMOUNT, REPORT_DATE from BRF7_SUMMARYTABLE),\r\n"
			+ "			Current_month_date as (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "			CONNECT BY LEVEL <= 31 )\r\n"
			+ "			Select To_char(month_dates,'DD-MM-YYYY') AS month_dates,NVL(R27_AMOUNT,0) AS R27_AMOUNT\r\n"
			+ "			from Current_month_date a left join Eligibility_ratio b on a.month_dates = b.report_date Order by a.month_dates asc)", nativeQuery = true)
	List<Object[]> GetAsrrcurrentmonthgraph(Date Selecteddate);
	
	@Query(value="Select * from BRF7_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	Stableresourcesratio_entity GetAsrrreport(Date date);

}
