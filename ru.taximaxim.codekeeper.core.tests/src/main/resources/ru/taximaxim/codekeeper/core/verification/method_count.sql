CREATE OR REPLACE FUNCTION public.check_params(param1 integer) RETURNS integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin
  RETURN 1 + 2;

  if (w = 0) then
    select 1;
  end if;

  case c1
  when '1' then
    return query
      select test.f1(c1, c2);
  when '2' then
    return query
      select test.f2(c1, c2);
  when '3' then
    return query
      select test.f3(c1, c2);
  when '4 district' then
    return query
      select test.f4(c1, c2);
  when '5' then
    return query
      select test.f5(c1, c2);
  else
    raise exception '%', f1('t1', q);
  end case;

  FOR r IN
    SELECT * FROM foo WHERE fooid > 0
  LOOP
    RETURN NEXT r;
  END LOOP;
  RETURN;

  IF number = 0 THEN
    result := 'zero';
  ELSIF number > 0 THEN
    result := 'positive';
  ELSIF number < 0 THEN
    result := 'negative';
  ELSE
    result := 'NULL';
  END IF;

  BEGIN
    UPDATE mytab SET firstname = 'Joe' WHERE lastname = 'Jones';
    x := x + 1;
    y := x / 0;
  EXCEPTION
    WHEN division_by_zero THEN
      RAISE NOTICE 'caught division_by_zero';
      RETURN x;
  END;
end;
$$;