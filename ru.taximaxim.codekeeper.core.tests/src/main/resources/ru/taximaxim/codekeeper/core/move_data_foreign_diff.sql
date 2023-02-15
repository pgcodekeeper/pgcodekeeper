SET search_path = pg_catalog;

DROP FOREIGN TABLE public.tbl;

CREATE FOREIGN TABLE public.tbl (
	id bigint,
	value text,
	name text
)
SERVER my_server;
