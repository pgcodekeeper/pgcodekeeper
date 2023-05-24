CREATE OR REPLACE FUNCTION public.f1(p1 integer[], p2 integer, p3 uuid[] = NULL::uuid[], p4 timestamp with time zone = NULL::timestamp with time zone, p5 timestamp with time zone = NULL::timestamp with time zone, p6 smallint[] = NULL::smallint[], p7 integer = 100) RETURNS TABLE(c1 uuid, c2 uuid, c3 timestamp with time zone, c4 timestamp with time zone, c5 timestamp with time zone, c6 integer, c7 smallint, c8 smallint, c9 integer, c10 text)
    LANGUAGE plpgsql SECURITY DEFINER PARALLEL SAFE
    AS $$ 
    begin
        return query select null, null, null, null, null, null, null, null, null, null; 
    end;
    $$;