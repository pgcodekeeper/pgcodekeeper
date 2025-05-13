SET search_path = pg_catalog;

-- DEPCY: This COLUMN did depends on the TYPE: public.typ_range

ALTER TABLE ONLY public.distributors
	DROP COLUMN did;

DROP TYPE public.typ_range;

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

ALTER TABLE public.distributors
	ADD COLUMN did public.typ_range;