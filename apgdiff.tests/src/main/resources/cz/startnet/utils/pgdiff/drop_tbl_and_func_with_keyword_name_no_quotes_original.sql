CREATE OR REPLACE FUNCTION public.user() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;

ALTER FUNCTION public.user() OWNER TO shamsutdinov_lr;

CREATE TABLE public.user (
    c1 integer DEFAULT public.user()
);

ALTER TABLE public.user OWNER TO shamsutdinov_lr;
