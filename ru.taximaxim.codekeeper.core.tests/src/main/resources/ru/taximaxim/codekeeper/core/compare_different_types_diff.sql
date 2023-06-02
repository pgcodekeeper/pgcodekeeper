SET search_path = pg_catalog;

DROP TYPE public.test_type;

CREATE TYPE public.test_type AS ENUM (
	'first',
	'second',
	'third'
);

ALTER TYPE public.test_type OWNER TO shamsutdinov_er;
