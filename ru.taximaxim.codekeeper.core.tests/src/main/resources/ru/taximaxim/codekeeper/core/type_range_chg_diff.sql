SET search_path = pg_catalog;

DROP TYPE public.typ_range;

DROP TYPE public.textrange111;

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	subtype_opclass = date_ops,
	collation = pg_catalog."ru_RU.utf8",
	canonical = daterange_canonical
);

ALTER TYPE public.typ_range OWNER TO botov_av;

CREATE TYPE public.textrange111 AS RANGE (
	subtype = text,
	collation = pg_catalog."C"
);

ALTER TYPE public.textrange111 OWNER TO khazieva_gr;
