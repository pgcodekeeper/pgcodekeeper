SET search_path = public, pg_catalog;

ALTER SEQUENCE testseq
	MAXVALUE 1000
	RESTART WITH 1000;
