CREATE TABLE public.t1 (
    col1 integer,
    col2 integer,
    col3 integer,
    col4 integer
);

ALTER TABLE public.t1
    ADD CONSTRAINT constr CHECK (col1 > 0);