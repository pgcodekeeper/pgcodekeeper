CREATE TABLE public.testtable (
    field1 integer,
    field2 integer
);

CREATE INDEX testindex ON public.testtable USING btree (field1);

CREATE INDEX testindex2 ON public.testtable USING btree (field2)
TABLESPACE test_tablespace;
