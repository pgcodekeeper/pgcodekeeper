SET search_path = pg_catalog;

ALTER TABLE public.testview_1
	SET TABLESPACE pg_default;

REFRESH MATERIALIZED VIEW public.testview_1;

ALTER TABLE public.testview_2
	SET TABLESPACE my_space;