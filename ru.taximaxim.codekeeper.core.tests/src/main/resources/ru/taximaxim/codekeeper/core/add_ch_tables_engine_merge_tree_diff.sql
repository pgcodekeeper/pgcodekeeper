CREATE TABLE default.t1
(
	`c1` integer NOT NULL,
	`c2` String NOT NULL
)
ENGINE = MergeTree
ORDER BY c1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`c1` integer NOT NULL,
	`c2` String NOT NULL
)
ENGINE = MergeTree
ORDER BY c1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_1
(
	`col1` Int64 NOT NULL COMMENT 'test',
	`col2` Float64 NOT NULL DEFAULT 0.12,
	`col3` String NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_2
(
	`col1` Int64 NOT NULL COMMENT 'test',
	`col2` Float64 NOT NULL DEFAULT 0.12,
	`col3` String NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_3
(
	`col1` Int64 NOT NULL COMMENT 'test',
	`col2` Float64 NOT NULL DEFAULT 0.12,
	`col3` String NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t5
(
	`col1` Int64 NOT NULL COMMENT 'test',
	`Col2` String NOT NULL,
	`col3` Int8 NOT NULL,
	`col2` Float64 NOT NULL DEFAULT 0.012,
	PROJECTION proj1 (SELECT col1 AS some_name, Col2, col3 ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
SAMPLE BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t6
(
	`col9` Int32 NOT NULL,
	`col10` Int32 NOT NULL,
	`col11` DateTime NOT NULL CODEC(DoubleDelta, T64),
	`col12` Nullable(Int32),
	`col13` Int32 NOT NULL TTL col11 + toIntervalDay(1),
	`col14` Int32 NOT NULL CODEC(LZ4HC(0)),
	`a` DateTime64(9, 'America/Chicago') NOT NULL
)
ENGINE = MergeTree
PARTITION BY a
PRIMARY KEY col9 AND col10
ORDER BY col9 AND col10
SETTINGS index_granularity = 8192,
	min_bytes_for_wide_part = 123
COMMENT 'TEST';

CREATE TABLE default.t7
(
	`d` DateTime NOT NULL,
	`key` UInt64 NOT NULL,
	`value` String NOT NULL
)
ENGINE = MergeTree
PARTITION BY key
ORDER BY tuple()
TTL d + toIntervalMonth(1) RECOMPRESS CODEC(ZSTD(17)),
 d + toIntervalYear(1) RECOMPRESS CODEC(LZ4HC(10))
SETTINGS index_granularity = 8192;

CREATE TABLE default.`01154_test`
(
	`col1` Int32 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

ALTER TABLE default.t4_1 ADD INDEX ind2 col3 TYPE minmax;

ALTER TABLE default.t4_1 ADD INDEX ind1 col3 TYPE minmax;

ALTER TABLE default.t4_2 ADD INDEX ind3 col3 TYPE tokenbf_v1(256, 5, 0);

ALTER TABLE default.t4_3 ADD INDEX ind4 col3 TYPE set(51);

ALTER TABLE default.t7 ADD CONSTRAINT c_check CHECK value>0;

ALTER TABLE default.`01154_test` ADD CONSTRAINT c_check_1 CHECK col1>0;
