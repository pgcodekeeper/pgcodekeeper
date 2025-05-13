SET search_path = pg_catalog;

-- DEPCY: This COLUMN description depends on the COLUMN: public.a.description

ALTER TABLE ONLY public.a2
	ALTER COLUMN description DROP DEFAULT;

ALTER TABLE ONLY public.a1
	ALTER COLUMN description DROP DEFAULT;

ALTER TABLE ONLY public.a
	ALTER COLUMN description DROP DEFAULT;

ALTER TABLE public.a
	ALTER COLUMN description TYPE integer USING description::integer; /* TYPE change - table: public.a original: text new: integer */

ALTER TABLE ONLY public.a
	ALTER COLUMN description SET DEFAULT 555777;

ALTER TABLE ONLY public.a1
	ALTER COLUMN description SET DEFAULT 555777;

ALTER TABLE ONLY public.a2
	ALTER COLUMN description SET DEFAULT 555777;