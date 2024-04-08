--change func body
CREATE FUNCTION test_function AS () -> (SELECT * FROM test_table LIMIT 1);

--change func args
CREATE FUNCTION plustwo AS (a) -> a + 2;