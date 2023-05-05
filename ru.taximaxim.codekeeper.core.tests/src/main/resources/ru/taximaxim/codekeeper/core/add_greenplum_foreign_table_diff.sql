SET search_path = pg_catalog;

CREATE EXTENSION postgres_fdw SCHEMA public;

COMMENT ON EXTENSION postgres_fdw IS 'foreign-data wrapper for remote PostgreSQL servers';

CREATE SERVER foreign_server FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    mpp_execute 'all segments',
    host '192.83.123.89',
    port '5432',
    dbname 'foreign_db'
);

ALTER SERVER foreign_server OWNER TO shamsutdinov_er;

CREATE FOREIGN TABLE public.films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER foreign_server
OPTIONS (
    mpp_execute 'all segments'
);

ALTER FOREIGN TABLE public.films OWNER TO shamsutdinov_er;
