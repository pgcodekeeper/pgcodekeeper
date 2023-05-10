CREATE FOREIGN DATA WRAPPER mywrapper1 OPTIONS (
    mpp_execute 'any',
    debug 'true'
);

CREATE FOREIGN DATA WRAPPER mywrapper2 OPTIONS (
    debug 'true'
);

CREATE FOREIGN DATA WRAPPER mywrapper3 OPTIONS (
    mpp_execute 'master',
    debug 'true'
);
