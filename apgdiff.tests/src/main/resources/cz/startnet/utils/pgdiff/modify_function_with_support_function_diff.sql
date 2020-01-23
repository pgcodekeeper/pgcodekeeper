SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.f_sp(s text) RETURNS text
    LANGUAGE plpgsql SUPPORT tester.my_support2
    AS $$begin return 'textttt'; end;$$;

CREATE OR REPLACE FUNCTION public.f_sp_2(s text) RETURNS text
    LANGUAGE plpgsql SUPPORT public.my_support
    AS $$begin return 'textttt'; end;$$;
