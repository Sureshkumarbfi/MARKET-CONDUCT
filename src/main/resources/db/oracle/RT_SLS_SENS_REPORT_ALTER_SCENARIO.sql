-- =============================================================================
-- RT_SLS_SENS_REPORT — scenario columns for 7-day sensitivity (position vs as-of)
-- Run once on existing RT_SLS_SENS_REPORT. Adjust schema name if needed.
-- =============================================================================

ALTER TABLE RT_SLS_SENS_REPORT ADD (
    AS_OF_DATE       DATE,
    SENS_DAY_OFFSET  NUMBER(1)
);

COMMENT ON COLUMN RT_SLS_SENS_REPORT.REPORT_DATE IS 'Position / data date (balance snapshot)';
COMMENT ON COLUMN RT_SLS_SENS_REPORT.AS_OF_DATE IS 'Maturity calculation as-of date';
COMMENT ON COLUMN RT_SLS_SENS_REPORT.SENS_DAY_OFFSET IS 'Calendar days added to position date (0-6)';

-- Backfill: one row per offset where AS_OF_DATE is null (legacy rows treated as Day 0)
UPDATE RT_SLS_SENS_REPORT
   SET SENS_DAY_OFFSET = 0,
       AS_OF_DATE = REPORT_DATE
 WHERE AS_OF_DATE IS NULL;

-- Example: expand single position-date rows into 7 scenarios (run only if you have one row per date+currency)
-- INSERT ... SELECT with CONNECT BY LEVEL <= 7 is environment-specific; prefer ETL.

CREATE INDEX IDX_RT_SLS_SENS_POS_CURR
    ON RT_SLS_SENS_REPORT (REPORT_DATE, REPORT_CURRENCY, SENS_DAY_OFFSET);
