CREATE OR REPLACE FUNCTION test.space_after_comma() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin
  if _c1 is not null then
    select c1, c2,
    c3
    into _c1,_c2, _c3
    from test.t1
    where id = _c1;

    perform f1(f1,f2, f3, f4);
  end if;
end;
$$;