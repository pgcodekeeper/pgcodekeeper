CREATE TABLE public.t1 (
    c1 integer
);

CREATE SEQUENCE public.s1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.s1 OWNED BY public.t1.c1;