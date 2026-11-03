-- Add step-count columns to an existing RT_REPORT_MASTER table.
-- Run once. If ORA-01430 (column being added already exists), skip.

ALTER TABLE RT_REPORT_MASTER ADD (
    TOTAL_STEPS        NUMBER(10),
    COMPLETED_STEPS    NUMBER(10),
    FAILED_STEPS       NUMBER(10)
);
