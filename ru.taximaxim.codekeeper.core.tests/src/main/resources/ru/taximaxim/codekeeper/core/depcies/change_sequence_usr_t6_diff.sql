SET search_path = pg_catalog;

DROP TABLE public.t6;

CREATE SEQUENCE public.s6
	AS integer
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE public.t6 (
	c2 text,
	c1 integer DEFAULT nextval('public.s6'::regclass) NOT NULL,
	c3 integer DEFAULT public.fff(1, 2)
);

ALTER SEQUENCE public.s6
	OWNED BY public.t6.c1;