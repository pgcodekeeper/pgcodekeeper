COMMENT ON DATABASE comments IS 'comments database';
COMMENT ON SCHEMA public IS 'public schema';


CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;

ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;


SET search_path = public, pg_catalog;

CREATE TYPE typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

ALTER TYPE typ_composite OWNER TO fordfrog;

COMMENT ON TYPE typ_composite IS 'test type';

COMMENT ON COLUMN typ_composite.key IS 'Type composite key comment';

COMMENT ON COLUMN typ_composite.val IS 'Type composite val comment';

CREATE DOMAIN dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));
    
ALTER DOMAIN dom OWNER TO fordfrog;

COMMENT ON DOMAIN dom IS 'test domain';

CREATE FUNCTION test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO fordfrog;

COMMENT ON FUNCTION test_fnc(arg character varying) IS 'test function';


CREATE FUNCTION trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

ALTER FUNCTION public.trigger_fnc() OWNER TO fordfrog;


CREATE TABLE test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

ALTER TABLE public.test OWNER TO fordfrog;

COMMENT ON TABLE test IS 'test table';

COMMENT ON COLUMN test.id IS 'id column';

COMMENT ON COLUMN test.text IS 'text column';


COMMENT ON CONSTRAINT text_check ON test IS 'text check';


CREATE SEQUENCE test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.test_id_seq OWNER TO fordfrog;

ALTER SEQUENCE test_id_seq OWNED BY test.id;

COMMENT ON SEQUENCE test_id_seq IS 'test table sequence';


CREATE VIEW test_view AS
    SELECT test.id, test.text FROM test;

ALTER TABLE public.test_view OWNER TO fordfrog;

COMMENT ON VIEW test_view IS 'test view';

COMMENT ON COLUMN test_view.id IS 'view id col';


ALTER TABLE test ALTER COLUMN id SET DEFAULT nextval('test_id_seq'::regclass);


ALTER TABLE ONLY test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX test_pkey IS 'primary key';


CREATE TRIGGER test_trigger BEFORE UPDATE ON test FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();

COMMENT ON TRIGGER test_trigger ON test IS 'test trigger';


CREATE RULE test_rule AS ON DELETE TO test DO NOTHING;

COMMENT ON RULE test_rule ON test IS 'test rule';

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

