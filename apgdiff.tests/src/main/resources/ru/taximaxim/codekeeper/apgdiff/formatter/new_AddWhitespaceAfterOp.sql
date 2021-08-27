CREATE FUNCTION public.fun2() RETURNS void LANGUAGE plpgsql AS $$ BEGIN select 1,-1,+1,2= 5+ 5,2< 5,s|| s2,j-> a,3>> 2;END $$;
ALTER FUNCTION public.fun2() OWNER TO user_m;