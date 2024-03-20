CREATE TABLE default.t1 
(
	`col1` Int64 COMMENT 'test', 
	`col1_1` Int64 COMMENT 'test', 
	`col2` Float64 DEFAULT 0., 
	`col3` Float64 DEFAULT 0.12, 
	`col4` DateTime DEFAULT now(), 
	`col5` String DEFAULT 'Hellow world', 
	`col6` UInt8 DEFAULT 17, 
	`col7` Float64 DEFAULT 1.2357135465432165e23, 
	`col8` UInt32 DEFAULT 12345847, 
	`col9` Int32
) 
ENGINE = MergeTree 
PRIMARY KEY tuple(col9) 
ORDER BY col9 
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2 
(
	`col1` Int64 COMMENT 'test', 
	`col2` Float64 DEFAULT 0.012, 
	PROJECTION proj2 
	(
		SELECT col1 AS some_name
		ORDER BY col2
	)
) 
ENGINE = MergeTree 
ORDER BY col1 
SETTINGS index_granularity = 8192;

CREATE TABLE default.t3(`c1` integer,`c2` String)ENGINE = MergeTree ORDER BY c1 SETTINGS index_granularity = 8192;

CREATE TABLE default.t4
(
	col1 Int64,
	col2 Int64
)
ENGINE = MergeTree
PRIMARY KEY (col1, col2)
ORDER BY (col1, col2);