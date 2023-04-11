CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1);

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL
);

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE VIEW public.test_view AS
	SELECT test.id, test.text FROM public.test;

CREATE TRIGGER test_trigger
	BEFORE UPDATE ON public.test
	FOR EACH STATEMENT
	EXECUTE PROCEDURE trigger_fnc();

CREATE RULE test_rule AS
    ON DELETE TO public.test DO NOTHING;
    
ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 1));

ALTER TABLE public.test
	ADD CONSTRAINT test_pkey PRIMARY KEY (id);
	

ALTER SEQUENCE public.test_id_seq
	OWNED BY public.test.id;
