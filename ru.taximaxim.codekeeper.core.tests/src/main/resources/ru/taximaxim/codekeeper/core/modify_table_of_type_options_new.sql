CREATE TYPE public.testtype AS (
    field1 text,
    field2 numeric,
    field3 text,
    field4 boolean
);

CREATE TABLE public.testtable OF public.testtype (
    field2 WITH OPTIONS DEFAULT 5000,
    field4 WITH OPTIONS NOT NULL
);