package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Matrix_monitoring_rep extends JpaRepository<RT_Matrix_monitoring_entity, BigDecimal> {
	///Capital Adequecy Ratio - 1
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '1') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(POSITION_OF_MATRIX,0) \r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ " order by a.month_end Asc)",nativeQuery=true)
	List<Object[]> GetCapitalAdequecy_Ratio(Date Selecteddate);
	
	/// Single and Group Borrower Exposure Details - 2
	@Query(value = "Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '2') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ " order by a.month_end Asc)", nativeQuery = true)
	List<Object[]> Group_Single_Exposure_Position(Date Selecteddate);
	
	/// Real Estate Concentration - 3
	@Query(value = "Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '3') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "order by a.month_end Asc)", nativeQuery = true)
	List<Object[]> RealEstateconcentration_Position(Date Selecteddate);
	
	/// Leverage ratio - 4
		@Query(value = "Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '4') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end Asc)", nativeQuery = true)
		List<Object[]> Leverage_ratio_position(Date Selecteddate);
		
	/// Fresh slippage toTotal Advances Ratio (Q on Q) - 4
		@Query(value = "Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '7') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,TO_NUMBER(POSITION_OF_MATRIX) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "Where a.month_end = b.REPORT_DATE order by a.month_end Asc)", nativeQuery = true)
		List<Object[]> Freshslippage_position(Date Selecteddate);
	/// Deposit concentration non Retail - 42
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '42') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ " Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDepositconcentrationnonretail(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '42') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ " Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDailyDepositconcentrationnonretail(Date Selecteddate);
		
		
		/// Deposit concentration Retail - 43
				@Query(value="Select * from(\r\n"
						+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '43') ,\r\n"
						+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
						+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
						+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
						+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
						+ " Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDepositconcentrationretail(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '43') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ " Order by a.month_end Asc)",nativeQuery=true)
List<Object[]> GetDailyDepositconcentrationretail(Date Selecteddate);
		
		
				
	@Query(value = "Select * from rt_matrix_monitored_table where (S_NO, REPORT_DATE) in (Select S_NO, Max(REPORT_DATE) from rt_matrix_monitored_table\r\n"
			+ "Group by S_NO) Order by S_NO Asc", nativeQuery = true)
	List<RT_Matrix_monitoring_entity> Getcurrentdatematrixcal();
	
	@Query(value = "Select * from rt_matrix_monitored_table Where REPORT_DATE=?1 and S_NO =?2", nativeQuery = true)
	List<RT_Matrix_monitoring_entity> checkdataavail(Date Report_date,String Srl_no);
	
	@Query(value = "Select TO_CHAR(month_end,'DD-MM-YYYY') AS month_end,R15_ELIGI_LIQ_ASSETS from (\n"
			+ "With Eligibility_ratio as(\n"
			+ "Select (R15_ELIGI_LIQ_ASSETS*100) as R15_ELIGI_LIQ_ASSETS, REPORT_DATE from brf8_summarytable\n"
			+ "Where report_date in(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)),\n"
			+ "Month_end_data as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\n"
			+ "Select month_end,NVL(R15_ELIGI_LIQ_ASSETS,0) AS R15_ELIGI_LIQ_ASSETS\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by A.month_end asc)", nativeQuery = true)
	List<Object[]> GetElar_curryear_report(Date Selecteddate);

	@Query(value = "Select TO_CHAR(month_end,'DD-MM-YYYY') AS month_end,R15_ELIGI_LIQ_ASSETS from (\n"
			+ "With Eligibility_ratio as(\n"
			+ "Select (R15_ELIGI_LIQ_ASSETS*100) as R15_ELIGI_LIQ_ASSETS, REPORT_DATE from brf8_summarytable\n"
			+ "Where report_date in(SELECT ?1 - (LEVEL - 1) AS month_end FROM dual CONNECT BY LEVEL <= 31)),\n"
			+ "Month_end_data as (SELECT ?1 - (LEVEL - 1) AS month_end FROM dual CONNECT BY LEVEL <= 31)\n"
			+ "Select month_end,NVL(R15_ELIGI_LIQ_ASSETS,0) AS R15_ELIGI_LIQ_ASSETS\n"
			+ "from Month_end_data a left join Eligibility_ratio b on a.month_end = b.report_date Order by A.month_end asc)", nativeQuery = true)
	List<Object[]> GetElarcurrentmonthgraph(Date Selecteddate);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM (\r\n"
			+ "    WITH TakingWithoutSortedValue AS (\r\n"
			+ "        SELECT *\r\n"
			+ "        FROM rt_matrix_monitored_table\r\n"
			+ "        WHERE (s_no, report_date) IN (\r\n"
			+ "            SELECT s_no, MAX(report_date)\r\n"
			+ "            FROM rt_matrix_monitored_table\r\n"
			+ "            WHERE s_no <> ?2 GROUP BY s_no\r\n"
			+ "        )\r\n"
			+ "    ),\r\n"
			+ "    FetchSortedValue AS (\r\n"
			+ "        SELECT *\r\n"
			+ "        FROM rt_matrix_monitored_table\r\n"
			+ "        WHERE s_no = ?2 AND report_date = ?1)\r\n"
			+ "    SELECT\r\n"
			+ "        NVL(a.primary_num, b.primary_num)                 AS primary_num,\r\n"
			+ "        NVL(a.s_no, b.s_no)                               AS s_no,\r\n"
			+ "        NVL(a.matrix_label, b.matrix_label)               AS matrix_label,\r\n"
			+ "        NVL(a.guidelines_or_policy, b.guidelines_or_policy) AS guidelines_or_policy,\r\n"
			+ "        NVL(a.limit_assigned, b.limit_assigned)           AS limit_assigned,\r\n"
			+ "        NVL(a.position_of_matrix, b.position_of_matrix)   AS position_of_matrix,\r\n"
			+ "        NVL(a.status, b.status)                           AS status,\r\n"
			+ "        NVL(a.report_date, b.report_date)                 AS report_date\r\n"
			+ "    FROM TakingWithoutSortedValue a\r\n"
			+ "    FULL OUTER JOIN FetchSortedValue b\r\n"
			+ "        ON a.s_no = b.s_no\r\n"
			+ ")\r\n"
			+ "ORDER BY s_no ASC\r\n"
			+ "", nativeQuery = true)
	List<RT_Matrix_monitoring_entity> GetMatrixbysortedvalue(Date Report_date,String Serial_no);
	
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '47') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "Order by a.month_end asc)",nativeQuery=true)
	List<Object[]> General_provision_of_CRWA(Date Selecteddate);
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '47') ,\r\n"
			+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "Order by a.month_end asc)",nativeQuery=true)
	List<Object[]> DailyGeneral_provision_of_CRWA(Date Selecteddate);
	
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '22') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(POSITION_OF_MATRIX,0) \r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "Order by a.month_end Asc)",nativeQuery=true)
	List<Object[]> GetBPVPV01(Date Selecteddate);
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '23') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,Round(nvl(POSITION_OF_MATRIX,0)/45,4)*100 \r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
			+ "Order by a.month_end Asc)",nativeQuery=true)
	List<Object[]> GetDaylightlimit(Date Selecteddate);
	
	
	
	@Query(value="Select * from(\r\n"
			+ "With  POSITION_OF_MATRIX as(Select * from rt_matrix_monitored_table Where S_NO = '22') ,\r\n"
			+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1)\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
			+ "from Current_Year_dates a left join POSITION_OF_MATRIX b on a.month_end = b.REPORT_DATE  Order by a.month_end asc)\r\n"
			,nativeQuery=true)
	List<Object[]> GetBPVPV01Monthdetail(Date Selecteddate);
	
	@Query(value="Select * from(\r\n"
			+ "With  POSITION_OF_MATRIX as(Select * from rt_matrix_monitored_table Where S_NO = '23') ,\r\n"
			+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1)\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,Round(nvl(POSITION_OF_MATRIX,0)/45,4)*100\r\n"
			+ "from Current_Year_dates a left join POSITION_OF_MATRIX b on a.month_end = b.REPORT_DATE  Order by a.month_end asc)\r\n"
			,nativeQuery=true)
	List<Object[]> GetDaylightlimitdaily(Date Selecteddate);
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '10') ,\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE  Order by a.month_end asc)\r\n"
			,nativeQuery=true)
	List<Object[]> Exposure_Outsidegccper(Date Selecteddate);
	
	
	@Query(value="Select * from(\r\n"
			+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '10') ,\r\n"
			+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1)\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
			+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE  Order by a.month_end asc)\r\n"
			,nativeQuery=true)
	List<Object[]> Exposure_Outsidegccpermonthly(Date Selecteddate);
	
	@Query(value="Select R20_RATIOS2 As General_Provision,R22_RATIOS2 As CRWA,report_date from car Where rePort_date = ?1",nativeQuery=true)
	List<Object[]> GetSelecteddateGenepro(Date Selecteddate);

	@Query(value = "SELECT COUNT(*) FROM rt_matrix_monitored_table WHERE report_date = ?1 and s_no=?2", nativeQuery = true)
	Long countByReportDate(Date reportDate,String Serialno);

	/** Monthly (last 12 month-ends) chart series from rt_matrix_monitored_table for any S_NO. */
	@Query(value = "Select * from(\r\n"
			+ "With MatrixData as(Select REPORT_DATE, POSITION_OF_MATRIX from rt_matrix_monitored_table Where S_NO = ?2),\r\n"
			+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as chart_date, NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS position_value\r\n"
			+ "from Current_Year_dates a left join MatrixData b on a.month_end = b.REPORT_DATE\r\n"
			+ "order by a.month_end Asc)", nativeQuery = true)
	List<Object[]> GetMatrixChartMonthlyBySno(Date selectedDate, String sNo);

	/** Daily (last 31 days) chart series from rt_matrix_monitored_table for any S_NO. */
	@Query(value = "Select * from(\r\n"
			+ "With MatrixData as(Select REPORT_DATE, POSITION_OF_MATRIX from rt_matrix_monitored_table Where S_NO = ?2),\r\n"
			+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
			+ "Select To_char(a.month_end,'DD-MM-YYYY') as chart_date, NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS position_value\r\n"
			+ "from Current_Year_dates a left join MatrixData b on a.month_end = b.REPORT_DATE\r\n"
			+ "order by a.month_end Asc)", nativeQuery = true)
	List<Object[]> GetMatrixChartDailyBySno(Date selectedDate, String sNo);
	
}
