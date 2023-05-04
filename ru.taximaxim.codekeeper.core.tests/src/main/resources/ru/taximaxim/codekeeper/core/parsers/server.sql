CREATE SERVER myserver FOREIGN DATA WRAPPER postgres_fdw OPTIONS (host 'foo', dbname 'foodb', port '5432');

ALTER SERVER myserver OPTIONS (host 'host');

DROP SERVER myserver;

-- only for greenplum

CREATE SERVER foreign_server FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    mpp_execute 'all segments',
    host '192.83.123.89',
    port '5432',
    dbname 'foreign_db'
);

ALTER SERVER foreign_server OPTIONS (SET mpp_execute 'master');