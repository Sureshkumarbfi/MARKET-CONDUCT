package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BCBUAERT_UPLOAD_MONITOR")
public class UploadMonitorEntity {

    @Id
    @Column(name = "UPLOAD_ID", length = 64, nullable = false)
    private String uploadId;

    @Column(name = "REPORT_TYPE", length = 50, nullable = false)
    private String reportType;

    @Temporal(TemporalType.DATE)
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "FILE_NAME", length = 500)
    private String fileName;

    @Column(name = "FILE_FORMAT", length = 30)
    private String fileFormat;

    @Column(name = "FILE_SIZE_BYTES")
    private Long fileSizeBytes;

    @Column(name = "UPLOAD_STATUS", length = 30, nullable = false)
    private String uploadStatus;

    @Column(name = "RECORDS_TOTAL")
    private Long recordsTotal;

    @Column(name = "RECORDS_LOADED")
    private Long recordsLoaded;

    @Column(name = "RECORDS_FAILED")
    private Long recordsFailed;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTED_AT")
    private Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDED_AT")
    private Date endedAt;

    @Column(name = "DURATION_MS")
    private Long durationMs;

    @Column(name = "UPLOADED_BY", length = 100)
    private String uploadedBy;

    @Column(name = "ERROR_SUMMARY", length = 1000)
    private String errorSummary;

    @Lob
    @Column(name = "ERROR_DETAILS")
    private String errorDetails;

    @Column(name = "IS_REUPLOAD")
    private String isReupload;

    @Column(name = "REPLACED_UPLOAD_ID", length = 64)
    private String replacedUploadId;

    /** NONE, PENDING, DELETED */
    @Column(name = "DELETE_REQUEST_STATUS", length = 20)
    private String deleteRequestStatus;

    @Column(name = "DELETE_REMARKS", length = 1000)
    private String deleteRemarks;

    @Column(name = "DELETE_REQUESTED_BY", length = 100)
    private String deleteRequestedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETE_REQUESTED_AT")
    private Date deleteRequestedAt;

    @Column(name = "DELETE_APPROVED_BY", length = 100)
    private String deleteApprovedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETE_APPROVED_AT")
    private Date deleteApprovedAt;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public Long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(Long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsLoaded() {
        return recordsLoaded;
    }

    public void setRecordsLoaded(Long recordsLoaded) {
        this.recordsLoaded = recordsLoaded;
    }

    public Long getRecordsFailed() {
        return recordsFailed;
    }

    public void setRecordsFailed(Long recordsFailed) {
        this.recordsFailed = recordsFailed;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getErrorSummary() {
        return errorSummary;
    }

    public void setErrorSummary(String errorSummary) {
        this.errorSummary = errorSummary;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getIsReupload() {
        return isReupload;
    }

    public void setIsReupload(String isReupload) {
        this.isReupload = isReupload;
    }

    public String getReplacedUploadId() {
        return replacedUploadId;
    }

    public void setReplacedUploadId(String replacedUploadId) {
        this.replacedUploadId = replacedUploadId;
    }

    public String getDeleteRequestStatus() {
        return deleteRequestStatus;
    }

    public void setDeleteRequestStatus(String deleteRequestStatus) {
        this.deleteRequestStatus = deleteRequestStatus;
    }

    public String getDeleteRemarks() {
        return deleteRemarks;
    }

    public void setDeleteRemarks(String deleteRemarks) {
        this.deleteRemarks = deleteRemarks;
    }

    public String getDeleteRequestedBy() {
        return deleteRequestedBy;
    }

    public void setDeleteRequestedBy(String deleteRequestedBy) {
        this.deleteRequestedBy = deleteRequestedBy;
    }

    public Date getDeleteRequestedAt() {
        return deleteRequestedAt;
    }

    public void setDeleteRequestedAt(Date deleteRequestedAt) {
        this.deleteRequestedAt = deleteRequestedAt;
    }

    public String getDeleteApprovedBy() {
        return deleteApprovedBy;
    }

    public void setDeleteApprovedBy(String deleteApprovedBy) {
        this.deleteApprovedBy = deleteApprovedBy;
    }

    public Date getDeleteApprovedAt() {
        return deleteApprovedAt;
    }

    public void setDeleteApprovedAt(Date deleteApprovedAt) {
        this.deleteApprovedAt = deleteApprovedAt;
    }
}
