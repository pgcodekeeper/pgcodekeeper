CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE TABLE public.testtable3 (
    id integer,
    name character varying(100) NOT NULL
);

ALTER TABLE ONLY public.testtable3 FORCE ROW LEVEL SECURITY;

ALTER TABLE public.testtable3 OWNER TO fordfrog;

CREATE TABLE public.testtable4 (
    id integer,
    field text
);

ALTER TABLE ONLY public.testtable4 FORCE ROW LEVEL SECURITY;

ALTER TABLE public.testtable3 OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field3);

ALTER TABLE public.testtable4 ENABLE ROW LEVEL SECURITY;