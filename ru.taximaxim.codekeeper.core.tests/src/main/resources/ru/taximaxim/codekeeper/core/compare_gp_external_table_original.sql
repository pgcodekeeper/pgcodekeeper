CREATE WRITABLE EXTERNAL WEB TABLE public.test_1 
(id int, name text, sponsor text) 
 EXECUTE '/var/unload_scripts/to_adreport_etl.sh'
 FORMAT 'TEXT' (DELIMITER '|')
 ENCODING 'UTF8'
 DISTRIBUTED RANDOMLY;

CREATE WRITABLE EXTERNAL WEB TABLE public.test_2 
(id int, name text, sponsor text) 
 EXECUTE '/var/unload_scripts/to_adreport_etl.sh' ON MASTER
 FORMAT 'TEXT';

CREATE WRITABLE EXTERNAL WEB TABLE public.test_3 
(id int, name text, sponsor text) 
 EXECUTE '/var/unload_scripts/to_adreport_etl.sh'
 FORMAT 'TEXT';

CREATE WRITABLE EXTERNAL WEB TABLE public.test_4 
(id int, name text, sponsor text) 
 EXECUTE '/var/unload_scripts/to_adreport_etl.sh'
 FORMAT 'TEXT'
 OPTIONS (error_log_persistent 'true');