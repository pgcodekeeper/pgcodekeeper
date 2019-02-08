CREATE TYPE public.typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

CREATE TABLE public.distributors (
    did public.typ_range,
    name character varying(40)
);

ALTER TABLE public.distributors OWNER TO botov_av;