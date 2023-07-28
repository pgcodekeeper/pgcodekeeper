SET search_path = pg_catalog;

DROP SERVER test_server_3;

CREATE TABLE public.rrr (
	idd bigint
);

ALTER TABLE ONLY public.table5
	ALTER COLUMN id DROP NOT NULL;

DROP FUNCTION public.f1(a text, b text, VARIADIC c text[]);

ALTER TABLE public.table5
	DROP CONSTRAINT table5e_pkey;

DROP VIEW IF EXISTS public.test_view3;

CREATE VIEW public.test_view3 AS
	SELECT 2 AS column1;

DROP VIEW public.test_view;

DROP TRIGGER name ON public.table2;

DROP RULE name ON public.table3;

CREATE SERVER test_server_3 FOREIGN DATA WRAPPER test_fdw11;

ALTER SERVER test_server_3 OWNER TO khazieva_gr;

CREATE OR REPLACE FUNCTION public.f1(a text = NULL::text, c text = NULL::text[], VARIADIC c text[] = NULL::text[]) RETURNS text
    LANGUAGE plpgsql
    AS $$
begin
end;
$$;

ALTER FUNCTION public.f1(a text, c text, VARIADIC c text[]) OWNER TO khazieva_gr;

ALTER TABLE public.table5
	ADD CONSTRAINT table5e_pkey PRIMARY KEY (id2);

CREATE VIEW public.test_view AS
	SELECT 1 AS column1;

CREATE TRIGGER name
	BEFORE UPDATE ON public.table2
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.fun3();

CREATE RULE name AS
    ON UPDATE TO public.table3 DO  NOTIFY table3;
