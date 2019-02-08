CREATE SEQUENCE public.testtable2_sequence_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE public.testtable2 (
    id integer,
    name character varying(100) NOT NULL,
    "sequence" integer DEFAULT nextval('public.testtable2_sequence_seq'::regclass) NOT NULL
);