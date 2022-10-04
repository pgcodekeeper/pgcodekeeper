SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 DROP DEFAULT;

ALTER TABLE public.testtable
	ALTER COLUMN field3 TYPE integer USING field3::integer; /* TYPE change - table: public.testtable original: character varying(150) new: integer */

ALTER TABLE public.testtable
	ALTER COLUMN field3 SET NOT NULL;
