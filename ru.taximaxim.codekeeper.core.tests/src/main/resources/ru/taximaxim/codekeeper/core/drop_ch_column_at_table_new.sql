CREATE TABLE default.t
(
	col2 Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;	