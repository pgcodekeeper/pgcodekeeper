SET search_path = pg_catalog;

ALTER TABLE ONLY public.parenttable
	DROP COLUMN id;

CREATE TABLE public.parenttable2 (
	id bigserial NOT NULL
);

ALTER TABLE public.testtable
	NO INHERIT public.parenttable;

ALTER TABLE public.testtable
	INHERIT public.parenttable2;

ALTER TABLE public.parenttable
	ADD COLUMN field3 information_schema.cardinal_number;