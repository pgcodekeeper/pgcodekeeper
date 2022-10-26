DELETE FROM delete_test AS dt WHERE dt.a > 75;
DELETE FROM delete_test dt WHERE delete_test.a > 25;
DELETE FROM r1 USING r2 WHERE r1.a = r2.a + 2 RETURNING *;
DELETE FROM delete_test WHERE a > 25;
DELETE FROM r2 RETURNING *;
delete from gin_test_tbl where i @> array[2];
delete from gist_point_tbl where id % 2 = 1;
delete from gist_point_tbl where id < 10000;
DELETE FROM f WHERE f1 > 2 RETURNING f3, f2, f1, least(f1,f3);
DELETE FROM f WHERE f1 > 1 RETURNING *, f1+1 IN (SELECT q1 FROM t) AS sp, EXISTS(SELECT * FROM t) AS ip;
DELETE FROM f USING tbl i WHERE foo.f1 + 1 = i.f1 RETURNING foo.*, i.f1 as "i.f1";