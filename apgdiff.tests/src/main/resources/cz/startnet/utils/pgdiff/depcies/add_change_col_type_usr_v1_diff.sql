DROP VIEW v1;

ALTER TABLE t2
	ALTER COLUMN c2 TYPE text USING c2::text; /* TYPE change - table: t2 original: integer new: text */

ALTER TABLE t1
	ALTER COLUMN c1 TYPE text USING c1::text; /* TYPE change - table: t1 original: integer new: text */

CREATE VIEW v1 AS
	SELECT t1.c1,
    t2.c2,
    'asdad' AS text
   FROM t1,
    t2;

ALTER VIEW v1 OWNER TO botov_av;

COMMENT ON VIEW v1 IS 'asdsada';
