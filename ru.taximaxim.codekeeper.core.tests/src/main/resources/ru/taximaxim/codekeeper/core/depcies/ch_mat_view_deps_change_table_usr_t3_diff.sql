-- DEPCY: This VIEW v2 depends on the COLUMN: default.t3.b

ALTER TABLE default.v2
	MODIFY QUERY SELECT A + B AS col1, C AS col2 FROM(SELECT t11.c AS A, t12.c AS B, t13.c AS C FROM default.t1_2 AS t11 INNER JOIN default.t2 AS t12 ON t12.d = t11.d INNER JOIN default.t3 AS t13 ON t13.d = t12.d);

ALTER TABLE default.t3
	DROP COLUMN `b`;