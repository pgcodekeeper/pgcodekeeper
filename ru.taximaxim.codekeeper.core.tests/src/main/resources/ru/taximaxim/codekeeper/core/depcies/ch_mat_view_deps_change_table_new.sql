CREATE TABLE default.t1_1
(
	`d` DateTime NOT NULL default 1,
	`a` UInt32 NOT NULL,
	`c` Int64 NOT NULL
)
ENGINE = MergeTree
PRIMARY KEY tuple()
ORDER BY tuple()
TTL toIntervalHour(c) + toStartOfHour(d)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t1_2
(
	`d` DateTime NOT NULL default 1,
	`a` UInt32 NOT NULL,
	`c` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY tuple()
TTL toIntervalHour(c) + toStartOfHour(d)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2
(
	`d` DateTime NOT NULL,
	`a` UInt32 NOT NULL,
	`c` String NOT NULL
)
ENGINE = MergeTree
ORDER BY tuple()
TTL (toIntervalHour(c) + toStartOfHour(d)) + toIntervalHour(12)
SETTINGS index_granularity = 8192;

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

CREATE MATERIALIZED VIEW default.v1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = Memory
AS SELECT A + B AS col1, C AS col2
FROM (
		SELECT 
			t11.c AS A, 
			t12.c AS B, 
			t13.c AS C 
		FROM default.t1_1 AS t11 
		INNER JOIN default.t2 AS t12 ON t12.d = t11.d 
		INNER JOIN default.t3 AS t13 ON t13.d = t12.d
	  );
	  
CREATE MATERIALIZED VIEW default.v2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = Memory
AS SELECT A + B AS col1, C AS col2
FROM (
		SELECT 
			t11.c AS A, 
			t12.c AS B, 
			t13.c AS C 
		FROM default.t1_2 AS t11 
		INNER JOIN default.t2 AS t12 ON t12.d = t11.d 
		INNER JOIN default.t3 AS t13 ON t13.d = t12.d
	  );
