CREATE ACCESS METHOD gist2 TYPE INDEX HANDLER gisthandler;
DROP ACCESS METHOD gist2;
CREATE LANGUAGE alt_lang1 HANDLER plpgsql_call_handler;
ALTER LANGUAGE alt_lang1 RENAME TO alt_lang2;
ALTER LANGUAGE alt_lang3 OWNER TO user3;
CREATE FOREIGN DATA WRAPPER alt_fdw1;
ALTER FOREIGN DATA WRAPPER alt_fdw1 RENAME TO alt_fdw2;
CREATE SERVER alt_fserv1 FOREIGN DATA WRAPPER alt_fdw1;
ALTER SERVER alt_fserv1 RENAME TO alt_fserv2;
CREATE OPERATOR @-@ ( leftarg = int4, rightarg = int4, procedure = int4mi );
ALTER OPERATOR @+@(int4, int4) OWNER TO regress_alter_generic_user2;
ALTER OPERATOR @-@(int4, int4) SET SCHEMA alt_nsp2;
CREATE OPERATOR CLASS alt_opc1 FOR TYPE uuid USING hash AS STORAGE uuid;
ALTER OPERATOR CLASS alt_opc2 USING hash OWNER TO regress_alter_generic_user1;
ALTER OPERATOR CLASS alt_opc1 USING hash RENAME TO alt_opc2;
ALTER OPERATOR CLASS alt_opc2 USING hash SET SCHEMA alt_nsp2;
CREATE OPERATOR FAMILY alt_opf1 USING hash;
ALTER OPERATOR FAMILY alt_opf1 USING hash RENAME TO alt_opf3;
ALTER OPERATOR FAMILY alt_opf2 USING hash OWNER TO regress_alter_generic_user2;
ALTER OPERATOR FAMILY alt_opf2 USING hash SET SCHEMA alt_nsp2;
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD
  -- int4 vs int2
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);

ALTER OPERATOR FAMILY alt_opf4 USING btree DROP
  -- int4 vs int2
  OPERATOR 1 (int4, int2) ,
  OPERATOR 2 (int4, int2) ,
  OPERATOR 3 (int4, int2) ,
  OPERATOR 4 (int4, int2) ,
  OPERATOR 5 (int4, int2) ,
  FUNCTION 1 (int4, int2) ;

CREATE OPERATOR FAMILY alt_opf4 USING btree;
ALTER OPERATOR FAMILY alt_opf4 USING invalid_index_method ADD  OPERATOR 1 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD OPERATOR 6 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD OPERATOR 0 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD FUNCTION 0 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD FUNCTION 6 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf4 USING btree;
CREATE ROLE regress_alter_generic_user5 NOSUPERUSER;
ALTER OPERATOR FAMILY alt_opf5 USING btree ADD OPERATOR 1 < (int4, int2), FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf5 USING btree;
CREATE ROLE regress_alter_generic_user6;
REVOKE ALL ON SCHEMA alt_nsp6 FROM regress_alter_generic_user6;
CREATE OPERATOR FAMILY alt_nsp6.alt_opf6 USING btree;
ALTER OPERATOR FAMILY alt_nsp6.alt_opf6 USING btree ADD OPERATOR 1 < (int4, int2);
CREATE OPERATOR FAMILY alt_opf7 USING btree;
ALTER OPERATOR FAMILY alt_opf7 USING btree ADD OPERATOR 1 < (int4, int2);
DROP OPERATOR FAMILY alt_opf7 USING btree;
CREATE OPERATOR FAMILY alt_opf8 USING btree;
ALTER OPERATOR FAMILY alt_opf8 USING btree ADD OPERATOR 1 < (int4, int4);
DROP OPERATOR FAMILY alt_opf8 USING btree;
CREATE OPERATOR FAMILY alt_opf9 USING gist;
ALTER OPERATOR FAMILY alt_opf9 USING gist ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
DROP OPERATOR FAMILY alt_opf9 USING gist;
CREATE OPERATOR FAMILY alt_opf10 USING btree;
ALTER OPERATOR FAMILY alt_opf10 USING btree ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
DROP OPERATOR FAMILY alt_opf10 USING btree;
CREATE OPERATOR FAMILY alt_opf11 USING gist;
ALTER OPERATOR FAMILY alt_opf11 USING gist ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
ALTER OPERATOR FAMILY alt_opf11 USING gist DROP OPERATOR 1 (int4, int4);
ALTER OPERATOR FAMILY alt_opf16 USING gist ADD FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf16 USING gist;
CREATE OPERATOR FAMILY alt_opf17 USING btree;
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf17 USING btree;
CREATE OPERATOR FAMILY alt_opf18 USING btree;
ALTER OPERATOR FAMILY alt_opf18 USING btree DROP OPERATOR 1 (int4, int4);
ALTER OPERATOR FAMILY alt_opf18 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf18 USING btree DROP FUNCTION 2 (int4, int4);
DROP OPERATOR FAMILY alt_opf18 USING btree;
CREATE STATISTICS alt_stat1 ON a, b FROM alt_regress_1;
ALTER STATISTICS alt_stat1 RENAME TO alt_stat2;
ALTER STATISTICS alt_stat2 OWNER TO regress_alter_generic_user2;
ALTER STATISTICS alt_stat2 SET SCHEMA alt_nsp2;
CREATE TEXT SEARCH DICTIONARY alt_ts_dict1 (template=simple);
ALTER TEXT SEARCH DICTIONARY alt_ts_dict1 RENAME TO alt_ts_dict2;
ALTER TEXT SEARCH DICTIONARY alt_ts_dict2 OWNER TO user3;
ALTER TEXT SEARCH DICTIONARY alt_ts_dict2 SET SCHEMA s;
CREATE TEXT SEARCH CONFIGURATION alt_ts_conf1 (copy=english);
ALTER TEXT SEARCH CONFIGURATION alt_ts_conf2 SET SCHEMA alt_nsp2;
ALTER TEXT SEARCH CONFIGURATION alt_ts_conf3 RENAME TO alt_ts_conf4;
CREATE TEXT SEARCH TEMPLATE alt_ts_temp2 (lexize=dsimple_lexize);
ALTER TEXT SEARCH TEMPLATE alt_ts_temp1 RENAME TO alt_ts_temp2;
ALTER TEXT SEARCH TEMPLATE alt_ts_temp2 SET SCHEMA alt_nsp2;
CREATE TEXT SEARCH PARSER alt_ts_prs1 (start = prsd_start, gettoken = prsd_nexttoken, end = prsd_end, lextypes = prsd_lextype);
ALTER TEXT SEARCH PARSER alt_ts_prs1 RENAME TO alt_ts_prs3;
ALTER TEXT SEARCH PARSER alt_ts_prs2 SET SCHEMA alt_nsp2;
DROP FOREIGN DATA WRAPPER alt_fdw3 CASCADE;
DROP LANGUAGE alt_lang3 CASCADE;
DROP USER regress_alter_generic_user3;
CREATE OPERATOR CLASS box_ops DEFAULT
    FOR TYPE box USING gist2 AS
    OPERATOR 1  <<,
    OPERATOR 2  &<,
    OPERATOR 3  &&,
    OPERATOR 4  &>,
    OPERATOR 5  >>,
    OPERATOR 6  ~=,
    OPERATOR 7  @>,
    OPERATOR 8  <@,
    OPERATOR 9  &<|,
    OPERATOR 10 <<|,
    OPERATOR 11 |>>,
    OPERATOR 12 |&>,
    OPERATOR 13 ~,
    OPERATOR 14 @,
    FUNCTION 1  gist_box_consistent(internal, box, smallint, oid, internal),
    FUNCTION 2  gist_box_union(internal, internal),
    -- don't need compress, decompress, or fetch functions
    FUNCTION 5  gist_box_penalty(internal, internal, internal),
    FUNCTION 6  gist_box_picksplit(internal, internal),
    FUNCTION 7  gist_box_same(box, box, internal);
NOTIFY notify_async2;
LISTEN notify_async2;
UNLISTEN notify_async2;
UNLISTEN *;
FETCH ABSOLUTE 1 FROM current_check_cursor;
FETCH RELATIVE 1 FROM current_check_cursor;
fetch all in c1;
fetch 1 in c1;
fetch backward 1 in c1;
fetch backward all in c1;
fetch backward 1 in c1;
fetch all in c1;
explain (verbose, costs off, analyze on, timing off, summary off)
explain (costs off)
EXPLAIN (COSTS OFF) SELECT * FROM t1;
ANALYZE onek2;
PREPARE p1(int) AS SELECT * FROM t1 WHERE a <= $1;
EXPLAIN (COSTS OFF) EXECUTE p1(2);
SHOW session_preload_libraries;
LOCK TABLE lock_tbl1 IN ACCESS SHARE MODE;
LOCK lock_tbl1 IN ROW SHARE MODE;
LOCK lock_tbl1 IN SHARE ROW EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ROW EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN SHARE UPDATE EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN SHARE MODE;
LOCK TABLE lock_tbl1 IN EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ACCESS EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 IN ACCESS SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ROW SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ROW EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE UPDATE EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN SHARE ROW EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_tbl1 IN ACCESS EXCLUSIVE MODE NOWAIT;
LOCK TABLE lock_view7 IN EXCLUSIVE MODE;
LOCK TABLE lock_tbl1 * IN ACCESS EXCLUSIVE MODE;
LOCK TABLE ONLY lock_tbl1;
SAVEPOINT s1;
ROLLBACK TO s1;
DECLARE c CURSOR FOR SELECT ctid,cmin,* FROM combocidtest;
FETCH ALL FROM c;
VACUUM ANALYZE vacparted(a,b,a);
ANALYZE vacparted(a,b,b);
VACUUM;
vacuum btree_tall_tbl;
VACUUM FULL vactst;
VACUUM (FULL) vacparted;
VACUUM (FULL, FREEZE) vactst;
VACUUM (ANALYZE, FULL) vactst;
VACUUM FULL vactst;
VACUUM (DISABLE_PAGE_SKIPPING) vaccluster;
VACUUM (FREEZE) does_not_exist, vaccluster;
VACUUM FULL vactst, vacparted (a, b), vaccluster (i);
TRUNCATE TABLE ndistinct;
DROP STATISTICS ab1_a_b_stats;
CREATE STATISTICS regress_schema_2.ab1_a_b_stats ON a, b FROM ab1;
DROP STATISTICS regress_schema_2.ab1_a_b_stats;
CREATE STATISTICS ab1_b_a_stats ON b, a FROM ab1;
CREATE STATISTICS func_deps_stat (dependencies) ON a, b, c FROM functional_dependencies;
RELEASE SAVEPOINT p1;
SHOW track_counts;
DISCARD SEQUENCES;
START TRANSACTION READ ONLY;
SECURITY LABEL ON TABLE seclabel_tbl1 IS 'classified';          -- fail
SECURITY LABEL FOR 'dummy' ON TABLE seclabel_tbl1 IS 'classified';      -- fail
SECURITY LABEL ON TABLE seclabel_tbl1 IS '...invalid label...';     -- fail
SECURITY LABEL ON TABLE seclabel_tbl3 IS 'unclassified';            -- fail
SECURITY LABEL ON ROLE regress_seclabel_user1 IS 'classified';          -- fail
SECURITY LABEL FOR 'dummy' ON ROLE regress_seclabel_user1 IS 'classified';      -- fail
SECURITY LABEL ON ROLE regress_seclabel_user1 IS '...invalid label...';     -- fail
SECURITY LABEL ON ROLE regress_seclabel_user3 IS 'unclassified';            -- fail
PREPARE p1 AS SELECT * FROM my_property_normal WHERE f_leak(passwd);
EXECUTE p2;
begin isolation level repeatable read;
deallocate tenk1_count;