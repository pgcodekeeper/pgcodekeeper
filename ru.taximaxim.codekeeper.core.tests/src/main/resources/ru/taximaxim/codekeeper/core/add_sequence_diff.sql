SET search_path = pg_catalog;

CREATE SEQUENCE public.testseq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.testseq OWNER TO fordfrog;

CREATE UNLOGGED SEQUENCE public.trigtest_i_seq1
	AS integer
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq1 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq1
	OWNED BY public.test.c1;