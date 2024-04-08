ALTER TABLE default.t1_1
	REMOVE TTL;

ALTER TABLE default.t1_1
	RESET SETTING storage_policy;

ALTER TABLE default.t1_1
	MODIFY SETTING min_rows_for_wide_part=0, min_bytes_for_wide_part=123;

ALTER TABLE default.t1_1
	MODIFY COMMENT '';

ALTER TABLE default.t1_2
	MODIFY TTL col3 + toIntervalMonth(1);

ALTER TABLE default.t1_2
	RESET SETTING min_rows_for_wide_part;

ALTER TABLE default.t1_2
	MODIFY SETTING storage_policy='default', min_bytes_for_wide_part=0;

ALTER TABLE default.t1_2
	MODIFY COMMENT 'test comment';

ALTER TABLE default.t2_1
	MODIFY TTL col3;

ALTER TABLE default.t2_1
	MODIFY COMMENT 'test alter comment';

ALTER TABLE default.t2_2
	MODIFY TTL col3 + toIntervalMonth(1);

ALTER TABLE default.t2_2
	MODIFY COMMENT 'test comment';

DROP TABLE default.t3_1;

DROP TABLE default.t3_2;

ALTER TABLE default.t4_1
	REMOVE SAMPLE BY;

ALTER TABLE default.t4_2
	MODIFY SAMPLE BY col1;

DROP TABLE default.t5_1;

CREATE TABLE default.t3_1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col2
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3_2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY (col1)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t5_1
(
	`col1` Int64 NOT NULL,
	`col2` DateTime64(3) NOT NULL,
	`col3` DateTime64(4) NOT NULL
)
ENGINE = MergeTree
PARTITION BY col3
ORDER BY col1
SETTINGS index_granularity = 8192;
