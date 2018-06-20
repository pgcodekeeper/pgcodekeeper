SET search_path = pg_catalog;

-- DEPCY: This TRIGGER depends on the FUNCTION: test_table_trigger()

DROP TRIGGER test_table_trigger ON public.test_table;

DROP FUNCTION public.test_table_trigger();

CREATE SCHEMA another_triggers;

ALTER SCHEMA another_triggers OWNER TO postgres;

CREATE OR REPLACE FUNCTION another_triggers.test_table_trigger_another() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
    return NEW;
end;
$$;

ALTER FUNCTION another_triggers.test_table_trigger_another() OWNER TO postgres;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON public.test_table
	FOR EACH ROW
	EXECUTE PROCEDURE another_triggers.test_table_trigger_another();
