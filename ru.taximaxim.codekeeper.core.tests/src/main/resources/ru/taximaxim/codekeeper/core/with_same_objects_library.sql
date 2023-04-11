SET search_path = pg_catalog;

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1);

CREATE TABLE public.test (
	id integer DEFAULT nextval('public.test_id_seq'::regclass) NOT NULL,
	text character varying(20) NOT NULL
);

CREATE SEQUENCE public.test_id_seq
	START WITH 1
	INCREMENT BY 1
	CACHE 1;

CREATE TEXT SEARCH PARSER public.test_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	HEADLINE = prsd_headline,
	LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH TEMPLATE public.test_template (
	LEXIZE = dsnowball_lexize );

CREATE TEXT SEARCH DICTIONARY public.test_dictionary (
	TEMPLATE = snowball,
	language = 'english',
	stopwords = 'english' );

CREATE TEXT SEARCH CONFIGURATION public.test_config (
	PARSER = pg_catalog."default" );

CREATE OR REPLACE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

CREATE OR REPLACE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 1));

ALTER TABLE public.test
	ADD CONSTRAINT test_pkey PRIMARY KEY (id);

CREATE VIEW public.test_view AS
	SELECT test.id, test.text FROM public.test;

CREATE TRIGGER test_trigger
	BEFORE UPDATE ON public.test
	FOR EACH STATEMENT
	EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS
    ON DELETE TO public.test DO NOTHING;

ALTER SEQUENCE public.test_id_seq
	OWNED BY public.test.id;
