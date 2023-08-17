SET search_path = pg_catalog;

CREATE INDEX t_test_3_i ON public.t_test_3 USING btree (c1, c2);

ALTER TABLE public.t_test_3 CLUSTER ON t_test_3_i;

ALTER MATERIALIZED VIEW public.mv1 CLUSTER ON mv1_i;

ALTER TABLE public.t_test_2
	ADD CONSTRAINT t_test_2_pkey PRIMARY KEY (c1);

ALTER TABLE public.t_test_2 CLUSTER ON t_test_2_pkey;

ALTER TABLE public.t_test CLUSTER ON t_test_pkey;