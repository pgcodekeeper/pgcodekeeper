SET search_path = pg_catalog;

DROP FUNCTION public.function_contract(_id integer);

DROP VIEW public.v1;

CREATE VIEW public.v1 AS
	SELECT t1.c1,
	t1.c2 as col1,
	t1.c3,
	t1.c4
   FROM public.t1;

ALTER VIEW public.v1 OWNER TO khazieva_gr;

CREATE OR REPLACE FUNCTION public.function_contract(_id integer) RETURNS TABLE(id integer)
    LANGUAGE sql SECURITY DEFINER
    AS $$
select col1 from public.v1;
$$;

ALTER FUNCTION public.function_contract(_id integer) OWNER TO khazieva_gr;

COMMENT ON FUNCTION public.function_contract(_id integer) IS 'comment';