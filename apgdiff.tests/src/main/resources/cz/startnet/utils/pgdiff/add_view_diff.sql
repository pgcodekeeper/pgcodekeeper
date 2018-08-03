SET search_path = pg_catalog;

CREATE VIEW public.testview AS
	SELECT testtable.id, testtable.name FROM public.testtable;

ALTER VIEW public.testview OWNER TO fordfrog;
