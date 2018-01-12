SET search_path = public, pg_catalog;

CREATE UNLOGGED TABLE testtable3 (
	id integer,
	name character varying(100) NOT NULL
);

ALTER TABLE testtable3 OWNER TO fordfrog;

ALTER TABLE testtable
	SET LOGGED;

ALTER TABLE testtable2
	SET UNLOGGED;
