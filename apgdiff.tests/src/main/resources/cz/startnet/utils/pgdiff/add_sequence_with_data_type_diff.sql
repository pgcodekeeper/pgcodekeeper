SET search_path = public, pg_catalog;

CREATE SEQUENCE testseq
	AS smallint
	START WITH 15
	INCREMENT BY 2
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testseq OWNER TO fordfrog;
