CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE INDEX testindex2 ON public.testtable USING btree (field2);
 
ALTER TABLE public.testtable CLUSTER ON testindex2;

CREATE INDEX testindex4 ON public.testtable USING btree (field3) INCLUDE (field4);