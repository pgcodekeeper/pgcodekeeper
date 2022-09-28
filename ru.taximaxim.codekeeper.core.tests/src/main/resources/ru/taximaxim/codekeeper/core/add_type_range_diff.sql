SET search_path = pg_catalog;

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU.utf8"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

DROP TYPE public.textrange333;

CREATE TYPE public.textrange333 AS RANGE (
	subtype = text,
	collation = pg_catalog."C",
	multirange_type_name = public.multirange_of_text2
);

ALTER TYPE public.textrange333 OWNER TO khazieva_gr;