SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

ALTER TABLE public.t1
	DROP CONSTRAINT t1_c2_key;

ALTER TABLE public.t1
	ADD CONSTRAINT t1_c2_key UNIQUE (c2);
