CREATE VIEW default.v_1_1
(
	`s` UInt8 NOT NULL,
	`col1` Int64 NOT NULL,
	`col2` Date NOT NULL
)
AS SELECT 1 AS s;

CREATE VIEW default.v_1_2
(
	`s` UInt8 NOT NULL,
	`col1` Int64 NOT NULL TTL col2 + toIntervalDay(1),
	`col2` Date NOT NULL
)
AS SELECT 1 AS s;

CREATE VIEW default.v_2_1
(
	`s` UInt8 NOT NULL,
	`col1` Int64 NOT NULL
)
AS SELECT 1 AS s;

CREATE VIEW default.v_2_2
(
	`s` UInt8 NOT NULL,
	`col1` Int64 NOT NULL,
	`col2` Date NOT NULL
)
AS SELECT 1 AS s;

CREATE MATERIALIZED VIEW default.v_3_1
(
	`col1` String NOT NULL,
	`col2` String NOT NULL DEFAULT 'b',
	`col4` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
PARTITION BY tuple()
ORDER BY col1
SETTINGS index_granularity = 8192
AS SELECT concat(tuple(*).1, 'mv1') AS s FROM default.src;

CREATE MATERIALIZED VIEW default.v_3_2
(
	`col1` String NOT NULL,
	`col2` String NOT NULL DEFAULT 'b',
	`col4` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
PARTITION BY tuple()
ORDER BY col1
SETTINGS index_granularity = 8192,
	min_bytes_for_wide_part=123
AS SELECT concat(tuple(*).1, 'mv1') AS s FROM default.src;

CREATE MATERIALIZED VIEW default.v_4_1
(
	`col1` String NOT NULL,
	`col2` String NOT NULL DEFAULT 'b',
	`col4` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
PARTITION BY tuple()
ORDER BY col1
SETTINGS index_granularity = 8192
AS SELECT concat(tuple(*).1, 'mv1') AS s FROM default.src;

CREATE MATERIALIZED VIEW default.v_4_2
(
	`col1` String NOT NULL,
	`col2` String NOT NULL DEFAULT 'b',
	`col4` Int64 NOT NULL,
	`col3` Date NOT NULL
)
ENGINE = MergeTree
PARTITION BY tuple()
ORDER BY col1
SETTINGS index_granularity = 8192
AS SELECT concat(tuple(*).1, 'mv1') AS b FROM default.src;

CREATE VIEW default.v_5_1
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS s;

CREATE VIEW default.v_5_2
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS s
COMMENT 'TEST';

CREATE VIEW default.v_6_1
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS s;