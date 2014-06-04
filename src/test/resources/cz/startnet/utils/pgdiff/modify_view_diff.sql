
DROP VIEW IF EXISTS testview;

CREATE OR REPLACE VIEW testview AS
	SELECT testtable.name, testtable.id FROM testtable;
