CREATE OR REPLACE FUNCTION public.f1(p1 text, p2 integer) RETURNS integer
    LANGUAGE sql
    AS $_$ select $2 LIMIT 1 $_$;

CREATE OR REPLACE FUNCTION public.f2(s integer, k integer = 43) RETURNS integer
    LANGUAGE sql
    AS $$ SELECT $2 ; $$;

CREATE SEQUENCE public.s1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s1
    OWNED BY public.t0.c1;
    
CREATE TABLE public.t0 (
    c1 integer DEFAULT nextval('public.s1'::regclass) NOT NULL,
    c2 integer DEFAULT public.f1('t', 2),
    c3 integer DEFAULT public.f2(1, 2),
    c4 public.type_tt
);

CREATE TYPE public.type_tt AS ();

CREATE SEQUENCE public.s2
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s2
    OWNED BY public.t1.c1;

CREATE SEQUENCE public.s4
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s4
    OWNED BY public.t4.c1;

CREATE SEQUENCE public.s6
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s6
    OWNED BY public.t6.c1;

CREATE TABLE public.t1 (
    c1 integer DEFAULT nextval('public.s2'::regclass) NOT NULL,
    c2 text
);

CREATE TABLE public.t2 (
    c1 integer NOT NULL,
    c2 text
);

CREATE TABLE public.t3 (
    c1 integer NOT NULL,
    c2 text
);

CREATE TABLE public.t4 (
    c1 integer DEFAULT nextval('public.s4'::regclass) NOT NULL,
    c2 text
);

CREATE TABLE public.t6 (
    c2 text,
    c1 integer DEFAULT nextval('public.s6'::regclass) NOT NULL,
    c3 integer DEFAULT public.fff(1, 2)
);
