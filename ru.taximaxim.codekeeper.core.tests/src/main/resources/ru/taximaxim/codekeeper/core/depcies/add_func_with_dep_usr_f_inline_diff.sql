SET search_path = pg_catalog;

CREATE TABLE public.t1 (
	c1 integer,
	c2 integer,
	c3 integer
);

CREATE OR REPLACE FUNCTION public.f_inline_short() RETURNS void
    LANGUAGE sql
    RETURN (SELECT t.c1 FROM public.t1 t LIMIT 1);

CREATE TABLE public.t2 (
	c1 integer,
	c2 integer,
	c3 integer
);

CREATE OR REPLACE FUNCTION public.f_inline_full() RETURNS void
    LANGUAGE sql
    BEGIN ATOMIC
 SELECT t.c2 FROM public.t2 t LIMIT 1;
END;
