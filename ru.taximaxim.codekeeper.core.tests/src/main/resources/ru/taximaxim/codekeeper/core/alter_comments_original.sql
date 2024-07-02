COMMENT ON DATABASE comments IS 'comments database';
COMMENT ON SCHEMA public IS 'public schema';

CREATE CAST (integer AS bigint) WITHOUT FUNCTION;

COMMENT ON CAST (integer AS bigint) IS 'test cast'; 

CREATE EXTENSION test_ext WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION test_ext IS 'test extension';
CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

COMMENT ON TYPE public.typ_composite IS 'This composite type';

COMMENT ON COLUMN public.typ_composite."key" IS 'Type column of composite comment';

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom_check CHECK ((VALUE <> 0));
    
COMMENT ON DOMAIN public.dom IS 'Domain comment';

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

CREATE FOREIGN TABLE public.test_ft (
    c1 integer,
    c2 text
) SERVER myserver;

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table';

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

COMMENT ON EVENT TRIGGER evt1 IS 'event trigger';

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence';

CREATE MATERIALIZED VIEW public.test_mat_view AS
    SELECT 1 AS c1 WITH DATA;

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view';

CREATE VIEW public.test_view AS
    SELECT test.id, test.text FROM public.test;

COMMENT ON VIEW public.test_view IS 'test view';

COMMENT ON COLUMN public.test_view.id IS 'view id col';

CREATE STATISTICS public.s1 ON id, text FROM public.test;

COMMENT ON STATISTICS public.s1 IS 'test statistics';

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);

COMMENT ON INDEX public.test_pkey IS 'primary key';

CREATE TRIGGER test_trigger 
BEFORE UPDATE ON public.test 
FOR EACH STATEMENT EXECUTE PROCEDURE public.trigger_fnc();

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger';

CREATE RULE test_rule AS ON DELETE TO public.test DO NOTHING;

COMMENT ON RULE test_rule ON public.test IS 'test rule';

CREATE POLICY test_policy ON public.test;

COMMENT ON POLICY test_policy ON public.test IS 'test policy';

CREATE FOREIGN DATA WRAPPER test_fdw_2;

COMMENT ON FOREIGN DATA WRAPPER test_fdw_2 IS 'test comment';

CREATE SERVER test_server_0  FOREIGN DATA WRAPPER fdw1;

COMMENT ON SERVER test_server_0 IS 'test_comment';

CREATE COLLATION public.test_collation (LOCALE = 'ru_RU.utf8');

COMMENT ON COLLATION  public.test_collation IS 'ru';
