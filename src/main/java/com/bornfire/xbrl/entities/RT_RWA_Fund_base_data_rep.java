package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_RWA_Fund_base_data_rep extends JpaRepository<RT_RWA_Fund_base_data_entity,RT_RWA_Fund_base_id_class> {
	
	@Query(value="Select Distinct cust_id from brf95_rwa_data_fundbased fetch first 100 rows only",nativeQuery=true)
	List<String> getcustomerdetail();
	
	@Query(value="Select Distinct cust_id from brf95_rwa_data_fundbased where cust_id like '%' || ?1|| '%'",nativeQuery=true)
	List<String> Getsortingcustomerlist(String CustTermvalue);
	
	@Query(value="With ExposureWise as (Select * from (Select Branch_name,Round(sum(Balance)/1000000,2) as ExposureBal from brf95_rwa_data_fundbased Where Report_date = ?1 \r\n"
			+ "Group by Branch_name) Order by ExposureBal Desc),\r\n"
			+ "OverallBal As(Select Round(sum(Balance)/1000000,2) as Overallexposure from brf95_rwa_data_fundbased Where Report_date = ?1 )\r\n"
			+ "Select Branch_name,ExposureBal,Round(((ExposureBal/Overallexposure)*100),2) as Exposureper from ExposureWise a , OverallBal b",nativeQuery=true)
	List<Object[]> Getbranchwiseportfolio(Date Selecteddate);
	
	@Query(value="With ExposureWise as (Select * from (Select Category as Category,Round(sum(Balance)/1000000,2) as ExposureBal from brf95_rwa_data_fundbased Where Report_date = ?1 \r\n"
			+ "	and Branch_name = ?2		Group by Category) Order by ExposureBal Desc),\r\n"
			+ "			OverallBal As(Select Round(sum(Balance)/1000000,2) as Overallexposure from brf95_rwa_data_fundbased Where Report_date = ?1 )\r\n"
			+ "			Select Category,ExposureBal,Round(((ExposureBal/Overallexposure)*100),2) as Exposureper from ExposureWise a , OverallBal b",nativeQuery=true)
	List<Object[]> getcatorywiseportfolio(Date Selecteddate,String Branch_name);

	@Query(value="With ExposureWise as (Select * from (Select Category as Category,Round(sum(Balance)/1000000,2) as ExposureBal from brf95_rwa_data_fundbased Where Report_date = ?1 \r\n"
			+ "Group by Category) Order by ExposureBal Desc),\r\n"
			+ "OverallBal As(Select Round(sum(Balance)/1000000,2) as Overallexposure from brf95_rwa_data_fundbased Where Report_date = ?1 )\r\n"
			+ "Select Category,ExposureBal,Round(((ExposureBal/Overallexposure)*100),2) as Exposureper from ExposureWise a , OverallBal b",nativeQuery=true)
	List<Object[]> getoverallcategorywiseportfolio(Date Selecteddate);
	
	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
			+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
			+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and Category = ?2 and BRANCH_NAME = ?3 Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> Gettopexpposure(Date Selecteddate,String Category,String BRANCH_NAME);

	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
			+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
			+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and Category = ?2 Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> Getoveralltopexpposure(Date Selecteddate,String Category);
	
	
	//Get Top10 Total Exposure and Total RWA by branch
	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
			+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
			+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and BRANCH_NAME = ?2 Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> Gettotalexpobranch(Date Selecteddate,String BRANCH_NAME);
	
	//Get Top10 Standard Exposure
	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
			+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
			+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and BRANCH_NAME = ?2 and RWA_CLASS = 'STD' Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> Getactiveexpobranch(Date Selecteddate,String BRANCH_NAME);
	
	//Get Top10 NPA Exposure
		@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
				+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
				+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and BRANCH_NAME = ?2 and RWA_CLASS <> 'STD' Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetNPAexpobranch(Date Selecteddate,String BRANCH_NAME);
	
	//Get Top10 NPA Exposure
	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
					+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
					+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and BRANCH_NAME = ?2 and To_Number(DPD) <=30 Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetWatchlistexpobranch(Date Selecteddate,String BRANCH_NAME);
	
	//Get Top10 NPA Exposure
	@Query(value="Select * from(Select BRANCH_NAME, ACCOUNT_NAME, GL_CODE, CONST_ID, PURPOSE, SCHEME, RWA_CLASS, INT_SUSPENSE, \r\n"
						+ "			TOT_PROVISION, LIMIT, BALANCE, EXPOSURE, RW, RWA, TOTAL_DRAWN_RWA,\r\n"
						+ "			TOTAL_RWA from brf95_rwa_data_fundbased where report_date = ?1 and BRANCH_NAME = ?2 and To_Number(DPD)  > 30 Order by BALANCE Desc)fetch first 10 Rows only",nativeQuery=true)
	List<Object[]> GetOverdueexpobranch(Date Selecteddate,String BRANCH_NAME);
	
	@Query(value="With Exposuredata as (\r\n"
			+ "Select Branch_name,sum(Total_exposure) as Total_exposure,Nvl(Sum(Total_RWA),0) as Total_RWA,\r\n"
			+ "Round((Nvl(Sum(Total_RWA),0) / sum(Total_exposure)),2)*100 as Branchlevelratio,\r\n"
			+ "sum(NVL(Active_account,0)) as Active_account,Sum(NVL(Active_Exposure,0)) as Active_Exposure,\r\n"
			+ "Sum(NVL(Npa_account,0)) as Npa_account,Sum(NVL(Npa_exposure,0)) as Npa_exposure,\r\n"
			+ "NVL(SUM(Watchlist_Count),0) AS Watchlist_Count,NVL(Sum(Watchlist),0) as Watchlist ,\r\n"
			+ "NVL(SUM(Overdue_Count),0) AS Overdue_Count,NVL(Sum(Overdue),0) as Overdue From(\r\n"
			+ "Select Branch_name,Sum(Balance) Total_exposure,Sum(Total_RWA) as Total_rwa,\r\n"
			+ "case When RWA_CLASS = 'STD' Then Count(Branch_name) End as Active_account,\r\n"
			+ "case When RWA_CLASS = 'STD' Then Sum(Balance) End as Active_Exposure,\r\n"
			+ "case When RWA_CLASS <> 'STD' Then Count(Branch_name) End as Npa_account,\r\n"
			+ "case When RWA_CLASS <> 'STD' Then Sum(Balance) End as Npa_exposure,\r\n"
			+ "Case When To_Number(DPD) <= 30 Then Sum(Balance) End as Watchlist,\r\n"
			+ "Case When To_Number(DPD) <= 30 Then COUNT(Balance) End as Watchlist_Count,\r\n"
			+ "Case When To_Number(DPD) > 30 Then Sum(Balance) End as Overdue,\r\n"
			+ "Case When To_Number(DPD) > 30 Then COUNT(Balance) End as Overdue_Count\r\n"
			+ "from brf95_rwa_data_fundbased Where report_date = ?1  Group by RWA_CLASS,Branch_name,DPD) Group by Branch_name)\r\n"
			+ "Select * from Exposuredata Where Branch_name =  ?2 \r\n"
			+ "",nativeQuery=true)
	List<Object[]> Getbranchportfoliosnap(Date Selecteddate,String BRANCH_NAME);

	@Query(value="With Exposuredata as (\r\n"
			+ "Select Branch_name,sum(Total_exposure) as Total_exposure,Nvl(Sum(Total_RWA),0) as Total_RWA,\r\n"
			+ "Round((Nvl(Sum(Total_RWA),0) / sum(Total_exposure)),2)*100 as Branchlevelratio,\r\n"
			+ "sum(NVL(Active_account,0)) as Active_account,Sum(NVL(Active_Exposure,0)) as Active_Exposure,\r\n"
			+ "Sum(NVL(Npa_account,0)) as Npa_account,Sum(NVL(Npa_exposure,0)) as Npa_exposure,\r\n"
			+ "NVL(SUM(Watchlist_Count),0) AS Watchlist_Count,NVL(Sum(Watchlist),0) as Watchlist ,\r\n"
			+ "NVL(SUM(Overdue_Count),0) AS Overdue_Count,NVL(Sum(Overdue),0) as Overdue From(\r\n"
			+ "Select Branch_name,Sum(Balance) Total_exposure,Sum(Total_RWA) as Total_rwa,\r\n"
			+ "case When RWA_CLASS = 'STD' Then Count(Branch_name) End as Active_account,\r\n"
			+ "case When RWA_CLASS = 'STD' Then Sum(Balance) End as Active_Exposure,\r\n"
			+ "case When RWA_CLASS <> 'STD' Then Count(Branch_name) End as Npa_account,\r\n"
			+ "case When RWA_CLASS <> 'STD' Then Sum(Balance) End as Npa_exposure,\r\n"
			+ "Case When To_Number(DPD) <= 30 Then Sum(Balance) End as Watchlist,\r\n"
			+ "Case When To_Number(DPD) <= 30 Then COUNT(Balance) End as Watchlist_Count,\r\n"
			+ "Case When To_Number(DPD) > 30 Then Sum(Balance) End as Overdue,\r\n"
			+ "Case When To_Number(DPD) > 30 Then COUNT(Balance) End as Overdue_Count\r\n"
			+ "from brf95_rwa_data_fundbased Where report_date = ?1  Group by RWA_CLASS,Branch_name,DPD) Group by Branch_name)\r\n"
			+ "Select * from Exposuredata\r\n"
			+ "",nativeQuery=true)
	List<Object[]> Getallbranchportfoliosnap(Date Selecteddate);
	
	
	///GetSingleandGroupBorrower Detail -- Tier 1 Capital and Percentage value need to check and change once the Query id getting finalized
	@Query(value="With SingleBorrower_detail as ((Select ACCOUNT_NAME, ROUND(Sum(BALANCE)/1000000,2) AS Exposure from brf95_rwa_data_fundbased Where \r\n"
			+ "report_date = ?1  and group_name is null Group by  ACCOUNT_NAME) ORDER BY Exposure DESC\r\n"
			+ "FETCH FIRST 10 ROWS ONLY),\r\n"
			+ "Tier_1_Capital as (Select Round((r15_ratios1/1000),2) as r15_ratios1 from CAR Where report_date = ?1 )\r\n"
			+ "Select ACCOUNT_NAME, EXPOSURE,Round((EXPOSURE/r15_ratios1)*100,2) from SingleBorrower_detail a, Tier_1_Capital b",nativeQuery=true)
	List<Object[]> GetsingleExposure(Date Report_date);
	
	@Query(value="With SingleBorrower_detail as ((Select GROUP_NAME, ROUND(Sum(BALANCE)/1000000,2) AS Exposure from brf95_rwa_data_fundbased Where \r\n"
			+ "report_date = ?1  and group_name is not null Group by  GROUP_NAME) ORDER BY Exposure DESC\r\n"
			+ "FETCH FIRST 10 ROWS ONLY),\r\n"
			+ "Tier_1_Capital as (Select Round((r15_ratios1/1000),2) as r15_ratios1 from CAR Where report_date = ?1 )\r\n"
			+ "Select GROUP_NAME, EXPOSURE,Round((EXPOSURE/r15_ratios1)*100,2) from SingleBorrower_detail a, Tier_1_Capital b",nativeQuery=true)
	List<Object[]> Getgroupexposure(Date Report_date);
	
	
	//Get Outside Gcc Exposure detail
	@Query(value="With Countrywise_exposure as (\r\n"
			+ "Select EXPOSURE_COUNTRY,Round(Sum(Balance)/1000000,2) as Country_bal,Round(Sum(Total_RWA)/1000000,2) as Country_rwa from brf95_rwa_data_fundbased\r\n"
			+ "Where report_Date = ?1 and UPPER(Trim(EXPOSURE_COUNTRY)) not in ('OMAN','SAUDI ARABIA',\r\n"
			+ "'BAHRAIN','QATAR','KUWAIT','UAE','UNITED ARAB EMIRATES') Group by EXPOSURE_COUNTRY),\r\n"
			+ "Total_Exposure_balance as (Select Round(Sum(Balance)/1000000,2) as Total_balance,Round(Sum(Total_rwa)/1000000,2) as Total_rwa \r\n"
			+ "from brf95_rwa_data_fundbased where report_date = ?1 )\r\n"
			+ "Select EXPOSURE_COUNTRY,Country_bal,Country_rwa,\r\n"
			+ "Round(Country_bal/Total_balance,4)*100,Round(Country_rwa/Total_rwa,4)*100 \r\n"
			+ "from Countrywise_exposure a , Total_Exposure_balance b  ",nativeQuery=true)
	List<Object[]> GetoutsideGccExposure(Date Selecteddate);
	
	// Get Gcc Exposure detail
	@Query(value = "With Countrywise_exposure as (\r\n"
			+ "Select EXPOSURE_COUNTRY,Round(Sum(Balance)/1000000,2) as Country_bal,Round(Sum(Total_RWA)/1000000,2) as Country_rwa from brf95_rwa_data_fundbased\r\n"
			+ "Where report_Date = ?1 and UPPER(Trim(EXPOSURE_COUNTRY)) in ('OMAN','SAUDI ARABIA',\r\n"
			+ "'BAHRAIN','QATAR','KUWAIT','UAE','UNITED ARAB EMIRATES') Group by EXPOSURE_COUNTRY),\r\n"
			+ "Total_Exposure_balance as (Select  Round(Sum(Balance)/1000000,2) as Total_balance,Round(Sum(Total_rwa)/1000000,2) as Total_rwa \r\n"
			+ "from brf95_rwa_data_fundbased where report_date = ?1 )\r\n"
			+ "Select EXPOSURE_COUNTRY,Country_bal,Country_rwa,\r\n"
			+ "Round(Country_bal/Total_balance,4)*100,Round(Country_rwa/Total_rwa,4)*100 \r\n"
			+ "from Countrywise_exposure a , Total_Exposure_balance b  ", nativeQuery = true)
	List<Object[]> GetGccExposure(Date Selecteddate);
	
	//Get Outside Gcc Exposure detail
		@Query(value="With TotalFundBase as (Select Sum(Balance) as Total_bal,Sum(Total_rwa) as Total_rwa from brf95_rwa_data_fundbased \r\n"
				+ "				where report_date = ?1),\r\n"
				+ "				Only_gcc_countries as (Select Sum(Balance) as Gcc_Exposure,Sum(Total_rwa) as Gcc_rwa from brf95_rwa_data_fundbased \r\n"
				+ "				where report_date = ?1 and UPPER(Trim(EXPOSURE_COUNTRY)) in ('OMAN','SAUDI ARABIA','BAHRAIN','QATAR','KUWAIT','UAE')),\r\n"
				+ "				Outside_gcc_countries as(Select Sum(Balance) as OutGcc_Exposure,Sum(Total_rwa) as OutGcc_rwa from brf95_rwa_data_fundbased \r\n"
				+ "				where report_date = ?1 and UPPER(Trim(EXPOSURE_COUNTRY)) not in ('OMAN','SAUDI ARABIA','BAHRAIN','QATAR','KUWAIT','UAE'))\r\n"
				+ "				Select Round(c.OutGcc_Exposure/a.Total_bal,4)*100 as OutsideGcc_Exposure,Round(b.Gcc_Exposure/a.Total_bal,4)*100 Gcc_Exposure,\r\n"
				+ "				Round(c.OutGcc_rwa/a.Total_rwa,4)*100 as OutsideGcc_Rwa,Round(b.Gcc_rwa/a.Total_rwa,4)*100 Gcc_Rwa\r\n"
				+ "				from TotalFundBase a , Only_gcc_countries b ,Outside_gcc_countries c",nativeQuery=true)
		List<Object[]> CountryExpSummary(Date Selecteddate);
		
		
		//Fresh Slippage data Fetching
		@Query(value="\r\n"
				+ "With Total_balance_of_last_year as(Select LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-13)) as Tot_bal_rep_date,\r\n"
				+ "Nvl(Sum(Balance),1) Total_bal from brf95_rwa_data_fundbased where report_date = LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-13))),\r\n"
				+ "First_Quater_Npa as(\r\n"
				+ "Select LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-10)) as First_Qua_Rep_date,Nvl(Sum(Balance),0) First_bal \r\n"
				+ "from brf95_rwa_data_fundbased Where Report_date = LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-10))\r\n"
				+ "and Rwa_class not in ('STD') and NPA_DATE Between LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-13))+1 and \r\n"
				+ "LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-10))),\r\n"
				+ "Second_Quater_Npa as(\r\n"
				+ "Select LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-7)) As Second_Qua_Rep_date,Nvl(Sum(Balance),0) Second_bal\r\n"
				+ "from brf95_rwa_data_fundbased Where Report_date = LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-7))\r\n"
				+ "and Rwa_class not in ('STD') and NPA_DATE Between LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-10))+1 and \r\n"
				+ "LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-7))),\r\n"
				+ "Third_Quater as (\r\n"
				+ "Select LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-4)) As Third_Qua_Rep_date,Nvl(Sum(Balance),0) Third_bal \r\n"
				+ "from brf95_rwa_data_fundbased Where Report_date = LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-4))\r\n"
				+ "and Rwa_class not in ('STD') and NPA_DATE Between LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-7))+1 and \r\n"
				+ "LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-4))),\r\n"
				+ "Final_quater as (\r\n"
				+ "Select LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-1)) As Final_Qua_Rep_date,Nvl(Sum(Balance),0) Final_bal \r\n"
				+ "from brf95_rwa_data_fundbased Where Report_date = LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-1))\r\n"
				+ "and Rwa_class not in ('STD') and NPA_DATE Between LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-4))+1 and \r\n"
				+ "LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'),-1)))\r\n"
				+ "Select Round((e.final_bal+d.third_bal+c.second_bal+b.first_bal)/Total_bal,4)*100 Current_Ratio,\r\n"
				+ "To_char(a.Tot_bal_rep_date,'Mon - YYYY'),a.Total_bal,\r\n"
				+ "To_char(b.First_Qua_Rep_date,'Mon - YYYY'),b.First_bal,\r\n"
				+ "To_char(c.Second_Qua_Rep_date,'Mon - YYYY'),c.Second_bal,\r\n"
				+ "To_char(d.Third_Qua_Rep_date,'Mon - YYYY'),d.Third_bal,\r\n"
				+ "To_char(e.Final_Qua_Rep_date,'Mon - YYYY'),e.Final_bal \r\n"
				+ "from Total_balance_of_last_year a,First_Quater_Npa b,Second_Quater_Npa c,Third_Quater d,Final_quater e",nativeQuery=true)
		List<Object[]> Freshslippage(Date Selecteddate);
		
		//Sector Calculation
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance,sector_classification \r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification = 'Industry' \r\n"
				+ "Group by sector_classification),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> Industry_Classifi(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '11') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> Industry_ClassiGetCurrentyear(Date Selecteddate);
		
		
		
		
			
			@Query(value="Select * from(\r\n"
					+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '11') ,\r\n"
					+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
					+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
					+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
					+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
					+  "order by a.month_end asc)",nativeQuery=true)
			List<Object[]> getDailyIndustryRatio(Date Selecteddate);
			

		
		
		
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance,sector_classification \r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification = 'Trading' \r\n"
				+ "Group by sector_classification),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> Trading_Classifi(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '12') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> Trading_ClassiGetCurrentyear(Date Selecteddate);
		
		
		
		
		
			@Query(value="Select * from(\r\n"
					+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '12') ,\r\n"
					+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
					+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
					+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
					+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
					+ "order by a.month_end asc)",nativeQuery=true)
			List<Object[]> getDailyTradingRatio(Date Selecteddate);
			
			
		
		
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance,sector_classification \r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification = 'Services' \r\n"
				+ "Group by sector_classification),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> Services_Classifi(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '13') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> ServicesGetCurrentyear(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '14') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> BanksGetCurrentyear(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '15') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> RealEstateGetCurrentyear(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '16') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1)) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "order by a.month_end asc)",nativeQuery=true)
		List<Object[]> otherGetCurrentyear(Date Selecteddate);
		
		
		
		
			
			
			@Query(value="Select * from(\r\n"
					+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '13') ,\r\n"
					+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
					+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
					+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
					+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
					+ "order by a.month_end asc)",nativeQuery=true)
			List<Object[]> getDailyServicesRatio(Date Selecteddate);
			
			@Query(value="Select * from(\r\n"
					+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '14') ,\r\n"
					+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
					+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
					+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
					+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
					+ "order by a.month_end asc)",nativeQuery=true)
			List<Object[]> getDailyBanks(Date Selecteddate);
			
			
				
					
					@Query(value="Select * from(\r\n"
							+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '15') ,\r\n"
							+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
							+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
							+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
							+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
							+ "order by a.month_end asc)",nativeQuery=true)
					List<Object[]> getDailyRealEstate(Date Selecteddate);
					
					@Query(value="Select * from(\r\n"
							+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '16') ,\r\n"
							+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
							+ "AS month_end FROM dual CONNECT BY LEVEL <= 31)\r\n"
							+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(POSITION_OF_MATRIX,0) \r\n"
							+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
							+ "order by a.month_end asc)",nativeQuery=true)
					List<Object[]> getDailyother(Date Selecteddate);
					
					
					
					
		
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance,sector_classification \r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification = 'Banks' \r\n"
				+ "Group by sector_classification),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> Banks_Classifi(Date Selecteddate);
		
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance,sector_classification \r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification = 'Real Estate' \r\n"
				+ "Group by sector_classification),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> RealEstate_Classifi(Date Selecteddate);
		
		
		@Query(value="With Industrial_asset As (Select ABS(SUM(balance)) As Sector_balance\r\n"
				+ "from brf95_rwa_data_fundbased Where report_date = ?1 and sector_classification not in (\r\n"
				+ "'Banks','Industry','Real Estate','Services','Trading')),\r\n"
				+ "Current_Month_bala as (Select ABS(SUM(balance)) as Total_assets from brf95_rwa_data_fundbased Where \r\n"
				+ "report_date = ?1)\r\n"
				+ "Select Round(Sector_balance/1000000,2),Round(Total_assets/1000000,2),Round(Sector_balance/Total_assets,4)*100 as Percentage\r\n"
				+ "from Industrial_asset a,Current_Month_bala b",nativeQuery=true)
		List<Object[]> Others_Classifi(Date Selecteddate);

		//Real Estate Concentration
		@Query(value="Select * from(\r\n"
				+ "With DateWise_Real_Estate_RWA as(Select Report_date,Nvl(sum(total_rwa),0) as Real_estate_total_rwa  from brf95_rwa_data_fundbased where \r\n"
				+ "Report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) and is_acct_real_estate_exp = 'Y' Group by Report_date),\r\n"
				+ "Date_wise_total_rwa as (Select Report_date,Sum(Total_rwa) as Total_rwa from brf95_rwa_data_fundbased where \r\n"
				+ "Report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) Group by Report_date),\r\n"
				+ "DateWise_Percen as (Select a.report_date as Report_date,a.Real_estate_total_rwa/b.Total_rwa as Real_Estate_perce\r\n"
				+ "from DateWise_Real_Estate_RWA a ,Date_wise_total_rwa b \r\n"
				+ "where a.report_date = b.report_date),\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
				+ "Select To_char(d.month_end,'DD-MM-YYYY'),Nvl(Round(c.REAL_ESTATE_PERCE,4)*100,0) as REAL_ESTATE_PERCE from Current_Year_dates d left join \r\n"
				+ "DateWise_Percen c on d.month_end = c.Report_date Order by d.month_end asc) ",nativeQuery=true)
		List<Object[]> GetCurrentyear_realestate_concen_per(Date Selecteddate);
		

		@Query(value="Select * from (\r\n"
				+ "With DateWise_Real_Estate_RWA as(Select Report_date,Nvl(sum(total_rwa),0) as Real_estate_total_rwa  from brf95_rwa_data_fundbased where \r\n"
				+ "Report_date BETWEEN Trunc(?1,'MM') and Last_day(Trunc(?1,'MM')) and\r\n"
				+ "is_acct_real_estate_exp = 'Y' Group by Report_date),\r\n"
				+ "Date_wise_total_rwa as (Select Report_date,Sum(Total_rwa) as Total_rwa from brf95_rwa_data_fundbased where \r\n"
				+ "Report_date BETWEEN Trunc(?1,'MM') and Last_day(Trunc(?1,'MM')) Group by Report_date),\r\n"
				+ "DateWise_Percen as (Select a.report_date as Report_date,a.Real_estate_total_rwa/b.Total_rwa as Real_Estate_perce\r\n"
				+ "from DateWise_Real_Estate_RWA a ,Date_wise_total_rwa b \r\n"
				+ "where a.report_date = b.report_date),\r\n"
				+ "Current_month_dates as(SELECT TRUNC(?1, 'MM') + (LEVEL - 1) AS month_dates FROM dual\r\n"
				+ "CONNECT BY TRUNC(?1, 'MM') + (LEVEL - 1) <= LAST_DAY(?1))\r\n"
				+ "Select To_char(d.month_dates,'DD-MM-YYYY'),Nvl(Round(c.REAL_ESTATE_PERCE,4)*100,0) as REAL_ESTATE_PERCE  from Current_month_dates d left join  \r\n"
				+ "DateWise_Percen c on d.month_dates = c.Report_date order by d.month_dates asc)",nativeQuery=true)
		List<Object[]> GetCurrentMonth_realestate_concen_per(Date Selectedreport_date);
		
		@Query(value="With Fundbase_Provision_data as(Select Report_date,Sum(balance) as Fundbalance,Sum(Int_suspense) as FundIntSuspen,\r\n"
				+ "Sum(TOT_PROVISION) as TOT_PROVISION from brf95_rwa_data_fundbased where rwa_class <> 'STD' and \r\n"
				+ "Report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )Group by Report_date),\r\n"
				+ "NonFundbase_provision as (Select Report_date,Sum(LCBG_BALANCE) as NfbBalance from brf95_rwa_data_nonfundbased\r\n"
				+ "Where class <> 'STD' and Report_date in (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) Group by Report_date),\r\n"
				+ "Provision_Cover as (Select a.Report_date as Report_date,Round(TOT_PROVISION/((a.Fundbalance+NfbBalance)-FundIntSuspen),4)*100 as Prov_Coverage\r\n"
				+ "from Fundbase_Provision_data a ,NonFundbase_provision b where a.Report_date = b.Report_date),\r\n"
				+ "MonthWise_Prov_Cov as(Select * from Provision_Cover),\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
				+ "Select To_char(a.Month_end,'DD-MM-YYYY'),Nvl(Prov_Coverage,0) from Current_Year_dates a left join Provision_Cover b on a.month_end = b.Report_date\r\n"
				+ "Order by month_end Asc",nativeQuery=true)
		List<Object[]> GetCurrentyear_prov_cover(Date Selecteddate);
		
		
		
		@Query(value="With Fundbase_Provision_data as(Select Report_date,Sum(balance) as Fundbalance,Sum(Int_suspense) as FundIntSuspen,\r\n"
				+ "Sum(TOT_PROVISION) as TOT_PROVISION from brf95_rwa_data_fundbased where rwa_class <> 'STD'\r\n"
				+ "and Report_date Between ?1 - 30  AND ?1 Group by Report_date),\r\n"
				+ "NonFundbase_provision as (Select Report_date,Sum(LCBG_BALANCE) as NfbBalance from brf95_rwa_data_nonfundbased\r\n"
				+ "Where class <> 'STD' and Report_date Between ?1 - 30  AND ?1 Group by Report_date),\r\n"
				+ "Provision_Cover as (Select a.Report_date as Report_date,Round(TOT_PROVISION/((a.Fundbalance+NfbBalance)-FundIntSuspen),4)*100 as Prov_Coverage\r\n"
				+ "from Fundbase_Provision_data a ,NonFundbase_provision b where a.Report_date = b.Report_date),\r\n"
				+ "MonthWise_Prov_Cov as(Select * from Provision_Cover),\r\n"
				+ "Current_month_dates as(SELECT ?1 - (LEVEL - 1) AS month_dates FROM dual\r\n"
				+ "CONNECT BY LEVEL <= 31)\r\n"
				+ "Select To_char(a.month_dates,'DD-MM-YYYY'),Nvl(Prov_Coverage,0) from Current_month_dates a \r\n"
				+ "left join Provision_Cover b on a.month_dates = b.Report_date Order by month_dates Asc",nativeQuery=true)
		List<Object[]> GetCurrentmonth_prov_cover(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '7') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "Where a.month_end = b.REPORT_DATE)",nativeQuery=true)
		List<Object[]> GetSelectedyearslippagedetails(Date Selecteddate);
		
		@Query(value="Select * from(With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '7') ,\r\n"
				+ "Current_Year_dates as(SELECT TRUNC(?1, 'MM') + (LEVEL - 1) AS month_end FROM dual\r\n"
				+ "CONNECT BY TRUNC(?1, 'MM') + (LEVEL - 1) <= LAST_DAY(?1))\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE\r\n"
				+ "Where a.month_end = b.REPORT_DATE)",nativeQuery=true)
		List<Object[]> GetSelectedMonthslippagedetails(Date Selecteddate);
		
		
		
		/////Get Top 10 Real Estate Details
		@Query(value="SELECT * FROM (\r\n"
				+ "Select ACCOUNT_NAME, ROUND(BALANCE/1000000,2), RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where \r\n"
				+ "Report_date = ?1 and is_acct_real_estate_exp = 'Y' ORDER BY TOTAL_RWA DESC ) FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenRealestateaccountdetail(Date Selecteddate);
		
		@Query(value="select  ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification = 'Industry' and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenSectorIndustrial(Date Selecteddate);
		
		@Query(value="select ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification = 'Trading' and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenSectorTrading(Date Selecteddate);
		
		@Query(value="select ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification = 'Services' and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenSectorServicesexcludingbank(Date Selecteddate);
		
		@Query(value="select ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification = 'Banks' and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenSectorbank(Date Selecteddate);
		
		@Query(value="select  ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification = 'Real Estate' and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenRealEstate(Date Selecteddate);
		
		@Query(value="select ACCOUNT_NAME, ROUND(BALANCE/1000000,2) as BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) from brf95_rwa_data_fundbased where sector_classification not in ('Banks','Industry','Real Estate','Services','Trading') and report_date=?1 ORDER BY TOTAL_RWA DESC FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenOtherSectors(Date Selecteddate);
		
		@Query(value="SELECT SHORT_TERM_RESO, MEDIUM_TERM_RESO, LONG_TERM_RES, SHORT_TERM_ASSET, MEDIUM_TERM_ASSET, LONG_TERM_ASSET,\r\n"
				+ "Round((LONG_TERM_RES/LONG_TERM_ASSET),4)*100 As Long_Term_Ratio,\r\n"
				+ "Round((MEDIUM_TERM_RESO+ LONG_TERM_RES)/(MEDIUM_TERM_ASSET+ LONG_TERM_ASSET),4)*100 As Medium_to_long_Term_Ratio,\r\n"
				+ "70 - Round((LONG_TERM_RES/LONG_TERM_ASSET),4)*100 Long_Term_Remai,\r\n"
				+ "80 - Round((MEDIUM_TERM_RESO+ LONG_TERM_RES)/(MEDIUM_TERM_ASSET+ LONG_TERM_ASSET),4)*100 As Medium_to_long_Term_Ratio_Remai\r\n"
				+ "FROM(Select (R39_DAY1+ R39_DAY2_7+ R39_DAY8_14+ R39_DAY15_30+ R39_DAY31_TO_2M+R39_MORE2M_TO_3M+ R39_OVER3M_TO_6M) As Short_Term_reso,\r\n"
				+ "(R39_OVER6M_TO_1Y+ R39_OVER1Y_TO_3Y) As Medium_Term_Reso,(R39_OVER3Y_TO_5Y+ R39_OVER5Y) As Long_Term_Res,\r\n"
				+ "(R70_DAY1+ R70_DAY2_7+ R70_DAY8_14+ R70_DAY15_30+ R70_DAY31_TO_2M+R70_MORE2M_TO_3M+ R70_OVER3M_TO_6M) As Short_Term_Asset,\r\n"
				+ "(R70_OVER6M_TO_1Y+ R70_OVER1Y_TO_3Y) As Medium_Term_Asset,(R70_OVER3Y_TO_5Y+ R70_OVER5Y) As Long_Term_Asset\r\n"
				+ "from RT_SLS_USD Where report_date = ?1 and report_currency = 'ONLY_AED_CCY_REPORT')",nativeQuery=true)
		List<Object[]> GetlongtermAED(Date Selecteddate);
		
		@Query(value="SELECT SHORT_TERM_RESO, MEDIUM_TERM_RESO, LONG_TERM_RES, SHORT_TERM_ASSET, MEDIUM_TERM_ASSET, LONG_TERM_ASSET,\r\n"
				+ "Round((LONG_TERM_RES/LONG_TERM_ASSET),4)*100 As Long_Term_Ratio,\r\n"
				+ "Round((MEDIUM_TERM_RESO+ LONG_TERM_RES)/(MEDIUM_TERM_ASSET+ LONG_TERM_ASSET),4)*100 As Medium_to_long_Term_Ratio,\r\n"
				+ "70 - Round((LONG_TERM_RES/LONG_TERM_ASSET),4)*100 Long_Term_Remai,\r\n"
				+ "80 - Round((MEDIUM_TERM_RESO+ LONG_TERM_RES)/(MEDIUM_TERM_ASSET+ LONG_TERM_ASSET),4)*100 As Medium_to_long_Term_Ratio_Remai\r\n"
				+ "FROM(Select (R39_DAY1+ R39_DAY2_7+ R39_DAY8_14+ R39_DAY15_30+ R39_DAY31_TO_2M+R39_MORE2M_TO_3M+ R39_OVER3M_TO_6M) As Short_Term_reso,\r\n"
				+ "(R39_OVER6M_TO_1Y+ R39_OVER1Y_TO_3Y) As Medium_Term_Reso,(R39_OVER3Y_TO_5Y+ R39_OVER5Y) As Long_Term_Res,\r\n"
				+ "(R70_DAY1+ R70_DAY2_7+ R70_DAY8_14+ R70_DAY15_30+ R70_DAY31_TO_2M+R70_MORE2M_TO_3M+ R70_OVER3M_TO_6M) As Short_Term_Asset,\r\n"
				+ "(R70_OVER6M_TO_1Y+ R70_OVER1Y_TO_3Y) As Medium_Term_Asset,(R70_OVER3Y_TO_5Y+ R70_OVER5Y) As Long_Term_Asset\r\n"
				+ "from RT_SLS_USD Where report_date = ?1 and report_currency = 'ONLY_USD_CCY_REPORT')",nativeQuery=true)
		List<Object[]> GetlongtermUSD(Date Selecteddate);

		
		@Query(value =
			    "SELECT ACCOUNT_NAME, BALANCE, RW, TOTAL_RWA FROM ( \r\n"
			    + "SELECT \r\n"
			    + "  ACCOUNT_NAME, \r\n"
			    + "  ROUND(BALANCE/1000000,2) AS BALANCE, RW, ROUND(TOTAL_RWA/1000000,2) AS TOTAL_RWA,\r\n"
			    + "  ROW_NUMBER() OVER (ORDER BY BALANCE DESC) AS rn \r\n"
			    + "FROM brf95_rwa_data_fundbased \r\n"
			    + "WHERE rwa_class <> 'STD' \r\n"
			    + "  AND npa_date BETWEEN \r\n"
			    + "    LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'), -13)) \r\n"
			    + "    AND LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'), -1)) \r\n"
			    + "  AND report_date BETWEEN \r\n"
			    + "    LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'), -13)) \r\n"
			    + "    AND LAST_DAY(ADD_MONTHS(TRUNC(?1, 'Q'), -1)) \r\n"
			    + "			    ) WHERE rn <= 10",
			    nativeQuery = true
			)
			List<Object[]> GetToptenSlippage(Date Selecteddate);

		
			@Query(value = "Select * from (\r\n"
					+ "WITH FUNDBASE_BALANCE AS (\r\n"
					+ "Select branch_name,CUST_ID,ACCOUNT_NAME,Report_date,ROUND(SUM(balance)/1000000,2) AS balance,\r\n"
					+ "ROUND(SUM(Int_suspense)/1000000,2) AS Int_suspense,ROUND(SUM(TOT_PROVISION)/1000000,2) AS TOT_PROVISION from \r\n"
					+ "brf95_rwa_data_fundbased Where report_date = ?1 AND rwa_class <> 'STD'\r\n"
					+ "GROUP BY CUST_ID,ACCOUNT_NAME,Report_date,branch_name),\r\n"
					+ "NON_FUND_BALANCE AS (Select branch_name,CUST_ID, CUST_NAME,Report_date,ROUND(Sum(LCBG_BALANCE)/1000000,2) as NfbBalance \r\n"
					+ "from brf95_rwa_data_nonfundbased Where class <> 'STD' AND report_date = ?1 GROUP BY Report_date,CUST_ID, CUST_NAME,branch_name)\r\n"
					+ "SELECT NVL(A.ACCOUNT_NAME, B.CUST_NAME) AS NAME,\r\n"
					+ "NVL(BALANCE,0) AS BALANCE,NVL(NFBBALANCE,0) AS NFBBALANCE,NVL(INT_SUSPENSE,0) AS INT_SUSPENSE, \r\n"
					+ "NVL(TOT_PROVISION,0) AS TOT_PROVISION FROM FUNDBASE_BALANCE A FULL JOIN NON_FUND_BALANCE B ON \r\n"
					+ "(A.REPORT_DATE = B.REPORT_DATE AND A.CUST_ID = B.CUST_ID))Order by BALANCE desc fetch first 10 rows only",nativeQuery = true)
				List<Object[]> GetToptenProvision(Date Selecteddate);

		///Get Outside Gcc Exposure Current Year Graph
		@Query(value="Select To_char(month_end,'DD-MM-YYYY'),Countrywise_exposure from (With Countrywise_exposure as (\r\n"
				+ "Select report_Date,Sum(Balance) as Country_bal from brf95_rwa_data_fundbased\r\n"
				+ "Where report_Date  IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) and UPPER(Trim(EXPOSURE_COUNTRY)) not in ('OMAN','SAUDI ARABIA',\r\n"
				+ "'BAHRAIN','QATAR','KUWAIT','UAE') Group by report_Date),\r\n"
				+ "Total_Exposure_balance as (Select report_Date,Sum(Balance) as Total_balance\r\n"
				+ "from brf95_rwa_data_fundbased where report_date IN (\r\n"
				+ "SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) group by report_Date),\r\n"
				+ "PercentageCalcu as (Select a.REPORT_DATE,Country_bal,Round(Country_bal/Total_balance,4)*100 as Countrywise_exposure\r\n"
				+ "from Countrywise_exposure a , Total_Exposure_balance b  Where A.Report_date = b.Report_date),\r\n"
				+ "Current_yeardates as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select month_end as month_end,Nvl(b.Countrywise_exposure,0) as Countrywise_exposure from Current_yeardates a Left Join \r\n"
				+ "PercentageCalcu b on a.month_end = b.REPORT_DATE  Order by month_end Asc)",nativeQuery=true)
		List<Object[]> GetSelectedMonthOutsideGccexp(Date Selecteddate);
		
		@Query(value="Select To_char(month_end,'DD-MM-YYYY'),Countrywise_exposure from (With Countrywise_exposure as (\r\n"
				+ "Select report_Date,Sum(Balance) as Country_bal from brf95_rwa_data_fundbased\r\n"
				+ "Where report_Date Between Trunc(?1,'MM') AND\r\n"
				+ "LAST_DAY(Trunc(?1,'MM'))\r\n"
				+ "and UPPER(Trim(EXPOSURE_COUNTRY)) not in ('OMAN','SAUDI ARABIA',\r\n"
				+ "'BAHRAIN','QATAR','KUWAIT','UAE') Group by report_Date),\r\n"
				+ "Total_Exposure_balance as (Select report_Date,Sum(Balance) as Total_balance\r\n"
				+ "from brf95_rwa_data_fundbased where report_date \r\n"
				+ "Between Trunc(?1,'MM') AND\r\n"
				+ "LAST_DAY(Trunc(?1,'MM')) group by report_Date),\r\n"
				+ "PercentageCalcu as (Select a.REPORT_DATE,Country_bal,Round(Country_bal/Total_balance,4)*100 as Countrywise_exposure\r\n"
				+ "from Countrywise_exposure a , Total_Exposure_balance b  Where A.Report_date = b.Report_date),\r\n"
				+ "Current_yeardates as (SELECT TRUNC(?1, 'MM') + (LEVEL - 1) AS month_end FROM dual\r\n"
				+ "CONNECT BY TRUNC(?1, 'MM') + (LEVEL - 1) <= LAST_DAY(?1))\r\n"
				+ "Select month_end as month_end,Nvl(b.Countrywise_exposure,0) as Countrywise_exposure from Current_yeardates a Left Join \r\n"
				+ "PercentageCalcu b on a.month_end = b.REPORT_DATE  Order by month_end Asc)",nativeQuery=true)
		List<Object[]> GetSelectedDayOutsideGccexp(Date Selecteddate);
		
		@Query(value="Select To_char(month_end,'DD-MM-YYYY'),Countrywise_exposure from (With Countrywise_exposure as (\r\n"
				+ "Select report_Date,Sum(Balance) as Country_bal from brf95_rwa_data_fundbased\r\n"
				+ "Where report_Date  IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) and UPPER(Trim(EXPOSURE_COUNTRY)) in ('OMAN','SAUDI ARABIA',\r\n"
				+ "'BAHRAIN','QATAR','KUWAIT','UAE') Group by report_Date),\r\n"
				+ "Total_Exposure_balance as (Select report_Date,Sum(Balance) as Total_balance\r\n"
				+ "from brf95_rwa_data_fundbased where report_date IN (\r\n"
				+ "SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12 ) group by report_Date),\r\n"
				+ "PercentageCalcu as (Select a.REPORT_DATE,Country_bal,Round(Country_bal/Total_balance,4)*100 as Countrywise_exposure\r\n"
				+ "from Countrywise_exposure a , Total_Exposure_balance b  Where A.Report_date = b.Report_date),\r\n"
				+ "Current_yeardates as (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'YEAR'), LEVEL - 1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select month_end as month_end,Nvl(b.Countrywise_exposure,0) as Countrywise_exposure from Current_yeardates a Left Join \r\n"
				+ "PercentageCalcu b on a.month_end = b.REPORT_DATE  Order by month_end Asc)",nativeQuery=true)
		List<Object[]> GetSelectedMonthGccexp(Date Selecteddate);
		
		@Query(value="Select To_char(month_end,'DD-MM-YYYY'),Countrywise_exposure from (With Countrywise_exposure as (\r\n"
				+ "Select report_Date,Sum(Balance) as Country_bal from brf95_rwa_data_fundbased\r\n"
				+ "Where report_Date Between Trunc(?1,'MM') AND\r\n"
				+ "LAST_DAY(Trunc(?1,'MM'))\r\n"
				+ "and UPPER(Trim(EXPOSURE_COUNTRY)) in ('OMAN','SAUDI ARABIA',\r\n"
				+ "'BAHRAIN','QATAR','KUWAIT','UAE') Group by report_Date),\r\n"
				+ "Total_Exposure_balance as (Select report_Date,Sum(Balance) as Total_balance\r\n"
				+ "from brf95_rwa_data_fundbased where report_date \r\n"
				+ "Between Trunc(?1,'MM') AND\r\n"
				+ "LAST_DAY(Trunc(?1,'MM')) group by report_Date),\r\n"
				+ "PercentageCalcu as (Select a.REPORT_DATE,Country_bal,Round(Country_bal/Total_balance,4)*100 as Countrywise_exposure\r\n"
				+ "from Countrywise_exposure a , Total_Exposure_balance b  Where A.Report_date = b.Report_date),\r\n"
				+ "Current_yeardates as (SELECT TRUNC(?1, 'MM') + (LEVEL - 1) AS month_end FROM dual\r\n"
				+ "CONNECT BY TRUNC(?1, 'MM') + (LEVEL - 1) <= LAST_DAY(?1))\r\n"
				+ "Select month_end as month_end,Nvl(b.Countrywise_exposure,0) as Countrywise_exposure from Current_yeardates a Left Join \r\n"
				+ "PercentageCalcu b on a.month_end = b.REPORT_DATE  Order by month_end Asc)",nativeQuery=true)
		List<Object[]> GetSelectedDayGccexp(Date Selecteddate);
	
		
		@Query(value="Select * from(With Freshslippage as(Select * from rt_matrix_monitored_table Where S_NO = '2') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) AS month_end FROM dual\r\n"
				+ "CONNECT BY LEVEL <= 31)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,nvl(POSITION_OF_MATRIX,0)\r\n"
				+ "from Current_Year_dates a left join Freshslippage b on a.month_end = b.REPORT_DATE Order by a.month_end Asc )\r\n"
				,nativeQuery=true)
		List<Object[]> GetSelectedmonSingorGroupdetails(Date Selecteddate);
		
		/////SLS AED Limit
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '38') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ " Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetLongTermResourcesLongTermAssetsaed(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '38') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ " Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDailyLongTermResourcesLongTermAssetsaed(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '39') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetLongTermResourcesLongTermAssetsUSD(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '39') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDailyLongTermResourcesLongTermAssetsUSD(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '40') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDailyLongMedTermResourcesLongMedTermAssetsaed(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '40') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetLongMedTermResourcesLongMedTermAssetsaed(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '41') ,\r\n"
				+ "Current_Year_dates as(SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1, 'MONTH'), (-LEVEL)+1))\r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 12)\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetLongMedTermResourcesLongMedTermAssetsUSD(Date Selecteddate);
		
		@Query(value="Select * from(\r\n"
				+ "With long_term_res_and_asset as(Select * from rt_matrix_monitored_table Where S_NO = '41') ,\r\n"
				+ "Current_Year_dates as(SELECT ?1 - (LEVEL - 1) \r\n"
				+ "AS month_end FROM dual CONNECT BY LEVEL <= 31 )\r\n"
				+ "Select To_char(a.month_end,'DD-MM-YYYY') as month_end,NVL(TO_NUMBER(POSITION_OF_MATRIX),0) AS POSITION_OF_MATRIX\r\n"
				+ "from Current_Year_dates a left join long_term_res_and_asset b on a.month_end = b.REPORT_DATE\r\n"
				+ "Order by a.month_end Asc)",nativeQuery=true)
		List<Object[]> GetDailyLongMedTermResourcesLongMedTermAssetsUSD(Date Selecteddate);
		
//		@Query(value="SELECT TO_CHAR(REPORT_DATE,'DD-MM-YYYY'), HEADROOMLIMIT FROM(WITH TOTAL_DEPOSITS_VALUE AS (SELECT REPORT_DATE, sum(NVL(ACCT_BALANCE_LC,0)) TOT_ACCT_BALANCE_LC\r\n"
//				+ "FROM brf2_mapping_table WHERE  report_lable_1 in ('ROW113','ROW114','ROW115','ROW118','ROW119',\r\n"
//				+ "'ROW120','ROW124','ROW125')\r\n"
//				+ "AND REPORT_DATE IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1,'YEAR'),LEVEL-1)) FROM DUAL CONNECT BY \r\n"
//				+ "LEVEL <= 12) GROUP BY REPORT_DATE),\r\n"
//				+ "CORPORATE AS (SELECT REPORT_DATE, MAX(ACCT_BALANCE_LC) AS CORP_ACCT_BALANCE_LC  FROM (\r\n"
//				+ "SELECT CUST_ID, ACCT_NAME,REPORT_DATE, sum(ACCT_BALANCE_LC) AS ACCT_BALANCE_LC\r\n"
//				+ "FROM brf2_mapping_table WHERE report_lable_1 in ('ROW113','ROW114','ROW115','ROW124','ROW125')\r\n"
//				+ "AND REPORT_DATE IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1,'YEAR'),LEVEL-1)) FROM DUAL CONNECT BY \r\n"
//				+ "LEVEL <= 12)group by CUST_ID, ACCT_NAME,REPORT_DATE ) GROUP BY  REPORT_DATE) \r\n"
//				+ "SELECT NVL(A.REPORT_DATE,B.REPORT_DATE) AS REPORT_DATE,\r\n"
//				+ "ROUND(B.CORP_ACCT_BALANCE_LC/A.TOT_ACCT_BALANCE_LC ,4)*100 as Headroomlimit\r\n"
//				+ "FROM TOTAL_DEPOSITS_VALUE A LEFT JOIN CORPORATE B ON A.REPORT_DATE = B.REPORT_DATE Order by A.REPORT_DATE ASC)",nativeQuery=true)
//		List<Object[]> GetDepositconcentrationnonretail(Date Selecteddate);
// This Query is moved to Risk Matrix table		
		
//		@Query(value="SELECT TO_CHAR(REPORT_DATE,'DD-MM-YYYY'), HEADROOMLIMIT FROM(WITH TOTAL_DEPOSITS_VALUE AS (SELECT REPORT_DATE, sum(NVL(ACCT_BALANCE_LC,0)) TOT_ACCT_BALANCE_LC\r\n"
//				+ "FROM brf2_mapping_table WHERE  report_lable_1 in ('ROW113','ROW114','ROW115','ROW118','ROW119',\r\n"
//				+ "'ROW120','ROW124','ROW125')\r\n"
//				+ "AND REPORT_DATE IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1,'YEAR'),LEVEL-1)) FROM DUAL CONNECT BY \r\n"
//				+ "LEVEL <= 12) GROUP BY REPORT_DATE),\r\n"
//				+ "CORPORATE AS (SELECT REPORT_DATE, MAX(ACCT_BALANCE_LC) AS CORP_ACCT_BALANCE_LC  FROM (\r\n"
//				+ "SELECT CUST_ID, ACCT_NAME,REPORT_DATE, sum(ACCT_BALANCE_LC) AS ACCT_BALANCE_LC\r\n"
//				+ "FROM brf2_mapping_table WHERE report_lable_1 in ('ROW118','ROW119','ROW120')\r\n"
//				+ "AND REPORT_DATE IN (SELECT LAST_DAY(ADD_MONTHS(TRUNC(?1,'YEAR'),LEVEL-1)) FROM DUAL CONNECT BY \r\n"
//				+ "LEVEL <= 12)group by CUST_ID, ACCT_NAME,REPORT_DATE ) GROUP BY  REPORT_DATE) \r\n"
//				+ "SELECT NVL(A.REPORT_DATE,B.REPORT_DATE) AS REPORT_DATE,\r\n"
//				+ "ROUND(B.CORP_ACCT_BALANCE_LC/A.TOT_ACCT_BALANCE_LC ,4)*100 as Headroomlimit\r\n"
//				+ "FROM TOTAL_DEPOSITS_VALUE A LEFT JOIN CORPORATE B ON A.REPORT_DATE = B.REPORT_DATE Order by A.REPORT_DATE ASC)",nativeQuery=true)
//		List<Object[]> GetDepositconcentrationretail(Date Selecteddate);
// This Query is moved to Risk Matrix table
		
		@Query(value="SELECT ACCT_NAME, BALANCE_IN_MN, HEADROOMLIMIT FROM (\r\n"
				+ "WITH TOTAL_DEPOSITS_VALUE AS (SELECT REPORT_DATE, sum(NVL(ACCT_BALANCE_LC,0)) TOT_ACCT_BALANCE_LC\r\n"
				+ "FROM brf2_mapping_table WHERE  report_lable_1 in ('ROW113','ROW114','ROW115','ROW118','ROW119',\r\n"
				+ "'ROW120','ROW124','ROW125')\r\n"
				+ "AND REPORT_DATE = ?1 GROUP BY REPORT_DATE),\r\n"
				+ "CORPORATE AS (\r\n"
				+ "SELECT CUST_ID, ACCT_NAME,REPORT_DATE, sum(ACCT_BALANCE_LC) AS CORP_ACCT_BALANCE_LC\r\n"
				+ "FROM brf2_mapping_table WHERE report_lable_1 in ('ROW113','ROW114','ROW115','ROW124','ROW125')\r\n"
				+ "AND REPORT_DATE = ?1 group by CUST_ID, ACCT_NAME,REPORT_DATE ) \r\n"
				+ "SELECT NVL(A.REPORT_DATE,B.REPORT_DATE) AS REPORT_DATE,B.CUST_ID, B.ACCT_NAME, ROUND(B.CORP_ACCT_BALANCE_LC/1000000,2) AS BALANCE_IN_MN,\r\n"
				+ "ROUND(B.CORP_ACCT_BALANCE_LC/A.TOT_ACCT_BALANCE_LC ,4)*100 as Headroomlimit\r\n"
				+ "FROM TOTAL_DEPOSITS_VALUE A LEFT JOIN CORPORATE B ON A.REPORT_DATE = B.REPORT_DATE Order by B.CORP_ACCT_BALANCE_LC DESC)\r\n"
				+ "FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenNonretaildepo(Date Selecteddate);
		
		@Query(value="SELECT ACCT_NAME, BALANCE_IN_MN, HEADROOMLIMIT FROM (\r\n"
				+ "WITH TOTAL_DEPOSITS_VALUE AS (SELECT REPORT_DATE, sum(NVL(ACCT_BALANCE_LC,0)) TOT_ACCT_BALANCE_LC\r\n"
				+ "FROM brf2_mapping_table WHERE  report_lable_1 in ('ROW113','ROW114','ROW115','ROW118','ROW119',\r\n"
				+ "'ROW120','ROW124','ROW125')\r\n"
				+ "AND REPORT_DATE = ?1 GROUP BY REPORT_DATE),\r\n"
				+ "CORPORATE AS (\r\n"
				+ "SELECT CUST_ID, ACCT_NAME,REPORT_DATE, sum(ACCT_BALANCE_LC) AS CORP_ACCT_BALANCE_LC\r\n"
				+ "FROM brf2_mapping_table WHERE report_lable_1 in ('ROW118','ROW119','ROW120')\r\n"
				+ "AND REPORT_DATE = ?1 group by CUST_ID, ACCT_NAME,REPORT_DATE ) \r\n"
				+ "SELECT NVL(A.REPORT_DATE,B.REPORT_DATE) AS REPORT_DATE,B.CUST_ID, B.ACCT_NAME, ROUND(B.CORP_ACCT_BALANCE_LC/1000000,2) AS BALANCE_IN_MN,\r\n"
				+ "ROUND(B.CORP_ACCT_BALANCE_LC/A.TOT_ACCT_BALANCE_LC ,4)*100 as Headroomlimit\r\n"
				+ "FROM TOTAL_DEPOSITS_VALUE A LEFT JOIN CORPORATE B ON A.REPORT_DATE = B.REPORT_DATE Order by B.CORP_ACCT_BALANCE_LC DESC)\r\n"
				+ "FETCH FIRST 10 ROWS ONLY",nativeQuery=true)
		List<Object[]> GetToptenretaildepo(Date Selecteddate);
	
		// Deletes records for a specific date to prevent duplicates

		@Transactional
	    @Modifying
	    @Query(value = "DELETE FROM BRF95_RWA_DATA_FUNDBASED WHERE REPORT_DATE = ?1", nativeQuery = true)
	    void deleteByReportDate(Date reportDate);

		@Query(value = "SELECT COUNT(*) FROM BRF95_RWA_DATA_FUNDBASED WHERE REPORT_DATE = ?1", nativeQuery = true)
		long existsReportDate(Date reportDate);

	    @Query(value = "SELECT DISTINCT REPORT_DATE FROM BRF95_RWA_DATA_FUNDBASED ORDER BY REPORT_DATE", nativeQuery = true)
	    List<Date> findUploadedDates();

}
