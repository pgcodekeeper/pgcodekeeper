SET search_path = pg_catalog;

DROP MATERIALIZED VIEW public.testview_1;

DROP MATERIALIZED VIEW public.testview_2;

CREATE MATERIALIZED VIEW public.testview_1
TABLESPACE my_space AS
	SELECT * FROM public.testtable
WITH DATA;

ALTER MATERIALIZED VIEW public.testview_1 OWNER TO galiev_mr;

CREATE MATERIALIZED VIEW public.testview_2
TABLESPACE my_space AS
	SELECT * FROM public.testtable
WITH NO DATA;

ALTER MATERIALIZED VIEW public.testview_2 OWNER TO galiev_mr;
