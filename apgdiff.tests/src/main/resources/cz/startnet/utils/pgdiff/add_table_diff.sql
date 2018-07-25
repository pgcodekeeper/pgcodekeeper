SET search_path = pg_catalog;

CREATE TABLE public.testtable2 (
	id integer,
	name character varying(100) NOT NULL
);

ALTER TABLE public.testtable2 OWNER TO fordfrog;
