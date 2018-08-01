SET search_path = pg_catalog;

COMMENT ON DATABASE current_database() IS 'comments database 2';

COMMENT ON COLUMN public.typ_composite.key IS 'Type column of composite comment 2';

COMMENT ON TYPE public.typ_composite IS 'This composite type 2';

COMMENT ON DOMAIN public.dom IS 'Domain comment 2';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence 2';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function 2';

COMMENT ON TABLE public.test IS 'test table 2';

COMMENT ON COLUMN public.test.id IS 'id column 2';

COMMENT ON COLUMN public.test.text IS 'text column 2';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check 2';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key 2';

COMMENT ON VIEW public.test_view IS 'test view 2';

COMMENT ON COLUMN public.test_view.id IS 'view id col 2';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger 2';