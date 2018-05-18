SET search_path = public, pg_catalog;

ALTER TABLE cities
	ATTACH PARTITION cities_ab FOR VALUES IN ('a', 'b');
