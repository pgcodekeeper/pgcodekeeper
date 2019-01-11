CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE UNLOGGED TABLE public.testtable2 (
    field1 integer,
    field2 integer
);

CREATE UNLOGGED TABLE public.testtable3 (
    id integer,
    name character varying(100) NOT NULL
);

ALTER TABLE public.testtable3 OWNER TO fordfrog;