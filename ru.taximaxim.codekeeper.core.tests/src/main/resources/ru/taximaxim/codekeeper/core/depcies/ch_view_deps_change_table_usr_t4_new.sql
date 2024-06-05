CREATE TABLE default.t4
(
	`Id` UInt32 NOT NULL,
	`Object.Value` Array(String) NOT NULL
)
ENGINE = MergeTree
ORDER BY Id
SETTINGS index_granularity = 8192;