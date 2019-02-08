CREATE TABLE public.testtable (
    id integer NOT NULL,
    field1 character(64),
    field2 character(64),
    field3 cidr,
    field4 character(64)
);
ALTER TABLE ONLY public.testtable ALTER COLUMN field1 SET STORAGE MAIN;
ALTER TABLE ONLY public.testtable ALTER COLUMN field2 SET STORAGE PLAIN;
ALTER TABLE ONLY public.testtable ALTER COLUMN field3 SET STORAGE EXTERNAL;
