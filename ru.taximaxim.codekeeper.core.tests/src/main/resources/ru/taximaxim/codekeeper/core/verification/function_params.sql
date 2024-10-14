CREATE OR REPLACE FUNCTION public.check_params(
    param1 integer,
    param2 integer,
    param3 text,
    param4 numeric,
    param5 integer,
    param6 integer,
    param7 integer,
    OUT param8 text
)
RETURNS integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
declare
  _locale text := locale;
begin
select 1;
end;
$$;