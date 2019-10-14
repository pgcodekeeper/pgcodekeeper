SET search_path = pg_catalog;

COMMENT ON DATABASE current_database() IS NULL;

COMMENT ON COLUMN public.typ_composite.key IS NULL;

COMMENT ON COLUMN public.typ_composite.val IS NULL;

COMMENT ON TYPE public.typ_composite IS NULL;

COMMENT ON DOMAIN public.dom IS NULL;

COMMENT ON SEQUENCE public.test_id_seq IS NULL;

COMMENT ON TEXT SEARCH PARSER public.test_parser IS null;

COMMENT ON TEXT SEARCH TEMPLATE public.test_template IS null;

COMMENT ON TEXT SEARCH DICTIONARY public.test_dictionary IS NULL;

COMMENT ON TEXT SEARCH CONFIGURATION public.test_config IS null;

COMMENT ON TABLE public.test IS NULL;

COMMENT ON COLUMN public.test.id IS NULL;

COMMENT ON COLUMN public.test.text IS NULL;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS NULL;

COMMENT ON CONSTRAINT text_check ON public.test IS NULL;

COMMENT ON CONSTRAINT test_pkey ON public.test IS NULL;

COMMENT ON VIEW public.test_view IS NULL;

COMMENT ON COLUMN public.test_view.id IS NULL;

COMMENT ON INDEX public.test_index IS NULL;

COMMENT ON TRIGGER test_trigger ON public.test IS NULL;

COMMENT ON RULE test_rule ON public.test IS NULL;