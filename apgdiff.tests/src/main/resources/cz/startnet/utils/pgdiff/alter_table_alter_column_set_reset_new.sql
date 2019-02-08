CREATE TABLE public.testtable (
    id integer NOT NULL,
    field1 character(64),
    field2 character(64),
    field3 character(64),
    field4 character(64),
    field5 character(64)
);
ALTER TABLE ONLY public.testtable ALTER COLUMN field1 SET (n_distinct=0.5, n_distinct_inherited=-0.75);
ALTER TABLE ONLY public.testtable ALTER COLUMN field2 SET (n_distinct=-0.5, n_distinct_inherited=5.0);
ALTER TABLE ONLY public.testtable ALTER COLUMN field5 SET (n_distinct=-1.0);