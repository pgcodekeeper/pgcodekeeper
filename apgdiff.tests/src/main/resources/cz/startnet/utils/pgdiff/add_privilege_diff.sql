SET search_path = pg_catalog;

GRANT ALL ON SCHEMA test_schema TO maindb;

GRANT ALL ON TYPE public.typ_composite TO maindb;

GRANT ALL ON TYPE public.dom TO maindb;

GRANT ALL ON SEQUENCE public.test_id_seq TO maindb;

GRANT ALL ON TABLE public.test TO maindb;

GRANT ALL(id) ON TABLE public.test TO maindb;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO maindb;

GRANT ALL ON FUNCTION public.trigger_fnc() TO maindb;

GRANT ALL ON TABLE public.test_view TO maindb;