CREATE OR REPLACE FUNCTION test.f() RETURNS integer
    LANGUAGE sql SECURITY DEFINER
    AS $$
    
    select 1
   

$$;