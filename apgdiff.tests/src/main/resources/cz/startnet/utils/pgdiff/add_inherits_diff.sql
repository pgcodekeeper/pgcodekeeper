SET search_path = public, pg_catalog;

CREATE TABLE testtable (
	field1 polygon
)
INHERITS (parenttable);

ALTER TABLE testtable OWNER TO fordfrog;
