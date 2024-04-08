CREATE TABLE default.t1
(
    `d` Bool,
    `s` Bool
)
ENGINE = MergeTree
PRIMARY KEY (s, d)
ORDER BY (s, d)
SAMPLE BY s
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL DEFAULT col1 + col4,
	`col4` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
TTL col3 + toIntervalMonth(1)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;

CREATE TABLE default.t4
(
	`col1` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;

CREATE TABLE default.t5(
	`col1` Int64 NOT NULL,
	`col2` DateTime NOT NULL,
	`col3` String NOT NULL TTL col2 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY col1;

--------------------------------------------------------------------------------

ALTER TABLE `default`.`t5` ADD INDEX ind1 col1 > col4 TYPE bloom_filter GRANULARITY 1;

CREATE TABLE `default`.`t6`
(
	`col1` Int64 NOT NULL COMMENT 'test',
	`col2` Float64 NOT NULL,
	`col3` Int64,
	PROJECTION proj1 (SELECT * ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE `default`.`t8`
(
	`a` Int64 NOT NULL,
	`b` Int64 NOT NULL,
)
ENGINE = TinyLog;

--------------------------------------------------------------------------------

ALTER TABLE `default`.`t8` ADD CONSTRAINT `1c2` ASSUME (b > 10);

CREATE TABLE default.t9_1(
	`a` UInt8 NOT NULL,
	`b` UInt8 NOT NULL
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;

CREATE TABLE default.t9_2(
	`a` UInt8 NOT NULL,
	`b` UInt8 NOT NULL TTL c + toIntervalDay(1),
	`c` Date NOT NULL
)
ENGINE = MergeTree
ORDER BY a
TTL c + toIntervalDay(3)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t9_3(
	`a` UInt8 NOT NULL,
	`b` UInt8 NOT NULL TTL c + toIntervalDay(1) + d,
	`c` Date NOT NULL,
	`d` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY a
TTL c + toIntervalDay(3) + d
SETTINGS index_granularity = 8192;

CREATE TABLE default.t10 (
	`col1` Int64 NOT NULL,
	INDEX idx_t10_1 col1 TYPE minmax,
	INDEX idx_t10_2 col1 TYPE minmax
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t11
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;
