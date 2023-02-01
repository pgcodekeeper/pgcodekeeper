CREATE SERVER local_server FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    host '127.0.0.1',
    dbname 'postgres',
    port '5432'
);


CREATE FOREIGN TABLE public.t1 (
	c1 integer NOT NULL,
	c2 integer NOT NULL,
	c3 bigint NOT NULL
)
SERVER local_server;