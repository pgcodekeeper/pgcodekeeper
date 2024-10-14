CREATE OR REPLACE FUNCTION public.f() RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN
  case _select.c_level when 0 then
    perform f1(_id, _level);  when 1 then
    perform f1(_id, _level);
  when 2 then
    perform f1(_id, _level);
  when 3,4,5 then
    perform f1(_id, _level);
  when 6,7 then
    perform f1(_id, _level);
  end case;

END;
$$;