SET search_path = public, pg_catalog;

ALTER TABLE cities
	DETACH PARTITION cities_ab;