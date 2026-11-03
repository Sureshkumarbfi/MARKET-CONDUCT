package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RtInvestmentDealDataDump_Rep extends JpaRepository<RtInvestmentDealDataDump, mc_invdealreportid> {
	
	@Transactional
	@Modifying
	@Query("DELETE FROM RtInvestmentDealDataDump a WHERE a.reportDate = ?1")
	void deleteByReportDate(Date reportDate);
	
	boolean existsByReportDate(Date reportDate);

	@Query("SELECT DISTINCT r.reportDate FROM RtInvestmentDealDataDump r")
	List<Date> findDistinctReportDates();

}
