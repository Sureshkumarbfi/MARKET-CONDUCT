package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_IRRBB_RECON_Repository extends JpaRepository<RT_IRRBB_RECON, BigDecimal> {

	@Query(value = "SELECT * FROM RT_IRRBB_RECON WHERE TRUNC(REPORT_DATE) = TRUNC(?1) ORDER BY ID ASC", nativeQuery = true)
	List<RT_IRRBB_RECON> getAlldetails(Date REPORT_DATE);

	@Query(value = "SELECT * FROM RT_IRRBB_RECON WHERE REPORT_DATE = ?1 ORDER BY ID ASC", nativeQuery = true)
	List<RT_IRRBB_RECON> getDetailsByReportDate(Date REPORT_DATE);

	@Query(value = "SELECT * FROM RT_IRRBB_RECON ORDER BY ID ASC", nativeQuery = true)
	List<RT_IRRBB_RECON> getAllRecords();

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM RT_IRRBB_RECON", nativeQuery = true)
	Timestamp findLastReportDate();

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM RT_IRRBB_RECON WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM RT_IRRBB_RECON)", nativeQuery = true)
	Timestamp findSecondLastReportDate();
}
