ALTER TABLE default.t2_1
	DROP CONSTRAINT ch3;

ALTER TABLE default.t2_1
	DROP INDEX ind2;

ALTER TABLE default.t2_1
	DROP INDEX ind3;

-- DEPCY: This CONSTRAINT ch1 depends on the COLUMN: default.t2_1.col2

ALTER TABLE default.t2_1
	DROP CONSTRAINT ch1;

-- DEPCY: This INDEX ind1 depends on the COLUMN: default.t2_1.col2

ALTER TABLE default.t2_1
	DROP INDEX ind1;

ALTER TABLE default.t2_1
	DROP COLUMN `col2`;

ALTER TABLE default.t1_1
	DROP PROJECTION IF EXISTS proj1;

ALTER TABLE default.t1_1
	ADD PROJECTION proj1 (SELECT col1, col2 ORDER BY col2);

ALTER TABLE default.t1_1
	ADD PROJECTION proj2 (SELECT * ORDER BY col2);

ALTER TABLE default.t1_2
	DROP PROJECTION IF EXISTS proj2;

ALTER TABLE default.t1_2
	DROP PROJECTION IF EXISTS proj1;

ALTER TABLE default.t1_2
	ADD PROJECTION proj1 (SELECT * ORDER BY col2);

DROP TABLE default.test;

DROP TABLE default.test2;

ALTER TABLE default.t2_2
	ADD COLUMN `col2` Int64;

ALTER TABLE default.t2_2 ADD INDEX ind3 col1 > col2 TYPE bloom_filter;

ALTER TABLE default.t2_2 ADD INDEX ind4 col1 > 0 TYPE bloom_filter;

ALTER TABLE default.t2_2 ADD CONSTRAINT ch3 CHECK col2 > 0;

ALTER TABLE default.t2_2
	DROP CONSTRAINT ch2;

ALTER TABLE default.t2_1 ADD CONSTRAINT ch1 CHECK col1 > 10;

ALTER TABLE default.t2_1 ADD INDEX ind1 col1 > 0 TYPE bloom_filter;

CREATE TABLE default.test
(
	`col1` Int32 NOT NULL,
	CONSTRAINT c_name2 CHECK col1 < 10
)
ENGINE = Log;

CREATE TABLE default.test2
(
	`col1` Int32 NOT NULL,
	CONSTRAINT c_name CHECK col1 > 0,
	CONSTRAINT c_name2 CHECK col1 < 10
)
ENGINE = Log;

ALTER TABLE default.t2_2 ADD CONSTRAINT ch2 CHECK col1 > col2;
