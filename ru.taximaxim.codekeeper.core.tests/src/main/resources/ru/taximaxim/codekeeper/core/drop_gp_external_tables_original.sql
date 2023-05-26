CREATE EXTERNAL TABLE public.ext_customer
   (id int, name text, sponsor text) 
   LOCATION ( 'gpfdist://filehost:8081/*.txt' ) 
   FORMAT 'TEXT' ( DELIMITER '|' NULL ' ')
   ENCODING 'UTF8'
   LOG ERRORS SEGMENT REJECT LIMIT 5;