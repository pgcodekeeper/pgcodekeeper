CREATE TABLE public.t1 (
    id integer DEFAULT public.f1()
);


CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
    select public.f2();
END
$$;

CREATE OR REPLACE FUNCTION public.f2() RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
   SELECT 1 FROM public.t1 WHERE id > 0;
END
$$;