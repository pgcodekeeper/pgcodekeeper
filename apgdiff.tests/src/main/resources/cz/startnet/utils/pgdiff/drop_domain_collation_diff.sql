SET search_path = public, pg_catalog;

DROP DOMAIN dom6;

CREATE DOMAIN dom6 AS text COLLATE pg_catalog."ru_RU"
	CONSTRAINT dom6_check CHECK ((VALUE <> ''::text));

ALTER DOMAIN dom6 OWNER TO botov_av;
