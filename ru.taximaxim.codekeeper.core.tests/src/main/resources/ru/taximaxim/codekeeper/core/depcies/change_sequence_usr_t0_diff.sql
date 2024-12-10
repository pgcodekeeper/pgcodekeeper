SET search_path = pg_catalog;

-- DEPCY: This SEQUENCE s1 is a dependency of COLUMN: public.t0.c1

CREATE SEQUENCE public.s1
	AS integer
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

-- DEPCY: This FUNCTION f1 is a dependency of COLUMN: public.t0.c2

CREATE OR REPLACE FUNCTION public.f1(p1 text, p2 integer) RETURNS integer
    LANGUAGE sql
    AS $_$ select $2 LIMIT 1 $_$;

-- DEPCY: This FUNCTION f2 is a dependency of COLUMN: public.t0.c3

CREATE OR REPLACE FUNCTION public.f2(s integer, k integer = 43) RETURNS integer
    LANGUAGE sql
    AS $_$ SELECT $2 ; $_$;

-- DEPCY: This TYPE type_tt is a dependency of COLUMN: public.t0.c4

CREATE TYPE public.type_tt AS (
);

CREATE TABLE public.t0 (
	c1 integer DEFAULT nextval('public.s1'::regclass) NOT NULL,
	c2 integer DEFAULT public.f1('t', 2),
	c3 integer DEFAULT public.f2(1, 2),
	c4 public.type_tt
);

ALTER SEQUENCE public.s1
	OWNED BY public.t0.c1;