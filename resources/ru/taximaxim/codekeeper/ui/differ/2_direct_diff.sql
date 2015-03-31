SET TIMEZONE TO 'UTC';

ALTER TABLE table1
	DROP CONSTRAINT chk_table1;

ALTER TABLE table1
	ADD CONSTRAINT chk_table1 CHECK ((1 > 2));

ALTER TABLE table1
	ALTER COLUMN col2 TYPE name; /* TYPE change - table: table1 original: oid new: name */
