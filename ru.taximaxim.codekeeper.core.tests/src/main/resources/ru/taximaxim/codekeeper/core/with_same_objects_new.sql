SET search_path = pg_catalog;

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8"
);

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1);

CREATE TABLE public.test (
	id integer DEFAULT nextval('public.test_id_seq'::regclass) NOT NULL,
	text character varying(20) NOT NULL
);

CREATE SEQUENCE public.test_id_seq
	START WITH 3
	INCREMENT BY 7
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
