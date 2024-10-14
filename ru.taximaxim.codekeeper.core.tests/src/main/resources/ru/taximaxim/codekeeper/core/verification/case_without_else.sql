CREATE OR REPLACE FUNCTION public.case_else() RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
  case _select.c_level
    when 0 then
      SELECT *;
  end case;
end;
$$;