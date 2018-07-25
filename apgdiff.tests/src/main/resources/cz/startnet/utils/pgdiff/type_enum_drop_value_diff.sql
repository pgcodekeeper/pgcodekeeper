SET search_path = pg_catalog;

DROP TYPE public.typ_enum;

CREATE TYPE public.typ_enum AS ENUM (
	'wat',
	'wut'
);

ALTER TYPE public.typ_enum OWNER TO botov_av;
