DELETE FROM delete_test AS dt WHERE dt.a > 75;
DELETE FROM delete_test dt WHERE delete_test.a > 25;
DELETE FROM r1 USING r2 WHERE r1.a = r2.a + 2 RETURNING *;
DELETE FROM delete_test WHERE a > 25;
DELETE FROM r2 RETURNING *;
delete from gin_test_tbl where i @> array[2];
delete from gist_point_tbl where id % 2 = 1;
delete from gist_point_tbl where id < 10000;