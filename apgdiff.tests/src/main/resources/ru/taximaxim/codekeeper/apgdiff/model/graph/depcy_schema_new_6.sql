CREATE TABLE public.t1 (
    c1 integer DEFAULT public.f1() NOT NULL,
    c2 text
);

CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
    select 1;
END
$$;
