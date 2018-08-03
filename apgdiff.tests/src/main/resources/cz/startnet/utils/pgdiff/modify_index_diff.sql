SET search_path = pg_catalog;

DROP INDEX public.testindex;

CREATE INDEX """idxф.garbage=:;\""""." ON public.testtable USING btree (field3);
