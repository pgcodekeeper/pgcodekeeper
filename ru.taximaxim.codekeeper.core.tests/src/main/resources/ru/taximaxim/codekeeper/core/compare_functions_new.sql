-- no diff
CREATE FUNCTION public.f1(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f40(test in integer) RETURNS void LANGUAGE sql AS $$ $$;

-- cost
CREATE FUNCTION public.f2(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f3(integer) RETURNS void LANGUAGE sql COST 5.0 AS $$ $$;
CREATE FUNCTION public.f4(integer) RETURNS void LANGUAGE sql COST 2.5 AS $$ $$;
CREATE FUNCTION public.f5(integer) RETURNS void LANGUAGE internal AS $$ $$;
CREATE FUNCTION public.f6(integer) RETURNS void LANGUAGE internal COST 5.0 AS $$ $$;
CREATE FUNCTION public.f7(integer) RETURNS void LANGUAGE internal COST 3.0 AS $$ $$;
CREATE FUNCTION public.f8(integer) RETURNS void LANGUAGE c AS $$ $$;
CREATE FUNCTION public.f9(integer) RETURNS void LANGUAGE c COST 5.0 AS $$ $$;
CREATE FUNCTION public.f10(integer) RETURNS void LANGUAGE c COST 3.0 AS $$ $$;

--rows
CREATE FUNCTION public.f11(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f12(integer) RETURNS void LANGUAGE sql ROWS 500 AS $$ $$;
CREATE FUNCTION public.f13(integer) RETURNS void LANGUAGE sql ROWS 300 AS $$ $$;

--language
CREATE FUNCTION public.f14(integer) RETURNS void LANGUAGE c AS $$ $$;

--window
CREATE FUNCTION public.f15(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f16(integer) RETURNS void LANGUAGE sql WINDOW AS $$ $$;

--null check
CREATE FUNCTION public.f17(integer) RETURNS void LANGUAGE sql RETURNS NULL ON NULL INPUT AS $$ $$;
CREATE FUNCTION public.f18(integer) RETURNS void LANGUAGE sql CALLED ON NULL INPUT AS $$ $$;
CREATE FUNCTION public.f19(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f20(integer) RETURNS void LANGUAGE sql STRICT AS $$ $$;

--security
CREATE FUNCTION public.f21(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f22(integer) RETURNS void LANGUAGE sql SECURITY INVOKER AS $$ $$;
CREATE FUNCTION public.f23(integer) RETURNS void LANGUAGE sql EXTERNAL SECURITY DEFINER AS $$ $$;

--volatile
CREATE FUNCTION public.f24(integer) RETURNS void LANGUAGE sql STABLE AS $$ $$;
CREATE FUNCTION public.f25(integer) RETURNS void LANGUAGE sql IMMUTABLE AS $$ $$;
CREATE FUNCTION public.f26(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f27(integer) RETURNS void LANGUAGE sql VOLATILE AS $$ $$;

--leakproof
CREATE FUNCTION public.f28(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f29(integer) RETURNS void LANGUAGE sql LEAKPROOF AS $$ $$;

--transform
CREATE FUNCTION public.f30(integer) RETURNS void LANGUAGE sql AS $$ $$;
CREATE FUNCTION public.f31(integer) RETURNS void LANGUAGE sql TRANSFORM FOR TYPE text AS $$ $$;
CREATE FUNCTION public.f32(integer) RETURNS void LANGUAGE sql TRANSFORM FOR TYPE text AS $$ $$;

--configuration
CREATE FUNCTION public.f33(integer) RETURNS void LANGUAGE sql SET zero_damaged_pages FROM CURRENT AS $$ $$;
CREATE FUNCTION public.f34(integer) RETURNS void LANGUAGE sql SET debug_deadlocks = true SET TIME ZONE - 1 SET ROLE FROM CURRENT AS $$ $$;
CREATE FUNCTION public.f35(integer) RETURNS void LANGUAGE sql SET ROLE NONE AS $$ $$;
CREATE FUNCTION public.f36(integer) RETURNS void LANGUAGE sql SET XML OPTION DOCUMENT SET zero_damaged_pages = true SET SESSION AUTHORIZATION 'a' SET TIME ZONE DEFAULT AS $$ $$;
CREATE FUNCTION public.f37(integer) RETURNS void LANGUAGE sql SET XML OPTION CONTENT SET TIME ZONE 'Europe/Rome' SET SESSION AUTHORIZATION DEFAULT AS $$ $$;
CREATE FUNCTION public.f38(integer) RETURNS void LANGUAGE sql SET SESSION AUTHORIZATION test SET ROLE test SET TIME ZONE LOCAL AS $$ $$;
CREATE FUNCTION public.f39(integer) RETURNS void LANGUAGE sql SET XMLOPTION TO DEFAULT SET session.timezone TO 'Europe/Rome' AS $$ $$;

