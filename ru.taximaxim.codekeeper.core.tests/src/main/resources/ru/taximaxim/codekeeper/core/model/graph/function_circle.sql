CREATE OR REPLACE FUNCTION public.f1() RETURNS integer AS $$
        BEGIN
                RETURN public.f2();
        END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION public.f2() RETURNS integer AS $$
        BEGIN
                RETURN public.f1();
        END;
$$ LANGUAGE plpgsql;
