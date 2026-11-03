package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RT_MC_DATA_RECORD_REPO extends JpaRepository<RT_MC_DATA_RECORD_ENTITY, MCReportDataRecordId> {

	@Query("SELECT COALESCE(MAX(r.id), 0) FROM RT_MC_DATA_RECORD_ENTITY r")
	BigDecimal findMaxId();

	@Query(value = "SELECT * FROM RT_MC_DATA_RECORD WHERE REPORT_DATE = TO_DATE(:reportDate, 'DD-MM-YYYY') AND TIMEPERIOD = :timeperiod AND VERIFY_FLG = 'Y' ", nativeQuery = true)
	List<RT_MC_DATA_RECORD_ENTITY> findByReportDateAndBranchCode(@Param("reportDate") String reportDate, @Param("timeperiod") String timeperiod);
	
	RT_MC_DATA_RECORD_ENTITY findTopByFormModeAndReportDateAndCellNameAndTimeperiodOrderByIdDesc(String formMode,
			Date reportDate, String cellName, String timeperiod);

	RecordMetadataProjection findTopProjectionByFormModeAndReportDateAndCellNameAndTimeperiodOrderByIdDesc(
			String formMode, Date reportDate, String cellName, String timeperiod);

	List<RecordMetadataProjection> findTop4ByFormModeAndCellNameAndTimeperiodOrderByReportDateDesc(String formMode,
			String cellName, String timeperiod);

	@Modifying
	@Query("UPDATE RT_MC_DATA_RECORD_ENTITY r SET r.verifyFlg = :verifyFlg, r.remarks = :remarks, r.checkerJustification = :checkerJustification WHERE r.formMode = :formMode AND r.reportDate = :reportDate AND r.cellName = :cellName AND r.timeperiod = :timeperiod")
	int updateVerifyFlg(@Param("verifyFlg") String verifyFlg, @Param("formMode") String formMode,
			@Param("reportDate") Date reportDate, @Param("cellName") String cellName, @Param("remarks") String remarks,
			@Param("timeperiod") String timeperiod, @Param("checkerJustification") String checkerJustification);

	@Modifying
	@Query("UPDATE RT_MC_DATA_RECORD_ENTITY r SET r.verifyFlg = :verifyFlg WHERE r.formMode = :formMode AND r.reportDate = :reportDate AND r.cellName = :cellName AND r.timeperiod = :timeperiod")
	int updateVerifyFlgwithoutremarks(@Param("verifyFlg") String verifyFlg, @Param("formMode") String formMode,
			@Param("reportDate") Date reportDate, @Param("cellName") String cellName,
			@Param("timeperiod") String timeperiod);

	@Modifying
	@Query("UPDATE RT_MC_DATA_RECORD_ENTITY r SET r.verifyFlg = 'Y' WHERE r.formMode = :formMode AND r.reportDate = :reportDate AND r.timeperiod = :timeperiod AND r.verifyFlg = 'MR'")
	int revertMrCellsToVerified(@Param("formMode") String formMode, @Param("reportDate") Date reportDate,
			@Param("timeperiod") String timeperiod);

	@Query(value = "SELECT COALESCE(remarks, ' - ') FROM RT_MC_DATA_RECORD " + "WHERE form_mode = :formMode "
			+ "AND report_date = :reportDate " + "AND cell_name = :cellName " + "AND timeperiod = :timeperiod "
			+ "ORDER BY id DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	String findRemarksByFormModeAndReportDateAndCellNameAndTimeperiod(@Param("formMode") String formMode,
			@Param("reportDate") Date reportDate, @Param("cellName") String cellName,
			@Param("timeperiod") String timeperiod);

	@Query(value = "SELECT COALESCE(JUSTIFICATION, ' - ') FROM RT_MC_DATA_RECORD " + "WHERE form_mode = :formMode "
			+ "AND report_date = TO_DATE(:reportDate, 'DD-MM-YYYY') " + "AND cell_name = :cellName "
			+ "AND timeperiod = :timeperiod " + "ORDER BY id DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	String findMakerJustificationByFormModeAndReportDateAndCellNameAndTimeperiod(@Param("formMode") String formMode,
			@Param("reportDate") String reportDate, @Param("cellName") String cellName,
			@Param("timeperiod") String timeperiod);

	@Query(value = "SELECT COALESCE(CHECKER_JUSTIFICATION, ' - ') FROM RT_MC_DATA_RECORD "
			+ "WHERE form_mode = :formMode " + "AND report_date = TO_DATE(:reportDate, 'DD-MM-YYYY') "
			+ "AND cell_name = :cellName " + "AND timeperiod = :timeperiod "
			+ "ORDER BY id DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	String findCheckerJustificationByFormModeAndReportDateAndCellNameAndTimeperiod(@Param("formMode") String formMode,
			@Param("reportDate") String reportDate, @Param("cellName") String cellName,
			@Param("timeperiod") String timeperiod);

	@Query("SELECT r.cellName FROM RT_MC_DATA_RECORD_ENTITY r WHERE r.verifyFlg = :verifyFlg AND r.formMode = :formMode AND r.reportDate = :reportDate AND r.timeperiod = :timeperiod")
	List<String> findCellNamesByVerifyFlg(@Param("verifyFlg") String verifyFlg, @Param("formMode") String formMode,
			@Param("reportDate") Date reportDate, @Param("timeperiod") String timeperiod);
	
	RecordMetadataProjection findTopProjectionByFormModeAndCellNameAndTimeperiodAndReportDateLessThanOrderByReportDateDesc(
			String formMode, String cellName, String timeperiod, Date reportDate);
	
	List<RecordMetadataProjection> findByFormModeAndTimeperiodAndReportDateOrderByReportDateDesc(
			String formMode, String timeperiod, Date reportDate);

	public interface RecordMetadataProjection {
		BigDecimal getId();

		String getDataValue();

		String getJustification();

		String getCheckerJustification();

		String getCellName();

		String getSource();

		Date getReportDate();

		Date getSubmittedReportDate();

		String getVerifyFlg();

		String getRemarks();

		String getModifyFlg();

		String getFileName1();

		String getFileName2();

		String getFileName3();

		String getFileName4();

		String getFileName5();

		String getFileName6();

		String getFileName7();

		String getFileName8();

		String getFileName9();

		String getFileName10();

		String getCroVerifyFlg();

		String getCroRemarks();

		String getCcoVerifyFlg();

		String getCcoRemarks();
	}

}