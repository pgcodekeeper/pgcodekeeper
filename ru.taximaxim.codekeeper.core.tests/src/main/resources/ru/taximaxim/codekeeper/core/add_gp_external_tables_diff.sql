SET search_path = pg_catalog;

CREATE EXTERNAL TABLE public.ext_customer (
	id integer,
	name text,
	sponsor text
)
LOCATION (
'gpfdist://filehost:8081/*.txt'
)
FORMAT 'TEXT' ( delimiter '|' null ' ' )
OPTIONS (
    error_log_persistent 'true'
)
ENCODING 'UTF8'
LOG ERRORS SEGMENT REJECT LIMIT 5 ROWS;

CREATE EXTERNAL TABLE public.ext_expenses (
	name text,
	date date,
	amount real,
	category text,
	description text
)
LOCATION (
'file://seghost1/dbfast/external/expenses1.csv',
'file://seghost1/dbfast/external/expenses2.csv',
'file://seghost2/dbfast/external/expenses3.csv',
'file://seghost2/dbfast/external/expenses4.csv',
'file://seghost3/dbfast/external/expenses5.csv',
'file://seghost3/dbfast/external/expenses6.csv'
)
FORMAT 'CSV' ( header );

CREATE EXTERNAL WEB TABLE public.log_output (
	linenum integer,
	message text
)
EXECUTE '/var/load_scripts/get_log_data.sh' ON HOST
FORMAT 'TEXT' ( delimiter '|' )
ENCODING 'UTF8'
SEGMENT REJECT LIMIT 5 PERCENT;

CREATE WRITABLE EXTERNAL TABLE public.sales_out (
	id integer,
	name text,
	sponsor text
)
LOCATION (
'gpfdist://etl1:8081/sales.out'
)
FORMAT 'TEXT' ( delimiter '|' null ' ' )
ENCODING 'UTF8'
DISTRIBUTED BY (id);

CREATE WRITABLE EXTERNAL WEB TABLE public.campaign_out (
	id integer,
	name text,
	sponsor text
)
EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON ALL
FORMAT 'TEXT' ( delimiter '|' )
ENCODING 'UTF8'
DISTRIBUTED RANDOMLY;