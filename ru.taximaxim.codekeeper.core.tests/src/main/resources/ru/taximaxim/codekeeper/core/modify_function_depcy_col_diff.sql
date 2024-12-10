SET search_path = pg_catalog;

-- DEPCY: This COLUMN c1 depends on the FUNCTION: public.f(integer, integer)

ALTER TABLE ONLY public.tbl
	DROP COLUMN c1;

DROP FUNCTION public.f(s integer, k integer);

CREATE OR REPLACE FUNCTION public.f(s integer, k text = 'qwerty'::text) RETURNS integer
    LANGUAGE sql
    AS $$ SELECT 1111; $$;

ALTER FUNCTION public.f(s integer, k text) OWNER TO shamsutdinov_lr;

ALTER TABLE public.tbl
	ADD COLUMN c1 integer;

ALTER TABLE ONLY public.tbl
	ALTER COLUMN c1 SET DEFAULT public.f(1);

COMMENT ON COLUMN public.tbl.c1 IS 'some comment';