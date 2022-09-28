CREATE TYPE public.testtype AS (
    field1 text,
    field2 numeric,
    field3 text,
    field4 boolean
);

ALTER TYPE public.testtype OWNER TO shamsutdinov_lr;

CREATE TABLE public.testtable OF public.testtype;

ALTER TABLE public.testtable OWNER TO shamsutdinov_lr;