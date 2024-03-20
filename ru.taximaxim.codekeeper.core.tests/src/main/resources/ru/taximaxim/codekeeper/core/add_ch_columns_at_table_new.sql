CREATE TABLE default.t1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Int64 NOT NULL,
	`b` UInt8,
	`col13` Int32 TTL col11 + toIntervalDay(1)
)
ENGINE = MergeTree
ORDER BY col1;