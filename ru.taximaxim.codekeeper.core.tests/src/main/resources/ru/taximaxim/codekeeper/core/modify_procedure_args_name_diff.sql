SET search_path = pg_catalog;

DROP PROCEDURE public.get_user3(p_id_usder character, test integer);

CREATE OR REPLACE PROCEDURE public.get_user3(new_name character, test integer)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user3(new_name character, test integer) OWNER TO "SA";