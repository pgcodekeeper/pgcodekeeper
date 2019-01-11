CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE INDEX testindex3 ON public.testtable USING btree (field2) INCLUDE (field4);

CREATE INDEX testindex2 ON public.testtable USING btree (field2) INCLUDE (field4);