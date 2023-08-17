CREATE TABLE public.t_test (
	c1 bigint NOT NULL,
	c2 bigint NOT NULL,
	c3 bigint NOT NULL
);

ALTER TABLE public.t_test
	ADD CONSTRAINT t_test_pkey PRIMARY KEY (c1);

ALTER TABLE public.t_test CLUSTER ON t_test_pkey;

--------------------------------------------------------------------------------

CREATE TABLE public.t_test_2 (
	c1 bigint NOT NULL,
	c2 bigint NOT NULL,
	c3 bigint NOT NULL
);

CREATE INDEX t_test_2_i ON public.t_test_2 USING btree (c1, c2);

ALTER TABLE public.t_test_2 CLUSTER ON t_test_2_i;

--------------------------------------------------------------------------------

CREATE MATERIALIZED VIEW public.mv1 AS
	SELECT t1.c1,
    t1.c2
   FROM public.t1
WITH DATA;

CREATE INDEX mv1_i2 ON public.mv1 USING btree (c1);

ALTER MATERIALIZED VIEW public.mv1 CLUSTER ON mv1_i2;