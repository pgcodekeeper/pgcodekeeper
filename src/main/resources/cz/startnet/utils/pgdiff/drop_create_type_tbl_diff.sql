-- DEPCY: This COLUMN depends on the TYPE: typ_range

ALTER TABLE distributors
	DROP COLUMN did;

DROP TYPE typ_range;

CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE typ_range OWNER TO botov_av;

ALTER TABLE distributors
	ADD COLUMN did typ_range;
