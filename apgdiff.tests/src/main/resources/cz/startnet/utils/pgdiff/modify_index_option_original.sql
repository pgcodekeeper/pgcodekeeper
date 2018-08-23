CREATE TABLE public.testtable (
    field1 integer,
    field2 integer
);

CREATE INDEX testindex ON public.testtable USING btree (field1) WITH (fillfactor = 60);
