package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_IRS_SENS2_REPOSITORY extends JpaRepository<RT_IRS_SENS_ENTITIES2, String> {

	@Query(value = "SELECT * FROM RT_IRS_SENS_REPORT2 WHERE TRUNC(REPORT_DATE) = TRUNC(?1) "
			+ "AND REPORT_CURRENCY = ?2 AND NVL(SENS_DAY_OFFSET, 0) = NVL(?3, 0)", nativeQuery = true)
	List<RT_IRS_SENS_ENTITIES2> findByPositionDateAndCurrencyAndDayOffset(Date reportdate, String currency,
			Integer dayOffset);
}
