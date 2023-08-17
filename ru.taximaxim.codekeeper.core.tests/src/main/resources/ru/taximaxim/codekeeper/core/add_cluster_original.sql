CREATE TABLE public.t_test (
	c1 bigint NOT NULL,
	c2 bigint NOT NULL,
	c3 bigint NOT NULL
);

ALTER TABLE public.t_test
	ADD CONSTRAINT t_test_pkey PRIMARY KEY (c1);

--------------------------------------------------------------------------------

CREATE TABLE public.t_test_2 (
	c1 bigint NOT NULL,
	c2 bigint NOT NULL,
	c3 bigint NOT NULL
);

--------------------------------------------------------------------------------

CREATE TABLE public.t_test_3 (
	c1 bigint NOT NULL,
	c2 bigint NOT NULL,
	c3 bigint NOT NULL
);

--------------------------------------------------------------------------------

CREATE MATERIALIZED VIEW public.mv1 AS
	SELECT t1.c1,
    t1.c2
   FROM public.t1
WITH DATA;

CREATE INDEX mv1_i ON public.mv1 USING btree (c1);