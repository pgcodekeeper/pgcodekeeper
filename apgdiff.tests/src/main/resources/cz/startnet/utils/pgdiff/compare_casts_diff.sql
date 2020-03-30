SET search_path = pg_catalog;

DROP CAST (double precision AS public.tt);

CREATE CAST (float AS public.tt) WITHOUT FUNCTION;

DROP CAST (integer AS public.tt);

DROP CAST (bigint AS public.tt);

DROP CAST (smallint AS public.tt);

CREATE CAST (integer AS public.tt) WITHOUT FUNCTION AS ASSIGNMENT;

CREATE CAST (bigint AS public.tt) WITHOUT FUNCTION AS ASSIGNMENT;

CREATE CAST (smallint AS public.tt) WITH FUNCTION public.ttt(smallint);