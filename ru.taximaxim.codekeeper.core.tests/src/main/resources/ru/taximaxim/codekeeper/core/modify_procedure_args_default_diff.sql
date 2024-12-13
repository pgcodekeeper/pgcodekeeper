SET search_path = pg_catalog;

DROP PROCEDURE public.get_user2(p_id_usder character, test integer);

CREATE OR REPLACE PROCEDURE public.get_user_test2(p_id_usder character, test integer)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user_test2(p_id_usder character, test integer) OWNER TO "SA";

CREATE OR REPLACE PROCEDURE public.get_user1(p_id_usder character = 'a', test integer = 5)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;