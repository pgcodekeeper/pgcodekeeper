ALTER FOREIGN TABLE new_films
	DROP COLUMN len;

ALTER FOREIGN TABLE films OPTIONS (SET table_name 'all_films');

ALTER FOREIGN TABLE films OPTIONS (DROP updatable );

ALTER FOREIGN TABLE films OPTIONS (SET use_remote_estimate 'false');

ALTER FOREIGN TABLE new_films OPTIONS (ADD schema_name 'public');

DROP FOREIGN TABLE old_films;

ALTER TABLE ONLY films ALTER COLUMN code SET (n_distinct_inherited=0.5, n_distinct=-1);

ALTER FOREIGN TABLE films
	ALTER COLUMN code OPTIONS (SET column_name 'num');

ALTER FOREIGN TABLE films
	ALTER COLUMN title OPTIONS (DROP column_name );

ALTER FOREIGN TABLE films
	ALTER COLUMN kind OPTIONS (ADD column_name 'film kind');

CREATE FOREIGN TABLE old_films (
	code character(5) NOT NULL,
	title character varying(40) NOT NULL,
	did integer NOT NULL,
	date_prod date,
	kind character varying(10),
	len interval hour to minute
)
SERVER new_server;

ALTER FOREIGN TABLE old_films OWNER TO galiev_mr;
