SET search_path = pg_catalog;

CREATE CAST (integer AS bigint) WITHOUT FUNCTION;

CREATE EXTENSION test_ext SCHEMA pg_catalog;

CREATE EVENT TRIGGER evt1
	ON ddl_command_start
	EXECUTE PROCEDURE proc1();

CREATE FOREIGN DATA WRAPPER test_fdw_1;

CREATE SERVER srv111 FOREIGN DATA WRAPPER fdw1;

CREATE COLLATION public.test_collation (LOCALE = 'ru_RU.utf8');

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));

-- DEPCY: This SEQUENCE test_id_seq is a dependency of COLUMN: public.test.id

CREATE SEQUENCE public.test_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE public.test (
	id integer DEFAULT nextval('public.test_id_seq'::regclass) NOT NULL,
	text character varying(20) NOT NULL
);

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

CREATE FOREIGN TABLE public.test_ft (
	c1 integer,
	c2 text
)
SERVER myserver;

CREATE OR REPLACE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

CREATE OR REPLACE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE OR REPLACE FUNCTION public.proc1() RETURNS event_trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
END;
$$;

CREATE OR REPLACE PROCEDURE public.test_proc(arg integer)
    LANGUAGE "SQL"
    AS $$ $$;

CREATE INDEX test_index ON public.test (id, text);

ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 0));

ALTER TABLE public.test
	ADD CONSTRAINT test_pkey PRIMARY KEY (id);

CREATE VIEW public.view1 AS
	SELECT t1.id,
    t1.uid::character varying(36) AS uid,
    t1.col1,
    t1.col2,
    t1.col3,
    t1.col4,
    t1.col5
    FROM public.table1 t1;

ALTER VIEW public.view1 OWNER TO user1;

CREATE MATERIALIZED VIEW public.test_mat_view AS
	SELECT 1 AS c1
WITH DATA;

CREATE VIEW public.test_view AS
	SELECT test.id, test.text FROM public.test;

CREATE TRIGGER test_trigger
	BEFORE UPDATE ON public.test
	FOR EACH STATEMENT
	EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS
    ON DELETE TO public.test DO NOTHING;

CREATE POLICY test_policy ON public.test;

ALTER SEQUENCE public.test_id_seq
	OWNED BY public.test.id;

COMMENT ON CAST (integer AS bigint) IS 'test cast';

COMMENT ON EXTENSION test_ext IS 'test extension';

COMMENT ON EVENT TRIGGER evt1 IS 'This is event trigger';

COMMENT ON FOREIGN DATA WRAPPER test_fdw_1 IS 'test_comment';

COMMENT ON SERVER srv111 IS 'test_comment';

COMMENT ON COLLATION public.test_collation IS 'ru Ru';

COMMENT ON TYPE public.typ_composite IS 'test type';

COMMENT ON COLUMN public.typ_composite.key IS 'Type composite key comment';

COMMENT ON COLUMN public.typ_composite.val IS 'Type composite val comment';

COMMENT ON DOMAIN public.dom IS 'test domain';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

COMMENT ON TABLE public.test IS 'test table';

COMMENT ON COLUMN public.test.id IS 'id column';

COMMENT ON COLUMN public.test.text IS 'text column';

COMMENT ON TEXT SEARCH PARSER public.test_parser IS 'test_parser';

COMMENT ON TEXT SEARCH TEMPLATE public.test_template IS 'test_template';

COMMENT ON TEXT SEARCH DICTIONARY public.test_dictionary IS 'test_dictionary';

COMMENT ON TEXT SEARCH CONFIGURATION public.test_config IS 'test_config';

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function';

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure';

COMMENT ON INDEX public.test_index IS 'test table index';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key';

COMMENT ON VIEW public.view1 IS 'Text comment view';

COMMENT ON COLUMN public.view1.uid IS 'Text comment cols';

COMMENT ON COLUMN public.view1.col1 IS 'Text comment col1';

COMMENT ON COLUMN public.view1.col2 IS 'Text comment col2';

COMMENT ON COLUMN public.view1.col3 IS 'Text comment col3';

COMMENT ON COLUMN public.view1.col4 IS 'Text comment col4';

COMMENT ON COLUMN public.view1.col5 IS 'Text comment col5';

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view';

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

COMMENT ON RULE test_rule ON public.test IS 'test rule';

COMMENT ON POLICY test_policy ON public.test IS 'test policy';