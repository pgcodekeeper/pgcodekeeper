SET search_path = pg_catalog;

ALTER SEQUENCE public.s2
	OWNED BY public.t1.c1;
