SET search_path = public, pg_catalog;

-- DEPCY: This COLUMN depends on the TYPE: typ_range

ALTER TABLE distributors
	DROP COLUMN did;

DROP TYPE typ_range;

-- DEPCY: This TYPE is a dependency of COLUMN: distributors.did

CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE typ_range OWNER TO botov_av;

ALTER TABLE distributors
	ADD COLUMN did typ_range;
