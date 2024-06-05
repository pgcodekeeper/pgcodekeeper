CREATE TABLE default.t3
(
	`d` DateTime NOT NULL,
	`a` UInt32 NOT NULL,
	`c` Int64 NOT NULL,
)
ENGINE = MergeTree
ORDER BY tuple()
TTL (toIntervalHour(c) + toStartOfHour(d)) + toIntervalHour(c)
SETTINGS index_granularity = 8192;