CREATE TABLE public.t1 (
    c1 integer,
    c2 character varying(40),
    c3 text
);


-- Test group I
-- default value of access method specified
CREATE MATERIALIZED VIEW public.v1 
    USING heap AS 
    SELECT c1 as vc1, c2 as vc2, c3 as vc3
    FROM public.t1;


-- Test group II
-- default value of access method not specified
CREATE MATERIALIZED VIEW public.v2 AS 
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v3 AS 
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;

CREATE MATERIALIZED VIEW public.v4 AS 
    SELECT c1 as vc1, c2 as vc2
    FROM public.t1;


-- Test group III
-- default value of access method specified in SET
SET default_table_access_method = heap;

CREATE MATERIALIZED VIEW public.v5 AS 
    SELECT c1 as vc1
    FROM public.t1;