
DROP VIEW testview;

CREATE VIEW testview AS
	SELECT testtable.name, testtable.id FROM testtable;

ALTER VIEW testview OWNER TO fordfrog;
