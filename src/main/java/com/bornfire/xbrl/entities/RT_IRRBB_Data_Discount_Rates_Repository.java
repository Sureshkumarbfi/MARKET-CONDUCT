package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_IRRBB_Data_Discount_Rates_Repository extends JpaRepository<RT_IRRBB_Data_Discount_Rates,BigDecimal> {
	
	@Query(value = "select * from BCBUAE_IRRBB_DISCOUNT_RATES where REPORT_DATE =?1 ", nativeQuery = true)
	List<RT_IRRBB_Data_Discount_Rates> getAlldetails(Date REPORT_DATE);
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_IRRBB_DISCOUNT_RATES", nativeQuery = true)
	Timestamp findLastReportDate();

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_IRRBB_DISCOUNT_RATES WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_IRRBB_DATA_TEMPLATE)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
	
	@Query(value = "SELECT * FROM BCBUAE_IRRBB_DISCOUNT_RATES where SI_NO =?1 ", nativeQuery = true)
	RT_IRRBB_Data_Discount_Rates getParticularDataBySI_NO(BigDecimal SI_NO);
	
	
	@Query(value = "SELECT * FROM BCBUAE_IRRBB_DISCOUNT_RATES where REPORT_DATE=?1", nativeQuery = true)
	List<Object[]> getirrbbdiscountratesdatalistdata1(Date REPORT_DATE);

}
