SET search_path = pg_catalog;

ALTER TABLE public.cities
	ATTACH PARTITION public.cities_ab FOR VALUES IN ('a', 'b');
