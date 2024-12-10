COMMENT ON DATABASE comments IS 'comments database 2';
COMMENT ON SCHEMA public IS 'public schema 2';

CREATE CAST (integer AS bigint) WITHOUT FUNCTION;

COMMENT ON CAST (integer AS bigint) IS 'test cast 2'; 

CREATE EXTENSION test_ext WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION test_ext IS 'test extension 2';

CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    col1 character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

COMMENT ON TYPE public.typ_composite IS 'This composite type 2';

COMMENT ON COLUMN public.typ_composite."key" IS 'Type column of composite comment 2';

CREATE OR REPLACE FUNCTION public.proc1()
    RETURNS event_trigger
    LANGUAGE plpgsql
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
select 1;
END;
$BODY$;

CREATE EVENT TRIGGER evt1
ON ddl_command_start
EXECUTE PROCEDURE proc2();

COMMENT ON EVENT TRIGGER evt1 IS 'altered comment of the event trigger';

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom_check CHECK ((VALUE <> 0));
    
COMMENT ON DOMAIN public.dom IS 'Domain comment 2';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint 2';

CREATE DOMAIN public.dom2 AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom_check2 CHECK ((VALUE <> 0))
    CONSTRAINT dom5_check1 CHECK ((VALUE <> (-1)));
    
COMMENT ON DOMAIN public.dom2 IS 'Domain comment';

COMMENT ON CONSTRAINT dom_check2 ON DOMAIN public.dom2 IS 'test domain constraint';

CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN false;
END;$$;

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function 2';

CREATE PROCEDURE public.test_proc(arg integer)
    LANGUAGE SQL
    AS $$ $$;

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure 2';

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
    select 1;
end;$$;

CREATE FOREIGN TABLE public.test_ft (
    c1 integer,
    c0 text,
    c2 text
) SERVER myserver;

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table 2';

CREATE TABLE public.test (
    id integer NOT NULL,
    text1 character varying(20) NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

CREATE INDEX test_index ON public.test (id, text, text1);

COMMENT ON TABLE public.test IS 'test table 2';

COMMENT ON COLUMN public.test.id IS 'id column 2';

COMMENT ON COLUMN public.test.text IS 'text column 2';

COMMENT ON COLUMN public.test.text1 IS 'text column 000';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check 2';

COMMENT ON INDEX public.test_index IS 'test table index 2';

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 2
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence 2';

CREATE MATERIALIZED VIEW public.test_mat_view AS
    SELECT 1 AS c2 WITH DATA;

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view 2';

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

COMMENT ON VIEW public.test_view IS 'test view 2';

COMMENT ON COLUMN public.test_view.id IS 'view id col 2';

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX public.test_pkey IS 'primary key 2';

CREATE TRIGGER test_trigger 
BEFORE UPDATE ON public.test 
FOR EACH STATEMENT EXECUTE PROCEDURE public.test_fnc();

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger 2';

CREATE RULE test_rule AS ON DELETE TO public.test DO ALSO NOTHING;

COMMENT ON RULE test_rule ON public.test IS 'test rule 2';

CREATE POLICY test_policy ON public.test;

COMMENT ON POLICY test_policy ON public.test IS 'test policy 2';

CREATE FOREIGN DATA WRAPPER test_fdw_2;

COMMENT ON FOREIGN DATA WRAPPER test_fdw_2 IS 'new comment';

CREATE SERVER test_server_0  FOREIGN DATA WRAPPER fdw2;

COMMENT ON SERVER test_server_0 IS 'new_comment';

CREATE COLLATION public.test_collation (LOCALE = 'ru_RU.utf8');

COMMENT ON COLLATION  public.test_collation IS 'ru Ru';
