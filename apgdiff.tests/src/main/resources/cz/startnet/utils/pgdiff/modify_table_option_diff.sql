SET search_path = pg_catalog;

ALTER TABLE public.testtable RESET (fillfactor);

ALTER TABLE ONLY public.testtable SET WITHOUT OIDS;