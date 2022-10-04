CREATE VIEW public.v4 AS
    SELECT 
        sum(t1.c1) OVER w AS sum,
        avg(t1.c2) OVER w AS avg
    FROM public.t1
    WINDOW w AS (PARTITION BY t1.c3 ORDER BY t1.c1 DESC);
