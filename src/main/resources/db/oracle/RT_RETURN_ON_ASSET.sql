-- Return on assets (ROA) snapshot by report date.
-- Aligns with application entity RT_Return_On_Asset_Entity (REPORT_DATE is primary key).

CREATE TABLE RT_RETURN_ON_ASSET (
    NET_PROFIT                                   NUMBER(24, 2),
    DAILY_AVG_ASSETS_NET_OF_INTER_BRANCH_BORR NUMBER(24, 2),
    RETURN_ON_ASST_PER                           NUMBER(10, 2),
    REPORT_DATE                                  DATE NOT NULL,
    CONSTRAINT PK_RT_RETURN_ON_ASSET PRIMARY KEY (REPORT_DATE)
);

COMMENT ON TABLE RT_RETURN_ON_ASSET IS 'Return on net assets / ROA metrics';
COMMENT ON COLUMN RT_RETURN_ON_ASSET.REPORT_DATE IS 'Business date (one row per date)';
COMMENT ON COLUMN RT_RETURN_ON_ASSET.RETURN_ON_ASST_PER IS 'Return on assets percent';
