CREATE TABLE public.testtable (
    id integer UNIQUE NULLS DISTINCT,
    value1 integer UNIQUE NULLS NOT DISTINCT,
    value2 text,
    value3 integer UNIQUE NULLS DISTINCT,
    value4 text,
    CONSTRAINT uq_nulls UNIQUE (value2)
);

ALTER TABLE public.testtable 
    ADD CONSTRAINT uq_nulls1 UNIQUE NULLS DISTINCT (value4);