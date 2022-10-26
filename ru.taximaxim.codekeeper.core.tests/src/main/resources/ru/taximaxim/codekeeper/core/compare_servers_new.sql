-- type
CREATE SERVER test_server_1 TYPE 'new server' FOREIGN DATA WRAPPER fdw1;

--version
CREATE SERVER test_server_2 VERSION '9.4' FOREIGN DATA WRAPPER fdw1;

-- foreign data wrapper
CREATE SERVER test_server_3 FOREIGN DATA WRAPPER fdw_new;

--options
CREATE SERVER test_server_4 FOREIGN DATA WRAPPER fdw1 OPTIONS (dbname 'new_db', port '5432');

--OWNER--
CREATE SERVER test_server_5 FOREIGN DATA WRAPPER fdw1;
ALTER SERVER test_server_5 OWNER TO user1;