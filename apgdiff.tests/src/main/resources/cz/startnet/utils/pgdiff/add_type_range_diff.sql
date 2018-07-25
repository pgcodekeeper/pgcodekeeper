SET search_path = pg_catalog;

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU.utf8"
);

ALTER TYPE public.typ_range OWNER TO botov_av;
