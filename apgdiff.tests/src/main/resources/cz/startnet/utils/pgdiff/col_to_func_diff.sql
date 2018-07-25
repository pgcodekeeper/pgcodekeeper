SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;

ALTER FUNCTION public.testf() OWNER TO botov_av;

ALTER TABLE ONLY public.t1
	ALTER COLUMN c1 SET DEFAULT public.testf();