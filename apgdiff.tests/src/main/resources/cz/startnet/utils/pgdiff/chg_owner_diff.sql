ALTER SCHEMA test_schema OWNER TO fordfrog;

ALTER TYPE typ_composite OWNER TO fordfrog;

ALTER DOMAIN dom OWNER TO fordfrog;

ALTER SEQUENCE test_id_seq OWNER TO fordfrog;

ALTER FUNCTION test_fnc(arg character varying) OWNER TO fordfrog;

ALTER FUNCTION trigger_fnc() OWNER TO fordfrog;

ALTER TABLE test OWNER TO fordfrog;

ALTER VIEW test_view OWNER TO fordfrog;