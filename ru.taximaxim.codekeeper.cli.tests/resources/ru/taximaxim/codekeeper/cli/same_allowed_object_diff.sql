SET search_path = pg_catalog;

-- HIDDEN: Object public of type SCHEMA (action: ALTER, reason: object type is not in allowed types list)

-- HIDDEN: Object public.testtable of type TABLE (action: CREATE, reason: object type is not in allowed types list)

CREATE INDEX testindex ON public.testtable USING btree (field3);
