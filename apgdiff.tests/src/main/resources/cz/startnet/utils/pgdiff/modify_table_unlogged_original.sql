CREATE UNLOGGED TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE TABLE public.testtable2 (
    field1 integer,
    field2 integer
);