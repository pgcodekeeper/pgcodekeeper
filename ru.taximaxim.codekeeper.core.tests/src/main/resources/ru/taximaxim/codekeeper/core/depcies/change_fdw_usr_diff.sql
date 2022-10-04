SET search_path = pg_catalog;

-- DEPCY: This FUNCTION is a dependency of TABLE: public.test_ft

CREATE OR REPLACE FUNCTION public.fdw_test_validator(text[], oid) RETURNS void
    LANGUAGE plpgsql
    AS $$ begin return; end; $$;

ALTER FUNCTION public.fdw_test_validator(text[], oid) OWNER TO khazieva_gr;

-- DEPCY: This FUNCTION is a dependency of TABLE: public.test_ft

CREATE OR REPLACE FUNCTION public.handler_func() RETURNS fdw_handler
    LANGUAGE c STRICT
    AS null;

ALTER FUNCTION public.handler_func() OWNER TO khazieva_gr;

-- DEPCY: This FOREIGN_DATA_WRAPPER is a dependency of TABLE: public.test_ft

CREATE FOREIGN DATA WRAPPER mywrapper HANDLER public.handler_func VALIDATOR public.fdw_test_validator;

ALTER FOREIGN DATA WRAPPER mywrapper OWNER TO khazieva_gr;

-- DEPCY: This SERVER is a dependency of TABLE: public.test_ft

CREATE SERVER myserver VERSION '9.4' FOREIGN DATA WRAPPER mywrapper;

ALTER SERVER myserver OWNER TO khazieva_gr;

CREATE FOREIGN TABLE public.test_ft (
	c1 integer,
	c2 text
)
SERVER myserver;