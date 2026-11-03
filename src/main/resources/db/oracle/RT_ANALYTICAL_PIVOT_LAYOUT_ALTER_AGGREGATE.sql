-- Optional: add SUM transform columns for saved layouts (run once if table exists without these columns)
ALTER TABLE RT_ANALYTICAL_PIVOT_LAYOUT ADD ( AGGREGATE_TRANSFORM VARCHAR2(20) );
ALTER TABLE RT_ANALYTICAL_PIVOT_LAYOUT ADD ( AGGREGATE_OPERAND VARCHAR2(50) );
