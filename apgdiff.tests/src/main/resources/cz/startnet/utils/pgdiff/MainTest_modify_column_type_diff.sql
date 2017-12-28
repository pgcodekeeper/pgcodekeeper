SET TIMEZONE TO 'UTC';

SET check_function_bodies = false;

START TRANSACTION;

ALTER TABLE testtable
	ALTER COLUMN field1 TYPE integer USING field1::integer; /* TYPE change - table: testtable original: smallint new: integer */

ALTER TABLE testtable
	ALTER COLUMN field3 TYPE character varying(150) USING field3::character varying(150); /* TYPE change - table: testtable original: character varying(100) new: character varying(150) */

COMMIT TRANSACTION;
