REVOKE ALL ON SCHEMA test_schema FROM maindb;
GRANT ALL ON SCHEMA test_schema TO fordfrog;

REVOKE ALL ON TYPE typ_composite FROM maindb;
GRANT ALL ON TYPE typ_composite TO fordfrog;

REVOKE ALL ON SEQUENCE test_id_seq FROM maindb;
GRANT ALL ON SEQUENCE test_id_seq TO fordfrog;

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM maindb;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO fordfrog;

REVOKE ALL ON FUNCTION trigger_fnc() FROM maindb;
GRANT ALL ON FUNCTION trigger_fnc() TO fordfrog;

REVOKE ALL ON TABLE test FROM maindb;
GRANT ALL ON TABLE test TO fordfrog;

-- COLUMN id GRANT

REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO fordfrog;

REVOKE ALL ON TABLE test_view FROM maindb;
GRANT ALL ON TABLE test_view TO fordfrog;