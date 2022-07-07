SET search_path = pg_catalog;

ALTER SEQUENCE public.custom_named_seq RENAME TO changed_named_seq;

ALTER SEQUENCE public.changed_named_seq
	INCREMENT BY 12
	MINVALUE 5
	START WITH 5;
