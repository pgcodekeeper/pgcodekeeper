CREATE TABLE public.testtable (
    id integer NOT NULL,
    field1 character(64),
    field2 character(64),
    field3 cidr,
    field4 character(64)
);
ALTER TABLE ONLY public.testtable ALTER COLUMN field4 SET STORAGE MAIN;