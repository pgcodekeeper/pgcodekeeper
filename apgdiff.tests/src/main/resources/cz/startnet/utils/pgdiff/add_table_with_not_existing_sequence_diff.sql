CREATE TABLE testtable2 (
	id integer,
	name character varying(100) NOT NULL,
	sequence integer NOT NULL
);

ALTER TABLE testtable2 OWNER TO fordfrog;
