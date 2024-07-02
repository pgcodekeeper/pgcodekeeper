SET search_path = pg_catalog;

COMMENT ON CAST (integer AS bigint) IS NULL;

COMMENT ON EXTENSION test_ext IS NULL;

COMMENT ON EVENT TRIGGER evt1 IS NULL;

COMMENT ON FOREIGN DATA WRAPPER test_fdw_1 IS NULL;

COMMENT ON SERVER test_server_0 IS NULL;

COMMENT ON COLLATION public.test_collation IS NULL;

COMMENT ON TYPE public.typ_composite IS NULL;

COMMENT ON COLUMN public.typ_composite.key IS NULL;

COMMENT ON COLUMN public.typ_composite.val IS NULL;

COMMENT ON DOMAIN public.dom IS NULL;

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS NULL;

COMMENT ON SEQUENCE public.test_id_seq IS NULL;

COMMENT ON TEXT SEARCH PARSER public.test_parser IS NULL;

COMMENT ON TEXT SEARCH TEMPLATE public.test_template IS NULL;

COMMENT ON TEXT SEARCH DICTIONARY public.test_dictionary IS NULL;

COMMENT ON TEXT SEARCH CONFIGURATION public.test_config IS NULL;

COMMENT ON FOREIGN TABLE public.test_ft IS NULL;

COMMENT ON TABLE public.test IS NULL;

COMMENT ON COLUMN public.test.id IS NULL;

COMMENT ON COLUMN public.test.text IS NULL;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS NULL;

COMMENT ON PROCEDURE public.test_proc(arg integer) IS NULL;

COMMENT ON INDEX public.test_index IS NULL;

COMMENT ON CONSTRAINT text_check ON public.test IS NULL;

COMMENT ON CONSTRAINT test_pkey ON public.test IS NULL;

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS NULL;

COMMENT ON VIEW public.test_view IS NULL;

COMMENT ON COLUMN public.test_view.id IS NULL;

COMMENT ON STATISTICS public.s1 IS NULL;

COMMENT ON TRIGGER test_trigger ON public.test IS NULL;

COMMENT ON RULE test_rule ON public.test IS NULL;

COMMENT ON POLICY test_policy ON public.test IS NULL;