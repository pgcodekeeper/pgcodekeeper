
CREATE TABLE testtable2 (
	id integer,
	name character varying(100) NOT NULL,
	sequence integer DEFAULT nextval('testtable2_sequence_seq'::regclass) NOT NULL
);

ALTER TABLE testtable2 OWNER TO fordfrog;
