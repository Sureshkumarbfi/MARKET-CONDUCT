package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_IRRBB_Data_EVE_Template_Detail_Rep extends JpaRepository<RT_IRRBB_Data_EVE_Template_Detail, RT_IRRBB_Data_EVE_Template_Detail_Id> {
	@Query(value = "SELECT * FROM BCBUAE_IRRBB_DATA_TEMPLATE_DETAIL " +
		       "WHERE REPORT_DATE = :reportDate " +
		       "AND SCENARIO = :scenario " +
		       "AND GL_LEVEL_1 = :glLevel1 " +
		       "AND GL_LEVEL_2 = :glLevel2 " +
		       "AND GL_LEVEL_3 = :glLevel3 " +
		       "AND OPTION_TYPE = :optionType " +
		       "AND RATE_TYPE = :rateType " +
		       "AND REFERENCE_RATE = :referenceRate " +
		       "AND INSTRUMENT_CURRENCY = :instrumentCurrency",
		       nativeQuery = true)
		List<RT_IRRBB_Data_EVE_Template_Detail> getAlldetails(
		       @Param("reportDate") Date reportDate,
		       @Param("scenario") String scenario,
		       @Param("glLevel1") String glLevel1,
		       @Param("glLevel2") String glLevel2,
		       @Param("glLevel3") String glLevel3,
		       @Param("optionType") String optionType,
		       @Param("rateType") String rateType,
		       @Param("referenceRate") String referenceRate,
		       @Param("instrumentCurrency") String instrumentCurrency);
}
