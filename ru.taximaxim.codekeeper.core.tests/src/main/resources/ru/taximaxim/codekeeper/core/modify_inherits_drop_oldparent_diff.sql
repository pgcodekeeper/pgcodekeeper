SET search_path = pg_catalog;

ALTER TABLE public.parenttable
	DROP COLUMN id;

CREATE TABLE public.parenttable2 (
	id bigserial NOT NULL
);

ALTER TABLE public.parenttable2 OWNER TO fordfrog;

ALTER TABLE public.testtable
	NO INHERIT parenttable;

ALTER TABLE public.testtable
	INHERIT parenttable2;

ALTER TABLE public.parenttable
	ADD COLUMN field3 information_schema.cardinal_number;
