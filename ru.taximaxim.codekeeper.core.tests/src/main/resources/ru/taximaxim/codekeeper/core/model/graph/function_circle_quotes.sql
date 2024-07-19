CREATE OR REPLACE FUNCTION public."Func1"() RETURNS integer AS $$
        BEGIN
                RETURN public.f2();
        END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION public.f2() RETURNS integer AS $$
        BEGIN
                RETURN public."Func1"();
        END;
$$ LANGUAGE plpgsql;
