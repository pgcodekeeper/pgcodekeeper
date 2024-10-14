CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$ begin select 1; end; $_$;

CREATE OR REPLACE FUNCTION public.f2() RETURNS integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $fff$
begin
  select 1;
end;
$fff$;