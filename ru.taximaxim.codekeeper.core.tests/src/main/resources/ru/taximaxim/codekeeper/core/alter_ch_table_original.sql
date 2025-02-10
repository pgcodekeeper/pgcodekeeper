CREATE TABLE default.t1_1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
	 PROJECTION proj1 (SELECT * ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t1_2
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
	 PROJECTION proj1 (SELECT col1, col2 ORDER BY col2),
	 PROJECTION proj2 (SELECT * ORDER BY col2)
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

CREATE TABLE default.t2_1
(
	`col1` Int64 NOT NULL,
	`col2` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_1 ADD CONSTRAINT ch1 CHECK col1 > col2;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_1 ADD CONSTRAINT ch3 CHECK col2 > 0;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_1 ADD INDEX ind1 col1 > col2 TYPE bloom_filter GRANULARITY 1;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_1 ADD INDEX ind2 col1 > 0 TYPE bloom_filter GRANULARITY 1;

CREATE TABLE default.t2_2
(
	`col1` Int64 NOT NULL,
	`col3` Date NOT NULL,
	`col4` Date NOT NULL,
)
ENGINE = MergeTree
ORDER BY col1
SETTINGS index_granularity = 8192;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_2 ADD CONSTRAINT ch2 CHECK col1 > 10;

--------------------------------------------------------------------------------

ALTER TABLE default.t2_1 ADD INDEX ind3 col1 > 0 TYPE bloom_filter GRANULARITY 1;

CREATE TABLE default.test
(
    `col1` Int32 NOT NULL,
    CONSTRAINT c_name CHECK col1 > 0,
    CONSTRAINT c_name2 CHECK col1 < 10
)
ENGINE = Log;

CREATE TABLE default.test2
(
    `col1` Int32 NOT NULL,
    CONSTRAINT c_name2 CHECK col1 < 10
)
ENGINE = Log;
