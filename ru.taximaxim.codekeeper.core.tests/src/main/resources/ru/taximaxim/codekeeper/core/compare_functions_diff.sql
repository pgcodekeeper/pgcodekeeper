SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.f2(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f3(integer) RETURNS void
    LANGUAGE sql COST 5.0
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f4(integer) RETURNS void
    LANGUAGE sql COST 2.5
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f5(integer) RETURNS void
    LANGUAGE internal
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f6(integer) RETURNS void
    LANGUAGE internal COST 5.0
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f7(integer) RETURNS void
    LANGUAGE internal COST 3.0
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f8(integer) RETURNS void
    LANGUAGE c
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f9(integer) RETURNS void
    LANGUAGE c COST 5.0
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f10(integer) RETURNS void
    LANGUAGE c COST 3.0
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f11(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f12(integer) RETURNS void
    LANGUAGE sql ROWS 500
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f13(integer) RETURNS void
    LANGUAGE sql ROWS 300
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f14(integer) RETURNS void
    LANGUAGE c
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f15(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f16(integer) RETURNS void
    LANGUAGE sql WINDOW
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f17(integer) RETURNS void
    LANGUAGE sql STRICT
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f18(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f19(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f20(integer) RETURNS void
    LANGUAGE sql STRICT
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f22(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f23(integer) RETURNS void
    LANGUAGE sql SECURITY DEFINER
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f24(integer) RETURNS void
    LANGUAGE sql STABLE
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f25(integer) RETURNS void
    LANGUAGE sql IMMUTABLE
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f28(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f29(integer) RETURNS void
    LANGUAGE sql LEAKPROOF
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f30(integer) RETURNS void
    LANGUAGE sql
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f31(integer) RETURNS void
    LANGUAGE sql TRANSFORM FOR TYPE text
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f32(integer) RETURNS void
    LANGUAGE sql TRANSFORM FOR TYPE text
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f33(integer) RETURNS void
    LANGUAGE sql
    SET zero_damaged_pages FROM CURRENT
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f34(integer) RETURNS void
    LANGUAGE sql
    SET debug_deadlocks TO true
    SET "TimeZone" TO - 1
    SET "ROLE" FROM CURRENT
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f35(integer) RETURNS void
    LANGUAGE sql
    SET role TO 'none'
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f36(integer) RETURNS void
    LANGUAGE sql
    SET xmloption TO 'document'
    SET zero_damaged_pages TO true
    SET session_authorization TO 'a'
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f37(integer) RETURNS void
    LANGUAGE sql
    SET xmloption TO 'content'
    SET "TimeZone" TO 'Europe/Rome'
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f38(integer) RETURNS void
    LANGUAGE sql
    SET session_authorization TO 'test'
    SET role TO 'test'
    AS $$ $$;

CREATE OR REPLACE FUNCTION public.f39(integer) RETURNS void
    LANGUAGE sql
    SET xmloption TO DEFAULT
    SET "session.timezone" TO 'Europe/Rome'
    AS $$ $$;