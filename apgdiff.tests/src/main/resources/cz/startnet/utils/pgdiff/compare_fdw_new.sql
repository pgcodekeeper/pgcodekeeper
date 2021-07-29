-- handler
CREATE FOREIGN DATA WRAPPER test_fdw_1
     HANDLER handler_function_1;
     
-- validator
CREATE FOREIGN DATA WRAPPER test_fdw_2
     VALIDATOR fdw_test_validator_1;

--options
CREATE FOREIGN DATA WRAPPER test_fdw_0 OPTIONS (debug 'true');

CREATE FOREIGN DATA WRAPPER test_fdw_3 OPTIONS (dbname 'newdb', port '5432');

--OWNER--
CREATE FOREIGN DATA WRAPPER test_fdw_4;
ALTER FOREIGN DATA WRAPPER test_fdw_4 OWNER TO khazieva_gr;
