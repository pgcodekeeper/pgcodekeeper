SET search_path = pg_catalog;

ALTER TABLE public.testtable SET (fillfactor=70);

ALTER TABLE ONLY public.testtable SET WITH OIDS;