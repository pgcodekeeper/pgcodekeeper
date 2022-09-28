SET search_path = pg_catalog;

CREATE SEQUENCE public.testseq
	AS smallint
	START WITH 15
	INCREMENT BY 2
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.testseq OWNER TO fordfrog;
