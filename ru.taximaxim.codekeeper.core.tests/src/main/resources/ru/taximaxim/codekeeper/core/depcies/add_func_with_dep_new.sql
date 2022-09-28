CREATE TABLE public.t1 (
    c1 integer,
    c2 integer,
    c3 integer
);

CREATE TABLE public.t2 (
    c1 integer,
    c2 integer,
    c3 integer
);

CREATE OR REPLACE FUNCTION public.f1(s integer, k integer = 43) RETURNS integer
    LANGUAGE plpgsql
    AS $$ begin SELECT count(t.c1) from public.t1 t where c1 = s ; end $$;

CREATE OR REPLACE FUNCTION public.f_inline_short() RETURNS void
    LANGUAGE sql
    RETURN (SELECT t.c1 FROM public.t1 t LIMIT 1);

CREATE OR REPLACE FUNCTION public.f_inline_full() RETURNS void
    LANGUAGE sql
    BEGIN ATOMIC
 SELECT t.c2 FROM public.t2 t LIMIT 1;
END;