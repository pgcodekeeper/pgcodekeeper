CREATE TABLE default.t3 
(
    `col1` Int64 COMMENT 'test', 
    `col2` Float64 DEFAULT 0.12, 
    INDEX ind2 col3 TYPE minmax GRANULARITY 1, 
    `col3` String,
    CONSTRAINT c_check CHECK col1>0
) 
ENGINE = MergeTree 
ORDER BY col1;

-----------------------------------------------------------------------

ALTER TABLE default.t3 ADD INDEX ind1 col3 TYPE minmax;

CREATE TABLE default.`01154_test`
(
    `col1` Int32,
    `col2` Int32,
    `col3` Int32,
    PRIMARY KEY (col1, col2)
)
ENGINE = MergeTree
ORDER BY (col1, col2)
SETTINGS index_granularity = 8192;