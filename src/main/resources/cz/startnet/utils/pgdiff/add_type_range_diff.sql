CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU.utf8"
);

ALTER TYPE typ_range OWNER TO botov_av;
