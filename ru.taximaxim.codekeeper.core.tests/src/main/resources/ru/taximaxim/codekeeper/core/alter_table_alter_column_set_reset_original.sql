CREATE TABLE public.testtable (
    id integer NOT NULL,
    field1 character(64),
    field2 character(64),
    field3 character(64),
    field4 character(64),
    field5 character(64)
);
ALTER TABLE ONLY public.testtable ALTER COLUMN field2 SET (n_distinct=3.0, n_distinct_inherited=2.0);
ALTER TABLE ONLY public.testtable ALTER COLUMN field3 SET (n_distinct=-1.0);
ALTER TABLE ONLY public.testtable ALTER COLUMN field4 SET (n_distinct=3.0, n_distinct_inherited=-0.5);