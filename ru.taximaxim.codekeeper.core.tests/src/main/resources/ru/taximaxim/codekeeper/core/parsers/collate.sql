SELECT * FROM collate_test1 WHERE b COLLATE "C" >= 'bbc';
SELECT * FROM collate_test1 WHERE b >= 'bbc' COLLATE "C";
SELECT * FROM collate_test1 WHERE b COLLATE "C" >= 'bbc' COLLATE "C";
SELECT * FROM collate_test1 WHERE b COLLATE "C" >= 'bbc' COLLATE "en-x-icu";
CREATE DOMAIN testdomain_sv AS text COLLATE "sv-x-icu";
CREATE DOMAIN testdomain_i AS int COLLATE "sv-x-icu"; -- fails
SELECT a, b FROM collate_test1 ORDER BY b COLLATE "C";
SELECT * FROM collate_test3 ORDER BY b;
SELECT 'bbc' COLLATE "en-x-icu" > 'äbc' COLLATE "en-x-icu" AS "true";
SELECT 'bbc' COLLATE "sv-x-icu" > 'äbc' COLLATE "sv-x-icu" AS "false";
SELECT a, lower(x COLLATE "C"), lower(y COLLATE "C") FROM collate_test10;
SELECT 'Türkiye' COLLATE "en-x-icu" ILIKE '%KI%' AS "true";
SELECT 'Türkiye' COLLATE "tr-x-icu" ILIKE '%KI%' AS "false";
SELECT 'bıt' ILIKE 'BIT' COLLATE "en-x-icu" AS "false";
SELECT 'bıt' ILIKE 'BIT' COLLATE "tr-x-icu" AS "true";
SELECT to_char(date '2010-04-01', 'DD TMMON YYYY' COLLATE "tr-x-icu");
CREATE VIEW collview1 AS SELECT * FROM collate_test1 WHERE b COLLATE "C" >= 'bbc';
CREATE VIEW collview2 AS SELECT a, b FROM collate_test1 ORDER BY b COLLATE "C";
CREATE VIEW collview3 AS SELECT a, lower((x || x) COLLATE "C") FROM collate_test10;
CREATE INDEX collate_test1_idx2 ON collate_test1 (b COLLATE "POSIX");
CREATE INDEX collate_test1_idx3 ON collate_test1 ((b COLLATE "POSIX")); -- this is different grammatically
CREATE INDEX collate_test1_idx4 ON collate_test1 (((b||'foo') COLLATE "POSIX"));
CREATE INDEX collate_test1_idx5 ON collate_test1 (a COLLATE "POSIX"); -- fail
CREATE INDEX collate_test1_idx6 ON collate_test1 ((a COLLATE "POSIX")); -- fail
CREATE COLLATION mycoll1 FROM "C";
CREATE COLLATION mycoll2 ( LC_COLLATE = "POSIX", LC_CTYPE = "POSIX" );
CREATE COLLATION mycoll3 FROM "default";  -- intentionally unsupported
DROP COLLATION mycoll1;
DROP COLLATION mycoll2;  -- fail
CREATE COLLATION case_coll (LC_COLLATE = "POSIX", LC_CTYPE = "POSIX");
CREATE COLLATION test3 (provider = icu, lc_collate = 'en_US.utf8'); -- fail, need lc_ctype
CREATE COLLATION testx (provider = icu, locale = 'nonsense'); /* never fails with ICU */  DROP COLLATION testx;
CREATE COLLATION test4 FROM nonsense;
CREATE COLLATION test5 FROM test0;
ALTER COLLATION test1 RENAME TO test11;
ALTER COLLATION test0 RENAME TO test11; -- fail
ALTER COLLATION test1 RENAME TO test22; -- fail
ALTER COLLATION test11 OWNER TO regress_test_role;
ALTER COLLATION test11 OWNER TO nonsense;
ALTER COLLATION test11 SET SCHEMA test_schema;
COMMENT ON COLLATION test0 IS 'US English';
DROP COLLATION test0, test_schema.test11, test5;
DROP COLLATION test0; -- fail
DROP COLLATION IF EXISTS test0;
ALTER COLLATION "en-x-icu" REFRESH VERSION;
CREATE COLLATION test0 FROM "C";
create type textrange_c as range(subtype=text, collation="C");
create type textrange_en_us as range(subtype=text, collation="en-x-icu");
CREATE COLLATION pg_catalog."default" (provider = default, locale = '');
