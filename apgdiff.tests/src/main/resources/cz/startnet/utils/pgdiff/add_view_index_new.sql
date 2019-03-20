CREATE MATERIALIZED VIEW public.testview AS 
SELECT 1 AS first
WITH NO DATA;

CREATE INDEX testindex ON public.testview USING btree (first);