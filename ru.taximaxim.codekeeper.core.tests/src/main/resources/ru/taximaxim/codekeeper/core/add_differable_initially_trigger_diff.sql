SET search_path = pg_catalog;

CREATE CONSTRAINT TRIGGER test_table_trigger_differed
	AFTER INSERT OR UPDATE ON public.test_table
	FROM public.test_table
	DEFERRABLE INITIALLY DEFERRED
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE CONSTRAINT TRIGGER test_table_trigger_immediate
	AFTER INSERT OR UPDATE ON public.test_table
	FROM public.test_table
	DEFERRABLE INITIALLY IMMEDIATE
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();