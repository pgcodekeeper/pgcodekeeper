-- for VIEW
CREATE VIEW public.v1 AS
    SELECT c1, c2, c3
   FROM public.t_test;

--change
COMMENT ON COLUMN public.v1.c1 IS 'view column comment change';
--add
COMMENT ON COLUMN public.v1.c2 IS 'view column comment add';

-- for DOMAIN
CREATE DOMAIN public.d1 AS integer NOT NULL DEFAULT '-1'::integer
    CONSTRAINT d1_check1 CHECK ((VALUE <> 0))
    CONSTRAINT d1_check2 CHECK ((VALUE <> -1))
    CONSTRAINT d1_check3 CHECK ((VALUE <> 6));

--change
COMMENT ON CONSTRAINT d1_check1 ON DOMAIN public.d1 IS 'CONSTRAINT change';
--add
COMMENT ON CONSTRAINT d1_check2 ON DOMAIN public.d1 IS 'CONSTRAINT comment add';

-- for TABLE
CREATE TABLE public.t1 (
    c1 text,
    c2 text,
    c3 text
);

--change
COMMENT ON COLUMN public.t1.c1 IS 'table column comment change';
--add
COMMENT ON COLUMN public.t1.c2 IS 'table column comment add';

-- for TABLE
CREATE TYPE public.ct1 AS (
    c1 text,
    c2 text,
    c3 text
);

--change
COMMENT ON COLUMN public.ct1.c1 IS 'type column comment change';
--add
COMMENT ON COLUMN public.ct1.c2 IS 'type column comment add';