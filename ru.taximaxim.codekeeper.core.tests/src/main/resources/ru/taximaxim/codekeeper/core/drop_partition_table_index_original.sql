
CREATE TABLE public.main_table (
    c1 bigint not null,
    с2 bigint not null,
    с3 bigint
)
PARTITION BY LIST (с2);

ALTER TABLE public.main_table ALTER COLUMN c1 ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.main_table_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
);

CREATE INDEX main_table_c3_idx ON public.main_table USING btree (c3);

ALTER TABLE public.main_table
    ADD CONSTRAINT main_table_pkey PRIMARY KEY (c2, c1);
    
--------------------------------------------------------------------------------

CREATE TABLE public.table_default PARTITION OF public.main_table
DEFAULT;

CREATE INDEX IF NOT EXISTS table_default_c3_idx ON public.table_default USING btree (c3);

ALTER INDEX public.main_table_c3_idx ATTACH PARTITION public.table_default_c3_idx;

--------------------------------------------------------------------------------

CREATE TABLE public.table_part1 PARTITION OF public.main_table
FOR VALUES IN ('55');

CREATE INDEX IF NOT EXISTS table_part1_c3_idx ON public.table_part1 USING btree (c3);

ALTER INDEX public.main_table_c3_idx ATTACH PARTITION public.table_part1_c3_idx;

