CREATE TABLE public.t1 (
    id integer UNIQUE NULLS NOT DISTINCT
);

CREATE TABLE public.t2 (
    id integer,
    CONSTRAINT uq_nulls UNIQUE NULLS NOT DISTINCT (id)
);

CREATE TABLE public.t3 (
    id integer UNIQUE NULLS DISTINCT
);

CREATE TABLE public.t4 (
    id integer UNIQUE NULLS NOT DISTINCT
);

CREATE TABLE public.t5 (
    id integer UNIQUE NULLS DISTINCT
);