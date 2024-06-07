ALTER TABLE default.t1
	ADD COLUMN `b` UInt8;

ALTER TABLE default.t1
	ADD COLUMN `col13` Int32 TTL col11 + toIntervalDay(1);
