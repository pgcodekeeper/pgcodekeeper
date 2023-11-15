SET search_path = pg_catalog;

CREATE EXTENSION intarray SCHEMA public;

ALTER TABLE public.tt1
	ADD EXCLUDE USING gist (c gist__intbig_ops WITH &&);

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable2_c_excl EXCLUDE (c DESC WITH &&) INCLUDE (id);

ALTER TABLE public.testtable
	ADD CONSTRAINT test EXCLUDE USING test (id DESC NULLS LAST WITH =) WITH (fillfactor=10) INITIALLY DEFERRED;

ALTER TABLE public.testtable
	ADD CONSTRAINT test2 EXCLUDE USING gist (id WITH =, daterange(d_date_begin, d_date_end, '[)'::TEXT) WITH &&)
	USING INDEX TABLESPACE ts_indexes DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE public.testtable
	ADD CONSTRAINT test3 EXCLUDE ((id > 10) DESC NULLS LAST WITH =) WITH (deduplicate_items) INITIALLY DEFERRED;
