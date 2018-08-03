SET search_path = pg_catalog;

DROP TYPE public.typ_range;

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	subtype_opclass = date_ops,
	collation = pg_catalog."ru_RU.utf8",
	canonical = daterange_canonical
);

ALTER TYPE public.typ_range OWNER TO botov_av;
