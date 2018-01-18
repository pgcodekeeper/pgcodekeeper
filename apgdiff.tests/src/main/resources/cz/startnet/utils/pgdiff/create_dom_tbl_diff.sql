SET search_path = public, pg_catalog;

CREATE DOMAIN dom2 AS integer NOT NULL DEFAULT (-100)
	CONSTRAINT dom2_check CHECK ((VALUE < 1000));

ALTER DOMAIN dom2 OWNER TO botov_av;

CREATE TABLE distributors (
	did dom2,
	name character varying(40)
);

ALTER TABLE distributors OWNER TO botov_av;
