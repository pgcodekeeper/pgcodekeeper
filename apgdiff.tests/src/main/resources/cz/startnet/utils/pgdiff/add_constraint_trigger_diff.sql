SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.test_table_trigger() RETURNS "trigger"
    LANGUAGE plpgsql
    AS $$
begin
	return NEW;
end;
$$;

ALTER FUNCTION public.test_table_trigger() OWNER TO fordfrog;

CREATE CONSTRAINT TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON public.test_table
	FROM public.test_table
	DEFERRABLE INITIALLY DEFERRED
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE CONSTRAINT TRIGGER test_view_trigger1
	INSTEAD OF INSERT OR UPDATE ON public.test_view
	FROM public.test_table
	NOT DEFERRABLE INITIALLY IMMEDIATE
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE CONSTRAINT TRIGGER test_view_trigger2
	AFTER INSERT OR UPDATE ON public.test_view
	DEFERRABLE INITIALLY IMMEDIATE
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.test_table_trigger();
