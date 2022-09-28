CREATE TYPE public.typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU.utf8",
    SUBTYPE_OPCLASS=date_ops,
    CANONICAL=daterange_canonical
);

ALTER TYPE public.typ_range OWNER TO botov_av;

CREATE TYPE public.textrange111 AS RANGE (
    subtype = text,
    collation = pg_catalog."C"
);

ALTER TYPE public.textrange111 OWNER TO khazieva_gr;