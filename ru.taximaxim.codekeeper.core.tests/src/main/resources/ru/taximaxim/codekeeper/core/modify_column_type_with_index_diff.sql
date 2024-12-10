SET search_path = pg_catalog;

-- DEPCY: This INDEX col222_idx depends on the COLUMN: public.mytable.col111

DROP INDEX public.col222_idx;

ALTER TABLE public.mytable
	ALTER COLUMN col111 TYPE numeric USING col111::numeric; /* TYPE change - table: public.mytable original: integer new: numeric */

-- DEPCY: This INDEX col222_idx_2 depends on the COLUMN: public.mytable2.col222

DROP INDEX public.col222_idx_2;

ALTER TABLE public.mytable2
	ALTER COLUMN col222 TYPE numeric USING col222::numeric; /* TYPE change - table: public.mytable2 original: integer new: numeric */

CREATE UNIQUE INDEX col222_idx ON public.mytable USING btree (col222)
WHERE (col111 > 100);

CREATE UNIQUE INDEX col222_idx_2 ON public.mytable2 USING btree (col222)
WHERE (col111 > 100);