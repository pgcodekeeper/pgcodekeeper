CREATE TABLE public.parenttable (
    field3 information_schema.cardinal_number
);

CREATE TABLE public.parenttable2 (
    id bigserial NOT NULL
);

CREATE TABLE public.testtable (
    field1 polygon
)
INHERITS (public.parenttable2);