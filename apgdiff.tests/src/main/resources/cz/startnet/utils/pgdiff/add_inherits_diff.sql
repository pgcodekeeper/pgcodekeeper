SET search_path = pg_catalog;

CREATE TABLE public.testtable (
	field1 polygon
)
INHERITS (public.parenttable);

ALTER TABLE public.testtable OWNER TO fordfrog;
