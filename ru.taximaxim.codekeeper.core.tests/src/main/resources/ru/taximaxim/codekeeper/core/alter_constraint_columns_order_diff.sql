SET search_path = pg_catalog;

ALTER TABLE public.t1
	DROP CONSTRAINT c1;

ALTER TABLE public.t1
	ADD CONSTRAINT c1 EXCLUDE USING gist (b WITH &&, a WITH &&);