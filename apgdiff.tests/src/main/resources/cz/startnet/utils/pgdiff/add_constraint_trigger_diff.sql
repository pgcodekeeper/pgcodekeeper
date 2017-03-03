CREATE OR REPLACE FUNCTION test_table_trigger() RETURNS "trigger"
    AS $$
begin
	return NEW;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION test_table_trigger() OWNER TO fordfrog;

CREATE CONSTRAINT TRIGGER test_view_trigger1
	INSTEAD OF INSERT OR UPDATE ON test_view
	FROM test_table
	FOR EACH ROW
	EXECUTE PROCEDURE test_table_trigger();

CREATE CONSTRAINT TRIGGER test_view_trigger2
	AFTER INSERT OR UPDATE ON test_view
	DEFERRABLE INITIALLY IMMEDIATE
	FOR EACH STATEMENT
	EXECUTE PROCEDURE test_table_trigger();

CREATE CONSTRAINT TRIGGER test_table_trigger
	BEFORE INSERT OR UPDATE ON test_table
	FROM test_table
	DEFERRABLE INITIALLY DEFERRED
	FOR EACH ROW
	EXECUTE PROCEDURE test_table_trigger();