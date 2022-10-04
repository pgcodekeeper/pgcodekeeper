SET search_path = pg_catalog;

ALTER DOMAIN public.dom1
	VALIDATE CONSTRAINT dom1_check;

ALTER TABLE public.t1
	VALIDATE CONSTRAINT t1_c1_check;