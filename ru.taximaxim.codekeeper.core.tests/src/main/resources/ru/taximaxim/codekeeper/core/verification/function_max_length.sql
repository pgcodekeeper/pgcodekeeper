 CREATE OR REPLACE FUNCTION public.f5() RETURNS void
    LANGUAGE plpgsql
    AS $$
    BEGIN
    if (count_worker = 0) then
      if (count_worker = 0) then
        if (count_worker = 0) then
          _test_worker = 0;
        elseif (_count_worker > 0) then
          _test_worker = 1;
        elseif (_id_worker = 2) then
          _test_worker = 2;
        else
          _test_worker = 3;
        end if;
      end if;
    end if;
END$$;