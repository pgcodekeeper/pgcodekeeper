COMMENT ON DATABASE comments IS 'comments database';
COMMENT ON SCHEMA public IS 'public schema';

CREATE EXTENSION test_ext WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION test_ext IS 'test extension';

CREATE CAST (integer AS bigint) WITHOUT FUNCTION;

COMMENT ON CAST (integer AS bigint) IS 'test cast'; 

CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

COMMENT ON TYPE public.typ_composite IS 'test type';

COMMENT ON COLUMN public.typ_composite.key IS 'Type composite key comment';

COMMENT ON COLUMN public.typ_composite.val IS 'Type composite val comment';

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));
    
COMMENT ON DOMAIN public.dom IS 'test domain';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint';

CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

CREATE PROCEDURE public.test_proc(arg integer)
    LANGUAGE SQL
    AS $$ $$;

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure';

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

COMMENT ON INDEX public.test_index IS 'test table index';

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

ALTER TABLE public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX public.test_pkey IS 'primary key';

CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test
FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

CREATE RULE test_rule AS ON DELETE TO public.test DO NOTHING;

COMMENT ON RULE test_rule ON public.test IS 'test rule';

CREATE POLICY test_policy ON public.test;

COMMENT ON POLICY test_policy ON public.test IS 'test policy';

CREATE TEXT SEARCH TEMPLATE public.test_template (
    LEXIZE = dsnowball_lexize );

COMMENT ON TEXT SEARCH TEMPLATE public.test_template IS 'test_template';

CREATE TEXT SEARCH PARSER public.test_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

COMMENT ON TEXT SEARCH PARSER public.test_parser IS 'test_parser';

CREATE TEXT SEARCH DICTIONARY public.test_dictionary (
    TEMPLATE = snowball,
    language = 'english',
    stopwords = 'english' );

COMMENT ON TEXT SEARCH DICTIONARY public.test_dictionary IS 'test_dictionary';

CREATE TEXT SEARCH CONFIGURATION public.test_config (
    PARSER = pg_catalog."default" );

COMMENT ON TEXT SEARCH CONFIGURATION public.test_config IS 'test_config';

