CREATE SCHEMA another_triggers;

ALTER SCHEMA another_triggers OWNER TO postgres;

DROP TRIGGER test_table_trigger ON test_table;

SET search_path = another_triggers, pg_catalog;

-- DEPCY: This FUNCTION is a dependency of TRIGGER: test_table_trigger

CREATE OR REPLACE FUNCTION test_table_trigger_another() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
    return NEW;
end;
$$;

ALTER FUNCTION test_table_trigger_another() OWNER TO postgres;

SET search_path = public, pg_catalog;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON test_table
	FOR EACH ROW
	EXECUTE PROCEDURE another_triggers.test_table_trigger_another();

DROP FUNCTION test_table_trigger();
