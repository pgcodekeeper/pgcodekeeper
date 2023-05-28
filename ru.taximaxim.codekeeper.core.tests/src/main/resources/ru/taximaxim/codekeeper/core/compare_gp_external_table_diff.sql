SET search_path = pg_catalog;

DROP EXTERNAL TABLE public.test_1;

DROP EXTERNAL TABLE public.test_2;

DROP EXTERNAL TABLE public.test_3;

DROP EXTERNAL TABLE public.test_4;

CREATE WRITABLE EXTERNAL WEB TABLE public.test_1 (
	id integer,
	name text,
	sponsor text
)
EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON ALL
FORMAT 'TEXT' ( delimiter '|' )
ENCODING 'UTF8'
DISTRIBUTED BY (id);

CREATE WRITABLE EXTERNAL WEB TABLE public.test_2 (
	id integer,
	name text,
	sponsor text
)
EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON ALL
FORMAT 'TEXT';

CREATE WRITABLE EXTERNAL WEB TABLE public.test_3 (
	id integer,
	name text,
	sponsor text
)
EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON ALL
FORMAT 'CSV';

CREATE WRITABLE EXTERNAL WEB TABLE public.test_4 (
	id integer,
	name text,
	sponsor text
)
EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON ALL
FORMAT 'TEXT'
OPTIONS (
    error_log_persistent 'false'
);