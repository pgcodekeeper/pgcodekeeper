SET search_path = pg_catalog;

ALTER SEQUENCE public.testseq
	MINVALUE 1000
	RESTART WITH 1000;
