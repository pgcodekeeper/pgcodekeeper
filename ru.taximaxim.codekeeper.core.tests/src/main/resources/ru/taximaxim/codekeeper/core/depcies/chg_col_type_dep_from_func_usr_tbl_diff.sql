SET search_path = pg_catalog;

ALTER TABLE ONLY public.tbl
	ALTER COLUMN c1 DROP DEFAULT;

ALTER TABLE public.tbl
	ALTER COLUMN c1 TYPE text USING c1::text; /* TYPE change - table: public.tbl original: integer new: text */

ALTER TABLE ONLY public.tbl
	ALTER COLUMN c1 SET DEFAULT USER;
