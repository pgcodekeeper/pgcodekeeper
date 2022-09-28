SET search_path = pg_catalog;

DROP TYPE public.typ_enum;

CREATE TYPE public.typ_enum AS ENUM (
	'wat',
	'wut'
);