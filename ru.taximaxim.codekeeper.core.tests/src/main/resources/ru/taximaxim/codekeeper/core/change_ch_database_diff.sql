DROP DATABASE db_comment;

DROP DATABASE db_comment_2;

CREATE DATABASE db_comment
ENGINE = Memory
COMMENT 'change comment';

CREATE DATABASE db_comment_2
ENGINE = Atomic
COMMENT 'The temporary database';