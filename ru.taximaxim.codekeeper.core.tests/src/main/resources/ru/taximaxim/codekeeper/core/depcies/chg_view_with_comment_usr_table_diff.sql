SET search_path = pg_catalog;

-- DEPCY: This VIEW testview depends on the COLUMN: public.testtable.c2

DROP VIEW public.testview;

ALTER TABLE public.testtable
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: public.testtable original: integer new: text */

CREATE VIEW public.testview AS
	SELECT testtable.c1,
    testtable.c2
   FROM public.testtable;

ALTER VIEW public.testview OWNER TO galiev_mr;

COMMENT ON VIEW public.testview IS 'this is test comment';