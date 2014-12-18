SET TIMEZONE TO 'UTC';

ALTER TABLE table1
	DROP CONSTRAINT chk_table1;

ALTER TABLE table1
	ALTER COLUMN col2 TYPE oid /* TYPE change - table: table1 original: name new: oid */;

ALTER TABLE table1
	ADD CONSTRAINT chk_table1 CHECK ((1 > 1));