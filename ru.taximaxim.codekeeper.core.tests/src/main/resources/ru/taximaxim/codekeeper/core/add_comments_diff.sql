SET search_path = pg_catalog;

COMMENT ON CAST (integer AS bigint) IS 'test cast';

COMMENT ON EXTENSION test_ext IS 'test extension';

COMMENT ON EVENT TRIGGER evt1 IS 'This is event trigger';

COMMENT ON FOREIGN DATA WRAPPER test_fdw_1 IS 'test_comment';

COMMENT ON SERVER srv111 IS 'test_comment';

COMMENT ON COLLATION public.test_collation IS 'ru Ru';

COMMENT ON TYPE public.typ_composite IS 'test type';

COMMENT ON COLUMN public.typ_composite.key IS 'Type composite key comment';

COMMENT ON COLUMN public.typ_composite.val IS 'Type composite val comment';

COMMENT ON DOMAIN public.dom IS 'test domain';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

COMMENT ON TEXT SEARCH PARSER public.test_parser IS 'test_parser';

COMMENT ON TEXT SEARCH TEMPLATE public.test_template IS 'test_template';

COMMENT ON TEXT SEARCH DICTIONARY public.test_dictionary IS 'test_dictionary';

COMMENT ON TEXT SEARCH CONFIGURATION public.test_config IS 'test_config';

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table';

COMMENT ON TABLE public.test IS 'test table';

COMMENT ON COLUMN public.test.id IS 'id column';

COMMENT ON COLUMN public.test.text IS 'text column';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure';

COMMENT ON INDEX public.test_index IS 'test table index';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key';

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view';

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

COMMENT ON STATISTICS public.s1 IS 'test statistics';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

COMMENT ON RULE test_rule ON public.test IS 'test rule';

COMMENT ON POLICY test_policy ON public.test IS 'test policy';