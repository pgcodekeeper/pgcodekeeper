SET search_path = public, pg_catalog;

DROP DOMAIN dom5;

CREATE DOMAIN dom5 AS text NOT NULL
	CONSTRAINT dom6_check CHECK ((VALUE <> ''::text));

ALTER DOMAIN dom5 OWNER TO botov_av;
