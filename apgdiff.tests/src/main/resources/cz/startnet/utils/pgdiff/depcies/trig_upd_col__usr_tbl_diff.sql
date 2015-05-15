-- DEPCY: This TRIGGER depends on the COLUMN: t1.c2

DROP TRIGGER trig1 ON t1;

ALTER TABLE t1
	ALTER COLUMN c2 TYPE bigint; /* TYPE change - table: t1 original: integer new: bigint */

CREATE TRIGGER trig1
	AFTER UPDATE OF c1, c2 ON t1
	FOR EACH ROW
	EXECUTE PROCEDURE incr();