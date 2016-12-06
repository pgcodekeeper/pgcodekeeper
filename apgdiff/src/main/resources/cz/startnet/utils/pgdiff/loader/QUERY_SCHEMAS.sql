SELECT n.oid,
       n.nspname,
       n.nspacl,
       n.nspowner,
       d.description AS comment
FROM pg_catalog.pg_namespace n
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
WHERE n.nspname NOT LIKE 'pg\_%'
    AND n.nspname != 'information_schema'