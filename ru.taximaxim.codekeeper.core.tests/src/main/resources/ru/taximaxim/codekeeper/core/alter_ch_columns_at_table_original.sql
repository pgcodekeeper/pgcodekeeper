CREATE TABLE default.t
(
    `a` UInt8,
    `b` UInt8,
    `c` Int64,
    `c1` Int64 DEFAULT false CODEC(LZ4HC(0)),
    `c2` Int64 DEFAULT b + a CODEC(LZ4HC(0)),
    `c3` Int64 DEFAULT b + a COMMENT 'test comment' CODEC(LZ4HC(0)),
    `c4` Int64 EPHEMERAL b + a,
    `col11` DateTime COMMENT 'test1' CODEC(DoubleDelta, T64),
    `col13` Int32 TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;

CREATE TABLE default.t1
(
    `a` UInt8,
    `b` Int64,
    `c` Int64 TTL col11 + toIntervalDay(1),
    `c1` Int64 CODEC(LZ4HC(0)),
    `c2` Int64 ALIAS b + a,
    `c3` Int64 DEFAULT b + a + c CODEC(LZ4HC(0)),
    `c4` Int64,
    `col11` DateTime COMMENT 'test1' CODEC(DoubleDelta, T64),
    `col13` Int32 COMMENT 'test' TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`a` UInt8 NOT NULL,
	`b` UInt8 NOT NULL TTL (c + toIntervalDay(1)) + d,
	`c` Date NOT NULL,
	`d` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY a
TTL c + toIntervalDay(3)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4
(
    `a` UInt8,
    `b` Int64,
    `c` Int64 ALIAS b + a + d,
    `d` Int64
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;