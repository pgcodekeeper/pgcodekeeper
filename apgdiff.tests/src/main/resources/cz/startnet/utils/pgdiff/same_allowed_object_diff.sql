-- HIDDEN: Object public of type SCHEMA

-- HIDDEN: Object public.testtable of type TABLE

SET search_path = public, pg_catalog;

CREATE INDEX testindex ON testtable USING btree (field3);

