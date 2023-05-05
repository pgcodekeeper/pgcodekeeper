SET search_path = pg_catalog;

ALTER FOREIGN TABLE public.films_v1 OPTIONS (ADD mpp_execute 'all segments');

ALTER FOREIGN TABLE public.films_v2 OPTIONS (DROP mpp_execute );

ALTER FOREIGN TABLE public.films_v3 OPTIONS (SET mpp_execute 'master');