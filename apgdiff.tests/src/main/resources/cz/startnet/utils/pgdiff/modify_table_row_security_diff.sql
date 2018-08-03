SET search_path = pg_catalog;

ALTER TABLE public.testtable
	DROP COLUMN field4;

DROP TABLE public.testtable2;

CREATE TABLE public.testtable4 (
	id integer,
	field text
);

ALTER TABLE public.testtable4 ENABLE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.testtable4 FORCE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.testtable NO FORCE ROW LEVEL SECURITY;

ALTER TABLE public.testtable3 DISABLE ROW LEVEL SECURITY;
