SET search_path = pg_catalog;

DROP DOMAIN public.dom5;

CREATE DOMAIN public.dom5 AS text NOT NULL
	CONSTRAINT dom6_check CHECK ((VALUE <> ''::text));

ALTER DOMAIN public.dom5 OWNER TO botov_av;
