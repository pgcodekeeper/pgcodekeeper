SET search_path = pg_catalog;

-- WARNING: Column testtable.field1 in new table has no STORAGE set but in old table storage was set. Unable to determine STORAGE type.

-- WARNING: Column testtable.field2 in new table has no STORAGE set but in old table storage was set. Unable to determine STORAGE type.

-- WARNING: Column testtable.field3 in new table has no STORAGE set but in old table storage was set. Unable to determine STORAGE type.

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 SET STORAGE MAIN;