SET search_path = public, pg_catalog;

CREATE DOMAIN dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));

ALTER DOMAIN dom OWNER TO botov_av;

CREATE DOMAIN dom2 AS integer NOT NULL DEFAULT (-100)
	CONSTRAINT dom2_check CHECK ((VALUE < 1000));

ALTER DOMAIN dom2 OWNER TO botov_av;

CREATE DOMAIN dom3 AS integer NOT NULL;

ALTER DOMAIN dom3 OWNER TO botov_av;

CREATE DOMAIN dom3_1 AS integer NOT NULL;

ALTER DOMAIN dom3_1 OWNER TO botov_av;

CREATE DOMAIN dom4 AS integer NOT NULL
	CONSTRAINT dom4_check CHECK ((VALUE <> 0));

ALTER DOMAIN dom4 OWNER TO botov_av;

CREATE DOMAIN dom5 AS integer NOT NULL
	CONSTRAINT dom5_check CHECK ((VALUE <> 0))
	CONSTRAINT dom5_check1 CHECK ((VALUE <> (-1)))
	CONSTRAINT dom5_check2 CHECK ((VALUE <> 1));

ALTER DOMAIN dom5 OWNER TO botov_av;

CREATE DOMAIN dom6 AS text COLLATE pg_catalog."ru_RU.utf8"
	CONSTRAINT dom6_check CHECK ((VALUE <> ''::text));

ALTER DOMAIN dom6 OWNER TO botov_av;

CREATE DOMAIN dom8 AS text COLLATE pg_catalog."ru_RU.utf8" NOT NULL DEFAULT 'NO DATA'::text
	CONSTRAINT dom8_check CHECK ((VALUE <> ''::text))
	CONSTRAINT dom8_check1 CHECK ((lower(VALUE) <> 'null'::text))
	CONSTRAINT dom8_check2 CHECK ((VALUE <> (0)::text));

ALTER DOMAIN dom8 OWNER TO botov_av;
