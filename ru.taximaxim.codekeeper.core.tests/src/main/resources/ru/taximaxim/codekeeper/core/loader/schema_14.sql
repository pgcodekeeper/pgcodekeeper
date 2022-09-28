CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;


ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO fordfrog;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

ALTER FUNCTION public.trigger_fnc() OWNER TO fordfrog;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

ALTER TABLE public.test OWNER TO fordfrog;

COMMENT ON TABLE public.test IS 'test table';

COMMENT ON COLUMN public.test.id IS 'id column';

COMMENT ON COLUMN public.test.text IS 'text column';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check';

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.test_id_seq OWNER TO fordfrog;

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

CREATE VIEW public.test_view AS
    SELECT 
        test.id, 
        test.text 
    FROM public.test;

ALTER TABLE public.test_view OWNER TO fordfrog;

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

ALTER TABLE public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX public.test_pkey IS 'primary key';

CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test FOR EACH STATEMENT EXECUTE PROCEDURE public.trigger_fnc();

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;