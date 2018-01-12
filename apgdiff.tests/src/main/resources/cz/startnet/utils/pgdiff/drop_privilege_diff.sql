REVOKE ALL ON SCHEMA test_schema FROM botov_av;
REVOKE ALL ON SCHEMA test_schema FROM maindb;
REVOKE ALL ON SCHEMA test_schema FROM PUBLIC;
REVOKE ALL ON SCHEMA test_schema FROM botov_av;
GRANT ALL ON SCHEMA test_schema TO botov_av;

SET search_path = public, pg_catalog;

REVOKE ALL ON TYPE typ_composite FROM botov_av;
REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM maindb;
REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM botov_av;
GRANT ALL ON TYPE typ_composite TO botov_av;

REVOKE ALL ON TYPE dom FROM botov_av;
REVOKE ALL ON TYPE dom FROM PUBLIC;
REVOKE ALL ON TYPE dom FROM maindb;
REVOKE ALL ON DOMAIN dom FROM PUBLIC;
REVOKE ALL ON DOMAIN dom FROM botov_av;
GRANT ALL ON DOMAIN dom TO botov_av;

REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
REVOKE ALL ON SEQUENCE test_id_seq FROM maindb;
REVOKE ALL ON SEQUENCE test_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO botov_av;

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM botov_av;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM maindb;
REVOKE ALL ON FUNCTION test_fnc(character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(character varying) FROM botov_av;
GRANT ALL ON FUNCTION test_fnc(character varying) TO botov_av;

REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM maindb;
REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO botov_av;

REVOKE ALL ON TABLE test FROM botov_av;
REVOKE ALL ON TABLE test FROM maindb;
REVOKE ALL ON TABLE test FROM PUBLIC;
REVOKE ALL ON TABLE test FROM botov_av;
GRANT ALL ON TABLE test TO botov_av;

REVOKE ALL(id) ON TABLE test FROM maindb;
REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO botov_av;

REVOKE ALL ON TABLE test_view FROM botov_av;
REVOKE ALL ON TABLE test_view FROM maindb;
REVOKE ALL ON VIEW test_view FROM PUBLIC;
REVOKE ALL ON VIEW test_view FROM botov_av;
GRANT ALL ON VIEW test_view TO botov_av;