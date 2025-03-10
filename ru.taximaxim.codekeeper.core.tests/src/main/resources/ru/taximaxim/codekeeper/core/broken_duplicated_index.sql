CREATE TABLE public.t1 (c1 integer, c2 integer);

CREATE INDEX i ON public.t1 USING btree (c1);

CREATE INDEX i ON public.t1 USING btree (c2);