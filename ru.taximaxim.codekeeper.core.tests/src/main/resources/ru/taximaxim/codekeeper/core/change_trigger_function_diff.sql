SET search_path = pg_catalog;

-- DEPCY: This TRIGGER test_table_trigger depends on the FUNCTION: public.test_table_trigger()

DROP TRIGGER test_table_trigger ON public.test_table;

DROP FUNCTION public.test_table_trigger();

CREATE SCHEMA another_triggers;

CREATE OR REPLACE FUNCTION another_triggers.test_table_trigger_another() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
    return NEW;
end;
$$;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON public.test_table
	FOR EACH ROW
	EXECUTE PROCEDURE another_triggers.test_table_trigger_another();