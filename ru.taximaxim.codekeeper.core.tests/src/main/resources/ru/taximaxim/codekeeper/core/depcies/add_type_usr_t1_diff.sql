SET search_path = pg_catalog;

-- DEPCY: This FUNCTION t1_subtype_diff is a dependency of TYPE: public.t1

CREATE OR REPLACE FUNCTION public.t1_subtype_diff(_x date, _y date) RETURNS double precision
    LANGUAGE sql IMMUTABLE STRICT
    AS $$SELECT _x - _y$$;

CREATE TYPE public.t1 AS RANGE (
	subtype = date,
	subtype_diff = public.t1_subtype_diff,
	multirange_type_name = public.t1_multirange
);