SET search_path = pg_catalog;

-- DEPCY: This VIEW v1 depends on the COLUMN: public.t2.c2

DROP VIEW public.v1;

ALTER TABLE public.t2
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: public.t2 original: integer new: text */

ALTER TABLE public.t1
	ALTER COLUMN c1 TYPE text USING c1::text; /* TYPE change - table: public.t1 original: integer new: text */

-- DEPCY: This VIEW v1 is a dependency of VIEW: public.v2

CREATE VIEW public.v1 AS
	SELECT t1.c1,
    t2.c2,
    'asdad' AS text
   FROM public.t1,
    public.t2;

ALTER VIEW public.v1 OWNER TO botov_av;

COMMENT ON VIEW public.v1 IS 'asdsada';

CREATE VIEW public.v2 AS
	SELECT v1.c1,
    v1.c2
   FROM public.v1;

ALTER VIEW public.v2 OWNER TO botov_av;