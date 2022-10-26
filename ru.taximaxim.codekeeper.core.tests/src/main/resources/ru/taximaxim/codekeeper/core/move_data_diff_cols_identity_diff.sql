SET search_path = pg_catalog;

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_name22_check;

-- DEPCY: This TRIGGER depends on the COLUMN: public.tbl.did_2

DROP TRIGGER events_insert ON public.tbl;

-- DEPCY: This FUNCTION depends on the COLUMN: public.tbl.did_2

DROP FUNCTION public.events_insert_trigger();

-- DEPCY: This VIEW depends on the TABLE: public.tbl

DROP VIEW public.v;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_pkey;

ALTER TABLE public.tbl RENAME TO tbl_randomly_generated_part;

ALTER SEQUENCE public.tbl_did_seq RENAME TO tbl_did_seq_randomly_generated_part;

ALTER SEQUENCE public.tbl_did_2_seq RENAME TO tbl_did_2_seq_randomly_generated_part;

CREATE TABLE public.tbl (
	did integer NOT NULL,
	did_3 integer NOT NULL,
	name4444 character varying(40),
	event_time timestamp without time zone DEFAULT now() NOT NULL,
	description integer DEFAULT 55777,
	calculated bigint GENERATED ALWAYS AS ((did + 2000)) STORED,
	password character varying(127) NOT NULL
);

ALTER TABLE public.tbl ALTER COLUMN did ADD GENERATED BY DEFAULT AS IDENTITY (
	SEQUENCE NAME public.tbl_did_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1
);

ALTER TABLE public.tbl ALTER COLUMN did_3 ADD GENERATED BY DEFAULT AS IDENTITY (
	SEQUENCE NAME public.tbl_did_3_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1
);

INSERT INTO public.tbl(did, event_time, description, password)
OVERRIDING SYSTEM VALUE
SELECT did, event_time, description, password FROM public.tbl_randomly_generated_part;

DO LANGUAGE plpgsql $_$
DECLARE restart_var bigint = (SELECT nextval(pg_get_serial_sequence('public.tbl_randomly_generated_part', 'did')));
BEGIN
	EXECUTE $$ ALTER TABLE public.tbl ALTER COLUMN did RESTART WITH $$ || restart_var || ';' ;
END;
$_$;

DROP TABLE public.tbl_randomly_generated_part;

-- DEPCY: This FUNCTION is a dependency of TRIGGER: public.tbl.events_insert

CREATE OR REPLACE FUNCTION public.events_insert_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  UPDATE public.tbl
  SET description = (SELECT trunc(random() * 100 + 1)) 
  WHERE did_3 = 2;
  RETURN NULL;
END;
$$;

CREATE TRIGGER events_insert
	AFTER INSERT ON public.tbl
	FOR EACH ROW
	EXECUTE PROCEDURE public.events_insert_trigger();

CREATE VIEW public.v AS
	SELECT tbl.description,
    1 AS qwerty
   FROM public.tbl;

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_pkey PRIMARY KEY (did);