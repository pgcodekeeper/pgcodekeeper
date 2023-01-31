CREATE SERVER myserver FOREIGN DATA WRAPPER postgres_fdw OPTIONS (host 'foo', dbname 'foodb', port '5432');

ALTER SERVER myserver OPTIONS (host 'host');

DROP SERVER myserver;