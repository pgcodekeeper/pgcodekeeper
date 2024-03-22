--change func body
CREATE FUNCTION test_function AS () -> (SELECT 1);

--change func args
CREATE FUNCTION plustwo AS (a, b) -> a + 2;