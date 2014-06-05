SET search_path = testschema1, pg_catalog;

DROP TABLE testtable1;

DROP SEQUENCE testtable1_id_seq;

DROP SCHEMA testschema1;

CREATE SCHEMA testschema2;

ALTER SCHEMA testschema2 OWNER TO fordfrog;

SET search_path = public, pg_catalog;

DROP TABLE testtable2;

DROP SEQUENCE testtable2_id_seq;

CREATE SEQUENCE testtable3_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testtable3_id_seq OWNER TO fordfrog;

CREATE TABLE testtable3 (
	id bigint DEFAULT nextval('testtable3_id_seq'::regclass) NOT NULL
);

ALTER TABLE testtable3 OWNER TO fordfrog;

ALTER SEQUENCE testtable3_id_seq
	OWNED BY testtable3.id;

SET search_path = testschema2, pg_catalog;

CREATE SEQUENCE testtable1_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testtable1_id_seq OWNER TO fordfrog;

CREATE TABLE testtable1 (
	id integer DEFAULT nextval('testtable1_id_seq'::regclass) NOT NULL
);

ALTER TABLE testtable1 OWNER TO fordfrog;

ALTER SEQUENCE testtable1_id_seq
	OWNED BY testtable1.id;
