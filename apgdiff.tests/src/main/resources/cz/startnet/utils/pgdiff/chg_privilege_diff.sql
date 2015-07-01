-- SCHEMA test_schema GRANT

REVOKE ALL ON SCHEMA test_schema FROM PUBLIC;
REVOKE ALL ON SCHEMA test_schema FROM botov_av;
GRANT ALL ON SCHEMA test_schema TO botov_av;
GRANT ALL ON SCHEMA test_schema TO fordfrog;

-- TYPE typ_composite GRANT

REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM botov_av;
GRANT ALL ON TYPE typ_composite TO botov_av;
GRANT ALL ON TYPE typ_composite TO PUBLIC;
GRANT ALL ON TYPE typ_composite TO fordfrog;

-- SEQUENCE test_id_seq GRANT

REVOKE ALL ON SEQUENCE test_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO fordfrog;

-- TABLE test GRANT

REVOKE ALL ON TABLE test FROM PUBLIC;
REVOKE ALL ON TABLE test FROM botov_av;
GRANT ALL ON TABLE test TO botov_av;
GRANT ALL ON TABLE test TO fordfrog;

-- COLUMN id GRANT

REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO fordfrog;

-- FUNCTION test_fnc(character varying) GRANT

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO PUBLIC;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO fordfrog;

-- FUNCTION trigger_fnc() GRANT

REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO PUBLIC;
GRANT ALL ON FUNCTION trigger_fnc() TO fordfrog;

-- VIEW test_view GRANT

REVOKE ALL ON TABLE test_view FROM PUBLIC;
REVOKE ALL ON TABLE test_view FROM botov_av;
GRANT ALL ON TABLE test_view TO botov_av;
GRANT ALL ON TABLE test_view TO fordfrog;