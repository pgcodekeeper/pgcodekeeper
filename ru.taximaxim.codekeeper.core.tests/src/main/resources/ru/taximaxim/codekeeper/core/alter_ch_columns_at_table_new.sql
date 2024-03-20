CREATE TABLE default.t
(
    `a` UInt8,
    `b` Int64,
    `c` Int64,
    `c1` Int64 CODEC(LZ4HC(0)),
    `c2` Int64 ALIAS b + a,
-- after alter column c3 server will be retern "DEFAULT (b + a) + c" 
    `c3` Int64 DEFAULT b + a + c CODEC(LZ4HC(0)),
    `col11` DateTime COMMENT 'test1' CODEC(DoubleDelta, T64),
    `col13` Int32 COMMENT 'test' TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;

CREATE TABLE default.t1
(
    `a` UInt8,
    `b` UInt8,
    `c` Int64,
    `c1` Int64 DEFAULT false CODEC(LZ4HC(0)),
    `c2` Int64 DEFAULT b + a CODEC(LZ4HC(0)),
    `c3` Int64 DEFAULT b + a COMMENT 'test comment' CODEC(LZ4HC(0)),
    `col11` DateTime COMMENT 'test1' CODEC(DoubleDelta, T64),
    `col13` Int32 TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY a
SETTINGS index_granularity = 8192;