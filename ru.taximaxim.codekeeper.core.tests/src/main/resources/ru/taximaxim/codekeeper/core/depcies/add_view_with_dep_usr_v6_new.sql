CREATE VIEW public.v6 AS
    SELECT 
        c1, c2
    FROM public.t1
    GROUP BY t2.c1;