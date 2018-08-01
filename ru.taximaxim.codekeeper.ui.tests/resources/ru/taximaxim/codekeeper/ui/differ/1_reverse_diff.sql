SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

ALTER TABLE public.t4
	DROP CONSTRAINT t4_c2_key;

ALTER TABLE public.t4
	ADD CONSTRAINT t4_c2_key UNIQUE (c1, c2);
