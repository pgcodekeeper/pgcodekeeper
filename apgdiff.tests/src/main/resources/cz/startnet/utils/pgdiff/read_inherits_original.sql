CREATE TABLE public.parenttable (
    id bigserial NOT NULL
);

CREATE TABLE public.testtable (
    field1 bit(1)
)
INHERITS (public.parenttable);