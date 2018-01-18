SET search_path = public, pg_catalog;

CREATE SEQUENCE testseq
	AS smallint
	START WITH 15
	INCREMENT BY 2
	MAXVALUE 32767
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testseq OWNER TO fordfrog;
