SET search_path = pg_catalog;

CREATE TABLE public.testtable2 (
	id integer,
	name character varying(100) NOT NULL,
	sequence integer DEFAULT nextval('public.testtable2_sequence_seq'::regclass) NOT NULL
);