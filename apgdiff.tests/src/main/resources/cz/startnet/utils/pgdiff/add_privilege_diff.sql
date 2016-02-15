GRANT ALL ON SCHEMA test_schema TO botov_av;
GRANT ALL ON SCHEMA test_schema TO maindb;

GRANT ALL ON TYPE typ_composite TO botov_av;
GRANT ALL ON TYPE typ_composite TO PUBLIC;
GRANT ALL ON TYPE typ_composite TO maindb;

GRANT ALL ON SEQUENCE test_id_seq TO botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO maindb;

GRANT ALL ON FUNCTION test_fnc(arg character varying) TO botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO PUBLIC;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO maindb;

GRANT ALL ON FUNCTION trigger_fnc() TO botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO PUBLIC;
GRANT ALL ON FUNCTION trigger_fnc() TO maindb;

GRANT ALL ON TABLE test TO botov_av;
GRANT ALL ON TABLE test TO maindb;

-- COLUMN id GRANT

REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO maindb;

GRANT ALL ON TABLE test_view TO botov_av;
GRANT ALL ON TABLE test_view TO maindb;