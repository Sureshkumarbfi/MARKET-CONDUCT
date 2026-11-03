package com.bornfire.xbrl.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_TradeMarketriskDataRepository extends JpaRepository<RT_TradeMarketRiskData, Date> {

	@Query(value = "select * from BCBUAE_TRADE_MARKET_RISK_DATA where DEL_FLG != 'Y' and REPORT_DATE=?1 ", nativeQuery = true)
	List<RT_TradeMarketRiskData> getlist(Date REPORT_DATE);
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_TRADE_MARKET_RISK_DATA", nativeQuery = true)
	Timestamp findLastReportDate();
	
	@Query(value = "SELECT TRUNC(MAX(REPORT_DATE)) FROM BCBUAE_TRADE_MARKET_RISK_DATA WHERE REPORT_DATE < (SELECT MAX(REPORT_DATE) FROM BCBUAE_TRADE_MARKET_RISK_DATA)", nativeQuery = true)
	Timestamp findSecondLastReportDate();

}
