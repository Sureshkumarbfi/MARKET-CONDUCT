-- =============================================================================
-- RT_REPORT_MASTER — Oracle definition for Report Control Center
-- Run as the application schema owner. Adjust tablespace / storage as needed.
-- =============================================================================

-- New database: full create
CREATE TABLE RT_REPORT_MASTER (
    REPORT_ID          NUMBER(19)      NOT NULL,
    REPORT_NAME        VARCHAR2(200)   NOT NULL,
    IS_ACTIVE          CHAR(1)         DEFAULT 'Y' NOT NULL,
    REPORT_DATE        TIMESTAMP(6),
    REPORT_STATUS      VARCHAR2(20),
    REPORT_FREQ        VARCHAR2(20),
    TOTAL_STEPS        NUMBER(10),
    COMPLETED_STEPS    NUMBER(10),
    FAILED_STEPS       NUMBER(10),
    CONSTRAINT PK_RT_REPORT_MASTER PRIMARY KEY (REPORT_ID),
    CONSTRAINT CHK_RT_REP_ACTIVE CHECK (IS_ACTIVE IN ('Y', 'N'))
);

COMMENT ON COLUMN RT_REPORT_MASTER.REPORT_DATE IS 'Last generated / last run timestamp for the report';
COMMENT ON COLUMN RT_REPORT_MASTER.REPORT_FREQ IS 'e.g. Daily, Weekly, Monthly';
COMMENT ON COLUMN RT_REPORT_MASTER.REPORT_STATUS IS 'SUCCESS, FAILED, IN_PROGRESS, or other workflow values';
COMMENT ON COLUMN RT_REPORT_MASTER.TOTAL_STEPS IS 'Total procedure steps configured for this report';
COMMENT ON COLUMN RT_REPORT_MASTER.COMPLETED_STEPS IS 'Steps completed successfully in latest run';
COMMENT ON COLUMN RT_REPORT_MASTER.FAILED_STEPS IS 'Steps that failed in latest run';
