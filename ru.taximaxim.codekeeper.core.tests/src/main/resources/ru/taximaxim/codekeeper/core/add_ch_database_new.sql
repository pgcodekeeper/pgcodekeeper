CREATE DATABASE default;

CREATE DATABASE `db_comment`
ENGINE = Memory
COMMENT 'The temporary database';

CREATE DATABASE `test_database`
ENGINE = PostgreSQL('postgres1:5432', 'test_database', 'postgres', '[HIDDEN]', 'schema_name', 1);

CREATE DATABASE db_12
ENGINE = Atomic;