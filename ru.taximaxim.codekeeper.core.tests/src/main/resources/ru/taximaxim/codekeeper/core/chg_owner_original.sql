CREATE SCHEMA test_schema;

ALTER SCHEMA test_schema OWNER TO botov_av;

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));

ALTER DOMAIN public.dom OWNER TO botov_av;

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

ALTER TYPE public.typ_composite OWNER TO botov_av;

CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO botov_av;

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

ALTER FUNCTION public.trigger_fnc() OWNER TO botov_av;

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);

ALTER TABLE public.test OWNER TO botov_av;

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.test_id_seq OWNER TO botov_av;

CREATE VIEW public.test_view AS
 SELECT test.id,
    test.text
   FROM public.test;

ALTER TABLE public.test_view OWNER TO botov_av;

CREATE STATISTICS public.s1 ON id, text FROM public.test;

ALTER STATISTICS public.s1 OWNER TO botov_av;