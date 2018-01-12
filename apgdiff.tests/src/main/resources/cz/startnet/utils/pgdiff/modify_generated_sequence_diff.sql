SET search_path = public, pg_catalog;

ALTER SEQUENCE custom_named_seq RENAME TO changed_named_seq;

ALTER SEQUENCE changed_named_seq
	INCREMENT BY 12
	MINVALUE 5
	RESTART WITH 5;
