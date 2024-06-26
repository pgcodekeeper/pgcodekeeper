CREATE LIVE VIEW default.lv2 WITH REFRESH 60
(
	`sum(x)` Int64 NOT NULL
)
AS SELECT sum(x), a FROM default.mt;

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

CREATE VIEW default.v_5_2
(
	`s` UInt8 NOT NULL
)
AS SELECT a, f FROM ( SELECT toLowCardinality(toNullable(number)) AS l0 FROM system.numbers LIMIT 10 ) AS s1 ANY LEFT JOIN ( SELECT toLowCardinality(toNullable(number)) AS r FROM system.numbers LIMIT 7 ) AS s2 ON (l + 1023) = (r * 3) ORDER BY l, r;

CREATE VIEW default.v_5_3
(
	`s` UInt8 NOT NULL
)
AS SELECT a, f FROM ( SELECT toLowCardinality(toNullable(number)) AS l0
 FROM system.numbers LIMIT 10 ) AS s1
 ANY LEFT JOIN ( SELECT toLowCardinality(toNullable(number)) AS r FROM  (SELECT toLowCardinality(toNullable(number)) AS l0 FROM system.numbers LIMIT 10) AS s1) AS s2 ON (l + 1023) = (r * 3) ORDER BY l, r;

CREATE VIEW default.v_5_5
(
	`s` UInt8 NOT NULL
)
AS SELECT * FROM t ANY LEFT JOIN x  USING date, id;

CREATE VIEW default.v_5_6
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS max_size, groupArray(max_size)(col) FROM (SELECT col FROM ( SELECT 1 AS col UNION ALL SELECT 2 ) ORDER BY col);

CREATE VIEW default.v_5_7
(
	`s` UInt8 NOT NULL
)
AS SELECT 2 AS x, arrayJoin([NULL, NULL, NULL]) GROUP BY GROUPING SETS ( (0), ([NULL, NULL, NULL])) ORDER BY x ASC WITH FILL FROM 1 TO 10;

CREATE VIEW default.v_5_8
(
	`s` UInt8 NOT NULL
)
AS SELECT a, b FROM t1 AS tt1 INNER JOIN ( SELECT c FROM t2 ) AS tt2 ON tt1.a = tt2.c INNER JOIN ( SELECT f FROM t3 ) AS tt3 ON tt1.b = tt3.f;

CREATE VIEW default.v_5_9
(
	`s` UInt8 NOT NULL
)
AS SELECT a, count() FROM remote('127.0.0.{1,2}', currentDatabase(), local_t) GROUP BY a WITH TOTALS HAVING a IN ( SELECT 1 );

CREATE VIEW default.v_5_10
(
	`s` UInt8 NOT NULL
)
AS SELECT '2' FROM numbers(10) EXCEPT DISTINCT SELECT '1' FROM numbers(5);

CREATE VIEW default.v_5_11
(
	`s` UInt8 NOT NULL
)
AS SELECT 'a' AS key, 'b' as value GROUP BY key WITH CUBE SETTINGS allow_experimental_analyzer = 1;

CREATE VIEW default.v_5_12
(
	`s` UInt8 NOT NULL
)
AS SELECT 'a' IN (SELECT 1) SETTINGS transform_null_in = 1;

CREATE VIEW default.v_5_13
(
	`s` UInt8 NOT NULL
)
AS SELECT 'a' UNION ALL (SELECT 'a' UNION ALL SELECT 'a' UNION SELECT 'a');

CREATE VIEW default.v_5_14
(
	`s` UInt8 NOT NULL
)
AS SELECT * FROM ( EXPLAIN PLAN indexes = 1 SELECT * FROM tab WHERE match(str, '.*(ClickHouse|World)') ORDER BY id ) WHERE explain LIKE '%Granules: %' SETTINGS allow_experimental_analyzer = 1;

CREATE VIEW default.v_5_15
(
	`s` UInt8 NOT NULL
)
AS SELECT * FROM functional_index_mergetree WHERE x < 7.49;

CREATE VIEW default.v_5_16
(
	`s` UInt8 NOT NULL
)
AS WITH x -> * AS lambda SELECT lambda(1) FROM test_table;

CREATE VIEW default.v_5_17
(
	`s` UInt8 NOT NULL
)
AS SELECT '-21474836.48', 10000000000., '', count(kbytes), '', 10.0001, toStartOfMinute(datetime) AS dt_m, 10, NULL FROM projection_test__fuzz_0 GROUP BY dt_m WITH ROLLUP WITH TOTALS ORDER BY count(retry_count / duration) ASC NULLS LAST, 100000000000000000000. ASC NULLS FIRST;

CREATE VIEW default.v_5_18
(
	`s` UInt8 NOT NULL
)
AS SELECT (X.a + 1) AS a, (Y.a + 1) AS Y_a, (Z.a + 1) AS Z_a, (Y.b + 1) AS b, (Z.b + 1) AS Z_b FROM (SELECT 10 a) X CROSS JOIN (SELECT 20 a, 21 as b) Y CROSS JOIN (SELECT 30 a, 31 as b, 32 as c) Z;

CREATE VIEW default.v_5_19
(
	`s` UInt8 NOT NULL
)
AS SELECT x, t, round(max, 12) FROM ( SELECT d[1] AS x, d[2] AS t, exponentialTimeDecayedMax(100)(-x, t) OVER w AS max FROM ( SELECT [[2, 1], [1, 2], [10, 3], [4, 4], [5, 5], [1, 6], [10, 7], [10, 8], [10, 9], [9.81, 10], [9.9, 11]] AS d ) ARRAY JOIN d WINDOW w AS (ORDER BY 1 ASC Rows BETWEEN 2 PRECEDING AND 2 FOLLOWING) );

CREATE VIEW default.v_5_20
(
	`s` UInt8 NOT NULL
)
AS SELECT * FROM `02538_bf_ngrambf_map_values_test` PREWHERE (map['']) = 'V2V\0V2V2V2V2V2V2' WHERE (map[NULL]) = 'V2V\0V2V2V2V2V2V2V2V\0V2V2V2V2V2V2V2V\0V2V2V2V2V2V2V2V\0V2V2V2V2V2V2' SETTINGS force_data_skipping_indices = 'map_values_ngrambf';