SELECT n.oid::bigint,
       n.nspname,
       n.nspacl,
       r.rolname AS owner,
       d.description AS comment
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE 'pg\_%'
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid