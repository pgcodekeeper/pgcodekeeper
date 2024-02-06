CREATE OR REPLACE FUNCTION public.nonull_append_strings(text) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $_$ select 1; $_$;

CREATE OPERATOR public.||++ (
    PROCEDURE = public.nonull_append_strings,
	RIGHTARG = text
);

CREATE OR REPLACE FUNCTION public.f_regoper(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||++'::regoper)::text AS text;$$;

---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION public.nonull_append_strings(text, text) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

CREATE OR REPLACE FUNCTION public.nonull_append_strings(integer, text) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

CREATE OPERATOR public.||== (
    PROCEDURE = public.nonull_append_strings,
    LEFTARG = text,
    RIGHTARG = text
);

CREATE OPERATOR public.||== (
    PROCEDURE = public.nonull_append_strings,
    LEFTARG = integer,
    RIGHTARG = text
);

CREATE OR REPLACE FUNCTION public.f_regoperator(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||==(text, text)'::regoperator)::text AS text;$$;


---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION public.f1(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1;$$;

CREATE OR REPLACE FUNCTION public.f_regproc(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f1'::regproc)::text AS text;$$;

---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION public.f2(f1 text, f2 text) RETURNS text
    LANGUAGE sql
    AS $$ select 1;$$;

CREATE OR REPLACE FUNCTION public.f2(f1 text, f2 integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1;$$;

CREATE OR REPLACE FUNCTION public.f_regprocedure(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f2(text, text)'::regprocedure)::text AS text;$$;