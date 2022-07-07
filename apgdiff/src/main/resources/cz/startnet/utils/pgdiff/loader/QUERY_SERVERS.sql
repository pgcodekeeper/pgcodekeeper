WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE dep.classid = 'pg_catalog.pg_foreign_server'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT srv.oid::bigint,
       srv.srvname,
       srv.srvtype,
       srv.srvversion,
       srv.srvacl,
       srv.srvoptions,
       srv.srvowner,
       d.description,
       fdw.fdwname
FROM pg_catalog.pg_foreign_server srv
LEFT JOIN pg_catalog.pg_foreign_data_wrapper fdw ON srv.srvfdw = fdw.oid
LEFT JOIN pg_catalog.pg_description d ON srv.oid = d.objoid
    AND d.classoid = 'pg_catalog.pg_foreign_server'::pg_catalog.regclass
WHERE srv.oid NOT IN (SELECT objid FROM extension_deps)
