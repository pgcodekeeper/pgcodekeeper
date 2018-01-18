SET search_path = public, pg_catalog;

CREATE TYPE typ_enum AS ENUM (
	'wat',
	'wut',
	'weed'
);

ALTER TYPE typ_enum OWNER TO botov_av;
