-- SCHEMA test_schema GRANT

REVOKE ALL ON SCHEMA test_schema FROM PUBLIC;
REVOKE ALL ON SCHEMA test_schema FROM botov_av;
GRANT ALL ON SCHEMA test_schema TO botov_av;
GRANT ALL ON SCHEMA test_schema TO maindb;

-- TYPE typ_composite GRANT

REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM botov_av;
GRANT ALL ON TYPE typ_composite TO botov_av;
GRANT ALL ON TYPE typ_composite TO PUBLIC;
GRANT ALL ON TYPE typ_composite TO maindb;

-- DOMAIN dom GRANT

REVOKE ALL ON TYPE dom FROM PUBLIC;
REVOKE ALL ON TYPE dom FROM botov_av;
GRANT ALL ON TYPE dom TO botov_av;
GRANT ALL ON TYPE dom TO PUBLIC;
GRANT ALL ON TYPE dom TO maindb;

-- SEQUENCE test_id_seq GRANT

REVOKE ALL ON SEQUENCE test_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO maindb;

-- FUNCTION test_fnc(character varying) GRANT

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO PUBLIC;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO maindb;

-- FUNCTION trigger_fnc() GRANT

REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO PUBLIC;
GRANT ALL ON FUNCTION trigger_fnc() TO maindb;

-- TABLE test GRANT

REVOKE ALL ON TABLE test FROM PUBLIC;
REVOKE ALL ON TABLE test FROM botov_av;
GRANT ALL ON TABLE test TO botov_av;
GRANT ALL ON TABLE test TO maindb;

-- COLUMN id GRANT

REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO maindb;

-- VIEW test_view GRANT

REVOKE ALL ON TABLE test_view FROM PUBLIC;
REVOKE ALL ON TABLE test_view FROM botov_av;
GRANT ALL ON TABLE test_view TO botov_av;
GRANT ALL ON TABLE test_view TO maindb;