SET search_path = pg_catalog;

CREATE TABLE "ABC".testtable2 (
	id integer,
	name character varying(100) NOT NULL
);

ALTER TABLE "ABC".testtable2 OWNER TO fordfrog;
