CREATE OR REPLACE FUNCTION public.check_privil(id bigint, idtype text) RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
declare
  _locale text := context_variables.getcurrentlocale();
begin
select 1;
end;
$$;

ALTER FUNCTION public.check_privil(id bigint, idtype text) OWNER TO user_1;

REVOKE ALL ON FUNCTION public.check_privil(id bigint, idtype text) FROM PUBLIC;
GRANT ALL ON FUNCTION public.check_privil(id bigint, idtype text) TO PUBLIC;