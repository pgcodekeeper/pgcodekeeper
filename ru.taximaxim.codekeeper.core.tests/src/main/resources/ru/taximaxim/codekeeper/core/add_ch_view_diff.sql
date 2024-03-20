CREATE LIVE VIEW default.lv2 WITH REFRESH 60
(
	`sum(x)` Int64 NOT NULL
)
AS SELECT sum(x) FROM default.mt;

CREATE MATERIALIZED VIEW default.mv
(
	`1` UInt8 NOT NULL
)
ENGINE = Memory
AS SELECT 1;

CREATE MATERIALIZED VIEW default.mv1
(
	`s` String NOT NULL,
	`x` String NOT NULL DEFAULT 'b'
)
ENGINE = MergeTree
PARTITION BY tuple()
ORDER BY s
SETTINGS index_granularity = 8192
AS SELECT concat(tuple(*).1, 'mv1') AS s FROM default.src;

CREATE MATERIALIZED VIEW default.mv2 TO default.dst
(
	`s` String NOT NULL,
	`x` String NOT NULL DEFAULT 'd'
)
AS SELECT concat(tuple(*).1, 'mv2') AS s FROM default.src;

CREATE MATERIALIZED VIEW default.mv3
(
	`c1` UInt8 NOT NULL
)
ENGINE = MergeTree
PRIMARY KEY c1
ORDER BY c1
SETTINGS index_granularity = 8192
AS SELECT 1 AS c1;

CREATE VIEW default.v1
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS s;

CREATE VIEW default.vv1
(
	`select` UInt8 NOT NULL
)
AS SELECT 1 AS select;

CREATE VIEW default.vvvv1
(
	`1` UInt8 NOT NULL
)
DEFINER = test_user SQL SECURITY INVOKER
AS SELECT 1;

CREATE MATERIALIZED VIEW default.X TO default.Y
(
	`1` UInt8 NOT NULL
)
AS SELECT 1;
