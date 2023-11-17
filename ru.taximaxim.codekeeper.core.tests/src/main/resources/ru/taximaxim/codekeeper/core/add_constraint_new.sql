CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision,
    "full" timestamp with time zone DEFAULT '2006-11-10 00:00:00+01'::timestamp with time zone NOT NULL,
    CONSTRAINT field4check CHECK (((field4 > (-5.0)::double precision) AND (field4 < (5.0)::double precision)))
);

CREATE TABLE public.test_un (
col1 text,
CONSTRAINT con_col1 UNIQUE (col1) INCLUDE (col1) with (fillfactor='10')
);