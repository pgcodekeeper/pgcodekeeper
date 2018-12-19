CREATE SCHEMA test
    CREATE TABLE test_table (c1 integer, c2 text, c3 text)
    CREATE VIEW test_view AS
        SELECT c1, c2 FROM test_table WHERE c3 IS NOT NULL
    GRANT SELECT ON test_view TO test_user;