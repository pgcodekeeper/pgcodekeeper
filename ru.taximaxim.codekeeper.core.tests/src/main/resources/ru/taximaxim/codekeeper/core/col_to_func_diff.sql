SET search_path = pg_catalog;

-- DEPCY: This FUNCTION testf is a dependency of COLUMN: public.t1.c1

CREATE OR REPLACE FUNCTION public.testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;

ALTER FUNCTION public.testf() OWNER TO botov_av;

ALTER TABLE ONLY public.t1
	ALTER COLUMN c1 SET DEFAULT public.testf();