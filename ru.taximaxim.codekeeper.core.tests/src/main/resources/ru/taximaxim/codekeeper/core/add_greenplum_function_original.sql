CREATE OR REPLACE FUNCTION public.test_func(integer, OUT f1 integer, OUT f2 text) RETURNS record
    LANGUAGE sql EXECUTE ON ANY CONTAINS SQL
    AS $$ SELECT $1, CAST($1 AS text) || ' is text' $$ WITH (DESCRIBE = describe_func);
    
CREATE OR REPLACE FUNCTION public.test_func1(integer, OUT f1 integer, OUT f2 text) RETURNS record
    LANGUAGE sql
    AS $$ SELECT $1, CAST($1 AS text) || ' is text' $$ WITH (DESCRIBE = describe_func);
    
CREATE OR REPLACE FUNCTION public.test_func2(integer, OUT f1 integer, OUT f2 text) RETURNS record
    LANGUAGE sql EXECUTE ON MASTER
    AS $$ SELECT $1, CAST($1 AS text) || ' is text' $$ WITH (DESCRIBE = describe_func);
