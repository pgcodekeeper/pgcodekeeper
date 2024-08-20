CREATE TYPE public.t1 AS RANGE (
	subtype = date,
	subtype_diff = public.t1_subtype_diff,
	multirange_type_name = public.t1_multirange
);