SET search_path = public, pg_catalog;

CREATE VIEW testview AS
	SELECT testtable.id, testtable.name FROM testtable;

ALTER VIEW testview OWNER TO fordfrog;
