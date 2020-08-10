COMMENT ON SCHEMA public IS 'Standard public schema';


CREATE OR REPLACE FUNCTION public.events_delete_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  RETURN NULL;
END;
$$;


CREATE SEQUENCE public.tbl_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


CREATE SEQUENCE public.tbl_id_2_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


CREATE TABLE public.tbl (
    tbl_id bigint DEFAULT nextval('public.tbl_id_seq'::regclass) NOT NULL,
    tbl_id_2 bigint DEFAULT nextval('public.tbl_id_2_seq'::regclass) NOT NULL,
    name text,
    population double precision,
    altitude text DEFAULT '23'::text,
    description integer DEFAULT 55777,
    event_time timestamp without time zone DEFAULT now() NOT NULL
);

--------------------------------------------------------------------------------

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);

--------------------------------------------------------------------------------

CREATE TRIGGER events_before_delete
    BEFORE DELETE ON public.tbl
    FOR EACH ROW
    EXECUTE PROCEDURE public.events_delete_trigger();

--------------------------------------------------------------------------------

CREATE RULE notify_tbl AS
    ON DELETE TO public.tbl
  DO ALSO NOTIFY tbl;

--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));

--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_pkey PRIMARY KEY (tbl_id);


CREATE VIEW public.v AS
    SELECT tbl.name,
    tbl.altitude,
    1 AS qwe
   FROM public.tbl;

CREATE VIEW public.v2 AS
    SELECT a.name,
    4 AS zxc
   FROM public.v a;


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;