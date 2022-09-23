SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

ALTER TABLE public.t4
	DROP CONSTRAINT t4_c2_key;

ALTER TABLE public.t4
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: public.t4 original: integer new: text */

ALTER TABLE ONLY public.t4
	ALTER COLUMN c2 DROP NOT NULL;

ALTER TABLE public.t4
	ADD CONSTRAINT t4_c2_key UNIQUE (c2);