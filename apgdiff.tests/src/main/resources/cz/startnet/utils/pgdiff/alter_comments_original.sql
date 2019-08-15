COMMENT ON DATABASE comments IS 'comments database';
COMMENT ON SCHEMA public IS 'public schema';

CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

COMMENT ON TYPE public.typ_composite IS 'This composite type';

COMMENT ON COLUMN public.typ_composite."key" IS 'Type column of composite comment';

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom_check CHECK ((VALUE <> 0));
    
COMMENT ON DOMAIN public.dom IS 'Domain comment';

CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

CREATE INDEX test_index ON public.test (id, text);

COMMENT ON TABLE public.test IS 'test table';

COMMENT ON COLUMN public.test.id IS 'id column';

COMMENT ON COLUMN public.test.text IS 'text column';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check';

COMMENT ON INDEX public.test_index ON IS 'test table index';

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX public.test_pkey IS 'primary key';

CREATE TRIGGER test_trigger 
BEFORE UPDATE ON public.test 
FOR EACH STATEMENT EXECUTE PROCEDURE public.trigger_fnc();

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';