CREATE OR REPLACE FUNCTION test.space_after_if() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin

  if(c1 = 0) then
    select 1;
  end if;

  if (c2 = 0) then
    select 1;
  end if;

  IF ((NOT (c1 ->> 'c1')::boolean) and (c2 = 'test')) THEN
    RAISE EXCEPTION 'ERROR';
  END IF;
end;
$$;