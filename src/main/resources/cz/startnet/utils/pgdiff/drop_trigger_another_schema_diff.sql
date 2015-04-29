SET search_path = another_triggers, pg_catalog;

-- DEPCY: This TRIGGER depends on the FUNCTION: test_table_trigger_public()

DROP TRIGGER test_table_a_trigger ON test_table_a;

SET search_path = public, pg_catalog;

DROP FUNCTION test_table_trigger_public();
