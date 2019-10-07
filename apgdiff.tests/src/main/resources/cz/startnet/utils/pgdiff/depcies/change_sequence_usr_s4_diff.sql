SET search_path = pg_catalog;

CREATE SEQUENCE public.s4
	AS integer
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.s4
	OWNED BY public.t4.c1;
