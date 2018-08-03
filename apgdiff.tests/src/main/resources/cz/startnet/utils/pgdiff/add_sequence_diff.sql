SET search_path = pg_catalog;

CREATE SEQUENCE public.testseq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.testseq OWNER TO fordfrog;
