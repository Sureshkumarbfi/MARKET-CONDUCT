package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF40_Rep1 extends JpaRepository<BRF40_Entity1, Date> {
	
	//individual and corporate
	@Query(value = "SELECT * FROM BRF40A_SUMMARYTABLE WHERE TO_CHAR(REPORT_DATE, 'YYYY') = ?1", nativeQuery = true)
	List<BRF40_Entity1> getassetvalues(String year);

}
