--drop identitiy column
CREATE TABLE public.testtable (
    id bigint NOT NULL,
    c2 text NOT NULL,
    c3 bigint
);

ALTER TABLE public.testtable ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.testtable_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
);

-----------------------------------------------------------------------------
-- change identitiy column
CREATE TABLE public.testtable1 (
    id bigint NOT NULL,
    c2 text NOT NULL,
    c3 bigint
);

ALTER TABLE public.testtable1 ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.testtable1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
);

-----------------------------------------------------------------------------
--change identitiy type
CREATE TABLE public.testtable2 (
    id bigint NOT NULL,
    c2 text NOT NULL,
    c3 bigint
);

ALTER TABLE public.testtable2 ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.testtable2_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
);

ALTER TABLE public.testtable2 OWNER TO khazieva_gr;