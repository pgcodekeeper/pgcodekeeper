DROP FUNCTION test_function;

DROP FUNCTION plustwo;

CREATE FUNCTION test_function AS () -> (SELECT 1);

CREATE FUNCTION plustwo AS (a, b) -> a + 2;
