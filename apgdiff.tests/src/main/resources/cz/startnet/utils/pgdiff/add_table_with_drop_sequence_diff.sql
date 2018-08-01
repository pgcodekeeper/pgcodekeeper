SET search_path = pg_catalog;

DROP SEQUENCE public.testtable2_sequence_seq;

CREATE TABLE public.testtable2 (
	id integer,
	name character varying(100) NOT NULL,
	sequence integer NOT NULL
);

ALTER TABLE public.testtable2 OWNER TO fordfrog;
