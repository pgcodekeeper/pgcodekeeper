CREATE TYPE public.testtype AS (
    field1 text,
    field2 numeric,
    field3 text,
    field4new numeric
);

ALTER TYPE public.testtype OWNER TO shamsutdinov_lr;

CREATE TABLE public.testtable OF public.testtype (
    field1 WITH OPTIONS NOT NULL,
    field2 WITH OPTIONS DEFAULT 1000,
    field3 WITH OPTIONS DEFAULT 'word'::text,
    field4new WITH OPTIONS DEFAULT 2000
);

ALTER TABLE public.testtable OWNER TO shamsutdinov_lr;

ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);