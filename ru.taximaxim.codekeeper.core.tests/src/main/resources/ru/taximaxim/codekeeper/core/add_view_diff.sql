SET search_path = pg_catalog;

CREATE VIEW public.testview AS
	SELECT testtable.id, testtable.name FROM public.testtable
WITH LOCAL CHECK OPTION;

ALTER VIEW public.testview OWNER TO fordfrog;
