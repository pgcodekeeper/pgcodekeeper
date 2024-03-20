CREATE TABLE default.t1
(
    `d` Bool,
    `s` Bool
)
ENGINE = MergeTree
PRIMARY KEY (s, d)
ORDER BY (s, d)
SAMPLE BY s
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
TTL col3 + toIntervalMonth(1)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;