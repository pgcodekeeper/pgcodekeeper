-- DEPCY: This VIEW depends on the COLUMN: testtable.c2

DROP VIEW testview;

ALTER TABLE testtable
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: testtable original: integer new: text */

CREATE VIEW testview AS
	SELECT testtable.c1,
    testtable.c2
   FROM testtable;

ALTER VIEW testview OWNER TO galiev_mr;

COMMENT ON VIEW testview IS 'this is test comment';
