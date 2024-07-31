SET search_path = pg_catalog;

ALTER SEQUENCE public.t1_row_id_seq SET LOGGED;

ALTER SEQUENCE public.t2_row_id_seq SET UNLOGGED;

ALTER SEQUENCE public.t3_row_id_seq SET UNLOGGED;