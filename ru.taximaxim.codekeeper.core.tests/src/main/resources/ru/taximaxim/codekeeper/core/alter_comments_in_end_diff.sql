SET search_path = pg_catalog;

DROP EVENT TRIGGER evt1;

DROP SERVER test_server_0;

DROP TYPE public.typ_composite;

ALTER DOMAIN public.dom2
	ADD CONSTRAINT dom5_check1 CHECK ((VALUE <> (-1)));

ALTER SEQUENCE public.test_id_seq
	INCREMENT BY 2;

DROP FOREIGN TABLE public.test_ft;

-- DEPCY: This VIEW test_view depends on the TABLE: public.test

DROP VIEW public.test_view;

-- DEPCY: This CONSTRAINT test_pkey depends on the TABLE: public.test

ALTER TABLE public.test
	DROP CONSTRAINT test_pkey;

-- DEPCY: This CONSTRAINT text_check depends on the TABLE: public.test

ALTER TABLE public.test
	DROP CONSTRAINT text_check;

-- DEPCY: This POLICY test_policy depends on the TABLE: public.test

DROP POLICY test_policy ON public.test;

-- DEPCY: This RULE test_rule depends on the TABLE: public.test

DROP RULE test_rule ON public.test;

-- DEPCY: This TRIGGER test_trigger depends on the TABLE: public.test

DROP TRIGGER test_trigger ON public.test;

-- DEPCY: This INDEX test_index depends on the TABLE: public.test

DROP INDEX public.test_index;

DROP TABLE public.test;

CREATE FOREIGN TABLE public.test_ft (
	c1 integer,
	c0 text,
	c2 text
)
SERVER myserver;

CREATE TABLE public.test (
	id integer NOT NULL,
	text1 character varying(20) NOT NULL,
	text character varying(20) NOT NULL
);

CREATE OR REPLACE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN false;
END;$$;

CREATE OR REPLACE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
    select 1;
end;$$;

CREATE OR REPLACE FUNCTION public.proc1() RETURNS event_trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
select 1;
END;
$$;

DROP MATERIALIZED VIEW public.test_mat_view;

CREATE EVENT TRIGGER evt1
	ON ddl_command_start
	EXECUTE PROCEDURE proc2();

CREATE SERVER test_server_0 FOREIGN DATA WRAPPER fdw2;

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	col1 character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

CREATE VIEW public.test_view AS
	SELECT test.id, test.text FROM public.test;

ALTER TABLE public.test
	ADD CONSTRAINT test_pkey PRIMARY KEY (id);

ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 0));

CREATE POLICY test_policy ON public.test;

CREATE RULE test_rule AS
    ON DELETE TO public.test DO NOTHING;

CREATE TRIGGER test_trigger
	BEFORE UPDATE ON public.test
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.test_fnc();

CREATE INDEX test_index ON public.test (id, text, text1);

CREATE MATERIALIZED VIEW public.test_mat_view AS
	SELECT 1 AS c2
WITH DATA;

COMMENT ON CAST (integer AS bigint) IS 'test cast 2';

COMMENT ON EXTENSION test_ext IS 'test extension 2';

COMMENT ON FOREIGN DATA WRAPPER test_fdw_2 IS 'new comment';

COMMENT ON COLLATION public.test_collation IS 'ru Ru';

COMMENT ON DOMAIN public.dom IS 'Domain comment 2';

COMMENT ON CONSTRAINT dom_check ON DOMAIN public.dom IS 'test domain constraint 2';

COMMENT ON CONSTRAINT dom_check2 ON DOMAIN public.dom2 IS 'test domain constraint';

COMMENT ON SEQUENCE public.test_id_seq IS 'test table sequence 2';

COMMENT ON FOREIGN TABLE public.test_ft IS 'test foreign table 2';

COMMENT ON TABLE public.test IS 'test table 2';

COMMENT ON COLUMN public.test.id IS 'id column 2';

COMMENT ON COLUMN public.test.text1 IS 'text column 000';

COMMENT ON COLUMN public.test.text IS 'text column 2';

COMMENT ON FUNCTION public.test_fnc(arg character varying) IS 'test function 2';

COMMENT ON PROCEDURE public.test_proc(arg integer) IS 'test procedure 2';

COMMENT ON EVENT TRIGGER evt1 IS 'altered comment of the event trigger';

COMMENT ON SERVER test_server_0 IS 'new_comment';

COMMENT ON TYPE public.typ_composite IS 'This composite type 2';

COMMENT ON COLUMN public.typ_composite.key IS 'Type column of composite comment 2';

COMMENT ON VIEW public.test_view IS 'test view 2';

COMMENT ON COLUMN public.test_view.id IS 'view id col 2';

COMMENT ON CONSTRAINT test_pkey ON public.test IS 'primary key 2';

COMMENT ON CONSTRAINT text_check ON public.test IS 'text check 2';

COMMENT ON POLICY test_policy ON public.test IS 'test policy 2';

COMMENT ON RULE test_rule ON public.test IS 'test rule 2';

COMMENT ON TRIGGER test_trigger ON public.test IS 'test trigger 2';

COMMENT ON INDEX public.test_index IS 'test table index 2';

COMMENT ON MATERIALIZED VIEW public.test_mat_view IS 'test mat view 2';