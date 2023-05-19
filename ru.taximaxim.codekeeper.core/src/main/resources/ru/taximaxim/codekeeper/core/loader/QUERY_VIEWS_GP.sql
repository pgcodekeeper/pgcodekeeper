SELECT
	oid,
	pg_get_table_distributedby(oid) AS distribution
FROM pg_catalog.pg_class
