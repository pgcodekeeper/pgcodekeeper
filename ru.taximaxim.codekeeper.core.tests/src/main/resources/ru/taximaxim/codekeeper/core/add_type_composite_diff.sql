SET search_path = pg_catalog;

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	"Value" text COLLATE pg_catalog."en_GB"
);

ALTER TYPE public.typ_composite OWNER TO botov_av;
