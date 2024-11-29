SET search_path = pg_catalog;

REVOKE ALL ON SCHEMA test_schema FROM maindb;

REVOKE ALL ON SCHEMA test_schema FROM PUBLIC;

REVOKE ALL ON SCHEMA test_schema FROM botov_av;

GRANT ALL ON SCHEMA test_schema TO botov_av;

GRANT ALL ON SCHEMA test_schema TO fordfrog;

REVOKE ALL ON TYPE public.typ_composite FROM maindb;

GRANT ALL ON TYPE public.typ_composite TO PUBLIC;

REVOKE ALL ON TYPE public.typ_composite FROM botov_av;

GRANT ALL ON TYPE public.typ_composite TO botov_av;

GRANT ALL ON TYPE public.typ_composite TO fordfrog;

REVOKE ALL ON TYPE public.dom FROM maindb;

GRANT ALL ON DOMAIN public.dom TO PUBLIC;

REVOKE ALL ON DOMAIN public.dom FROM botov_av;

GRANT ALL ON DOMAIN public.dom TO botov_av;

GRANT ALL ON TYPE public.dom TO fordfrog;

REVOKE ALL ON SEQUENCE public.test_id_seq FROM maindb;

REVOKE ALL ON SEQUENCE public.test_id_seq FROM PUBLIC;

REVOKE ALL ON SEQUENCE public.test_id_seq FROM botov_av;

GRANT ALL ON SEQUENCE public.test_id_seq TO botov_av;

GRANT ALL ON SEQUENCE public.test_id_seq TO fordfrog;

REVOKE ALL ON TABLE public.test FROM maindb;

REVOKE ALL ON TABLE public.test FROM PUBLIC;

REVOKE ALL ON TABLE public.test FROM botov_av;

GRANT ALL ON TABLE public.test TO botov_av;

GRANT ALL ON TABLE public.test TO fordfrog;

REVOKE ALL(id) ON TABLE public.test FROM maindb;

GRANT ALL(id) ON TABLE public.test TO fordfrog;

REVOKE ALL ON FUNCTION public.test_fnc(arg character varying) FROM maindb;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO PUBLIC;

REVOKE ALL ON FUNCTION public.test_fnc(arg character varying) FROM botov_av;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO botov_av;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO fordfrog;

REVOKE ALL ON FUNCTION public.trigger_fnc() FROM maindb CASCADE;

GRANT ALL ON FUNCTION public.trigger_fnc() TO PUBLIC;

REVOKE ALL ON FUNCTION public.trigger_fnc() FROM botov_av;

GRANT ALL ON FUNCTION public.trigger_fnc() TO botov_av;

GRANT ALL ON FUNCTION public.trigger_fnc() TO fordfrog;

REVOKE ALL ON TABLE public.test_view FROM maindb;

REVOKE ALL ON TABLE public.test_view FROM PUBLIC;

REVOKE ALL ON TABLE public.test_view FROM botov_av;

GRANT ALL ON TABLE public.test_view TO botov_av;

GRANT ALL ON TABLE public.test_view TO fordfrog;