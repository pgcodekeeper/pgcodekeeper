CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE INDEX testindex ON public.testtable USING btree (field1);

CREATE INDEX testindex2 ON public.testtable USING btree (field2);

ALTER TABLE public.testtable CLUSTER ON testindex2;