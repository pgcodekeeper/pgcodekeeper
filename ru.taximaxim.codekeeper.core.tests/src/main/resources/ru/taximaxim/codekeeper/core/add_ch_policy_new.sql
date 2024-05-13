CREATE TABLE default.t2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

--------------------------------------------------------------------------------

CREATE POLICY pol1 ON default.t2
  USING col2 != 3 as RESTRICTIVE to all;

--------------------------------------------------------------------------------

CREATE POLICY pol2 ON default.t2
  USING col1 > 10 as RESTRICTIVE to admin EXCEPT director;