SET search_path = pg_catalog;

DROP TABLE defval.t1;

DROP FUNCTION defval.f();

CREATE TABLE defval.t1 (
	c2 integer,
	c1 text DEFAULT USER
);

ALTER TABLE defval.t1 OWNER TO levsha_aa;