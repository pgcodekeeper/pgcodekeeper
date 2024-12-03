-- DEPCY: This VIEW v1 is a dependency of FUNCTION: func_1

CREATE VIEW default.v1
(
	`s` UInt8 NOT NULL
)
AS SELECT 1 AS s;

CREATE FUNCTION func_1 AS (a) -> default.v1;