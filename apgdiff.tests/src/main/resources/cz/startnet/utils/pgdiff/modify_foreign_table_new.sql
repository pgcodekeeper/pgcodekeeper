CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;

ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO galiev_mr;

CREATE EXTENSION IF NOT EXISTS postgres_fdw WITH SCHEMA public;

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
    table_name 'all_films',
    use_remote_estimate 'false'
);
ALTER TABLE ONLY public.films ALTER COLUMN code SET STORAGE PLAIN;
ALTER TABLE ONLY public.films ALTER COLUMN code SET (n_distinct_inherited=0.5, n_distinct=-1);
ALTER FOREIGN TABLE public.films ALTER COLUMN code OPTIONS (
    column_name 'num'
);
ALTER FOREIGN TABLE public.films ALTER COLUMN kind OPTIONS (
    column_name 'film kind'
);

ALTER FOREIGN TABLE public.films OWNER TO galiev_mr;

CREATE TABLE public.my_films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
);

ALTER TABLE public.my_films OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.new_films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10)
)
SERVER new_server
OPTIONS (
    schema_name 'public'
);


ALTER FOREIGN TABLE public.new_films OWNER TO galiev_mr;

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