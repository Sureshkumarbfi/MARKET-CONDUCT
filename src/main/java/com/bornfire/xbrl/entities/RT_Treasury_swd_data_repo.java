package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_Treasury_swd_data_repo extends JpaRepository<RT_Treasury_swd_data_entity, RT_Treasury_swd_id_class> {

	@Transactional
	@Modifying
	@Query(value="Delete from BRF_TREASURY_SWD_TB where report_date =?1",nativeQuery=true)
	void Deletebyreportdate(Date Report_date);

	@Query(value = "SELECT DISTINCT TRUNC(REPORT_DATE) FROM BRF_TREASURY_SWD_TB", nativeQuery = true)
	List<Date> findDistinctReportDates();

}
