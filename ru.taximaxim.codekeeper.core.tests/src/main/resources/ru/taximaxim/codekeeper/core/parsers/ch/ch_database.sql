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
CREATE DATABASE db ENGINE = Memory;
CREATE DATABASE db ENGINE=Atomic;
CREATE DATABASE db ON CLUSTER test_shard_localhost;
CREATE DATABASE ordinary_db ENGINE = Ordinary;
CREATE DATABASE `01945.db`;
CREATE DATABASE `foo 1234`;
CREATE DATABASE `foo 123`;
CREATE DATABASE conv_main ENGINE = MySQL('127.0.0.1:3456', conv_main, 'metrika', 'password');
CREATE DATABASE database_123456789abcde;
CREATE DATABASE database_for_dict;
CREATE DATABASE database_for_dict_01018;
CREATE DATABASE IF NOT EXISTS replicated_database_test ENGINE = Replicated('some/path/' || currentDatabase() || '/replicated_database_test', 'shard_1', 'replica_1') SETTINGS max_broken_tables_ratio=1;
create database if not exists shard_0;
create database if not exists shard_1;
CREATE DATABASE IF NOT EXISTS shard_1;
CREATE DATABASE IF NOT EXISTS test_01487;
CREATE DATABASE IF NOT EXISTS test_max_num_to_warn_10;
CREATE DATABASE IF NOT EXISTS test_max_num_to_warn_8;
CREATE DATABASE IF NOT EXISTS test_max_num_to_warn_9;
CREATE DATABASE IF NOT EXISTS {CLICKHOUSE_DATABASE:Identifier};
CREATE DATABASE imdb_01148 ENGINE = Replicated('/test/databases/imdb_01148', '{shard}', '{replica}');
CREATE DATABASE lazy_db ENGINE = Lazy(1);
create database local_t_l5ydey engine=Replicated('/clickhouse/tables/test_' || currentDatabase() || '/{shard}/local_t_l5ydey', '1', '1');
CREATE DATABASE memory_01069 ENGINE = Memory;
CREATE DATABASE memory_db ENGINE = Memory;
CREATE DATABASE ordinary_db;
CREATE DATABASE replicated_database_params ENGINE = Replicated('some/path/' || currentDatabase() || '/replicated_database_params');
CREATE DATABASE replicated_database_params ENGINE = Replicated('some/path/' || currentDatabase() || '/replicated_database_params', 'shard_1');
create database replicated_db_no_args engine=Replicated;
CREATE DATABASE shard_0;
CREATE DATABASE shard_1;
CREATE DATABASE some_db;
CREATE DATABASE sqllt;
CREATE DATABASE t_2710_db engine=Atomic;
CREATE DATABASE test1601_detach_permanently_atomic Engine=Atomic;
CREATE DATABASE test1601_detach_permanently_lazy Engine=Lazy(10);
CREATE DATABASE test1601_detach_permanently_ordinary Engine=Ordinary;
CREATE DATABASE test_01048 ENGINE=Ordinary;
CREATE DATABASE test_01109 ENGINE=Atomic;
CREATE DATABASE test_01109_ordinary ENGINE=Ordinary;
CREATE DATABASE test_01109_other_atomic;
CREATE DATABASE test_01109_rename_exists ENGINE=Atomic;
CREATE DATABASE test_01148_atomic ENGINE=Atomic;
CREATE DATABASE test_01148_ordinary ENGINE=Ordinary;
CREATE DATABASE test_01155_atomic ENGINE=Atomic;
CREATE DATABASE test_01155_ordinary ENGINE=Ordinary;
CREATE DATABASE test_01191 ENGINE=Atomic;
CREATE DATABASE test_01249 ENGINE=Ordinary;
CREATE DATABASE test_01457;
CREATE DATABASE test_01516 ENGINE=Ordinary;
create database test_01600;
CREATE DATABASE test_01676;
CREATE DATABASE test_01748;
CREATE DATABASE test_01915_db ENGINE=Atomic;
CREATE DATABASE test_02771;
create database test_1164_memory engine=Memory;
CREATE DATABASE test_1602;
create database test_1603_rename_bug_atomic engine=Atomic;
create database test_1603_rename_bug_ordinary engine=Ordinary;
CREATE DATABASE test_buffer;
CREATE DATABASE test_dict_db;
CREATE database test_query_log_factories_info1 ENGINE=Atomic;
CREATE DATABASE truncate_test;
CREATE DATABASE {CLICKHOUSE_DATABASE:Identifier} ENGINE=Ordinary;
CREATE DATABASE {CLICKHOUSE_DATABASE:Identifier};
CREATE DATABASE {CLICKHOUSE_DATABASE_1:Identifier};
CREATE DATABASE {old_db_name:Identifier};
attach database db_01870;
ATTACH DATABASE dict_db_01254;
ATTACH DATABASE test1601_detach_permanently_atomic;
ATTACH DATABASE test1601_detach_permanently_lazy;
ATTACH DATABASE test1601_detach_permanently_ordinary;
ATTACH DATABASE test_01457;
ATTACH DATABASE test_01676;
DROP DATABASE database_for_cache_dictionary;
DROP DATABASE `01945.db`;
DROP DATABASE `foo 1234`;
DROP DATABASE `foo 123`;
DROP DATABASE database_123456789abcde;
DROP DATABASE database_for_dict;
DROP DATABASE database_for_range_dict;
DROP DATABASE db_01048;
DROP DATABASE empty_db_01036;
DROP DATABASE empty_db_02179;
DROP DATABASE {CLICKHOUSE_DATABASE_1:Identifier};
DROP DATABASE IF EXISTS db1;
DROP DATABASE IF EXISTS `foo 123`;
DROP DATABASE imdb_01148;
DROP DATABASE main_01487;
DROP DATABASE memory_01069;
DROP DATABASE replicated_database_params;
detach database db_01870;
DETACH DATABASE dict_db_01254;
DETACH DATABASE test_01457;
DETACH DATABASE test_01676;