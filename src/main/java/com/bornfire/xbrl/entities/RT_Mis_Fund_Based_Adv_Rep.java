package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Mis_Fund_Based_Adv_Rep extends JpaRepository<RT_Mis_Fund_based_Advances_entity, RT_Mis_Fund_based_Advances_Id_Class> {
	
	@Query(value="With Top_up_loan_exp As(Select SCHEME,ABS(ROUND(Sum(BALANCE)/1000000,4)) as Mortgage_Loans_Exp from brf95_rwa_data_fundbased\r\n"
			+ "Where report_date = ?1 and SCHEME in ('LA110') group by SCHEME),\r\n"
			+ "Housing_loan_exp As(Select SCHEME,ABS(ROUND(Sum(BALANCE)/1000000,4)) as Mortgage_Loans_Exp from brf95_rwa_data_fundbased\r\n"
			+ "Where report_date = ?1 and SCHEME in ('LA106') group by SCHEME),\r\n"
			+ "Total_exposure as (Select ABS(ROUND(Sum(BALANCE)/1000000,4)) as Total_Exp from brf95_rwa_data_fundbased where report_date = ?1)\r\n"
			+ "Select b.Mortgage_Loans_Exp as Housing_loan_exp,a.Mortgage_Loans_Exp as Top_up_loan_exp,\r\n"
			+ "(b.Mortgage_Loans_Exp+a.Mortgage_Loans_Exp) Total_mortgageloan,\r\n"
			+ "Round(( (b.Mortgage_Loans_Exp+a.Mortgage_Loans_Exp) / c.Total_Exp),4)*100 as Top_up_loan_per \r\n"
			+ "from Top_up_loan_exp a,Housing_loan_exp b,Total_exposure c",nativeQuery=true)
	List<Object[]> GetMortageloanappetite(Date Selecteddate);
	
	@Query(value="Select CUST_ID, ACCOUNT_NAME, HOSUINGLOAN_EXP, Round((HOSUINGLOAN_EXP/TOTAL_BALANCE),4)*100 as Percentage from (\r\n"
			+ "With Total_Balance_val as (Select abs(Round(Sum(Balance)/1000000,2)) As Total_balance from brf95_rwa_data_fundbased where report_date = ?1  )\r\n"
			+ "Select CUST_ID, ACCOUNT_NAME, abs(Round(Sum(Balance)/1000000,2)) as Hosuingloan_exp,b.Total_balance as  from brf95_rwa_data_fundbased a, Total_balance_val b\r\n"
			+ "where report_date = ?1  AND scheme in ('LA106') Group by CUST_ID, ACCOUNT_NAME,Total_balance\r\n"
			+ ")Order by Hosuingloan_exp desc Fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetHousingloantoptencust(Date Selecteddate);
	
	@Query(value="Select CUST_ID, ACCOUNT_NAME, HOSUINGLOAN_EXP, Round((HOSUINGLOAN_EXP/TOTAL_BALANCE),4)*100 as Percentage from (\r\n"
			+ "With Total_Balance_val as (Select abs(Round(Sum(Balance)/1000000,2)) As Total_balance from brf95_rwa_data_fundbased where report_date = ?1  )\r\n"
			+ "Select CUST_ID, ACCOUNT_NAME, abs(Round(Sum(Balance)/1000000,2)) as Hosuingloan_exp,b.Total_balance as  from brf95_rwa_data_fundbased a, Total_balance_val b\r\n"
			+ "where report_date = ?1  AND scheme in ('LA110') Group by CUST_ID, ACCOUNT_NAME,Total_balance\r\n"
			+ ")Order by Hosuingloan_exp desc Fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetTopuploantoptencust(Date Selecteddate);

	@Query(value="Select CUST_ID, acct_name, HOSUINGLOAN_EXP, Round((HOSUINGLOAN_EXP/TOTAL_BALANCE),4)*100 as Percentage from (\r\n"
			+ "With Total_Balance_val as (Select abs(Sum(act_balance_amt_lc)) As Total_balance from BRF_MIS_FUND_BASED_ADVANCES where report_date = ?1  )\r\n"
			+ "Select CUST_ID, acct_name, abs(Sum(act_balance_amt_lc)) as Hosuingloan_exp,b.Total_balance as  from BRF_MIS_FUND_BASED_ADVANCES a, Total_balance_val b\r\n"
			+ "where report_date = ?1  AND schm_code in ('LA110','LA106') Group by CUST_ID, acct_name,Total_balance\r\n"
			+ ")Order by Hosuingloan_exp desc Fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetMortgageloantencust(Date Selecteddate);
	
	
	// Get Data for Graph 
	// Monthly
	@Query(value="Select To_char(month_end,'DD-MM-YYYY') as month_end,Percentage from(\r\n"
			+ "With Total_balanceP_fb as (Select Report_date,abs(sum(Balance)) as Tot_bal from brf95_rwa_data_fundbased \r\n"
			+ "Where report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)Group by Report_date),\r\n"
			+ "Mortgage_loan as (Select Report_date,abs(sum(Balance)) as Mortgage_bal from brf95_rwa_data_fundbased \r\n"
			+ "where scheme in('LA106','LA110') and report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12) Group by Report_Date),\r\n"
			+ "Mortgage_loan_cal as( Select a.Report_date as Report_date,Round(b.Mortgage_bal/a.Tot_bal,4)*100 as Percentage\r\n"
			+ "from Total_balanceP_fb a left join Mortgage_loan b on a.report_date = b.Report_date Order by a.report_date asc),\r\n"
			+ "Current_year_Dates as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
			+ "AS month_end FROM dual CONNECT BY LEVEL <= 12) \r\n"
			+ "Select a.month_end as month_end,Nvl(Percentage,0) as Percentage\r\n"
			+ "from Current_year_Dates a left join Mortgage_loan_cal b on a.month_end = b.Report_date Order by a.month_end Asc) ",nativeQuery=true)
	List<Object[]> GetMortgageratio_curryear_report(Date Selecteddate);
	
	@Query(value = "SELECT * FROM (\r\n"
			+ "Select BRANCH_NAME, CUST_ID, ACCOUNT_NAME, ROUND(SUM(BALANCE)/1000000,4) AS BALANCE\r\n"
			+ "from brf95_rwa_data_fundbased Where report_date = ?1 and scheme in ('LA106','LA110')\r\n"
			+ "GROUP BY BRANCH_NAME, CUST_ID, ACCOUNT_NAME )ORDER BY BALANCE DESC FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
		List<Object[]> GetTopteMort(Date Selecteddate);

	
	
	
	
	
	//Daily Query
	@Query(value="Select To_char(month_dates,'DD-MM-YYYY') as month_dates,Percentage from(\r\n"
			+ "			With Total_balanceP_fb as (Select Report_date,abs(sum(Balance)) as Tot_bal from brf95_rwa_data_fundbased \r\n"
			+ "			Where report_date in (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "			CONNECT BY LEVEL <= 31) Group by Report_date),\r\n"
			+ "			Mortgage_loan as (Select Report_date,abs(sum(Balance)) as Mortgage_bal from brf95_rwa_data_fundbased \r\n"
			+ "			where Scheme in('LA106','LA110') and report_date in (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "			CONNECT BY LEVEL <= 31) Group by Report_Date),\r\n"
			+ "			Mortgage_loan_cal as( Select a.Report_date as Report_date,Round(b.Mortgage_bal/a.Tot_bal,4)*100 as Percentage\r\n"
			+ "			from Total_balanceP_fb a left join Mortgage_loan b on a.report_date = b.Report_date Order by a.report_date asc),\r\n"
			+ "			Current_Month as (SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
			+ "			CONNECT BY LEVEL <= 31) \r\n"
			+ "			Select a.month_dates as month_dates,Nvl(Percentage,0) as Percentage\r\n"
			+ "			from Current_Month a left join Mortgage_loan_cal b on a.month_dates = b.Report_date Order by a.month_dates Asc)",nativeQuery=true)
	List<Object[]> GetMortgageratio_currentmonthgraph(Date Selecteddate);
	
}
