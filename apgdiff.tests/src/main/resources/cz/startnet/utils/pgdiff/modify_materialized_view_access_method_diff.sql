SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.my_method(internal) RETURNS table_am_handler
    LANGUAGE internal STRICT PARALLEL SAFE
    AS $$heap_tableam_handler$$;

DROP MATERIALIZED VIEW public.v1;

DROP MATERIALIZED VIEW public.v2;

DROP MATERIALIZED VIEW public.v3;

DROP MATERIALIZED VIEW public.v5;

CREATE MATERIALIZED VIEW public.v1
USING my_method AS
	SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v2
USING my_method AS
	SELECT c1 as vc1, c2 as vc2
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v3
USING heap AS
	SELECT c1 as vc1, c2 as vc2
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v5
USING my_method AS
	SELECT c1 as vc1
    FROM public.t1
WITH DATA;
