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
	`b` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY tuple()
TTL (toIntervalHour(c) + toStartOfHour(d)) + toIntervalHour(c)
SETTINGS index_granularity = 8192;

CREATE TABLE default.t4
(
	`Id` UInt32 NOT NULL,
	`Object.Key` Array(UInt8) NOT NULL,
	`Object.Value` Array(String) NOT NULL
)
ENGINE = MergeTree
ORDER BY Id
SETTINGS index_granularity = 8192;

CREATE VIEW default.v1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
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
	  
CREATE VIEW default.v2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
AS SELECT A + B AS col1, C AS col2
FROM (
		SELECT 
			t11.c AS A, 
			t12.c AS B, 
			t13.c + t13.b AS C 
		FROM default.t1_2 AS t11 
		INNER JOIN default.t2 AS t12 ON t12.d = t11.d 
		INNER JOIN default.t3 AS t13 ON t13.d = t12.d
	  );

CREATE VIEW default.v3
(
	`Id` UInt32 NOT NULL,
	`Object.Key` Array(UInt16) NOT NULL,
	`Object.Value` Array(String) NOT NULL
)
AS SELECT * REPLACE arrayMap(x -> (x + 1), `Object.Key`) AS `Object.Key` FROM default.t4;