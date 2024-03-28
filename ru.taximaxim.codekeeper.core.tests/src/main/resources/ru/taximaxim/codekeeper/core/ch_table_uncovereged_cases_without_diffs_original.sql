CREATE TABLE default.t1
(
    `col1` Int64 COMMENT 'test',
    `col1_1` Int64 COMMENT 'test',
    `col2` Float64 DEFAULT 0.00,
    `col3` Float64 DEFAULT 0.12,
    col4 default now(),
    col5 default 'Hellow world',
    col6 default 17,
    col7 default 123571354654321658541578,
    col8 default 12345847,
    col9 integer not null primary key
)
ENGINE = MergeTree()
ORDER BY col9;

CREATE TABLE default.t2
(
    `col1` Int64 COMMENT 'test', 
    PROJECTION proj1 (SELECT col1 AS some_name ORDER BY col2),
    `col2` Float64 DEFAULT 0.012
) 
ENGINE = MergeTree 
ORDER BY col1;

CREATE TABLE t3
(
	c1 integer,
	`c2` String
)
ENGINE = MergeTree
ORDER BY c1;

CREATE TABLE default.t4
(
	col1 Int64 PRIMARY KEY,
	col2 Int64 PRIMARY KEY
)
ENGINE = MergeTree
ORDER BY (col1, col2);

CREATE TABLE default.t5 (
	`col1` Int64 NOT NULL,
	INDEX idx_t10_3 col1 TYPE minmax,
	INDEX idx_t10_1 col1 TYPE minmax,
	INDEX idx_t10_4 col1 TYPE minmax,
	INDEX idx_t10_2 col1 TYPE minmax,
	INDEX idx_t10_5 col1 TYPE minmax
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;