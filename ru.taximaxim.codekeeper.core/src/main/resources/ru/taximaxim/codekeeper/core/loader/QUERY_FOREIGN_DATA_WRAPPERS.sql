WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE dep.classid = 'pg_catalog.pg_foreign_data_wrapper'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT fdw.oid::bigint,
       fdw.fdwname,
       fdw.fdwhandler::pg_catalog.regproc,
       fdw.fdwvalidator::pg_catalog.regproc,
       fdw.fdwoptions,
       fdw.fdwacl,
       fdw.fdwowner, 
       d.description
FROM pg_catalog.pg_foreign_data_wrapper fdw
LEFT JOIN pg_catalog.pg_description d ON fdw.oid = d.objoid
    AND d.classoid = 'pg_catalog.pg_foreign_data_wrapper'::pg_catalog.regclass
WHERE fdw.oid NOT IN (SELECT objid FROM extension_deps)