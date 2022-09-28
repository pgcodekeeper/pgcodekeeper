CREATE SEQUENCE public.s2
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s2
    OWNED BY public.t2.c1;

CREATE SEQUENCE public.s3
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s3
    OWNED BY public.t3.c1;

CREATE SEQUENCE public.s5
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s5
    OWNED BY public.t5.c1;

CREATE SEQUENCE public.s6
    AS integer
    START WITH 1
    INCREMENT BY 2
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.s6
    OWNED BY public.t6.c1;

CREATE TABLE public.t1 (
    c1 integer,
    c2 text
);

CREATE TABLE public.t2 (
    c1 integer DEFAULT nextval('public.s2'::regclass) NOT NULL,
    c2 text
);

CREATE TABLE public.t3 (
    c1 integer DEFAULT nextval('public.s3'::regclass) NOT NULL,
    c2 text
);

CREATE TABLE public.t4 (
    c1 integer,
    c2 text
);

CREATE TABLE public.t5 (
    c1 integer DEFAULT nextval('public.s5'::regclass) NOT NULL,
    c2 text
);

CREATE TABLE public.t6 (
    c1 integer DEFAULT nextval('public.s6'::regclass) NOT NULL,
    c2 text
);