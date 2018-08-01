SET search_path = pg_catalog;

DROP FOREIGN TABLE public.testtable;

-- DEPCY: This TABLE is a dependency of COLUMN: public.testtable.f1

CREATE TABLE public.testtable (
	f1 integer,
	f2 text,
	f3 text
);
