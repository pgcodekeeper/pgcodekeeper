CREATE TABLE public.t1 (
    id integer
);

ALTER TABLE public.t1 
    ADD CONSTRAINT uq_nulls_distinct UNIQUE NULLS DISTINCT (id);

ALTER TABLE public.t1
    DROP CONSTRAINT uq_nulls_distinct;

ALTER TABLE public.t1 
    ADD CONSTRAINT uq_nulls_not_distinct UNIQUE NULLS NOT DISTINCT (id);