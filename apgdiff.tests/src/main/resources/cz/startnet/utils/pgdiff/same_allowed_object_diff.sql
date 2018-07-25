SET search_path = pg_catalog;

-- HIDDEN: Object public of type SCHEMA

-- HIDDEN: Object public.testtable of type TABLE

CREATE INDEX testindex ON public.testtable USING btree (field3);
