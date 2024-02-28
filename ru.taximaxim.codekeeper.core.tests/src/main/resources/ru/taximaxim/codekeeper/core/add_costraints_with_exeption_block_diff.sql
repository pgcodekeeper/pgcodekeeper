SET search_path = pg_catalog;

CREATE TABLE public.temp_test_1 (
	id integer,
	column1 integer
);

CREATE TABLE public.temp_test (
	id integer NOT NULL,
	column1 integer
);

CREATE TABLE public.partitioned (
	a integer
)
PARTITION BY RANGE (a);

CREATE TABLE public.t11 (
	a circle,
	b circle
);

CREATE TABLE public.testtable (
	c1 integer,
	c2 integer,
	c3 text
);

DO $$
BEGIN
	ALTER TABLE public.temp_test
		ADD CONSTRAINT temp_test_pkey PRIMARY KEY (id);
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42P16') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';

DO $$
BEGIN
	ALTER TABLE public.temp_test
		ADD CONSTRAINT fk_test FOREIGN KEY (column1) REFERENCES public.temp_test_fk(id) DEFERRABLE;
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42710') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';

DO $$
BEGIN
	ALTER TABLE public.partitioned
		ADD CONSTRAINT check_a CHECK (a > 0);
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42710') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';

DO $$
BEGIN
	ALTER TABLE public.t11
		ADD CONSTRAINT c1 EXCLUDE USING gist (a WITH &&, b WITH &&);
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42P07') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';

DO $$
BEGIN
	ALTER TABLE public.testtable
		ADD CONSTRAINT pk_testtable PRIMARY KEY (c1);
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42P16') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';

DO $$
BEGIN
	ALTER TABLE public.testtable
		ADD CONSTRAINT un_testtable UNIQUE (c3);
EXCEPTION WHEN OTHERS THEN
	IF (SQLSTATE = '42P07') THEN
		RAISE NOTICE '%, skip', SQLERRM;
	ELSE
		RAISE;
	END IF;
END; $$
LANGUAGE 'plpgsql';
