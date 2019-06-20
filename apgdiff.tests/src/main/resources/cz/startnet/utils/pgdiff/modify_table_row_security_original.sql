CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

ALTER TABLE ONLY public.testtable FORCE ROW LEVEL SECURITY;

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE TABLE public.testtable2 (
    field1 integer,
    field2 integer
);

ALTER TABLE public.testtable2 OWNER TO fordfrog;

CREATE TABLE public.testtable3 (
    id integer,
    name character varying(100) NOT NULL
);

ALTER TABLE ONLY public.testtable3 FORCE ROW LEVEL SECURITY;

ALTER TABLE public.testtable3 OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field3);

ALTER TABLE public.testtable2 ENABLE ROW LEVEL SECURITY;

ALTER TABLE public.testtable3 ENABLE ROW LEVEL SECURITY;