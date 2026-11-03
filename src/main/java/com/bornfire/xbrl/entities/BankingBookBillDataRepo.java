package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingBookBillDataRepo extends JpaRepository<BankingBookBillDataEntity, BankingBookBillDataId> {

	@Query(value = "SELECT * FROM BANKING_BOOK_BILL_DATA WHERE TRUNC(REPORT_DATE)=TRUNC(?1) ORDER BY BILL_ID", nativeQuery = true)
	List<BankingBookBillDataEntity> getListByReportDate(Date reportDate);

	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BANKING_BOOK_BILL_DATA", nativeQuery = true)
	Timestamp findLastReportDate();
}
