CREATE TABLE default.t1
(
    `d` Bool,
    `s` Bool
)
ENGINE = MergeTree
PRIMARY KEY (s, d)
ORDER BY (s, d)
SAMPLE BY d
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3
(
	`c2` Int64 DEFAULT b + a CODEC(LZ4HC(0)),
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`c3` Int64 DEFAULT b + a COMMENT 'test comment' CODEC(LZ4HC(0)),
	`col11` DateTime COMMENT 'test1' CODEC(DoubleDelta, T64),
	`col3` Int64 NOT NULL,
	`b` UInt8,
	`col13` Int32 TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY col1;