SET search_path = pg_catalog;

DROP TABLE public.testtable;

-- DEPCY: This TABLE is a dependency of COLUMN: public.testtable.c5

CREATE TABLE public.testtable (
	c1 integer,
	c5 integer,
	c2 integer,
	c3 integer,
	c4 integer
);
