SET search_path = pg_catalog;

CREATE TABLE public.t1 (
	c1 integer,
	c2 integer,
	c3 integer
);

CREATE VIEW public.v4 AS
	SELECT 
        sum(t1.c1) OVER w AS sum,
        avg(t1.c2) OVER w AS avg
    FROM public.t1
    WINDOW w AS (PARTITION BY t1.c3 ORDER BY t1.c1 DESC);
