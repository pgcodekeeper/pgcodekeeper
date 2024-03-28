-- simple table only with column
CREATE TABLE default.t1
(
	c1 integer,
	`c2` String
)
ENGINE = MergeTree
ORDER BY c1;

-- simple table only with column with parens after engine
CREATE TABLE default.t2
(
	`c1` integer,
	`c2` String
)
ENGINE = MergeTree()
Order by c1;

-- table with index
CREATE TABLE default.t4_1 
(
    `col1` Int64 COMMENT 'test', 
    `col2` Float64 DEFAULT 0.12, 
    INDEX ind2 col3 TYPE minmax GRANULARITY 1,
    `col3` String
) 
ENGINE = MergeTree 
ORDER BY col1;

CREATE TABLE default.t4_2
(
    `col1` Int64 COMMENT 'test',
    `col2` Float64 DEFAULT 0.12,
    `col3` String,
    INDEX ind3 col3 TYPE tokenbf_v1(256, 5, 0) GRANULARITY 1
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_3
(
    `col1` Int64 COMMENT 'test',
    `col2` Float64 DEFAULT 0.12,
    `col3` String,
    INDEX ind4 col3 TYPE set(51) GRANULARITY 1
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

--------------------------------------------------------------------------

ALTER TABLE default.t4_1 ADD INDEX ind1 col3 TYPE minmax;

-- table with projection
CREATE TABLE default.t5
(
    `col1` Int64 COMMENT 'test', 
    Col2 String,
    col3 Int8,
    PROJECTION proj1 (SELECT col1 AS some_name, Col2, col3 ORDER BY col2),
    `col2` Float64 DEFAULT 0.012
) 
ENGINE = MergeTree 
ORDER BY col1
SAMPLE BY col1;

-- column with codec, null, and ttl options. table with pk
CREATE TABLE default.t6
(
    `col9` Int32,
    `col10` Int32,
    `col11` DateTime CODEC(DoubleDelta, T64),
    `col12` Nullable(Int32),
    `col13` Int32 TTL col11 + toIntervalDay(1),
    `col14` Int32 CODEC(LZ4HC(0)),
    `a` DateTime64(9, 'America/Chicago')
)
ENGINE = MergeTree
PARTITION BY a
PRIMARY KEY col9 AND col10
ORDER BY col9 AND col10
SETTINGS min_bytes_for_wide_part = 123,
index_granularity = 8192
COMMENT 'TEST';

CREATE TABLE default.t7
(
    `d` DateTime,
    `key` UInt64,
    `value` String,
    CONSTRAINT c_check CHECK value>0
)
ENGINE = MergeTree
PARTITION BY key
ORDER BY tuple()
TTL d + toIntervalMonth(1) RECOMPRESS CODEC(ZSTD(17)),
 d + toIntervalYear(1) RECOMPRESS CODEC(LZ4HC(10));

-- table with specific name
CREATE TABLE default.`01154_test`
(
    `col1` Int32
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

---------------------------------------------------------------------------------

ALTER TABLE default.`01154_test` ADD CONSTRAINT c_check_1 CHECK col1>0;
