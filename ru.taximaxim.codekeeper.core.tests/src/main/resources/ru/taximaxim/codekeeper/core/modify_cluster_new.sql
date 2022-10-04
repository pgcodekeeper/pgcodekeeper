CREATE TABLE public.testtable (
    f1 integer,
    f2 integer
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (f1);

CREATE INDEX testindex2 ON public.testtable USING btree (f2);

ALTER TABLE public.testtable CLUSTER ON testindex2;