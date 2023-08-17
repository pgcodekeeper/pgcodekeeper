SET search_path = pg_catalog;

ALTER TABLE public.t_test CLUSTER ON t_test_i2;

ALTER TABLE public.t_test_3 CLUSTER ON t_test_3_i;

ALTER MATERIALIZED VIEW public.mv1 CLUSTER ON mv1_i2;