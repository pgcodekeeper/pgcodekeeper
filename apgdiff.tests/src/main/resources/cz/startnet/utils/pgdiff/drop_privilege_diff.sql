REVOKE ALL ON SCHEMA test_schema FROM botov_av;
REVOKE ALL ON SCHEMA test_schema FROM maindb;

SET search_path = public, pg_catalog;

REVOKE ALL ON TYPE typ_composite FROM botov_av;
REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM maindb;

REVOKE ALL ON TYPE dom FROM botov_av;
REVOKE ALL ON TYPE dom FROM PUBLIC;
REVOKE ALL ON TYPE dom FROM maindb;

REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
REVOKE ALL ON SEQUENCE test_id_seq FROM maindb;

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM botov_av;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM maindb;

REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM maindb;

REVOKE ALL ON TABLE test FROM botov_av;
REVOKE ALL ON TABLE test FROM maindb;

REVOKE ALL(id) ON TABLE test FROM maindb;

REVOKE ALL ON TABLE test_view FROM botov_av;
REVOKE ALL ON TABLE test_view FROM maindb;