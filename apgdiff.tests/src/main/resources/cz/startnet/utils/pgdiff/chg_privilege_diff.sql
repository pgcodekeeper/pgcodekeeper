SET search_path = pg_catalog;

REVOKE ALL ON SCHEMA test_schema FROM maindb;

GRANT ALL ON SCHEMA test_schema TO fordfrog;

REVOKE ALL ON TYPE public.typ_composite FROM maindb;

GRANT ALL ON TYPE public.typ_composite TO fordfrog;

REVOKE ALL ON TYPE public.dom FROM maindb;

GRANT ALL ON TYPE public.dom TO fordfrog;

REVOKE ALL ON SEQUENCE public.test_id_seq FROM maindb;

GRANT ALL ON SEQUENCE public.test_id_seq TO fordfrog;

REVOKE ALL ON FUNCTION public.test_fnc(arg character varying) FROM maindb;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO fordfrog;

REVOKE ALL ON FUNCTION public.trigger_fnc() FROM maindb CASCADE;

GRANT ALL ON FUNCTION public.trigger_fnc() TO fordfrog;

REVOKE ALL ON TABLE public.test FROM maindb;

GRANT ALL ON TABLE public.test TO fordfrog;

REVOKE ALL(id) ON TABLE public.test FROM maindb;

GRANT ALL(id) ON TABLE public.test TO fordfrog;

REVOKE ALL ON TABLE public.test_view FROM maindb;

GRANT ALL ON TABLE public.test_view TO fordfrog;