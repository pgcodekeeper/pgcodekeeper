SET search_path = pg_catalog;

CREATE INDEX testindex2 ON public.testtable USING btree (field2);

ALTER TABLE public.testtable CLUSTER ON testindex2;
