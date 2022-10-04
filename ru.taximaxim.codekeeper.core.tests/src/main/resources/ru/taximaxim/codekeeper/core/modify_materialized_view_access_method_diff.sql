SET search_path = pg_catalog;

DROP MATERIALIZED VIEW public.v1;

DROP MATERIALIZED VIEW public.v2;

DROP MATERIALIZED VIEW public.v3;

DROP MATERIALIZED VIEW public.v4;

DROP MATERIALIZED VIEW public.v7;

CREATE MATERIALIZED VIEW public.v1
USING my_method AS
	SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v2 AS
	SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v3 AS
	SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v4
USING my_method AS
	SELECT c1 as vc1, c2 as vc2
    FROM public.t1
WITH DATA;

CREATE MATERIALIZED VIEW public.v7
USING my_method AS
	SELECT c1 as vc1
    FROM public.t1
WITH DATA;
