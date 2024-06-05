CREATE TABLE default.t1_1
(
	`d` DateTime NOT NULL default 1,
	`a` UInt32 NOT NULL,
	`c` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY tuple()
TTL toIntervalHour(c) + toStartOfHour(d)
SETTINGS index_granularity = 8192;