SET search_path = pg_catalog;

ALTER FOREIGN DATA WRAPPER mywrapper1 OPTIONS (SET mpp_execute 'any');

ALTER FOREIGN DATA WRAPPER mywrapper2 OPTIONS (DROP mpp_execute );

ALTER FOREIGN DATA WRAPPER mywrapper3 OPTIONS (ADD mpp_execute 'master');