-- =============================================================================
-- RT_NET_POSITION_LIMIT_NOOP — RBI / FEDAI reference rates for NOOP detail export
-- =============================================================================

ALTER TABLE RT_NET_POSITION_LIMIT_NOOP ADD (
    USD_INR_FEDAI_RATE NUMBER(10, 5),
    AED_INR_FEDAI_RATE NUMBER(10, 5),
    USD_AED_FEDAI_RATE NUMBER(10, 5)
);

COMMENT ON COLUMN RT_NET_POSITION_LIMIT_NOOP.USD_INR_FEDAI_RATE IS 'RBI ref rate USD/INR (Excel N2)';
COMMENT ON COLUMN RT_NET_POSITION_LIMIT_NOOP.AED_INR_FEDAI_RATE IS 'RBI ref rate AED/INR (Excel N3)';
COMMENT ON COLUMN RT_NET_POSITION_LIMIT_NOOP.USD_AED_FEDAI_RATE IS 'RBI ref rate USD/AED (Excel N4)';
