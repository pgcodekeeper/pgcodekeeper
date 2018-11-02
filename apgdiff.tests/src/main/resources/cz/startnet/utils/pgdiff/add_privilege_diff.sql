SET search_path = pg_catalog;

-- SCHEMA test_schema GRANT

GRANT ALL ON SCHEMA test_schema TO maindb;

-- TYPE public.typ_composite GRANT

GRANT ALL ON TYPE public.typ_composite TO PUBLIC;
GRANT ALL ON TYPE public.typ_composite TO maindb;

-- DOMAIN public.dom GRANT

GRANT ALL ON TYPE public.dom TO PUBLIC;
GRANT ALL ON TYPE public.dom TO maindb;

-- SEQUENCE public.test_id_seq GRANT

GRANT ALL ON SEQUENCE public.test_id_seq TO maindb;

-- FUNCTION public.test_fnc(character varying) GRANT

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO PUBLIC;
GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO maindb;

-- FUNCTION public.trigger_fnc() GRANT

GRANT ALL ON FUNCTION public.trigger_fnc() TO PUBLIC;
GRANT ALL ON FUNCTION public.trigger_fnc() TO maindb;

-- TABLE public.test GRANT

GRANT ALL ON TABLE public.test TO maindb;

-- COLUMN public.test.id GRANT

REVOKE ALL(id) ON TABLE public.test FROM botov_av;
GRANT ALL(id) ON TABLE public.test TO maindb;

-- VIEW public.test_view GRANT

GRANT ALL ON TABLE public.test_view TO maindb;