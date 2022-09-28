CREATE TABLE public.t1 (
    c1 integer,
    c2 character varying(40),
    c3 text
);

CREATE OR REPLACE FUNCTION public.my_method(internal) RETURNS table_am_handler
    LANGUAGE internal STRICT PARALLEL SAFE
    AS $$heap_tableam_handler$$;

CREATE ACCESS METHOD my_method TYPE TABLE HANDLER public.my_method;


-- Test group I
CREATE MATERIALIZED VIEW public.v1 
    USING my_method AS 
    SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v2 
    USING heap AS 
    SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v3 AS 
    SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1;


-- Test group II
CREATE MATERIALIZED VIEW public.v4
    USING my_method AS
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v5
    USING heap AS
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v6 AS 
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;


-- Test group III
SET default_table_access_method = my_method;

CREATE MATERIALIZED VIEW public.v7 AS 
    SELECT c1 as vc1
    FROM public.t1;