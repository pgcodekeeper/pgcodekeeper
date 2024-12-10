SET search_path = pg_catalog;

-- DEPCY: This FUNCTION boo is a dependency of VIEW: public.v1

CREATE OR REPLACE FUNCTION public.boo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;

-- DEPCY: This FUNCTION foo is a dependency of VIEW: public.v1

CREATE OR REPLACE FUNCTION public.foo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;

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