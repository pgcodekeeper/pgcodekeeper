ALTER TABLE cities
	DETACH PARTITION cities_ab;

ALTER TABLE cities_ab OF public.comp;
