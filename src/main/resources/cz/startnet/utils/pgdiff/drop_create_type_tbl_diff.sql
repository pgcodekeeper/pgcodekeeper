-- DEPCY: This object depends on the type we are about to drop: typ_range

DROP TABLE distributors;

DROP TYPE typ_range;

-- DEPCY: This object depends on the type we are about to create: typ_range

CREATE TABLE distributors (
	did typ_range,
	name character varying(40)
);

ALTER TABLE distributors OWNER TO botov_av;

CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE typ_range OWNER TO botov_av;
