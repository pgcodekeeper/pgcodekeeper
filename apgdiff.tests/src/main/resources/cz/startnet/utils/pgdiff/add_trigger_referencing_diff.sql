SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.test_table_trigger() RETURNS "trigger"
    LANGUAGE plpgsql
    AS $$
begin
	return NEW;
end;
$$;

ALTER FUNCTION public.test_table_trigger() OWNER TO fordfrog;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON public.test_table
	REFERENCING NEW TABLE AS newtab 
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE TRIGGER test_view_trigger1
	INSTEAD OF INSERT OR UPDATE ON public.test_view
	REFERENCING OLD TABLE AS oldtab 
	FOR EACH ROW
	EXECUTE PROCEDURE public.test_table_trigger();

CREATE TRIGGER test_view_trigger2
	AFTER INSERT OR UPDATE ON public.test_view
	REFERENCING NEW TABLE AS newtab OLD TABLE AS oldtab 
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.test_table_trigger();
