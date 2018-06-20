SET search_path = pg_catalog;

ALTER TABLE public.cities
	DETACH PARTITION cities_ab;