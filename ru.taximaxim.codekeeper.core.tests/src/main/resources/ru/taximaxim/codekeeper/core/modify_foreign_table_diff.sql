SET search_path = pg_catalog;

ALTER FOREIGN TABLE ONLY public.new_films
	DROP COLUMN len;

ALTER FOREIGN TABLE public.films OPTIONS (SET table_name 'all_films');

ALTER FOREIGN TABLE public.films OPTIONS (DROP updatable );

ALTER FOREIGN TABLE public.films OPTIONS (SET use_remote_estimate 'false');

ALTER FOREIGN TABLE public.new_films OPTIONS (ADD schema_name 'public');

DROP FOREIGN TABLE public.old_films;

ALTER TABLE ONLY public.films ALTER COLUMN code SET (n_distinct_inherited=0.5, n_distinct=-1);

ALTER FOREIGN TABLE public.films
	ALTER COLUMN code OPTIONS (SET column_name 'num');

ALTER FOREIGN TABLE public.films
	ALTER COLUMN title OPTIONS (DROP column_name );

ALTER FOREIGN TABLE public.films
	ALTER COLUMN kind OPTIONS (ADD column_name 'film kind');

CREATE FOREIGN TABLE public.old_films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER new_server;

ALTER FOREIGN TABLE public.old_films OWNER TO galiev_mr;
