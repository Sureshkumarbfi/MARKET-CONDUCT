-- =============================================================================
-- Add configurable backend-only filters to Data Inventory exports
-- Run once on your application schema.
-- =============================================================================

ALTER TABLE RT_DATA_INVENTORY ADD (
    EXTRA_FILTERS VARCHAR2(4000)
);

COMMENT ON COLUMN RT_DATA_INVENTORY.EXTRA_FILTERS IS
'JSON: backend fixed filters (not shown on dashboard) and optional date rules.';

-- Example: filters applied in SQL only; user selects report date on dashboard only.
/*
UPDATE RT_DATA_INVENTORY
SET EXTRA_FILTERS = '{
  "filters": [
    {"column":"REPORT_LABLE_1","values":["ROW101","ROW102"]},
    {"column":"SOL_ID","values":["9001","9002"]}
  ],
  "dateNotFuture": true,
  "dateMaxDaysBack": 365
}'
WHERE INVENTORY_ID = 1;
*/

-- Alternative: single value per column
-- {"column":"SOL_ID","value":"9001"}

-- Alternative: fixedFilters array (same as filters with values)
-- {"fixedFilters":[{"column":"SOL_ID","values":["9001","9002"]}]}

COMMIT;
