SET search_path = pg_catalog;

DROP FOREIGN TABLE public.cities_xz;

CREATE FOREIGN TABLE public.cities_xz PARTITION OF public.new_cities
FOR VALUES IN ('x', 'z')
SERVER myserver;

ALTER FOREIGN TABLE ONLY public.cities_xz ALTER COLUMN c1 SET NOT NULL;

ALTER FOREIGN TABLE public.cities_xz OWNER TO galiev_mr;