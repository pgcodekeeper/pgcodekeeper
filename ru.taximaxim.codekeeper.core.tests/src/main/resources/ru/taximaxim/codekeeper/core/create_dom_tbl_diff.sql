SET search_path = pg_catalog;

CREATE DOMAIN public.dom2 AS integer NOT NULL DEFAULT (-100)
	CONSTRAINT dom2_check CHECK ((VALUE < 1000));

ALTER DOMAIN public.dom2 OWNER TO botov_av;

CREATE TABLE public.distributors (
	did public.dom2,
	name character varying(40)
);

ALTER TABLE public.distributors OWNER TO botov_av;
