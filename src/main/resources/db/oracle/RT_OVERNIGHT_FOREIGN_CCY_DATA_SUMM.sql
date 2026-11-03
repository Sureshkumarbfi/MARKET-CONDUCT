-- Overnight foreign currency / NOOP daily risk limits summary (one row per report date).

CREATE TABLE RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM (
    REPORT_DATE                      DATE          NOT NULL,
    ONFC_OVER_BOUGHT                 NUMBER(24, 4),
    ONFC_OVER_SOLD                   NUMBER(24, 4),
    NOOP_OVER_BOUGHT                 NUMBER(24, 4),
    NOOP_OVER_SOLD                   NUMBER(24, 4),
    GAP_LIMIT                        NUMBER(24, 4),
    AGGREGATE_GAP_LIMIT_MAIN_CCY     NUMBER(24, 4),
    AGGREGATE_GAP_LIMIT_OTHER_CCY    NUMBER(24, 4),
    INDL_GAP_LIMIT_MAIN_CCY          NUMBER(24, 4),
    INDL_GAP_LIMIT_OTHER_CCY         NUMBER(24, 4),
    BREACH_OF_DAY_LIGHT_EXP          VARCHAR2(3),
    BREACH_OF_STOP_LOSS_LIMIT        VARCHAR2(3),
    CONSTRAINT PK_RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM PRIMARY KEY (REPORT_DATE)
);

COMMENT ON TABLE RT_OVERNIGHT_FOREIGN_CCY_DATA_SUMM IS 'Daily risk limits monitoring summary for ONFC / NOOP';
