-- Overnight foreign-currency closing positions by report date and currency.
-- Aligns with application entity RT_Overnight_Foreign_Ccy_Data_Entity (REPORT_DATE + CURRENCY primary key).

CREATE TABLE RT_OVERNIGHT_FOREIGN_CCY_DATA (
    REPORT_DATE      DATE          NOT NULL,
    CURRENCY         VARCHAR2(3)   NOT NULL,
    CLOSING_POSITION NUMBER(24, 4),
    CONSTRAINT PK_RT_OVERNIGHT_FOREIGN_CCY_DATA PRIMARY KEY (REPORT_DATE, CURRENCY)
);

COMMENT ON TABLE RT_OVERNIGHT_FOREIGN_CCY_DATA IS 'Overnight foreign currency closing positions';
COMMENT ON COLUMN RT_OVERNIGHT_FOREIGN_CCY_DATA.REPORT_DATE IS 'Business date';
COMMENT ON COLUMN RT_OVERNIGHT_FOREIGN_CCY_DATA.CURRENCY IS 'ISO currency code (3 characters)';
COMMENT ON COLUMN RT_OVERNIGHT_FOREIGN_CCY_DATA.CLOSING_POSITION IS 'Closing position amount';
