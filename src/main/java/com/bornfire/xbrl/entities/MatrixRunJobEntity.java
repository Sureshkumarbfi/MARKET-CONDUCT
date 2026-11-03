package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BCBUAERT_MATRIX_RUN_JOB")
public class MatrixRunJobEntity {

    @Id
    @Column(name = "JOB_ID", length = 64, nullable = false)
    private String jobId;

    @Temporal(TemporalType.DATE)
    @Column(name = "SELECTED_REPORT_DATE", nullable = false)
    private Date selectedReportDate;

    @Column(name = "REQUESTED_BY", length = 100)
    private String requestedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUESTED_AT")
    private Date requestedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTED_AT")
    private Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDED_AT")
    private Date endedAt;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "PROCESSED_RATIO_COUNT")
    private Long processedRatioCount;

    @Column(name = "ERROR_MESSAGE", length = 2000)
    private String errorMessage;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getSelectedReportDate() {
        return selectedReportDate;
    }

    public void setSelectedReportDate(Date selectedReportDate) {
        this.selectedReportDate = selectedReportDate;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Date getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Date requestedAt) {
        this.requestedAt = requestedAt;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProcessedRatioCount() {
        return processedRatioCount;
    }

    public void setProcessedRatioCount(Long processedRatioCount) {
        this.processedRatioCount = processedRatioCount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
