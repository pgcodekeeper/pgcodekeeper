SET search_path = pg_catalog;

-- DEPCY: This FUNCTION test_function is a dependency of CONSTRAINT: public.test_table.test_constraint

CREATE OR REPLACE FUNCTION public.test_function() RETURNS tsrange
    LANGUAGE sql IMMUTABLE
    AS $$ SELECT '[2010-01-01 14:30, 2010-01-01 15:30)'::tsrange $$;

ALTER TABLE public.test_table
	ADD CONSTRAINT test_constraint EXCLUDE USING gist (public.test_function() WITH &&)
	USING INDEX TABLESPACE test_tablespace WHERE ((c1 <> 0)) DEFERRABLE INITIALLY DEFERRED;