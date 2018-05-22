SET search_path = public, pg_catalog;

-- DEPCY: This RULE depends on the COLUMN: accounts.number

DROP RULE protect_accounts ON accounts;

ALTER TABLE accounts
	ALTER COLUMN number TYPE numeric USING number::numeric; /* TYPE change - table: accounts original: integer new: numeric */

-- DEPCY: This RULE depends on the COLUMN: accounts2.number2

DROP RULE protect_accounts2 ON accounts2;

ALTER TABLE accounts2
	ALTER COLUMN number2 TYPE numeric USING number2::numeric; /* TYPE change - table: accounts2 original: integer new: numeric */

-- DEPCY: This RULE depends on the COLUMN: one1.col222222

DROP RULE protect_accounts3 ON accounts3;

ALTER TABLE one1
	ALTER COLUMN col222222 TYPE text USING col222222::text; /* TYPE change - table: one1 original: character varying new: text */

CREATE RULE protect_accounts AS
    ON UPDATE TO accounts
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts2 AS
    ON UPDATE TO accounts2
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts3 AS
    ON UPDATE TO accounts3
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO one1 (col222222)  SELECT (new.number + 1);
