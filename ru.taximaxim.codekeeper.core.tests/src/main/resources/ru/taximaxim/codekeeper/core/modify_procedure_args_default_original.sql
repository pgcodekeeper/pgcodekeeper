CREATE OR REPLACE PROCEDURE public.get_user1(p_id_usder character, test integer)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user1(p_id_usder character, test integer) OWNER TO "SA";

CREATE OR REPLACE PROCEDURE public.get_user2(p_id_usder character default 'a', test integer default 5)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user2(p_id_usder character, test integer) OWNER TO "SA";