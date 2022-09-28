SET search_path = pg_catalog;

CREATE INDEX testindex ON public.testview USING btree (first);
