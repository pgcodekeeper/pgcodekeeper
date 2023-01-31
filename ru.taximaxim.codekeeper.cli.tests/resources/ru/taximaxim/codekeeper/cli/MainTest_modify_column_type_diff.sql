SET TIMEZONE TO 'UTC';

SET check_function_bodies = false;

START TRANSACTION;

SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ALTER COLUMN field1 TYPE integer USING field1::integer; /* TYPE change - table: public.testtable original: smallint new: integer */

ALTER TABLE public.testtable
	ALTER COLUMN field3 TYPE character varying(150) USING field3::character varying(150); /* TYPE change - table: public.testtable original: character varying(100) new: character varying(150) */

COMMIT TRANSACTION;

