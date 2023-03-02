SET search_path = pg_catalog;

ALTER SEQUENCE public.t1_c1_seq
	START WITH 2;

ALTER SEQUENCE public.t2_c1_seq
	OWNED BY NONE;

CREATE TABLE public.t1 (
	c1 integer DEFAULT nextval('public.t1_c1_seq'::regclass) NOT NULL,
	c2 text
);

ALTER SEQUENCE public.t1_c1_seq
	OWNED BY public.t1.c1;