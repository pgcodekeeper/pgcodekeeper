CREATE DATABASE db_comment ENGINE = Memory COMMENT 'The temporary database';
CREATE DATABASE test_database ENGINE = PostgreSQL('postgres1:5432', 'test_database', 'postgres', 'mysecretpassword', 'schema_name',1);
CREATE DATABASE mysql_db ENGINE = MySQL('localhost:3306', 'test', 'my_user', 'user_password') SETTINGS read_write_timeout=10000, connect_timeout=100;
CREATE DATABASE sqlite_db ENGINE = SQLite('sqlite.db');
-- experimental database engines (20.02.2024)
CREATE DATABASE r ENGINE=Replicated('some/path/r','shard1','replica1');
CREATE DATABASE r ENGINE=Replicated('some/path/r','shard1','other_replica');
CREATE DATABASE r ENGINE=Replicated('some/path/r','other_shard','{replica}');
CREATE DATABASE r ENGINE=Replicated('some/path/r','other_shard','r2');
CREATE DATABASE postgres_db ENGINE = MaterializedPostgreSQL('postgres1:5432', 'postgres_database', 'postgres_user', 'postgres_password');
CREATE DATABASE postgres_database ENGINE = MaterializedPostgreSQL('postgres1:5432', 'postgres_database', 'postgres_user', 'postgres_password') SETTINGS materialized_postgresql_schema = 'postgres_schema';
CREATE DATABASE database1 ENGINE = MaterializedPostgreSQL('postgres1:5432', 'postgres_database', 'postgres_user', 'postgres_password') SETTINGS materialized_postgresql_tables_list = 'schema1.table1,schema2.table2,schema1.table3', materialized_postgresql_tables_list_with_schema = 1;
CREATE DATABASE mysql ENGINE = MaterializedMySQL('localhost:3306', 'db', 'user', '***') SETTINGS allows_query_when_mysql_lost=true, max_wait_time_when_mysql_unavailable=10000;
CREATE DATABASE db_name ENGINE = MaterializedMySQL('localhost:3306', 'db', 'user', '***')
TABLE OVERRIDE table1 (
    COLUMNS (
        userid UUID,
        category LowCardinality(String),
        timestamp DateTime CODEC(Delta, Default)
    )
    PARTITION BY toYear(timestamp)
),
TABLE OVERRIDE table2 (
    COLUMNS (
        client_ip String TTL created + INTERVAL 72 HOUR
    )
    SAMPLE BY ip_hash
);