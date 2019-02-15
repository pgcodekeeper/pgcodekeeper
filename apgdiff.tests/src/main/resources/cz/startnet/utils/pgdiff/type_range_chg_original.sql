CREATE TYPE public.typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU.utf8",
    SUBTYPE_OPCLASS=date_ops,
    SUBTYPE_DIFF=daterange_subdiff
);

ALTER TYPE public.typ_range OWNER TO botov_av;