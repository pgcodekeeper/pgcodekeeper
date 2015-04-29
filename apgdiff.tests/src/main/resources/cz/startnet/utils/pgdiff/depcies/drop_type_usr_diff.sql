-- DEPCY: This VIEW depends on the TYPE: ty1

DROP VIEW v1;

-- DEPCY: This COLUMN depends on the TYPE: ty1

ALTER TABLE t1
	DROP COLUMN c1;

DROP TYPE ty1;

-- DEPCY: This TYPE is a dependency of VIEW: v1

CREATE TYPE ty1 AS ENUM (
	'a'
);

ALTER TYPE ty1 OWNER TO botov_av;

-- DEPCY: This COLUMN is a dependency of VIEW: v1

ALTER TABLE t1
	ADD COLUMN c1 ty1;

CREATE VIEW v1 AS
	SELECT t1.c1
   FROM t1;

ALTER VIEW v1 OWNER TO botov_av;
