SET search_path = public, pg_catalog;

-- DEPCY: This TRIGGER depends on the COLUMN: accounts.number

DROP TRIGGER log_update ON accounts;

ALTER TABLE accounts
	ALTER COLUMN number TYPE numeric USING number::numeric; /* TYPE change - table: accounts original: integer new: numeric */

CREATE TRIGGER log_update
	AFTER UPDATE ON accounts
	FOR EACH ROW
	WHEN ((old.number IS DISTINCT FROM new.number))
	EXECUTE PROCEDURE log_account_update();
