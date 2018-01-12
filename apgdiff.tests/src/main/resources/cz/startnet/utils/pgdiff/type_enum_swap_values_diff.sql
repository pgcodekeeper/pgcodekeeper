SET search_path = public, pg_catalog;

DROP TYPE typ_enum;

CREATE TYPE typ_enum AS ENUM (
	'e1',
	'e5',
	'e3',
	'e2',
	'e4',
	'e6'
);

ALTER TYPE typ_enum OWNER TO botov_av;
