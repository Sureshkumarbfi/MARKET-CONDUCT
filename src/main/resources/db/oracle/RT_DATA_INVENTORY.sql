-- =============================================================================
-- RT_DATA_INVENTORY — Data Inventory Dashboard configuration
-- Run as the application schema owner. Adjust tablespace / storage as needed.
-- =============================================================================

CREATE SEQUENCE RT_DATA_INVENTORY_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE RT_DATA_INVENTORY (
    INVENTORY_ID       NUMBER(19)      NOT NULL,
    REPORT_NAME        VARCHAR2(200)   NOT NULL,
    TABLE_NAME         VARCHAR2(128)   NOT NULL,
    DATE_COLUMN_NAME   VARCHAR2(128)   NOT NULL,
    EXPORT_COLUMNS     VARCHAR2(4000)  NOT NULL,
    IS_ACTIVE          CHAR(1)         DEFAULT 'Y' NOT NULL,
    SORT_ORDER         NUMBER(10)      DEFAULT 0,
    CONSTRAINT PK_RT_DATA_INVENTORY PRIMARY KEY (INVENTORY_ID),
    CONSTRAINT CHK_RT_DATA_INV_ACTIVE CHECK (IS_ACTIVE IN ('Y', 'N'))
);

CREATE INDEX IDX_RT_DATA_INV_ACTIVE ON RT_DATA_INVENTORY (IS_ACTIVE, SORT_ORDER, REPORT_NAME);

COMMENT ON TABLE RT_DATA_INVENTORY IS 'Data Inventory Dashboard: report-to-table export configuration';
COMMENT ON COLUMN RT_DATA_INVENTORY.REPORT_NAME IS 'Display name shown in the dashboard';
COMMENT ON COLUMN RT_DATA_INVENTORY.TABLE_NAME IS 'Oracle source table (uppercase)';
COMMENT ON COLUMN RT_DATA_INVENTORY.DATE_COLUMN_NAME IS 'Column used to filter by report date (e.g. REPORT_DATE, AS_OF_DATE)';
COMMENT ON COLUMN RT_DATA_INVENTORY.EXPORT_COLUMNS IS 'Comma-separated column list for SELECT export';
COMMENT ON COLUMN RT_DATA_INVENTORY.SORT_ORDER IS 'Display order (lower first)';

-- =============================================================================
-- Seed examples (uncomment and adjust table/column names for your environment)
-- =============================================================================
/*
INSERT INTO RT_DATA_INVENTORY (
    INVENTORY_ID, REPORT_NAME, TABLE_NAME, DATE_COLUMN_NAME, EXPORT_COLUMNS, IS_ACTIVE, SORT_ORDER
) VALUES (
    RT_DATA_INVENTORY_SEQ.NEXTVAL,
    'Repo Data',
    'BCBUAE_REPO_DATA_TEMPLATE',
    'REPORT_DATE',
    'REPORT_DATE,BRANCH_CODE,DEAL_REF,AMOUNT',
    'Y', 10
);

INSERT INTO RT_DATA_INVENTORY (
    INVENTORY_ID, REPORT_NAME, TABLE_NAME, DATE_COLUMN_NAME, EXPORT_COLUMNS, IS_ACTIVE, SORT_ORDER
) VALUES (
    RT_DATA_INVENTORY_SEQ.NEXTVAL,
    'FX Risk Data',
    'BCBUAE_FX_RISK_DATA',
    'REPORT_DATE',
    'REPORT_DATE,CURRENCY,EXPOSURE_AMOUNT',
    'Y', 20
);

INSERT INTO RT_DATA_INVENTORY (
    INVENTORY_ID, REPORT_NAME, TABLE_NAME, DATE_COLUMN_NAME, EXPORT_COLUMNS, IS_ACTIVE, SORT_ORDER
) VALUES (
    RT_DATA_INVENTORY_SEQ.NEXTVAL,
    'Nostro Account Balance',
    'BCBUAE_NOSTRO_ACCOUNT_BAL',
    'REPORT_DATE',
    'REPORT_DATE,ACCOUNT_NO,CURRENCY,BALANCE',
    'Y', 30
);
*/
