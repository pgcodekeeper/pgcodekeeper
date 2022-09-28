CREATE TABLE public.testtable (
    f1 integer,
    f2 integer
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (f1);

ALTER TABLE public.testtable CLUSTER ON testindex;