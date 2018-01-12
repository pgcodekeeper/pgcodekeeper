SET search_path = public, pg_catalog;

CREATE TYPE typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

ALTER TYPE typ_composite OWNER TO botov_av;
