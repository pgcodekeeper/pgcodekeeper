CREATE VIEW test2 AS
	SELECT 1 AS test_col;

CREATE VIEW test AS
	SELECT test_col FROM test2;
