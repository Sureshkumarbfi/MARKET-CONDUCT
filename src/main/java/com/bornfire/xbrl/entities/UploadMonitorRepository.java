package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UploadMonitorRepository extends JpaRepository<UploadMonitorEntity, String> {

    Optional<UploadMonitorEntity> findTopByReportTypeOrderByStartedAtDesc(String reportType);

    Optional<UploadMonitorEntity> findTopByReportTypeAndReportDateOrderByStartedAtDesc(String reportType, Date reportDate);

    Page<UploadMonitorEntity> findByReportTypeOrderByStartedAtDesc(String reportType, Pageable pageable);

    Page<UploadMonitorEntity> findByReportTypeAndReportDateOrderByStartedAtDesc(
            String reportType, Date reportDate, Pageable pageable);

    @Query("SELECT COALESCE(SUM(u.recordsLoaded), 0) FROM UploadMonitorEntity u "
            + "WHERE u.reportType = :reportType AND u.startedAt BETWEEN :fromDate AND :toDate")
    Long sumLoadedByReportTypeAndStartedAtWindow(
            @Param("reportType") String reportType,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate);

    @Query("SELECT u FROM UploadMonitorEntity u "
            + "WHERE u.reportType = :reportType "
            + "AND u.reportDate = :reportDate "
            + "AND u.uploadStatus = 'SUCCESS' "
            + "AND u.uploadId <> :currentUploadId "
            + "ORDER BY u.startedAt DESC")
    List<UploadMonitorEntity> findPreviousSuccessfulForSameReportDate(
            @Param("reportType") String reportType,
            @Param("reportDate") Date reportDate,
            @Param("currentUploadId") String currentUploadId,
            Pageable pageable);

    @Query("SELECT DISTINCT u.reportDate FROM UploadMonitorEntity u WHERE u.reportType = :reportType "
            + "AND u.uploadStatus IN ('SUCCESS', 'REPLACED')")
    List<Date> findDistinctSuccessfulReportDatesByReportType(@Param("reportType") String reportType);
}
