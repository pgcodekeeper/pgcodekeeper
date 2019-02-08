CREATE TABLE public.parenttable (
    id bigserial NOT NULL
);

CREATE TABLE public.testtable (
    field1 polygon
)
INHERITS (public.parenttable);

ALTER TABLE public.testtable OWNER TO fordfrog;