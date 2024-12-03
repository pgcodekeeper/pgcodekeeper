SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f2 is a dependency of COLUMN: public.t1.id

CREATE OR REPLACE FUNCTION public.f2() RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
   SELECT 1 FROM public.t1 WHERE id > 0;
END
$$;

-- DEPCY: This FUNCTION f1 is a dependency of COLUMN: public.t1.id

CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
    select public.f2();
END
$$;

CREATE TABLE public.t1 (
	id integer DEFAULT public.f1()
);