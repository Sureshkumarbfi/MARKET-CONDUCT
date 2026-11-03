-- =============================================================================
-- RT_SLS_SENS_REPORT — SLS Sensitivity (7-day scenario) table
-- See RT_SLS_SENS_REPORT_ALTER_SCENARIO.sql for AS_OF_DATE / SENS_DAY_OFFSET columns.
-- Application entity: RT_SLS_SENS_ENTITIES
-- =============================================================================

-- If creating fresh (structure mirrors RT_SLS_USD plus scenario columns):
-- CREATE TABLE RT_SLS_SENS_REPORT AS SELECT * FROM RT_SLS_USD WHERE 1=0;
-- Then run RT_SLS_SENS_REPORT_ALTER_SCENARIO.sql if columns are missing.
