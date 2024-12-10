SET search_path = pg_catalog;

-- DEPCY: This RULE protect_accounts depends on the COLUMN: public.accounts.number

DROP RULE protect_accounts ON public.accounts;

ALTER TABLE public.accounts
	ALTER COLUMN number TYPE numeric USING number::numeric; /* TYPE change - table: public.accounts original: integer new: numeric */

-- DEPCY: This RULE protect_accounts2 depends on the COLUMN: public.accounts2.number2

DROP RULE protect_accounts2 ON public.accounts2;

ALTER TABLE public.accounts2
	ALTER COLUMN number2 TYPE numeric USING number2::numeric; /* TYPE change - table: public.accounts2 original: integer new: numeric */

-- DEPCY: This RULE protect_accounts3 depends on the COLUMN: public.one1.col222222

DROP RULE protect_accounts3 ON public.accounts3;

ALTER TABLE public.one1
	ALTER COLUMN col222222 TYPE text USING col222222::text; /* TYPE change - table: public.one1 original: character varying new: text */

CREATE RULE protect_accounts AS
    ON UPDATE TO public.accounts
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO public.one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts2 AS
    ON UPDATE TO public.accounts2
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO public.one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts3 AS
    ON UPDATE TO public.accounts3
  WHERE (old.number2 = 100) DO INSTEAD  INSERT INTO public.one1 (col222222)  SELECT (new.number + 1);