package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_VAR_PORTFOLIO_Repo extends JpaRepository<RT_VAR_PORTFOLIO_Entity, Date>{

	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select Report_date,round(Round((TOTAL_VAR/1000),0)/6,2) as POSITION_OF_MATRIX \r\n"
			+ "from RT_VAR_PORTFOLIO_TABLE Where Report_date > TRUNC(?1)-60 ) ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1 , 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(POSITION_OF_MATRIX,0) \r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "order by a.month_end Asc)=?1",nativeQuery= true)
	List<Object[]>GetMonthlydata(Date Selecteddate);
	
	@Query(value="Select TO_CHAR(month_end,'DD-MM-YYYY') AS month_end,R15_ELIGI_LIQ_ASSETS from (\r\n"
			+ "With Eligibility_ratio as(Select Report_date,round(Round((TOTAL_VAR/1000),0)/6,2) as POSITION_OF_MATRIX \r\n"
			+ "from RT_VAR_PORTFOLIO_TABLE Where Report_date in(SELECT ?1 - (LEVEL - 1) AS month_end FROM dual CONNECT BY LEVEL <= 31)),\r\n"
			+ "Month_end_data as (SELECT ?1 - (LEVEL - 1) AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
			+ "Select month_end,NVL(POSITION_OF_MATRIX,0) AS POSITION_OF_MATRIX\r\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by A.month_end asc)",nativeQuery= true)
	List<Object[]>GetDailydata(Date Selecteddate);
	
}
