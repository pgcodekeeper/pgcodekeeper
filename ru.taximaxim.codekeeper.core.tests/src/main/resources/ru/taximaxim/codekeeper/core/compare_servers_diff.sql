SET search_path = pg_catalog;

DROP SERVER test_server_1;

ALTER SERVER test_server_2 VERSION '9.4';

DROP SERVER test_server_3;

ALTER SERVER test_server_4 OPTIONS (DROP host );

ALTER SERVER test_server_4 OPTIONS (SET dbname 'new_db');

ALTER SERVER test_server_4 OPTIONS (ADD port '5432');

ALTER SERVER test_server_5 OWNER TO user1;

ALTER SERVER foreign_server OPTIONS (SET mpp_execute 'master');

CREATE SERVER test_server_1 TYPE 'new server' FOREIGN DATA WRAPPER fdw1;

CREATE SERVER test_server_3 FOREIGN DATA WRAPPER fdw_new;
