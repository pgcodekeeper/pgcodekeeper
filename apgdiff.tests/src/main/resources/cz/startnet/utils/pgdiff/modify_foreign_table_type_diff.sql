DROP FOREIGN TABLE testtable;

-- DEPCY: This TABLE is a dependency of COLUMN: testtable.f1

CREATE TABLE testtable (
	f1 integer,
	f2 text,
	f3 text
);
