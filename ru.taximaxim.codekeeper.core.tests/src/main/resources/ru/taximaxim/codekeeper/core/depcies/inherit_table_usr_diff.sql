SET search_path = pg_catalog;

-- DEPCY: This SEQUENCE seq2 is a dependency of COLUMN: public.t2.c4

CREATE SEQUENCE public.seq2
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.seq2 OWNER TO botov_av;

ALTER TABLE public.t2
	ADD COLUMN c4 integer;

ALTER TABLE ONLY public.t2
	ALTER COLUMN c4 SET DEFAULT nextval('public.seq2'::regclass);