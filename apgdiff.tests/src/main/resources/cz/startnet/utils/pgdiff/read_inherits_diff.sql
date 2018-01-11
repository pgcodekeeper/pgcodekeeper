SET search_path = public, pg_catalog;

ALTER TABLE testtable
	ADD COLUMN field2 information_schema.cardinal_number;
