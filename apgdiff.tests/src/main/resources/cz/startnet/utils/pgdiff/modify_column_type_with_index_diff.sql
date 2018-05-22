SET search_path = public, pg_catalog;

-- DEPCY: This INDEX depends on the COLUMN: mytable.col111

DROP INDEX col222_idx;

ALTER TABLE mytable
	ALTER COLUMN col111 TYPE numeric USING col111::numeric; /* TYPE change - table: mytable original: integer new: numeric */

-- DEPCY: This INDEX depends on the COLUMN: mytable2.col222

DROP INDEX col222_idx_2;

ALTER TABLE mytable2
	ALTER COLUMN col222 TYPE numeric USING col222::numeric; /* TYPE change - table: mytable2 original: integer new: numeric */

CREATE UNIQUE INDEX col222_idx ON mytable USING btree (col222) WHERE (col111 > 100);

CREATE UNIQUE INDEX col222_idx_2 ON mytable2 USING btree (col222) WHERE (col111 > 100);
