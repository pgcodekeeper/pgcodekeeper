SET search_path = pg_catalog;

-- DEPCY: This VIEW depends on the TABLE: public.tbl

DROP VIEW public.v;

-- DEPCY: This TRIGGER depends on the TABLE: public.tbl

DROP TRIGGER events_insert ON public.tbl;

-- DEPCY: This FUNCTION depends on the TABLE: public.tbl

DROP FUNCTION public.events_insert_trigger();

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_pkey;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_event_time_check;

-- DEPCY: This RULE depends on the TABLE: public.tbl

DROP RULE notify_me_tbl ON public.tbl;

-- DEPCY: This INDEX depends on the TABLE: public.tbl

DROP INDEX public.tbl_idx;

ALTER TABLE public.tbl RENAME TO tbl_randomly_generated_part;

CREATE TABLE public.tbl (
	id bigint DEFAULT nextval('public.seq_tbl_id'::regclass) NOT NULL,
	id_2 bigint DEFAULT nextval('public.seq_tbl_id_2'::regclass) NOT NULL,
	name text,
	population double precision,
	description integer DEFAULT 55777,
	altitude text DEFAULT '23'::text,
	event_time timestamp without time zone DEFAULT now() NOT NULL
);

GRANT INSERT ON TABLE public.tbl TO test_user;

INSERT INTO public.tbl(id, id_2, name, population, description, altitude, event_time) SELECT id, id_2, name, population, description, altitude, event_time FROM public.tbl_randomly_generated_part;

DROP TABLE public.tbl_randomly_generated_part;

CREATE VIEW public.v AS
	SELECT tbl.name,
    tbl.altitude,
    1 AS qwerty
   FROM public.tbl;

-- DEPCY: This FUNCTION is a dependency of TRIGGER: public.tbl.events_insert

CREATE OR REPLACE FUNCTION public.events_insert_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  UPDATE public.tbl
  SET description = (SELECT trunc(random() * 100 + 1)) 
  WHERE id_2 = 2;
  RETURN NULL;
END;
$$;

CREATE TRIGGER events_insert
	AFTER INSERT ON public.tbl
	FOR EACH ROW
	EXECUTE PROCEDURE public.events_insert_trigger();

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_pkey PRIMARY KEY (id);

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));

CREATE RULE notify_me_tbl AS
    ON DELETE TO public.tbl DO  NOTIFY tbl;

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);
