CREATE SCHEMA tester;

CREATE FUNCTION public.my_support(internal) RETURNS internal
    LANGUAGE internal STRICT PARALLEL SAFE
    AS $$heap_tableam_handler$$;

CREATE FUNCTION tester.my_support2(internal) RETURNS internal
    LANGUAGE internal STRICT PARALLEL SAFE
    AS $$heap_tableam_handler$$;