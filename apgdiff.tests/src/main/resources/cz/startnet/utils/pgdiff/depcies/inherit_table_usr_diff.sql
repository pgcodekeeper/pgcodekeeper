SET search_path = public, pg_catalog;

-- DEPCY: This SEQUENCE is a dependency of COLUMN: t2.c4

CREATE SEQUENCE seq2
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE seq2 OWNER TO botov_av;

ALTER TABLE t2
	ADD COLUMN c4 integer;

ALTER TABLE ONLY t2
	ALTER COLUMN c4 SET DEFAULT nextval('seq2'::regclass);