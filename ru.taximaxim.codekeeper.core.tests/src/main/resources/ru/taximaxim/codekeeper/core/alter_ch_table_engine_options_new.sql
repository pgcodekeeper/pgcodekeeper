CREATE TABLE default.t1_2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
	 PROJECTION proj1 (SELECT * ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
TTL col3 + toIntervalMonth(1)
SETTINGS index_granularity = 8192,
	min_bytes_for_wide_part = 0,
	storage_policy = 'default'
COMMENT 'test comment';

CREATE TABLE default.t1_1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192,
	min_bytes_for_wide_part = 123,
	min_rows_for_wide_part = 0;
	
CREATE TABLE default.t2_2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
	PROJECTION proj1 (SELECT * ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
TTL col3 + toIntervalMonth(1)
SETTINGS index_granularity = 8192
COMMENT 'test comment';

CREATE TABLE default.t2_1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
	PROJECTION proj1 (SELECT col1 AS some_name ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
TTL col3
SETTINGS index_granularity = 8192
COMMENT 'test alter comment';

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

CREATE TABLE default.t4_2
(
	`col1` Bool NOT NULL,
)
ENGINE = MergeTree
PRIMARY KEY col1
ORDER BY col1
SAMPLE BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_1
(
	`col1` Bool NOT NULL,
)
ENGINE = MergeTree
PRIMARY KEY col1
ORDER BY col1
SETTINGS index_granularity = 8192;
