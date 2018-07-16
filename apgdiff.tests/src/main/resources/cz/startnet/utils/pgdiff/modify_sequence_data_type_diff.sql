SET search_path = pg_catalog;

ALTER SEQUENCE public.testseq
	AS smallint
	INCREMENT BY 10
	RESTART WITH 15;
