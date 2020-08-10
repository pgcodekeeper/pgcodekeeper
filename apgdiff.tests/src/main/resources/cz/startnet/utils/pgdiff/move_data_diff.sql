SET search_path = pg_catalog;

-- DEPCY: This VIEW depends on the TABLE: public.tbl

DROP VIEW public.v2;

-- DEPCY: This VIEW depends on the TABLE: public.tbl

DROP VIEW public.v;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_pkey;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_event_time_check;

-- DEPCY: This RULE depends on the TABLE: public.tbl

DROP RULE notify_tbl ON public.tbl;

-- DEPCY: This TRIGGER depends on the TABLE: public.tbl

DROP TRIGGER events_before_delete ON public.tbl;

-- DEPCY: This INDEX depends on the TABLE: public.tbl

DROP INDEX public.tbl_idx;

ALTER TABLE public.tbl RENAME TO tbl_randomly_generated_part;

CREATE TABLE public.tbl (
	tbl_id bigint DEFAULT nextval('public.tbl_id_seq'::regclass) NOT NULL,
	tbl_id_2 bigint DEFAULT nextval('public.tbl_id_2_seq'::regclass) NOT NULL,
	name text,
	population double precision,
	description integer DEFAULT 55777,
	altitude text DEFAULT '23'::text,
	event_time timestamp without time zone DEFAULT now() NOT NULL
);

-- DEPCY: This VIEW is a dependency of VIEW: public.v2

CREATE VIEW public.v AS
	SELECT tbl.name,
    tbl.altitude,
    1 AS qwe
   FROM public.tbl;

CREATE VIEW public.v2 AS
	SELECT a.name,
    4 AS zxc
   FROM public.v a;

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_pkey PRIMARY KEY (tbl_id);

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));

CREATE RULE notify_tbl AS
    ON DELETE TO public.tbl DO  NOTIFY tbl;

CREATE TRIGGER events_before_delete
	BEFORE DELETE ON public.tbl
	FOR EACH ROW
	EXECUTE PROCEDURE public.events_delete_trigger();

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);

INSERT INTO public.tbl(tbl_id, tbl_id_2, name, population, altitude, description, event_time) SELECT tbl_id, tbl_id_2, name, population, altitude, description, event_time FROM public.tbl_randomly_generated_part;

DROP TABLE public.tbl_randomly_generated_part;
