SELECT e.oid::bigint, 
       e.extname,
    (SELECT n.nspname
     FROM pg_catalog.pg_namespace n
     WHERE e.extnamespace = n.oid) namespace,
    d.description
FROM pg_catalog.pg_extension e
LEFT JOIN pg_catalog.pg_description d ON e.oid = d.objoid