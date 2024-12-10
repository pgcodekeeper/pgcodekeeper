SET search_path = pg_catalog;

CREATE TABLE public.t1 (
	c1 integer,
	c2 integer,
	c3 integer
);

-- DEPCY: This CONSTRAINT t1_c1_pk is a dependency of VIEW: public.v6

ALTER TABLE public.t1
	ADD CONSTRAINT t1_c1_pk PRIMARY KEY (c1);

CREATE VIEW public.v6 AS
	SELECT 
        c1, c2
    FROM public.t1
    GROUP BY t1.c1;