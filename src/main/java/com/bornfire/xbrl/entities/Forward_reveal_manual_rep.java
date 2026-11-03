package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Forward_reveal_manual_rep extends JpaRepository<Forward_reveal_manual_table, Forward_reveal_manual_id> {

	@Transactional
	@Modifying
	@Query(value="Delete from BRF_FORWARD_REVEAL_MANUAL_TABLE where report_date =?1",nativeQuery=true)
	void Deletebyreportdate(Date Report_date);
	
	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM BRF_FORWARD_REVEAL_MANUAL_TABLE", nativeQuery = true)
	List<Date> findUploadedDates();
}
