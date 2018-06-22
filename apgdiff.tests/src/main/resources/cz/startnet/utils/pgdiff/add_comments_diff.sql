SET search_path = pg_catalog;

COMMENT ON DATABASE current_database() IS 'comments database';

COMMENT ON COLUMN public.typ_composite.key IS 'Type composite key comment';

COMMENT ON COLUMN public.typ_composite.val IS 'Type composite val comment';

COMMENT ON TYPE public.typ_composite IS 'test type';

COMMENT ON DOMAIN public.dom IS 'test domain';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

COMMENT ON TABLE public.test IS 'test table';

COMMENT ON COLUMN public.test.id IS 'id column';

COMMENT ON COLUMN public.test.text IS 'text column';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key';

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

COMMENT ON RULE test_rule ON public.test IS 'test rule';