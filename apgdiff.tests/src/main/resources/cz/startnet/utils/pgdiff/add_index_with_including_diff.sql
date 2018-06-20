SET search_path = pg_catalog;

DROP INDEX public.testindex3;

CREATE INDEX testindex4 ON public.testtable USING btree (field3) INCLUDE (field4);

DROP INDEX public.testindex2;

CREATE INDEX testindex2 ON public.testtable USING btree (field2);

ALTER TABLE public.testtable CLUSTER ON testindex2;