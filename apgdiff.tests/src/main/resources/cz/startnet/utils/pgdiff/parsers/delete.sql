DELETE FROM delete_test AS dt WHERE dt.a > 75;
DELETE FROM delete_test dt WHERE delete_test.a > 25;
DELETE FROM r1 USING r2 WHERE r1.a = r2.a + 2 RETURNING *;
DELETE FROM delete_test WHERE a > 25;
DELETE FROM r2 RETURNING *;