CREATE TABLE default.t1
(
	`c1` integer,
	`c2` String
)
ENGINE = MergeTree
ORDER BY c1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`c1` integer,
	`c2` String
)
ENGINE = MergeTree()
Order by c1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3
(
    `col1` Int64 COMMENT 'test',
    `col1_1` Int64 COMMENT 'test',
    `col2` Float64 DEFAULT 0.00,
    `col3` Float64 DEFAULT 0.12,
    col4 default now(),
    col5 default 'Hellow world',
    col6 default 17,
    col7 default 123571354654321658541578,
    col8 default 12345847
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4_1 
(
	`col1` Int64 COMMENT 'test', 
	`col2` Float64 DEFAULT 0.12, 
	`col3` String, 
	INDEX ind2 col3 TYPE minmax GRANULARITY 1, 
	INDEX ind1 col3 TYPE minmax GRANULARITY 1
) 
ENGINE = MergeTree 
ORDER BY col1 
SETTINGS index_granularity = 8192;

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

CREATE TABLE default.t5 
(
	`col1` Int64 COMMENT 'test', 
	`col2` Float64 DEFAULT 0.012, 
	PROJECTION proj2 (SELECT col1 AS some_name ORDER BY col2)
) 
ENGINE = MergeTree 
ORDER BY col1 
SETTINGS index_granularity = 8192;

CREATE TABLE default.t6
(

    `col9` Int32,

    `col10` Int32,

    `col11` DateTime CODEC(DoubleDelta, T64),

    `col12` Nullable(Int32),

    `col13` Int32 TTL col11 + toIntervalDay(1),

    `col14` Int32 CODEC(LZ4HC(0))
)
ENGINE = MergeTree
PRIMARY KEY col9 AND col10
ORDER BY col9 AND col10
SETTINGS index_granularity = 8192;

CREATE TABLE default.01154_test
(

    `col1` Int32
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;