CREATE TABLE public.parenttable (
    id bigserial NOT NULL
);

CREATE TABLE public.testtable (
    field1 bit(1),
    field2 information_schema.cardinal_number
)
INHERITS (public.parenttable);