CREATE SEQUENCE testtable2_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testtable2_id_seq OWNER TO fordfrog;

CREATE TABLE testtable2 (
	id integer DEFAULT nextval('testtable2_id_seq'::regclass) NOT NULL,
	col1 boolean NOT NULL
);

ALTER TABLE testtable2 OWNER TO fordfrog;

CREATE INDEX testindex ON testtable USING btree (field1);

ALTER TABLE testtable CLUSTER ON testindex;

CREATE INDEX testtable2_col1 ON testtable2 USING btree (col1);

ALTER TABLE testtable2 CLUSTER ON testtable2_col1;

ALTER SEQUENCE testtable2_id_seq
	OWNED BY testtable2.id;
