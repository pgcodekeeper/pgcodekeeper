SET search_path = pg_catalog;

CREATE UNLOGGED TABLE public.testtable3 (
	id integer,
	name character varying(100) NOT NULL
);

ALTER TABLE public.testtable3 OWNER TO fordfrog;

ALTER TABLE public.testtable
	SET LOGGED;

ALTER TABLE public.testtable2
	SET UNLOGGED;
