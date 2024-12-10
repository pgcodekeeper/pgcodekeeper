SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ALTER COLUMN field1 TYPE integer USING field1::integer, /* TYPE change - table: public.testtable original: smallint new: integer */
	ALTER COLUMN field3 TYPE character varying(150) USING field3::character varying(150); /* TYPE change - table: public.testtable original: character varying(100) new: character varying(150) */

ALTER TABLE public.t_prod
	ALTER COLUMN total_price TYPE numeric(30,8) USING total_price::numeric(30,8), /* TYPE change - table: public.t_prod original: numeric(30,6) new: numeric(30,8) */
	ALTER COLUMN midle_price TYPE numeric(30,7) USING midle_price::numeric(30,7), /* TYPE change - table: public.t_prod original: numeric(30,6) new: numeric(30,7) */
	ALTER COLUMN new_col TYPE numeric(30,7) USING new_col::numeric(30,7); /* TYPE change - table: public.t_prod original: numeric(30,6) new: numeric(30,7) */

ALTER TABLE public.t_lod3
	ALTER COLUMN field1 TYPE bigint USING field1::bigint, /* TYPE change - table: public.t_lod3 original: integer new: bigint */
	ALTER COLUMN field2 TYPE integer USING field2::integer; /* TYPE change - table: public.t_lod3 original: bigint new: integer */

ALTER TABLE ONLY public.t_lod3
	ALTER COLUMN field3 DROP DEFAULT;

ALTER TABLE public.t_lod3
	ALTER COLUMN field3 TYPE bigint USING field3::bigint; /* TYPE change - table: public.t_lod3 original: integer new: bigint */

ALTER TABLE ONLY public.t_lod3
	ALTER COLUMN field3 SET DEFAULT '9'::integer;

ALTER TABLE public.t_lod3_1
	ALTER COLUMN field4 TYPE integer USING field4::integer, /* TYPE change - table: public.t_lod3_1 original: double precision new: integer */
	ALTER COLUMN field5 TYPE integer USING field5::integer; /* TYPE change - table: public.t_lod3_1 original: numeric(30,6) new: integer */

ALTER TABLE public.t_prod_1
	ALTER COLUMN id TYPE integer USING id::integer, /* TYPE change - table: public.t_prod_1 original: bigint new: integer */
	ALTER COLUMN total_price TYPE numeric(30,6) USING total_price::numeric(30,6), /* TYPE change - table: public.t_prod_1 original: numeric(30,7) new: numeric(30,6) */
	ALTER COLUMN midle_price TYPE numeric(30,8) USING midle_price::numeric(30,8); /* TYPE change - table: public.t_prod_1 original: numeric(30,7) new: numeric(30,8) */

-- DEPCY: This CONSTRAINT id_1 depends on the COLUMN: public.t_lot_prod_3.id

ALTER TABLE public.t_lot_prod_3
	DROP CONSTRAINT id_1;

ALTER TABLE public.t_lot_prod_3
	ALTER COLUMN id TYPE bigint USING id::bigint; /* TYPE change - table: public.t_lot_prod_3 original: integer new: bigint */

ALTER TABLE ONLY public.t_lod4
	ALTER COLUMN field3 SET DEFAULT '9'::integer;

UPDATE public.t_lod4
	SET field3 = DEFAULT WHERE field3 IS NULL;

ALTER TABLE public.t_lod4
	ALTER COLUMN field3 SET NOT NULL;

ALTER TABLE public.t_lod4
	ALTER COLUMN field4 TYPE numeric(20,4) USING field4::numeric(20,4); /* TYPE change - table: public.t_lod4 original: bigint new: numeric(20,4) */

ALTER TABLE public.t33
	ALTER COLUMN c0 TYPE bigint USING c0::bigint; /* TYPE change - table: public.t33 original: integer new: bigint */

ALTER TABLE public.t33
	ALTER COLUMN c1 TYPE bigint USING c1::bigint; /* TYPE change - table: public.t33 original: integer new: bigint */

ALTER TABLE ONLY public.t33
	ALTER COLUMN c1 SET COMPRESSION ghh;

ALTER TABLE public.testidentity
	ALTER COLUMN id TYPE integer USING id::integer; /* TYPE change - table: public.testidentity original: bigint new: integer */

ALTER TABLE public.testidentity
	ALTER COLUMN id DROP IDENTITY;

ALTER TABLE public.testidentity
	ALTER COLUMN c1 TYPE integer USING c1::integer, /* TYPE change - table: public.testidentity original: text new: integer */
	ALTER COLUMN c11 TYPE integer USING c11::integer; /* TYPE change - table: public.testidentity original: text new: integer */

ALTER TABLE public.testidentity
	ALTER COLUMN c2 TYPE bigint USING c2::bigint; /* TYPE change - table: public.testidentity original: text new: bigint */

ALTER TABLE public.testidentity
	ALTER COLUMN c2 ADD GENERATED ALWAYS AS IDENTITY (
	SEQUENCE NAME public.testidentity_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1
);

ALTER TABLE public.teststorage
	ALTER COLUMN c1 TYPE integer USING c1::integer; /* TYPE change - table: public.teststorage original: text new: integer */

ALTER TABLE ONLY public.teststorage
	ALTER COLUMN c1 SET STORAGE EXTERNAL;

ALTER TABLE public.teststorage
	ALTER COLUMN c11 TYPE text USING c11::text; /* TYPE change - table: public.teststorage original: bigint new: text */

ALTER TABLE public.comment_test
	ALTER COLUMN id TYPE bigint USING id::bigint; /* TYPE change - table: public.comment_test original: integer new: bigint */

COMMENT ON COLUMN public.comment_test.id IS 'new comment';

ALTER TABLE public.comment_test
	ALTER COLUMN text TYPE character varying(21) USING text::character varying(21); /* TYPE change - table: public.comment_test original: character varying(20) new: character varying(21) */

ALTER TABLE public.test_options
	ALTER COLUMN field1 TYPE character(60) USING field1::character(60); /* TYPE change - table: public.test_options original: character(64) new: character(60) */

ALTER TABLE ONLY public.test_options ALTER COLUMN field1 SET (n_distinct=4);

ALTER TABLE public.test_options
	ALTER COLUMN field2 TYPE character(60) USING field2::character(60), /* TYPE change - table: public.test_options original: character(64) new: character(60) */
	ALTER COLUMN field3 TYPE character(60) USING field3::character(60); /* TYPE change - table: public.test_options original: character(64) new: character(60) */

ALTER TABLE public.test_statistics
	ALTER COLUMN field1 TYPE bigint USING field1::bigint; /* TYPE change - table: public.test_statistics original: integer new: bigint */

ALTER TABLE public.test_statistics
	ALTER COLUMN field2 TYPE bigint USING field2::bigint; /* TYPE change - table: public.test_statistics original: integer new: bigint */

ALTER TABLE ONLY public.test_statistics
	ALTER COLUMN field2 SET STATISTICS 40;

ALTER TABLE public.testseq
	ALTER COLUMN id TYPE bigint USING id::bigint; /* TYPE change - table: public.testseq original: integer new: bigint */

ALTER SEQUENCE public.custom_named_seq
	AS bigint
	START WITH 2;

ALTER TABLE public.testseq
	ALTER COLUMN field1 TYPE character(60) USING field1::character(60); /* TYPE change - table: public.testseq original: character(64) new: character(60) */

ALTER TABLE public.test_null
	ALTER COLUMN field3 TYPE double precision USING field3::double precision; /* TYPE change - table: public.test_null original: integer new: double precision */

ALTER TABLE ONLY public.test_null
	ALTER COLUMN field3 DROP NOT NULL;

ALTER TABLE public.test_null
	ALTER COLUMN field4 TYPE numeric(30,6) USING field4::numeric(30,6); /* TYPE change - table: public.test_null original: double precision new: numeric(30,6) */

ALTER TABLE public.testcollation
	ALTER COLUMN id TYPE bigint COLLATE "en_US" USING id::bigint, /* TYPE change - table: public.testcollation original: integer new: bigint */
	ALTER COLUMN field1 TYPE bigint USING field1::bigint; /* TYPE change - table: public.testcollation original: integer new: bigint */

CREATE INDEX i7_1 ON public.t_lot_prod_3 USING btree (text COLLATE public.test_collation7);

ALTER TABLE public.t_lot_prod_3
	ADD CONSTRAINT id_1 CHECK ((id > 4));