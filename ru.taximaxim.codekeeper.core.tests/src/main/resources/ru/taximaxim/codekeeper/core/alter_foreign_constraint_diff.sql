SET search_path = pg_catalog;

ALTER TABLE public.t2
	ALTER CONSTRAINT t2_id_fkey NOT DEFERRABLE;

ALTER TABLE public.t3
	ALTER CONSTRAINT t3_fk_1 DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE public.t4
	ALTER CONSTRAINT t4_id_fkey DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE public.t5
	ALTER CONSTRAINT t5_id_fkey DEFERRABLE INITIALLY IMMEDIATE;

COMMENT ON CONSTRAINT t6_id_fkey ON public.t6 IS 'test';