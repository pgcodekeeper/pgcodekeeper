SET search_path = pg_catalog;

DROP VIEW public.testview;

CREATE VIEW public.testview AS
	SELECT testtable.name, testtable.id FROM public.testtable;

ALTER VIEW public.testview OWNER TO fordfrog;
