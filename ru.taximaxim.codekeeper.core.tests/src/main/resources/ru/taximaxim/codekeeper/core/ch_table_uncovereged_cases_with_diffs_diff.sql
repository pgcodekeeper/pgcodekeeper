ALTER TABLE default.t1
	MODIFY SAMPLE BY d;

ALTER TABLE default.t2
	REMOVE TTL;
	
ALTER TABLE default.t2 MODIFY COLUMN col2 DEFAULT col1;

ALTER TABLE default.t2
	DROP COLUMN col4;

ALTER TABLE default.t2
	DROP COLUMN col3;
	
ALTER TABLE default.t3
	ADD COLUMN c2 Int64 DEFAULT col1 + col2 CODEC(LZ4HC(0)) FIRST;
	
ALTER TABLE default.t3
	ADD COLUMN c3 Int64 DEFAULT col1 + col2 CODEC(LZ4HC(0)) AFTER col2;
	
ALTER TABLE default.t3
	ADD COLUMN col11 Int64 DEFAULT col1 + col2 CODEC(LZ4HC(0)) AFTER c3;
	
ALTER TABLE default.t3
	ADD COLUMN b Int64 DEFAULT col1 + col2 CODEC(LZ4HC(0)) AFTER col3;
	
ALTER TABLE default.t3
	ADD COLUMN col13 Int64 DEFAULT col1 + col2 CODEC(LZ4HC(0));
	
DROP TABLE default.t4;

CREATE TABLE default.t4(
	`col1` String NOT NULL
)
ENGINE = MergeTree
ORDER BY col1;

ALTER TABLE default.t5 MODIFY COLUMN col3 String TTL (col12 + toIntervalDay(1)) + col4;

ALTER TABLE default.t5
	DROP INDEX ind1;

ALTER TABLE default.t5
	ADD COLUMN col5 Int64;
	
ALTER TABLE default.t5 ADD INDEX ind1 col1 > 0 TYPE bloom_filter;

ALTER TABLE default.t6
	DROP PROJECTION IF EXISTS proj1;

ALTER TABLE default.t6
	ADD PROJECTION proj1 (SELECT * ORDER BY col3);

ALTER TABLE default.t6
	DROP COLUMN col2;
	
CREATE TABLE `default`.`t7`
(
	`a` Int64 NOT NULL,
	`b` Int64 NOT NULL,
	CONSTRAINT `1c1` ASSUME (b > 10) AND (1 > a)
)
ENGINE = TinyLog;

DROP TABLE default.t8;

CREATE TABLE `default`.`t8`
(
	`a` Int64 NOT NULL,
	`b` Int64 NOT NULL,
	CONSTRAINT `1c2` ASSUME (b > 10) AND (1 > a)
)
ENGINE = TinyLog;

ALTER TABLE default.t9_1
	ADD COLUMN c Date;

ALTER TABLE default.t9_1 MODIFY COLUMN b UInt8 TTL c + INTERVAL 1 DAY;

ALTER TABLE default.t9_1
	MODIFY TTL c + INTERVAL 3 DAY;

ALTER TABLE default.t9_2
	ADD COLUMN d Int64;

ALTER TABLE default.t9_2
	MODIFY TTL c + toIntervalDay(3) + d;

ALTER TABLE default.t9_2 MODIFY COLUMN b UInt8 TTL c + toIntervalDay(1) + d;

ALTER TABLE default.t9_3
	MODIFY TTL c + toIntervalDay(3);

ALTER TABLE default.t9_3 MODIFY COLUMN b UInt8 TTL c + toIntervalDay(1);

ALTER TABLE default.t9_3
	DROP COLUMN d;

ALTER TABLE default.t10 ADD INDEX idx_t10_3 col1 TYPE minmax FIRST;

ALTER TABLE default.t10 ADD INDEX idx_t10_4 col1 TYPE minmax AFTER idx_t10_1;

ALTER TABLE default.t10 ADD INDEX idx_t10_5 col1 TYPE minmax;

ALTER TABLE default.t11
	ADD COLUMN col5 Int64;
	
ALTER TABLE default.t11
	ADD COLUMN col6 Int64 AFTER col2;
	
ALTER TABLE default.t11
	ADD COLUMN col4 Int64 DEFAULT col6 AFTER col2;
	
ALTER TABLE default.t11
	ADD COLUMN col7 Int64 DEFAULT col4 + col5 AFTER col2;
