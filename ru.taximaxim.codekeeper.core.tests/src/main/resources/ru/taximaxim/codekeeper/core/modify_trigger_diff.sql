SET search_path = pg_catalog;

DROP TRIGGER test_table_trigger ON public.test_table;

DROP TRIGGER test_view_trigger1 ON public.test_view;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE OF id ON public.test_table
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE TRIGGER test_view_trigger1
	BEFORE INSERT OR UPDATE ON public.test_view
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.test_table_trigger();
