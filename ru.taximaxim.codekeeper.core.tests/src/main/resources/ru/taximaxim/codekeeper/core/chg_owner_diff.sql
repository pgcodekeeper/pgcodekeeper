SET search_path = pg_catalog;

ALTER SCHEMA test_schema OWNER TO fordfrog;

ALTER TYPE public.typ_composite OWNER TO fordfrog;

ALTER DOMAIN public.dom OWNER TO fordfrog;

ALTER SEQUENCE public.test_id_seq OWNER TO fordfrog;

ALTER TABLE public.test OWNER TO fordfrog;

ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO fordfrog;

ALTER FUNCTION public.trigger_fnc() OWNER TO fordfrog;

ALTER VIEW public.test_view OWNER TO fordfrog;

ALTER STATISTICS public.s1 OWNER TO fordfrog;