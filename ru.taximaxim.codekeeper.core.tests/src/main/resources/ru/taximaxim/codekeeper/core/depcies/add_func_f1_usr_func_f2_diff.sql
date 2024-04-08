-- DEPCY: This FUNCTION is a dependency of FUNCTION: function_1

CREATE FUNCTION function_2 AS (x) -> (a + 2);

CREATE FUNCTION function_1 AS (a, b) -> function_2(x);