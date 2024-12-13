CREATE OR REPLACE PROCEDURE public.get_user3(new_name character, test integer)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user3(new_name character, test integer) OWNER TO "SA";