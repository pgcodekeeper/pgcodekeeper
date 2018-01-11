SET search_path = public, pg_catalog;

CREATE TABLE t1 (
	c1 integer,
	c2 text
);

ALTER TABLE t1 OWNER TO botov_av;

-- TABLE t1 GRANT

GRANT ALL ON TABLE t1 TO PUBLIC;

-- COLUMN c1 GRANT

REVOKE ALL(c1) ON TABLE t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE t1 FROM botov_av;
GRANT ALL(c1) ON TABLE t1 TO maindb;

-- COLUMN c2 GRANT

GRANT ALL(c2) ON TABLE t1 TO maindb;