-- type
CREATE SERVER test_server_1 TYPE 'server_type' FOREIGN DATA WRAPPER fdw1;

--version
CREATE SERVER test_server_2 VERSION '8.4' FOREIGN DATA WRAPPER fdw1;

-- foreign data wrapper
CREATE SERVER test_server_3 FOREIGN DATA WRAPPER fdw1;

--options
CREATE SERVER test_server_4 FOREIGN DATA WRAPPER fdw1 OPTIONS (host 'foo', dbname 'foodb');

--OWNER--
CREATE SERVER test_server_5 FOREIGN DATA WRAPPER fdw1;
ALTER SERVER test_server_5 OWNER TO khazieva_gr;

-- greenplum option
CREATE SERVER foreign_server FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    mpp_execute 'all segments',
    host '192.83.123.89',
    port '5432',
    dbname 'foreign_db'
);