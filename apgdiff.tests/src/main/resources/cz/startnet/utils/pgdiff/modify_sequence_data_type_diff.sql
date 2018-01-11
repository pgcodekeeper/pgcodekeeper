SET search_path = public, pg_catalog;

ALTER SEQUENCE testseq
	AS smallint
	INCREMENT BY 10
	MAXVALUE 32767
	RESTART WITH 15;
