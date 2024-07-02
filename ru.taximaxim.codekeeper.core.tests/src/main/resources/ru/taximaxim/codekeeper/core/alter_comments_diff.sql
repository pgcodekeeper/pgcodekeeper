SET search_path = pg_catalog;

COMMENT ON CAST (integer AS bigint) IS 'test cast 2';

COMMENT ON EXTENSION test_ext IS 'test extension 2';

COMMENT ON EVENT TRIGGER evt1 IS 'altered comment of the event trigger';

COMMENT ON FOREIGN DATA WRAPPER test_fdw_2 IS 'new comment';

COMMENT ON SERVER test_server_0 IS 'new_comment';

COMMENT ON COLLATION public.test_collation IS 'ru Ru';

COMMENT ON TYPE public.typ_composite IS 'This composite type 2';

COMMENT ON COLUMN public.typ_composite.key IS 'Type column of composite comment 2';

COMMENT ON DOMAIN public.dom IS 'Domain comment 2';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint 2';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence 2';

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table 2';

COMMENT ON TABLE public.test IS 'test table 2';

COMMENT ON COLUMN public.test.id IS 'id column 2';

COMMENT ON COLUMN public.test.text IS 'text column 2';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function 2';

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure 2';

COMMENT ON INDEX public.test_index IS 'test table index 2';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check 2';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key 2';

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view 2';

COMMENT ON VIEW public.test_view IS 'test view 2';

COMMENT ON COLUMN public.test_view.id IS 'view id col 2';

COMMENT ON STATISTICS public.s1 IS 'test statistics 2';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger 2';

COMMENT ON RULE test_rule ON public.test IS 'test rule 2';

COMMENT ON POLICY test_policy ON public.test IS 'test policy 2';