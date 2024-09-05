abort;
ALTER DEFAULT PRIVILEGES FOR ROLE regress_addr_user IN SCHEMA public GRANT ALL ON TABLES TO regress_addr_user;
ALTER DEFAULT PRIVILEGES FOR ROLE regress_addr_user REVOKE DELETE ON TABLES FROM regress_addr_user;
ALTER FOREIGN DATA WRAPPER alt_fdw1 RENAME TO alt_fdw2;
ALTER LANGUAGE alt_lang1 RENAME TO alt_lang2;
ALTER LANGUAGE alt_lang3 OWNER TO user3;
ALTER SERVER alt_fserv1 RENAME TO alt_fserv2;
ALTER STATISTICS alt_stat1 RENAME TO alt_stat2;
ALTER STATISTICS alt_stat2 OWNER TO regress_alter_generic_user2;
ALTER STATISTICS alt_stat2 SET SCHEMA alt_nsp2;
ALTER STATISTICS alt_stat2 SET STATISTICS -1;
ALTER STATISTICS alt_stat2 SET STATISTICS 2048;
ALTER STATISTICS alt_stat2 SET STATISTICS DEFAULT;
ALTER TEXT SEARCH CONFIGURATION alt_ts_conf2 SET SCHEMA alt_nsp2;
ALTER TEXT SEARCH CONFIGURATION alt_ts_conf3 RENAME TO alt_ts_conf4;
ALTER TEXT SEARCH DICTIONARY alt_ts_dict1 RENAME TO alt_ts_dict2;
ALTER TEXT SEARCH DICTIONARY alt_ts_dict2 OWNER TO user3;
ALTER TEXT SEARCH DICTIONARY alt_ts_dict2 SET SCHEMA s;
ALTER TEXT SEARCH PARSER alt_ts_prs1 RENAME TO alt_ts_prs3;
ALTER TEXT SEARCH PARSER alt_ts_prs2 SET SCHEMA alt_nsp2;
ALTER TEXT SEARCH TEMPLATE alt_ts_temp1 RENAME TO alt_ts_temp2;
ALTER TEXT SEARCH TEMPLATE alt_ts_temp2 SET SCHEMA alt_nsp2;
ANALYZE (VERBOSE TRUE, SKIP_LOCKED 1) public.t1 (c1, c2), public.t2 (c1, c2);
ANALYZE onek2;
ANALYZE vacparted(a,b,b);
ANALYZE VERBOSE q.t1 (c1, c2), public.t2 (c1, c2);
begin isolation level repeatable read;
begin;
CHECKPOINT;
CLOSE hsc;
CLUSTER public.t1;
COMMENT ON STATISTICS ctlt1_a_b_stat IS 'ab stats';
COPY (SELECT 1) TO STDOUT;
CREATE ACCESS METHOD gist2 TYPE INDEX HANDLER gisthandler;
CREATE AGGREGATE addr_nsp.genaggr(int4) (sfunc = int4pl, stype = int4);
CREATE EXTENSION hstore SCHEMA public FROM unpackaged;
CREATE FOREIGN DATA WRAPPER addr_fdw;
CREATE LANGUAGE alt_lang1 HANDLER plpgsql_call_handler;
CREATE SERVER "integer" FOREIGN DATA WRAPPER addr_fdw;
CREATE SERVER addr_fserv FOREIGN DATA WRAPPER addr_fdw;
CREATE SERVER alt_fserv1 FOREIGN DATA WRAPPER alt_fdw1;
CREATE STATISTICS (dependencies) ON a, b FROM t1;
CREATE STATISTICS ab1_b_a_stats ON b, a FROM ab1;
CREATE STATISTICS addr_nsp.gentable_stat ON a, b FROM addr_nsp.gentable;
CREATE STATISTICS alt_stat1 ON a, b FROM alt_regress_1;
CREATE STATISTICS ctlt1_a_b_stat ON a,b FROM ctlt1;
CREATE STATISTICS func_deps_stat (dependencies) ON a, b, c FROM functional_dependencies;
CREATE STATISTICS regress_schema_2.ab1_a_b_stats ON a, b FROM ab1;
CREATE STATISTICS s2 (mcv) ON a, b FROM t2;
CREATE TEXT SEARCH CONFIGURATION addr_ts_conf (copy=english);
CREATE TEXT SEARCH CONFIGURATION alt_ts_conf1 (copy=english);
CREATE TEXT SEARCH DICTIONARY addr_ts_dict (template=simple);
CREATE TEXT SEARCH DICTIONARY alt_ts_dict1 (template=simple);
CREATE TEXT SEARCH PARSER addr_ts_prs (start = prsd_start, gettoken = prsd_nexttoken, end = prsd_end, lextypes = prsd_lextype);
CREATE TEXT SEARCH PARSER alt_ts_prs1 (start = prsd_start, gettoken = prsd_nexttoken, end = prsd_end, lextypes = prsd_lextype);
CREATE TEXT SEARCH TEMPLATE addr_ts_temp (lexize=dsimple_lexize);
CREATE TEXT SEARCH TEMPLATE alt_ts_temp2 (lexize=dsimple_lexize);
CREATE TRANSFORM FOR int LANGUAGE SQL (FROM SQL WITH FUNCTION varchar_transform(internal), TO SQL WITH FUNCTION int4recv(internal));
CREATE TRIGGER t BEFORE INSERT ON addr_nsp.gentable FOR EACH ROW EXECUTE PROCEDURE addr_nsp.trig();
CREATE USER MAPPING FOR regress_addr_user SERVER "integer";
CREATE USER regress_addr_user;
CREATE VIEW addr_nsp.genview AS SELECT * from addr_nsp.gentable;
DEALLOCATE ALL;
deallocate tenk1_count;
DECLARE c CURSOR FOR SELECT ctid,cmin,* FROM combocidtest;
DECLARE hsc CURSOR FOR select * from hs3;
DECLARE xc CURSOR WITH HOLD FOR SELECT * FROM testxmlschema.test1 ORDER BY 1, 2;
discard all;
DISCARD SEQUENCES;
discard temp;
DROP ACCESS METHOD gist2;
DROP FOREIGN DATA WRAPPER alt_fdw3 CASCADE;
DROP LANGUAGE alt_lang3 CASCADE;
DROP ROLE IF EXISTS regress_addr_user;
DROP STATISTICS ab1_a_b_stats;
DROP STATISTICS regress_schema_2.ab1_a_b_stats;
DROP USER regress_alter_generic_user3;
end;
EXECUTE p2;
EXECUTE pp;
EXPLAIN (ANALYZE 'true', COSTS 'on', WAL true, FORMAT TEXT) select 1;
EXPLAIN (ANALYZE, VERBOSE, COSTS, SETTINGS, BUFFERS, WAL, TIMING, SUMMARY, FORMAT TEXT) select 1;
EXPLAIN (COSTS OFF) EXECUTE p1(2);
EXPLAIN (COSTS OFF) SELECT * FROM t1;
explain (verbose, costs off, analyze on, timing off, summary off) create table t1 as select 1;
EXPLAIN SELECT 1;
EXPLAIN (SERIALIZE BINARY) select 1;
EXPLAIN (MEMORY 'true') select 1;

-- Test SERIALIZE option
explain (analyze, serialize) select * from int8_tbl i8;
explain (analyze, serialize text,buffers,timing off) select * from int8_tbl i8;
explain (analyze, serialize binary,buffers,timing) select * from int8_tbl i8;
-- this tests an edge case where we have no data to return
explain (analyze, serialize) create temp table explain_temp as select * from int8_tbl i8;

-- MEMORY option
explain (memory) select * from int8_tbl i8;
explain (memory, analyze) select * from int8_tbl i8;
explain (memory, summary, format yaml) select * from int8_tbl i8;
explain (memory, analyze, format json) select * from int8_tbl i8;
explain (memory) execute int8_query;

LISTEN notify_async2;
LOCK lock_tbl1 IN ROW SHARE MODE;
LOCK lock_tbl1 IN SHARE ROW EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 * IN ACCESS EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ACCESS EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ACCESS EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ACCESS SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ACCESS SHARE MODE;
LOCK TABLE lock_tbl1 IN EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ROW EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ROW EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ROW SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE MODE;
LOCK TABLE lock_tbl1 IN SHARE ROW EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE UPDATE EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE UPDATE EXCLUSIVE MODE;
LOCK TABLE lock_view7 IN EXCLUSIVE MODE;
LOCK TABLE ONLY lock_tbl1;
MOVE BACKWARD ALL IN xc;
NOTIFY notify_async2;
PREPARE p1 AS SELECT * FROM my_property_normal WHERE f_leak(passwd);
PREPARE p1(int) AS SELECT * FROM t1 WHERE a <= $1;
REASSIGN OWNED BY SESSION_USER TO CURRENT_USER;
REFRESH MATERIALIZED VIEW public.mv1 WITH DATA;
REINDEX TABLE public.t1;
RELEASE SAVEPOINT p1;
release savepoint s;
RESET client_min_messages;
ROLLBACK TO s1;
rollback to savepoint s;
rollback;
SAVEPOINT s1;
savepoint s;
SECURITY LABEL FOR 'dummy' ON ROLE regress_seclabel_user1 IS 'classified';      -- fail
SECURITY LABEL FOR 'dummy' ON TABLE seclabel_tbl1 IS 'classified';      -- fail
SECURITY LABEL ON ROLE regress_seclabel_user1 IS '...invalid label...';     -- fail
SECURITY LABEL ON ROLE regress_seclabel_user1 IS 'classified';          -- fail
SECURITY LABEL ON ROLE regress_seclabel_user3 IS 'unclassified';            -- fail
SECURITY LABEL ON TABLE seclabel_tbl1 IS '...invalid label...';     -- fail
SECURITY LABEL ON TABLE seclabel_tbl1 IS 'classified';          -- fail
SECURITY LABEL ON TABLE seclabel_tbl3 IS 'unclassified';            -- fail
SET client_min_messages TO 'warning';
SHOW ALL;
SHOW SESSION AUTHORIZATION;
SHOW session_preload_libraries;
SHOW TIME ZONE;
SHOW track_counts;
SHOW TRANSACTION ISOLATION LEVEL;
START TRANSACTION READ ONLY;
TRUNCATE ONLY trunc_fb, trunc_fa;
TRUNCATE TABLE ndistinct;
TRUNCATE TABLE trunc_c,trunc_d,trunc_e,truncate_a,trunc_b;  -- ok
TRUNCATE TABLE truncate_a CASCADE;  -- ok
TRUNCATE TABLE truncate_a RESTRICT; -- fail
TRUNCATE truncate_a;
TRUNCATE truncate_b RESTART IDENTITY;
UNLISTEN *;
UNLISTEN notify_async2;
VACUUM (ANALYZE, FULL) vactst;
VACUUM (DISABLE_PAGE_SKIPPING) vaccluster;
VACUUM (FREEZE 'true', ANALYZE on, DISABLE_PAGE_SKIPPING 0, SKIP_LOCKED 1, INDEX_CLEANUP 'off', TRUNCATE false, PARALLEL 4);
VACUUM (FREEZE) does_not_exist, vaccluster;
VACUUM (FREEZE, VERBOSE, ANALYZE, DISABLE_PAGE_SKIPPING, SKIP_LOCKED, INDEX_CLEANUP, TRUNCATE, PARALLEL 4);
VACUUM (FULL 1, FREEZE 0, VERBOSE true, ANALYZE false, DISABLE_PAGE_SKIPPING on, SKIP_LOCKED off, INDEX_CLEANUP true, TRUNCATE off) vaccluster;
VACUUM (FULL) vacparted;
VACUUM (FULL, FREEZE) vactst;
VACUUM ANALYZE vacparted(a,b,a);
vacuum btree_tall_tbl;
VACUUM FULL FREEZE VERBOSE ANALYZE vaccluster;
VACUUM FULL vactst, vacparted (a, b), vaccluster (i);
VACUUM FULL vactst;
VACUUM;
/* a /* b /* c */ d /* e */ f */ g /* h */ i */ -- nested comments