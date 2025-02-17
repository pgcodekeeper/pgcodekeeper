SET search_path = pg_catalog;

-- DEPCY: This TYPE the_my_type is a dependency of FUNCTION: public.f1()

CREATE TYPE public.the_my_type AS (
	c1 integer
);

CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE sql
    AS $$ select 1::public.the_my_type;$$;