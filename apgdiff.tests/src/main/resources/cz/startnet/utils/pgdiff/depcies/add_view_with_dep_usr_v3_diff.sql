SET search_path = pg_catalog;

-- DEPCY: This TABLE is a dependency of VIEW: public.v3

CREATE TABLE public.t1 (
	c1 integer,
	c2 integer,
	c3 integer
);

CREATE VIEW public.v3 (c1, c2, c3) AS
	TABLE public.t1 *;
