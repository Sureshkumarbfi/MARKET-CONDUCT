-- Add audit columns to existing RT_REPORT_STEP_EXEC (run once per database).
-- If a column already exists, remove that line and re-run.

ALTER TABLE RT_REPORT_STEP_EXEC ADD (
    EXEC_USER_NAME   VARCHAR2(200),
    STEP_START_TIME  TIMESTAMP(6),
    STEP_END_TIME    TIMESTAMP(6)
);

COMMENT ON COLUMN RT_REPORT_STEP_EXEC.EXEC_USER_NAME IS 'Session user who ran the step (e.g. USERID)';
COMMENT ON COLUMN RT_REPORT_STEP_EXEC.STEP_START_TIME IS 'When the step run began';
COMMENT ON COLUMN RT_REPORT_STEP_EXEC.STEP_END_TIME IS 'When the step run finished (success or failure)';
