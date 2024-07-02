CREATE EXTENSION test_ext WITH SCHEMA pg_catalog;

CREATE CAST (integer AS bigint) WITHOUT FUNCTION;

CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));
	
CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

CREATE PROCEDURE public.test_proc(arg integer)
    LANGUAGE SQL
    AS $$ $$;

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE FOREIGN TABLE public.test_ft (
    c1 integer,
    c2 text
) SERVER myserver;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

CREATE INDEX test_index ON public.test (id, text);

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;

CREATE MATERIALIZED VIEW public.test_mat_view AS
    SELECT 1 AS c1 WITH DATA;

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

CREATE STATISTICS public.s1 ON id, text FROM public.test;

ALTER TABLE public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test
FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS ON DELETE TO public.test DO NOTHING;

CREATE POLICY test_policy ON public.test;

CREATE COLLATION public.test_collation (LOCALE = 'ru_RU.utf8');

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
    
 CREATE FOREIGN DATA WRAPPER test_fdw_1;
 
 CREATE SERVER srv111 FOREIGN DATA WRAPPER fdw1 ;

 CREATE OR REPLACE FUNCTION public.proc1()
    RETURNS event_trigger
    LANGUAGE plpgsql
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
END;
$BODY$;

CREATE EVENT TRIGGER evt1
ON ddl_command_start
EXECUTE PROCEDURE proc1();