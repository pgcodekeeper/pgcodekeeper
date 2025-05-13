SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f2 depends on the FUNCTION: tester.f1(text)

DROP FUNCTION public.f2(j text);

DROP FUNCTION tester.f1(j text);

CREATE OR REPLACE FUNCTION tester.f1(k text) RETURNS text
    LANGUAGE sql
    AS $$ SELECT 'oldtext'::text; $$;

ALTER FUNCTION tester.f1(k text) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION public.f2(j text) RETURNS text
    LANGUAGE sql
    AS $$ select tester.f1('newtext'::text); $$;

ALTER FUNCTION public.f2(j text) OWNER TO shamsutdinov_lr;