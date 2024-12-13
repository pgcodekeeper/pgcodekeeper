SET search_path = pg_catalog;

DROP PROCEDURE public.get_user5(p_id_usder character, test integer);

CREATE OR REPLACE PROCEDURE public.get_user5(INOUT p_id_usder character, test integer)
    LANGUAGE plpgsql
    AS $$
begin
end; 
$$;

ALTER PROCEDURE public.get_user5(INOUT p_id_usder character, test integer) OWNER TO "SA";