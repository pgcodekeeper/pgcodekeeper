CREATE SEQUENCE sequence_testx INCREMENT BY 0;
CREATE SEQUENCE sequence_testx INCREMENT BY -1 MINVALUE 20;
CREATE SEQUENCE sequence_testx INCREMENT BY 1 MAXVALUE -20;
CREATE SEQUENCE sequence_testx INCREMENT BY -1 START 10;
CREATE SEQUENCE sequence_testx INCREMENT BY 1 START -10;
CREATE SEQUENCE sequence_testx CACHE 0;
CREATE SEQUENCE sequence_testx OWNED BY nobody;  -- nonsense word
CREATE SEQUENCE sequence_testx OWNED BY pg_class_oid_index.oid;  -- not a table
CREATE SEQUENCE sequence_testx OWNED BY pg_class.relname;  -- not same schema
CREATE SEQUENCE sequence_testx OWNED BY sequence_test_table.b;  -- wrong column
CREATE SEQUENCE sequence_test5 AS integer;
CREATE SEQUENCE sequence_test6 AS smallint;
CREATE SEQUENCE sequence_test7 AS bigint;
CREATE SEQUENCE sequence_test8 AS integer MAXVALUE 100000;
CREATE SEQUENCE sequence_test9 AS integer INCREMENT BY -1;
CREATE SEQUENCE sequence_test10 AS integer MINVALUE -100000 START 1;
CREATE SEQUENCE sequence_test11 AS smallint;
CREATE SEQUENCE sequence_test12 AS smallint INCREMENT -1;
CREATE SEQUENCE sequence_test13 AS smallint MINVALUE -32768;
CREATE SEQUENCE sequence_test14 AS smallint MAXVALUE 32767 INCREMENT -1;
CREATE SEQUENCE sequence_testx AS smallint MAXVALUE 100000;
CREATE SEQUENCE sequence_testx AS smallint MINVALUE -100000;
ALTER SEQUENCE sequence_test5 AS smallint;  -- success, max will be adjusted
ALTER SEQUENCE sequence_test8 AS smallint;  -- fail, max has to be adjusted
ALTER SEQUENCE sequence_test8 AS smallint MAXVALUE 20000;  -- ok now
ALTER SEQUENCE sequence_test9 AS smallint;  -- success, min will be adjusted
ALTER SEQUENCE sequence_test10 AS smallint;  -- fail, min has to be adjusted
ALTER SEQUENCE sequence_test10 AS smallint MINVALUE -20000;  -- ok now
DROP SEQUENCE sequence_test;
CREATE SEQUENCE foo_seq;
CREATE TEMP SEQUENCE myseq2;
ALTER SEQUENCE IF EXISTS sequence_test2 RESTART WITH 24 INCREMENT BY 4 MAXVALUE 36 MINVALUE 5 CYCLE;
ALTER SEQUENCE serialTest1 CYCLE;  -- error, not a sequence
CREATE SEQUENCE sequence_test2 START WITH 32;
CREATE SEQUENCE sequence_test4 INCREMENT BY -1;
ALTER SEQUENCE sequence_test2 RESTART;
ALTER SEQUENCE sequence_test2 RESTART WITH 0;  -- error
ALTER SEQUENCE sequence_test4 RESTART WITH 40;  -- error
ALTER SEQUENCE sequence_test2 RESTART WITH 24 INCREMENT BY 4 MAXVALUE 36 MINVALUE 5 CYCLE;
ALTER SEQUENCE sequence_test2 RESTART WITH 24 NO CYCLE;
ALTER SEQUENCE sequence_test2 RESTART WITH -24 START WITH -24 INCREMENT BY -4 MINVALUE -36 MAXVALUE -5 CYCLE;
ALTER SEQUENCE sequence_test2 RESTART WITH -24 NO CYCLE;
ALTER SEQUENCE IF EXISTS sequence_test2 RESTART WITH 32 START WITH 32 INCREMENT BY 4 MAXVALUE 36 MINVALUE 5 CYCLE;
COMMENT ON SEQUENCE asdf IS 'won''t work';
COMMENT ON SEQUENCE sequence_test2 IS 'will work';
COMMENT ON SEQUENCE sequence_test2 IS NULL;
CREATE SEQUENCE seq2;
CREATE TEMPORARY SEQUENCE sequence_test_temp1;
CREATE SEQUENCE seq3;
REVOKE ALL ON seq3 FROM regress_seq_user;
GRANT USAGE ON seq3 TO regress_seq_user;
GRANT UPDATE ON seq3 TO regress_seq_user;
ALTER SEQUENCE sequence_test2 START WITH 1;
CREATE SEQUENCE test_seq1 CACHE 10;