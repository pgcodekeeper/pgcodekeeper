CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 1))
);

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test
FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS ON DELETE TO public.test DO NOTHING;

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;

CREATE ROLE test_role;

ALTER DEFAULT PRIVILEGES FOR ROLE test_role 
	REVOKE ALL PRIVILEGES ON TABLES TO test_role;

GRANT SELECT ON TABLE public.test TO test_role;

GRANT INSERT ON TABLE public.test TO test_role;

GRANT UPDATE ON TABLE public.test TO test_role;
 
ALTER TABLE public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);
