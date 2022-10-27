SET search_path = pg_catalog;

ALTER SEQUENCE public.trigtest_i_seq1
	START WITH 7;

ALTER SEQUENCE public.trigtest_i_seq1 SET UNLOGGED;

ALTER SEQUENCE public.trigtest_i_seq2 SET LOGGED;