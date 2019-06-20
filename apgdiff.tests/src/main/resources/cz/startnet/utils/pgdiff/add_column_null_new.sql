CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision,
    field5 boolean DEFAULT false,
    field6 integer DEFAULT 0,
    field7 double precision DEFAULT 1 NOT NULL
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field3);