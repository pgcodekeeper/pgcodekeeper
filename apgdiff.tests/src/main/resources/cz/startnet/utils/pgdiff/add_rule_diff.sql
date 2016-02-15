CREATE OR REPLACE FUNCTION test_table_rule_f() RETURNS "rule"
    AS $$
begin
	return NEW;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION test_table_rule_f() OWNER TO fordfrog;

CREATE RULE test_rule AS
    ON SELECT TO test_table_rule DO INSTEAD test_table_rule_f();
