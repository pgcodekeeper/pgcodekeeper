SET search_path = pg_catalog;

CREATE EXTENSION postgres_fdw SCHEMA public;

COMMENT ON EXTENSION postgres_fdw IS 'foreign-data wrapper for remote PostgreSQL servers';

CREATE SERVER film_server FOREIGN DATA WRAPPER postgres_fdw;

ALTER SERVER film_server OWNER TO galiev_mr;

CREATE SERVER new_server FOREIGN DATA WRAPPER postgres_fdw;

ALTER SERVER new_server OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER film_server
OPTIONS (
    schema_name 'public',
    table_name 'films',
    updatable 'true',
    use_remote_estimate 'true'
);

ALTER FOREIGN TABLE public.films ALTER COLUMN code SET STORAGE PLAIN;

ALTER FOREIGN TABLE public.films ALTER COLUMN code SET (n_distinct_inherited=1, n_distinct=-0.7);

ALTER FOREIGN TABLE public.films ALTER COLUMN code OPTIONS (column_name 'number');

ALTER FOREIGN TABLE public.films ALTER COLUMN title OPTIONS (column_name 'name');

ALTER FOREIGN TABLE public.films OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.new_films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER new_server;

ALTER FOREIGN TABLE public.new_films OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.old_films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER film_server;

ALTER FOREIGN TABLE public.old_films OWNER TO galiev_mr;
