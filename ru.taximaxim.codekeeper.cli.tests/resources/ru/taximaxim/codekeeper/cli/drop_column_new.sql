CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field3);