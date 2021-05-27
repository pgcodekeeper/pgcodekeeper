CREATE FUNCTION public.fun2() RETURNS void LANGUAGE plpgsql AS $$BEGIN
        select 1;
        select 1;
END $$;
ALTER FUNCTION public.fun2() OWNER TO user_m;