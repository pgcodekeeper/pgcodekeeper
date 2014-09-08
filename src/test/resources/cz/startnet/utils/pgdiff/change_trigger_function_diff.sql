SET search_path = public, pg_catalog;

DROP TRIGGER test_table_trigger ON test_table;

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON test_table
	FOR EACH ROW
	EXECUTE PROCEDURE test_table_trigger();

SET search_path = another_triggers, pg_catalog;

DROP FUNCTION test_table_trigger_another();
