package com.bornfire.xbrl.entities;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Elar_summary_report_rep extends JpaRepository<Elar_summary_report_entity, Date> {

	@Query(value="Select * from BRF8_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	Elar_summary_report_entity Getelarreport(Date date);
	
}
