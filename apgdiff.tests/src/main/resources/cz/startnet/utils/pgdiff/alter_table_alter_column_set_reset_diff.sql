SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable ALTER COLUMN field1 SET (n_distinct=0.5, n_distinct_inherited=-0.75);

ALTER TABLE ONLY public.testtable ALTER COLUMN field2 SET (n_distinct=-0.5, n_distinct_inherited=5.0);

ALTER TABLE ONLY public.testtable ALTER COLUMN field3 RESET (n_distinct);

ALTER TABLE ONLY public.testtable ALTER COLUMN field4 RESET (n_distinct, n_distinct_inherited);

ALTER TABLE ONLY public.testtable ALTER COLUMN field5 SET (n_distinct=-1.0);
