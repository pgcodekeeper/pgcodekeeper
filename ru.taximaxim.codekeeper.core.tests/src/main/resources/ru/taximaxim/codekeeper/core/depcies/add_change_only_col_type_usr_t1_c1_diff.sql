SET search_path = pg_catalog;

-- DEPCY: This VIEW v1 depends on the COLUMN: public.t1.c1

DROP VIEW public.v1;

ALTER TABLE public.t1
	ALTER COLUMN c1 TYPE text USING c1::text; /* TYPE change - table: public.t1 original: integer new: text */

ALTER TABLE public.t2
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: public.t2 original: integer new: text */

CREATE VIEW public.v1 AS
	SELECT t1.c1,
    t2.c2
   FROM public.t1,
    public.t2;

ALTER VIEW public.v1 OWNER TO botov_av;

COMMENT ON VIEW public.v1 IS 'asdsada';