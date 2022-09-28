CREATE VIEW public.v1 AS
SELECT q.c1,
    q.c2,
    q.c3,
    q.c4,
    q.c5,
    q.c6,
    q.ordinality
FROM ROWS FROM(
    public.foo() AS (c1 integer, c2 integer, c3 text), 
    public.boo() AS (c4 integer, c5 integer, c6 text)) 
WITH ORDINALITY q (c1, c2, c3, c4, c5, c6, ordinality);
