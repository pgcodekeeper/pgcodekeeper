CREATE TABLE default.t1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;