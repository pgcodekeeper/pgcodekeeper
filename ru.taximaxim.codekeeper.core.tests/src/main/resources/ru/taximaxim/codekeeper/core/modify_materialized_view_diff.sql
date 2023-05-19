SET search_path = pg_catalog;

ALTER TABLE public.testview_1
	SET TABLESPACE pg_default;

REFRESH MATERIALIZED VIEW public.testview_1;

ALTER TABLE public.testview_2
	SET TABLESPACE my_space;

DROP MATERIALIZED VIEW public.testview_3;

CREATE MATERIALIZED VIEW public.testview_3 AS
	SELECT * FROM public.testtable
WITH DATA
DISTRIBUTED REPLICATED;