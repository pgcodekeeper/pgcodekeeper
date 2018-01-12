SET search_path = public, pg_catalog;

CREATE SEQUENCE testtable2_sequence_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testtable2_sequence_seq OWNER TO fordfrog;

CREATE TABLE testtable2 (
	id integer,
	name character varying(100) NOT NULL,
	sequence integer DEFAULT nextval('testtable2_sequence_seq'::regclass) NOT NULL
);

ALTER TABLE testtable2 OWNER TO fordfrog;
