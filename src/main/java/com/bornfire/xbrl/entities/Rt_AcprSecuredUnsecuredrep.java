package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Rt_AcprSecuredUnsecuredrep extends JpaRepository<Rt_AcprSecuredUnsecuredEntity, Date> {
	@Query(value=" WITH current_year_dates AS (\r\n" + 
			"    SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) AS month_end\r\n" + 
			"    FROM dual\r\n" + 
			"    CONNECT BY LEVEL <= 12\r\n" + 
			"),\r\n" + 
			"monthly_sum AS (\r\n" + 
			"    SELECT \r\n" + 
			"        TRUNC(report_date, 'MM') AS month_start,\r\n" + 
			"        SUM(total_ratio) AS total_ratio\r\n" + 
			"    FROM rt_acpr_secured_unsecured\r\n" + 
			"    GROUP BY TRUNC(report_date, 'MM')\r\n" + 
			")\r\n" + 
			"SELECT \r\n" + 
			"    TO_CHAR(a.month_end, 'DD-MM-YYYY') AS month_end,\r\n" + 
			"    NVL(b.total_ratio, 0) AS total_ratio\r\n" + 
			"FROM current_year_dates a\r\n" + 
			"LEFT JOIN monthly_sum b\r\n" + 
			"    ON TRUNC(a.month_end, 'MM') = b.month_start\r\n" + 
			"ORDER BY a.month_end ASC",nativeQuery=true)
	List<Object[]> GetCurrentyear_unsecured(Date Selecteddate);
	
	@Query(value="WITH current_month_dates AS (\r\n" + 
			"    SELECT ?1 - (LEVEL - 1) AS report_date\r\n" + 
			"    FROM dual\r\n" + 
			"    CONNECT BY LEVEL <= 31 \r\n" + 
			")\r\n" + 
			"SELECT \r\n" + 
			"    TO_CHAR(a.report_date, 'DD-MM-YYYY') AS report_date,\r\n" + 
			"    NVL(b.total_ratio, 0) AS total_ratio\r\n" + 
			"FROM current_month_dates a\r\n" + 
			"LEFT JOIN rt_acpr_secured_unsecured b\r\n" + 
			"    ON TRUNC(a.report_date) = TRUNC(b.report_date)\r\n" + 
			"ORDER BY a.report_date",nativeQuery=true)
	List<Object[]> GetCurrentmonth_unsecured(Date Selecteddate);
	
	@Query(value="Select * from RT_ACPR_SECURED_UNSECURED where REPORT_DATE=TRUNC(?1) ",nativeQuery=true)
	Rt_AcprSecuredUnsecuredEntity GetSecuredUnsecuredreport(Date date);
	
}
