SET search_path = pg_catalog;

REVOKE ALL ON SCHEMA test_schema FROM maindb;

-- SCHEMA test_schema GRANT

GRANT ALL ON SCHEMA test_schema TO fordfrog;

REVOKE ALL ON TYPE public.typ_composite FROM maindb;

-- TYPE public.typ_composite GRANT

GRANT ALL ON TYPE public.typ_composite TO fordfrog;

REVOKE ALL ON TYPE public.dom FROM maindb;

-- DOMAIN public.dom GRANT

GRANT ALL ON TYPE public.dom TO fordfrog;

REVOKE ALL ON SEQUENCE public.test_id_seq FROM maindb;

-- SEQUENCE public.test_id_seq GRANT

GRANT ALL ON SEQUENCE public.test_id_seq TO fordfrog;

REVOKE ALL ON FUNCTION public.test_fnc(arg character varying) FROM maindb;

-- FUNCTION public.test_fnc(character varying) GRANT

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO fordfrog;

REVOKE ALL ON FUNCTION public.trigger_fnc() FROM maindb CASCADE;

-- FUNCTION public.trigger_fnc() GRANT

GRANT ALL ON FUNCTION public.trigger_fnc() TO fordfrog;

REVOKE ALL ON TABLE public.test FROM maindb;

-- TABLE public.test GRANT

GRANT ALL ON TABLE public.test TO fordfrog;

REVOKE ALL(id) ON TABLE public.test FROM maindb;

-- COLUMN public.test.id GRANT

GRANT ALL(id) ON TABLE public.test TO fordfrog;

REVOKE ALL ON TABLE public.test_view FROM maindb;

-- VIEW public.test_view GRANT

GRANT ALL ON TABLE public.test_view TO fordfrog;