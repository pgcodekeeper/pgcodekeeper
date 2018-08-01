SET search_path = pg_catalog;

DROP TABLE public.testtable2;

DROP TABLE testschema1.testtable1;

DROP SCHEMA testschema1;

CREATE SCHEMA testschema2;

ALTER SCHEMA testschema2 OWNER TO fordfrog;

CREATE SEQUENCE public.testtable3_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.testtable3_id_seq OWNER TO fordfrog;

CREATE SEQUENCE testschema2.testtable1_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE testschema2.testtable1_id_seq OWNER TO fordfrog;

CREATE TABLE public.testtable3 (
	id bigint DEFAULT nextval('public.testtable3_id_seq'::regclass) NOT NULL
);

ALTER TABLE public.testtable3 OWNER TO fordfrog;

CREATE TABLE testschema2.testtable1 (
	id integer DEFAULT nextval('testschema2.testtable1_id_seq'::regclass) NOT NULL
);

ALTER TABLE testschema2.testtable1 OWNER TO fordfrog;

ALTER SEQUENCE public.testtable3_id_seq
	OWNED BY public.testtable3.id;

ALTER SEQUENCE testschema2.testtable1_id_seq
	OWNED BY testschema2.testtable1.id;
