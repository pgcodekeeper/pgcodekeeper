CREATE TABLE default.t3 
(
	`col1` Int64 COMMENT 'test', 
	`col2` Float64 DEFAULT 0.12, 
	`col3` String, 
	INDEX ind2 col3 TYPE minmax GRANULARITY 1, 
	INDEX ind1 col3 TYPE minmax GRANULARITY 1
) 
ENGINE = MergeTree 
ORDER BY col1 
SETTINGS index_granularity = 8192;

CREATE TABLE default.`01154_test`
(

    `col1` Int32
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;