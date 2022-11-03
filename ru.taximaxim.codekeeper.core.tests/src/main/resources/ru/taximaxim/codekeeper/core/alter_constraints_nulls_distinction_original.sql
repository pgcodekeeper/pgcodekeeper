CREATE TABLE public.t1 (
    id integer UNIQUE
);

CREATE TABLE public.t2 (
    id integer UNIQUE
);

CREATE TABLE public.t3 (
    id integer
);

CREATE TABLE public.t4 (
    id integer UNIQUE
);

CREATE TABLE public.t5 (
    id integer UNIQUE NULLS NOT DISTINCT
);