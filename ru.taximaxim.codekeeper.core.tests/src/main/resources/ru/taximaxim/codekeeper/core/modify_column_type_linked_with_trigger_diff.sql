SET search_path = pg_catalog;

-- DEPCY: This TRIGGER log_update depends on the COLUMN: public.accounts.number

DROP TRIGGER log_update ON public.accounts;

ALTER TABLE public.accounts
	ALTER COLUMN number TYPE numeric USING number::numeric; /* TYPE change - table: public.accounts original: integer new: numeric */

CREATE TRIGGER log_update
	AFTER UPDATE ON public.accounts
	FOR EACH ROW
	WHEN ((old.number IS DISTINCT FROM new.number))
	EXECUTE PROCEDURE public.log_account_update();