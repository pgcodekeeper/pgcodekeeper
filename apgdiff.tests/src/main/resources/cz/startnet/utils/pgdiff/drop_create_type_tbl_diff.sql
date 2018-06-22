SET search_path = pg_catalog;

-- DEPCY: This COLUMN depends on the TYPE: public.typ_range

ALTER TABLE public.distributors
	DROP COLUMN did;

DROP TYPE public.typ_range;

-- DEPCY: This TYPE is a dependency of COLUMN: public.distributors.did

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

ALTER TABLE public.distributors
	ADD COLUMN did typ_range;
