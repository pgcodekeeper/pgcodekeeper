SELECT n.oid,
       n.nspname,
       n.nspacl,
       n.nspowner,
       d.description AS comment
FROM pg_catalog.pg_namespace n
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
WHERE n.nspname NOT LIKE 'pg\_%'
    AND n.nspname != 'information_schema'
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')