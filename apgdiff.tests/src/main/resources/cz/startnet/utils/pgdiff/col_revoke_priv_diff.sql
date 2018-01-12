SET search_path = public, pg_catalog;

REVOKE ALL(c1) ON TABLE t1 FROM maindb;
REVOKE ALL(c1) ON TABLE t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE t1 FROM botov_av;
GRANT ALL(c1) ON TABLE t1 TO botov_av;