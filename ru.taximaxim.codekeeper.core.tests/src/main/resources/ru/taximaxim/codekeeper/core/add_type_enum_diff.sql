SET search_path = pg_catalog;

CREATE TYPE public.typ_enum AS ENUM (
	'wat',
	'wut',
	'weed'
);

ALTER TYPE public.typ_enum OWNER TO botov_av;
