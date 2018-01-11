SET search_path = public, pg_catalog;

DROP TYPE typ_enum;

CREATE TYPE typ_enum AS ENUM (
	'wat',
	'wut'
);

ALTER TYPE typ_enum OWNER TO botov_av;
