CREATE SCHEMA test;

CREATE OR REPLACE FUNCTION public.foo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;

CREATE OR REPLACE FUNCTION public.boo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;
    
CREATE OR REPLACE FUNCTION public.goo(x integer) RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,x,'A'::text;$$;

CREATE TABLE public.t1 (
    c1 integer,
    c2 integer,
    c3 integer
);

ALTER TABLE public.t1  
    ADD CONSTRAINT t1_c1_pk PRIMARY KEY (c1);

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
WITH ORDINALITY q(c1, c2, c3, c4, c5, c6, ordinality);

CREATE VIEW public.v2 AS
SELECT ('public.foo'::regproc)::text AS text
UNION (
    SELECT ('public.goo(integer)'::regprocedure)::text AS text
    UNION ALL
    SELECT ('test'::regnamespace)::text AS text
);

CREATE VIEW public.v3(c1, c2, c3) AS
TABLE public.t1 *;

CREATE VIEW public.v4 AS
    SELECT 
        sum(t1.c1) OVER w AS sum,
        avg(t1.c2) OVER w AS avg
    FROM public.t1
    WINDOW w AS (PARTITION BY t1.c3 ORDER BY t1.c1 DESC);

CREATE VIEW public.v5 AS
    SELECT GROUPING(t1.c1) AS grouping_c1,
    t1.c1,
    t1.c2,
    sum(t1.c3) AS sum
   FROM public.t1
  GROUP BY GROUPING SETS ((t1.c1, t1.c2), (t1.c1), (t1.c2), ((public.foo())))
  ORDER BY t1.c1, t1.c2;

CREATE VIEW public.v6 AS
    SELECT 
        c1, c2
    FROM public.t1
    GROUP BY t1.c1;
