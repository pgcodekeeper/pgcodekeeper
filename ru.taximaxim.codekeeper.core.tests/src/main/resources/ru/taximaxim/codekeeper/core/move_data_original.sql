COMMENT ON SCHEMA public IS 'Standard public schema';


CREATE SEQUENCE public.seq_tbl_id
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE public.seq_tbl_id_2
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;



CREATE TABLE public.tbl (
    id bigint DEFAULT nextval('public.seq_tbl_id'::regclass) NOT NULL,
    id_2 bigint DEFAULT nextval('public.seq_tbl_id_2'::regclass) NOT NULL,
    name text,
    population double precision,
    altitude text DEFAULT '23'::text,
    description integer DEFAULT 55777,
    event_time timestamp without time zone DEFAULT now() NOT NULL
);

GRANT INSERT ON TABLE public.tbl TO test_user;

--------------------------------------------------------------------------------

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);

--------------------------------------------------------------------------------

CREATE RULE notify_me_tbl AS
    ON DELETE TO public.tbl
  DO ALSO NOTIFY tbl;

--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));
    
--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_pkey PRIMARY KEY (id);



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

CREATE VIEW public.v AS
    SELECT tbl.name,
    tbl.altitude,
    1 AS qwerty
   FROM public.tbl;


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--------------------------------------------------------------------------------
CREATE SEQUENCE public.cities2_city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.cities2_city_id_seq OWNER TO khazieva_gr;

ALTER SEQUENCE public.cities2_city_id_seq
    OWNED BY public.cities2.city_id;

CREATE TABLE public.cities2 (
    id1 text NOT NULL,
    id2 text NOT NULL,
    id text NOT NULL,
    city_id bigint DEFAULT nextval('public.cities2_city_id_seq'::regclass) NOT NULL,
    c_name text NOT NULL,
    population bigint
);

ALTER TABLE public.cities2 OWNER TO khazieva_gr;
