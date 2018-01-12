SET search_path = public, pg_catalog;

DROP TRIGGER test_view_trigger1 ON test_view;

DROP TRIGGER test_table_trigger ON test_table;

CREATE TRIGGER test_view_trigger1
	BEFORE INSERT OR UPDATE ON test_view
	FOR EACH STATEMENT
	EXECUTE PROCEDURE test_table_trigger();

CREATE TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE OF id ON test_table
	FOR EACH STATEMENT
	EXECUTE PROCEDURE test_table_trigger();
