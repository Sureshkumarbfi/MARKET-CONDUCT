-- =============================================================================
-- RT_IRS_SENS_REPORT / RT_IRS_SENS_REPORT2 — scenario columns for 7-day sensitivity
-- Run once on existing sensitivity tables. Adjust schema name if needed.
-- =============================================================================

ALTER TABLE RT_IRS_SENS_REPORT ADD (
    AS_OF_DATE       DATE,
    SENS_DAY_OFFSET  NUMBER(1)
);

ALTER TABLE RT_IRS_SENS_REPORT2 ADD (
    AS_OF_DATE       DATE,
    SENS_DAY_OFFSET  NUMBER(1)
);

COMMENT ON COLUMN RT_IRS_SENS_REPORT.REPORT_DATE IS 'Position / data date (balance snapshot)';
COMMENT ON COLUMN RT_IRS_SENS_REPORT.AS_OF_DATE IS 'Maturity calculation as-of date';
COMMENT ON COLUMN RT_IRS_SENS_REPORT.SENS_DAY_OFFSET IS 'Calendar days added to position date (0-6)';

UPDATE RT_IRS_SENS_REPORT
   SET SENS_DAY_OFFSET = 0,
       AS_OF_DATE = REPORT_DATE
 WHERE AS_OF_DATE IS NULL;

UPDATE RT_IRS_SENS_REPORT2
   SET SENS_DAY_OFFSET = 0,
       AS_OF_DATE = REPORT_DATE
 WHERE AS_OF_DATE IS NULL;

CREATE INDEX IDX_RT_IRS_SENS_POS_CURR
    ON RT_IRS_SENS_REPORT (REPORT_DATE, REPORT_CURRENCY, SENS_DAY_OFFSET);

CREATE INDEX IDX_RT_IRS_SENS2_POS_CURR
    ON RT_IRS_SENS_REPORT2 (REPORT_DATE, REPORT_CURRENCY, SENS_DAY_OFFSET);
