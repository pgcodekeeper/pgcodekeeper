SET search_path = pg_catalog;

-- DEPCY: This TRIGGER trig1 depends on the COLUMN: public.t1.c2

DROP TRIGGER trig1 ON public.t1;

ALTER TABLE public.t1
	ALTER COLUMN c2 TYPE bigint USING c2::bigint; /* TYPE change - table: public.t1 original: integer new: bigint */

CREATE TRIGGER trig1
	AFTER UPDATE OF c1, c2 ON public.t1
	FOR EACH ROW
	EXECUTE PROCEDURE public.incr();