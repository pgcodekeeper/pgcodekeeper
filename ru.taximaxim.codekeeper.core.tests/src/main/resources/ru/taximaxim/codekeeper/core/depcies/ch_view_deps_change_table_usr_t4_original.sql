CREATE TABLE default.t4
(
	`Id` UInt32 NOT NULL,
	`Object.Key` Array(UInt8) NOT NULL,
	`Object.Value` Array(String) NOT NULL
)
ENGINE = MergeTree
ORDER BY Id
SETTINGS index_granularity = 8192;