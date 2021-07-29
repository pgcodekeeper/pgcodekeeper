-- handler
CREATE FOREIGN DATA WRAPPER test_fdw_1
     HANDLER handler_function_0;

-- validator
CREATE FOREIGN DATA WRAPPER test_fdw_2
     VALIDATOR fdw_test_validator;

--options
CREATE FOREIGN DATA WRAPPER test_fdw_0;

CREATE FOREIGN DATA WRAPPER test_fdw_3 OPTIONS (host 'foo', dbname 'foodb');

--OWNER--
CREATE FOREIGN DATA WRAPPER test_fdw_4;
ALTER FOREIGN DATA WRAPPER test_fdw_4 OWNER TO user1;
