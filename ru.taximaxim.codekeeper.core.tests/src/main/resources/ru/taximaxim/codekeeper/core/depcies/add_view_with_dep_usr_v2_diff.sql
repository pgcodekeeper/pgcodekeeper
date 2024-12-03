SET search_path = pg_catalog;

-- DEPCY: This SCHEMA test is a dependency of VIEW: public.v2

CREATE SCHEMA test;

-- DEPCY: This FUNCTION goo is a dependency of VIEW: public.v2

CREATE OR REPLACE FUNCTION public.goo(x integer) RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,x,'A'::text;$$;

-- DEPCY: This FUNCTION foo is a dependency of VIEW: public.v2

CREATE OR REPLACE FUNCTION public.foo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;

CREATE VIEW public.v2 AS
	SELECT ('public.foo'::regproc)::text AS text
UNION (
    SELECT ('public.goo(integer)'::regprocedure)::text AS text
    UNION ALL
    SELECT ('test'::regnamespace)::text AS text
);