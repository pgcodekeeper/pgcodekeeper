CREATE TABLE default.t
(
	col1 Int64 NOT NULL,
	col2 Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;	