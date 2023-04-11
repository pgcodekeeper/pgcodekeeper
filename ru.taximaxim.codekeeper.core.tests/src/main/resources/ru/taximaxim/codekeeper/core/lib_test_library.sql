CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1);
    
CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 1))
);

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;
 
ALTER TABLE public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test
FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS ON DELETE TO public.test DO NOTHING;

CREATE TEXT SEARCH TEMPLATE public.test_template (
    LEXIZE = dsnowball_lexize );

CREATE TEXT SEARCH PARSER public.test_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH DICTIONARY public.test_dictionary (
    TEMPLATE = snowball,
    language = 'english',
    stopwords = 'english' );

CREATE TEXT SEARCH CONFIGURATION public.test_config (
    PARSER = pg_catalog."default" );

CREATE ROLE test_role;

GRANT SELECT ON TABLE public.test TO test_role;

GRANT INSERT ON TABLE public.test TO test_role;

GRANT UPDATE ON TABLE public.test TO test_role;

