SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

ALTER TABLE public.t4
	DROP CONSTRAINT t4_c2_key;

ALTER TABLE public.t4
	ALTER COLUMN c2 TYPE integer USING c2::integer; /* TYPE change - table: public.t4 original: text new: integer */

ALTER TABLE public.t4
	ALTER COLUMN c2 SET NOT NULL;

ALTER TABLE public.t4
	ADD CONSTRAINT t4_c2_key UNIQUE (c1, c2);