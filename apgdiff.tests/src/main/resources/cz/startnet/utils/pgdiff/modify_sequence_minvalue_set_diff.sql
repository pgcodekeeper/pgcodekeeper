SET search_path = public, pg_catalog;

ALTER SEQUENCE testseq
	MINVALUE 1000
	RESTART WITH 1000;
