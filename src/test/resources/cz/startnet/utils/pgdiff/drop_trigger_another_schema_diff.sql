SET search_path = public, pg_catalog;

DROP TRIGGER test_table_trigger ON test_table;

SET search_path = another_triggers, pg_catalog;

DROP FUNCTION test_table_trigger_another();
